import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class ahtg
  implements ahxl
{
  ahtg(ahte paramahte) {}
  
  public vrn a()
  {
    if (ahte.a(this.a) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + ahte.a(this.a).a());
    }
    return ahte.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (ahte.a(this.a) != null) {
      ahte.a(this.a, ahte.a(this.a).b());
    }
    ahte.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (ahte.a(this.a) != null)
    {
      if (paramInt == 0) {
        ahte.a(this.a).setImageResource(2130845752);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      ahte.a(this.a).setImageResource(2130845751);
      return;
    }
    ahte.a(this.a).setImageResource(2130845745);
  }
  
  public void a(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
    if (ahte.a(this.a) != null) {
      ahte.a(this.a).g = paramString;
    }
  }
  
  public void a(vrn paramvrn)
  {
    if (paramvrn != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramvrn.a() + " " + paramvrn.d + " to " + paramvrn.e);
      if (paramvrn.b == 0)
      {
        ahte.a(this.a, false);
        ahte.b(this.a, true);
      }
    }
    for (;;)
    {
      ahte.a(this.a, paramvrn);
      return;
      if (paramvrn.b == 1)
      {
        ahte.a(this.a, false);
        ahte.b(this.a, false);
        continue;
        ahte.a(this.a, false);
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
    ahte.a(this.a, 0);
    ahte.a(this.a, false);
  }
  
  public boolean b()
  {
    return (ahte.a(this.a) == null) || (!ahte.a(this.a).a());
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    ahte.a(this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    ahte.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahtg
 * JD-Core Version:    0.7.0.1
 */