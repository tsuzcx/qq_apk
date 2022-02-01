package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.d;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aw;
import java.util.List;

public final class aa
  extends LinearLayout
{
  private List<String> Xsn;
  private a XuY;
  private b XuZ;
  private Context context;
  private LinearLayout wSF;
  
  public aa(Context paramContext, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37926);
    this.wSF = null;
    this.context = paramContext;
    this.XuY = parama;
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(288732);
        aa localaa = aa.this;
        bh.beI();
        aa.a(localaa, c.bbL().hyk());
        aa.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(232351);
            if ((aa.a(aa.this) == null) || (aa.a(aa.this).size() <= 0))
            {
              Log.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
              AppMethodBeat.o(232351);
              return;
            }
            aa.a(aa.this).remove("wework");
            Log.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", new Object[] { Integer.valueOf(aa.a(aa.this).size()) });
            if (aa.b(aa.this) == null)
            {
              View.inflate(aa.this.getContext(), R.i.ejM, aa.this);
              aa.a(aa.this, (LinearLayout)aa.this.findViewById(R.h.container));
            }
            aa.b(aa.this).removeAllViews();
            int i = 0;
            if (i < aa.a(aa.this).size())
            {
              Object localObject = (String)aa.a(aa.this).get(i);
              localObject = new ab(aa.this.getContext(), (String)localObject);
              aa.b(aa.this).addView((View)localObject);
              if (i == aa.a(aa.this).size() - 1)
              {
                localObject = ((ab)localObject).findViewById(R.h.dFD);
                int j = ((View)localObject).getPaddingLeft();
                ((View)localObject).setBackground(aw.bf(aa.c(aa.this), R.d.list_item_divider));
                ((View)localObject).findViewById(R.h.dFF).setBackground(null);
                ((View)localObject).setPadding(j, 0, 0, 0);
              }
              for (;;)
              {
                i += 1;
                break;
                ((ab)localObject).findViewById(R.h.dFD).setBackground(null);
                ((ab)localObject).findViewById(R.h.dFD).findViewById(R.h.dFF).setBackground(aw.bf(aa.c(aa.this), R.d.list_item_divider));
              }
            }
            aa.d(aa.this).awK(aa.a(aa.this).size());
            AppMethodBeat.o(232351);
          }
        });
        AppMethodBeat.o(288732);
      }
    });
    AppMethodBeat.o(37926);
  }
  
  public final int getOpenIMCount()
  {
    AppMethodBeat.i(37927);
    if (this.Xsn == null)
    {
      AppMethodBeat.o(37927);
      return 0;
    }
    int i = this.Xsn.size();
    AppMethodBeat.o(37927);
    return i;
  }
  
  public final void setOnVisibilityChangeListener(b paramb)
  {
    this.XuZ = paramb;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(37929);
    b localb;
    if ((this.XuZ != null) && (paramInt != getVisibility()))
    {
      localb = this.XuZ;
      if (paramInt != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localb.GI(bool);
      super.setVisibility(paramInt);
      AppMethodBeat.o(37929);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void awK(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void GI(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.aa
 * JD-Core Version:    0.7.0.1
 */