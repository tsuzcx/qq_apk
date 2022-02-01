import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class altl
  implements alxq
{
  altl(altj paramaltj) {}
  
  public zhr a()
  {
    if (altj.a(this.a) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + altj.a(this.a).a());
    }
    return altj.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (altj.a(this.a) != null) {
      altj.a(this.a, altj.a(this.a).c());
    }
    altj.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (altj.a(this.a) != null)
    {
      if (paramInt == 0) {
        altj.a(this.a).setImageResource(2130846666);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      altj.a(this.a).setImageResource(2130846665);
      return;
    }
    altj.a(this.a).setImageResource(2130846659);
  }
  
  public void a(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
    if (altj.a(this.a) != null) {
      altj.a(this.a).g = paramString;
    }
  }
  
  public void a(zhr paramzhr)
  {
    if (paramzhr != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramzhr.a() + " " + paramzhr.d + " to " + paramzhr.e);
      if (paramzhr.b == 0)
      {
        altj.a(this.a, false);
        altj.b(this.a, true);
      }
    }
    for (;;)
    {
      altj.a(this.a, paramzhr);
      return;
      if (paramzhr.b == 1)
      {
        altj.a(this.a, false);
        altj.b(this.a, false);
        continue;
        altj.a(this.a, false);
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
    altj.a(this.a, 0);
    altj.a(this.a, false);
  }
  
  public boolean b()
  {
    return (altj.a(this.a) == null) || (!altj.a(this.a).a());
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    altj.a(this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    altj.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altl
 * JD-Core Version:    0.7.0.1
 */