import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class ahgp
  implements ahkt
{
  ahgp(ahgn paramahgn) {}
  
  public ver a()
  {
    if (ahgn.a(this.a) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + ahgn.a(this.a).a());
    }
    return ahgn.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (ahgn.a(this.a) != null) {
      ahgn.a(this.a, ahgn.a(this.a).b());
    }
    ahgn.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (ahgn.a(this.a) != null)
    {
      if (paramInt == 0) {
        ahgn.a(this.a).setImageResource(2130845569);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      ahgn.a(this.a).setImageResource(2130845568);
      return;
    }
    ahgn.a(this.a).setImageResource(2130845562);
  }
  
  public void a(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
    if (ahgn.a(this.a) != null) {
      ahgn.a(this.a).g = paramString;
    }
  }
  
  public void a(ver paramver)
  {
    if (paramver != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramver.a() + " " + paramver.d + " to " + paramver.e);
      if (paramver.b == 0)
      {
        ahgn.a(this.a, false);
        ahgn.b(this.a, true);
      }
    }
    for (;;)
    {
      ahgn.a(this.a, paramver);
      return;
      if (paramver.b == 1)
      {
        ahgn.a(this.a, false);
        ahgn.b(this.a, false);
        continue;
        ahgn.a(this.a, false);
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
    ahgn.a(this.a, 0);
    ahgn.a(this.a, false);
  }
  
  public boolean b()
  {
    return (ahgn.a(this.a) == null) || (!ahgn.a(this.a).a());
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    ahgn.a(this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    ahgn.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgp
 * JD-Core Version:    0.7.0.1
 */