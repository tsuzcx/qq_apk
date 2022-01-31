import Wallet.DownloadReportReq;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

public class aiwd
  extends bdvu
{
  private boolean jdField_a_of_type_Boolean;
  
  public aiwd(PreloadResource paramPreloadResource, int paramInt, WeakReference paramWeakReference, bdvu parambdvu, long paramLong) {}
  
  public void onDoneFile(bdvv parambdvv)
  {
    Object localObject = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a((PreloadManager)localObject)) {
      ((PreloadManager)localObject).c();
    }
    if (this.jdField_a_of_type_Bdvu != null) {
      this.jdField_a_of_type_Bdvu.onDoneFile(parambdvv);
    }
    localObject = new DownloadReportReq();
    int i;
    File localFile;
    long l;
    if (parambdvv.jdField_a_of_type_Int == 0)
    {
      ((DownloadReportReq)localObject).iType = 1;
      int j = -1;
      i = j;
      if (parambdvv.jdField_a_of_type_JavaUtilMap != null)
      {
        i = j;
        if (!TextUtils.isEmpty(parambdvv.jdField_a_of_type_JavaLangString))
        {
          localFile = (File)parambdvv.jdField_a_of_type_JavaUtilMap.get(parambdvv.jdField_a_of_type_JavaLangString);
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
        ((DownloadReportReq)localObject).sPhoneType = bdcb.i();
        ((DownloadReportReq)localObject).sOsVersion = bdcb.e();
        ((DownloadReportReq)localObject).sQQVersion = bdcb.c();
        ((DownloadReportReq)localObject).iScene = parambdvv.a().getInt("scene");
        aiqs.a((JceStruct)localObject, null);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down result:" + parambdvv.jdField_a_of_type_Int + localObject);
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
  
  public void onProgress(bdvv parambdvv)
  {
    double d;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      long l1 = System.currentTimeMillis();
      long l2 = parambdvv.g;
      d = parambdvv.f / (l1 - l2);
      if (d >= 1.0D) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      parambdvv = new DownloadReportReq();
      parambdvv.sSpeed = (d + "");
      parambdvv.vecResInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.getMyResInfos();
      parambdvv.iType = 0;
      parambdvv.iUin = this.jdField_a_of_type_Long;
      aiqs.a(parambdvv, null);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down speed:" + d);
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    int i = 3;
    parambdvv.f = 1048576L;
    if (this.jdField_a_of_type_Int > 3) {
      i = this.jdField_a_of_type_Int;
    }
    parambdvv.b = i;
    return super.onStart(parambdvv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwd
 * JD-Core Version:    0.7.0.1
 */