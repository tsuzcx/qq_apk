import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1;

public class akve
  implements vtx<vts>
{
  public akve(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, vts paramvts)
  {
    xvv.b(P2VEditMusicDialog.a(), "onAddressUpdate.");
    if ((paramBoolean) && (paramvts != null))
    {
      xvv.a(P2VEditMusicDialog.a(), "onAddressUpdate success, address=%s", paramvts);
      this.a.a.post(new P2VEditMusicDialog.4.1(this, paramvts));
      return;
    }
    xvv.e(P2VEditMusicDialog.a(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akve
 * JD-Core Version:    0.7.0.1
 */