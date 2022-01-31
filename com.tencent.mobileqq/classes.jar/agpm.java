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

public class agpm
  extends batl
{
  private boolean jdField_a_of_type_Boolean;
  
  public agpm(PreloadResource paramPreloadResource, int paramInt, WeakReference paramWeakReference, batl parambatl, long paramLong) {}
  
  public void onDoneFile(batm parambatm)
  {
    Object localObject = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a((PreloadManager)localObject)) {
      ((PreloadManager)localObject).c();
    }
    if (this.jdField_a_of_type_Batl != null) {
      this.jdField_a_of_type_Batl.onDoneFile(parambatm);
    }
    localObject = new DownloadReportReq();
    int i;
    File localFile;
    long l;
    if (parambatm.jdField_a_of_type_Int == 0)
    {
      ((DownloadReportReq)localObject).iType = 1;
      int j = -1;
      i = j;
      if (parambatm.jdField_a_of_type_JavaUtilMap != null)
      {
        i = j;
        if (!TextUtils.isEmpty(parambatm.jdField_a_of_type_JavaLangString))
        {
          localFile = (File)parambatm.jdField_a_of_type_JavaUtilMap.get(parambatm.jdField_a_of_type_JavaLangString);
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
        ((DownloadReportReq)localObject).sPhoneType = babp.i();
        ((DownloadReportReq)localObject).sOsVersion = babp.e();
        ((DownloadReportReq)localObject).sQQVersion = babp.c();
        ((DownloadReportReq)localObject).iScene = parambatm.a().getInt("scene");
        agkg.a((JceStruct)localObject, null);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down result:" + parambatm.jdField_a_of_type_Int + localObject);
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
  
  public void onProgress(batm parambatm)
  {
    double d;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      long l1 = System.currentTimeMillis();
      long l2 = parambatm.g;
      d = parambatm.f / (l1 - l2);
      if (d >= 1.0D) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      parambatm = new DownloadReportReq();
      parambatm.sSpeed = (d + "");
      parambatm.vecResInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.getMyResInfos();
      parambatm.iType = 0;
      parambatm.iUin = this.jdField_a_of_type_Long;
      agkg.a(parambatm, null);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down speed:" + d);
  }
  
  public boolean onStart(batm parambatm)
  {
    int i = 3;
    parambatm.f = 1048576L;
    if (this.jdField_a_of_type_Int > 3) {
      i = this.jdField_a_of_type_Int;
    }
    parambatm.b = i;
    return super.onStart(parambatm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agpm
 * JD-Core Version:    0.7.0.1
 */