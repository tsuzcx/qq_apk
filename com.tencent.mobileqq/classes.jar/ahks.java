import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1;

public class ahks
  implements spg<spb>
{
  public ahks(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, spb paramspb)
  {
    urk.b(P2VEditMusicDialog.a(), "onAddressUpdate.");
    if ((paramBoolean) && (paramspb != null))
    {
      urk.a(P2VEditMusicDialog.a(), "onAddressUpdate success, address=%s", paramspb);
      this.a.a.post(new P2VEditMusicDialog.4.1(this, paramspb));
      return;
    }
    urk.e(P2VEditMusicDialog.a(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahks
 * JD-Core Version:    0.7.0.1
 */