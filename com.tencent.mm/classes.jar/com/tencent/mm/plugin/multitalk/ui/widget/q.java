package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView.a;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarAdapterInContactUI;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "headerCount", "", "smallAvatarClickListener", "Landroid/view/View$OnClickListener;", "checkIsExists", "", "userName", "decreaseContact", "", "userNameList", "onClickListener", "index", "getItemCount", "getItemViewType", "position", "getMarginStart", "getMarginStartFrom", "increaseContact", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateContactList", "Companion", "plugin-multitalk_release"})
public final class q
  extends RecyclerView.a<r>
{
  public static final a zVg;
  private Context context;
  public final ArrayList<String> uae;
  public final int wqJ;
  public View.OnClickListener zVf;
  
  static
  {
    AppMethodBeat.i(178984);
    zVg = new a((byte)0);
    AppMethodBeat.o(178984);
  }
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(178983);
    this.context = paramContext;
    this.uae = new ArrayList();
    this.wqJ = 1;
    AppMethodBeat.o(178983);
  }
  
  private final int epe()
  {
    AppMethodBeat.i(178979);
    int i = (ao.az(this.context).x - (f.zSs * this.uae.size() + f.zSk * (this.uae.size() - 1))) / 2;
    int j = f.zSs;
    AppMethodBeat.o(178979);
    return i - j;
  }
  
  public final boolean aGC(String paramString)
  {
    AppMethodBeat.i(178978);
    Iterator localIterator = ((Iterable)this.uae).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.j((String)localObject, paramString));
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
    this.uae.clear();
    this.uae.add(z.aTY());
    int i = 0;
    int j = ((Collection)paramArrayList).size();
    while (i < j)
    {
      Object localObject = paramArrayList.get(i);
      p.g(localObject, "userNameList[i]");
      if ((!aGC((String)localObject)) && ((p.j((String)paramArrayList.get(i), z.aTY()) ^ true))) {
        this.uae.add(paramArrayList.get(i));
      }
      i += 1;
    }
    this.zVf = paramOnClickListener;
    notifyDataSetChanged();
    AppMethodBeat.o(178977);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178982);
    int i = this.uae.size();
    int j = this.wqJ;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarAdapterInContactUI$Companion;", "", "()V", "VIEW_TYPE_FOOTER", "", "VIEW_TYPE_HEADER", "VIEW_TYPE_ITEM", "plugin-multitalk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.q
 * JD-Core Version:    0.7.0.1
 */