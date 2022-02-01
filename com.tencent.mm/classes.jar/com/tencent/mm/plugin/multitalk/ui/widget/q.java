package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarAdapterInContactUI;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContext", "()Landroid/content/Context;", "setContext", "headerCount", "", "smallAvatarClickListener", "Landroid/view/View$OnClickListener;", "checkIsExists", "", "userName", "createDesc", "Ljava/lang/StringBuffer;", "decreaseContact", "", "userNameList", "onClickListener", "index", "getItemCount", "getItemViewType", "position", "getMarginStart", "getMarginStartFrom", "increaseContact", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateContactList", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends RecyclerView.a<r>
{
  public static final q.a LwR;
  public final ArrayList<String> BmO;
  public View.OnClickListener LwS;
  private Context context;
  public final int xZt;
  
  static
  {
    AppMethodBeat.i(178984);
    LwR = new q.a((byte)0);
    AppMethodBeat.o(178984);
  }
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(178983);
    this.context = paramContext;
    this.BmO = new ArrayList();
    this.xZt = 1;
    AppMethodBeat.o(178983);
  }
  
  private final int ghS()
  {
    AppMethodBeat.i(178979);
    int i = (aw.bf(this.context).x - (f.Lug * this.BmO.size() + f.LtY * (this.BmO.size() - 1))) / 2;
    int j = f.Lug;
    AppMethodBeat.o(178979);
    return i - j;
  }
  
  public final boolean aNI(String paramString)
  {
    AppMethodBeat.i(178978);
    Iterator localIterator = ((Iterable)this.BmO).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p((String)localObject, paramString));
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
    s.u(paramArrayList, "userNameList");
    s.u(paramOnClickListener, "onClickListener");
    this.BmO.clear();
    this.BmO.add(z.bAM());
    int k = paramArrayList.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = paramArrayList.get(i);
      s.s(localObject, "userNameList[i]");
      if ((!aNI((String)localObject)) && (!s.p(paramArrayList.get(i), z.bAM()))) {
        this.BmO.add(paramArrayList.get(i));
      }
      if (j > k)
      {
        this.LwS = paramOnClickListener;
        this.bZE.notifyChanged();
        AppMethodBeat.o(178977);
        return;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178982);
    int i = this.BmO.size();
    int j = this.xZt;
    AppMethodBeat.o(178982);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 2;
    }
    return 1;
  }
  
  public final StringBuffer ghT()
  {
    AppMethodBeat.i(285488);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(MMApplicationContext.getString(a.h.multitalk_members_selected));
    Iterator localIterator = this.BmO.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      b localb = (b)h.ax(b.class);
      if (localb == null) {}
      for (str = null;; str = localb.getDisplayName(str))
      {
        localStringBuffer.append(s.X(str, ","));
        break;
      }
    }
    AppMethodBeat.o(285488);
    return localStringBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.q
 * JD-Core Version:    0.7.0.1
 */