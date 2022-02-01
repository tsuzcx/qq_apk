package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k.a.a;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

public final class b
  extends s<c>
{
  a QhB;
  private ArrayList<c> krk;
  
  public b(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(38763);
    this.krk = new ArrayList();
    this.QhB = null;
    anq();
    AppMethodBeat.o(38763);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(38765);
    this.krk.clear();
    if (this.QhB == null)
    {
      AppMethodBeat.o(38765);
      return;
    }
    c localc = new c(this.QhB);
    this.krk.add(localc);
    notifyDataSetChanged();
    AppMethodBeat.o(38765);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(38764);
    anp();
    AppMethodBeat.o(38764);
  }
  
  public final c aoa(int paramInt)
  {
    AppMethodBeat.i(38767);
    c localc = (c)this.krk.get(paramInt);
    AppMethodBeat.o(38767);
    return localc;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(38766);
    int i = this.krk.size();
    AppMethodBeat.o(38766);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38768);
    c localc = (c)this.krk.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, 2131492986, null);
      paramView = new d();
      paramView.QhD = localView;
      paramView.QhE = ((Button)localView.findViewById(2131296485));
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