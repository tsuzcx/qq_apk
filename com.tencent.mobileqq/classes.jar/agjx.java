import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ar.IArConfigListener;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoLogListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.ArrayList;
import java.util.Iterator;

public class agjx
  implements IArConfigListener
{
  public agjx(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onArManagerReady");
    }
    ScanTorchActivity.a(this.a, System.currentTimeMillis());
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(ARCommonConfigInfo arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("onARCommonConfigChanged mHasGetARConfig=%s arCommonConfigInfo=%s", new Object[] { Boolean.valueOf(ScanTorchActivity.a(this.a)), ??? }));
    }
    if (ScanTorchActivity.a(this.a))
    {
      QLog.w("ScanTorchActivity", 1, "onARCommonConfigChanged have got ARConfig before.");
      return;
    }
    Object localObject1;
    if ((this.a.b()) && (??? != null) && (???.recognitions != null) && (???.recognitions.size() > 0))
    {
      localObject1 = new ArrayList();
      long l = this.a.a();
      Iterator localIterator = ???.recognitions.iterator();
      while (localIterator.hasNext())
      {
        ARRecognition localARRecognition = (ARRecognition)localIterator.next();
        if ((localARRecognition.a == l) || ((l == 0L) && (localARRecognition.a == 2L))) {
          ((ArrayList)localObject1).add(localARRecognition);
        }
      }
      ???.recognitions = ((ArrayList)localObject1);
    }
    ScanTorchActivity.a(this.a, ???);
    if ((??? != null) && (???.arControllers != null))
    {
      ??? = ???.arControllers.iterator();
      while (???.hasNext())
      {
        localObject1 = (ARScanAR)???.next();
        if ((localObject1 != null) && (((ARScanAR)localObject1).a == 1))
        {
          this.a.b = ((ARScanAR)localObject1).j;
          this.a.c = ((ARScanAR)localObject1).f;
        }
      }
      this.a.a.removeMessages(325);
      this.a.a.sendEmptyMessage(325);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onARCommonConfigChanged what2scanUrl =" + this.a.b);
    }
    ScanTorchActivity.b(this.a, System.currentTimeMillis());
    ScanTorchActivity.a(this.a);
    TVK_SDKMgr.setDebugEnable(false);
    TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    TVK_SDKMgr.setOnLogListener(new AROnlineVideoLogListener());
    ScanTorchActivity.b(this.a);
    ScanTorchActivity.c(this.a);
    ScanTorchActivity.c(this.a, System.currentTimeMillis());
    ??? = this.a;
    if ((!ScanTorchActivity.b(this.a)) || (!ScanTorchActivity.c(this.a))) {}
    for (boolean bool = true;; bool = false)
    {
      ScanTorchActivity.a(???, bool);
      synchronized (this.a)
      {
        ScanTorchActivity.b(this.a, true);
        ScanTorchActivity.d(this.a);
        return;
      }
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onArConfigChanged arConfigInfo=" + paramArConfigInfo);
    }
    ScanTorchActivity.a(this.a, paramArConfigInfo);
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onEffectConfigChanged arEffectConfig=" + paramArEffectConfig);
    }
    ScanTorchActivity.a(this.a, paramArEffectConfig);
    ARDeviceController.a().a(paramArEffectConfig);
    boolean bool1 = ARDeviceController.a().a();
    boolean bool2 = ARDeviceController.a().b();
    paramArEffectConfig = ARDeviceController.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, String.format("onEffectConfigChanged isAREnable=%s isSupportAr=%s GPU=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramArEffectConfig }));
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjx
 * JD-Core Version:    0.7.0.1
 */