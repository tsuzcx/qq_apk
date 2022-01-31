import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class ambt
  extends bbwf
{
  public ambt(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bbwg parambbwg)
  {
    String str = parambbwg.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onCancel pkgName = " + str);
    }
    this.a.a("Bubble_download_cancel", parambbwg.b(), str, 0L);
  }
  
  public void onDone(bbwg parambbwg)
  {
    long l = parambbwg.h - parambbwg.g;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onDone downloadTime = " + l);
    }
    this.a.a("Bubble_download_succ", parambbwg.b(), "pkgName", l);
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    String str = parambbwg.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onStart pkgName = " + str);
    }
    this.a.a("Bubble_download", parambbwg.b(), str, 0L);
    super.onStart(parambbwg);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambt
 * JD-Core Version:    0.7.0.1
 */