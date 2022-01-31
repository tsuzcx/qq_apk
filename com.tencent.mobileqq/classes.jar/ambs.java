import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class ambs
  extends bbwt
{
  public ambs(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(bbwu parambbwu)
  {
    String str = parambbwu.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onCancel pkgName = " + str);
    }
    this.a.a("Bubble_download_cancel", parambbwu.b(), str, 0L);
  }
  
  public void onDone(bbwu parambbwu)
  {
    long l = parambbwu.h - parambbwu.g;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onDone downloadTime = " + l);
    }
    this.a.a("Bubble_download_succ", parambbwu.b(), "pkgName", l);
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    String str = parambbwu.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onStart pkgName = " + str);
    }
    this.a.a("Bubble_download", parambbwu.b(), str, 0L);
    super.onStart(parambbwu);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambs
 * JD-Core Version:    0.7.0.1
 */