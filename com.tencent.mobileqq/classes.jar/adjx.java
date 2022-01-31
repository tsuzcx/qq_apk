import android.os.Bundle;
import com.tencent.mobileqq.flashchat.FlashChatObserver;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;

public class adjx
  extends FlashChatObserver
{
  public adjx(FlashChatTextEffectView paramFlashChatTextEffectView) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    if (paramBoolean) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjx
 * JD-Core Version:    0.7.0.1
 */