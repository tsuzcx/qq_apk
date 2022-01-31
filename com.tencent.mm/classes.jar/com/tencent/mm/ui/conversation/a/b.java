package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.ui.p;
import java.util.ArrayList;

public final class b
  extends p<c>
{
  a Amh;
  private ArrayList<c> gJj;
  
  public b(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(34636);
    this.gJj = new ArrayList();
    this.Amh = null;
    Kv();
    AppMethodBeat.o(34636);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(34638);
    this.gJj.clear();
    if (this.Amh == null)
    {
      AppMethodBeat.o(34638);
      return;
    }
    c localc = new c(this.Amh);
    this.gJj.add(localc);
    notifyDataSetChanged();
    AppMethodBeat.o(34638);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(34637);
    Ku();
    AppMethodBeat.o(34637);
  }
  
  public final c QF(int paramInt)
  {
    AppMethodBeat.i(34640);
    c localc = (c)this.gJj.get(paramInt);
    AppMethodBeat.o(34640);
    return localc;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34639);
    int i = this.gJj.size();
    AppMethodBeat.o(34639);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34641);
    c localc = (c)this.gJj.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, 2130968645, null);
      paramView = new d();
      paramView.Amj = localView;
      paramView.Amk = ((Button)localView.findViewById(2131821113));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    while (localc.a(paramViewGroup) != 0)
    {
      AppMethodBeat.o(34641);
      return null;
      paramViewGroup = (d)paramView.getTag();
      localView = paramView;
    }
    AppMethodBeat.o(34641);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.b
 * JD-Core Version:    0.7.0.1
 */