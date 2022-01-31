import android.os.Handler;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.ArConfigService.4.1;
import com.tencent.mobileqq.ar.ArConfigService.4.2;
import com.tencent.mobileqq.ar.ArConfigService.4.3;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class akne
  implements amys
{
  public akne(ArConfigService paramArConfigService) {}
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "EarlyDownLoadListener");
    }
  }
  
  public void a(XmlData paramXmlData, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onDownloadProgress data=%s curOffset=%s totalLen=%s", new Object[] { paramXmlData, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    if ("qq.android.ar.native.so_v8.0.0".equals(paramXmlData.strResName)) {
      ArConfigService.a(this.a, (int)(100L * paramLong1 / paramLong2));
    }
    int i = (ArConfigService.a(this.a) + ArConfigService.b(this.a) + ArConfigService.c(this.a) + ArConfigService.d(this.a) + ArConfigService.e(this.a)) / 5;
    if (!ArConfigService.e(this.a)) {
      ArConfigService.a(this.a).post(new ArConfigService.4.1(this, i));
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onDownloadFinish data=%s result=%s", new Object[] { paramXmlData, Boolean.valueOf(paramBoolean1) }));
    }
    if (paramBoolean1)
    {
      if ("qq.android.ar.native.so_v8.0.0".equals(paramXmlData.strResName)) {
        ArConfigService.b(this.a, true);
      }
      if ((ArConfigService.f(this.a)) && (ArConfigService.g(this.a)) && (ArConfigService.h(this.a)) && (ArConfigService.i(this.a)) && (ArConfigService.j(this.a))) {
        ArConfigService.a(this.a).post(new ArConfigService.4.2(this));
      }
    }
    while (ArConfigService.e(this.a)) {
      return;
    }
    ArConfigService.a(this.a).post(new ArConfigService.4.3(this));
    ArConfigService.a(this.a, true);
  }
  
  public void b(XmlData paramXmlData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akne
 * JD-Core Version:    0.7.0.1
 */