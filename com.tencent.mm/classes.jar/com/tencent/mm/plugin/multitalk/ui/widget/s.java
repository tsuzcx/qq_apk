package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "addMember", "", "userName", "index", "", "checkIsExists", "", "getItemCount", "getMarginWidth", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "plugin-multitalk_release"})
public final class s
  extends RecyclerView.a<t>
{
  public ArrayList<String> FAQ;
  private Context context;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(178991);
    this.context = paramContext;
    this.FAQ = new ArrayList();
    AppMethodBeat.o(178991);
  }
  
  public final boolean aQR(String paramString)
  {
    AppMethodBeat.i(178987);
    p.k(paramString, "userName");
    Iterator localIterator = ((Iterable)this.FAQ).iterator();
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
      AppMethodBeat.o(178987);
      return true;
    }
    AppMethodBeat.o(178987);
    return false;
  }
  
  public final void fp(String paramString, int paramInt)
  {
    AppMethodBeat.i(178986);
    p.k(paramString, "userName");
    if (this.FAQ.size() <= paramInt)
    {
      this.FAQ.add(paramString);
      AppMethodBeat.o(178986);
      return;
    }
    this.FAQ.set(paramInt, paramString);
    AppMethodBeat.o(178986);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178989);
    int i = (int)Math.ceil(this.FAQ.size() / e.b.QRL);
    AppMethodBeat.o(178989);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.s
 * JD-Core Version:    0.7.0.1
 */