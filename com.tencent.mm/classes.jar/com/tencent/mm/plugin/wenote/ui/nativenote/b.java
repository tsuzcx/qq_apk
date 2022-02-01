package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class b
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private View nFO;
  private View nFP;
  private TextView titleTv;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(30810);
    this.titleTv = null;
    if (this.view != null)
    {
      this.titleTv = ((TextView)this.view.findViewById(2131306972));
      this.nFO = this.view.findViewById(2131306973);
      this.nFP = this.view.findViewById(2131297183);
      this.titleTv.setTextSize(0, com.tencent.mm.cb.a.ax(this.titleTv.getContext(), 2131165466));
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30809);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("WNNoteBanner", "click WNNoteBanner");
          paramAnonymousView = h.faJ().faK();
          if (paramAnonymousView == null)
          {
            ae.i("WNNoteBanner", "keepTopItem is null");
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
  
  public final boolean bAV()
  {
    AppMethodBeat.i(30812);
    try
    {
      if (h.faJ().faK() != null)
      {
        long l = System.currentTimeMillis();
        bc.aCg();
        if (l - ((Long)c.ajA().get(am.a.ITV, Long.valueOf(0L))).longValue() > 86400000L)
        {
          g.yxI.f(18728, new Object[] { Integer.valueOf(1) });
          bc.aCg();
          c.ajA().set(am.a.ITV, Long.valueOf(l));
        }
      }
      Object localObject = h.faJ().faK();
      if ((this.isFirst) && (this.hms))
      {
        this.nFP.setBackgroundResource(2131234377);
        this.nFO.setBackground(null);
        this.titleTv.setBackground(null);
        if ((localObject == null) || (!((q)localObject).ESe) || (((q)localObject).ESg <= 0L) || (bu.isNullOrNil(((q)localObject).ESi))) {
          break label313;
        }
      }
      for (i = 1;; i = 1)
      {
        if (i == 0) {
          break label342;
        }
        localObject = ((q)localObject).ESh;
        if (this.titleTv != null) {
          this.titleTv.setText((CharSequence)localObject);
        }
        setVisibility(0);
        AppMethodBeat.o(30812);
        return true;
        if (this.isFirst)
        {
          this.nFP.setBackgroundResource(2131232872);
          this.nFO.setBackgroundResource(2131232870);
          this.titleTv.setBackgroundResource(2131232867);
          break;
        }
        if (this.hms)
        {
          this.nFP.setBackgroundResource(2131232872);
          this.nFO.setBackgroundResource(2131232867);
          this.titleTv.setBackground(null);
          break;
        }
        this.nFP.setBackgroundResource(2131232872);
        this.nFO.setBackground(null);
        this.titleTv.setBackgroundResource(2131232867);
        break;
        label313:
        if ((localObject == null) || (((q)localObject).ESe) || (f.zd(((q)localObject).ESf) == null)) {
          break label373;
        }
      }
      label342:
      if (localObject != null) {
        h.faJ().c(null);
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