import com.tencent.mobileqq.ark.ArkMediaPlayer;

public class aawg
  implements Runnable
{
  public aawg(ArkMediaPlayer paramArkMediaPlayer) {}
  
  public void run()
  {
    if (ArkMediaPlayer.a(this.a)) {
      return;
    }
    ArkMediaPlayer.a(this.a, true);
    if (ArkMediaPlayer.a(this.a) == ArkMediaPlayer.b(this.a)) {
      this.a.Play();
    }
    for (;;)
    {
      ArkMediaPlayer.a(this.a, ArkMediaPlayer.f(this.a));
      return;
      if (ArkMediaPlayer.a(this.a) == ArkMediaPlayer.c(this.a)) {
        this.a.Stop();
      } else if (ArkMediaPlayer.a(this.a) == ArkMediaPlayer.d(this.a)) {
        this.a.Resume();
      } else if (ArkMediaPlayer.a(this.a) == ArkMediaPlayer.e(this.a)) {
        this.a.Pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawg
 * JD-Core Version:    0.7.0.1
 */