import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class acdq
  extends DownloadListener
{
  public acdq(VasEmojiManager paramVasEmojiManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    EmojiManager localEmojiManager = this.a.a();
    Bundle localBundle = paramDownloadTask.a();
    if (paramDownloadTask.a() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localEmojiManager.a(localBundle, paramDownloadTask, bool, paramDownloadTask.a, paramDownloadTask.d, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    Object localObject = paramDownloadTask.a();
    int i = ((Bundle)localObject).getInt(paramDownloadTask.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + paramDownloadTask);
    }
    if (paramDownloadTask.a != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + paramDownloadTask.a);
      if (EmojiManager.a(i)) {
        EmojiManager.a.a((EmoticonPackage)localObject, i, -1, paramDownloadTask.a);
      }
      VasReportUtils.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", paramDownloadTask.a + "", "", "", "");
    }
    for (;;)
    {
      return;
      EmojiManager localEmojiManager = this.a.a();
      if (EmojiManager.a(i)) {
        EmojiManager.a.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localEmojiManager.b(paramDownloadTask);
        return;
        if (i == 7) {
          localEmojiManager.a(paramDownloadTask);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acdq
 * JD-Core Version:    0.7.0.1
 */