package com.tencent.mm.ui.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  String DhI;
  boolean adNS;
  b.b adNT;
  String mUrl;
  String mWording;
  
  public a(Context paramContext, b.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(33849);
    this.mWording = null;
    this.mUrl = null;
    this.adNS = false;
    this.adNT = null;
    this.DhI = "";
    this.adNT = paramb;
    setVisibility(8);
    bDL();
    AppMethodBeat.o(33849);
  }
  
  private void bDL()
  {
    AppMethodBeat.i(33850);
    setVisibility(8);
    com.tencent.threadpool.h.ahAA.bn(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249618);
        bh.bCz().bAb();
        final boolean bool = com.tencent.mm.model.b.b.a(a.this.adNT);
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249625);
            if (bool)
            {
              Log.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[] { a.this.adNT, a.this.mWording, a.this.mUrl, Boolean.valueOf(a.this.adNS) });
              Object localObject1;
              Object localObject2;
              if (a.this.adNT == b.b.ool)
              {
                localObject1 = a.this;
                bh.bCz().bAb();
                ((a)localObject1).mWording = com.tencent.mm.model.b.b.bDX();
                localObject1 = a.this;
                bh.bCz().bAb();
                ((a)localObject1).mUrl = com.tencent.mm.model.b.b.bDY();
                localObject1 = a.this;
                bh.bCz().bAb();
                ((a)localObject1).adNS = com.tencent.mm.model.b.b.bDZ();
                localObject2 = (TextView)a.this.getView().findViewById(R.h.fzr);
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
                a.this.getView().findViewById(R.h.fOu).setBackgroundResource(R.g.tips_bar_white_selector);
                ((ImageView)localObject1).setImageResource(R.g.fox);
                ((TextView)localObject2).setTextColor(MMApplicationContext.getContext().getResources().getColor(R.e.BW_50));
              }
              for (;;)
              {
                a.this.getView().setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(249621);
                    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymous3View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                    a.a(a.this, 1);
                    paramAnonymous3View = a.this;
                    localObject = a.this.mUrl;
                    if (Util.isNullOrNil((String)localObject)) {
                      Log.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
                    }
                    for (;;)
                    {
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(249621);
                      return;
                      Intent localIntent = new Intent();
                      localIntent.putExtra("rawUrl", (String)localObject);
                      localIntent.putExtra("showShare", false);
                      localIntent.putExtra("show_bottom", false);
                      com.tencent.mm.br.c.b((Context)paramAnonymous3View.Ydi.get(), "webview", ".ui.tools.WebViewUI", localIntent);
                    }
                  }
                });
                if (a.this.getView().getVisibility() != 0)
                {
                  localObject2 = a.this;
                  StringBuilder localStringBuilder = new StringBuilder();
                  com.tencent.mm.kernel.h.baC();
                  ((a)localObject2).DhI = (com.tencent.mm.kernel.b.getUin() + "_" + System.currentTimeMillis());
                  a.a(a.this, 0);
                }
                a.this.setVisibility(0);
                if (!a.this.adNS) {
                  break label563;
                }
                ((ImageView)localObject1).setVisibility(0);
                ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous3View)
                  {
                    AppMethodBeat.i(249628);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.cH(paramAnonymous3View);
                    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                    Log.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
                    a.a(a.this, 2);
                    bh.bCz().bAb().c(b.b.ook);
                    bh.bCz().bAb().c(b.b.ool);
                    a.this.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(249628);
                  }
                });
                AppMethodBeat.o(249625);
                return;
                localObject1 = a.this;
                bh.bCz().bAb();
                ((a)localObject1).mWording = com.tencent.mm.model.b.b.bDU();
                localObject1 = a.this;
                bh.bCz().bAb();
                ((a)localObject1).mUrl = com.tencent.mm.model.b.b.bDV();
                localObject1 = a.this;
                bh.bCz().bAb();
                ((a)localObject1).adNS = com.tencent.mm.model.b.b.bDW();
                break;
                label505:
                ((TextView)localObject2).setText(R.l.app_waiting);
                break label230;
                label515:
                a.this.getView().findViewById(R.h.fOu).setBackgroundResource(R.e.tipsbar_black_bg_color);
                ((ImageView)localObject1).setImageResource(R.g.fow);
                ((TextView)localObject2).setTextColor(MMApplicationContext.getContext().getResources().getColor(R.e.white_text_color));
              }
              label563:
              ((ImageView)localObject1).setVisibility(8);
              AppMethodBeat.o(249625);
              return;
            }
            Log.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
            a.this.setVisibility(8);
            AppMethodBeat.o(249625);
          }
        });
        AppMethodBeat.o(249618);
      }
    });
    AppMethodBeat.o(33850);
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(33852);
    bDL();
    boolean bool = super.cMa();
    AppMethodBeat.o(33852);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.ght;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(33851);
    super.setVisibility(paramInt);
    getView().findViewById(R.h.fOu).setVisibility(paramInt);
    AppMethodBeat.o(33851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.c.a
 * JD-Core Version:    0.7.0.1
 */