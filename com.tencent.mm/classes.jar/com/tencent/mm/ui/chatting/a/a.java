package com.tencent.mm.ui.chatting.a;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.q;
import com.tencent.mm.az.f;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.s.f;
import com.tencent.mm.ui.chatting.s.g;
import com.tencent.mm.ui.chatting.viewitems.an.a;
import com.tencent.mm.ui.chatting.viewitems.an.b;
import com.tencent.mm.ui.chatting.viewitems.aw.d;
import com.tencent.mm.ui.chatting.viewitems.bj;
import com.tencent.mm.ui.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public final class a
  extends BaseAdapter
  implements i
{
  public com.tencent.mm.ui.chatting.d.a FQd;
  private l GrA;
  public aa GrB;
  private aa GrC;
  public com.tencent.mm.ui.chatting.c GrD;
  private com.tencent.mm.ui.chatting.c GrE;
  private View.OnClickListener GrF;
  private final int GrG;
  private final int GrH;
  public SparseArray<bl> GrI;
  private HashSet<Long> GrJ;
  public SparseIntArray GrK;
  public long GrL;
  private TreeSet<Long> GrM;
  private Map<Long, Integer> GrN;
  private Map<Long, WeakReference<View>> GrO;
  private boolean GrP;
  private boolean GrQ;
  private final av GrR;
  public com.tencent.mm.ui.chatting.m.a.a GrS;
  private boolean GrT;
  private int GrU;
  protected h.a GrV;
  private t.a GrW;
  private long GrX;
  public s.g Grv;
  private s.g Grw;
  public s.f Grx;
  private s.f Gry;
  public l Grz;
  private boolean cMh;
  public com.tencent.mm.aw.a.a.c fvx;
  private int fwK;
  private LayoutInflater imq;
  private ListView mListView;
  private com.tencent.mm.pluginsdk.ui.span.h mYs;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, ListView paramListView)
  {
    AppMethodBeat.i(34989);
    this.GrF = null;
    this.GrI = new SparseArray();
    this.GrJ = new HashSet();
    this.GrK = new SparseIntArray();
    this.GrL = -1L;
    this.GrM = new TreeSet();
    this.GrN = new HashMap();
    this.GrO = new HashMap();
    this.GrP = false;
    this.GrQ = false;
    this.GrR = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34984);
        if ((a.a(a.this) != null) && (a.a(a.this).ctF))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
          a.this.eWj();
        }
        AppMethodBeat.o(34984);
        return true;
      }
    }, true);
    this.fwK = -1;
    this.GrT = false;
    this.GrU = 0;
    this.GrV = new h.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramAnonymoush, h.c paramAnonymousc)
      {
        AppMethodBeat.i(34986);
        if ((paramAnonymoush == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(34986);
          return;
        }
        if ((paramAnonymousc.talker == null) || (a.a(a.this).getTalkerUserName() == null))
        {
          AppMethodBeat.o(34986);
          return;
        }
        if (paramAnonymousc.talker.equals(a.a(a.this).getTalkerUserName())) {
          a.this.eWj();
        }
        AppMethodBeat.o(34986);
      }
    };
    this.GrW = new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(34988);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousa != null)
        {
          bool1 = bool2;
          if (paramAnonymousa.hAo != 3) {
            if ((paramAnonymousa.hAo != 2) && (paramAnonymousa.hAo != -1))
            {
              bool1 = bool2;
              if (paramAnonymousa.hAo != 1) {}
            }
            else
            {
              bool1 = aw.d.b(paramAnonymousa);
            }
          }
        }
        if (!bool1) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34987);
              a.this.eWj();
              AppMethodBeat.o(34987);
            }
          });
        }
        AppMethodBeat.o(34988);
      }
    };
    this.GrX = -1L;
    this.fvx = null;
    parama.a(i.class, this);
    this.mListView = paramListView;
    this.FQd = parama;
    this.imq = y.js(parama.GzJ.getContext());
    this.GrG = parama.GzJ.getMMResources().getDimensionPixelSize(2131165575);
    this.GrH = parama.GzJ.getMMResources().getDimensionPixelSize(2131165490);
    paramListView = new s.g();
    this.Grw = paramListView;
    this.Grv = paramListView;
    paramListView = new s.f(parama);
    this.Gry = paramListView;
    this.Grx = paramListView;
    paramListView = new l(parama.GzJ.getContext());
    this.GrA = paramListView;
    this.Grz = paramListView;
    paramListView = new aa(parama);
    this.GrC = paramListView;
    this.GrB = paramListView;
    paramListView = new com.tencent.mm.ui.chatting.c(parama);
    this.GrE = paramListView;
    this.GrD = paramListView;
    this.mYs = new com.tencent.mm.ui.chatting.af(parama);
    eyl();
    AppMethodBeat.o(34989);
  }
  
  private void eWf()
  {
    AppMethodBeat.i(34994);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
    this.Grv = null;
    this.Grx = null;
    this.Grz = null;
    this.GrB = null;
    this.GrD = null;
    AppMethodBeat.o(34994);
  }
  
  private void eyl()
  {
    AppMethodBeat.i(35018);
    if (this.fvx == null)
    {
      com.tencent.mm.aw.a.a.c.a locala = new com.tencent.mm.aw.a.a.c.a();
      locala.prefixPath = com.tencent.mm.am.a.e.xs(this.FQd.getTalkerUserName());
      locala.hjU = true;
      locala.gjA = true;
      locala.hkf = 2131690013;
      try
      {
        this.fvx = locala.azc();
        AppMethodBeat.o(35018);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.ChattingDataAdapter", localNullPointerException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(35018);
  }
  
  public final void I(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35013);
    if ((!this.GrO.containsKey(Long.valueOf(paramLong))) || (!this.GrN.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35013);
      return;
    }
    Object localObject = (WeakReference)this.GrO.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        an.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramBoolean);
      }
      AppMethodBeat.o(35013);
      return;
    }
  }
  
  public final bl YE(int paramInt)
  {
    AppMethodBeat.i(34999);
    bl localbl = (bl)this.GrI.get(paramInt);
    AppMethodBeat.o(34999);
    return localbl;
  }
  
  public final void YF(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(35007);
    bl localbl = YE(paramInt);
    if (localbl == null) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[setShowHistoryMsgTipId] pos:%s msg is null? %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if ((localbl != null) && (localbl.field_msgId != 0L)) {
      this.GrL = localbl.field_msgId;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(35007);
  }
  
  public final void YG(int paramInt)
  {
    AppMethodBeat.i(35015);
    bl localbl = YE(paramInt);
    if ((localbl != null) && (localbl.field_msgId != 0L)) {
      this.GrJ.add(Long.valueOf(localbl.field_msgId));
    }
    AppMethodBeat.o(35015);
  }
  
  public final bl YH(int paramInt)
  {
    AppMethodBeat.i(161523);
    paramInt -= 1;
    if ((this.GrI != null) && (paramInt >= 0) && (paramInt < this.GrI.size()))
    {
      bl localbl = (bl)this.GrI.get(paramInt);
      AppMethodBeat.o(161523);
      return localbl;
    }
    AppMethodBeat.o(161523);
    return null;
  }
  
  public final void a(int paramInt, d.a parama)
  {
    AppMethodBeat.i(35009);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", new Object[] { Integer.valueOf(paramInt), parama });
    Bundle localBundle = new Bundle();
    localBundle.putInt("MSG_POSITION", paramInt);
    localBundle.putInt("SCENE", 2);
    this.GrS.a(parama, false, localBundle);
    AppMethodBeat.o(35009);
  }
  
  public final void a(long paramLong, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(35014);
    if ((!this.GrO.containsKey(Long.valueOf(paramLong))) || (!this.GrN.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35014);
      return;
    }
    Object localObject = (WeakReference)this.GrO.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        an.a.a(this.FQd.GzJ.getContext(), (com.tencent.mm.ui.chatting.viewitems.c.a)localObject, parambl, paramBoolean);
      }
      AppMethodBeat.o(35014);
      return;
    }
  }
  
  public final void a(long paramLong, d.a parama)
  {
    AppMethodBeat.i(179850);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", new Object[] { Long.valueOf(paramLong), Boolean.FALSE, parama });
    Bundle localBundle = new Bundle();
    localBundle.putLong("MSG_ID", paramLong);
    localBundle.putInt("SCENE", 1);
    localBundle.putBoolean("IS_LOAD_ALL", false);
    this.GrS.a(parama, true, localBundle);
    AppMethodBeat.o(179850);
  }
  
  public final void ciV()
  {
    AppMethodBeat.i(35003);
    this.GrP = false;
    notifyDataSetChanged();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
    this.Grv = this.Grw;
    this.Grx = this.Gry;
    this.Grz = this.GrA;
    this.GrB = this.GrC;
    this.GrD = this.GrE;
    AppMethodBeat.o(35003);
  }
  
  public final int deG()
  {
    AppMethodBeat.i(35001);
    int i = this.GrM.size();
    AppMethodBeat.o(35001);
    return i;
  }
  
  public final void eH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35020);
    if (this.FQd == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    Object localObject1 = this.FQd.zgX;
    if (localObject1 == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBS();
    bl localbl;
    Object localObject2;
    if (((com.tencent.mm.storage.af)localObject1).eKB())
    {
      localObject1 = new ArrayList();
      while (paramInt1 <= paramInt2)
      {
        localbl = YH(paramInt1);
        if ((localbl != null) && (localbl.getType() == 285212721))
        {
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + localbl.field_msgId);
          ((List)localObject1).add(new String[] { String.valueOf(localbl.field_msgId), localbl.field_content, "-1" });
          localObject2 = new q();
          ((q)localObject2).msgId = localbl.field_msgId;
          ((q)localObject2).gKr = localbl.field_content;
          if (bool) {
            localLinkedList.add(localObject2);
          }
        }
        paramInt1 += 1;
      }
      if (((List)localObject1).size() > 0)
      {
        ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).j((List)localObject1, 0);
        if (bool) {
          ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).k(localLinkedList, 0);
        }
      }
      AppMethodBeat.o(35020);
      return;
    }
    localLinkedList = new LinkedList();
    Object localObject3;
    String str;
    int j;
    Object localObject4;
    if (paramInt1 <= paramInt2)
    {
      localbl = YH(paramInt1);
      if ((localbl != null) && ((localbl.getType() & 0x31) != 0))
      {
        localObject2 = localbl.field_content;
        if (localObject2 != null)
        {
          localObject2 = k.b.ar((String)localObject2, localbl.field_reserved);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((k.b)localObject2).url)) && (((k.b)localObject2).url.contains("mp.weixin.qq.com")))
          {
            localObject3 = bj.cq(localbl);
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.ui.chatting.viewitems.c)localObject3).b(this.FQd, localbl);
              if (localObject3 != null)
              {
                str = ((au)localObject1).field_username;
                if (str != null)
                {
                  j = x.aw((String)localObject3, this.FQd.getTalkerUserName());
                  localObject4 = (com.tencent.mm.ai.e)((k.b)localObject2).ao(com.tencent.mm.ai.e.class);
                  if (localObject4 == null) {
                    break label629;
                  }
                }
              }
            }
          }
        }
      }
    }
    label629:
    for (int i = ((com.tencent.mm.ai.e)localObject4).gGx;; i = -1)
    {
      localObject4 = new ArrayList();
      ((List)localObject4).add(((k.b)localObject2).url);
      ((List)localObject4).add(String.valueOf(i));
      ((List)localObject4).add(String.valueOf(localbl.field_msgSvrId));
      ((List)localObject4).add(str);
      ((List)localObject4).add(String.valueOf(j));
      ((List)localObject4).add(localObject3);
      ((List)localObject4).add(String.valueOf(localbl.field_createTime));
      ((List)localObject4).add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).OZ(str)));
      localLinkedList.add(localObject4);
      paramInt1 += 1;
      break;
      if (localLinkedList.size() > 0) {
        ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).i(localLinkedList, 1);
      }
      AppMethodBeat.o(35020);
      return;
    }
  }
  
  public final int eKa()
  {
    AppMethodBeat.i(34998);
    if (-1 == this.fwK)
    {
      az.arV();
      this.fwK = com.tencent.mm.model.c.apO().agE(this.FQd.getTalkerUserName());
    }
    int i = this.fwK;
    AppMethodBeat.o(34998);
    return i;
  }
  
  public final Set<Long> eWg()
  {
    return this.GrM;
  }
  
  public final void eWh()
  {
    AppMethodBeat.i(35002);
    if (this.GrM != null) {
      this.GrM.clear();
    }
    AppMethodBeat.o(35002);
  }
  
  public final void eWi()
  {
    AppMethodBeat.i(35004);
    this.GrP = true;
    notifyDataSetChanged();
    eWf();
    AppMethodBeat.o(35004);
  }
  
  public final void eWj()
  {
    AppMethodBeat.i(35006);
    if (this.GrT)
    {
      this.GrU += 1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.GrU);
      AppMethodBeat.o(35006);
      return;
    }
    if (!this.cMh)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
      AppMethodBeat.o(35006);
      return;
    }
    this.GrS.a(d.a.GEW, false, null);
    AppMethodBeat.o(35006);
  }
  
  public final void eWk()
  {
    AppMethodBeat.i(35010);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.GrT), Integer.valueOf(this.GrU) });
    if (this.GrT)
    {
      AppMethodBeat.o(35010);
      return;
    }
    this.GrT = true;
    this.GrU = 0;
    AppMethodBeat.o(35010);
  }
  
  public final void eWl()
  {
    AppMethodBeat.i(35011);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.GrT), Integer.valueOf(this.GrU) });
    if (!this.GrT)
    {
      AppMethodBeat.o(35011);
      return;
    }
    this.GrT = false;
    if (this.GrU > 0) {
      this.GrS.a(d.a.GEW, false, null);
    }
    this.GrU = 0;
    AppMethodBeat.o(35011);
  }
  
  public final void eWm()
  {
    AppMethodBeat.i(35016);
    this.GrQ = true;
    eWf();
    AppMethodBeat.o(35016);
  }
  
  public final t.a eWn()
  {
    return this.GrW;
  }
  
  public final s.f eWo()
  {
    return this.Grx;
  }
  
  public final s.g eWp()
  {
    return this.Grv;
  }
  
  public final aa eWq()
  {
    return this.GrB;
  }
  
  public final l eWr()
  {
    return this.Grz;
  }
  
  public final com.tencent.mm.ui.chatting.c eWs()
  {
    return this.GrD;
  }
  
  public final long eWt()
  {
    AppMethodBeat.i(35017);
    long l;
    if (this.GrX != -1L)
    {
      l = this.GrX;
      AppMethodBeat.o(35017);
      return l;
    }
    this.GrX = 0L;
    int i = getCount() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        bl localbl = YE(i);
        if ((localbl.field_isSend == 1) && ((localbl.esg & 0x4) != 4)) {
          this.GrX = localbl.field_msgId;
        }
      }
      else
      {
        l = this.GrX;
        AppMethodBeat.o(35017);
        return l;
      }
      i -= 1;
    }
  }
  
  public final com.tencent.mm.aw.a.a.c eWu()
  {
    AppMethodBeat.i(35019);
    if (this.fvx == null) {
      eyl();
    }
    com.tencent.mm.aw.a.a.c localc = this.fvx;
    AppMethodBeat.o(35019);
    return localc;
  }
  
  public final void evL()
  {
    AppMethodBeat.i(34997);
    com.tencent.mm.ui.chatting.d.a.eZd().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34985);
        a.this.notifyDataSetChanged();
        AppMethodBeat.o(34985);
      }
    });
    AppMethodBeat.o(34997);
  }
  
  public final void g(View.OnClickListener paramOnClickListener)
  {
    this.GrF = paramOnClickListener;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34990);
    int i = this.GrI.size();
    AppMethodBeat.o(34990);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(34991);
    paramInt = bj.cr(YE(paramInt));
    AppMethodBeat.o(34991);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34993);
    bl localbl = YE(paramInt);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[getView] position:" + paramInt + " msgId:" + localbl.field_msgId + " svrId:" + localbl.field_msgSvrId + " type:" + localbl.getType() + " send:" + localbl.field_isSend + " talker:" + localbl.field_talker + " msgSep:" + localbl.field_msgSeq + " time:" + localbl.field_createTime);
    if (paramInt == 0)
    {
      paramViewGroup = this.FQd;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
      paramViewGroup.GzK.eVU();
    }
    int i;
    int j;
    label226:
    label245:
    boolean bool;
    label294:
    label310:
    int k;
    label357:
    Object localObject;
    if ((paramInt != 0) && (this.GrK.get(paramInt) == 0))
    {
      long l1 = YE(paramInt - 1).field_createTime;
      long l2 = localbl.field_createTime;
      if (l2 - l1 < 60000L)
      {
        i = 1;
        if ((l2 - l1) / 180000L >= 1L) {
          break label1115;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label1121;
        }
        this.GrK.put(paramInt, 2);
      }
    }
    else
    {
      if (((this.GrK.get(paramInt) != 1) && (paramInt != 0) && (!this.GrJ.contains(Long.valueOf(localbl.field_msgId)))) || (localbl.field_createTime <= 1000L)) {
        break label1133;
      }
      i = 1;
      if (localbl.field_msgId != this.GrL) {
        break label1139;
      }
      j = 1;
      paramViewGroup = t.azZ().yR(this.FQd.getTalkerUserName());
      bool = true;
      if (paramViewGroup != null) {
        break label1145;
      }
      az.arV();
      k = ((Integer)com.tencent.mm.model.c.afk().get(12311, Integer.valueOf(-2))).intValue();
      if (k != -2) {
        bool = false;
      }
      if (paramView != null) {
        break label1154;
      }
      localObject = bj.cq(localbl);
      paramView = ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(this.imq, paramView);
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.GIb = ((com.tencent.mm.ui.chatting.viewitems.c)localObject);
      paramViewGroup.setChattingBG(bool);
      label409:
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", new Object[] { paramViewGroup.GIb });
      if (i == 0) {
        break label1171;
      }
      paramViewGroup.fwS.setVisibility(0);
      paramViewGroup.fwS.setText(com.tencent.mm.pluginsdk.g.h.c(this.FQd.GzJ.getContext(), localbl.field_createTime, false));
      if (paramViewGroup.fwS.getTextSize() > com.tencent.mm.cd.a.fromDPToPix(this.FQd.GzJ.getContext(), 25)) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", new Object[] { Float.valueOf(paramViewGroup.fwS.getTextSize()) });
      }
      label519:
      if (paramViewGroup.GHY != null)
      {
        if (j == 0) {
          break label1183;
        }
        paramViewGroup.GHY.setVisibility(0);
      }
      label539:
      localObject = paramViewGroup.GIb;
      paramViewGroup.GIa = null;
      f localf = com.tencent.mm.az.a.azI();
      if ((localf != null) && (localf.hnp != null) && (localf.hnn == 0) && (com.tencent.mm.az.a.azF())) {
        paramViewGroup.GIa = localf.hnp;
      }
      ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(paramViewGroup, paramInt, this.FQd, localbl);
      localObject = ((com.tencent.mm.ui.chatting.c.b.c)this.FQd.be(com.tencent.mm.ui.chatting.c.b.c.class)).eXd();
      if ((paramViewGroup.fwS.getVisibility() == 0) && (localObject != null))
      {
        paramViewGroup.fwS.setTextColor(((com.tencent.mm.pluginsdk.ui.e)localObject).BUI);
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).BUJ) {
          break label1195;
        }
        paramViewGroup.fwS.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.e)localObject).BUK);
        label678:
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).BUL) {
          break label1222;
        }
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).BUM) {
          break label1209;
        }
        paramViewGroup.fwS.setBackgroundResource(2131231583);
        label704:
        paramViewGroup.fwS.setPadding(this.GrH, this.GrG, this.GrH, this.GrG);
      }
      label727:
      if ((paramViewGroup.wet != null) && (paramViewGroup.wet.getVisibility() == 0) && (localObject != null) && (!this.FQd.getTalkerUserName().equals("qqmail")) && (localbl.getType() != 318767153))
      {
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).BUM) {
          break label1233;
        }
        paramViewGroup.wet.setTextColor(-1);
        paramViewGroup.wet.setShadowLayer(com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.wet.getContext(), 2), 0.0F, com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.wet.getContext(), 1), this.FQd.GzJ.getMMResources().getColor(2131099662));
      }
      label840:
      if (paramViewGroup.lRB != null) {
        paramViewGroup.lRB.setTag(Long.valueOf(localbl.field_msgId));
      }
      if (this.GrP)
      {
        if (!localbl.isSystem()) {
          break label1259;
        }
        paramInt = 0;
        label879:
        if (paramInt != 0) {}
      }
      else
      {
        if (!this.GrQ) {
          break label1264;
        }
      }
      if (paramViewGroup.hIS != null) {
        paramViewGroup.hIS.setChecked(this.GrM.contains(Long.valueOf(localbl.field_msgId)));
      }
      if (paramViewGroup.lRB != null) {
        paramViewGroup.lRB.setOnClickListener(this.GrF);
      }
      paramViewGroup.wp(true);
    }
    for (;;)
    {
      paramViewGroup = this.GrO.entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        localObject = (Map.Entry)paramViewGroup.next();
        if ((((Map.Entry)localObject).getValue() != null) && ((View)((WeakReference)((Map.Entry)localObject).getValue()).get() == paramView))
        {
          this.GrO.remove(((Map.Entry)localObject).getKey());
          this.GrN.remove(((Map.Entry)localObject).getKey());
        }
      }
      this.GrO.put(Long.valueOf(localbl.field_msgId), new WeakReference(paramView));
      if (localbl.eJO()) {
        this.GrN.put(Long.valueOf(localbl.field_msgId), Integer.valueOf(localbl.field_isSend));
      }
      AppMethodBeat.o(34993);
      return paramView;
      i = 0;
      break;
      label1115:
      j = 0;
      break label226;
      label1121:
      this.GrK.put(paramInt, 1);
      break label245;
      label1133:
      i = 0;
      break label294;
      label1139:
      j = 0;
      break label310;
      label1145:
      k = paramViewGroup.hoW;
      break label357;
      label1154:
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.setChattingBG(bool);
      break label409;
      label1171:
      paramViewGroup.fwS.setVisibility(8);
      break label519;
      label1183:
      paramViewGroup.GHY.setVisibility(8);
      break label539;
      label1195:
      paramViewGroup.fwS.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label678;
      label1209:
      paramViewGroup.fwS.setBackgroundResource(2131231582);
      break label704;
      label1222:
      paramViewGroup.fwS.setBackgroundColor(0);
      break label727;
      label1233:
      paramViewGroup.wet.setTextColor(((com.tencent.mm.pluginsdk.ui.e)localObject).BUI);
      paramViewGroup.wet.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label840;
      label1259:
      paramInt = 1;
      break label879;
      label1264:
      paramViewGroup.wp(false);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(34992);
    int i = bj.faU();
    AppMethodBeat.o(34992);
    return i;
  }
  
  public final boolean isInEditMode()
  {
    return this.GrP;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35005);
    super.notifyDataSetChanged();
    this.GrK.clear();
    AppMethodBeat.o(35005);
  }
  
  public final void o(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35012);
    if ((!this.GrO.containsKey(Long.valueOf(paramLong))) || (!this.GrN.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35012);
      return;
    }
    Object localObject = (WeakReference)this.GrO.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        an.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramInt1, paramInt2);
      }
      AppMethodBeat.o(35012);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(34996);
    this.cMh = false;
    az.arV();
    com.tencent.mm.model.c.apO().a(this.GrV);
    k.b(this.mYs);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "adapter pause");
    this.GrR.stopTimer();
    AppMethodBeat.o(34996);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(34995);
    this.cMh = true;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "adapter resume");
    az.arV();
    com.tencent.mm.model.c.apO().a(this.GrV, Looper.getMainLooper());
    k.a(this.mYs);
    this.GrR.av(300000L, 300000L);
    if (this.GrS != null) {
      this.GrS.a(d.a.GEW, false, null);
    }
    AppMethodBeat.o(34995);
  }
  
  public final boolean wA(long paramLong)
  {
    AppMethodBeat.i(35000);
    int i;
    label60:
    Object localObject;
    if (this.GrM.contains(Long.valueOf(paramLong)))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      this.GrM.remove(Long.valueOf(paramLong));
      if (this.mListView == null) {
        break label291;
      }
      i = 0;
      if (i >= this.mListView.getChildCount()) {
        break label291;
      }
      localObject = this.mListView.getChildAt(i);
      com.tencent.mm.ui.chatting.viewitems.c.a locala = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((locala == null) || (locala.lRB == null) || (((Long)locala.lRB.getTag()).longValue() != paramLong)) {
        break label284;
      }
      label123:
      if (localObject == null) {
        break label297;
      }
      localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).hIS != null) && (((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).hIS.getVisibility() == 0)) {
        ((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).hIS.setChecked(this.GrM.contains(Long.valueOf(paramLong)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35000);
      return true;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      if (this.GrM.size() >= 100)
      {
        com.tencent.mm.ui.base.h.c(this.FQd.GzJ.getContext(), this.FQd.GzJ.getMMResources().getString(2131758462, new Object[] { Integer.valueOf(100) }), "", true);
        AppMethodBeat.o(35000);
        return false;
      }
      this.GrM.add(Long.valueOf(paramLong));
      break;
      label284:
      i += 1;
      break label60;
      label291:
      localObject = null;
      break label123;
      label297:
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a
 * JD-Core Version:    0.7.0.1
 */