package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.k.a.a;
import com.tencent.mm.ui.x;
import java.util.ArrayList;

public final class b
  extends x<c>
{
  private ArrayList<c> afsI;
  a afsJ;
  
  public b(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(38763);
    this.afsI = new ArrayList();
    this.afsJ = null;
    aNz();
    AppMethodBeat.o(38763);
  }
  
  public final c aDN(int paramInt)
  {
    AppMethodBeat.i(38767);
    c localc = (c)this.afsI.get(paramInt);
    AppMethodBeat.o(38767);
    return localc;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(38765);
    this.afsI.clear();
    if (this.afsJ == null)
    {
      AppMethodBeat.o(38765);
      return;
    }
    c localc = new c(this.afsJ);
    this.afsI.add(localc);
    notifyDataSetChanged();
    AppMethodBeat.o(38765);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(38764);
    aNy();
    AppMethodBeat.o(38764);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(38766);
    int i = this.afsI.size();
    AppMethodBeat.o(38766);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38768);
    c localc = (c)this.afsI.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, R.i.geb, null);
      paramView = new d();
      paramView.afsL = localView;
      paramView.afsM = ((Button)localView.findViewById(R.h.fqp));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.b
 * JD-Core Version:    0.7.0.1
 */