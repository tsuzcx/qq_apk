import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1;

public class ahxi
  implements tbz<tbu>
{
  public ahxi(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, tbu paramtbu)
  {
    ved.b(P2VEditMusicDialog.a(), "onAddressUpdate.");
    if ((paramBoolean) && (paramtbu != null))
    {
      ved.a(P2VEditMusicDialog.a(), "onAddressUpdate success, address=%s", paramtbu);
      this.a.a.post(new P2VEditMusicDialog.4.1(this, paramtbu));
      return;
    }
    ved.e(P2VEditMusicDialog.a(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahxi
 * JD-Core Version:    0.7.0.1
 */