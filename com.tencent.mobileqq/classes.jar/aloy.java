import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class aloy
  implements altb
{
  aloy(alow paramalow) {}
  
  public yxk a()
  {
    if (alow.a(this.a) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + alow.a(this.a).a());
    }
    return alow.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (alow.a(this.a) != null) {
      alow.a(this.a, alow.a(this.a).c());
    }
    alow.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (alow.a(this.a) != null)
    {
      if (paramInt == 0) {
        alow.a(this.a).setImageResource(2130846670);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      alow.a(this.a).setImageResource(2130846669);
      return;
    }
    alow.a(this.a).setImageResource(2130846663);
  }
  
  public void a(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
    if (alow.a(this.a) != null) {
      alow.a(this.a).g = paramString;
    }
  }
  
  public void a(yxk paramyxk)
  {
    if (paramyxk != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramyxk.a() + " " + paramyxk.d + " to " + paramyxk.e);
      if (paramyxk.b == 0)
      {
        alow.a(this.a, false);
        alow.b(this.a, true);
      }
    }
    for (;;)
    {
      alow.a(this.a, paramyxk);
      return;
      if (paramyxk.b == 1)
      {
        alow.a(this.a, false);
        alow.b(this.a, false);
        continue;
        alow.a(this.a, false);
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onStopCurFragmentMusic: ");
    alow.a(this.a, 0);
    alow.a(this.a, false);
  }
  
  public boolean b()
  {
    return (alow.a(this.a) == null) || (!alow.a(this.a).hasMusic());
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    alow.a(this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    alow.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aloy
 * JD-Core Version:    0.7.0.1
 */