package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class b
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private View nAt;
  private View nAu;
  private TextView titleTv;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(30810);
    this.titleTv = null;
    if (this.view != null)
    {
      this.titleTv = ((TextView)this.view.findViewById(2131306972));
      this.nAt = this.view.findViewById(2131306973);
      this.nAu = this.view.findViewById(2131297183);
      this.titleTv.setTextSize(0, com.tencent.mm.cc.a.ax(this.titleTv.getContext(), 2131165466));
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30809);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("WNNoteBanner", "click WNNoteBanner");
          paramAnonymousView = h.eWX().eWY();
          if (paramAnonymousView == null)
          {
            ad.i("WNNoteBanner", "keepTopItem is null");
            b.this.setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30809);
            return;
          }
          com.tencent.mm.plugin.wenote.b.b.a(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30809);
        }
      });
    }
    AppMethodBeat.o(30810);
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(30812);
    try
    {
      if (h.eWX().eWY() != null)
      {
        long l = System.currentTimeMillis();
        ba.aBQ();
        if (l - ((Long)c.ajl().get(al.a.Izw, Long.valueOf(0L))).longValue() > 86400000L)
        {
          g.yhR.f(18728, new Object[] { Integer.valueOf(1) });
          ba.aBQ();
          c.ajl().set(al.a.Izw, Long.valueOf(l));
        }
      }
      Object localObject = h.eWX().eWY();
      if ((this.isFirst) && (this.hjE))
      {
        this.nAu.setBackgroundResource(2131234377);
        this.nAt.setBackground(null);
        this.titleTv.setBackground(null);
        if ((localObject == null) || (!((q)localObject).EzI) || (((q)localObject).EzK <= 0L) || (bt.isNullOrNil(((q)localObject).EzM))) {
          break label313;
        }
      }
      for (i = 1;; i = 1)
      {
        if (i == 0) {
          break label342;
        }
        localObject = ((q)localObject).EzL;
        if (this.titleTv != null) {
          this.titleTv.setText((CharSequence)localObject);
        }
        setVisibility(0);
        AppMethodBeat.o(30812);
        return true;
        if (this.isFirst)
        {
          this.nAu.setBackgroundResource(2131232872);
          this.nAt.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
          break;
        }
        if (this.hjE)
        {
          this.nAu.setBackgroundResource(2131232872);
          this.nAt.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
          break;
        }
        this.nAu.setBackgroundResource(2131232872);
        this.nAt.setBackground(null);
        this.titleTv.setBackgroundResource(2131232867);
        break;
        label313:
        if ((localObject == null) || (((q)localObject).EzI) || (f.yE(((q)localObject).EzJ) == null)) {
          break label373;
        }
      }
      label342:
      if (localObject != null) {
        h.eWX().c(null);
      }
      setVisibility(8);
      AppMethodBeat.o(30812);
      return false;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        continue;
        label373:
        int i = 0;
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131496102;
  }
  
  public final int getOrder()
  {
    return 0;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(30811);
    if (this.view != null) {
      this.view.findViewById(2131306973).setVisibility(paramInt);
    }
    AppMethodBeat.o(30811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b
 * JD-Core Version:    0.7.0.1
 */