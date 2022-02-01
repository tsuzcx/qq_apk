package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class b
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private View mZW;
  private View mZX;
  private TextView titleTv;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(30810);
    this.titleTv = null;
    if (this.view != null)
    {
      this.titleTv = ((TextView)this.view.findViewById(2131306972));
      this.mZW = this.view.findViewById(2131306973);
      this.mZX = this.view.findViewById(2131297183);
      this.titleTv.setTextSize(0, a.au(this.titleTv.getContext(), 2131165466));
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30809);
          ac.i("WNNoteBanner", "click WNNoteBanner");
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eIe().eIf();
          if (paramAnonymousView == null)
          {
            ac.i("WNNoteBanner", "keepTopItem is null");
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
  
  public final boolean bvU()
  {
    AppMethodBeat.i(30812);
    try
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eIe().eIf() != null)
      {
        long l = System.currentTimeMillis();
        az.ayM();
        if (l - ((Long)c.agA().get(ah.a.GNf, Long.valueOf(0L))).longValue() > 86400000L)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(18728, new Object[] { Integer.valueOf(1) });
          az.ayM();
          c.agA().set(ah.a.GNf, Long.valueOf(l));
        }
      }
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eIe().eIf();
      if ((this.isFirst) && (this.gRm))
      {
        this.mZX.setBackgroundResource(2131234377);
        this.mZW.setBackground(null);
        this.titleTv.setBackground(null);
        if ((localObject == null) || (!((q)localObject).CVL) || (((q)localObject).CVN <= 0L) || (bs.isNullOrNil(((q)localObject).CVP))) {
          break label313;
        }
      }
      for (i = 1;; i = 1)
      {
        if (i == 0) {
          break label342;
        }
        localObject = ((q)localObject).CVO;
        if (this.titleTv != null) {
          this.titleTv.setText((CharSequence)localObject);
        }
        setVisibility(0);
        AppMethodBeat.o(30812);
        return true;
        if (this.isFirst)
        {
          this.mZX.setBackgroundResource(2131232872);
          this.mZW.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
          break;
        }
        if (this.gRm)
        {
          this.mZX.setBackgroundResource(2131232872);
          this.mZW.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
          break;
        }
        this.mZX.setBackgroundResource(2131232872);
        this.mZW.setBackground(null);
        this.titleTv.setBackgroundResource(2131232867);
        break;
        label313:
        if ((localObject == null) || (((q)localObject).CVL) || (f.ws(((q)localObject).CVM) == null)) {
          break label373;
        }
      }
      label342:
      if (localObject != null) {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.h.eIe().c(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b
 * JD-Core Version:    0.7.0.1
 */