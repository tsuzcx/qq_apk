import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.10.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;

public class airf
  implements aivw
{
  public airf(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      airp localairp = new airp();
      localairp.a = (paramPathResult.folderPath + "/" + "original.mp3");
      localairp.b = (paramPathResult.folderPath + "/" + "accompany.mp3");
      localairp.c = (paramPathResult.folderPath + "/" + "lyrics.qrc");
      localairp.d = (paramPathResult.folderPath + "/" + "config.cfg");
      RedPacketKSongFragment.a(this.a, localairp);
      if (this.a.c()) {
        return;
      }
      this.a.getActivity().runOnUiThread(new RedPacketKSongFragment.10.1(this));
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airf
 * JD-Core Version:    0.7.0.1
 */