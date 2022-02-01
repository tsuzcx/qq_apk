package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.pb.talkroom.sdk.MultiTalkGroupMember;>;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "avatarViewManager", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "getContext", "()Landroid/content/Context;", "setContext", "footerCount", "", "headerCount", "isFooterShow", "", "mAvatarItemHasBeenShow", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mCurrentScreenSize", "Ljava/util/ArrayList;", "mCurrentVideoSize", "mIs2GOr3G", "addMember", "", "members", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "clickListener", "Landroid/view/View$OnClickListener;", "checkIsAvatarContent", "position", "findChildIndexByUsername", "userName", "getAvatarCount", "getAvatarWidth", "getItemCount", "getItemViewType", "getMarginWidth", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "index", "registerAvatarManager", "manager", "setCurrentScreenSet", "currentScreenSet", "setCurrentVideoSet", "currentVideoSet", "setIs2GOr3G", "is2GOr3G", "Companion", "plugin-multitalk_release"})
public final class a
  extends RecyclerView.a<b>
{
  private static final int tMh = 2;
  private static final int tMi = 3;
  private static final int zQQ = 1;
  public static final a.a zQR;
  private Context context;
  public final int wqJ;
  public CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> zQI;
  public boolean zQJ;
  public HashSet<String> zQK;
  public ArrayList<String> zQL;
  private HashSet<String> zQM;
  private boolean zQN;
  int zQO;
  public com.tencent.mm.plugin.multitalk.model.a zQP;
  
  static
  {
    AppMethodBeat.i(178965);
    zQR = new a.a((byte)0);
    zQQ = 1;
    tMh = 2;
    tMi = 3;
    AppMethodBeat.o(178965);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(178964);
    this.context = paramContext;
    this.zQI = new CopyOnWriteArrayList();
    this.wqJ = 1;
    this.zQO = 1;
    AppMethodBeat.o(178964);
  }
  
  private final int Ro(int paramInt)
  {
    AppMethodBeat.i(239761);
    switch (eoy())
    {
    default: 
      AppMethodBeat.o(239761);
      return 0;
    }
    if (paramInt == 2)
    {
      paramInt = eoz() / 2;
      AppMethodBeat.o(239761);
      return paramInt;
    }
    AppMethodBeat.o(239761);
    return 0;
  }
  
  private int eoy()
  {
    AppMethodBeat.i(178961);
    int i = getItemCount();
    int j = this.wqJ;
    int k = this.zQO;
    AppMethodBeat.o(178961);
    return i - j - k;
  }
  
  private final int eoz()
  {
    AppMethodBeat.i(178962);
    int i = com.tencent.mm.cb.a.jo(this.context) - com.tencent.mm.cb.a.fromDPToPix(this.context, 285);
    int j = com.tencent.mm.cb.a.jn(this.context);
    if (i > j)
    {
      if (eoy() < 5)
      {
        i = j / 2;
        AppMethodBeat.o(178962);
        return i;
      }
      i = j / 3;
      AppMethodBeat.o(178962);
      return i;
    }
    if (eoy() < 5)
    {
      i /= 2;
      AppMethodBeat.o(178962);
      return i;
    }
    i /= 3;
    AppMethodBeat.o(178962);
    return i;
  }
  
  public final boolean Rn(int paramInt)
  {
    AppMethodBeat.i(178960);
    if ((paramInt < this.wqJ) || (paramInt > getItemCount() - this.zQO - 1))
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
          j.hxH();
        }
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)???;
        ??? = this.zQK;
        Object localObject;
        if ((??? == null) || (???.contains(localMultiTalkGroupMember.RHb) != true))
        {
          ??? = this.zQL;
          if ((??? == null) || (???.contains(localMultiTalkGroupMember.RHb) != true)) {}
        }
        else if (!this.zQJ)
        {
          ??? = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(???, "MMKernel.service(IMessengerStorage::class.java)");
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)???).aSN().Kn(localMultiTalkGroupMember.RHb);
          if (??? != null)
          {
            localObject = ???.arI();
            ??? = (ArrayList<MultiTalkGroupMember>)localObject;
            if (localObject != null) {}
          }
          else
          {
            ??? = localMultiTalkGroupMember.RHb;
            p.g(???, "member.usrName");
          }
        }
        for (??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, true, ???);; ??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, false, ???))
        {
          localObject = this.zQM;
          if ((localObject != null) && (((HashSet)localObject).contains(localMultiTalkGroupMember.RHb) == true)) {
            localHashSet.add(localMultiTalkGroupMember.RHb);
          }
          localCopyOnWriteArrayList.add(???);
          i += 1;
          break;
          ??? = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(???, "MMKernel.service(IMessengerStorage::class.java)");
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.l)???).aSN().Kn(localMultiTalkGroupMember.RHb);
          if (??? != null)
          {
            localObject = ???.arI();
            ??? = (ArrayList<MultiTalkGroupMember>)localObject;
            if (localObject != null) {}
          }
          else
          {
            ??? = localMultiTalkGroupMember.RHb;
            p.g(???, "member.usrName");
          }
        }
      }
      this.zQM = localHashSet;
    }
    finally {}
    synchronized (this.zQI)
    {
      this.zQI.clear();
      this.zQI.addAll((Collection)localCopyOnWriteArrayList);
      notifyDataSetChanged();
      paramOnClickListener = x.SXb;
      AppMethodBeat.o(178954);
      return;
    }
  }
  
  public final void aA(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(239760);
    p.h(paramArrayList, "currentScreenSet");
    this.zQL = paramArrayList;
    AppMethodBeat.o(239760);
  }
  
  public final void c(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(178956);
    p.h(paramHashSet, "currentVideoSet");
    this.zQK = paramHashSet;
    AppMethodBeat.o(178956);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178959);
    if (this.zQI.size() > 12)
    {
      this.zQN = true;
      this.zQO = 1;
      i = this.zQI.size();
      j = this.wqJ;
      int k = this.zQO;
      AppMethodBeat.o(178959);
      return i + j + k;
    }
    this.zQN = false;
    this.zQO = 0;
    int i = this.zQI.size();
    int j = this.wqJ;
    AppMethodBeat.o(178959);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(178958);
    if (paramInt == 0)
    {
      paramInt = tMh;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    if (paramInt == getItemCount() - 1)
    {
      if (this.zQN)
      {
        paramInt = tMi;
        AppMethodBeat.o(178958);
        return paramInt;
      }
      paramInt = zQQ;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    paramInt = zQQ;
    AppMethodBeat.o(178958);
    return paramInt;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "usrName", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "usrName", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<String, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "usrName", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<String, x>
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