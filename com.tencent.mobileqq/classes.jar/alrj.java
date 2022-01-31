import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.wordsegment.WordSegment.ILogCallback;

final class alrj
  implements WordSegment.ILogCallback
{
  public void OnLog(String paramString1, String paramString2)
  {
    ArkAppCenter.c("ArkApp.Dict.WordSegment." + paramString1, String.format("%s", new Object[] { paramString2 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alrj
 * JD-Core Version:    0.7.0.1
 */