package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.f;
import java.lang.ref.WeakReference;

public final class g
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  String NBt;
  boolean aedO;
  String afte;
  
  public g(Context paramContext, final String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(38781);
    this.NBt = null;
    this.afte = null;
    this.aedO = false;
    this.NBt = paramString1;
    this.afte = paramString2;
    this.aedO = paramBoolean;
    if (this.view != null)
    {
      paramContext = (TextView)this.view.findViewById(R.h.fzY);
      paramString1 = bh.bCz().bAa().bi(this.NBt, "wording");
      paramString2 = bh.bCz().bAa().bi(this.afte, "wording");
      if (Util.isNullOrNil(paramString1)) {
        break label207;
      }
      paramContext.setText(paramString1);
    }
    for (;;)
    {
      paramContext = bh.bCz().bAa().bi(this.NBt, "linkname");
      paramString1 = bh.bCz().bAa().bi(this.NBt, "linksrc");
      paramString2 = (TextView)this.view.findViewById(R.h.fzX);
      if (!Util.isNullOrNil(paramContext)) {
        paramString2.setText(paramContext);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38779);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("k_username", g.this.NBt);
          int i = 39;
          if (g.this.aedO) {
            i = 36;
          }
          paramAnonymousView.putExtra("showShare", false);
          if (!Util.isNullOrNil(paramString1)) {
            paramAnonymousView.putExtra("rawUrl", paramString1);
          }
          for (;;)
          {
            if (g.this.Ydi.get() != null) {
              com.tencent.mm.br.c.b((Context)g.this.Ydi.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
            bh.bCz().bAa().Kt(g.this.NBt);
            bh.bCz().bAa().Kt(g.this.afte);
            a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38779);
            return;
            paramAnonymousView.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(i) }));
          }
        }
      });
      ((ImageView)this.view.findViewById(R.h.fzW)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38780);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          bh.bCz().bAa().Kt(g.this.NBt);
          bh.bCz().bAa().Kt(g.this.afte);
          a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38780);
        }
      });
      AppMethodBeat.o(38781);
      return;
      label207:
      if (!Util.isNullOrNil(paramString2)) {
        paramContext.setText(paramString2);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.ghw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.g
 * JD-Core Version:    0.7.0.1
 */