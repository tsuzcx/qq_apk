package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.l.a.a;
import com.tencent.mm.ui.v;
import java.util.ArrayList;

public final class b
  extends v<c>
{
  private ArrayList<c> XEL;
  a XEM;
  
  public b(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(38763);
    this.XEL = new ArrayList();
    this.XEM = null;
    ats();
    AppMethodBeat.o(38763);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(38765);
    this.XEL.clear();
    if (this.XEM == null)
    {
      AppMethodBeat.o(38765);
      return;
    }
    c localc = new c(this.XEM);
    this.XEL.add(localc);
    notifyDataSetChanged();
    AppMethodBeat.o(38765);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(38764);
    atr();
    AppMethodBeat.o(38764);
  }
  
  public final c axf(int paramInt)
  {
    AppMethodBeat.i(38767);
    c localc = (c)this.XEL.get(paramInt);
    AppMethodBeat.o(38767);
    return localc;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(38766);
    int i = this.XEL.size();
    AppMethodBeat.o(38766);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38768);
    c localc = (c)this.XEL.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, R.i.ebt, null);
      paramView = new d();
      paramView.XEO = localView;
      paramView.XEP = ((Button)localView.findViewById(R.h.dqb));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    while (localc.a(paramViewGroup) != 0)
    {
      AppMethodBeat.o(38768);
      return null;
      paramViewGroup = (d)paramView.getTag();
      localView = paramView;
    }
    AppMethodBeat.o(38768);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.b
 * JD-Core Version:    0.7.0.1
 */