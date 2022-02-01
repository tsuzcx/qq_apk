import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1;

public class alxp
  implements wsh<wsc>
{
  public alxp(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, wsc paramwsc)
  {
    yuk.b(P2VEditMusicDialog.a(), "onAddressUpdate.");
    if ((paramBoolean) && (paramwsc != null))
    {
      yuk.a(P2VEditMusicDialog.a(), "onAddressUpdate success, address=%s", paramwsc);
      this.a.a.post(new P2VEditMusicDialog.4.1(this, paramwsc));
      return;
    }
    yuk.e(P2VEditMusicDialog.a(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxp
 * JD-Core Version:    0.7.0.1
 */