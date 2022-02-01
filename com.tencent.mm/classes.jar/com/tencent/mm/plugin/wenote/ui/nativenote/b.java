package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.bh;
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
  private View rSI;
  private View rSJ;
  private TextView titleTv;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(30810);
    this.titleTv = null;
    if (this.view != null)
    {
      this.titleTv = ((TextView)this.view.findViewById(R.h.eaV));
      this.rSI = this.view.findViewById(R.h.eaW);
      this.rSJ = this.view.findViewById(R.h.banner_root);
      this.titleTv.setTextSize(0, com.tencent.mm.ci.a.aY(this.titleTv.getContext(), R.f.HintTextSize));
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30809);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("WNNoteBanner", "click WNNoteBanner");
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.hdC().hdD();
          if (paramAnonymousView == null)
          {
            Log.i("WNNoteBanner", "keepTopItem is null");
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
  
  public final boolean ckL()
  {
    AppMethodBeat.i(30812);
    try
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.h.hdC().hdD() != null)
      {
        long l = System.currentTimeMillis();
        bh.beI();
        if (l - ((Long)c.aHp().get(ar.a.Vqm, Long.valueOf(0L))).longValue() > 86400000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(18728, new Object[] { Integer.valueOf(1) });
          bh.beI();
          c.aHp().set(ar.a.Vqm, Long.valueOf(l));
        }
      }
      Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.hdC().hdD();
      if ((this.isFirst) && (this.kUc))
      {
        this.rSJ.setBackgroundResource(R.g.tips_bar_white_selector);
        this.rSI.setBackground(null);
        this.titleTv.setBackground(null);
        if ((localObject == null) || (!((q)localObject).QHj) || (((q)localObject).QHl <= 0L) || (Util.isNullOrNil(((q)localObject).QHn))) {
          break label321;
        }
      }
      for (i = 1;; i = 1)
      {
        if (i == 0) {
          break label350;
        }
        localObject = ((q)localObject).QHm;
        if (this.titleTv != null) {
          this.titleTv.setText((CharSequence)localObject);
        }
        setVisibility(0);
        AppMethodBeat.o(30812);
        return true;
        if (this.isFirst)
        {
          this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
          this.rSI.setBackgroundResource(R.g.list_item_top_normal);
          this.titleTv.setBackgroundResource(R.g.list_item_normal);
          break;
        }
        if (this.kUc)
        {
          this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
          this.rSI.setBackgroundResource(R.g.list_item_normal);
          this.titleTv.setBackground(null);
          break;
        }
        this.rSJ.setBackgroundResource(R.g.list_item_top_selector);
        this.rSI.setBackground(null);
        this.titleTv.setBackgroundResource(R.g.list_item_normal);
        break;
        label321:
        if ((localObject == null) || (((q)localObject).QHj) || (f.Po(((q)localObject).QHk) == null)) {
          break label381;
        }
      }
      label350:
      if (localObject != null) {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.h.hdC().c(null);
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
        label381:
        int i = 0;
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.eaW;
  }
  
  public final int getOrder()
  {
    return 0;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(30811);
    if (this.view != null) {
      this.view.findViewById(R.h.eaW).setVisibility(paramInt);
    }
    AppMethodBeat.o(30811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b
 * JD-Core Version:    0.7.0.1
 */