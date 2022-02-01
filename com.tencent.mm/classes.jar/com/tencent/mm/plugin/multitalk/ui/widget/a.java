package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "avatarViewManager", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "getContext", "()Landroid/content/Context;", "setContext", "footerCount", "", "headerCount", "isFooterShow", "", "mAvatarItemHasBeenShow", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mCurrentVideoSize", "mIs2GOr3G", "addMember", "", "members", "Ljava/util/ArrayList;", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "clickListener", "Landroid/view/View$OnClickListener;", "checkIsAvatarContent", "position", "findChildIndexByUsername", "userName", "getAvatarCount", "getAvatarWidth", "getItemCount", "getItemViewType", "getMarginWidth", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "index", "registerAvatarManager", "manager", "setCurrentVideoSet", "currentVideoSet", "setIs2GOr3G", "is2GOr3G", "Companion", "plugin-multitalk_release"})
public final class a
  extends RecyclerView.a<b>
{
  private static final int rTV = 2;
  private static final int rTW = 3;
  private static final int weu = 1;
  public static final a.a wev;
  private Context context;
  public final int sWU;
  public CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> wen;
  public boolean weo;
  public HashSet<String> wep;
  private HashSet<String> weq;
  private boolean wer;
  int wes;
  public com.tencent.mm.plugin.multitalk.model.a wet;
  
  static
  {
    AppMethodBeat.i(178965);
    wev = new a.a((byte)0);
    weu = 1;
    rTV = 2;
    rTW = 3;
    AppMethodBeat.o(178965);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(178964);
    this.context = paramContext;
    this.wen = new CopyOnWriteArrayList();
    this.sWU = 1;
    this.wes = 1;
    AppMethodBeat.o(178964);
  }
  
  private final int KK(int paramInt)
  {
    AppMethodBeat.i(206736);
    switch (dqE())
    {
    default: 
      AppMethodBeat.o(206736);
      return 0;
    }
    if (paramInt == 2)
    {
      paramInt = dqF() / 2;
      AppMethodBeat.o(206736);
      return paramInt;
    }
    AppMethodBeat.o(206736);
    return 0;
  }
  
  private int dqE()
  {
    AppMethodBeat.i(178961);
    int i = getItemCount();
    int j = this.sWU;
    int k = this.wes;
    AppMethodBeat.o(178961);
    return i - j - k;
  }
  
  private final int dqF()
  {
    AppMethodBeat.i(178962);
    int i = com.tencent.mm.cc.a.iq(this.context) - com.tencent.mm.cc.a.fromDPToPix(this.context, 285);
    int j = com.tencent.mm.cc.a.ip(this.context);
    if (i > j)
    {
      if (dqE() < 5)
      {
        i = j / 2;
        AppMethodBeat.o(178962);
        return i;
      }
      i = j / 3;
      AppMethodBeat.o(178962);
      return i;
    }
    if (dqE() < 5)
    {
      i /= 2;
      AppMethodBeat.o(178962);
      return i;
    }
    i /= 3;
    AppMethodBeat.o(178962);
    return i;
  }
  
  public final boolean KJ(int paramInt)
  {
    AppMethodBeat.i(178960);
    if ((paramInt < this.sWU) || (paramInt > getItemCount() - this.wes - 1))
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
          j.gfB();
        }
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)???;
        ??? = this.wep;
        Object localObject;
        if ((??? != null) && (???.contains(localMultiTalkGroupMember.LJH) == true) && (!this.weo))
        {
          ??? = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(???, "MMKernel.service(IMessengerStorage::class.java)");
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)???).azp().Bf(localMultiTalkGroupMember.LJH);
          if (??? != null)
          {
            localObject = ???.adu();
            ??? = (ArrayList<MultiTalkGroupMember>)localObject;
            if (localObject != null) {}
          }
          else
          {
            ??? = localMultiTalkGroupMember.LJH;
            p.g(???, "member.usrName");
          }
        }
        for (??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, true, ???);; ??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, false, ???))
        {
          localObject = this.weq;
          if ((localObject != null) && (((HashSet)localObject).contains(localMultiTalkGroupMember.LJH) == true)) {
            localHashSet.add(localMultiTalkGroupMember.LJH);
          }
          localCopyOnWriteArrayList.add(???);
          i += 1;
          break;
          ??? = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(???, "MMKernel.service(IMessengerStorage::class.java)");
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)???).azp().Bf(localMultiTalkGroupMember.LJH);
          if (??? != null)
          {
            localObject = ???.adu();
            ??? = (ArrayList<MultiTalkGroupMember>)localObject;
            if (localObject != null) {}
          }
          else
          {
            ??? = localMultiTalkGroupMember.LJH;
            p.g(???, "member.usrName");
          }
        }
      }
      this.weq = localHashSet;
    }
    finally {}
    synchronized (this.wen)
    {
      this.wen.clear();
      this.wen.addAll((Collection)localCopyOnWriteArrayList);
      notifyDataSetChanged();
      paramOnClickListener = z.MKo;
      AppMethodBeat.o(178954);
      return;
    }
  }
  
  public final void d(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(178956);
    p.h(paramHashSet, "currentVideoSet");
    this.wep = paramHashSet;
    AppMethodBeat.o(178956);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178959);
    if (this.wen.size() > 12)
    {
      this.wer = true;
      this.wes = 1;
      i = this.wen.size();
      j = this.sWU;
      int k = this.wes;
      AppMethodBeat.o(178959);
      return i + j + k;
    }
    this.wer = false;
    this.wes = 0;
    int i = this.wen.size();
    int j = this.sWU;
    AppMethodBeat.o(178959);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(178958);
    if (paramInt == 0)
    {
      paramInt = rTV;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    if (paramInt == getItemCount() - 1)
    {
      if (this.wer)
      {
        paramInt = rTW;
        AppMethodBeat.o(178958);
        return paramInt;
      }
      paramInt = weu;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    paramInt = weu;
    AppMethodBeat.o(178958);
    return paramInt;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "usrName", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<String, z>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "usrName", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<String, z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "usrName", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */