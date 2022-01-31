import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1;

public class ajos
  implements uqr<uqm>
{
  public ajos(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, uqm paramuqm)
  {
    wsv.b(P2VEditMusicDialog.a(), "onAddressUpdate.");
    if ((paramBoolean) && (paramuqm != null))
    {
      wsv.a(P2VEditMusicDialog.a(), "onAddressUpdate success, address=%s", paramuqm);
      this.a.a.post(new P2VEditMusicDialog.4.1(this, paramuqm));
      return;
    }
    wsv.e(P2VEditMusicDialog.a(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajos
 * JD-Core Version:    0.7.0.1
 */