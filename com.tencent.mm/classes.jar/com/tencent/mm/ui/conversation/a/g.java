package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class g
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  boolean Jxs;
  String Jya;
  String Kyl;
  
  public g(Context paramContext, final String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(38781);
    this.Jya = null;
    this.Kyl = null;
    this.Jxs = false;
    this.Jya = paramString1;
    this.Kyl = paramString2;
    this.Jxs = paramBoolean;
    if (this.view != null)
    {
      paramContext = (TextView)this.view.findViewById(2131298167);
      paramString1 = ba.aBQ().azP().aQ(this.Jya, "wording");
      paramString2 = ba.aBQ().azP().aQ(this.Kyl, "wording");
      if (bt.isNullOrNil(paramString1)) {
        break label204;
      }
      paramContext.setText(paramString1);
    }
    for (;;)
    {
      paramContext = ba.aBQ().azP().aQ(this.Jya, "linkname");
      paramString1 = ba.aBQ().azP().aQ(this.Jya, "linksrc");
      paramString2 = (TextView)this.view.findViewById(2131298166);
      if (!bt.isNullOrNil(paramContext)) {
        paramString2.setText(paramContext);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38779);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("k_username", g.this.Jya);
          int i = 39;
          if (g.this.Jxs) {
            i = 36;
          }
          paramAnonymousView.putExtra("showShare", false);
          if (!bt.isNullOrNil(paramString1)) {
            paramAnonymousView.putExtra("rawUrl", paramString1);
          }
          for (;;)
          {
            if (g.this.EXg.get() != null) {
              com.tencent.mm.bs.d.b((Context)g.this.EXg.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
            ba.aBQ().azP().BL(g.this.Jya);
            ba.aBQ().azP().BL(g.this.Kyl);
            a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38779);
            return;
            paramAnonymousView.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
          }
        }
      });
      ((ImageView)this.view.findViewById(2131298165)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38780);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ba.aBQ().azP().BL(g.this.Jya);
          ba.aBQ().azP().BL(g.this.Kyl);
          a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38780);
        }
      });
      AppMethodBeat.o(38781);
      return;
      label204:
      if (!bt.isNullOrNil(paramString2)) {
        paramContext.setText(paramString2);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131493518;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.g
 * JD-Core Version:    0.7.0.1
 */