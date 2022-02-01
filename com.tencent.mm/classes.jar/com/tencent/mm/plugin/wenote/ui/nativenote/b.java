package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class b
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private View oQL;
  private View oQM;
  private TextView titleTv;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(30810);
    this.titleTv = null;
    if (this.view != null)
    {
      this.titleTv = ((TextView)this.view.findViewById(2131310472));
      this.oQL = this.view.findViewById(2131310473);
      this.oQM = this.view.findViewById(2131297327);
      this.titleTv.setTextSize(0, com.tencent.mm.cb.a.aG(this.titleTv.getContext(), 2131165482));
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30809);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("WNNoteBanner", "click WNNoteBanner");
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().gjP();
          if (paramAnonymousView == null)
          {
            Log.i("WNNoteBanner", "keepTopItem is null");
            b.this.setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30809);
            return;
          }
          com.tencent.mm.plugin.wenote.b.a.a(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30809);
        }
      });
    }
    AppMethodBeat.o(30810);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(30812);
    try
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().gjP() != null)
      {
        long l = System.currentTimeMillis();
        bg.aVF();
        if (l - ((Long)c.azQ().get(ar.a.Ocj, Long.valueOf(0L))).longValue() > 86400000L)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(18728, new Object[] { Integer.valueOf(1) });
          bg.aVF();
          c.azQ().set(ar.a.Ocj, Long.valueOf(l));
        }
      }
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().gjP();
      if ((this.isFirst) && (this.ifo))
      {
        this.oQM.setBackgroundResource(2131235299);
        this.oQL.setBackground(null);
        this.titleTv.setBackground(null);
        if ((localObject == null) || (!((q)localObject).JHR) || (((q)localObject).JHT <= 0L) || (Util.isNullOrNil(((q)localObject).JHV))) {
          break label313;
        }
      }
      for (i = 1;; i = 1)
      {
        if (i == 0) {
          break label342;
        }
        localObject = ((q)localObject).JHU;
        if (this.titleTv != null) {
          this.titleTv.setText((CharSequence)localObject);
        }
        setVisibility(0);
        AppMethodBeat.o(30812);
        return true;
        if (this.isFirst)
        {
          this.oQM.setBackgroundResource(2131233332);
          this.oQL.setBackgroundResource(2131233330);
          this.titleTv.setBackgroundResource(2131233327);
          break;
        }
        if (this.ifo)
        {
          this.oQM.setBackgroundResource(2131233332);
          this.oQL.setBackgroundResource(2131233327);
          this.titleTv.setBackground(null);
          break;
        }
        this.oQM.setBackgroundResource(2131233332);
        this.oQL.setBackground(null);
        this.titleTv.setBackgroundResource(2131233327);
        break;
        label313:
        if ((localObject == null) || (((q)localObject).JHR) || (f.HT(((q)localObject).JHS) == null)) {
          break label373;
        }
      }
      label342:
      if (localObject != null) {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.h.gjO().c(null);
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
    return 2131497090;
  }
  
  public final int getOrder()
  {
    return 0;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(30811);
    if (this.view != null) {
      this.view.findViewById(2131310473).setVisibility(paramInt);
    }
    AppMethodBeat.o(30811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b
 * JD-Core Version:    0.7.0.1
 */