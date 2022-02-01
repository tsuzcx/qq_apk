import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.10.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;

public class akrt
  implements akxc
{
  public akrt(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      aksd localaksd = new aksd();
      localaksd.a = (paramPathResult.folderPath + "/" + "original.mp3");
      localaksd.b = (paramPathResult.folderPath + "/" + "accompany.mp3");
      localaksd.c = (paramPathResult.folderPath + "/" + "lyrics.qrc");
      localaksd.d = (paramPathResult.folderPath + "/" + "config.cfg");
      RedPacketKSongFragment.a(this.a, localaksd);
      if (this.a.c()) {
        return;
      }
      this.a.getActivity().runOnUiThread(new RedPacketKSongFragment.10.1(this));
      return;
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrt
 * JD-Core Version:    0.7.0.1
 */