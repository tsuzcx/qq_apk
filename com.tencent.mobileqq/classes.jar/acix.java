import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerRecallListener;

public class acix
  implements EmojiStickerManager.StickerRecallListener
{
  public acix(MessengerService paramMessengerService) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.a != null) {
      EmojiStickerManager.a().a(this.a.a, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acix
 * JD-Core Version:    0.7.0.1
 */