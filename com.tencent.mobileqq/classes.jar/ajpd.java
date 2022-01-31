import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class ajpd
  implements ajti
{
  ajpd(ajpb paramajpb) {}
  
  public xkl a()
  {
    if (ajpb.a(this.a) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + ajpb.a(this.a).a());
    }
    return ajpb.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (ajpb.a(this.a) != null) {
      ajpb.a(this.a, ajpb.a(this.a).b());
    }
    ajpb.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (ajpb.a(this.a) != null)
    {
      if (paramInt == 0) {
        ajpb.a(this.a).setImageResource(2130846210);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      ajpb.a(this.a).setImageResource(2130846209);
      return;
    }
    ajpb.a(this.a).setImageResource(2130846203);
  }
  
  public void a(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
    if (ajpb.a(this.a) != null) {
      ajpb.a(this.a).g = paramString;
    }
  }
  
  public void a(xkl paramxkl)
  {
    if (paramxkl != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramxkl.a() + " " + paramxkl.d + " to " + paramxkl.e);
      if (paramxkl.b == 0)
      {
        ajpb.a(this.a, false);
        ajpb.b(this.a, true);
      }
    }
    for (;;)
    {
      ajpb.a(this.a, paramxkl);
      return;
      if (paramxkl.b == 1)
      {
        ajpb.a(this.a, false);
        ajpb.b(this.a, false);
        continue;
        ajpb.a(this.a, false);
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
    ajpb.a(this.a, 0);
    ajpb.a(this.a, false);
  }
  
  public boolean b()
  {
    return (ajpb.a(this.a) == null) || (!ajpb.a(this.a).a());
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    ajpb.a(this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    ajpb.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpd
 * JD-Core Version:    0.7.0.1
 */