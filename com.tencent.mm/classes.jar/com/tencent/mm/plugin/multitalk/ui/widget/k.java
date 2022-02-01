package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView.a;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarAdapterInContactUI;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "headerCount", "", "smallAvatarClickListener", "Landroid/view/View$OnClickListener;", "checkIsExists", "", "userName", "decreaseContact", "", "userNameList", "onClickListener", "index", "getItemCount", "getItemViewType", "position", "getMarginStart", "getMarginStartFrom", "increaseContact", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateContactList", "Companion", "plugin-multitalk_release"})
public final class k
  extends RecyclerView.a<l>
{
  public static final k.a vck;
  private Context context;
  public final int rZI;
  public final ArrayList<String> rpr;
  public View.OnClickListener vcj;
  
  static
  {
    AppMethodBeat.i(178984);
    vck = new k.a((byte)0);
    AppMethodBeat.o(178984);
  }
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(178983);
    this.context = paramContext;
    this.rpr = new ArrayList();
    this.rZI = 1;
    AppMethodBeat.o(178983);
  }
  
  private final int dgS()
  {
    AppMethodBeat.i(178979);
    int i = (aj.cl(this.context).x - (f.vaF * this.rpr.size() + f.vay * (this.rpr.size() - 1))) / 2;
    int j = f.vaF;
    AppMethodBeat.o(178979);
    return i - j;
  }
  
  public final boolean amI(String paramString)
  {
    AppMethodBeat.i(178978);
    Iterator localIterator = ((Iterable)this.rpr).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!d.g.b.k.g((String)localObject, paramString));
    for (paramString = localObject; paramString != null; paramString = null)
    {
      AppMethodBeat.o(178978);
      return true;
    }
    AppMethodBeat.o(178978);
    return false;
  }
  
  public final void b(ArrayList<String> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(178977);
    d.g.b.k.h(paramArrayList, "userNameList");
    d.g.b.k.h(paramOnClickListener, "onClickListener");
    this.rpr.clear();
    this.rpr.add(u.axw());
    int i = 0;
    int j = ((Collection)paramArrayList).size();
    while (i < j)
    {
      Object localObject = paramArrayList.get(i);
      d.g.b.k.g(localObject, "userNameList[i]");
      if ((!amI((String)localObject)) && ((d.g.b.k.g((String)paramArrayList.get(i), u.axw()) ^ true))) {
        this.rpr.add(paramArrayList.get(i));
      }
      i += 1;
    }
    this.vcj = paramOnClickListener;
    notifyDataSetChanged();
    AppMethodBeat.o(178977);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178982);
    int i = this.rpr.size();
    int j = this.rZI;
    AppMethodBeat.o(178982);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.k
 * JD-Core Version:    0.7.0.1
 */