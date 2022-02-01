package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.aq;
import java.util.List;

public final class y
  extends LinearLayout
{
  private List<String> KIA;
  private a KLf;
  private b KLg;
  private Context context;
  private LinearLayout rMv;
  
  public y(Context paramContext, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37926);
    this.rMv = null;
    this.context = paramContext;
    this.KLf = parama;
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187957);
        y localy = y.this;
        bc.aCg();
        y.a(localy, c.azF().fus());
        y.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187956);
            if ((y.a(y.this) == null) || (y.a(y.this).size() <= 0))
            {
              ae.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
              AppMethodBeat.o(187956);
              return;
            }
            y.a(y.this).remove("wework");
            ae.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", new Object[] { Integer.valueOf(y.a(y.this).size()) });
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
            y.d(y.this).aeT(y.a(y.this).size());
            AppMethodBeat.o(187956);
          }
        });
        AppMethodBeat.o(187957);
      }
    });
    AppMethodBeat.o(37926);
  }
  
  public final int getOpenIMCount()
  {
    AppMethodBeat.i(37927);
    if (this.KIA == null)
    {
      AppMethodBeat.o(37927);
      return 0;
    }
    int i = this.KIA.size();
    AppMethodBeat.o(37927);
    return i;
  }
  
  public final void setOnVisibilityChangeListener(b paramb)
  {
    this.KLg = paramb;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(37929);
    b localb;
    if ((this.KLg != null) && (paramInt != getVisibility()))
    {
      localb = this.KLg;
      if (paramInt != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localb.yx(bool);
      super.setVisibility(paramInt);
      AppMethodBeat.o(37929);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aeT(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void yx(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.y
 * JD-Core Version:    0.7.0.1
 */