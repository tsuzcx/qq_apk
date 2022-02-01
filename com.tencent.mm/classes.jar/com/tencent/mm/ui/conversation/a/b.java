package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.a.a;
import com.tencent.mm.ui.q;
import java.util.ArrayList;

public final class b
  extends q<c>
{
  a Hgs;
  private ArrayList<c> iwQ;
  
  public b(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(38763);
    this.iwQ = new ArrayList();
    this.Hgs = null;
    We();
    AppMethodBeat.o(38763);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(38765);
    this.iwQ.clear();
    if (this.Hgs == null)
    {
      AppMethodBeat.o(38765);
      return;
    }
    c localc = new c(this.Hgs);
    this.iwQ.add(localc);
    notifyDataSetChanged();
    AppMethodBeat.o(38765);
  }
  
  public final void We()
  {
    AppMethodBeat.i(38764);
    Wd();
    AppMethodBeat.o(38764);
  }
  
  public final c ZW(int paramInt)
  {
    AppMethodBeat.i(38767);
    c localc = (c)this.iwQ.get(paramInt);
    AppMethodBeat.o(38767);
    return localc;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(38766);
    int i = this.iwQ.size();
    AppMethodBeat.o(38766);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38768);
    c localc = (c)this.iwQ.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, 2131492953, null);
      paramView = new d();
      paramView.Hgu = localView;
      paramView.Hgv = ((Button)localView.findViewById(2131296429));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.b
 * JD-Core Version:    0.7.0.1
 */