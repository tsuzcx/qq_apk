import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class alht
  implements ally
{
  alht(alhr paramalhr) {}
  
  public zdw a()
  {
    if (alhr.a(this.a) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + alhr.a(this.a).a());
    }
    return alhr.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (alhr.a(this.a) != null) {
      alhr.a(this.a, alhr.a(this.a).c());
    }
    alhr.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (alhr.a(this.a) != null)
    {
      if (paramInt == 0) {
        alhr.a(this.a).setImageResource(2130846649);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      alhr.a(this.a).setImageResource(2130846648);
      return;
    }
    alhr.a(this.a).setImageResource(2130846642);
  }
  
  public void a(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
    if (alhr.a(this.a) != null) {
      alhr.a(this.a).g = paramString;
    }
  }
  
  public void a(zdw paramzdw)
  {
    if (paramzdw != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramzdw.a() + " " + paramzdw.d + " to " + paramzdw.e);
      if (paramzdw.b == 0)
      {
        alhr.a(this.a, false);
        alhr.b(this.a, true);
      }
    }
    for (;;)
    {
      alhr.a(this.a, paramzdw);
      return;
      if (paramzdw.b == 1)
      {
        alhr.a(this.a, false);
        alhr.b(this.a, false);
        continue;
        alhr.a(this.a, false);
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
    alhr.a(this.a, 0);
    alhr.a(this.a, false);
  }
  
  public boolean b()
  {
    return (alhr.a(this.a) == null) || (!alhr.a(this.a).a());
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    alhr.a(this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    alhr.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alht
 * JD-Core Version:    0.7.0.1
 */