package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
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
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "avatarViewManager", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "getContext", "()Landroid/content/Context;", "setContext", "footerCount", "", "headerCount", "isFooterShow", "", "mAvatarItemHasBeenShow", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mCurrentScreenSize", "Ljava/util/ArrayList;", "mCurrentVideoSize", "mIs2GOr3G", "addMember", "", "members", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "clickListener", "Landroid/view/View$OnClickListener;", "checkIsAvatarContent", "position", "findChildIndexByUsername", "userName", "getAvatarCount", "getAvatarWidth", "getItemCount", "getItemViewType", "getMarginWidth", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "index", "registerAvatarManager", "manager", "setCurrentScreenSet", "currentScreenSet", "setCurrentVideoSet", "currentVideoSet", "setIs2GOr3G", "is2GOr3G", "Companion", "plugin-multitalk_release"})
public final class a
  extends RecyclerView.a<b>
{
  private static final int Fwt = 1;
  public static final a.a Fwu;
  private static final int xvY = 2;
  private static final int xvZ = 3;
  public final int BcO;
  public CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> Fwl;
  public boolean Fwm;
  public HashSet<String> Fwn;
  public ArrayList<String> Fwo;
  private HashSet<String> Fwp;
  private boolean Fwq;
  int Fwr;
  public com.tencent.mm.plugin.multitalk.model.a Fws;
  private Context context;
  
  static
  {
    AppMethodBeat.i(178965);
    Fwu = new a.a((byte)0);
    Fwt = 1;
    xvY = 2;
    xvZ = 3;
    AppMethodBeat.o(178965);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(178964);
    this.context = paramContext;
    this.Fwl = new CopyOnWriteArrayList();
    this.BcO = 1;
    this.Fwr = 1;
    AppMethodBeat.o(178964);
  }
  
  private final int XD(int paramInt)
  {
    AppMethodBeat.i(205020);
    switch (eYq())
    {
    default: 
      AppMethodBeat.o(205020);
      return 0;
    }
    if (paramInt == 2)
    {
      paramInt = eYr() / 2;
      AppMethodBeat.o(205020);
      return paramInt;
    }
    AppMethodBeat.o(205020);
    return 0;
  }
  
  private int eYq()
  {
    AppMethodBeat.i(178961);
    int i = getItemCount();
    int j = this.BcO;
    int k = this.Fwr;
    AppMethodBeat.o(178961);
    return i - j - k;
  }
  
  private final int eYr()
  {
    AppMethodBeat.i(178962);
    int i = com.tencent.mm.ci.a.ks(this.context) - com.tencent.mm.ci.a.fromDPToPix(this.context, 285);
    int j = ar.au(this.context).x;
    if (i > j)
    {
      if (eYq() < 5)
      {
        i = j / 2;
        AppMethodBeat.o(178962);
        return i;
      }
      i = j / 3;
      AppMethodBeat.o(178962);
      return i;
    }
    if (eYq() < 5)
    {
      i /= 2;
      AppMethodBeat.o(178962);
      return i;
    }
    i /= 3;
    AppMethodBeat.o(178962);
    return i;
  }
  
  public final boolean XC(int paramInt)
  {
    AppMethodBeat.i(178960);
    if ((paramInt < this.BcO) || (paramInt > getItemCount() - this.Fwr - 1))
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
      p.k(???, "members");
      p.k(paramOnClickListener, "clickListener");
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext())
      {
        ??? = localIterator.next();
        if (i < 0) {
          j.iBO();
        }
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)???;
        ??? = this.Fwn;
        Object localObject;
        if ((??? == null) || (???.contains(localMultiTalkGroupMember.ZiH) != true))
        {
          ??? = this.Fwo;
          if ((??? == null) || (???.contains(localMultiTalkGroupMember.ZiH) != true)) {}
        }
        else if (!this.Fwm)
        {
          ??? = h.ae(n.class);
          p.j(???, "MMKernel.service(IMessengerStorage::class.java)");
          ??? = ((n)???).bbL().RG(localMultiTalkGroupMember.ZiH);
          if (??? != null)
          {
            localObject = ???.ayr();
            ??? = (ArrayList<MultiTalkGroupMember>)localObject;
            if (localObject != null) {}
          }
          else
          {
            ??? = localMultiTalkGroupMember.ZiH;
            p.j(???, "member.usrName");
          }
        }
        for (??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, true, ???);; ??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, false, ???))
        {
          localObject = this.Fwp;
          if ((localObject != null) && (((HashSet)localObject).contains(localMultiTalkGroupMember.ZiH) == true)) {
            localHashSet.add(localMultiTalkGroupMember.ZiH);
          }
          localCopyOnWriteArrayList.add(???);
          i += 1;
          break;
          ??? = h.ae(n.class);
          p.j(???, "MMKernel.service(IMessengerStorage::class.java)");
          ??? = ((n)???).bbL().RG(localMultiTalkGroupMember.ZiH);
          if (??? != null)
          {
            localObject = ???.ayr();
            ??? = (ArrayList<MultiTalkGroupMember>)localObject;
            if (localObject != null) {}
          }
          else
          {
            ??? = localMultiTalkGroupMember.ZiH;
            p.j(???, "member.usrName");
          }
        }
      }
      this.Fwp = localHashSet;
    }
    finally {}
    synchronized (this.Fwl)
    {
      this.Fwl.clear();
      this.Fwl.addAll((Collection)localCopyOnWriteArrayList);
      notifyDataSetChanged();
      paramOnClickListener = x.aazN;
      AppMethodBeat.o(178954);
      return;
    }
  }
  
  public final void aH(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(205010);
    p.k(paramArrayList, "currentScreenSet");
    this.Fwo = paramArrayList;
    AppMethodBeat.o(205010);
  }
  
  public final void c(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(178956);
    p.k(paramHashSet, "currentVideoSet");
    this.Fwn = paramHashSet;
    AppMethodBeat.o(178956);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178959);
    if (this.Fwl.size() > 12)
    {
      this.Fwq = true;
      this.Fwr = 1;
      i = this.Fwl.size();
      j = this.BcO;
      int k = this.Fwr;
      AppMethodBeat.o(178959);
      return i + j + k;
    }
    this.Fwq = false;
    this.Fwr = 0;
    int i = this.Fwl.size();
    int j = this.BcO;
    AppMethodBeat.o(178959);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(178958);
    if (paramInt == 0)
    {
      paramInt = xvY;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    if (paramInt == getItemCount() - 1)
    {
      if (this.Fwq)
      {
        paramInt = xvZ;
        AppMethodBeat.o(178958);
        return paramInt;
      }
      paramInt = Fwt;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    paramInt = Fwt;
    AppMethodBeat.o(178958);
    return paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "usrName", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "usrName", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<String, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "usrName", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */