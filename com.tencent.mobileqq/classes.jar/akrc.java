import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class akrc
  implements akvf
{
  akrc(akra paramakra) {}
  
  public yir a()
  {
    if (akra.a(this.a) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + akra.a(this.a).a());
    }
    return akra.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (akra.a(this.a) != null) {
      akra.a(this.a, akra.a(this.a).c());
    }
    akra.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (akra.a(this.a) != null)
    {
      if (paramInt == 0) {
        akra.a(this.a).setImageResource(2130846574);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      akra.a(this.a).setImageResource(2130846573);
      return;
    }
    akra.a(this.a).setImageResource(2130846567);
  }
  
  public void a(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
    if (akra.a(this.a) != null) {
      akra.a(this.a).g = paramString;
    }
  }
  
  public void a(yir paramyir)
  {
    if (paramyir != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramyir.a() + " " + paramyir.d + " to " + paramyir.e);
      if (paramyir.b == 0)
      {
        akra.a(this.a, false);
        akra.b(this.a, true);
      }
    }
    for (;;)
    {
      akra.a(this.a, paramyir);
      return;
      if (paramyir.b == 1)
      {
        akra.a(this.a, false);
        akra.b(this.a, false);
        continue;
        akra.a(this.a, false);
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
    akra.a(this.a, 0);
    akra.a(this.a, false);
  }
  
  public boolean b()
  {
    return (akra.a(this.a) == null) || (!akra.a(this.a).hasMusic());
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    akra.a(this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    akra.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrc
 * JD-Core Version:    0.7.0.1
 */