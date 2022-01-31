import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class ajko
  implements ajot
{
  ajko(ajkm paramajkm) {}
  
  public xgc a()
  {
    if (ajkm.a(this.a) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + ajkm.a(this.a).a());
    }
    return ajkm.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (ajkm.a(this.a) != null) {
      ajkm.a(this.a, ajkm.a(this.a).b());
    }
    ajkm.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (ajkm.a(this.a) != null)
    {
      if (paramInt == 0) {
        ajkm.a(this.a).setImageResource(2130846137);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      ajkm.a(this.a).setImageResource(2130846136);
      return;
    }
    ajkm.a(this.a).setImageResource(2130846130);
  }
  
  public void a(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
    if (ajkm.a(this.a) != null) {
      ajkm.a(this.a).g = paramString;
    }
  }
  
  public void a(xgc paramxgc)
  {
    if (paramxgc != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramxgc.a() + " " + paramxgc.d + " to " + paramxgc.e);
      if (paramxgc.b == 0)
      {
        ajkm.a(this.a, false);
        ajkm.b(this.a, true);
      }
    }
    for (;;)
    {
      ajkm.a(this.a, paramxgc);
      return;
      if (paramxgc.b == 1)
      {
        ajkm.a(this.a, false);
        ajkm.b(this.a, false);
        continue;
        ajkm.a(this.a, false);
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
    ajkm.a(this.a, 0);
    ajkm.a(this.a, false);
  }
  
  public boolean b()
  {
    return (ajkm.a(this.a) == null) || (!ajkm.a(this.a).a());
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    ajkm.a(this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    ajkm.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajko
 * JD-Core Version:    0.7.0.1
 */