package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView.a;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.ui.ai;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarAdapterInContactUI;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "headerCount", "", "smallAvatarClickListener", "Landroid/view/View$OnClickListener;", "checkIsExists", "", "userName", "decreaseContact", "", "userNameList", "onClickListener", "index", "getItemCount", "getItemViewType", "position", "getMarginStart", "getMarginStartFrom", "increaseContact", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateContactList", "Companion", "plugin-multitalk_release"})
public final class k
  extends RecyclerView.a<l>
{
  public static final a tTC;
  private Context context;
  public final ArrayList<String> qHA;
  public final int qYg;
  public View.OnClickListener tTB;
  
  static
  {
    AppMethodBeat.i(178984);
    tTC = new a((byte)0);
    AppMethodBeat.o(178984);
  }
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(178983);
    this.context = paramContext;
    this.qHA = new ArrayList();
    this.qYg = 1;
    AppMethodBeat.o(178983);
  }
  
  private final int cTi()
  {
    AppMethodBeat.i(178979);
    int i = (ai.cf(this.context).x - (f.tRY * this.qHA.size() + f.tRR * (this.qHA.size() - 1))) / 2;
    int j = f.tRY;
    AppMethodBeat.o(178979);
    return i - j;
  }
  
  public final boolean ahN(String paramString)
  {
    AppMethodBeat.i(178978);
    Iterator localIterator = ((Iterable)this.qHA).iterator();
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
    this.qHA.clear();
    this.qHA.add(u.aqG());
    int i = 0;
    int j = ((Collection)paramArrayList).size();
    while (i < j)
    {
      Object localObject = paramArrayList.get(i);
      d.g.b.k.g(localObject, "userNameList[i]");
      if ((!ahN((String)localObject)) && ((d.g.b.k.g((String)paramArrayList.get(i), u.aqG()) ^ true))) {
        this.qHA.add(paramArrayList.get(i));
      }
      i += 1;
    }
    this.tTB = paramOnClickListener;
    notifyDataSetChanged();
    AppMethodBeat.o(178977);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178982);
    int i = this.qHA.size();
    int j = this.qYg;
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarAdapterInContactUI$Companion;", "", "()V", "VIEW_TYPE_FOOTER", "", "VIEW_TYPE_HEADER", "VIEW_TYPE_ITEM", "plugin-multitalk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.k
 * JD-Core Version:    0.7.0.1
 */