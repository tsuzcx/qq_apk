import android.content.Intent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class aepz
  implements apry
{
  public aepz(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public void a(View paramView)
  {
    String str = bdtg.a("aioEmojiStickerDetail");
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof ChatXListView)) {
      EmojiStickerManager.k = ((ChatXListView)localViewParent).getPositionForView(paramView);
    }
    paramView = new Intent(this.a.a.getApp(), QQBrowserActivity.class);
    paramView.setFlags(268435456);
    paramView.putExtra("vasUsePreWebview", true);
    VasWebviewUtil.openQQBrowserWithoutAD(this.a.a.getApp(), str, -1L, paramView, false, -1);
    int i;
    if (EmojiStickerManager.a().a == 0) {
      i = 1;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.a.c(), "Stick", "ClickDetail", String.valueOf(i), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
      if (EmojiStickerManager.a().a == 1) {
        i = 2;
      } else if (EmojiStickerManager.a().a == 3000) {
        i = 3;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepz
 * JD-Core Version:    0.7.0.1
 */