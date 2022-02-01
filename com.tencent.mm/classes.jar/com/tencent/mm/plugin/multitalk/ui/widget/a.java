package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.pb.talkroom.sdk.MultiTalkGroupMember;>;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "avatarViewManager", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "getContext", "()Landroid/content/Context;", "setContext", "footerCount", "", "headerCount", "isFooterShow", "", "mAvatarItemHasBeenShow", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mCurrentVideoSize", "mIs2GOr3G", "addMember", "", "members", "Ljava/util/ArrayList;", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "clickListener", "Landroid/view/View$OnClickListener;", "checkIsAvatarContent", "position", "findChildIndexByUsername", "userName", "getAvatarCount", "getAvatarWidth", "getItemCount", "getItemViewType", "getMarginWidth", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "index", "registerAvatarManager", "manager", "setCurrentVideoSet", "currentVideoSet", "setIs2GOr3G", "is2GOr3G", "Companion", "plugin-multitalk_release"})
public final class a
  extends RecyclerView.a<b>
{
  private static final int scA = 3;
  private static final int scz = 2;
  private static final int wtX = 1;
  public static final a.a wtY;
  private Context context;
  public final int tii;
  public CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> wtQ;
  public boolean wtR;
  public HashSet<String> wtS;
  private HashSet<String> wtT;
  private boolean wtU;
  int wtV;
  public com.tencent.mm.plugin.multitalk.model.a wtW;
  
  static
  {
    AppMethodBeat.i(178965);
    wtY = new a.a((byte)0);
    wtX = 1;
    scz = 2;
    scA = 3;
    AppMethodBeat.o(178965);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(178964);
    this.context = paramContext;
    this.wtQ = new CopyOnWriteArrayList();
    this.tii = 1;
    this.wtV = 1;
    AppMethodBeat.o(178964);
  }
  
  private final int Lp(int paramInt)
  {
    AppMethodBeat.i(191010);
    switch (dtR())
    {
    default: 
      AppMethodBeat.o(191010);
      return 0;
    }
    if (paramInt == 2)
    {
      paramInt = dtS() / 2;
      AppMethodBeat.o(191010);
      return paramInt;
    }
    AppMethodBeat.o(191010);
    return 0;
  }
  
  private int dtR()
  {
    AppMethodBeat.i(178961);
    int i = getItemCount();
    int j = this.tii;
    int k = this.wtV;
    AppMethodBeat.o(178961);
    return i - j - k;
  }
  
  private final int dtS()
  {
    AppMethodBeat.i(178962);
    int i = com.tencent.mm.cb.a.iv(this.context) - com.tencent.mm.cb.a.fromDPToPix(this.context, 285);
    int j = com.tencent.mm.cb.a.iu(this.context);
    if (i > j)
    {
      if (dtR() < 5)
      {
        i = j / 2;
        AppMethodBeat.o(178962);
        return i;
      }
      i = j / 3;
      AppMethodBeat.o(178962);
      return i;
    }
    if (dtR() < 5)
    {
      i /= 2;
      AppMethodBeat.o(178962);
      return i;
    }
    i /= 3;
    AppMethodBeat.o(178962);
    return i;
  }
  
  public final boolean Lo(int paramInt)
  {
    AppMethodBeat.i(178960);
    if ((paramInt < this.tii) || (paramInt > getItemCount() - this.wtV - 1))
    {
      AppMethodBeat.o(178960);
      return true;
    }
    AppMethodBeat.o(178960);
    return false;
  }
  
  public final void a(ArrayList<MultiTalkGroupMember> arg1, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    CopyOnWriteArrayList localCopyOnWriteArrayList;
    try
    {
      AppMethodBeat.i(178954);
      p.h(???, "members");
      p.h(paramOnClickListener, "clickListener");
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext())
      {
        ??? = localIterator.next();
        if (i < 0) {
          j.gkd();
        }
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)???;
        ??? = this.wtS;
        Object localObject;
        if ((??? != null) && (???.contains(localMultiTalkGroupMember.MgJ) == true) && (!this.wtR))
        {
          ??? = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(???, "MMKernel.service(IMessengerStorage::class.java)");
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)???).azF().BH(localMultiTalkGroupMember.MgJ);
          if (??? != null)
          {
            localObject = ???.adF();
            ??? = (ArrayList<MultiTalkGroupMember>)localObject;
            if (localObject != null) {}
          }
          else
          {
            ??? = localMultiTalkGroupMember.MgJ;
            p.g(???, "member.usrName");
          }
        }
        for (??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, true, ???);; ??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, false, ???))
        {
          localObject = this.wtT;
          if ((localObject != null) && (((HashSet)localObject).contains(localMultiTalkGroupMember.MgJ) == true)) {
            localHashSet.add(localMultiTalkGroupMember.MgJ);
          }
          localCopyOnWriteArrayList.add(???);
          i += 1;
          break;
          ??? = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(???, "MMKernel.service(IMessengerStorage::class.java)");
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)???).azF().BH(localMultiTalkGroupMember.MgJ);
          if (??? != null)
          {
            localObject = ???.adF();
            ??? = (ArrayList<MultiTalkGroupMember>)localObject;
            if (localObject != null) {}
          }
          else
          {
            ??? = localMultiTalkGroupMember.MgJ;
            p.g(???, "member.usrName");
          }
        }
      }
      this.wtT = localHashSet;
    }
    finally {}
    synchronized (this.wtQ)
    {
      this.wtQ.clear();
      this.wtQ.addAll((Collection)localCopyOnWriteArrayList);
      notifyDataSetChanged();
      paramOnClickListener = z.Nhr;
      AppMethodBeat.o(178954);
      return;
    }
  }
  
  public final void d(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(178956);
    p.h(paramHashSet, "currentVideoSet");
    this.wtS = paramHashSet;
    AppMethodBeat.o(178956);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178959);
    if (this.wtQ.size() > 12)
    {
      this.wtU = true;
      this.wtV = 1;
      i = this.wtQ.size();
      j = this.tii;
      int k = this.wtV;
      AppMethodBeat.o(178959);
      return i + j + k;
    }
    this.wtU = false;
    this.wtV = 0;
    int i = this.wtQ.size();
    int j = this.tii;
    AppMethodBeat.o(178959);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(178958);
    if (paramInt == 0)
    {
      paramInt = scz;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    if (paramInt == getItemCount() - 1)
    {
      if (this.wtU)
      {
        paramInt = scA;
        AppMethodBeat.o(178958);
        return paramInt;
      }
      paramInt = wtX;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    paramInt = wtX;
    AppMethodBeat.o(178958);
    return paramInt;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "usrName", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<String, z>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "usrName", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<String, z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "usrName", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<String, z>
  {
    d(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */