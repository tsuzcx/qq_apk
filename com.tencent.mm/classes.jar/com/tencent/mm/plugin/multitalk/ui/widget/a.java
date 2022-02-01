package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import d.a.j;
import d.y;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.pb.talkroom.sdk.MultiTalkGroupMember;>;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "getContext", "()Landroid/content/Context;", "setContext", "footerCount", "", "headerCount", "isFooterShow", "", "mAvatarItemHasBeenShow", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mCurrentVideoSize", "mIs2GOr3G", "addMember", "", "members", "Ljava/util/ArrayList;", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "clickListener", "Landroid/view/View$OnClickListener;", "checkIsAvatarContent", "position", "findChildIndexByUsername", "userName", "getAvatarCount", "getAvatarWidth", "getItemCount", "getItemViewType", "getMarginWidth", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "index", "setCurrentVideoSet", "currentVideoSet", "setIs2GOr3G", "is2GOr3G", "Companion", "plugin-multitalk_release"})
public final class a
  extends RecyclerView.a<b>
{
  private static final int rgk = 2;
  private static final int rgl = 3;
  private static final int uZr = 1;
  public static final a.a uZs;
  private Context context;
  final int rZI;
  public CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> uZl;
  public boolean uZm;
  public HashSet<String> uZn;
  private HashSet<String> uZo;
  private boolean uZp;
  int uZq;
  
  static
  {
    AppMethodBeat.i(178965);
    uZs = new a.a((byte)0);
    uZr = 1;
    rgk = 2;
    rgl = 3;
    AppMethodBeat.o(178965);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(178964);
    this.context = paramContext;
    this.uZl = new CopyOnWriteArrayList();
    this.rZI = 1;
    this.uZq = 1;
    AppMethodBeat.o(178964);
  }
  
  private final int Jk(int paramInt)
  {
    AppMethodBeat.i(200717);
    switch (dgD())
    {
    default: 
      AppMethodBeat.o(200717);
      return 0;
    }
    if (paramInt == 2)
    {
      paramInt = dgE() / 2;
      AppMethodBeat.o(200717);
      return paramInt;
    }
    AppMethodBeat.o(200717);
    return 0;
  }
  
  private int dgD()
  {
    AppMethodBeat.i(178961);
    int i = getItemCount();
    int j = this.rZI;
    int k = this.uZq;
    AppMethodBeat.o(178961);
    return i - j - k;
  }
  
  private final int dgE()
  {
    AppMethodBeat.i(178962);
    int i = com.tencent.mm.cc.a.ih(this.context) - com.tencent.mm.cc.a.fromDPToPix(this.context, 285);
    int j = com.tencent.mm.cc.a.ig(this.context);
    if (i > j)
    {
      if (dgD() < 5)
      {
        i = j / 2;
        AppMethodBeat.o(178962);
        return i;
      }
      i = j / 3;
      AppMethodBeat.o(178962);
      return i;
    }
    if (dgD() < 5)
    {
      i /= 2;
      AppMethodBeat.o(178962);
      return i;
    }
    i /= 3;
    AppMethodBeat.o(178962);
    return i;
  }
  
  public final boolean Jj(int paramInt)
  {
    AppMethodBeat.i(178960);
    if ((paramInt < this.rZI) || (paramInt > getItemCount() - this.uZq - 1))
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
      d.g.b.k.h(???, "members");
      d.g.b.k.h(paramOnClickListener, "clickListener");
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext())
      {
        ??? = localIterator.next();
        if (i < 0) {
          j.fOc();
        }
        MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)???;
        ??? = this.uZn;
        Object localObject;
        if ((??? != null) && (???.contains(localMultiTalkGroupMember.JPW) == true) && (!this.uZm))
        {
          ??? = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(???, "MMKernel.service(IMessengerStorage::class.java)");
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.k)???).awB().aNt(localMultiTalkGroupMember.JPW);
          if (??? != null)
          {
            localObject = ???.aaR();
            ??? = (ArrayList<MultiTalkGroupMember>)localObject;
            if (localObject != null) {}
          }
          else
          {
            ??? = localMultiTalkGroupMember.JPW;
            d.g.b.k.g(???, "member.usrName");
          }
        }
        for (??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, true, ???);; ??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, false, ???))
        {
          localObject = this.uZo;
          if ((localObject != null) && (((HashSet)localObject).contains(localMultiTalkGroupMember.JPW) == true)) {
            localHashSet.add(localMultiTalkGroupMember.JPW);
          }
          localCopyOnWriteArrayList.add(???);
          i += 1;
          break;
          ??? = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(???, "MMKernel.service(IMessengerStorage::class.java)");
          ??? = ((com.tencent.mm.plugin.messenger.foundation.a.k)???).awB().aNt(localMultiTalkGroupMember.JPW);
          if (??? != null)
          {
            localObject = ???.aaR();
            ??? = (ArrayList<MultiTalkGroupMember>)localObject;
            if (localObject != null) {}
          }
          else
          {
            ??? = localMultiTalkGroupMember.JPW;
            d.g.b.k.g(???, "member.usrName");
          }
        }
      }
      this.uZo = localHashSet;
    }
    finally {}
    synchronized (this.uZl)
    {
      this.uZl.clear();
      this.uZl.addAll((Collection)localCopyOnWriteArrayList);
      notifyDataSetChanged();
      paramOnClickListener = y.KTp;
      AppMethodBeat.o(178954);
      return;
    }
  }
  
  public final int amE(String paramString)
  {
    AppMethodBeat.i(178955);
    d.g.b.k.h(paramString, "userName");
    Iterator localIterator = ((Iterable)this.uZl).iterator();
    Object localObject1;
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      localObject1 = (com.tencent.mm.plugin.multitalk.data.a)localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitalk.data.a)localObject1).uWR;
        if (localObject1 != null)
        {
          localObject1 = ((MultiTalkGroupMember)localObject1).JPW;
          label77:
          if (!d.g.b.k.g(localObject1, paramString)) {
            break label122;
          }
          paramString = localObject2;
          label89:
          paramString = (com.tencent.mm.plugin.multitalk.data.a)paramString;
          if (paramString == null) {
            break label129;
          }
        }
      }
    }
    label129:
    for (int i = paramString.index;; i = -1)
    {
      int j = this.rZI;
      AppMethodBeat.o(178955);
      return i + j;
      localObject1 = null;
      break label77;
      label122:
      break;
      paramString = null;
      break label89;
    }
  }
  
  public final void d(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(178956);
    d.g.b.k.h(paramHashSet, "currentVideoSet");
    this.uZn = paramHashSet;
    AppMethodBeat.o(178956);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178959);
    if (this.uZl.size() > 12)
    {
      this.uZp = true;
      this.uZq = 1;
      i = this.uZl.size();
      j = this.rZI;
      int k = this.uZq;
      AppMethodBeat.o(178959);
      return i + j + k;
    }
    this.uZp = false;
    this.uZq = 0;
    int i = this.uZl.size();
    int j = this.rZI;
    AppMethodBeat.o(178959);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(178958);
    if (paramInt == 0)
    {
      paramInt = rgk;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    if (paramInt == getItemCount() - 1)
    {
      if (this.uZp)
      {
        paramInt = rgl;
        AppMethodBeat.o(178958);
        return paramInt;
      }
      paramInt = uZr;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    paramInt = uZr;
    AppMethodBeat.o(178958);
    return paramInt;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "usrName", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "usrName", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "usrName", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<String, y>
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