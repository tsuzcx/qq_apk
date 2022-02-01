package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ao;
import java.util.List;

public final class y
  extends LinearLayout
{
  private List<String> GVn;
  private a GXP;
  private b GXQ;
  private Context context;
  private LinearLayout qlu;
  
  public y(Context paramContext, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37926);
    this.qlu = null;
    this.context = paramContext;
    this.GXP = parama;
    reset();
    AppMethodBeat.o(37926);
  }
  
  private void reset()
  {
    AppMethodBeat.i(37928);
    az.arV();
    this.GVn = c.apM().eKN();
    if ((this.GVn == null) || (this.GVn.size() <= 0))
    {
      ad.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
      AppMethodBeat.o(37928);
      return;
    }
    this.GVn.remove("wework");
    ad.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", new Object[] { Integer.valueOf(this.GVn.size()) });
    if (this.qlu == null)
    {
      View.inflate(getContext(), 2131495057, this);
      this.qlu = ((LinearLayout)findViewById(2131298736));
    }
    this.qlu.removeAllViews();
    int i = 0;
    if (i < this.GVn.size())
    {
      Object localObject = (String)this.GVn.get(i);
      localObject = new z(getContext(), (String)localObject);
      this.qlu.addView((View)localObject);
      if (i == this.GVn.size() - 1)
      {
        localObject = ((z)localObject).findViewById(2131299501);
        int j = ((View)localObject).getPaddingLeft();
        ((View)localObject).setBackground(ao.aC(this.context, 2130969245));
        ((View)localObject).findViewById(2131299503).setBackground(null);
        ((View)localObject).setPadding(j, 0, 0, 0);
      }
      for (;;)
      {
        i += 1;
        break;
        ((z)localObject).findViewById(2131299501).setBackground(null);
        ((z)localObject).findViewById(2131299501).findViewById(2131299503).setBackground(ao.aC(this.context, 2130969245));
      }
    }
    AppMethodBeat.o(37928);
  }
  
  public final int getOpenIMCount()
  {
    AppMethodBeat.i(37927);
    if (this.GVn == null)
    {
      AppMethodBeat.o(37927);
      return 0;
    }
    int i = this.GVn.size();
    AppMethodBeat.o(37927);
    return i;
  }
  
  public final void setOnVisibilityChangeListener(b paramb)
  {
    this.GXQ = paramb;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(37929);
    b localb;
    if ((this.GXQ != null) && (paramInt != getVisibility()))
    {
      localb = this.GXQ;
      if (paramInt != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localb.ws(bool);
      super.setVisibility(paramInt);
      AppMethodBeat.o(37929);
      return;
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void ws(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.y
 * JD-Core Version:    0.7.0.1
 */