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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ad;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.g.d.a;
import com.tencent.mm.ui.chatting.s.f;
import com.tencent.mm.ui.chatting.s.g;
import com.tencent.mm.ui.chatting.viewitems.ao.a;
import com.tencent.mm.ui.chatting.viewitems.ao.b;
import com.tencent.mm.ui.chatting.viewitems.ax.d;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.z;
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
  public SparseArray<bo> HRA;
  private HashSet<Long> HRB;
  public SparseIntArray HRC;
  public long HRD;
  private TreeSet<Long> HRE;
  private Map<Long, Integer> HRF;
  private Map<Long, WeakReference<View>> HRG;
  private boolean HRH;
  private boolean HRI;
  private final au HRJ;
  public com.tencent.mm.ui.chatting.m.a.a HRK;
  private boolean HRL;
  private int HRM;
  protected h.a HRN;
  private t.a HRO;
  private long HRP;
  public s.g HRn;
  private s.g HRo;
  public s.f HRp;
  private s.f HRq;
  public l HRr;
  private l HRs;
  public ab HRt;
  private ab HRu;
  public com.tencent.mm.ui.chatting.c HRv;
  private com.tencent.mm.ui.chatting.c HRw;
  private View.OnClickListener HRx;
  private final int HRy;
  private final int HRz;
  public com.tencent.mm.ui.chatting.d.a HpO;
  private boolean cJp;
  private int fAr;
  public com.tencent.mm.av.a.a.c fze;
  private LayoutInflater iMw;
  private ListView mListView;
  private com.tencent.mm.pluginsdk.ui.span.h nAR;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, ListView paramListView)
  {
    AppMethodBeat.i(34989);
    this.HRx = null;
    this.HRA = new SparseArray();
    this.HRB = new HashSet();
    this.HRC = new SparseIntArray();
    this.HRD = -1L;
    this.HRE = new TreeSet();
    this.HRF = new HashMap();
    this.HRG = new HashMap();
    this.HRH = false;
    this.HRI = false;
    this.HRJ = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34984);
        if ((a.a(a.this) != null) && (a.a(a.this).cqM))
        {
          ac.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
          a.this.flV();
        }
        AppMethodBeat.o(34984);
        return true;
      }
    }, true);
    this.fAr = -1;
    this.HRL = false;
    this.HRM = 0;
    this.HRN = new h.a()
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
          a.this.flV();
        }
        AppMethodBeat.o(34986);
      }
    };
    this.HRO = new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(34988);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousa != null)
        {
          bool1 = bool2;
          if (paramAnonymousa.iaP != 3) {
            if ((paramAnonymousa.iaP != 2) && (paramAnonymousa.iaP != -1))
            {
              bool1 = bool2;
              if (paramAnonymousa.iaP != 1) {}
            }
            else
            {
              bool1 = ax.d.b(paramAnonymousa);
            }
          }
        }
        if (!bool1) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34987);
              a.this.flV();
              AppMethodBeat.o(34987);
            }
          });
        }
        AppMethodBeat.o(34988);
      }
    };
    this.HRP = -1L;
    this.fze = null;
    parama.a(i.class, this);
    this.mListView = paramListView;
    this.HpO = parama;
    this.iMw = z.jD(parama.HZF.getContext());
    this.HRy = parama.HZF.getMMResources().getDimensionPixelSize(2131165575);
    this.HRz = parama.HZF.getMMResources().getDimensionPixelSize(2131165490);
    paramListView = new s.g();
    this.HRo = paramListView;
    this.HRn = paramListView;
    paramListView = new s.f(parama);
    this.HRq = paramListView;
    this.HRp = paramListView;
    paramListView = new l(parama.HZF.getContext());
    this.HRs = paramListView;
    this.HRr = paramListView;
    paramListView = new ab(parama);
    this.HRu = paramListView;
    this.HRt = paramListView;
    paramListView = new com.tencent.mm.ui.chatting.c(parama);
    this.HRw = paramListView;
    this.HRv = paramListView;
    this.nAR = new af(parama);
    eNF();
    AppMethodBeat.o(34989);
  }
  
  private void eNF()
  {
    AppMethodBeat.i(35018);
    if (this.fze == null)
    {
      com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
      locala.prefixPath = com.tencent.mm.al.a.e.By(this.HpO.getTalkerUserName());
      locala.hKx = true;
      locala.gKm = true;
      locala.hKI = 2131690013;
      try
      {
        this.fze = locala.aFT();
        AppMethodBeat.o(35018);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        ac.printErrStackTrace("MicroMsg.ChattingDataAdapter", localNullPointerException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(35018);
  }
  
  private void flR()
  {
    AppMethodBeat.i(34994);
    ac.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
    this.HRn = null;
    this.HRp = null;
    this.HRr = null;
    this.HRt = null;
    this.HRv = null;
    AppMethodBeat.o(34994);
  }
  
  public final boolean Bd(long paramLong)
  {
    AppMethodBeat.i(35000);
    int i;
    label61:
    Object localObject;
    if (this.HRE.contains(Long.valueOf(paramLong)))
    {
      ac.d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      this.HRE.remove(Long.valueOf(paramLong));
      if (this.mListView == null) {
        break label293;
      }
      i = 0;
      if (i >= this.mListView.getChildCount()) {
        break label293;
      }
      localObject = this.mListView.getChildAt(i);
      com.tencent.mm.ui.chatting.viewitems.c.a locala = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((locala == null) || (locala.gGk == null) || (((Long)locala.gGk.getTag()).longValue() != paramLong)) {
        break label286;
      }
      label124:
      if (localObject == null) {
        break label299;
      }
      localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).ijt != null) && (((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).ijt.getVisibility() == 0)) {
        ((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).ijt.setChecked(this.HRE.contains(Long.valueOf(paramLong)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35000);
      return true;
      ac.d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      if (this.HRE.size() >= 100)
      {
        com.tencent.mm.ui.base.h.c(this.HpO.HZF.getContext(), this.HpO.HZF.getMMResources().getString(2131758462, new Object[] { Integer.valueOf(100) }), "", true);
        AppMethodBeat.o(35000);
        return false;
      }
      this.HRE.add(Long.valueOf(paramLong));
      break;
      label286:
      i += 1;
      break label61;
      label293:
      localObject = null;
      break label124;
      label299:
      notifyDataSetChanged();
    }
  }
  
  public final void I(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35013);
    if ((!this.HRG.containsKey(Long.valueOf(paramLong))) || (!this.HRF.containsKey(Long.valueOf(paramLong))))
    {
      ac.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35013);
      return;
    }
    Object localObject = (WeakReference)this.HRG.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ao.b.c((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramBoolean);
      }
      AppMethodBeat.o(35013);
      return;
    }
  }
  
  public final void a(int paramInt, d.a parama)
  {
    AppMethodBeat.i(35009);
    ac.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", new Object[] { Integer.valueOf(paramInt), parama });
    Bundle localBundle = new Bundle();
    localBundle.putInt("MSG_POSITION", paramInt);
    localBundle.putInt("SCENE", 2);
    this.HRK.a(parama, false, localBundle);
    AppMethodBeat.o(35009);
  }
  
  public final void a(long paramLong, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(35014);
    if ((!this.HRG.containsKey(Long.valueOf(paramLong))) || (!this.HRF.containsKey(Long.valueOf(paramLong))))
    {
      ac.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35014);
      return;
    }
    Object localObject = (WeakReference)this.HRG.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        ao.a.a(this.HpO.HZF.getContext(), (com.tencent.mm.ui.chatting.viewitems.c.a)localObject, parambo, paramBoolean);
      }
      AppMethodBeat.o(35014);
      return;
    }
  }
  
  public final void a(long paramLong, d.a parama)
  {
    AppMethodBeat.i(179850);
    ac.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", new Object[] { Long.valueOf(paramLong), Boolean.FALSE, parama });
    Bundle localBundle = new Bundle();
    localBundle.putLong("MSG_ID", paramLong);
    localBundle.putInt("SCENE", 1);
    localBundle.putBoolean("IS_LOAD_ALL", false);
    this.HRK.a(parama, true, localBundle);
    AppMethodBeat.o(179850);
  }
  
  public final bo aaP(int paramInt)
  {
    AppMethodBeat.i(34999);
    bo localbo = (bo)this.HRA.get(paramInt);
    AppMethodBeat.o(34999);
    return localbo;
  }
  
  public final void aaQ(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(35007);
    bo localbo = aaP(paramInt);
    if (localbo == null) {
      bool = true;
    }
    ac.i("MicroMsg.ChattingDataAdapter", "[setShowHistoryMsgTipId] pos:%s msg is null? %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if ((localbo != null) && (localbo.field_msgId != 0L)) {
      this.HRD = localbo.field_msgId;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(35007);
  }
  
  public final void aaR(int paramInt)
  {
    AppMethodBeat.i(35015);
    bo localbo = aaP(paramInt);
    if ((localbo != null) && (localbo.field_msgId != 0L)) {
      this.HRB.add(Long.valueOf(localbo.field_msgId));
    }
    AppMethodBeat.o(35015);
  }
  
  public final bo aaS(int paramInt)
  {
    AppMethodBeat.i(161523);
    paramInt -= 1;
    if ((this.HRA != null) && (paramInt >= 0) && (paramInt < this.HRA.size()))
    {
      bo localbo = (bo)this.HRA.get(paramInt);
      AppMethodBeat.o(161523);
      return localbo;
    }
    AppMethodBeat.o(161523);
    return null;
  }
  
  public final void cqC()
  {
    AppMethodBeat.i(35003);
    this.HRH = false;
    notifyDataSetChanged();
    ac.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
    this.HRn = this.HRo;
    this.HRp = this.HRq;
    this.HRr = this.HRs;
    this.HRt = this.HRu;
    this.HRv = this.HRw;
    AppMethodBeat.o(35003);
  }
  
  public final int dsn()
  {
    AppMethodBeat.i(35001);
    int i = this.HRE.size();
    AppMethodBeat.o(35001);
    return i;
  }
  
  public final void eK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35020);
    if (this.HpO == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    Object localObject1 = this.HpO.AzG;
    if (localObject1 == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIQ();
    bo localbo;
    Object localObject2;
    if (((ai)localObject1).fad())
    {
      localObject1 = new ArrayList();
      while (paramInt1 <= paramInt2)
      {
        localbo = aaS(paramInt1);
        if ((localbo != null) && (localbo.getType() == 285212721))
        {
          ac.v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + localbo.field_msgId);
          ((List)localObject1).add(new String[] { String.valueOf(localbo.field_msgId), localbo.field_content, "-1" });
          localObject2 = new q();
          ((q)localObject2).msgId = localbo.field_msgId;
          ((q)localObject2).hkR = localbo.field_content;
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
      localbo = aaS(paramInt1);
      if ((localbo != null) && ((localbo.getType() & 0x31) != 0))
      {
        localObject2 = localbo.field_content;
        if (localObject2 != null)
        {
          localObject2 = k.b.az((String)localObject2, localbo.field_reserved);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((k.b)localObject2).url)) && (((k.b)localObject2).url.contains("mp.weixin.qq.com")))
          {
            localObject3 = bk.ct(localbo);
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.ui.chatting.viewitems.c)localObject3).b(this.HpO, localbo);
              if (localObject3 != null)
              {
                str = ((av)localObject1).field_username;
                if (str != null)
                {
                  j = x.aE((String)localObject3, this.HpO.getTalkerUserName());
                  localObject4 = (com.tencent.mm.ah.e)((k.b)localObject2).ao(com.tencent.mm.ah.e.class);
                  if (localObject4 == null) {
                    break label630;
                  }
                }
              }
            }
          }
        }
      }
    }
    label630:
    for (int i = ((com.tencent.mm.ah.e)localObject4).hgY;; i = -1)
    {
      localObject4 = new ArrayList();
      ((List)localObject4).add(((k.b)localObject2).url);
      ((List)localObject4).add(String.valueOf(i));
      ((List)localObject4).add(String.valueOf(localbo.field_msgSvrId));
      ((List)localObject4).add(str);
      ((List)localObject4).add(String.valueOf(j));
      ((List)localObject4).add(localObject3);
      ((List)localObject4).add(String.valueOf(localbo.field_createTime));
      ((List)localObject4).add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tj(str)));
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
  
  public final void eLf()
  {
    AppMethodBeat.i(34997);
    com.tencent.mm.ui.chatting.d.a.foS().post(new Runnable()
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
  
  public final int eZx()
  {
    AppMethodBeat.i(34998);
    if (-1 == this.fAr)
    {
      az.ayM();
      this.fAr = com.tencent.mm.model.c.awD().aly(this.HpO.getTalkerUserName());
    }
    int i = this.fAr;
    AppMethodBeat.o(34998);
    return i;
  }
  
  public final Set<Long> flS()
  {
    return this.HRE;
  }
  
  public final void flT()
  {
    AppMethodBeat.i(35002);
    if (this.HRE != null) {
      this.HRE.clear();
    }
    AppMethodBeat.o(35002);
  }
  
  public final void flU()
  {
    AppMethodBeat.i(35004);
    this.HRH = true;
    notifyDataSetChanged();
    flR();
    AppMethodBeat.o(35004);
  }
  
  public final void flV()
  {
    AppMethodBeat.i(35006);
    if (this.HRL)
    {
      this.HRM += 1;
      ac.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.HRM);
      AppMethodBeat.o(35006);
      return;
    }
    if (!this.cJp)
    {
      ac.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
      AppMethodBeat.o(35006);
      return;
    }
    this.HRK.a(d.a.IeS, false, null);
    AppMethodBeat.o(35006);
  }
  
  public final void flW()
  {
    AppMethodBeat.i(35010);
    ac.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.HRL), Integer.valueOf(this.HRM) });
    if (this.HRL)
    {
      AppMethodBeat.o(35010);
      return;
    }
    this.HRL = true;
    this.HRM = 0;
    AppMethodBeat.o(35010);
  }
  
  public final void flX()
  {
    AppMethodBeat.i(35011);
    ac.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.HRL), Integer.valueOf(this.HRM) });
    if (!this.HRL)
    {
      AppMethodBeat.o(35011);
      return;
    }
    this.HRL = false;
    if (this.HRM > 0) {
      this.HRK.a(d.a.IeS, false, null);
    }
    this.HRM = 0;
    AppMethodBeat.o(35011);
  }
  
  public final void flY()
  {
    AppMethodBeat.i(35016);
    this.HRI = true;
    flR();
    AppMethodBeat.o(35016);
  }
  
  public final t.a flZ()
  {
    return this.HRO;
  }
  
  public final s.f fma()
  {
    return this.HRp;
  }
  
  public final s.g fmb()
  {
    return this.HRn;
  }
  
  public final ab fmc()
  {
    return this.HRt;
  }
  
  public final l fmd()
  {
    return this.HRr;
  }
  
  public final com.tencent.mm.ui.chatting.c fme()
  {
    return this.HRv;
  }
  
  public final long fmf()
  {
    AppMethodBeat.i(35017);
    long l;
    if (this.HRP != -1L)
    {
      l = this.HRP;
      AppMethodBeat.o(35017);
      return l;
    }
    this.HRP = 0L;
    int i = getCount() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        bo localbo = aaP(i);
        if ((localbo.field_isSend == 1) && ((localbo.euk & 0x4) != 4)) {
          this.HRP = localbo.field_msgId;
        }
      }
      else
      {
        l = this.HRP;
        AppMethodBeat.o(35017);
        return l;
      }
      i -= 1;
    }
  }
  
  public final com.tencent.mm.av.a.a.c fmg()
  {
    AppMethodBeat.i(35019);
    if (this.fze == null) {
      eNF();
    }
    com.tencent.mm.av.a.a.c localc = this.fze;
    AppMethodBeat.o(35019);
    return localc;
  }
  
  public final void g(View.OnClickListener paramOnClickListener)
  {
    this.HRx = paramOnClickListener;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34990);
    int i = this.HRA.size();
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
    paramInt = bk.cu(aaP(paramInt));
    AppMethodBeat.o(34991);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34993);
    bo localbo = aaP(paramInt);
    ac.i("MicroMsg.ChattingDataAdapter", "[getView] position:" + paramInt + " msgId:" + localbo.field_msgId + " svrId:" + localbo.field_msgSvrId + " type:" + localbo.getType() + " send:" + localbo.field_isSend + " talker:" + localbo.field_talker + " msgSep:" + localbo.field_msgSeq + " time:" + localbo.field_createTime);
    if (paramInt == 0)
    {
      paramViewGroup = this.HpO;
      ac.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
      paramViewGroup.HZG.flG();
    }
    int i;
    int j;
    label227:
    label246:
    boolean bool;
    label295:
    label311:
    int k;
    label358:
    Object localObject;
    if ((paramInt != 0) && (this.HRC.get(paramInt) == 0))
    {
      long l1 = aaP(paramInt - 1).field_createTime;
      long l2 = localbo.field_createTime;
      if (l2 - l1 < 60000L)
      {
        i = 1;
        if ((l2 - l1) / 180000L >= 1L) {
          break label1118;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label1124;
        }
        this.HRC.put(paramInt, 2);
      }
    }
    else
    {
      if (((this.HRC.get(paramInt) != 1) && (paramInt != 0) && (!this.HRB.contains(Long.valueOf(localbo.field_msgId)))) || (localbo.field_createTime <= 1000L)) {
        break label1136;
      }
      i = 1;
      if (localbo.field_msgId != this.HRD) {
        break label1142;
      }
      j = 1;
      paramViewGroup = t.aGP().CW(this.HpO.getTalkerUserName());
      bool = true;
      if (paramViewGroup != null) {
        break label1148;
      }
      az.ayM();
      k = ((Integer)com.tencent.mm.model.c.agA().get(12311, Integer.valueOf(-2))).intValue();
      if (k != -2) {
        bool = false;
      }
      if (paramView != null) {
        break label1157;
      }
      localObject = bk.ct(localbo);
      paramView = ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(this.iMw, paramView);
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.IhY = ((com.tencent.mm.ui.chatting.viewitems.c)localObject);
      paramViewGroup.setChattingBG(bool);
      label410:
      ac.d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", new Object[] { paramViewGroup.IhY });
      if (i == 0) {
        break label1174;
      }
      paramViewGroup.fAz.setVisibility(0);
      paramViewGroup.fAz.setText(com.tencent.mm.pluginsdk.g.h.c(this.HpO.HZF.getContext(), localbo.field_createTime, false));
      if (paramViewGroup.fAz.getTextSize() > com.tencent.mm.cc.a.fromDPToPix(this.HpO.HZF.getContext(), 25)) {
        ac.e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", new Object[] { Float.valueOf(paramViewGroup.fAz.getTextSize()) });
      }
      label522:
      if (paramViewGroup.IhV != null)
      {
        if (j == 0) {
          break label1186;
        }
        paramViewGroup.IhV.setVisibility(0);
      }
      label542:
      localObject = paramViewGroup.IhY;
      paramViewGroup.IhX = null;
      f localf = com.tencent.mm.ay.a.aGy();
      if ((localf != null) && (localf.hNS != null) && (localf.hNQ == 0) && (com.tencent.mm.ay.a.aGv())) {
        paramViewGroup.IhX = localf.hNS;
      }
      ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(paramViewGroup, paramInt, this.HpO, localbo);
      localObject = ((com.tencent.mm.ui.chatting.c.b.c)this.HpO.bf(com.tencent.mm.ui.chatting.c.b.c.class)).fmP();
      if ((paramViewGroup.fAz.getVisibility() == 0) && (localObject != null))
      {
        paramViewGroup.fAz.setTextColor(((com.tencent.mm.pluginsdk.ui.e)localObject).DmY);
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).DmZ) {
          break label1198;
        }
        paramViewGroup.fAz.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.e)localObject).Dna);
        label681:
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).Dnb) {
          break label1225;
        }
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).Dnc) {
          break label1212;
        }
        paramViewGroup.fAz.setBackgroundResource(2131231583);
        label707:
        paramViewGroup.fAz.setPadding(this.HRz, this.HRy, this.HRz, this.HRy);
      }
      label730:
      if ((paramViewGroup.xpH != null) && (paramViewGroup.xpH.getVisibility() == 0) && (localObject != null) && (!this.HpO.getTalkerUserName().equals("qqmail")) && (localbo.getType() != 318767153))
      {
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).Dnc) {
          break label1236;
        }
        paramViewGroup.xpH.setTextColor(-1);
        paramViewGroup.xpH.setShadowLayer(com.tencent.mm.cc.a.fromDPToPix(paramViewGroup.xpH.getContext(), 2), 0.0F, com.tencent.mm.cc.a.fromDPToPix(paramViewGroup.xpH.getContext(), 1), this.HpO.HZF.getMMResources().getColor(2131099662));
      }
      label843:
      if (paramViewGroup.gGk != null) {
        paramViewGroup.gGk.setTag(Long.valueOf(localbo.field_msgId));
      }
      if (this.HRH)
      {
        if (!localbo.isSystem()) {
          break label1262;
        }
        paramInt = 0;
        label882:
        if (paramInt != 0) {}
      }
      else
      {
        if (!this.HRI) {
          break label1267;
        }
      }
      if (paramViewGroup.ijt != null) {
        paramViewGroup.ijt.setChecked(this.HRE.contains(Long.valueOf(localbo.field_msgId)));
      }
      if (paramViewGroup.gGk != null) {
        paramViewGroup.gGk.setOnClickListener(this.HRx);
      }
      paramViewGroup.xu(true);
    }
    for (;;)
    {
      paramViewGroup = this.HRG.entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        localObject = (Map.Entry)paramViewGroup.next();
        if ((((Map.Entry)localObject).getValue() != null) && ((View)((WeakReference)((Map.Entry)localObject).getValue()).get() == paramView))
        {
          this.HRG.remove(((Map.Entry)localObject).getKey());
          this.HRF.remove(((Map.Entry)localObject).getKey());
        }
      }
      this.HRG.put(Long.valueOf(localbo.field_msgId), new WeakReference(paramView));
      if (localbo.eZm()) {
        this.HRF.put(Long.valueOf(localbo.field_msgId), Integer.valueOf(localbo.field_isSend));
      }
      AppMethodBeat.o(34993);
      return paramView;
      i = 0;
      break;
      label1118:
      j = 0;
      break label227;
      label1124:
      this.HRC.put(paramInt, 1);
      break label246;
      label1136:
      i = 0;
      break label295;
      label1142:
      j = 0;
      break label311;
      label1148:
      k = paramViewGroup.hPy;
      break label358;
      label1157:
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.setChattingBG(bool);
      break label410;
      label1174:
      paramViewGroup.fAz.setVisibility(8);
      break label522;
      label1186:
      paramViewGroup.IhV.setVisibility(8);
      break label542;
      label1198:
      paramViewGroup.fAz.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label681;
      label1212:
      paramViewGroup.fAz.setBackgroundResource(2131231582);
      break label707;
      label1225:
      paramViewGroup.fAz.setBackgroundColor(0);
      break label730;
      label1236:
      paramViewGroup.xpH.setTextColor(((com.tencent.mm.pluginsdk.ui.e)localObject).DmY);
      paramViewGroup.xpH.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label843;
      label1262:
      paramInt = 1;
      break label882;
      label1267:
      paramViewGroup.xu(false);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(34992);
    int i = bk.fqK();
    AppMethodBeat.o(34992);
    return i;
  }
  
  public final boolean isInEditMode()
  {
    return this.HRH;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35005);
    super.notifyDataSetChanged();
    this.HRC.clear();
    AppMethodBeat.o(35005);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(34996);
    this.cJp = false;
    az.ayM();
    com.tencent.mm.model.c.awD().a(this.HRN);
    k.b(this.nAR);
    ac.i("MicroMsg.ChattingDataAdapter", "adapter pause");
    this.HRJ.stopTimer();
    AppMethodBeat.o(34996);
  }
  
  public final void q(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35012);
    if ((!this.HRG.containsKey(Long.valueOf(paramLong))) || (!this.HRF.containsKey(Long.valueOf(paramLong))))
    {
      ac.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35012);
      return;
    }
    Object localObject = (WeakReference)this.HRG.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ao.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramInt1, paramInt2);
      }
      AppMethodBeat.o(35012);
      return;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(34995);
    this.cJp = true;
    ac.i("MicroMsg.ChattingDataAdapter", "adapter resume");
    az.ayM();
    com.tencent.mm.model.c.awD().a(this.HRN, Looper.getMainLooper());
    k.a(this.nAR);
    this.HRJ.au(300000L, 300000L);
    if (this.HRK != null) {
      this.HRK.a(d.a.IeS, false, null);
    }
    AppMethodBeat.o(34995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a
 * JD-Core Version:    0.7.0.1
 */