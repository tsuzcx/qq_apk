import Wallet.DownloadReportReq;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

public class akbq
  extends bgod
{
  private boolean jdField_a_of_type_Boolean;
  
  public akbq(PreloadResource paramPreloadResource, int paramInt, WeakReference paramWeakReference, bgod parambgod, long paramLong) {}
  
  public void onDoneFile(bgoe parambgoe)
  {
    Object localObject = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a((PreloadManager)localObject)) {
      ((PreloadManager)localObject).c();
    }
    if (this.jdField_a_of_type_Bgod != null) {
      this.jdField_a_of_type_Bgod.onDoneFile(parambgoe);
    }
    localObject = new DownloadReportReq();
    int i;
    File localFile;
    long l;
    if (parambgoe.jdField_a_of_type_Int == 0)
    {
      ((DownloadReportReq)localObject).iType = 1;
      int j = -1;
      i = j;
      if (parambgoe.jdField_a_of_type_JavaUtilMap != null)
      {
        i = j;
        if (!TextUtils.isEmpty(parambgoe.jdField_a_of_type_JavaLangString))
        {
          localFile = (File)parambgoe.jdField_a_of_type_JavaUtilMap.get(parambgoe.jdField_a_of_type_JavaLangString);
          if (localFile != null) {
            break label242;
          }
          l = -2L;
          label113:
          i = (int)l;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((DownloadReportReq)localObject).vecResInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.getMyResInfos(i);
        ((DownloadReportReq)localObject).iUin = this.jdField_a_of_type_Long;
        ((DownloadReportReq)localObject).sPhoneType = DeviceInfoUtil.getModel();
        ((DownloadReportReq)localObject).sOsVersion = DeviceInfoUtil.getDeviceOSVersion();
        ((DownloadReportReq)localObject).sQQVersion = DeviceInfoUtil.getQQVersion();
        ((DownloadReportReq)localObject).iScene = parambgoe.a().getInt("scene");
        ajvh.a((JceStruct)localObject, null);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down result:" + parambgoe.jdField_a_of_type_Int + localObject);
        }
        return;
        ((DownloadReportReq)localObject).iType = 2;
        break;
        try
        {
          label242:
          if (localFile.exists())
          {
            l = localFile.length();
            break label113;
          }
          l = -3L;
        }
        catch (Throwable localThrowable)
        {
          i = -4;
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void onProgress(bgoe parambgoe)
  {
    double d;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      long l1 = System.currentTimeMillis();
      long l2 = parambgoe.g;
      d = parambgoe.f / (l1 - l2);
      if (d >= 1.0D) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      parambgoe = new DownloadReportReq();
      parambgoe.sSpeed = (d + "");
      parambgoe.vecResInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.getMyResInfos();
      parambgoe.iType = 0;
      parambgoe.iUin = this.jdField_a_of_type_Long;
      ajvh.a(parambgoe, null);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down speed:" + d);
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    int i = 3;
    parambgoe.f = 1048576L;
    if (this.jdField_a_of_type_Int > 3) {
      i = this.jdField_a_of_type_Int;
    }
    parambgoe.b = i;
    return super.onStart(parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbq
 * JD-Core Version:    0.7.0.1
 */