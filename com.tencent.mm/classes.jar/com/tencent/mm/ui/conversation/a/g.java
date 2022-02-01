package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e.e;
import java.lang.ref.WeakReference;

public final class g
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  String PdV;
  boolean Pdm;
  String QhV;
  
  public g(Context paramContext, final String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(38781);
    this.PdV = null;
    this.QhV = null;
    this.Pdm = false;
    this.PdV = paramString1;
    this.QhV = paramString2;
    this.Pdm = paramBoolean;
    if (this.view != null)
    {
      paramContext = (TextView)this.view.findViewById(2131298546);
      paramString1 = bg.aVF().aTn().aU(this.PdV, "wording");
      paramString2 = bg.aVF().aTn().aU(this.QhV, "wording");
      if (Util.isNullOrNil(paramString1)) {
        break label204;
      }
      paramContext.setText(paramString1);
    }
    for (;;)
    {
      paramContext = bg.aVF().aTn().aU(this.PdV, "linkname");
      paramString1 = bg.aVF().aTn().aU(this.PdV, "linksrc");
      paramString2 = (TextView)this.view.findViewById(2131298545);
      if (!Util.isNullOrNil(paramContext)) {
        paramString2.setText(paramContext);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38779);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("k_username", g.this.PdV);
          int i = 39;
          if (g.this.Pdm) {
            i = 36;
          }
          paramAnonymousView.putExtra("showShare", false);
          if (!Util.isNullOrNil(paramString1)) {
            paramAnonymousView.putExtra("rawUrl", paramString1);
          }
          for (;;)
          {
            if (g.this.Kgr.get() != null) {
              com.tencent.mm.br.c.b((Context)g.this.Kgr.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
            bg.aVF().aTn().KY(g.this.PdV);
            bg.aVF().aTn().KY(g.this.QhV);
            a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38779);
            return;
            paramAnonymousView.putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(i) }));
          }
        }
      });
      ((ImageView)this.view.findViewById(2131298544)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38780);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          bg.aVF().aTn().KY(g.this.PdV);
          bg.aVF().aTn().KY(g.this.QhV);
          a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38780);
        }
      });
      AppMethodBeat.o(38781);
      return;
      label204:
      if (!Util.isNullOrNil(paramString2)) {
        paramContext.setText(paramString2);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131493630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.g
 * JD-Core Version:    0.7.0.1
 */