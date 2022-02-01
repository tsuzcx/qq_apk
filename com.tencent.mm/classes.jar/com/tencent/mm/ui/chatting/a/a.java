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
import com.tencent.mm.bc.t;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.s.f;
import com.tencent.mm.ui.chatting.s.g;
import com.tencent.mm.ui.chatting.viewitems.ap.a;
import com.tencent.mm.ui.chatting.viewitems.ap.b;
import com.tencent.mm.ui.chatting.viewitems.ay.d;
import com.tencent.mm.ui.chatting.viewitems.bl;
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
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  extends BaseAdapter
  implements com.tencent.mm.ui.chatting.d.b.k
{
  private boolean JFA;
  private final av JFB;
  public com.tencent.mm.ui.chatting.n.a.a JFC;
  private boolean JFD;
  private int JFE;
  protected i.a JFF;
  private t.a JFG;
  private long JFH;
  public s.g JFd;
  private s.g JFe;
  public s.f JFf;
  private s.f JFg;
  public com.tencent.mm.pluginsdk.ui.chat.l JFh;
  private com.tencent.mm.pluginsdk.ui.chat.l JFi;
  public ab JFj;
  private ab JFk;
  public com.tencent.mm.ui.chatting.c JFl;
  private com.tencent.mm.ui.chatting.c JFm;
  private View.OnClickListener JFn;
  private final int JFo;
  private final int JFp;
  public SparseArray<bu> JFq;
  private HashSet<Long> JFr;
  public SparseIntArray JFs;
  public long JFt;
  public long JFu;
  private CopyOnWriteArraySet<Long> JFv;
  private Map<Long, Integer> JFw;
  private Map<Long, WeakReference<View>> JFx;
  private boolean JFy;
  private boolean JFz;
  public com.tencent.mm.ui.chatting.e.a Jdu;
  private boolean cUC;
  public com.tencent.mm.aw.a.a.c fSr;
  private int fTH;
  private LayoutInflater jfG;
  private ListView mListView;
  private com.tencent.mm.pluginsdk.ui.span.h oca;
  private boolean yCy;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, ListView paramListView)
  {
    AppMethodBeat.i(34989);
    this.JFn = null;
    this.JFq = new SparseArray();
    this.JFr = new HashSet();
    this.JFs = new SparseIntArray();
    this.JFt = -1L;
    this.JFu = -1L;
    this.JFv = new CopyOnWriteArraySet();
    this.JFw = new HashMap();
    this.JFx = new HashMap();
    this.JFy = false;
    this.JFz = false;
    this.yCy = false;
    this.JFA = false;
    this.JFB = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34984);
        if ((a.a(a.this) != null) && (a.a(a.this).cBJ))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
          a.this.fCo();
        }
        AppMethodBeat.o(34984);
        return true;
      }
    }, true);
    this.fTH = -1;
    this.JFD = false;
    this.JFE = 0;
    this.JFF = new i.a()
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
          a.this.fCo();
        }
        AppMethodBeat.o(34986);
      }
    };
    this.JFG = new t.a()
    {
      public final void a(t.a.a paramAnonymousa)
      {
        AppMethodBeat.i(34988);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousa != null)
        {
          bool1 = bool2;
          if (paramAnonymousa.iul != 3) {
            if ((paramAnonymousa.iul != 2) && (paramAnonymousa.iul != -1))
            {
              bool1 = bool2;
              if (paramAnonymousa.iul != 1) {}
            }
            else
            {
              bool1 = ay.d.b(paramAnonymousa);
            }
          }
        }
        if (!bool1) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34987);
              a.this.fCo();
              AppMethodBeat.o(34987);
            }
          });
        }
        AppMethodBeat.o(34988);
      }
    };
    this.JFH = -1L;
    this.fSr = null;
    parama.a(com.tencent.mm.ui.chatting.d.b.k.class, this);
    this.mListView = paramListView;
    this.Jdu = parama;
    this.jfG = z.jO(parama.JOR.getContext());
    this.JFo = parama.JOR.getMMResources().getDimensionPixelSize(2131165575);
    this.JFp = parama.JOR.getMMResources().getDimensionPixelSize(2131165490);
    paramListView = new s.g();
    this.JFe = paramListView;
    this.JFd = paramListView;
    paramListView = new s.f(parama);
    this.JFg = paramListView;
    this.JFf = paramListView;
    paramListView = new com.tencent.mm.pluginsdk.ui.chat.l(parama.JOR.getContext());
    this.JFi = paramListView;
    this.JFh = paramListView;
    paramListView = new ab(parama);
    this.JFk = paramListView;
    this.JFj = paramListView;
    paramListView = new com.tencent.mm.ui.chatting.c(parama);
    this.JFm = paramListView;
    this.JFl = paramListView;
    this.oca = new af(parama);
    fcE();
    AppMethodBeat.o(34989);
  }
  
  private static boolean bD(bu parambu)
  {
    AppMethodBeat.i(193888);
    if ((parambu.frF()) || (parambu.frI()) || (parambu.frP()))
    {
      AppMethodBeat.o(193888);
      return false;
    }
    AppMethodBeat.o(193888);
    return true;
  }
  
  private void fCj()
  {
    AppMethodBeat.i(34994);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
    this.JFd = null;
    this.JFf = null;
    this.JFh = null;
    this.JFj = null;
    this.JFl = null;
    AppMethodBeat.o(34994);
  }
  
  private void fcE()
  {
    AppMethodBeat.i(35018);
    if (this.fSr == null)
    {
      com.tencent.mm.aw.a.a.c.a locala = new com.tencent.mm.aw.a.a.c.a();
      locala.prefixPath = com.tencent.mm.am.a.e.Ex(this.Jdu.getTalkerUserName());
      locala.idr = true;
      locala.hdX = true;
      locala.idD = 2131690013;
      try
      {
        this.fSr = locala.aJc();
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
  
  public final boolean DR(long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(35000);
    int i;
    label65:
    Object localObject;
    label128:
    label181:
    int k;
    if (this.JFv.contains(Long.valueOf(paramLong)))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      this.JFv.remove(Long.valueOf(paramLong));
      if (this.mListView == null) {
        break label390;
      }
      i = j;
      if (i >= this.mListView.getChildCount()) {
        break label390;
      }
      localObject = this.mListView.getChildAt(i);
      com.tencent.mm.ui.chatting.viewitems.c.a locala = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((locala != null) && (locala.gZU != null) && (((Long)locala.gZU.getTag()).longValue() == paramLong))
      {
        if (localObject == null) {
          break label396;
        }
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        if ((((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).iCK != null) && (((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).iCK.getVisibility() == 0)) {
          ((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).iCK.setChecked(this.JFv.contains(Long.valueOf(paramLong)));
        }
        AppMethodBeat.o(35000);
        return true;
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      k = this.JFv.size();
      if (!this.JFz) {
        break label403;
      }
      i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGX, 99);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.recordSelect.SelectRecordConfig", "getSelectRecordMaxNum() num:%s", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if (k >= i)
      {
        if (this.JFz) {}
        for (localObject = this.Jdu.JOR.getMMResources().getString(2131766945, new Object[] { Integer.valueOf(i) });; localObject = this.Jdu.JOR.getMMResources().getString(2131758462, new Object[] { Integer.valueOf(99) }))
        {
          com.tencent.mm.ui.base.h.c(this.Jdu.JOR.getContext(), (String)localObject, "", true);
          AppMethodBeat.o(35000);
          return false;
        }
      }
      this.JFv.add(Long.valueOf(paramLong));
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
  
  public final View DS(long paramLong)
  {
    AppMethodBeat.i(193891);
    if (!this.JFx.containsKey(Long.valueOf(paramLong)))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(193891);
      return null;
    }
    Object localObject = (WeakReference)this.JFx.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(193891);
      return localObject;
    }
    AppMethodBeat.o(193891);
    return null;
  }
  
  public final void J(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35013);
    if ((!this.JFx.containsKey(Long.valueOf(paramLong))) || (!this.JFw.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35013);
      return;
    }
    Object localObject = (WeakReference)this.JFx.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ap.b.c((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramBoolean);
      }
      AppMethodBeat.o(35013);
      return;
    }
  }
  
  public final void a(int paramInt, d.a parama)
  {
    AppMethodBeat.i(35009);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", new Object[] { Integer.valueOf(paramInt), parama });
    Bundle localBundle = new Bundle();
    localBundle.putInt("MSG_POSITION", paramInt);
    localBundle.putInt("SCENE", 2);
    this.JFC.a(parama, false, localBundle);
    AppMethodBeat.o(35009);
  }
  
  public final void a(long paramLong, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(35014);
    if ((!this.JFx.containsKey(Long.valueOf(paramLong))) || (!this.JFw.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35014);
      return;
    }
    Object localObject = (WeakReference)this.JFx.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        ap.a.a(this.Jdu.JOR.getContext(), (com.tencent.mm.ui.chatting.viewitems.c.a)localObject, parambu, paramBoolean);
      }
      AppMethodBeat.o(35014);
      return;
    }
  }
  
  public final void a(long paramLong, boolean paramBoolean, d.a parama)
  {
    AppMethodBeat.i(35008);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), parama });
    Bundle localBundle = new Bundle();
    localBundle.putLong("MSG_ID", paramLong);
    localBundle.putInt("SCENE", 1);
    localBundle.putBoolean("IS_LOAD_ALL", paramBoolean);
    this.JFC.a(parama, true, localBundle);
    AppMethodBeat.o(35008);
  }
  
  public final bu ada(int paramInt)
  {
    AppMethodBeat.i(34999);
    bu localbu = (bu)this.JFq.get(paramInt);
    AppMethodBeat.o(34999);
    return localbu;
  }
  
  public final void adb(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(35007);
    bu localbu = ada(paramInt);
    if (localbu == null) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[setShowHistoryMsgTipId] pos:%s msg is null? %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if ((localbu != null) && (localbu.field_msgId != 0L)) {
      this.JFt = localbu.field_msgId;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(35007);
  }
  
  public final void adc(int paramInt)
  {
    AppMethodBeat.i(35015);
    bu localbu = ada(paramInt);
    if ((localbu != null) && (localbu.field_msgId != 0L)) {
      this.JFr.add(Long.valueOf(localbu.field_msgId));
    }
    AppMethodBeat.o(35015);
  }
  
  public final bu ade(int paramInt)
  {
    AppMethodBeat.i(161523);
    paramInt -= 1;
    if ((this.JFq != null) && (paramInt >= 0) && (paramInt < this.JFq.size()))
    {
      bu localbu = (bu)this.JFq.get(paramInt);
      AppMethodBeat.o(161523);
      return localbu;
    }
    AppMethodBeat.o(161523);
    return null;
  }
  
  public final boolean bE(bu parambu)
  {
    AppMethodBeat.i(193889);
    if ((parambu != null) && (bD(parambu)))
    {
      AppMethodBeat.o(193889);
      return true;
    }
    AppMethodBeat.o(193889);
    return false;
  }
  
  public final void cwh()
  {
    AppMethodBeat.i(35003);
    this.JFy = false;
    notifyDataSetChanged();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
    this.JFd = this.JFe;
    this.JFf = this.JFg;
    this.JFh = this.JFi;
    this.JFj = this.JFk;
    this.JFl = this.JFm;
    AppMethodBeat.o(35003);
  }
  
  public final int dCM()
  {
    AppMethodBeat.i(35001);
    int i = this.JFv.size();
    AppMethodBeat.o(35001);
    return i;
  }
  
  public final void e(View.OnClickListener paramOnClickListener)
  {
    this.JFn = paramOnClickListener;
  }
  
  public final void eO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35020);
    if (this.Jdu == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    Object localObject1 = this.Jdu.BYG;
    if (localObject1 == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNh();
    bu localbu;
    Object localObject2;
    if (((am)localObject1).fqg())
    {
      localObject1 = new ArrayList();
      while (paramInt1 <= paramInt2)
      {
        localbu = ade(paramInt1);
        if ((localbu != null) && (localbu.getType() == 285212721))
        {
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + localbu.field_msgId);
          ((List)localObject1).add(new String[] { String.valueOf(localbu.field_msgId), localbu.field_content, "-1" });
          localObject2 = new q();
          ((q)localObject2).msgId = localbu.field_msgId;
          ((q)localObject2).hDa = localbu.field_content;
          if (bool) {
            localLinkedList.add(localObject2);
          }
        }
        paramInt1 += 1;
      }
      if (((List)localObject1).size() > 0)
      {
        ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).k((List)localObject1, 0);
        if (bool) {
          ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).l(localLinkedList, 0);
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
      localbu = ade(paramInt1);
      if ((localbu != null) && ((localbu.getType() & 0x31) != 0))
      {
        localObject2 = localbu.field_content;
        if (localObject2 != null)
        {
          localObject2 = k.b.aA((String)localObject2, localbu.field_reserved);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((k.b)localObject2).url)) && (((k.b)localObject2).url.contains("mp.weixin.qq.com")))
          {
            localObject3 = bl.cz(localbu);
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.ui.chatting.viewitems.c)localObject3).b(this.Jdu, localbu);
              if (localObject3 != null)
              {
                str = ((aw)localObject1).field_username;
                if (str != null)
                {
                  j = x.aG((String)localObject3, this.Jdu.getTalkerUserName());
                  localObject4 = (com.tencent.mm.ai.e)((k.b)localObject2).ao(com.tencent.mm.ai.e.class);
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
    for (int i = ((com.tencent.mm.ai.e)localObject4).hzh;; i = -1)
    {
      localObject4 = new ArrayList();
      ((List)localObject4).add(((k.b)localObject2).url);
      ((List)localObject4).add(String.valueOf(i));
      ((List)localObject4).add(String.valueOf(localbu.field_msgSvrId));
      ((List)localObject4).add(str);
      ((List)localObject4).add(String.valueOf(j));
      ((List)localObject4).add(localObject3);
      ((List)localObject4).add(String.valueOf(localbu.field_createTime));
      ((List)localObject4).add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WP(str)));
      localLinkedList.add(localObject4);
      paramInt1 += 1;
      break;
      if (localLinkedList.size() > 0) {
        ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).j(localLinkedList, 1);
      }
      AppMethodBeat.o(35020);
      return;
    }
  }
  
  public final void eZZ()
  {
    AppMethodBeat.i(34997);
    com.tencent.mm.ui.chatting.e.a.fFx().post(new Runnable()
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
  
  public final SparseArray<bu> fCi()
  {
    return this.JFq;
  }
  
  public final Set<Long> fCk()
  {
    return this.JFv;
  }
  
  public final void fCl()
  {
    AppMethodBeat.i(35002);
    if (this.JFv != null) {
      this.JFv.clear();
    }
    AppMethodBeat.o(35002);
  }
  
  public final void fCm()
  {
    AppMethodBeat.i(35004);
    this.JFy = true;
    notifyDataSetChanged();
    fCj();
    AppMethodBeat.o(35004);
  }
  
  public final void fCn()
  {
    this.JFz = true;
  }
  
  public final void fCo()
  {
    AppMethodBeat.i(35006);
    if (this.JFD)
    {
      this.JFE += 1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.JFE);
      AppMethodBeat.o(35006);
      return;
    }
    if (!this.cUC)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
      AppMethodBeat.o(35006);
      return;
    }
    this.JFC.a(d.a.JVf, false, null);
    AppMethodBeat.o(35006);
  }
  
  public final void fCp()
  {
    AppMethodBeat.i(35010);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.JFD), Integer.valueOf(this.JFE) });
    if (this.JFD)
    {
      AppMethodBeat.o(35010);
      return;
    }
    this.JFD = true;
    this.JFE = 0;
    AppMethodBeat.o(35010);
  }
  
  public final void fCq()
  {
    AppMethodBeat.i(35011);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.JFD), Integer.valueOf(this.JFE) });
    if (!this.JFD)
    {
      AppMethodBeat.o(35011);
      return;
    }
    this.JFD = false;
    if (this.JFE > 0) {
      this.JFC.a(d.a.JVf, false, null);
    }
    this.JFE = 0;
    AppMethodBeat.o(35011);
  }
  
  public final void fCr()
  {
    AppMethodBeat.i(35016);
    this.JFA = true;
    fCj();
    AppMethodBeat.o(35016);
  }
  
  public final t.a fCs()
  {
    return this.JFG;
  }
  
  public final s.f fCt()
  {
    return this.JFf;
  }
  
  public final s.g fCu()
  {
    return this.JFd;
  }
  
  public final ab fCv()
  {
    return this.JFj;
  }
  
  public final com.tencent.mm.pluginsdk.ui.chat.l fCw()
  {
    return this.JFh;
  }
  
  public final com.tencent.mm.ui.chatting.c fCx()
  {
    return this.JFl;
  }
  
  public final long fCy()
  {
    AppMethodBeat.i(35017);
    long l;
    if (this.JFH != -1L)
    {
      l = this.JFH;
      AppMethodBeat.o(35017);
      return l;
    }
    this.JFH = 0L;
    int i = getCount() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        bu localbu = ada(i);
        if ((localbu.field_isSend == 1) && ((localbu.eLr & 0x4) != 4)) {
          this.JFH = localbu.field_msgId;
        }
      }
      else
      {
        l = this.JFH;
        AppMethodBeat.o(35017);
        return l;
      }
      i -= 1;
    }
  }
  
  public final com.tencent.mm.aw.a.a.c fCz()
  {
    AppMethodBeat.i(35019);
    if (this.fSr == null) {
      fcE();
    }
    com.tencent.mm.aw.a.a.c localc = this.fSr;
    AppMethodBeat.o(35019);
    return localc;
  }
  
  public final int fpw()
  {
    AppMethodBeat.i(34998);
    if (-1 == this.fTH)
    {
      ba.aBQ();
      this.fTH = com.tencent.mm.model.c.azs().aqm(this.Jdu.getTalkerUserName());
    }
    int i = this.fTH;
    AppMethodBeat.o(34998);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34990);
    int i = this.JFq.size();
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
    paramInt = bl.cA(ada(paramInt));
    AppMethodBeat.o(34991);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34993);
    bu localbu = ada(paramInt);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "[getView] position:" + paramInt + " msgId:" + localbu.field_msgId + " svrId:" + localbu.field_msgSvrId + " type:" + localbu.getType() + " send:" + localbu.field_isSend + " talker:" + localbu.field_talker + " msgSep:" + localbu.field_msgSeq + " time:" + localbu.field_createTime);
    if (paramInt == 0)
    {
      paramViewGroup = this.Jdu;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
      paramViewGroup.JOS.fBX();
    }
    int i;
    int j;
    label227:
    label246:
    Object localObject;
    if ((paramInt != 0) && (this.JFs.get(paramInt) == 0))
    {
      long l1 = ada(paramInt - 1).field_createTime;
      long l2 = localbu.field_createTime;
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
        this.JFs.put(paramInt, 2);
      }
    }
    else
    {
      if (((this.JFs.get(paramInt) != 1) && (paramInt != 0) && (!this.JFr.contains(Long.valueOf(localbu.field_msgId)))) || (localbu.field_createTime <= 1000L)) {
        break label1235;
      }
      i = 1;
      label295:
      if (localbu.field_msgId != this.JFt) {
        break label1241;
      }
      j = 1;
      label311:
      if (t.aKa().Gb(this.Jdu.getTalkerUserName()) == null)
      {
        ba.aBQ();
        ((Integer)com.tencent.mm.model.c.ajl().get(12311, Integer.valueOf(-2))).intValue();
      }
      if (paramView != null) {
        break label1247;
      }
      localObject = bl.cz(localbu);
      paramView = ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(this.jfG, paramView);
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.JYv = ((com.tencent.mm.ui.chatting.viewitems.c)localObject);
      label388:
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", new Object[] { paramViewGroup.JYv });
      if (i == 0) {
        break label1258;
      }
      paramViewGroup.fTP.setVisibility(0);
      paramViewGroup.fTP.setText(com.tencent.mm.pluginsdk.i.i.c(this.Jdu.JOR.getContext(), localbu.field_createTime, false));
      if (paramViewGroup.fTP.getTextSize() > com.tencent.mm.cc.a.fromDPToPix(this.Jdu.JOR.getContext(), 25)) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", new Object[] { Float.valueOf(paramViewGroup.fTP.getTextSize()) });
      }
      label500:
      if (paramViewGroup.JYq != null)
      {
        if (j == 0) {
          break label1270;
        }
        paramViewGroup.JYq.setVisibility(0);
      }
      label520:
      if (this.JFu == -1L)
      {
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().apY(this.Jdu.getTalkerUserName());
        if (localObject == null) {
          break label1282;
        }
        this.JFu = ((ei)localObject).field_msgId;
      }
      label573:
      if (paramViewGroup.JYr != null)
      {
        if ((!this.JFz) || (localbu.field_msgId != this.JFu)) {
          break label1290;
        }
        paramViewGroup.JYr.setVisibility(0);
      }
      label608:
      localObject = paramViewGroup.JYv;
      paramViewGroup.JYu = null;
      com.tencent.mm.az.f localf = com.tencent.mm.az.a.aJJ();
      if ((localf != null) && (localf.ihg != null) && (localf.ihe == 0) && (com.tencent.mm.az.a.aJG())) {
        paramViewGroup.JYu = localf.ihg;
      }
      ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(paramViewGroup, paramInt, this.Jdu, localbu);
      localObject = ((com.tencent.mm.ui.chatting.d.b.c)this.Jdu.bh(com.tencent.mm.ui.chatting.d.b.c.class)).fDj();
      if ((paramViewGroup.fTP.getVisibility() == 0) && (localObject != null))
      {
        paramViewGroup.fTP.setTextColor(((com.tencent.mm.pluginsdk.ui.f)localObject).ESd);
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).ESe) {
          break label1302;
        }
        paramViewGroup.fTP.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.f)localObject).ESf);
        label747:
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).ESg) {
          break label1329;
        }
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).ESh) {
          break label1316;
        }
        paramViewGroup.fTP.setBackgroundResource(2131231583);
        label773:
        paramViewGroup.fTP.setPadding(this.JFp, this.JFo, this.JFp, this.JFo);
      }
      label796:
      if ((paramViewGroup.yEk != null) && (paramViewGroup.yEk.getVisibility() == 0) && (localObject != null) && (!this.Jdu.getTalkerUserName().equals("qqmail")) && (localbu.getType() != 318767153))
      {
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).ESh) {
          break label1340;
        }
        paramViewGroup.yEk.setTextColor(-1);
        paramViewGroup.yEk.setShadowLayer(com.tencent.mm.cc.a.fromDPToPix(paramViewGroup.yEk.getContext(), 2), 0.0F, com.tencent.mm.cc.a.fromDPToPix(paramViewGroup.yEk.getContext(), 1), this.Jdu.JOR.getMMResources().getColor(2131099662));
      }
      label909:
      if (paramViewGroup.gZU != null) {
        paramViewGroup.gZU.setTag(Long.valueOf(localbu.field_msgId));
      }
      if (((!this.JFy) || (!bD(localbu))) && (!this.JFA)) {
        break label1366;
      }
      if (paramViewGroup.iCK != null) {
        paramViewGroup.iCK.setChecked(this.JFv.contains(Long.valueOf(localbu.field_msgId)));
      }
      if (paramViewGroup.gZU != null) {
        paramViewGroup.gZU.setOnClickListener(this.JFn);
      }
      paramViewGroup.yh(true);
      label1005:
      if ((!this.JFy) || (!this.yCy) || (this.JFv.contains(Long.valueOf(localbu.field_msgId)))) {
        break label1374;
      }
      paramView.setAlpha(0.5F);
    }
    for (;;)
    {
      paramViewGroup = this.JFx.entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        localObject = (Map.Entry)paramViewGroup.next();
        if ((((Map.Entry)localObject).getValue() != null) && ((View)((WeakReference)((Map.Entry)localObject).getValue()).get() == paramView))
        {
          this.JFx.remove(((Map.Entry)localObject).getKey());
          this.JFw.remove(((Map.Entry)localObject).getKey());
        }
      }
      this.JFx.put(Long.valueOf(localbu.field_msgId), new WeakReference(paramView));
      if (localbu.fpi()) {
        this.JFw.put(Long.valueOf(localbu.field_msgId), Integer.valueOf(localbu.field_isSend));
      }
      AppMethodBeat.o(34993);
      return paramView;
      i = 0;
      break;
      label1217:
      j = 0;
      break label227;
      label1223:
      this.JFs.put(paramInt, 1);
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
      paramViewGroup.fTP.setVisibility(8);
      break label500;
      label1270:
      paramViewGroup.JYq.setVisibility(8);
      break label520;
      label1282:
      this.JFu = 0L;
      break label573;
      label1290:
      paramViewGroup.JYr.setVisibility(8);
      break label608;
      label1302:
      paramViewGroup.fTP.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label747;
      label1316:
      paramViewGroup.fTP.setBackgroundResource(2131231582);
      break label773;
      label1329:
      paramViewGroup.fTP.setBackgroundColor(0);
      break label796;
      label1340:
      paramViewGroup.yEk.setTextColor(((com.tencent.mm.pluginsdk.ui.f)localObject).ESd);
      paramViewGroup.yEk.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label909;
      label1366:
      paramViewGroup.yh(false);
      break label1005;
      label1374:
      paramView.setAlpha(1.0F);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(34992);
    int i = bl.fHx();
    AppMethodBeat.o(34992);
    return i;
  }
  
  public final boolean isInEditMode()
  {
    return this.JFy;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35005);
    super.notifyDataSetChanged();
    this.JFs.clear();
    AppMethodBeat.o(35005);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(34996);
    this.cUC = false;
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(this.JFF);
    com.tencent.mm.pluginsdk.ui.span.k.b(this.oca);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "adapter pause");
    this.JFB.stopTimer();
    AppMethodBeat.o(34996);
  }
  
  public final void qM(boolean paramBoolean)
  {
    AppMethodBeat.i(193890);
    if (this.yCy != paramBoolean)
    {
      this.yCy = paramBoolean;
      notifyDataSetChanged();
    }
    AppMethodBeat.o(193890);
  }
  
  public final void r(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35012);
    if ((!this.JFx.containsKey(Long.valueOf(paramLong))) || (!this.JFw.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35012);
      return;
    }
    Object localObject = (WeakReference)this.JFx.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ap.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramInt1, paramInt2);
      }
      AppMethodBeat.o(35012);
      return;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(34995);
    this.cUC = true;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingDataAdapter", "adapter resume");
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(this.JFF, Looper.getMainLooper());
    com.tencent.mm.pluginsdk.ui.span.k.a(this.oca);
    this.JFB.az(300000L, 300000L);
    if (this.JFC != null) {
      this.JFC.a(d.a.JVf, false, null);
    }
    AppMethodBeat.o(34995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a
 * JD-Core Version:    0.7.0.1
 */