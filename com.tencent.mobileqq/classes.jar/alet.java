import Wallet.DownloadReportReq;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

class alet
  extends biht
{
  private boolean jdField_a_of_type_Boolean;
  
  alet(aler paramaler, int paramInt, WeakReference paramWeakReference, biht parambiht, long paramLong) {}
  
  public void onDoneFile(bihu parambihu)
  {
    Object localObject = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a((PreloadManager)localObject)) {
      ((PreloadManager)localObject).c();
    }
    if (this.jdField_a_of_type_Biht != null) {
      this.jdField_a_of_type_Biht.onDoneFile(parambihu);
    }
    localObject = new DownloadReportReq();
    int i;
    File localFile;
    long l;
    if (parambihu.jdField_a_of_type_Int == 0)
    {
      ((DownloadReportReq)localObject).iType = 1;
      int j = -1;
      i = j;
      if (parambihu.jdField_a_of_type_JavaUtilMap != null)
      {
        i = j;
        if (!TextUtils.isEmpty(parambihu.jdField_a_of_type_JavaLangString))
        {
          localFile = (File)parambihu.jdField_a_of_type_JavaUtilMap.get(parambihu.jdField_a_of_type_JavaLangString);
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
        ((DownloadReportReq)localObject).vecResInfo = this.jdField_a_of_type_Aler.a(i);
        ((DownloadReportReq)localObject).iUin = this.jdField_a_of_type_Long;
        ((DownloadReportReq)localObject).sPhoneType = bhlo.i();
        ((DownloadReportReq)localObject).sOsVersion = bhlo.e();
        ((DownloadReportReq)localObject).sQQVersion = bhlo.c();
        ((DownloadReportReq)localObject).iScene = parambihu.a().getInt("scene");
        akxq.a((JceStruct)localObject, null);
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, aler.a(this.jdField_a_of_type_Aler) + " flow down result:" + parambihu.jdField_a_of_type_Int + localObject);
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
  
  public void onProgress(bihu parambihu)
  {
    double d;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      long l1 = System.currentTimeMillis();
      long l2 = parambihu.g;
      d = parambihu.f / (l1 - l2);
      if (d >= 1.0D) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      parambihu = new DownloadReportReq();
      parambihu.sSpeed = (d + "");
      parambihu.vecResInfo = this.jdField_a_of_type_Aler.a(0);
      parambihu.iType = 0;
      parambihu.iUin = this.jdField_a_of_type_Long;
      akxq.a(parambihu, null);
    } while (!QLog.isColorLevel());
    QLog.d("RealTimeFlowControlObj", 2, aler.a(this.jdField_a_of_type_Aler) + " flow down speed:" + d);
  }
  
  public boolean onStart(bihu parambihu)
  {
    parambihu.f = 1048576L;
    parambihu.b = Math.max(this.jdField_a_of_type_Int, 3);
    return super.onStart(parambihu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alet
 * JD-Core Version:    0.7.0.1
 */