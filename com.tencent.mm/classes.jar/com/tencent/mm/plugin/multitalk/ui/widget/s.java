package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "addMember", "", "userName", "index", "", "checkIsExists", "", "getItemCount", "getMarginWidth", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends RecyclerView.a<t>
{
  public ArrayList<String> LwT;
  private Context context;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(178991);
    this.context = paramContext;
    this.LwT = new ArrayList();
    AppMethodBeat.o(178991);
  }
  
  public final boolean aNI(String paramString)
  {
    AppMethodBeat.i(178987);
    kotlin.g.b.s.u(paramString, "userName");
    Iterator localIterator = ((Iterable)this.LwT).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!kotlin.g.b.s.p((String)localObject, paramString));
    for (paramString = localObject; paramString != null; paramString = null)
    {
      AppMethodBeat.o(178987);
      return true;
    }
    AppMethodBeat.o(178987);
    return false;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178989);
    int i = (int)Math.ceil(this.LwT.size() / e.b.XNz);
    AppMethodBeat.o(178989);
    return i;
  }
  
  public final void gi(String paramString, int paramInt)
  {
    AppMethodBeat.i(178986);
    kotlin.g.b.s.u(paramString, "userName");
    if (this.LwT.size() <= paramInt)
    {
      this.LwT.add(paramString);
      AppMethodBeat.o(178986);
      return;
    }
    this.LwT.set(paramInt, paramString);
    AppMethodBeat.o(178986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.s
 * JD-Core Version:    0.7.0.1
 */