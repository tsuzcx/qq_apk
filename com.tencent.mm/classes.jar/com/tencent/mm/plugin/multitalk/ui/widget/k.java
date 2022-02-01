package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView.a;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.ui.al;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarAdapterInContactUI;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "headerCount", "", "smallAvatarClickListener", "Landroid/view/View$OnClickListener;", "checkIsExists", "", "userName", "decreaseContact", "", "userNameList", "onClickListener", "index", "getItemCount", "getItemViewType", "position", "getMarginStart", "getMarginStartFrom", "increaseContact", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateContactList", "Companion", "plugin-multitalk_release"})
public final class k
  extends RecyclerView.a<l>
{
  public static final k.a whv;
  private Context context;
  public final int sWU;
  public final ArrayList<String> sec;
  public View.OnClickListener whu;
  
  static
  {
    AppMethodBeat.i(178984);
    whv = new k.a((byte)0);
    AppMethodBeat.o(178984);
  }
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(178983);
    this.context = paramContext;
    this.sec = new ArrayList();
    this.sWU = 1;
    AppMethodBeat.o(178983);
  }
  
  private final int dqY()
  {
    AppMethodBeat.i(178979);
    int i = (al.ci(this.context).x - (f.wfO * this.sec.size() + f.wfH * (this.sec.size() - 1))) / 2;
    int j = f.wfO;
    AppMethodBeat.o(178979);
    return i - j;
  }
  
  public final boolean arH(String paramString)
  {
    AppMethodBeat.i(178978);
    Iterator localIterator = ((Iterable)this.sec).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.i((String)localObject, paramString));
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
    p.h(paramArrayList, "userNameList");
    p.h(paramOnClickListener, "onClickListener");
    this.sec.clear();
    this.sec.add(u.aAm());
    int i = 0;
    int j = ((Collection)paramArrayList).size();
    while (i < j)
    {
      Object localObject = paramArrayList.get(i);
      p.g(localObject, "userNameList[i]");
      if ((!arH((String)localObject)) && ((p.i((String)paramArrayList.get(i), u.aAm()) ^ true))) {
        this.sec.add(paramArrayList.get(i));
      }
      i += 1;
    }
    this.whu = paramOnClickListener;
    notifyDataSetChanged();
    AppMethodBeat.o(178977);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178982);
    int i = this.sec.size();
    int j = this.sWU;
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