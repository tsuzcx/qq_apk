package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "addMember", "", "userName", "index", "", "checkIsExists", "", "getItemCount", "getMarginWidth", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "plugin-multitalk_release"})
public final class s
  extends RecyclerView.a<t>
{
  private Context context;
  public ArrayList<String> zVh;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(178991);
    this.context = paramContext;
    this.zVh = new ArrayList();
    AppMethodBeat.o(178991);
  }
  
  public final boolean aGC(String paramString)
  {
    AppMethodBeat.i(178987);
    p.h(paramString, "userName");
    Iterator localIterator = ((Iterable)this.zVh).iterator();
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
      AppMethodBeat.o(178987);
      return true;
    }
    AppMethodBeat.o(178987);
    return false;
  }
  
  public final void eO(String paramString, int paramInt)
  {
    AppMethodBeat.i(178986);
    p.h(paramString, "userName");
    if (this.zVh.size() <= paramInt)
    {
      this.zVh.add(paramString);
      AppMethodBeat.o(178986);
      return;
    }
    this.zVh.set(paramInt, paramString);
    AppMethodBeat.o(178986);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178989);
    int i = (int)Math.ceil(this.zVh.size() / e.b.JSG);
    AppMethodBeat.o(178989);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.s
 * JD-Core Version:    0.7.0.1
 */