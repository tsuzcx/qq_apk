import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class alfq
  implements alew
{
  alfq(alfn paramalfn, long paramLong, algs paramalgs) {}
  
  public void a(int paramInt, String paramString, algn paramalgn)
  {
    alfn.c(this.jdField_a_of_type_Alfn, false);
    if (alfn.a(this.jdField_a_of_type_Alfn)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_Alfn;
        if ((paramalgn == null) || (paramalgn.jdField_a_of_type_Alfy == null)) {
          continue;
        }
        i = paramalgn.jdField_a_of_type_Alfy.c;
        ((alfn)localObject).i = i;
        alfn localalfn = this.jdField_a_of_type_Alfn;
        if ((paramalgn == null) || (paramalgn.jdField_a_of_type_Alfy == null) || (paramalgn.jdField_a_of_type_Alfy.a == null) || (paramalgn.jdField_a_of_type_Alfy.a.length <= 0)) {
          continue;
        }
        localObject = paramalgn.jdField_a_of_type_Alfy.a[0].jdField_a_of_type_JavaLangString;
        localalfn.jdField_a_of_type_JavaLangString = ((String)localObject);
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
        alfn.a(this.jdField_a_of_type_Alfn).a(paramInt, paramalgn);
        return;
      }
      if (this.jdField_a_of_type_Alfn.c != 0L) {
        this.jdField_a_of_type_Alfn.jdField_j_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Alfn.c);
      }
      if (this.jdField_a_of_type_Alfn.d != 0L)
      {
        localObject = this.jdField_a_of_type_Alfn;
        ((alfn)localObject).g += System.currentTimeMillis() - this.jdField_a_of_type_Alfn.d;
      }
      if (alfn.a(this.jdField_a_of_type_Alfn) != null) {
        alfn.a(this.jdField_a_of_type_Alfn).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (alfn.a(this.jdField_a_of_type_Alfn) == null) {
        break;
      }
      if ((paramInt == 0) && (paramalgn != null) && ((alfy.a(paramalgn.jdField_a_of_type_Alfy)) || (algd.a(paramalgn.jdField_a_of_type_Algd)) || (alhu.a(paramalgn.jdField_a_of_type_Alhu)) || (algp.a(paramalgn.jdField_a_of_type_Algp)) || (algv.a(paramalgn.jdField_a_of_type_Algv))))
      {
        QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.jdField_a_of_type_Alfn.jdField_j_of_type_Int);
        this.jdField_a_of_type_Alfn.jdField_j_of_type_Int = 0;
      }
      if ((paramalgn != null) && (alfy.a(paramalgn.jdField_a_of_type_Alfy))) {
        paramalgn.jdField_a_of_type_Alfy.b = this.jdField_a_of_type_Algs.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramalgn != null) && (algd.a(paramalgn.jdField_a_of_type_Algd))) {
        paramalgn.jdField_a_of_type_Algd.b = this.jdField_a_of_type_Algs.a.jdField_a_of_type_JavaLangString;
      }
      if ((paramalgn != null) && (algv.a(paramalgn.jdField_a_of_type_Algv))) {
        paramalgn.jdField_a_of_type_Algv.b = this.jdField_a_of_type_Algs.a.jdField_a_of_type_JavaLangString;
      }
      if (!alfn.c(this.jdField_a_of_type_Alfn))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramInt == 0)
        {
          bool1 = bool2;
          if (paramalgn != null) {
            if ((!alfy.a(paramalgn.jdField_a_of_type_Alfy)) && (!algd.a(paramalgn.jdField_a_of_type_Algd)) && (!algp.a(paramalgn.jdField_a_of_type_Algp)) && (!algf.a(paramalgn.jdField_a_of_type_Algf)))
            {
              bool1 = bool2;
              if (!algv.a(paramalgn.jdField_a_of_type_Algv)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        l1 = alfn.a(this.jdField_a_of_type_Alfn).b();
        aldn.a().a(bool1, l1);
        alfn.d(this.jdField_a_of_type_Alfn, true);
      }
      if ((!alfn.d(this.jdField_a_of_type_Alfn)) && (paramInt == 0) && (paramalgn != null) && ((alfy.a(paramalgn.jdField_a_of_type_Alfy)) || (algd.a(paramalgn.jdField_a_of_type_Algd)) || (algp.a(paramalgn.jdField_a_of_type_Algp)) || (algf.a(paramalgn.jdField_a_of_type_Algf)) || (algv.a(paramalgn.jdField_a_of_type_Algv))))
      {
        l1 = alfn.a(this.jdField_a_of_type_Alfn).b();
        aldn.a().a(l1, this.jdField_a_of_type_Alfn.jdField_a_of_type_Alfu.c);
        alfn.e(this.jdField_a_of_type_Alfn, true);
      }
      if (alfn.a(this.jdField_a_of_type_Alfn) != null) {
        alfn.a(this.jdField_a_of_type_Alfn).add(paramString);
      }
      if ((this.jdField_a_of_type_Alfn.jdField_j_of_type_Int != 0) || (!algn.a(this.jdField_a_of_type_Alfn.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramalgn))) {
        break label932;
      }
      if (this.jdField_a_of_type_Alfn.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.switchLBSLocation != 1) {
        break label917;
      }
      if ((paramalgn.jdField_a_of_type_Long == 128L) && ((paramalgn.jdField_a_of_type_Long != 128L) || (!alfn.a(this.jdField_a_of_type_Alfn).a(paramalgn.jdField_a_of_type_Alhu)))) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
      alfn.a(this.jdField_a_of_type_Alfn, paramInt, paramalgn);
      return;
      i = 0;
      continue;
      localObject = "";
    }
    label917:
    alfn.a(this.jdField_a_of_type_Alfn).a(2, null);
    return;
    label932:
    alfn.a(this.jdField_a_of_type_Alfn).a(paramInt, paramalgn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alfq
 * JD-Core Version:    0.7.0.1
 */