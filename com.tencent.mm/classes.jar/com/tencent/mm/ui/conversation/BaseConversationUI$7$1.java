package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.tencent.mm.sdk.platformtools.y;

final class BaseConversationUI$7$1
  implements View.OnApplyWindowInsetsListener
{
  BaseConversationUI$7$1(BaseConversationUI.7 param7) {}
  
  @TargetApi(20)
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    if (paramWindowInsets == null) {
      return paramWindowInsets;
    }
    y.i("MicroMsg.BaseConversationUI", "OnApplyWindowInsetsListener %s", new Object[] { paramWindowInsets });
    paramWindowInsets.consumeSystemWindowInsets();
    BaseConversationUI.access$1300(this.vPk.vPi, this.vPk.uPZ, paramWindowInsets.getSystemWindowInsetTop(), new Rect(paramWindowInsets.getSystemWindowInsetLeft(), paramWindowInsets.getSystemWindowInsetTop(), paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom()), this.vPk.uQa);
    return paramWindowInsets;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.7.1
 * JD-Core Version:    0.7.0.1
 */