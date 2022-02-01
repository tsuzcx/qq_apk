package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.at;
import java.util.List;

public final class y
  extends LinearLayout
{
  private List<String> PVy;
  private a PYg;
  private b PYh;
  private Context context;
  private LinearLayout tmh;
  
  public y(Context paramContext, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37926);
    this.tmh = null;
    this.context = paramContext;
    this.PYg = parama;
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234015);
        y localy = y.this;
        bg.aVF();
        y.a(localy, c.aSN().gBY());
        y.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(234014);
            if ((y.a(y.this) == null) || (y.a(y.this).size() <= 0))
            {
              Log.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
              AppMethodBeat.o(234014);
              return;
            }
            y.a(y.this).remove("wework");
            Log.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", new Object[] { Integer.valueOf(y.a(y.this).size()) });
            if (y.b(y.this) == null)
            {
              View.inflate(y.this.getContext(), 2131495891, y.this);
              y.a(y.this, (LinearLayout)y.this.findViewById(2131299174));
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
                localObject = ((z)localObject).findViewById(2131300138);
                int j = ((View)localObject).getPaddingLeft();
                ((View)localObject).setBackground(at.aN(y.c(y.this), 2130969285));
                ((View)localObject).findViewById(2131300140).setBackground(null);
                ((View)localObject).setPadding(j, 0, 0, 0);
              }
              for (;;)
              {
                i += 1;
                break;
                ((z)localObject).findViewById(2131300138).setBackground(null);
                ((z)localObject).findViewById(2131300138).findViewById(2131300140).setBackground(at.aN(y.c(y.this), 2130969285));
              }
            }
            y.d(y.this).anE(y.a(y.this).size());
            AppMethodBeat.o(234014);
          }
        });
        AppMethodBeat.o(234015);
      }
    });
    AppMethodBeat.o(37926);
  }
  
  public final int getOpenIMCount()
  {
    AppMethodBeat.i(37927);
    if (this.PVy == null)
    {
      AppMethodBeat.o(37927);
      return 0;
    }
    int i = this.PVy.size();
    AppMethodBeat.o(37927);
    return i;
  }
  
  public final void setOnVisibilityChangeListener(b paramb)
  {
    this.PYh = paramb;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(37929);
    b localb;
    if ((this.PYh != null) && (paramInt != getVisibility()))
    {
      localb = this.PYh;
      if (paramInt != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localb.Cm(bool);
      super.setVisibility(paramInt);
      AppMethodBeat.o(37929);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void anE(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void Cm(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.y
 * JD-Core Version:    0.7.0.1
 */