import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.SmallEmojiSpan;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qbar.QbarNativeImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

public class ahzo
  implements Runnable
{
  public ahzo(QQText.SmallEmojiSpan paramSmallEmojiSpan) {}
  
  public void run()
  {
    Object localObject2 = EmoticonUtils.r.replace("[epId]", Integer.toString(this.a.e));
    boolean bool = FileUtils.a((String)localObject2);
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(QQText.c());
        if (localQQAppInterface1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQText", 2, "appInterface is null. return");
          }
          return;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        localClassCastException.printStackTrace();
        QQAppInterface localQQAppInterface2 = null;
        continue;
        if (bool)
        {
          localObject3 = EmoticonUtils.a();
          if (localObject3 == null) {
            break label354;
          }
          localObject1 = ((EmoticonManager)localObject3).a(Integer.toString(this.a.e), Integer.toString(this.a.f));
          if (localObject1 != null)
          {
            localObject1 = ((EmoticonManager)localObject3).a(Integer.toString(this.a.e));
            if ((localObject1 == null) || (((EmoticonPackage)localObject1).isAPNG != 0)) {
              continue;
            }
            localObject2 = new ArrayList();
            EmotionJsonUtils.a(localQQAppInterface2, (EmoticonPackage)localObject1, EmojiManager.b, QbarNativeImpl.b, (ArrayList)localObject2);
            return;
          }
        }
        Object localObject3 = EmoticonUtils.c.replace("[epId]", Integer.toString(this.a.e));
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QQText", 2, "small emoji json not exist. epId:" + this.a.e + ",downloadUrl:" + (String)localObject3);
        }
        localObject2 = new DownloadTask((String)localObject3, (File)localObject1);
        ((DownloadTask)localObject2).h = true;
        int i = DownloaderFactory.a((DownloadTask)localObject2, localQQAppInterface2);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).epId = Integer.toString(this.a.e);
        ((EmoticonPackage)localObject2).jobType = 4;
        if (i != 0) {
          continue;
        }
        if (((File)localObject1).exists())
        {
          localObject1 = FileUtils.a((File)localObject1);
          localObject3 = new ArrayList();
          EmotionJsonUtils.a(localQQAppInterface2, (EmoticonPackage)localObject2, EmojiManager.b, (byte[])localObject1, (ArrayList)localObject3);
          return;
        }
        localObject1 = null;
        continue;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        return;
      }
      label354:
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahzo
 * JD-Core Version:    0.7.0.1
 */