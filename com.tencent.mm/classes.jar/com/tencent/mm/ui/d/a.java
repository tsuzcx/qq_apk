package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  boolean WgW;
  b.b WgX;
  String WgY;
  String mUrl;
  String mWording;
  
  public a(Context paramContext, b.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(33849);
    this.mWording = null;
    this.mUrl = null;
    this.WgW = false;
    this.WgX = null;
    this.WgY = "";
    this.WgX = paramb;
    setVisibility(8);
    bfU();
    AppMethodBeat.o(33849);
  }
  
  private void bfU()
  {
    AppMethodBeat.i(33850);
    setVisibility(8);
    com.tencent.e.h.ZvG.bf(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(288681);
        bh.beI().bcm();
        final boolean bool = com.tencent.mm.model.b.b.a(a.this.WgX);
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(290670);
            if (bool)
            {
              Log.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[] { a.this.WgX, a.this.mWording, a.this.mUrl, Boolean.valueOf(a.this.WgW) });
              Object localObject1;
              Object localObject2;
              if (a.this.WgX == b.b.lwM)
              {
                localObject1 = a.this;
                bh.beI().bcm();
                ((a)localObject1).mWording = com.tencent.mm.model.b.b.bgg();
                localObject1 = a.this;
                bh.beI().bcm();
                ((a)localObject1).mUrl = com.tencent.mm.model.b.b.bgh();
                localObject1 = a.this;
                bh.beI().bcm();
                ((a)localObject1).WgW = com.tencent.mm.model.b.b.bgi();
                localObject2 = (TextView)a.this.getView().findViewById(R.h.dyH);
                localObject1 = (ImageView)a.this.getView().findViewById(R.h.close_icon);
                if (Util.isNullOrNil(a.this.mWording)) {
                  break label505;
                }
                ((TextView)localObject2).setText(a.this.mWording);
                label230:
                ((TextView)localObject2).setSelected(true);
                if (Util.isNullOrNil(a.this.mUrl)) {
                  break label515;
                }
                a.this.getView().findViewById(R.h.dMK).setBackgroundResource(R.g.tips_bar_white_selector);
                ((ImageView)localObject1).setImageResource(R.g.dnZ);
                ((TextView)localObject2).setTextColor(MMApplicationContext.getContext().getResources().getColor(R.e.BW_50));
              }
              for (;;)
              {
                a.this.getView().setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(291056);
                    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymous3View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                    a.a(a.this, 1);
                    paramAnonymous3View = a.this;
                    localObject = a.this.mUrl;
                    if (Util.isNullOrNil((String)localObject)) {
                      Log.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
                    }
                    for (;;)
                    {
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(291056);
                      return;
                      Intent localIntent = new Intent();
                      localIntent.putExtra("rawUrl", (String)localObject);
                      localIntent.putExtra("showShare", false);
                      localIntent.putExtra("show_bottom", false);
                      com.tencent.mm.by.c.b((Context)paramAnonymous3View.Rhc.get(), "webview", ".ui.tools.WebViewUI", localIntent);
                    }
                  }
                });
                if (a.this.getView().getVisibility() != 0)
                {
                  localObject2 = a.this;
                  StringBuilder localStringBuilder = new StringBuilder();
                  com.tencent.mm.kernel.h.aHE();
                  ((a)localObject2).WgY = (com.tencent.mm.kernel.b.getUin() + "_" + System.currentTimeMillis());
                  a.a(a.this, 0);
                }
                a.this.setVisibility(0);
                if (!a.this.WgW) {
                  break label563;
                }
                ((ImageView)localObject1).setVisibility(0);
                ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(258469);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bn(paramAnonymous3View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                    Log.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
                    a.a(a.this, 2);
                    bh.beI().bcm().c(b.b.lwL);
                    bh.beI().bcm().c(b.b.lwM);
                    a.this.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(258469);
                  }
                });
                AppMethodBeat.o(290670);
                return;
                localObject1 = a.this;
                bh.beI().bcm();
                ((a)localObject1).mWording = com.tencent.mm.model.b.b.bgd();
                localObject1 = a.this;
                bh.beI().bcm();
                ((a)localObject1).mUrl = com.tencent.mm.model.b.b.bge();
                localObject1 = a.this;
                bh.beI().bcm();
                ((a)localObject1).WgW = com.tencent.mm.model.b.b.bgf();
                break;
                label505:
                ((TextView)localObject2).setText(R.l.app_waiting);
                break label230;
                label515:
                a.this.getView().findViewById(R.h.dMK).setBackgroundResource(R.e.tipsbar_black_bg_color);
                ((ImageView)localObject1).setImageResource(R.g.dnY);
                ((TextView)localObject2).setTextColor(MMApplicationContext.getContext().getResources().getColor(R.e.white_text_color));
              }
              label563:
              ((ImageView)localObject1).setVisibility(8);
              AppMethodBeat.o(290670);
              return;
            }
            Log.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
            a.this.setVisibility(8);
            AppMethodBeat.o(290670);
          }
        });
        AppMethodBeat.o(288681);
      }
    });
    AppMethodBeat.o(33850);
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(33852);
    bfU();
    boolean bool = super.ckL();
    AppMethodBeat.o(33852);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.eeD;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(33851);
    super.setVisibility(paramInt);
    getView().findViewById(R.h.dMK).setVisibility(paramInt);
    AppMethodBeat.o(33851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.d.a
 * JD-Core Version:    0.7.0.1
 */