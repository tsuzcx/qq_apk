package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class b
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private TextView eXr = null;
  
  public b(Context paramContext)
  {
    super(paramContext);
    if (this.view != null)
    {
      this.eXr = ((TextView)this.view.findViewById(R.h.wenote_banner_text_view));
      this.eXr.setTextSize(0, a.aa(this.eXr.getContext(), R.f.HintTextSize));
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          y.i("WNNoteBanner", "click WNNoteBanner");
          paramAnonymousView = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.cir().cis();
          if (paramAnonymousView == null)
          {
            y.i("WNNoteBanner", "keepTopItem is null");
            b.this.setVisibility(8);
            return;
          }
          if (paramAnonymousView.rGL)
          {
            if (paramAnonymousView.kay) {
              com.tencent.mm.plugin.report.service.h.nFQ.f(14789, new Object[] { Integer.valueOf(3) });
            }
            for (;;)
            {
              y.i("WNNoteBanner", "isOpenFromSession: true");
              localObject = new j();
              c.chu().rFh = ((d)localObject);
              localyl = new yl();
              localyl.scene = 8;
              ((j)localObject).a(paramAnonymousView.rGP, Long.valueOf(paramAnonymousView.rGN), true, (Context)b.this.sdy.get(), paramAnonymousView.rGQ, paramAnonymousView.rGR, localyl);
              return;
              com.tencent.mm.plugin.report.service.h.nFQ.f(14789, new Object[] { Integer.valueOf(2) });
            }
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(14789, new Object[] { Integer.valueOf(1) });
          y.i("WNNoteBanner", "isOpenFromSession: false");
          Object localObject = new g();
          c.chu().rFh = ((d)localObject);
          yl localyl = new yl();
          localyl.scene = 8;
          ((g)localObject).a(paramAnonymousView.rGM, (Context)b.this.sdy.get(), Boolean.valueOf(true), paramAnonymousView.rGQ, paramAnonymousView.rGR, localyl, null);
        }
      });
    }
  }
  
  public final boolean apu()
  {
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.cir().cis();
    int i;
    if ((localObject != null) && (((q)localObject).rGL) && (((q)localObject).rGN > 0L) && (!bk.bl(((q)localObject).rGP))) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = ((q)localObject).rGO;
        if (this.eXr != null) {
          this.eXr.setText((CharSequence)localObject);
        }
        setVisibility(0);
        return true;
        if ((localObject != null) && (!((q)localObject).rGL) && (f.fu(((q)localObject).rGM) != null)) {
          i = 1;
        }
      }
      else
      {
        if (localObject != null) {
          com.tencent.mm.plugin.wenote.model.nativenote.manager.h.cir().a(null);
        }
        setVisibility(8);
        return false;
      }
      i = 0;
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.wenote_banner_view;
  }
  
  public final int getOrder()
  {
    return 0;
  }
  
  public final void setVisibility(int paramInt)
  {
    if (this.view != null) {
      this.view.findViewById(R.h.wenote_banner_view).setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b
 * JD-Core Version:    0.7.0.1
 */