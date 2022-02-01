package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarAdapterInContactUI;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "headerCount", "", "smallAvatarClickListener", "Landroid/view/View$OnClickListener;", "checkIsExists", "", "userName", "decreaseContact", "", "userNameList", "onClickListener", "index", "getItemCount", "getItemViewType", "position", "getMarginStart", "getMarginStartFrom", "increaseContact", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateContactList", "Companion", "plugin-multitalk_release"})
public final class q
  extends RecyclerView.a<r>
{
  public static final q.a FAP;
  public final int BcO;
  public View.OnClickListener FAO;
  private Context context;
  public final ArrayList<String> xMG;
  
  static
  {
    AppMethodBeat.i(178984);
    FAP = new q.a((byte)0);
    AppMethodBeat.o(178984);
  }
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(178983);
    this.context = paramContext;
    this.xMG = new ArrayList();
    this.BcO = 1;
    AppMethodBeat.o(178983);
  }
  
  private final int eYU()
  {
    AppMethodBeat.i(178979);
    int i = (ar.au(this.context).x - (f.FxU * this.xMG.size() + f.FxM * (this.xMG.size() - 1))) / 2;
    int j = f.FxU;
    AppMethodBeat.o(178979);
    return i - j;
  }
  
  public final boolean aQR(String paramString)
  {
    AppMethodBeat.i(178978);
    Iterator localIterator = ((Iterable)this.xMG).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.h((String)localObject, paramString));
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
    p.k(paramArrayList, "userNameList");
    p.k(paramOnClickListener, "onClickListener");
    this.xMG.clear();
    this.xMG.add(z.bcZ());
    int i = 0;
    int j = ((Collection)paramArrayList).size();
    while (i < j)
    {
      Object localObject = paramArrayList.get(i);
      p.j(localObject, "userNameList[i]");
      if ((!aQR((String)localObject)) && ((p.h((String)paramArrayList.get(i), z.bcZ()) ^ true))) {
        this.xMG.add(paramArrayList.get(i));
      }
      i += 1;
    }
    this.FAO = paramOnClickListener;
    notifyDataSetChanged();
    AppMethodBeat.o(178977);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178982);
    int i = this.xMG.size();
    int j = this.BcO;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.q
 * JD-Core Version:    0.7.0.1
 */