import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class agkq
  implements agpf
{
  public agkq(RedPacketEmojiFragment paramRedPacketEmojiFragment) {}
  
  private boolean a(HashMap<String, PreloadManager.PathResult> paramHashMap)
  {
    if (RedPacketEmojiFragment.a(this.a))
    {
      if (paramHashMap == null) {}
      do
      {
        return false;
        paramHashMap = (PreloadManager.PathResult)paramHashMap.get(this.a.c);
      } while (paramHashMap == null);
      this.a.d = paramHashMap.filePath;
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketEmojiFragment", 2, "doLoading faceConfigPath:" + this.a.d);
      }
      if (!TextUtils.isEmpty(this.a.d)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public void a(int paramInt, HashMap<String, PreloadManager.PathResult> paramHashMap)
  {
    ThreadManager.getUIHandler().post(new RedPacketEmojiFragment.3.1(this, paramInt, paramHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agkq
 * JD-Core Version:    0.7.0.1
 */