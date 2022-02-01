package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class b
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private View mxV;
  private View mxW;
  private TextView titleTv;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(30810);
    this.titleTv = null;
    if (this.view != null)
    {
      this.titleTv = ((TextView)this.view.findViewById(2131306972));
      this.mxV = this.view.findViewById(2131306973);
      this.mxW = this.view.findViewById(2131297183);
      this.titleTv.setTextSize(0, a.ao(this.titleTv.getContext(), 2131165466));
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30809);
          ad.i("WNNoteBanner", "click WNNoteBanner");
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.esL().esM();
          if (paramAnonymousView == null)
          {
            ad.i("WNNoteBanner", "keepTopItem is null");
            b.this.setVisibility(8);
            AppMethodBeat.o(30809);
            return;
          }
          com.tencent.mm.plugin.wenote.b.b.a(paramAnonymousView);
          AppMethodBeat.o(30809);
        }
      });
    }
    AppMethodBeat.o(30810);
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(30812);
    try
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.h.esL().esM() != null)
      {
        long l = System.currentTimeMillis();
        az.arV();
        if (l - ((Long)c.afk().get(ae.a.Fpp, Long.valueOf(0L))).longValue() > 86400000L)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(18728, new Object[] { Integer.valueOf(1) });
          az.arV();
          c.afk().set(ae.a.Fpp, Long.valueOf(l));
        }
      }
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.esL().esM();
      if ((this.isFirst) && (this.gqE))
      {
        this.mxW.setBackgroundResource(2131234377);
        this.mxV.setBackground(null);
        this.titleTv.setBackground(null);
        if ((localObject == null) || (!((q)localObject).BDF) || (((q)localObject).BDH <= 0L) || (bt.isNullOrNil(((q)localObject).BDJ))) {
          break label313;
        }
      }
      for (i = 1;; i = 1)
      {
        if (i == 0) {
          break label342;
        }
        localObject = ((q)localObject).BDI;
        if (this.titleTv != null) {
          this.titleTv.setText((CharSequence)localObject);
        }
        setVisibility(0);
        AppMethodBeat.o(30812);
        return true;
        if (this.isFirst)
        {
          this.mxW.setBackgroundResource(2131232872);
          this.mxV.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
          break;
        }
        if (this.gqE)
        {
          this.mxW.setBackgroundResource(2131232872);
          this.mxV.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
          break;
        }
        this.mxW.setBackgroundResource(2131232872);
        this.mxV.setBackground(null);
        this.titleTv.setBackgroundResource(2131232867);
        break;
        label313:
        if ((localObject == null) || (((q)localObject).BDF) || (f.rP(((q)localObject).BDG) == null)) {
          break label373;
        }
      }
      label342:
      if (localObject != null) {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.h.esL().c(null);
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