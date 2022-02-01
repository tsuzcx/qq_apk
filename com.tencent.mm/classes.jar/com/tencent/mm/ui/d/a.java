package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  boolean ONP;
  b.b ONQ;
  String ONR;
  String mUrl;
  String mWording;
  
  public a(Context paramContext, b.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(33849);
    this.mWording = null;
    this.mUrl = null;
    this.ONP = false;
    this.ONQ = null;
    this.ONR = "";
    this.ONQ = paramb;
    setVisibility(8);
    refresh();
    AppMethodBeat.o(33849);
  }
  
  private void refresh()
  {
    AppMethodBeat.i(33850);
    setVisibility(8);
    h.RTc.aY(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(232758);
        bg.aVF().aTo();
        final boolean bool = com.tencent.mm.model.b.b.a(a.this.ONQ);
        h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232757);
            if (bool)
            {
              Log.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[] { a.this.ONQ, a.this.mWording, a.this.mUrl, Boolean.valueOf(a.this.ONP) });
              Object localObject1;
              Object localObject2;
              if (a.this.ONQ == b.b.iGK)
              {
                localObject1 = a.this;
                bg.aVF().aTo();
                ((a)localObject1).mWording = com.tencent.mm.model.b.b.aWZ();
                localObject1 = a.this;
                bg.aVF().aTo();
                ((a)localObject1).mUrl = com.tencent.mm.model.b.b.aXa();
                localObject1 = a.this;
                bg.aVF().aTo();
                ((a)localObject1).ONP = com.tencent.mm.model.b.b.aXb();
                localObject2 = (TextView)a.this.getView().findViewById(2131298514);
                localObject1 = (ImageView)a.this.getView().findViewById(2131298778);
                if (Util.isNullOrNil(a.this.mWording)) {
                  break label499;
                }
                ((TextView)localObject2).setText(a.this.mWording);
                label228:
                ((TextView)localObject2).setSelected(true);
                if (Util.isNullOrNil(a.this.mUrl)) {
                  break label508;
                }
                a.this.getView().findViewById(2131304852).setBackgroundResource(2131235299);
                ((ImageView)localObject1).setImageResource(2131234021);
                ((TextView)localObject2).setTextColor(MMApplicationContext.getContext().getResources().getColor(2131099683));
              }
              for (;;)
              {
                a.this.getView().setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(232755);
                    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymous3View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                    a.a(a.this, 1);
                    paramAnonymous3View = a.this;
                    localObject = a.this.mUrl;
                    if (Util.isNullOrNil((String)localObject)) {
                      Log.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
                    }
                    for (;;)
                    {
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(232755);
                      return;
                      Intent localIntent = new Intent();
                      localIntent.putExtra("rawUrl", (String)localObject);
                      localIntent.putExtra("showShare", false);
                      localIntent.putExtra("show_bottom", false);
                      com.tencent.mm.br.c.b((Context)paramAnonymous3View.Kgr.get(), "webview", ".ui.tools.WebViewUI", localIntent);
                    }
                  }
                });
                if (a.this.getView().getVisibility() != 0)
                {
                  localObject2 = a.this;
                  StringBuilder localStringBuilder = new StringBuilder();
                  g.aAf();
                  ((a)localObject2).ONR = (com.tencent.mm.kernel.a.getUin() + "_" + System.currentTimeMillis());
                  a.a(a.this, 0);
                }
                a.this.setVisibility(0);
                if (!a.this.ONP) {
                  break label552;
                }
                ((ImageView)localObject1).setVisibility(0);
                ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(232756);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bm(paramAnonymous3View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    Log.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
                    a.a(a.this, 2);
                    bg.aVF().aTo().c(b.b.iGJ);
                    bg.aVF().aTo().c(b.b.iGK);
                    a.this.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232756);
                  }
                });
                AppMethodBeat.o(232757);
                return;
                localObject1 = a.this;
                bg.aVF().aTo();
                ((a)localObject1).mWording = com.tencent.mm.model.b.b.aWW();
                localObject1 = a.this;
                bg.aVF().aTo();
                ((a)localObject1).mUrl = com.tencent.mm.model.b.b.aWX();
                localObject1 = a.this;
                bg.aVF().aTo();
                ((a)localObject1).ONP = com.tencent.mm.model.b.b.aWY();
                break;
                label499:
                ((TextView)localObject2).setText(2131756029);
                break label228;
                label508:
                a.this.getView().findViewById(2131304852).setBackgroundResource(2131101263);
                ((ImageView)localObject1).setImageResource(2131234020);
                ((TextView)localObject2).setTextColor(MMApplicationContext.getContext().getResources().getColor(2131101427));
              }
              label552:
              ((ImageView)localObject1).setVisibility(8);
              AppMethodBeat.o(232757);
              return;
            }
            Log.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
            a.this.setVisibility(8);
            AppMethodBeat.o(232757);
          }
        });
        AppMethodBeat.o(232758);
      }
    });
    AppMethodBeat.o(33850);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(33852);
    refresh();
    boolean bool = super.bYa();
    AppMethodBeat.o(33852);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131493627;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(33851);
    super.setVisibility(paramInt);
    getView().findViewById(2131304852).setVisibility(paramInt);
    AppMethodBeat.o(33851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.d.a
 * JD-Core Version:    0.7.0.1
 */