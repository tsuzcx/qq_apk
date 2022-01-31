import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1;

public class ajth
  implements uva<uuv>
{
  public ajth(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, uuv paramuuv)
  {
    wxe.b(P2VEditMusicDialog.a(), "onAddressUpdate.");
    if ((paramBoolean) && (paramuuv != null))
    {
      wxe.a(P2VEditMusicDialog.a(), "onAddressUpdate success, address=%s", paramuuv);
      this.a.a.post(new P2VEditMusicDialog.4.1(this, paramuuv));
      return;
    }
    wxe.e(P2VEditMusicDialog.a(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajth
 * JD-Core Version:    0.7.0.1
 */