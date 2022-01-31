import android.os.Handler;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class aacb
  implements EarlyDownloadManager.EarlyDownLoadListener
{
  public aacb(ArConfigService paramArConfigService) {}
  
  public void a(XmlData paramXmlData) {}
  
  public void a(XmlData paramXmlData, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onDownloadProgress data=%s curOffset=%s totalLen=%s", new Object[] { paramXmlData, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    if ("qq.android.ar.native.so_v7.6.5.1".equals(paramXmlData.strResName)) {
      ArConfigService.a(this.a, (int)(100L * paramLong1 / paramLong2));
    }
    int i = (ArConfigService.a(this.a) + ArConfigService.b(this.a) + ArConfigService.c(this.a)) / 3;
    if (!ArConfigService.d(this.a)) {
      ArConfigService.a(this.a).post(new aacc(this, i));
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onDownloadFinish data=%s result=%s", new Object[] { paramXmlData, Boolean.valueOf(paramBoolean1) }));
    }
    if (paramBoolean1)
    {
      if ("qq.android.ar.native.so_v7.6.5.1".equals(paramXmlData.strResName)) {
        ArConfigService.b(this.a, true);
      }
      if ((ArConfigService.e(this.a)) && (ArConfigService.f(this.a)) && (ArConfigService.g(this.a))) {
        ArConfigService.a(this.a).post(new aacd(this));
      }
    }
    while (ArConfigService.d(this.a)) {
      return;
    }
    ArConfigService.a(this.a).post(new aace(this));
    ArConfigService.a(this.a, true);
  }
  
  public void b(XmlData paramXmlData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aacb
 * JD-Core Version:    0.7.0.1
 */