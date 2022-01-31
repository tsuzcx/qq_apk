import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

class ahte
  implements ahxj
{
  ahte(ahtc paramahtc) {}
  
  public vrk a()
  {
    if (ahtc.a(this.a) != null) {
      QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + ahtc.a(this.a).a());
    }
    return ahtc.a(this.a);
  }
  
  public void a()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
    if (ahtc.a(this.a) != null) {
      ahtc.a(this.a, ahtc.a(this.a).b());
    }
    ahtc.a(this.a, true);
  }
  
  public void a(int paramInt)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + paramInt);
    if (ahtc.a(this.a) != null)
    {
      if (paramInt == 0) {
        ahtc.a(this.a).setImageResource(2130845758);
      }
    }
    else {
      return;
    }
    if (paramInt == 3)
    {
      ahtc.a(this.a).setImageResource(2130845757);
      return;
    }
    ahtc.a(this.a).setImageResource(2130845751);
  }
  
  public void a(String paramString)
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + paramString);
    if (ahtc.a(this.a) != null) {
      ahtc.a(this.a).g = paramString;
    }
  }
  
  public void a(vrk paramvrk)
  {
    if (paramvrk != null)
    {
      QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + paramvrk.a() + " " + paramvrk.d + " to " + paramvrk.e);
      if (paramvrk.b == 0)
      {
        ahtc.a(this.a, false);
        ahtc.b(this.a, true);
      }
    }
    for (;;)
    {
      ahtc.a(this.a, paramvrk);
      return;
      if (paramvrk.b == 1)
      {
        ahtc.a(this.a, false);
        ahtc.b(this.a, false);
        continue;
        ahtc.a(this.a, false);
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
    ahtc.a(this.a, 0);
    ahtc.a(this.a, false);
  }
  
  public boolean b()
  {
    return (ahtc.a(this.a) == null) || (!ahtc.a(this.a).a());
  }
  
  public void c()
  {
    QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
    ahtc.a(this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    ahtc.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahte
 * JD-Core Version:    0.7.0.1
 */