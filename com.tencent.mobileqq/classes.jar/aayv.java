import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiDictMgr;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.wordsegment.WordSegment;
import java.util.Locale;

public final class aayv
  implements Runnable
{
  public aayv(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      if (ArkAiDictMgr.a(this.a))
      {
        WordSegment.uninit();
        int i = WordSegment.init(ArkAppCenter.e() + '/');
        if (i != 0)
        {
          ArkAppCenter.b("ArkApp.Dict", String.format(Locale.CHINA, "reloadWordData failed, ret=%d", new Object[] { Integer.valueOf(i) }));
          return;
        }
        ArkAppCenter.b("ArkApp.Dict", String.format(Locale.CHINA, "reloadWordData success", new Object[0]));
        ArkAiDictMgr.b = true;
        VasUtils.a(this.a);
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ArkAppCenter.b("ArkApp.Dict", "reloadWordData, UnsatisfiedLinkError, err:" + localUnsatisfiedLinkError.getMessage());
      return;
    }
    ArkAppCenter.b("ArkApp.Dict", String.format("reloadWordData, dict flag is off", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayv
 * JD-Core Version:    0.7.0.1
 */