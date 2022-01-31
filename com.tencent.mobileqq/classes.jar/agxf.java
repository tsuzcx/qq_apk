import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.10.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;

public class agxf
  implements ahbr
{
  public agxf(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      agxp localagxp = new agxp();
      localagxp.a = (paramPathResult.folderPath + "/" + "original.mp3");
      localagxp.b = (paramPathResult.folderPath + "/" + "accompany.mp3");
      localagxp.c = (paramPathResult.folderPath + "/" + "lyrics.qrc");
      localagxp.d = (paramPathResult.folderPath + "/" + "config.cfg");
      RedPacketKSongFragment.a(this.a, localagxp);
      if (this.a.c()) {
        return;
      }
      this.a.getActivity().runOnUiThread(new RedPacketKSongFragment.10.1(this));
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agxf
 * JD-Core Version:    0.7.0.1
 */