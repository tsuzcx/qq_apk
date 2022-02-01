package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.aq;
import java.util.List;

public final class y
  extends LinearLayout
{
  private List<String> Kmg;
  private a KoL;
  private b KoM;
  private Context context;
  private LinearLayout rEk;
  
  public y(Context paramContext, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37926);
    this.rEk = null;
    this.context = paramContext;
    this.KoL = parama;
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194556);
        y localy = y.this;
        ba.aBQ();
        y.a(localy, c.azp().fqs());
        y.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194555);
            if ((y.a(y.this) == null) || (y.a(y.this).size() <= 0))
            {
              ad.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
              AppMethodBeat.o(194555);
              return;
            }
            y.a(y.this).remove("wework");
            ad.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", new Object[] { Integer.valueOf(y.a(y.this).size()) });
            if (y.b(y.this) == null)
            {
              View.inflate(y.this.getContext(), 2131495057, y.this);
              y.a(y.this, (LinearLayout)y.this.findViewById(2131298736));
            }
            y.b(y.this).removeAllViews();
            int i = 0;
            if (i < y.a(y.this).size())
            {
              Object localObject = (String)y.a(y.this).get(i);
              localObject = new z(y.this.getContext(), (String)localObject);
              y.b(y.this).addView((View)localObject);
              if (i == y.a(y.this).size() - 1)
              {
                localObject = ((z)localObject).findViewById(2131299501);
                int j = ((View)localObject).getPaddingLeft();
                ((View)localObject).setBackground(aq.aM(y.c(y.this), 2130969245));
                ((View)localObject).findViewById(2131299503).setBackground(null);
                ((View)localObject).setPadding(j, 0, 0, 0);
              }
              for (;;)
              {
                i += 1;
                break;
                ((z)localObject).findViewById(2131299501).setBackground(null);
                ((z)localObject).findViewById(2131299501).findViewById(2131299503).setBackground(aq.aM(y.c(y.this), 2130969245));
              }
            }
            y.d(y.this).aek(y.a(y.this).size());
            AppMethodBeat.o(194555);
          }
        });
        AppMethodBeat.o(194556);
      }
    });
    AppMethodBeat.o(37926);
  }
  
  public final int getOpenIMCount()
  {
    AppMethodBeat.i(37927);
    if (this.Kmg == null)
    {
      AppMethodBeat.o(37927);
      return 0;
    }
    int i = this.Kmg.size();
    AppMethodBeat.o(37927);
    return i;
  }
  
  public final void setOnVisibilityChangeListener(b paramb)
  {
    this.KoM = paramb;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(37929);
    b localb;
    if ((this.KoM != null) && (paramInt != getVisibility()))
    {
      localb = this.KoM;
      if (paramInt != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localb.yk(bool);
      super.setVisibility(paramInt);
      AppMethodBeat.o(37929);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aek(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void yk(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.y
 * JD-Core Version:    0.7.0.1
 */