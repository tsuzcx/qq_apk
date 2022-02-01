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

public class akxj
  extends bhyn
{
  private boolean jdField_a_of_type_Boolean;
  
  public akxj(PreloadResource paramPreloadResource, int paramInt, WeakReference paramWeakReference, bhyn parambhyn, long paramLong) {}
  
  public void onDoneFile(bhyo parambhyo)
  {
    Object localObject = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a((PreloadManager)localObject)) {
      ((PreloadManager)localObject).c();
    }
    if (this.jdField_a_of_type_Bhyn != null) {
      this.jdField_a_of_type_Bhyn.onDoneFile(parambhyo);
    }
    localObject = new DownloadReportReq();
    int i;
    File localFile;
    long l;
    if (parambhyo.jdField_a_of_type_Int == 0)
    {
      ((DownloadReportReq)localObject).iType = 1;
      int j = -1;
      i = j;
      if (parambhyo.jdField_a_of_type_JavaUtilMap != null)
      {
        i = j;
        if (!TextUtils.isEmpty(parambhyo.jdField_a_of_type_JavaLangString))
        {
          localFile = (File)parambhyo.jdField_a_of_type_JavaUtilMap.get(parambhyo.jdField_a_of_type_JavaLangString);
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
        ((DownloadReportReq)localObject).iScene = parambhyo.a().getInt("scene");
        akra.a((JceStruct)localObject, null);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down result:" + parambhyo.jdField_a_of_type_Int + localObject);
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
  
  public void onProgress(bhyo parambhyo)
  {
    double d;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      long l1 = System.currentTimeMillis();
      long l2 = parambhyo.g;
      d = parambhyo.f / (l1 - l2);
      if (d >= 1.0D) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      parambhyo = new DownloadReportReq();
      parambhyo.sSpeed = (d + "");
      parambhyo.vecResInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.getMyResInfos();
      parambhyo.iType = 0;
      parambhyo.iUin = this.jdField_a_of_type_Long;
      akra.a(parambhyo, null);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down speed:" + d);
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    int i = 3;
    parambhyo.f = 1048576L;
    if (this.jdField_a_of_type_Int > 3) {
      i = this.jdField_a_of_type_Int;
    }
    parambhyo.b = i;
    return super.onStart(parambhyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxj
 * JD-Core Version:    0.7.0.1
 */