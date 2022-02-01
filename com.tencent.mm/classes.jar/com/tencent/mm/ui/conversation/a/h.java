package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.storage.aj;
import java.lang.ref.WeakReference;

public final class h
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38783);
    if (this.view != null) {
      this.view.findViewById(2131299735).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38782);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          bc.aCg();
          c.ajA().set(65833, Integer.valueOf(0));
          paramAnonymousView = (Context)h.this.FpA.get();
          localObject = new Intent((Context)h.this.FpA.get(), FacebookFriendUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    com.tencent.mm.aw.b.aJE();
    AppMethodBeat.o(38784);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.h
 * JD-Core Version:    0.7.0.1
 */