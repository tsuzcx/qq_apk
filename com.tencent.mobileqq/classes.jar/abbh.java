import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.ar.ArNativeSoLoader;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;

public class abbh
  implements EarlyDownloadManager.EarlyDownLoadListener
{
  public abbh(ARMapLoadingActivity paramARMapLoadingActivity) {}
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "onDownloadBegin, data=" + paramXmlData);
    }
  }
  
  public void a(XmlData paramXmlData, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "onDownloadProgress, data=" + paramXmlData + ", cur=" + paramLong1 + ", total=" + paramLong2);
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    int j = 7;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "onDownloadFinish, data=" + paramXmlData + ", result=" + paramBoolean1 + ", errCode=" + paramInt + ", delRes=" + paramBoolean2 + ", filePath=" + paramString);
    }
    int i = j;
    paramInt = k;
    if (paramBoolean1)
    {
      if (ArNativeSoLoader.a("ArMapEngine738")) {
        break label163;
      }
      i = j;
      paramInt = k;
      if (QLog.isColorLevel())
      {
        QLog.d("ARMapLoadingActivity", 2, "onDownloadFinish, but the file miss");
        paramInt = k;
        i = j;
      }
    }
    for (;;)
    {
      ARMapLoadingActivity.a(this.a).removeMessages(111);
      if (paramInt == 0)
      {
        paramXmlData = ARMapLoadingActivity.a(this.a).obtainMessage(104);
        paramXmlData.arg1 = i;
        paramXmlData.sendToTarget();
        return;
        label163:
        if (this.a.a())
        {
          paramXmlData = ArNativeSoLoader.a() + "/lib" + "ArMapEngine738" + ".so";
          paramString = PortalUtils.a(paramXmlData);
          String str = this.a.a();
          if (QLog.isColorLevel()) {
            QLog.d("ARMapLoadingActivity", 2, "onDownloadFinish, need check md5.path=" + paramXmlData + ", calc=" + paramString + ", md5=" + str);
          }
          if (!str.equalsIgnoreCase(paramString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ARMapLoadingActivity", 2, "onDownloadFinish, md5 mismatch");
            }
            i = 9;
            paramInt = k;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARMapLoadingActivity", 2, "onDownloadFinish, not need check");
          }
          paramInt = 1;
          i = j;
        }
      }
      else
      {
        paramXmlData = ARMapLoadingActivity.a(this.a).obtainMessage(112);
        ARMapLoadingActivity.a(this.a).sendMessage(paramXmlData);
        return;
      }
      paramInt = 1;
      i = j;
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "onDownloadCancel, data=" + paramXmlData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbh
 * JD-Core Version:    0.7.0.1
 */