import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.10.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;

public class akyj
  implements aldq
{
  public akyj(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      akyt localakyt = new akyt();
      localakyt.a = (paramPathResult.folderPath + "/" + "original.mp3");
      localakyt.b = (paramPathResult.folderPath + "/" + "accompany.mp3");
      localakyt.c = (paramPathResult.folderPath + "/" + "lyrics.qrc");
      localakyt.d = (paramPathResult.folderPath + "/" + "config.cfg");
      RedPacketKSongFragment.a(this.a, localakyt);
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
 * Qualified Name:     akyj
 * JD-Core Version:    0.7.0.1
 */