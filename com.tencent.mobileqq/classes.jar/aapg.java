import com.tencent.mobileqq.ark.ArkMediaPlayer;

public class aapg
  implements Runnable
{
  public aapg(ArkMediaPlayer paramArkMediaPlayer) {}
  
  public void run()
  {
    ArkMediaPlayer.a(this.a, false);
    if (this.a.Pause()) {
      ArkMediaPlayer.a(this.a, ArkMediaPlayer.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapg
 * JD-Core Version:    0.7.0.1
 */