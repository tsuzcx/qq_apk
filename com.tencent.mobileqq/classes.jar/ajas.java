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

public class ajas
  extends bead
{
  private boolean jdField_a_of_type_Boolean;
  
  public ajas(PreloadResource paramPreloadResource, int paramInt, WeakReference paramWeakReference, bead parambead, long paramLong) {}
  
  public void onDoneFile(beae parambeae)
  {
    Object localObject = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a((PreloadManager)localObject)) {
      ((PreloadManager)localObject).c();
    }
    if (this.jdField_a_of_type_Bead != null) {
      this.jdField_a_of_type_Bead.onDoneFile(parambeae);
    }
    localObject = new DownloadReportReq();
    int i;
    File localFile;
    long l;
    if (parambeae.jdField_a_of_type_Int == 0)
    {
      ((DownloadReportReq)localObject).iType = 1;
      int j = -1;
      i = j;
      if (parambeae.jdField_a_of_type_JavaUtilMap != null)
      {
        i = j;
        if (!TextUtils.isEmpty(parambeae.jdField_a_of_type_JavaLangString))
        {
          localFile = (File)parambeae.jdField_a_of_type_JavaUtilMap.get(parambeae.jdField_a_of_type_JavaLangString);
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
        ((DownloadReportReq)localObject).sPhoneType = bdgk.i();
        ((DownloadReportReq)localObject).sOsVersion = bdgk.e();
        ((DownloadReportReq)localObject).sQQVersion = bdgk.c();
        ((DownloadReportReq)localObject).iScene = parambeae.a().getInt("scene");
        aivh.a((JceStruct)localObject, null);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down result:" + parambeae.jdField_a_of_type_Int + localObject);
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
  
  public void onProgress(beae parambeae)
  {
    double d;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      long l1 = System.currentTimeMillis();
      long l2 = parambeae.g;
      d = parambeae.f / (l1 - l2);
      if (d >= 1.0D) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      parambeae = new DownloadReportReq();
      parambeae.sSpeed = (d + "");
      parambeae.vecResInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.getMyResInfos();
      parambeae.iType = 0;
      parambeae.iUin = this.jdField_a_of_type_Long;
      aivh.a(parambeae, null);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down speed:" + d);
  }
  
  public boolean onStart(beae parambeae)
  {
    int i = 3;
    parambeae.f = 1048576L;
    if (this.jdField_a_of_type_Int > 3) {
      i = this.jdField_a_of_type_Int;
    }
    parambeae.b = i;
    return super.onStart(parambeae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajas
 * JD-Core Version:    0.7.0.1
 */