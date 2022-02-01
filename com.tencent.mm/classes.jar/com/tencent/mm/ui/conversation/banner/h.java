package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.ui.MMFBFriendUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.lang.ref.WeakReference;

public final class h
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38783);
    if (this.view != null) {
      this.view.findViewById(R.h.facebook_tips_content).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38782);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          bh.bCz();
          c.ban().B(65833, Integer.valueOf(0));
          paramAnonymousView = (Context)h.this.Ydi.get();
          localObject = new Intent((Context)h.this.Ydi.get(), MMFBFriendUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          h.this.view.setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38782);
        }
      });
    }
    AppMethodBeat.o(38783);
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(38784);
    if (com.tencent.mm.au.b.bKL())
    {
      bh.bCz();
      if (Util.nullAs((Integer)c.ban().d(65833, null), 0) > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        i = R.i.facebook_tips_btn;
        AppMethodBeat.o(38784);
        return i;
      }
    }
    AppMethodBeat.o(38784);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.h
 * JD-Core Version:    0.7.0.1
 */