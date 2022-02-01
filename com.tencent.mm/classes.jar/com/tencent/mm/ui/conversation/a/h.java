package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.storage.ao;
import java.lang.ref.WeakReference;

public final class h
  extends com.tencent.mm.pluginsdk.ui.b.b
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          bh.beI();
          c.aHp().i(65833, Integer.valueOf(0));
          paramAnonymousView = (Context)h.this.Rhc.get();
          localObject = new Intent((Context)h.this.Rhc.get(), FacebookFriendUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
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
    com.tencent.mm.az.b.bmZ();
    AppMethodBeat.o(38784);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.h
 * JD-Core Version:    0.7.0.1
 */