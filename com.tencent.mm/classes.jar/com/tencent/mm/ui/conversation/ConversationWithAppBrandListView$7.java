package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationWithAppBrandListView$7
  implements a.a
{
  ConversationWithAppBrandListView$7(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void fn(boolean paramBoolean)
  {
    AppMethodBeat.i(34273);
    ab.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onShowEmptyView show: %b, isOpenAppBrandRecentView: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(ConversationWithAppBrandListView.g(this.AjJ)) });
    ConversationWithAppBrandListView.d(this.AjJ, paramBoolean);
    if (ConversationWithAppBrandListView.h(this.AjJ))
    {
      ConversationWithAppBrandListView.c(this.AjJ, true);
      ConversationWithAppBrandListView.b(this.AjJ, true);
    }
    if (!ConversationWithAppBrandListView.g(this.AjJ))
    {
      AppMethodBeat.o(34273);
      return;
    }
    if ((ConversationWithAppBrandListView.i(this.AjJ) != null) && (paramBoolean)) {
      ConversationWithAppBrandListView.i(this.AjJ).setTranslationY(0.0F);
    }
    if ((ConversationWithAppBrandListView.j(this.AjJ) != null) && (paramBoolean)) {
      ConversationWithAppBrandListView.j(this.AjJ).setTranslationY(0.0F);
    }
    AppMethodBeat.o(34273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.7
 * JD-Core Version:    0.7.0.1
 */