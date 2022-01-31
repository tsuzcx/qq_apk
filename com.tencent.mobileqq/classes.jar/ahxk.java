import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1;

public class ahxk
  implements tcc<tbx>
{
  public ahxk(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, tbx paramtbx)
  {
    veg.b(P2VEditMusicDialog.a(), "onAddressUpdate.");
    if ((paramBoolean) && (paramtbx != null))
    {
      veg.a(P2VEditMusicDialog.a(), "onAddressUpdate success, address=%s", paramtbx);
      this.a.a.post(new P2VEditMusicDialog.4.1(this, paramtbx));
      return;
    }
    veg.e(P2VEditMusicDialog.a(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahxk
 * JD-Core Version:    0.7.0.1
 */