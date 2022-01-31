import android.os.Handler;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudFileUploadCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.ARCloudControlCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudImageSelect;
import com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult.ImageTag;
import com.tencent.mobileqq.ar.arengine.ARCloudObjectClassifyResult;
import com.tencent.mobileqq.ar.arengine.ARCloudPreOcrResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudSceneRecogResult;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aaap
  implements ARCloudFileUpload.ARCloudFileUploadCallback
{
  public aaap(ARCloudControl paramARCloudControl, long paramLong, ARCloudReqInfo paramARCloudReqInfo) {}
  
  public void a(int paramInt, String paramString, ARCloudRecogResult paramARCloudRecogResult)
  {
    ARCloudControl.c(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl, false);
    if (ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
        if ((paramARCloudRecogResult == null) || (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult == null)) {
          continue;
        }
        i = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.c;
        ((ARCloudControl)localObject).i = i;
        ARCloudControl localARCloudControl = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
        if ((paramARCloudRecogResult == null) || (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult == null) || (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.a == null) || (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.a.length <= 0)) {
          continue;
        }
        localObject = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.a[0].jdField_a_of_type_JavaLangString;
        localARCloudControl.jdField_a_of_type_JavaLangString = ((String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        long l1;
        long l2;
        boolean bool2;
        boolean bool1;
        QLog.i("AREngine_ARCloudControl", 1, "  mCloudTime  mImageId " + localException.getMessage());
        continue;
        int i = 0;
        continue;
        QLog.i("AREngine_ARCloudControl", 1, "MIGObjectClaasify not need  run requestToCheckLBSLocation.");
        ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl).a(paramInt, paramARCloudRecogResult);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.c != 0L) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.c);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.d != 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
        ((ARCloudControl)localObject).g += System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.d;
      }
      if (ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl) != null) {
        ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl) == null) {
        break;
      }
      if ((paramInt == 0) && (paramARCloudRecogResult != null) && ((ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult)) || (ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult)) || (ARMIGObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult)) || (ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult)) || (ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult))))
      {
        QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_j_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_j_of_type_Int = 0;
      }
      if ((paramARCloudRecogResult != null) && (ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult))) {
        paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult.b = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramARCloudRecogResult != null) && (ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult))) {
        paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult.b = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramARCloudRecogResult != null) && (ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult))) {
        paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult.b = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.jdField_a_of_type_JavaLangString;
      }
      if (!ARCloudControl.c(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramInt == 0)
        {
          bool1 = bool2;
          if (paramARCloudRecogResult != null) {
            if ((!ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult)) && (!ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult)) && (!ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult)) && (!ARCloudPreOcrResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult)))
            {
              bool1 = bool2;
              if (!ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        l1 = ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl).b();
        ScanEntranceReport.a().a(bool1, l1);
        ARCloudControl.d(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl, true);
      }
      if ((!ARCloudControl.d(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl)) && (paramInt == 0) && (paramARCloudRecogResult != null) && ((ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult)) || (ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult)) || (ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult)) || (ARCloudPreOcrResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult)) || (ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult))))
      {
        l1 = ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl).b();
        ScanEntranceReport.a().a(l1, this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.c);
        ARCloudControl.e(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl, true);
      }
      if (ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl) != null) {
        ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl).add(paramString);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_j_of_type_Int != 0) || (!ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult))) {
        break label932;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.switchLBSLocation != 1) {
        break label917;
      }
      if ((paramARCloudRecogResult.jdField_a_of_type_Long == 128L) && ((paramARCloudRecogResult.jdField_a_of_type_Long != 128L) || (!ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl).a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult)))) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
      ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl, paramInt, paramARCloudRecogResult);
      return;
      i = 0;
      continue;
      localObject = "";
    }
    label917:
    ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl).a(2, null);
    return;
    label932:
    ARCloudControl.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl).a(paramInt, paramARCloudRecogResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaap
 * JD-Core Version:    0.7.0.1
 */