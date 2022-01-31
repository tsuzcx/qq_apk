import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerRecallListener;

public class acax
  implements EmojiStickerManager.StickerRecallListener
{
  public acax(MessengerService paramMessengerService) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.a != null) {
      EmojiStickerManager.a().a(this.a.a, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acax
 * JD-Core Version:    0.7.0.1
 */