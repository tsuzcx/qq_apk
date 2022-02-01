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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.q;
import com.tencent.mm.bb.v;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.t.f;
import com.tencent.mm.ui.chatting.t.g;
import com.tencent.mm.ui.chatting.viewitems.av.a;
import com.tencent.mm.ui.chatting.viewitems.av.b;
import com.tencent.mm.ui.chatting.viewitems.be.d;
import com.tencent.mm.ui.chatting.viewitems.br;
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
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  extends BaseAdapter
  implements k
{
  protected i.a AHZ;
  private boolean CXr;
  public com.tencent.mm.ui.chatting.e.a OIz;
  private com.tencent.mm.ui.chatting.c PlA;
  private View.OnClickListener PlB;
  private final int PlC;
  private final int PlD;
  public SparseArray<ca> PlE;
  private HashSet<Long> PlF;
  public SparseIntArray PlG;
  public long PlH;
  public long PlI;
  private CopyOnWriteArraySet<Long> PlJ;
  private Map<Long, Integer> PlK;
  private Map<Long, WeakReference<View>> PlL;
  private boolean PlM;
  private boolean PlN;
  private boolean PlO;
  private final MTimerHandler PlP;
  public com.tencent.mm.ui.chatting.n.a.a PlQ;
  private boolean PlR;
  private int PlS;
  private t.a PlT;
  private long PlU;
  public t.g Plr;
  private t.g Pls;
  public t.f Plt;
  private t.f Plu;
  public com.tencent.mm.pluginsdk.ui.chat.l Plv;
  private com.tencent.mm.pluginsdk.ui.chat.l Plw;
  public com.tencent.mm.ui.ac Plx;
  private com.tencent.mm.ui.ac Ply;
  public com.tencent.mm.ui.chatting.c Plz;
  private int cSs;
  private boolean dlW;
  public com.tencent.mm.av.a.a.c gzE;
  private LayoutInflater kgB;
  private ListView mListView;
  private com.tencent.mm.pluginsdk.ui.span.i ptq;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, ListView paramListView)
  {
    AppMethodBeat.i(34989);
    this.PlB = null;
    this.PlE = new SparseArray();
    this.PlF = new HashSet();
    this.PlG = new SparseIntArray();
    this.PlH = -1L;
    this.PlI = -1L;
    this.PlJ = new CopyOnWriteArraySet();
    this.PlK = new HashMap();
    this.PlL = new HashMap();
    this.PlM = false;
    this.PlN = false;
    this.CXr = false;
    this.PlO = false;
    this.PlP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34984);
        if ((a.a(a.this) != null) && (a.a(a.this).cQp))
        {
          Log.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
          a.this.gOw();
        }
        AppMethodBeat.o(34984);
        return true;
      }
    }, true);
    this.cSs = -1;
    this.PlR = false;
    this.PlS = 0;
    this.AHZ = new i.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(34986);
        if ((paramAnonymousi == null) || (paramAnonymousc == null))
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
          a.this.gOw();
        }
        AppMethodBeat.o(34986);
      }
    };
    this.PlT = new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(34988);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousa != null)
        {
          bool1 = bool2;
          if (paramAnonymousa.jsu != 3) {
            if ((paramAnonymousa.jsu != 2) && (paramAnonymousa.jsu != -1))
            {
              bool1 = bool2;
              if (paramAnonymousa.jsu != 1) {}
            }
            else
            {
              bool1 = be.d.b(paramAnonymousa);
            }
          }
        }
        if (!bool1) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34987);
              a.this.gOw();
              AppMethodBeat.o(34987);
            }
          });
        }
        AppMethodBeat.o(34988);
      }
    };
    this.PlU = -1L;
    this.gzE = null;
    parama.a(k.class, this);
    this.mListView = paramListView;
    this.OIz = parama;
    this.kgB = aa.jQ(parama.Pwc.getContext());
    this.PlC = parama.Pwc.getMMResources().getDimensionPixelSize(2131165593);
    this.PlD = parama.Pwc.getMMResources().getDimensionPixelSize(2131165508);
    paramListView = new t.g();
    this.Pls = paramListView;
    this.Plr = paramListView;
    paramListView = new t.f(parama);
    this.Plu = paramListView;
    this.Plt = paramListView;
    paramListView = new com.tencent.mm.pluginsdk.ui.chat.l(parama.Pwc.getContext());
    this.Plw = paramListView;
    this.Plv = paramListView;
    paramListView = new com.tencent.mm.ui.ac(parama);
    this.Ply = paramListView;
    this.Plx = paramListView;
    paramListView = new com.tencent.mm.ui.chatting.c(parama);
    this.PlA = paramListView;
    this.Plz = paramListView;
    this.ptq = new ag(parama);
    gpB();
    AppMethodBeat.o(34989);
  }
  
  private static boolean bS(ca paramca)
  {
    AppMethodBeat.i(232954);
    if ((paramca.gDm()) || (paramca.gDp()) || (paramca.gDw()))
    {
      AppMethodBeat.o(232954);
      return false;
    }
    AppMethodBeat.o(232954);
    return true;
  }
  
  private void gOr()
  {
    AppMethodBeat.i(34994);
    Log.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
    this.Plr = null;
    this.Plt = null;
    this.Plv = null;
    this.Plx = null;
    this.Plz = null;
    AppMethodBeat.o(34994);
  }
  
  private void gpB()
  {
    AppMethodBeat.i(35018);
    if (this.gzE == null)
    {
      com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
      locala.prefixPath = com.tencent.mm.al.a.e.NN(this.OIz.getTalkerUserName());
      locala.jbf = true;
      locala.hZF = true;
      locala.jbq = 2131690042;
      try
      {
        this.gzE = locala.bdv();
        AppMethodBeat.o(35018);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.printErrStackTrace("MicroMsg.ChattingDataAdapter", localNullPointerException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(35018);
  }
  
  public final boolean Nu(long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(35000);
    int i;
    label65:
    Object localObject;
    label128:
    label181:
    int k;
    if (this.PlJ.contains(Long.valueOf(paramLong)))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      this.PlJ.remove(Long.valueOf(paramLong));
      if (this.mListView == null) {
        break label390;
      }
      i = j;
      if (i >= this.mListView.getChildCount()) {
        break label390;
      }
      localObject = this.mListView.getChildAt(i);
      com.tencent.mm.ui.chatting.viewitems.c.a locala = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((locala != null) && (locala.maskView != null) && (((Long)locala.maskView.getTag()).longValue() == paramLong))
      {
        if (localObject == null) {
          break label396;
        }
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        if ((((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).checkBox != null) && (((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).checkBox.getVisibility() == 0)) {
          ((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).checkBox.setChecked(this.PlJ.contains(Long.valueOf(paramLong)));
        }
        AppMethodBeat.o(35000);
        return true;
      }
    }
    else
    {
      Log.d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      k = this.PlJ.size();
      if (!this.PlN) {
        break label403;
      }
      i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slJ, 99);
      Log.d("MicroMsg.recordSelect.SelectRecordConfig", "getSelectRecordMaxNum() num:%s", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if (k >= i)
      {
        if (this.PlN) {}
        for (localObject = this.OIz.Pwc.getMMResources().getString(2131758761, new Object[] { Integer.valueOf(i) });; localObject = this.OIz.Pwc.getMMResources().getString(2131758760, new Object[] { Integer.valueOf(99) }))
        {
          h.c(this.OIz.Pwc.getContext(), (String)localObject, "", true);
          AppMethodBeat.o(35000);
          return false;
        }
      }
      this.PlJ.add(Long.valueOf(paramLong));
      break;
      i += 1;
      break label65;
      label390:
      localObject = null;
      break label128;
      label396:
      notifyDataSetChanged();
      break label181;
      label403:
      i = 99;
    }
  }
  
  public final void Q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35013);
    if ((!this.PlL.containsKey(Long.valueOf(paramLong))) || (!this.PlK.containsKey(Long.valueOf(paramLong))))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35013);
      return;
    }
    Object localObject = (WeakReference)this.PlL.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        av.b.c((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramBoolean);
      }
      AppMethodBeat.o(35013);
      return;
    }
  }
  
  public final void a(int paramInt, d.a parama)
  {
    AppMethodBeat.i(35009);
    Log.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", new Object[] { Integer.valueOf(paramInt), parama });
    Bundle localBundle = new Bundle();
    localBundle.putInt("MSG_POSITION", paramInt);
    localBundle.putInt("SCENE", 2);
    this.PlQ.a(parama, false, localBundle);
    AppMethodBeat.o(35009);
  }
  
  public final void a(long paramLong, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(35014);
    if ((!this.PlL.containsKey(Long.valueOf(paramLong))) || (!this.PlK.containsKey(Long.valueOf(paramLong))))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35014);
      return;
    }
    Object localObject = (WeakReference)this.PlL.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        av.a.a(this.OIz.Pwc.getContext(), (com.tencent.mm.ui.chatting.viewitems.c.a)localObject, paramca, paramBoolean);
      }
      AppMethodBeat.o(35014);
      return;
    }
  }
  
  public final void a(long paramLong, boolean paramBoolean, d.a parama)
  {
    AppMethodBeat.i(35008);
    Log.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), parama });
    Bundle localBundle = new Bundle();
    localBundle.putLong("MSG_ID", paramLong);
    localBundle.putInt("SCENE", 1);
    localBundle.putBoolean("IS_LOAD_ALL", paramBoolean);
    this.PlQ.a(parama, true, localBundle);
    AppMethodBeat.o(35008);
  }
  
  public final ca amt(int paramInt)
  {
    AppMethodBeat.i(34999);
    ca localca = (ca)this.PlE.get(paramInt);
    AppMethodBeat.o(34999);
    return localca;
  }
  
  public final void amu(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(35007);
    ca localca = amt(paramInt);
    if (localca == null) {
      bool = true;
    }
    Log.i("MicroMsg.ChattingDataAdapter", "[setShowHistoryMsgTipId] pos:%s msg is null? %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if ((localca != null) && (localca.field_msgId != 0L)) {
      this.PlH = localca.field_msgId;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(35007);
  }
  
  public final void amv(int paramInt)
  {
    AppMethodBeat.i(35015);
    ca localca = amt(paramInt);
    if ((localca != null) && (localca.field_msgId != 0L)) {
      this.PlF.add(Long.valueOf(localca.field_msgId));
    }
    AppMethodBeat.o(35015);
  }
  
  public final ca amw(int paramInt)
  {
    AppMethodBeat.i(161523);
    paramInt -= 1;
    if ((this.PlE != null) && (paramInt >= 0) && (paramInt < this.PlE.size()))
    {
      ca localca = (ca)this.PlE.get(paramInt);
      AppMethodBeat.o(161523);
      return localca;
    }
    AppMethodBeat.o(161523);
    return null;
  }
  
  public final boolean bT(ca paramca)
  {
    AppMethodBeat.i(232955);
    if ((paramca != null) && (bS(paramca)))
    {
      AppMethodBeat.o(232955);
      return true;
    }
    AppMethodBeat.o(232955);
    return false;
  }
  
  public final void cVM()
  {
    AppMethodBeat.i(35003);
    this.PlM = false;
    notifyDataSetChanged();
    Log.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
    this.Plr = this.Pls;
    this.Plt = this.Plu;
    this.Plv = this.Plw;
    this.Plx = this.Ply;
    this.Plz = this.PlA;
    AppMethodBeat.o(35003);
  }
  
  public final int cZm()
  {
    AppMethodBeat.i(34998);
    if (-1 == this.cSs)
    {
      bg.aVF();
      this.cSs = com.tencent.mm.model.c.aSQ().aEM(this.OIz.getTalkerUserName());
    }
    int i = this.cSs;
    AppMethodBeat.o(34998);
    return i;
  }
  
  public final int eGR()
  {
    AppMethodBeat.i(35001);
    int i = this.PlJ.size();
    AppMethodBeat.o(35001);
    return i;
  }
  
  public final void fc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35020);
    if (this.OIz == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    Object localObject1 = this.OIz.GUe;
    if (localObject1 == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cle();
    ca localca;
    Object localObject2;
    if (((as)localObject1).gBM())
    {
      localObject1 = new ArrayList();
      while (paramInt1 <= paramInt2)
      {
        localca = amw(paramInt1);
        if ((localca != null) && (localca.getType() == 285212721))
        {
          Log.v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + localca.field_msgId);
          ((List)localObject1).add(new String[] { String.valueOf(localca.field_msgId), localca.field_content, "-1" });
          localObject2 = new q();
          ((q)localObject2).msgId = localca.field_msgId;
          ((q)localObject2).iAc = localca.field_content;
          if (bool) {
            localLinkedList.add(localObject2);
          }
        }
        paramInt1 += 1;
      }
      if (((List)localObject1).size() > 0)
      {
        ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).k((List)localObject1, 0);
        if (bool) {
          ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).l(localLinkedList, 0);
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
      localca = amw(paramInt1);
      if ((localca != null) && ((localca.getType() & 0x31) != 0))
      {
        localObject2 = localca.field_content;
        if (localObject2 != null)
        {
          localObject2 = k.b.aD((String)localObject2, localca.field_reserved);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((k.b)localObject2).url)) && (((k.b)localObject2).url.contains(WeChatHosts.domainString(2131761726))))
          {
            localObject3 = br.cR(localca);
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.ui.chatting.viewitems.c)localObject3).a(this.OIz, localca);
              if (localObject3 != null)
              {
                str = ((ax)localObject1).field_username;
                if (str != null)
                {
                  j = com.tencent.mm.model.ac.aJ((String)localObject3, this.OIz.getTalkerUserName());
                  localObject4 = (com.tencent.mm.ag.e)((k.b)localObject2).as(com.tencent.mm.ag.e.class);
                  if (localObject4 == null) {
                    break label633;
                  }
                }
              }
            }
          }
        }
      }
    }
    label633:
    for (int i = ((com.tencent.mm.ag.e)localObject4).iwc;; i = -1)
    {
      localObject4 = new ArrayList();
      ((List)localObject4).add(((k.b)localObject2).url);
      ((List)localObject4).add(String.valueOf(i));
      ((List)localObject4).add(String.valueOf(localca.field_msgSvrId));
      ((List)localObject4).add(str);
      ((List)localObject4).add(String.valueOf(j));
      ((List)localObject4).add(localObject3);
      ((List)localObject4).add(String.valueOf(localca.field_createTime));
      ((List)localObject4).add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahy(str)));
      localLinkedList.add(localObject4);
      paramInt1 += 1;
      break;
      if (localLinkedList.size() > 0) {
        ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).j(localLinkedList, 1);
      }
      AppMethodBeat.o(35020);
      return;
    }
  }
  
  public final t.a gOA()
  {
    return this.PlT;
  }
  
  public final t.f gOB()
  {
    return this.Plt;
  }
  
  public final t.g gOC()
  {
    return this.Plr;
  }
  
  public final com.tencent.mm.ui.ac gOD()
  {
    return this.Plx;
  }
  
  public final com.tencent.mm.pluginsdk.ui.chat.l gOE()
  {
    return this.Plv;
  }
  
  public final com.tencent.mm.ui.chatting.c gOF()
  {
    return this.Plz;
  }
  
  public final long gOG()
  {
    AppMethodBeat.i(35017);
    long l;
    if (this.PlU != -1L)
    {
      l = this.PlU;
      AppMethodBeat.o(35017);
      return l;
    }
    this.PlU = 0L;
    int i = getCount() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        ca localca = amt(i);
        if ((localca.field_isSend == 1) && ((localca.fqJ & 0x4) != 4)) {
          this.PlU = localca.field_msgId;
        }
      }
      else
      {
        l = this.PlU;
        AppMethodBeat.o(35017);
        return l;
      }
      i -= 1;
    }
  }
  
  public final com.tencent.mm.av.a.a.c gOH()
  {
    AppMethodBeat.i(35019);
    if (this.gzE == null) {
      gpB();
    }
    com.tencent.mm.av.a.a.c localc = this.gzE;
    AppMethodBeat.o(35019);
    return localc;
  }
  
  public final SparseArray<ca> gOq()
  {
    return this.PlE;
  }
  
  public final Set<Long> gOs()
  {
    return this.PlJ;
  }
  
  public final void gOt()
  {
    AppMethodBeat.i(35002);
    if (this.PlJ != null) {
      this.PlJ.clear();
    }
    AppMethodBeat.o(35002);
  }
  
  public final void gOu()
  {
    AppMethodBeat.i(35004);
    this.PlM = true;
    notifyDataSetChanged();
    gOr();
    AppMethodBeat.o(35004);
  }
  
  public final void gOv()
  {
    this.PlN = true;
  }
  
  public final void gOw()
  {
    AppMethodBeat.i(35006);
    if (this.PlR)
    {
      this.PlS += 1;
      Log.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.PlS);
      AppMethodBeat.o(35006);
      return;
    }
    if (!this.dlW)
    {
      Log.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
      AppMethodBeat.o(35006);
      return;
    }
    this.PlQ.a(d.a.PDF, false, null);
    AppMethodBeat.o(35006);
  }
  
  public final void gOx()
  {
    AppMethodBeat.i(35010);
    Log.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.PlR), Integer.valueOf(this.PlS) });
    if (this.PlR)
    {
      AppMethodBeat.o(35010);
      return;
    }
    this.PlR = true;
    this.PlS = 0;
    AppMethodBeat.o(35010);
  }
  
  public final void gOy()
  {
    AppMethodBeat.i(35011);
    Log.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.PlR), Integer.valueOf(this.PlS) });
    if (!this.PlR)
    {
      AppMethodBeat.o(35011);
      return;
    }
    this.PlR = false;
    if (this.PlS > 0) {
      this.PlQ.a(d.a.PDF, false, null);
    }
    this.PlS = 0;
    AppMethodBeat.o(35011);
  }
  
  public final void gOz()
  {
    AppMethodBeat.i(35016);
    this.PlO = true;
    gOr();
    AppMethodBeat.o(35016);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34990);
    int i = this.PlE.size();
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
    paramInt = br.cS(amt(paramInt));
    AppMethodBeat.o(34991);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34993);
    ca localca = amt(paramInt);
    Log.i("MicroMsg.ChattingDataAdapter", "[getView] position:" + paramInt + " msgId:" + localca.field_msgId + " svrId:" + localca.field_msgSvrId + " type:" + localca.getType() + " send:" + localca.field_isSend + " talker:" + localca.field_talker + " msgSep:" + localca.field_msgSeq + " time:" + localca.field_createTime);
    if (paramInt == 0)
    {
      paramViewGroup = this.OIz;
      Log.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
      paramViewGroup.Pwd.gOe();
    }
    int i;
    int j;
    label227:
    label246:
    Object localObject;
    if ((paramInt != 0) && (this.PlG.get(paramInt) == 0))
    {
      long l1 = amt(paramInt - 1).field_createTime;
      long l2 = localca.field_createTime;
      if (l2 - l1 < 60000L)
      {
        i = 1;
        if ((l2 - l1) / 180000L >= 1L) {
          break label1217;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label1223;
        }
        this.PlG.put(paramInt, 2);
      }
    }
    else
    {
      if (((this.PlG.get(paramInt) != 1) && (paramInt != 0) && (!this.PlF.contains(Long.valueOf(localca.field_msgId)))) || (localca.field_createTime <= 1000L)) {
        break label1235;
      }
      i = 1;
      label295:
      if (localca.field_msgId != this.PlH) {
        break label1241;
      }
      j = 1;
      label311:
      if (v.bew().Pp(this.OIz.getTalkerUserName()) == null)
      {
        bg.aVF();
        ((Integer)com.tencent.mm.model.c.azQ().get(12311, Integer.valueOf(-2))).intValue();
      }
      if (paramView != null) {
        break label1247;
      }
      localObject = br.cR(localca);
      paramView = ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(this.kgB, paramView);
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.setChattingItem((com.tencent.mm.ui.chatting.viewitems.c)localObject);
      label388:
      Log.d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", new Object[] { paramViewGroup.chattingItem });
      if (i == 0) {
        break label1258;
      }
      paramViewGroup.timeTV.setVisibility(0);
      paramViewGroup.timeTV.setText(com.tencent.mm.pluginsdk.i.f.c(this.OIz.Pwc.getContext(), localca.field_createTime, false));
      if (paramViewGroup.timeTV.getTextSize() > com.tencent.mm.cb.a.fromDPToPix(this.OIz.Pwc.getContext(), 25)) {
        Log.e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", new Object[] { Float.valueOf(paramViewGroup.timeTV.getTextSize()) });
      }
      label500:
      if (paramViewGroup.historyMsgTip != null)
      {
        if (j == 0) {
          break label1270;
        }
        paramViewGroup.historyMsgTip.setVisibility(0);
      }
      label520:
      if (this.PlI == -1L)
      {
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEy(this.OIz.getTalkerUserName());
        if (localObject == null) {
          break label1282;
        }
        this.PlI = ((eo)localObject).field_msgId;
      }
      label573:
      if (paramViewGroup.noMoreMsgTip != null)
      {
        if ((!this.PlN) || (localca.field_msgId != this.PlI)) {
          break label1290;
        }
        paramViewGroup.noMoreMsgTip.setVisibility(0);
      }
      label608:
      localObject = paramViewGroup.chattingItem;
      paramViewGroup.playingMsgId = null;
      com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.bef();
      if ((localf != null) && (localf.jeV != null) && (localf.jeT == 0) && (com.tencent.mm.ay.a.bec())) {
        paramViewGroup.playingMsgId = localf.jeV;
      }
      ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(paramViewGroup, paramInt, this.OIz, localca);
      localObject = ((com.tencent.mm.ui.chatting.d.b.c)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.c.class)).gPr();
      if ((paramViewGroup.timeTV.getVisibility() == 0) && (localObject != null))
      {
        paramViewGroup.timeTV.setTextColor(((com.tencent.mm.pluginsdk.ui.f)localObject).Kbq);
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).Kbr) {
          break label1302;
        }
        paramViewGroup.timeTV.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.f)localObject).Kbs);
        label747:
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).Kbt) {
          break label1329;
        }
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).Kbu) {
          break label1316;
        }
        paramViewGroup.timeTV.setBackgroundResource(2131231647);
        label773:
        paramViewGroup.timeTV.setPadding(this.PlD, this.PlC, this.PlD, this.PlC);
      }
      label796:
      if ((paramViewGroup.userTV != null) && (paramViewGroup.userTV.getVisibility() == 0) && (localObject != null) && (!this.OIz.getTalkerUserName().equals("qqmail")) && (localca.getType() != 318767153))
      {
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).Kbu) {
          break label1340;
        }
        paramViewGroup.userTV.setTextColor(-1);
        paramViewGroup.userTV.setShadowLayer(com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.userTV.getContext(), 2), 0.0F, com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.userTV.getContext(), 1), this.OIz.Pwc.getMMResources().getColor(2131099665));
      }
      label909:
      if (paramViewGroup.maskView != null) {
        paramViewGroup.maskView.setTag(Long.valueOf(localca.field_msgId));
      }
      if (((!this.PlM) || (!bS(localca))) && (!this.PlO)) {
        break label1366;
      }
      if (paramViewGroup.checkBox != null) {
        paramViewGroup.checkBox.setChecked(this.PlJ.contains(Long.valueOf(localca.field_msgId)));
      }
      if (paramViewGroup.maskView != null) {
        paramViewGroup.maskView.setOnClickListener(this.PlB);
      }
      paramViewGroup.showEditView(true);
      label1005:
      if ((!this.PlM) || (!this.CXr) || (this.PlJ.contains(Long.valueOf(localca.field_msgId)))) {
        break label1374;
      }
      paramView.setAlpha(0.5F);
    }
    for (;;)
    {
      paramViewGroup = this.PlL.entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        localObject = (Map.Entry)paramViewGroup.next();
        if ((((Map.Entry)localObject).getValue() != null) && ((View)((WeakReference)((Map.Entry)localObject).getValue()).get() == paramView))
        {
          this.PlL.remove(((Map.Entry)localObject).getKey());
          this.PlK.remove(((Map.Entry)localObject).getKey());
        }
      }
      this.PlL.put(Long.valueOf(localca.field_msgId), new WeakReference(paramView));
      if (localca.gAz()) {
        this.PlK.put(Long.valueOf(localca.field_msgId), Integer.valueOf(localca.field_isSend));
      }
      AppMethodBeat.o(34993);
      return paramView;
      i = 0;
      break;
      label1217:
      j = 0;
      break label227;
      label1223:
      this.PlG.put(paramInt, 1);
      break label246;
      label1235:
      i = 0;
      break label295;
      label1241:
      j = 0;
      break label311;
      label1247:
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      break label388;
      label1258:
      paramViewGroup.timeTV.setVisibility(8);
      break label500;
      label1270:
      paramViewGroup.historyMsgTip.setVisibility(8);
      break label520;
      label1282:
      this.PlI = 0L;
      break label573;
      label1290:
      paramViewGroup.noMoreMsgTip.setVisibility(8);
      break label608;
      label1302:
      paramViewGroup.timeTV.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label747;
      label1316:
      paramViewGroup.timeTV.setBackgroundResource(2131231646);
      break label773;
      label1329:
      paramViewGroup.timeTV.setBackgroundColor(0);
      break label796;
      label1340:
      paramViewGroup.userTV.setTextColor(((com.tencent.mm.pluginsdk.ui.f)localObject).Kbq);
      paramViewGroup.userTV.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label909;
      label1366:
      paramViewGroup.showEditView(false);
      break label1005;
      label1374:
      paramView.setAlpha(1.0F);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(34992);
    int i = br.gUk();
    AppMethodBeat.o(34992);
    return i;
  }
  
  public final void gmY()
  {
    AppMethodBeat.i(34997);
    com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable()
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
  
  public final void i(View.OnClickListener paramOnClickListener)
  {
    this.PlB = paramOnClickListener;
  }
  
  public final boolean isInEditMode()
  {
    return this.PlM;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35005);
    super.notifyDataSetChanged();
    this.PlG.clear();
    AppMethodBeat.o(35005);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(34996);
    this.dlW = false;
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(this.AHZ);
    com.tencent.mm.pluginsdk.ui.span.l.b(this.ptq);
    Log.i("MicroMsg.ChattingDataAdapter", "adapter pause");
    this.PlP.stopTimer();
    AppMethodBeat.o(34996);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(34995);
    this.dlW = true;
    Log.i("MicroMsg.ChattingDataAdapter", "adapter resume");
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(this.AHZ, Looper.getMainLooper());
    com.tencent.mm.pluginsdk.ui.span.l.a(this.ptq);
    this.PlP.startTimer(300000L);
    if (this.PlQ != null) {
      this.PlQ.a(d.a.PDF, false, null);
    }
    AppMethodBeat.o(34995);
  }
  
  public final void s(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35012);
    if ((!this.PlL.containsKey(Long.valueOf(paramLong))) || (!this.PlK.containsKey(Long.valueOf(paramLong))))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35012);
      return;
    }
    Object localObject = (WeakReference)this.PlL.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        av.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramInt1, paramInt2);
      }
      AppMethodBeat.o(35012);
      return;
    }
  }
  
  public final void uo(boolean paramBoolean)
  {
    AppMethodBeat.i(232956);
    if (this.CXr != paramBoolean)
    {
      this.CXr = paramBoolean;
      notifyDataSetChanged();
    }
    AppMethodBeat.o(232956);
  }
  
  public final View zh(long paramLong)
  {
    AppMethodBeat.i(232957);
    if (!this.PlL.containsKey(Long.valueOf(paramLong)))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(232957);
      return null;
    }
    Object localObject = (WeakReference)this.PlL.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(232957);
      return localObject;
    }
    AppMethodBeat.o(232957);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a
 * JD-Core Version:    0.7.0.1
 */