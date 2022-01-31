import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class alnf
  extends batl
{
  public alnf(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(batm parambatm)
  {
    String str = parambatm.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onCancel pkgName = " + str);
    }
    this.a.a("Bubble_download_cancel", parambatm.b(), str, 0L);
  }
  
  public void onDone(batm parambatm)
  {
    long l = parambatm.h - parambatm.g;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onDone downloadTime = " + l);
    }
    this.a.a("Bubble_download_succ", parambatm.b(), "pkgName", l);
  }
  
  public boolean onStart(batm parambatm)
  {
    String str = parambatm.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onStart pkgName = " + str);
    }
    this.a.a("Bubble_download", parambatm.b(), str, 0L);
    super.onStart(parambatm);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alnf
 * JD-Core Version:    0.7.0.1
 */