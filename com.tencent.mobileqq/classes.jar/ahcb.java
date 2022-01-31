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

public class ahcb
  extends bbwf
{
  private boolean jdField_a_of_type_Boolean;
  
  public ahcb(PreloadResource paramPreloadResource, int paramInt, WeakReference paramWeakReference, bbwf parambbwf, long paramLong) {}
  
  public void onDoneFile(bbwg parambbwg)
  {
    Object localObject = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a((PreloadManager)localObject)) {
      ((PreloadManager)localObject).c();
    }
    if (this.jdField_a_of_type_Bbwf != null) {
      this.jdField_a_of_type_Bbwf.onDoneFile(parambbwg);
    }
    localObject = new DownloadReportReq();
    int i;
    File localFile;
    long l;
    if (parambbwg.jdField_a_of_type_Int == 0)
    {
      ((DownloadReportReq)localObject).iType = 1;
      int j = -1;
      i = j;
      if (parambbwg.jdField_a_of_type_JavaUtilMap != null)
      {
        i = j;
        if (!TextUtils.isEmpty(parambbwg.jdField_a_of_type_JavaLangString))
        {
          localFile = (File)parambbwg.jdField_a_of_type_JavaUtilMap.get(parambbwg.jdField_a_of_type_JavaLangString);
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
        ((DownloadReportReq)localObject).sPhoneType = bbct.i();
        ((DownloadReportReq)localObject).sOsVersion = bbct.e();
        ((DownloadReportReq)localObject).sQQVersion = bbct.c();
        ((DownloadReportReq)localObject).iScene = parambbwg.a().getInt("scene");
        agwv.a((JceStruct)localObject, null);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down result:" + parambbwg.jdField_a_of_type_Int + localObject);
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
  
  public void onProgress(bbwg parambbwg)
  {
    double d;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      long l1 = System.currentTimeMillis();
      long l2 = parambbwg.g;
      d = parambbwg.f / (l1 - l2);
      if (d >= 1.0D) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      parambbwg = new DownloadReportReq();
      parambbwg.sSpeed = (d + "");
      parambbwg.vecResInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.getMyResInfos();
      parambbwg.iType = 0;
      parambbwg.iUin = this.jdField_a_of_type_Long;
      agwv.a(parambbwg, null);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadResource", 2, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.mResId + " flow down speed:" + d);
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    int i = 3;
    parambbwg.f = 1048576L;
    if (this.jdField_a_of_type_Int > 3) {
      i = this.jdField_a_of_type_Int;
    }
    parambbwg.b = i;
    return super.onStart(parambbwg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahcb
 * JD-Core Version:    0.7.0.1
 */