import com.tencent.mobileqq.text.AppleEmojiManager;
import java.io.File;

public final class ahzl
  implements Runnable
{
  public ahzl(File paramFile1, File paramFile2, File paramFile3) {}
  
  public void run()
  {
    if (this.a.exists()) {
      this.a.delete();
    }
    if (this.b.exists()) {
      this.b.delete();
    }
    AppleEmojiManager.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahzl
 * JD-Core Version:    0.7.0.1
 */