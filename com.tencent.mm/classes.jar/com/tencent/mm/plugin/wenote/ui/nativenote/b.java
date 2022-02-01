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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class b
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  private TextView titleTv;
  private View vdX;
  private View vdY;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(30810);
    this.titleTv = null;
    if (this.view != null)
    {
      this.titleTv = ((TextView)this.view.findViewById(R.h.gdz));
      this.vdX = this.view.findViewById(R.h.gdA);
      this.vdY = this.view.findViewById(R.h.banner_root);
      this.titleTv.setTextSize(0, com.tencent.mm.cd.a.br(this.titleTv.getContext(), R.f.HintTextSize));
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30809);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("WNNoteBanner", "click WNNoteBanner");
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.iEj().iEk();
          if (paramAnonymousView == null)
          {
            Log.i("WNNoteBanner", "keepTopItem is null");
            b.this.setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(30809);
            return;
          }
          com.tencent.mm.plugin.wenote.a.b.a(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30809);
        }
      });
    }
    AppMethodBeat.o(30810);
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(30812);
    try
    {
      if (com.tencent.mm.plugin.wenote.model.nativenote.manager.h.iEj().iEk() != null)
      {
        long l = System.currentTimeMillis();
        bh.bCz();
        if (l - ((Long)c.ban().get(at.a.acRO, Long.valueOf(0L))).longValue() > 86400000L)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(18728, new Object[] { Integer.valueOf(1) });
          bh.bCz();
          c.ban().set(at.a.acRO, Long.valueOf(l));
        }
      }
      Object localObject1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.iEj().iEk();
      if ((this.isFirst) && (this.nzL))
      {
        this.vdY.setBackgroundResource(R.g.tips_bar_white_selector);
        this.vdX.setBackground(null);
        this.titleTv.setBackground(null);
        if ((localObject1 == null) || (!((q)localObject1).XAH) || (((q)localObject1).XAJ <= 0L) || (Util.isNullOrNil(((q)localObject1).XAL))) {
          break label321;
        }
      }
      for (i = 1;; i = 1)
      {
        if (i == 0) {
          break label350;
        }
        localObject1 = ((q)localObject1).XAK;
        if (this.titleTv != null) {
          this.titleTv.setText((CharSequence)localObject1);
        }
        setVisibility(0);
        AppMethodBeat.o(30812);
        return true;
        if (this.isFirst)
        {
          this.vdY.setBackgroundResource(R.g.list_item_top_selector);
          this.vdX.setBackgroundResource(R.g.list_item_top_normal);
          this.titleTv.setBackgroundResource(R.g.list_item_normal);
          break;
        }
        if (this.nzL)
        {
          this.vdY.setBackgroundResource(R.g.list_item_top_selector);
          this.vdX.setBackgroundResource(R.g.list_item_normal);
          this.titleTv.setBackground(null);
          break;
        }
        this.vdY.setBackgroundResource(R.g.list_item_top_selector);
        this.vdX.setBackground(null);
        this.titleTv.setBackgroundResource(R.g.list_item_normal);
        break;
        label321:
        if ((localObject1 == null) || (((q)localObject1).XAH) || (f.to(((q)localObject1).XAI) == null)) {
          break label381;
        }
      }
      label350:
      if (localObject1 != null) {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.h.iEj().c(null);
      }
      setVisibility(8);
      AppMethodBeat.o(30812);
      return false;
    }
    finally
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
    return R.i.gdA;
  }
  
  public final int getOrder()
  {
    return 0;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(30811);
    if (this.view != null) {
      this.view.findViewById(R.h.gdA).setVisibility(paramInt);
    }
    AppMethodBeat.o(30811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b
 * JD-Core Version:    0.7.0.1
 */