package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.util.List;

public final class u
  extends LinearLayout
{
  private Context context;
  private LinearLayout kjd = null;
  private List<String> vMT;
  private u.a vMU;
  private u.b vMV;
  
  public u(Context paramContext, u.a parama)
  {
    super(paramContext);
    this.context = paramContext;
    this.vMU = parama;
    reset();
  }
  
  public final int getOpenIMCount()
  {
    if (this.vMT == null) {
      return 0;
    }
    return this.vMT.size();
  }
  
  public final void reset()
  {
    int i = 0;
    au.Hx();
    this.vMT = c.Fw().cul();
    if ((this.vMT == null) || (this.vMT.size() <= 0)) {
      y.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
    }
    for (;;)
    {
      return;
      y.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", new Object[] { Integer.valueOf(this.vMT.size()) });
      if (this.kjd == null)
      {
        View.inflate(getContext(), R.i.openim_in_addressui_header, this);
        this.kjd = ((LinearLayout)findViewById(R.h.container));
      }
      this.kjd.removeAllViews();
      while (i < this.vMT.size())
      {
        Object localObject = (String)this.vMT.get(i);
        localObject = new v(getContext(), (String)localObject);
        this.kjd.addView((View)localObject);
        if (i == this.vMT.size() - 1) {
          ((v)localObject).findViewById(R.h.enterprise_biz_item_ll).setBackgroundResource(R.g.mm_trans);
        }
        i += 1;
      }
    }
  }
  
  public final void setOnVisibilityChangeListener(u.b paramb)
  {
    this.vMV = paramb;
  }
  
  public final void setVisibility(int paramInt)
  {
    u.b localb;
    if ((this.vMV != null) && (paramInt != getVisibility()))
    {
      localb = this.vMV;
      if (paramInt != 0) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      localb.nw(bool);
      super.setVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.u
 * JD-Core Version:    0.7.0.1
 */