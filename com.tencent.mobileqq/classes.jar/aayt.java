import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiDictMgr;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class aayt
  implements Runnable
{
  public aayt(ArkAiDictMgr paramArkAiDictMgr) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.Dict", "initWordData, qq app is null, return.");
      return;
    }
    int j = -1;
    for (int i = j;; i = j)
    {
      try
      {
        WordSegment.setLogCallback(new aayu(this));
        i = j;
        if (!ArkAiDictMgr.a(localQQAppInterface)) {
          break label124;
        }
        i = j;
        j = WordSegment.init(ArkAppCenter.e() + '/');
        i = j;
        ArkAppCenter.b("ArkApp.Dict", String.format("getWordInitState, WordSegment_Init State is opened", new Object[0]));
        i = j;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          label124:
          j = i;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ArkApp.Dict", 2, "initWordData, UnsatisfiedLinkError, err:" + localUnsatisfiedLinkError.getMessage());
            i = j;
          }
        }
        ArkAiDictMgr.b = true;
        VasUtils.a(localQQAppInterface);
      }
      if (i == 0) {
        break;
      }
      ArkAppCenter.b("ArkApp.Dict", String.format(Locale.CHINA, "initWordData failed, ret=%d", new Object[] { Integer.valueOf(i) }));
      return;
      i = j;
      ArkAppCenter.b("ArkApp.Dict", String.format("getWordInitState, WordSegment_Init State is closed", new Object[0]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayt
 * JD-Core Version:    0.7.0.1
 */