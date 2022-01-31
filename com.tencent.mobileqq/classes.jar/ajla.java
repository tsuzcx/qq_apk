import com.tencent.TMG.sdk.AVCallback;
import com.tencent.TMG.utils.SoUtil;
import com.tencent.qphone.base.util.QLog;

class ajla
  implements AVCallback
{
  ajla(ajku paramajku) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      QLog.e("AVEngineWalper", 1, "AVCallback make connection successfully!!!");
      if (!this.a.a())
      {
        bbdj.d(ajll.a() + "libqav_graphics.so", ajll.a() + "libtmg_graphics.so");
        boolean bool = SoUtil.loadSo("tmg_graphics");
        QLog.e("AVEngineWalper", 1, "first check failed, rename bLoad = " + bool);
        if (!this.a.a())
        {
          QLog.e("AVEngineWalper", 1, "Second check failed, stop engine~~~");
          ajku.a(this.a, false);
          this.a.a();
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.a(paramInt, paramString);
      }
      return;
      ajku.a(this.a, true);
      QLog.e("AVEngineWalper", 1, "start successfully second try~~~~");
      continue;
      ajku.a(this.a, true);
      QLog.e("AVEngineWalper", 1, "start successfully~~~~");
      continue;
      QLog.e("AVEngineWalper", 1, "AVCallback result=" + paramInt + ", errorInfo=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajla
 * JD-Core Version:    0.7.0.1
 */