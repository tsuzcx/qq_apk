package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public final class g
  extends b
{
  boolean HJB;
  String HKj;
  String IHf;
  
  public g(Context paramContext, final String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(38781);
    this.HKj = null;
    this.IHf = null;
    this.HJB = false;
    this.HKj = paramString1;
    this.IHf = paramString2;
    this.HJB = paramBoolean;
    if (this.view != null)
    {
      paramContext = (TextView)this.view.findViewById(2131298167);
      paramString1 = az.ayM().axa().aP(this.HKj, "wording");
      paramString2 = az.ayM().axa().aP(this.IHf, "wording");
      if (bs.isNullOrNil(paramString1)) {
        break label204;
      }
      paramContext.setText(paramString1);
    }
    for (;;)
    {
      paramContext = az.ayM().axa().aP(this.HKj, "linkname");
      paramString1 = az.ayM().axa().aP(this.HKj, "linksrc");
      paramString2 = (TextView)this.view.findViewById(2131298166);
      if (!bs.isNullOrNil(paramContext)) {
        paramString2.setText(paramContext);
      }
      paramString2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38779);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("k_username", g.this.HKj);
          int i = 39;
          if (g.this.HJB) {
            i = 36;
          }
          paramAnonymousView.putExtra("showShare", false);
          if (!bs.isNullOrNil(paramString1)) {
            paramAnonymousView.putExtra("rawUrl", paramString1);
          }
          for (;;)
          {
            if (g.this.Dsc.get() != null) {
              com.tencent.mm.br.d.b((Context)g.this.Dsc.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
            az.ayM().axa().yM(g.this.HKj);
            az.ayM().axa().yM(g.this.IHf);
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
          az.ayM().axa().yM(g.this.HKj);
          az.ayM().axa().yM(g.this.IHf);
          AppMethodBeat.o(38780);
        }
      });
      AppMethodBeat.o(38781);
      return;
      label204:
      if (!bs.isNullOrNil(paramString2)) {
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