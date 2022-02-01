package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

final class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(221400);
    if (this.Ofn)
    {
      ad.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[] { this.Ofo.Jip.Jin, this.Ofo.Jip.mWording, this.Ofo.Jip.mUrl, Boolean.valueOf(this.Ofo.Jip.Jim) });
      Object localObject1;
      Object localObject2;
      if (this.Ofo.Jip.Jin == b.b.hIP)
      {
        localObject1 = this.Ofo.Jip;
        ba.aBQ().azQ();
        ((a)localObject1).mWording = com.tencent.mm.model.b.b.aCX();
        localObject1 = this.Ofo.Jip;
        ba.aBQ().azQ();
        ((a)localObject1).mUrl = com.tencent.mm.model.b.b.aCY();
        localObject1 = this.Ofo.Jip;
        ba.aBQ().azQ();
        ((a)localObject1).Jim = com.tencent.mm.model.b.b.aCZ();
        localObject2 = (TextView)this.Ofo.Jip.getView().findViewById(2131298151);
        localObject1 = (ImageView)this.Ofo.Jip.getView().findViewById(2131298370);
        if (bt.isNullOrNil(this.Ofo.Jip.mWording)) {
          break label499;
        }
        ((TextView)localObject2).setText(this.Ofo.Jip.mWording);
        label228:
        ((TextView)localObject2).setSelected(true);
        if (bt.isNullOrNil(this.Ofo.Jip.mUrl)) {
          break label508;
        }
        this.Ofo.Jip.getView().findViewById(2131302449).setBackgroundResource(2131234377);
        ((ImageView)localObject1).setImageResource(2131233342);
        ((TextView)localObject2).setTextColor(aj.getContext().getResources().getColor(2131099676));
      }
      for (;;)
      {
        this.Ofo.Jip.getView().setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(221398);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            a.a(a.1.1.this.Ofo.Jip, 1);
            paramAnonymousView = a.1.1.this.Ofo.Jip;
            localObject = a.1.1.this.Ofo.Jip.mUrl;
            if (bt.isNullOrNil((String)localObject)) {
              ad.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(221398);
              return;
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", (String)localObject);
              localIntent.putExtra("showShare", false);
              localIntent.putExtra("show_bottom", false);
              d.b((Context)paramAnonymousView.EXg.get(), "webview", ".ui.tools.WebViewUI", localIntent);
            }
          }
        });
        if (this.Ofo.Jip.getView().getVisibility() != 0)
        {
          localObject2 = this.Ofo.Jip;
          StringBuilder localStringBuilder = new StringBuilder();
          g.ajA();
          ((a)localObject2).Jio = (com.tencent.mm.kernel.a.getUin() + "_" + System.currentTimeMillis());
          a.a(this.Ofo.Jip, 0);
        }
        this.Ofo.Jip.setVisibility(0);
        if (!this.Ofo.Jip.Jim) {
          break label552;
        }
        ((ImageView)localObject1).setVisibility(0);
        ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(221399);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
            a.a(a.1.1.this.Ofo.Jip, 2);
            ba.aBQ().azQ().c(b.b.hIO);
            ba.aBQ().azQ().c(b.b.hIP);
            a.1.1.this.Ofo.Jip.setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/banner/ChattingMonitoredBanner$1$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(221399);
          }
        });
        AppMethodBeat.o(221400);
        return;
        localObject1 = this.Ofo.Jip;
        ba.aBQ().azQ();
        ((a)localObject1).mWording = com.tencent.mm.model.b.b.aCU();
        localObject1 = this.Ofo.Jip;
        ba.aBQ().azQ();
        ((a)localObject1).mUrl = com.tencent.mm.model.b.b.aCV();
        localObject1 = this.Ofo.Jip;
        ba.aBQ().azQ();
        ((a)localObject1).Jim = com.tencent.mm.model.b.b.aCW();
        break;
        label499:
        ((TextView)localObject2).setText(2131755936);
        break label228;
        label508:
        this.Ofo.Jip.getView().findViewById(2131302449).setBackgroundResource(2131101030);
        ((ImageView)localObject1).setImageResource(2131233341);
        ((TextView)localObject2).setTextColor(aj.getContext().getResources().getColor(2131101182));
      }
      label552:
      ((ImageView)localObject1).setVisibility(8);
      AppMethodBeat.o(221400);
      return;
    }
    ad.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
    this.Ofo.Jip.setVisibility(8);
    AppMethodBeat.o(221400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.d.a.1.1
 * JD-Core Version:    0.7.0.1
 */