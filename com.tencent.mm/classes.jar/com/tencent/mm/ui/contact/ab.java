package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.d;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bd;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.List;

public final class ab
  extends LinearLayout
{
  private LinearLayout Api;
  private List<String> afdO;
  private a afgW;
  private b afgX;
  private Context context;
  
  public ab(Context paramContext, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37926);
    this.Api = null;
    this.context = paramContext;
    this.afgW = parama;
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252937);
        ab localab = ab.this;
        bh.bCz();
        ab.a(localab, c.bzA().iZS());
        ab.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(253012);
            if ((ab.a(ab.this) == null) || (ab.a(ab.this).size() <= 0))
            {
              Log.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
              AppMethodBeat.o(253012);
              return;
            }
            ab.a(ab.this).remove("wework");
            Log.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", new Object[] { Integer.valueOf(ab.a(ab.this).size()) });
            if (ab.b(ab.this) == null)
            {
              View.inflate(ab.this.getContext(), R.i.gmP, ab.this);
              ab.a(ab.this, (LinearLayout)ab.this.findViewById(R.h.container));
            }
            ab.b(ab.this).removeAllViews();
            int i = 0;
            if (i < ab.a(ab.this).size())
            {
              Object localObject = (String)ab.a(ab.this).get(i);
              localObject = new ac(ab.this.getContext(), (String)localObject);
              ab.b(ab.this).addView((View)localObject);
              if (i == ab.a(ab.this).size() - 1)
              {
                localObject = ((ac)localObject).findViewById(R.h.fGJ);
                int j = ((View)localObject).getPaddingLeft();
                ((View)localObject).setBackground(bd.by(ab.c(ab.this), R.d.list_item_divider));
                ((View)localObject).findViewById(R.h.fGL).setBackground(null);
                ((View)localObject).setPadding(j, 0, 0, 0);
              }
              for (;;)
              {
                i += 1;
                break;
                ((ac)localObject).findViewById(R.h.fGJ).setBackground(null);
                ((ac)localObject).findViewById(R.h.fGJ).findViewById(R.h.fGL).setBackground(bd.by(ab.c(ab.this), R.d.list_item_divider));
              }
            }
            ab.d(ab.this).onOpenIMListHeaderViewChange(ab.a(ab.this).size());
            AppMethodBeat.o(253012);
          }
        });
        AppMethodBeat.o(252937);
      }
    });
    AppMethodBeat.o(37926);
  }
  
  public final int getOpenIMCount()
  {
    AppMethodBeat.i(37927);
    if (this.afdO == null)
    {
      AppMethodBeat.o(37927);
      return 0;
    }
    int i = this.afdO.size();
    AppMethodBeat.o(37927);
    return i;
  }
  
  public final void setOnVisibilityChangeListener(b paramb)
  {
    this.afgX = paramb;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(37929);
    b localb;
    if ((this.afgX != null) && (paramInt != getVisibility()))
    {
      localb = this.afgX;
      if (paramInt != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localb.onVisibilityChange(bool);
      super.setVisibility(paramInt);
      AppMethodBeat.o(37929);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onOpenIMListHeaderViewChange(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void onVisibilityChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ab
 * JD-Core Version:    0.7.0.1
 */