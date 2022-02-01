package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.e.b;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "addMember", "", "userName", "index", "", "checkIsExists", "", "getItemCount", "getMarginWidth", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "plugin-multitalk_release"})
public final class m
  extends RecyclerView.a<n>
{
  private Context context;
  public ArrayList<String> wxa;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(178991);
    this.context = paramContext;
    this.wxa = new ArrayList();
    AppMethodBeat.o(178991);
  }
  
  public final boolean asU(String paramString)
  {
    AppMethodBeat.i(178987);
    p.h(paramString, "userName");
    Iterator localIterator = ((Iterable)this.wxa).iterator();
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
      AppMethodBeat.o(178987);
      return true;
    }
    AppMethodBeat.o(178987);
    return false;
  }
  
  public final void eA(String paramString, int paramInt)
  {
    AppMethodBeat.i(178986);
    p.h(paramString, "userName");
    if (this.wxa.size() <= paramInt)
    {
      this.wxa.add(paramString);
      AppMethodBeat.o(178986);
      return;
    }
    this.wxa.set(paramInt, paramString);
    AppMethodBeat.o(178986);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178989);
    int i = (int)Math.ceil(this.wxa.size() / e.b.FbM);
    AppMethodBeat.o(178989);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.m
 * JD-Core Version:    0.7.0.1
 */