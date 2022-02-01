package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k.a.a;
import com.tencent.mm.ui.r;
import java.util.ArrayList;

public final class b
  extends r<c>
{
  a KxR;
  private ArrayList<c> jqc;
  
  public b(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(38763);
    this.jqc = new ArrayList();
    this.KxR = null;
    Zv();
    AppMethodBeat.o(38763);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(38765);
    this.jqc.clear();
    if (this.KxR == null)
    {
      AppMethodBeat.o(38765);
      return;
    }
    c localc = new c(this.KxR);
    this.jqc.add(localc);
    notifyDataSetChanged();
    AppMethodBeat.o(38765);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(38764);
    Zu();
    AppMethodBeat.o(38764);
  }
  
  public final c aeH(int paramInt)
  {
    AppMethodBeat.i(38767);
    c localc = (c)this.jqc.get(paramInt);
    AppMethodBeat.o(38767);
    return localc;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(38766);
    int i = this.jqc.size();
    AppMethodBeat.o(38766);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38768);
    c localc = (c)this.jqc.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, 2131492953, null);
      paramView = new d();
      paramView.KxT = localView;
      paramView.KxU = ((Button)localView.findViewById(2131296429));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.b
 * JD-Core Version:    0.7.0.1
 */