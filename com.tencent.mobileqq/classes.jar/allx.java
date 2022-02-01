import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1;

public class allx
  implements wom<woh>
{
  public allx(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, woh paramwoh)
  {
    yqp.b(P2VEditMusicDialog.a(), "onAddressUpdate.");
    if ((paramBoolean) && (paramwoh != null))
    {
      yqp.a(P2VEditMusicDialog.a(), "onAddressUpdate success, address=%s", paramwoh);
      this.a.a.post(new P2VEditMusicDialog.4.1(this, paramwoh));
      return;
    }
    yqp.e(P2VEditMusicDialog.a(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allx
 * JD-Core Version:    0.7.0.1
 */