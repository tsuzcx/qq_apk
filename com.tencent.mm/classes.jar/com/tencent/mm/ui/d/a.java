package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  boolean JCX;
  b.b JCY;
  String JCZ;
  String mUrl;
  String mWording;
  
  public a(Context paramContext, b.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(33849);
    this.mWording = null;
    this.mUrl = null;
    this.JCX = false;
    this.JCY = null;
    this.JCZ = "";
    this.JCY = paramb;
    setVisibility(8);
    refresh();
    AppMethodBeat.o(33849);
  }
  
  private void refresh()
  {
    AppMethodBeat.i(33850);
    setVisibility(8);
    h.MqF.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187074);
        bc.aCg().aAg();
        final boolean bool = com.tencent.mm.model.b.b.a(a.this.JCY);
        h.MqF.aM(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187073);
            if (bool)
            {
              ae.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[] { a.this.JCY, a.this.mWording, a.this.mUrl, Boolean.valueOf(a.this.JCX) });
              Object localObject1;
              Object localObject2;
              if (a.this.JCY == b.b.hLI)
              {
                localObject1 = a.this;
                bc.aCg().aAg();
                ((a)localObject1).mWording = com.tencent.mm.model.b.b.aDn();
                localObject1 = a.this;
                bc.aCg().aAg();
                ((a)localObject1).mUrl = com.tencent.mm.model.b.b.aDo();
                localObject1 = a.this;
                bc.aCg().aAg();
                ((a)localObject1).JCX = com.tencent.mm.model.b.b.aDp();
                localObject2 = (TextView)a.this.getView().findViewById(2131298151);
                localObject1 = (ImageView)a.this.getView().findViewById(2131298370);
                if (bu.isNullOrNil(a.this.mWording)) {
                  break label499;
                }
                ((TextView)localObject2).setText(a.this.mWording);
                label228:
                ((TextView)localObject2).setSelected(true);
                if (bu.isNullOrNil(a.this.mUrl)) {
                  break label508;
                }
                a.this.getView().findViewById(2131302449).setBackgroundResource(2131234377);
                ((ImageView)localObject1).setImageResource(2131233342);
                ((TextView)localObject2).setTextColor(ak.getContext().getResources().getColor(2131099676));
              }
              for (;;)
              {
                a.this.getView().setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(187071);
                    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymous3View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                    a.a(a.this, 1);
                    paramAnonymous3View = a.this;
                    localObject = a.this.mUrl;
                    if (bu.isNullOrNil((String)localObject)) {
                      ae.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
                    }
                    for (;;)
                    {
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(187071);
                      return;
                      Intent localIntent = new Intent();
                      localIntent.putExtra("rawUrl", (String)localObject);
                      localIntent.putExtra("showShare", false);
                      localIntent.putExtra("show_bottom", false);
                      d.b((Context)paramAnonymous3View.FpA.get(), "webview", ".ui.tools.WebViewUI", localIntent);
                    }
                  }
                });
                if (a.this.getView().getVisibility() != 0)
                {
                  localObject2 = a.this;
                  StringBuilder localStringBuilder = new StringBuilder();
                  g.ajP();
                  ((a)localObject2).JCZ = (com.tencent.mm.kernel.a.getUin() + "_" + System.currentTimeMillis());
                  a.a(a.this, 0);
                }
                a.this.setVisibility(0);
                if (!a.this.JCX) {
                  break label552;
                }
                ((ImageView)localObject1).setVisibility(0);
                ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(187072);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymous3View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                    ae.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
                    a.a(a.this, 2);
                    bc.aCg().aAg().c(b.b.hLH);
                    bc.aCg().aAg().c(b.b.hLI);
                    a.this.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(187072);
                  }
                });
                AppMethodBeat.o(187073);
                return;
                localObject1 = a.this;
                bc.aCg().aAg();
                ((a)localObject1).mWording = com.tencent.mm.model.b.b.aDk();
                localObject1 = a.this;
                bc.aCg().aAg();
                ((a)localObject1).mUrl = com.tencent.mm.model.b.b.aDl();
                localObject1 = a.this;
                bc.aCg().aAg();
                ((a)localObject1).JCX = com.tencent.mm.model.b.b.aDm();
                break;
                label499:
                ((TextView)localObject2).setText(2131755936);
                break label228;
                label508:
                a.this.getView().findViewById(2131302449).setBackgroundResource(2131101030);
                ((ImageView)localObject1).setImageResource(2131233341);
                ((TextView)localObject2).setTextColor(ak.getContext().getResources().getColor(2131101182));
              }
              label552:
              ((ImageView)localObject1).setVisibility(8);
              AppMethodBeat.o(187073);
              return;
            }
            ae.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
            a.this.setVisibility(8);
            AppMethodBeat.o(187073);
          }
        });
        AppMethodBeat.o(187074);
      }
    });
    AppMethodBeat.o(33850);
  }
  
  public final boolean bAV()
  {
    AppMethodBeat.i(33852);
    refresh();
    boolean bool = super.bAV();
    AppMethodBeat.o(33852);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131493516;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(33851);
    super.setVisibility(paramInt);
    getView().findViewById(2131302449).setVisibility(paramInt);
    AppMethodBeat.o(33851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.d.a
 * JD-Core Version:    0.7.0.1
 */