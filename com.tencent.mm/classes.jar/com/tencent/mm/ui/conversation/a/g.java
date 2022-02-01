package com.tencent.mm.ui.conversation.a;

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
import com.tencent.mm.ui.f.e;
import java.lang.ref.WeakReference;

public final class g
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  String HDR;
  boolean Wwx;
  String XFg;
  
  public g(Context paramContext, final String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(38781);
    this.HDR = null;
    this.XFg = null;
    this.Wwx = false;
    this.HDR = paramString1;
    this.XFg = paramString2;
    this.Wwx = paramBoolean;
    if (this.view != null)
    {
      paramContext = (TextView)this.view.findViewById(R.h.dzg);
      paramString1 = bh.beI().bcl().aY(this.HDR, "wording");
      paramString2 = bh.beI().bcl().aY(this.XFg, "wording");
      if (Util.isNullOrNil(paramString1)) {
        break label207;
      }
      paramContext.setText(paramString1);
    }
    for (;;)
    {
      paramContext = bh.beI().bcl().aY(this.HDR, "linkname");
      paramString1 = bh.beI().bcl().aY(this.HDR, "linksrc");
      paramString2 = (TextView)this.view.findViewById(R.h.dzf);
      if (!Util.isNullOrNil(paramContext)) {
        paramString2.setText(paramContext);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38779);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("k_username", g.this.HDR);
          int i = 39;
          if (g.this.Wwx) {
            i = 36;
          }
          paramAnonymousView.putExtra("showShare", false);
          if (!Util.isNullOrNil(paramString1)) {
            paramAnonymousView.putExtra("rawUrl", paramString1);
          }
          for (;;)
          {
            if (g.this.Rhc.get() != null) {
              com.tencent.mm.by.c.b((Context)g.this.Rhc.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
            bh.beI().bcl().Sr(g.this.HDR);
            bh.beI().bcl().Sr(g.this.XFg);
            a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38779);
            return;
            paramAnonymousView.putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(i) }));
          }
        }
      });
      ((ImageView)this.view.findViewById(R.h.dze)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38780);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          bh.beI().bcl().Sr(g.this.HDR);
          bh.beI().bcl().Sr(g.this.XFg);
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
    return R.i.eeG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.g
 * JD-Core Version:    0.7.0.1
 */