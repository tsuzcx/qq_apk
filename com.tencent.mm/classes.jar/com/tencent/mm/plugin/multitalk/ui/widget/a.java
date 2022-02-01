package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarItems", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "avatarViewManager", "Lcom/tencent/mm/plugin/multitalk/model/AvatarViewManager;", "getContext", "()Landroid/content/Context;", "setContext", "footerCount", "", "headerCount", "isFooterShow", "", "mAvatarItemHasBeenShow", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mCurrentScreenSize", "Ljava/util/ArrayList;", "mCurrentVideoSize", "mIs2GOr3G", "addMember", "", "members", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "clickListener", "Landroid/view/View$OnClickListener;", "checkIsAvatarContent", "position", "findChildIndexByUsername", "userName", "getAvatarCount", "getAvatarWidth", "getItemCount", "getItemViewType", "getMarginWidth", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "index", "registerAvatarManager", "manager", "setCurrentScreenSet", "currentScreenSet", "setCurrentVideoSet", "currentVideoSet", "setIs2GOr3G", "is2GOr3G", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<b>
{
  private static final int ATI;
  private static final int ATJ;
  private static final int LsF;
  public static final a.a Lsw;
  public ArrayList<String> LsA;
  private HashSet<String> LsB;
  private boolean LsC;
  int LsD;
  public com.tencent.mm.plugin.multitalk.model.a LsE;
  public CopyOnWriteArrayList<com.tencent.mm.plugin.multitalk.data.a> Lsx;
  public boolean Lsy;
  public HashSet<String> Lsz;
  private Context context;
  public final int xZt;
  
  static
  {
    AppMethodBeat.i(178965);
    Lsw = new a.a((byte)0);
    LsF = 1;
    ATI = 2;
    ATJ = 3;
    AppMethodBeat.o(178965);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(178964);
    this.context = paramContext;
    this.Lsx = new CopyOnWriteArrayList();
    this.xZt = 1;
    this.LsD = 1;
    AppMethodBeat.o(178964);
  }
  
  private final int abN(int paramInt)
  {
    AppMethodBeat.i(285513);
    if (ghl() == 3)
    {
      if (paramInt == 2)
      {
        paramInt = ghm() / 2;
        AppMethodBeat.o(285513);
        return paramInt;
      }
      AppMethodBeat.o(285513);
      return 0;
    }
    AppMethodBeat.o(285513);
    return 0;
  }
  
  private int ghl()
  {
    AppMethodBeat.i(178961);
    int i = getItemCount();
    int j = this.xZt;
    int k = this.LsD;
    AppMethodBeat.o(178961);
    return i - j - k;
  }
  
  private final int ghm()
  {
    AppMethodBeat.i(178962);
    int j = com.tencent.mm.cd.a.mt(this.context) - com.tencent.mm.cd.a.fromDPToPix(this.context, 285);
    Point localPoint = aw.bf(this.context);
    if (localPoint != null) {
      i = localPoint.x;
    }
    while (j > i) {
      if (ghl() < 5)
      {
        i /= 2;
        AppMethodBeat.o(178962);
        return i;
        i = com.tencent.mm.cd.a.ms(this.context);
      }
      else
      {
        i /= 3;
        AppMethodBeat.o(178962);
        return i;
      }
    }
    if (ghl() < 5)
    {
      i = j / 2;
      AppMethodBeat.o(178962);
      return i;
    }
    int i = j / 3;
    AppMethodBeat.o(178962);
    return i;
  }
  
  public final void a(ArrayList<MultiTalkGroupMember> arg1, View.OnClickListener paramOnClickListener)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(178954);
        s.u(???, "members");
        s.u(paramOnClickListener, "clickListener");
        CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
        HashSet localHashSet = new HashSet();
        Iterator localIterator = ((Iterable)???).iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          ??? = localIterator.next();
          if (i < 0) {
            p.kkW();
          }
          MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)???;
          ??? = this.Lsz;
          if ((??? == null) || (???.contains(localMultiTalkGroupMember.ahhi) != true)) {
            break label432;
          }
          j = 1;
          if (j == 0)
          {
            ??? = this.LsA;
            if ((??? == null) || (???.contains(localMultiTalkGroupMember.ahhi) != true)) {
              break label438;
            }
            j = 1;
          }
          else
          {
            label139:
            Object localObject;
            if (!this.Lsy)
            {
              ??? = ((n)h.ax(n.class)).bzA().JE(localMultiTalkGroupMember.ahhi);
              if (??? == null)
              {
                ??? = null;
                localObject = ???;
                if (??? == null) {
                  localObject = localMultiTalkGroupMember.ahhi;
                }
                s.s(localObject, "contact?.displayNick?:member.usrName");
                ??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, true, (String)localObject);
                localObject = this.LsB;
                if ((localObject == null) || (((HashSet)localObject).contains(localMultiTalkGroupMember.ahhi) != true)) {
                  break label444;
                }
                j = 1;
                if (j != 0) {
                  localHashSet.add(localMultiTalkGroupMember.ahhi);
                }
                localCopyOnWriteArrayList.add(???);
                i += 1;
                continue;
              }
              ??? = ???.aSU();
              continue;
            }
            ??? = ((n)h.ax(n.class)).bzA().JE(localMultiTalkGroupMember.ahhi);
            if (??? == null)
            {
              ??? = null;
              localObject = ???;
              if (??? == null) {
                localObject = localMultiTalkGroupMember.ahhi;
              }
              s.s(localObject, "contact?.displayNick?:member.usrName");
              ??? = new com.tencent.mm.plugin.multitalk.data.a(localMultiTalkGroupMember, paramOnClickListener, i, false, (String)localObject);
              continue;
            }
            ??? = ???.aSU();
            continue;
          }
        }
        else
        {
          this.LsB = localHashSet;
          synchronized (this.Lsx)
          {
            this.Lsx.clear();
            this.Lsx.addAll((Collection)localCopyOnWriteArrayList);
            this.bZE.notifyChanged();
            paramOnClickListener = ah.aiuX;
            AppMethodBeat.o(178954);
            return;
          }
        }
        if (j == 0) {
          continue;
        }
      }
      finally {}
      for (;;)
      {
        break label139;
        label432:
        j = 0;
        break;
        label438:
        j = 0;
      }
      label444:
      int j = 0;
    }
  }
  
  public final boolean abM(int paramInt)
  {
    AppMethodBeat.i(178960);
    if ((paramInt < this.xZt) || (paramInt > getItemCount() - this.LsD - 1))
    {
      AppMethodBeat.o(178960);
      return true;
    }
    AppMethodBeat.o(178960);
    return false;
  }
  
  public final void bb(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(285547);
    s.u(paramArrayList, "currentScreenSet");
    this.LsA = paramArrayList;
    AppMethodBeat.o(285547);
  }
  
  public final void e(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(178956);
    s.u(paramHashSet, "currentVideoSet");
    this.Lsz = paramHashSet;
    AppMethodBeat.o(178956);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(178959);
    if (this.Lsx.size() > 12)
    {
      this.LsC = true;
      this.LsD = 1;
      i = this.Lsx.size();
      j = this.xZt;
      int k = this.LsD;
      AppMethodBeat.o(178959);
      return i + j + k;
    }
    this.LsC = false;
    this.LsD = 0;
    int i = this.Lsx.size();
    int j = this.xZt;
    AppMethodBeat.o(178959);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(178958);
    if (paramInt == 0)
    {
      paramInt = ATI;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    if (paramInt == getItemCount() - 1)
    {
      if (this.LsC)
      {
        paramInt = ATJ;
        AppMethodBeat.o(178958);
        return paramInt;
      }
      paramInt = LsF;
      AppMethodBeat.o(178958);
      return paramInt;
    }
    paramInt = LsF;
    AppMethodBeat.o(178958);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "usrName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "usrName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "usrName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    d(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */