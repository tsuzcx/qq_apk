import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1;

public class alta
  implements wis<win>
{
  public alta(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, win paramwin)
  {
    ykq.b(P2VEditMusicDialog.a(), "onAddressUpdate.");
    if ((paramBoolean) && (paramwin != null))
    {
      ykq.a(P2VEditMusicDialog.a(), "onAddressUpdate success, address=%s", paramwin);
      this.a.a.post(new P2VEditMusicDialog.4.1(this, paramwin));
      return;
    }
    ykq.e(P2VEditMusicDialog.a(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alta
 * JD-Core Version:    0.7.0.1
 */