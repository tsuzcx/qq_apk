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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.q;
import com.tencent.mm.be.w;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.t.f;
import com.tencent.mm.ui.chatting.t.g;
import com.tencent.mm.ui.chatting.viewitems.az.a;
import com.tencent.mm.ui.chatting.viewitems.az.b;
import com.tencent.mm.ui.chatting.viewitems.bj.d;
import com.tencent.mm.ui.chatting.viewitems.bz;
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
  protected i.a GBj;
  private boolean JcX;
  private final MTimerHandler WFA;
  public com.tencent.mm.ui.chatting.o.a.a WFB;
  private boolean WFC;
  private int WFD;
  private x.a WFE;
  private long WFF;
  public t.g WFc;
  private t.g WFd;
  public t.f WFe;
  private t.f WFf;
  public com.tencent.mm.pluginsdk.ui.chat.l WFg;
  private com.tencent.mm.pluginsdk.ui.chat.l WFh;
  public af WFi;
  private af WFj;
  public com.tencent.mm.ui.chatting.c WFk;
  private com.tencent.mm.ui.chatting.c WFl;
  private View.OnClickListener WFm;
  private final int WFn;
  private final int WFo;
  public SparseArray<ca> WFp;
  private HashSet<Long> WFq;
  public SparseIntArray WFr;
  public long WFs;
  public long WFt;
  private CopyOnWriteArraySet<Long> WFu;
  private Map<Long, Integer> WFv;
  private Map<Long, WeakReference<View>> WFw;
  private boolean WFx;
  private boolean WFy;
  private boolean WFz;
  public com.tencent.mm.ui.chatting.e.a WbU;
  private int cUX;
  private boolean fdB;
  public com.tencent.mm.ay.a.a.c jjH;
  private ListView mListView;
  private LayoutInflater mYa;
  private com.tencent.mm.pluginsdk.ui.span.i sCG;
  
  public a(com.tencent.mm.ui.chatting.e.a parama, ListView paramListView)
  {
    AppMethodBeat.i(34989);
    this.WFm = null;
    this.WFp = new SparseArray();
    this.WFq = new HashSet();
    this.WFr = new SparseIntArray();
    this.WFs = -1L;
    this.WFt = -1L;
    this.WFu = new CopyOnWriteArraySet();
    this.WFv = new HashMap();
    this.WFw = new HashMap();
    this.WFx = false;
    this.WFy = false;
    this.JcX = false;
    this.WFz = false;
    this.WFA = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34984);
        if ((a.a(a.this) != null) && (a.a(a.this).dgo))
        {
          Log.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
          a.this.hNI();
        }
        AppMethodBeat.o(34984);
        return true;
      }
    }, true);
    this.cUX = -1;
    this.WFC = false;
    this.WFD = 0;
    this.GBj = new i.a()
    {
      public final void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i paramAnonymousi, i.c paramAnonymousc)
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
          a.this.hNI();
        }
        AppMethodBeat.o(34986);
      }
    };
    this.WFE = new x.a()
    {
      public final void a(x.a.a paramAnonymousa)
      {
        AppMethodBeat.i(34988);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousa != null)
        {
          bool1 = bool2;
          if (paramAnonymousa.mhX != 3) {
            if ((paramAnonymousa.mhX != 2) && (paramAnonymousa.mhX != -1))
            {
              bool1 = bool2;
              if (paramAnonymousa.mhX != 1) {}
            }
            else
            {
              bool1 = bj.d.b(paramAnonymousa);
            }
          }
        }
        if (!bool1) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34987);
              a.this.hNI();
              AppMethodBeat.o(34987);
            }
          });
        }
        AppMethodBeat.o(34988);
      }
    };
    this.WFF = -1L;
    this.jjH = null;
    parama.a(k.class, this);
    this.mListView = paramListView;
    this.WbU = parama;
    this.mYa = ad.kS(parama.WQv.getContext());
    this.WFn = parama.WQv.getMMResources().getDimensionPixelSize(R.f.SmallestPadding);
    this.WFo = parama.WQv.getMMResources().getDimensionPixelSize(R.f.LittlePadding);
    paramListView = new t.g();
    this.WFd = paramListView;
    this.WFc = paramListView;
    paramListView = new t.f(parama);
    this.WFf = paramListView;
    this.WFe = paramListView;
    paramListView = new com.tencent.mm.pluginsdk.ui.chat.l(parama.WQv.getContext());
    this.WFh = paramListView;
    this.WFg = paramListView;
    paramListView = new af(parama);
    this.WFj = paramListView;
    this.WFi = paramListView;
    paramListView = new com.tencent.mm.ui.chatting.c(parama);
    this.WFl = paramListView;
    this.WFk = paramListView;
    this.sCG = new ag(parama);
    hkz();
    AppMethodBeat.o(34989);
  }
  
  private static boolean cm(ca paramca)
  {
    AppMethodBeat.i(284522);
    if ((paramca.hzA()) || (paramca.hzD()) || (paramca.hzL()))
    {
      AppMethodBeat.o(284522);
      return false;
    }
    AppMethodBeat.o(284522);
    return true;
  }
  
  private void hNC()
  {
    AppMethodBeat.i(34994);
    Log.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
    this.WFc = null;
    this.WFe = null;
    this.WFg = null;
    this.WFi = null;
    this.WFk = null;
    AppMethodBeat.o(34994);
  }
  
  private void hkz()
  {
    AppMethodBeat.i(35018);
    if (this.jjH == null)
    {
      com.tencent.mm.ay.a.a.c.a locala = new com.tencent.mm.ay.a.a.c.a();
      locala.prefixPath = com.tencent.mm.ao.a.e.Vj(this.WbU.getTalkerUserName());
      locala.lRD = true;
      locala.kOl = true;
      locala.lRP = R.k.default_avatar;
      try
      {
        this.jjH = locala.bmL();
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
  
  public final View Fl(long paramLong)
  {
    AppMethodBeat.i(284531);
    if (!this.WFw.containsKey(Long.valueOf(paramLong)))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(284531);
      return null;
    }
    Object localObject = (WeakReference)this.WFw.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(284531);
      return localObject;
    }
    AppMethodBeat.o(284531);
    return null;
  }
  
  public final void Q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35013);
    if ((!this.WFw.containsKey(Long.valueOf(paramLong))) || (!this.WFv.containsKey(Long.valueOf(paramLong))))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35013);
      return;
    }
    Object localObject = (WeakReference)this.WFw.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        az.b.c((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramBoolean);
      }
      AppMethodBeat.o(35013);
      return;
    }
  }
  
  public final boolean VC(long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(35000);
    int i;
    label65:
    Object localObject;
    label128:
    label181:
    int k;
    if (this.WFu.contains(Long.valueOf(paramLong)))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      this.WFu.remove(Long.valueOf(paramLong));
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
          ((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).checkBox.setChecked(this.WFu.contains(Long.valueOf(paramLong)));
        }
        AppMethodBeat.o(35000);
        return true;
      }
    }
    else
    {
      Log.d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      k = this.WFu.size();
      if (!this.WFy) {
        break label403;
      }
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWw, 99);
      Log.d("MicroMsg.recordSelect.SelectRecordConfig", "getSelectRecordMaxNum() num:%s", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if (k >= i)
      {
        if (this.WFy) {}
        for (localObject = this.WbU.WQv.getMMResources().getString(R.l.eCE, new Object[] { Integer.valueOf(i) });; localObject = this.WbU.WQv.getMMResources().getString(R.l.eCD, new Object[] { Integer.valueOf(99) }))
        {
          com.tencent.mm.ui.base.h.c(this.WbU.WQv.getContext(), (String)localObject, "", true);
          AppMethodBeat.o(35000);
          return false;
        }
      }
      this.WFu.add(Long.valueOf(paramLong));
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
  
  public final void a(int paramInt, d.a parama)
  {
    AppMethodBeat.i(35009);
    Log.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", new Object[] { Integer.valueOf(paramInt), parama });
    Bundle localBundle = new Bundle();
    localBundle.putInt("MSG_POSITION", paramInt);
    localBundle.putInt("SCENE", 2);
    this.WFB.a(parama, false, localBundle);
    AppMethodBeat.o(35009);
  }
  
  public final void a(long paramLong, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(35014);
    if ((!this.WFw.containsKey(Long.valueOf(paramLong))) || (!this.WFv.containsKey(Long.valueOf(paramLong))))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35014);
      return;
    }
    Object localObject = (WeakReference)this.WFw.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        az.a.a(this.WbU.WQv.getContext(), (com.tencent.mm.ui.chatting.viewitems.c.a)localObject, paramca, paramBoolean);
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
    this.WFB.a(parama, true, localBundle);
    AppMethodBeat.o(35008);
  }
  
  public final ca avt(int paramInt)
  {
    AppMethodBeat.i(34999);
    ca localca = (ca)this.WFp.get(paramInt);
    AppMethodBeat.o(34999);
    return localca;
  }
  
  public final void avu(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(35007);
    ca localca = avt(paramInt);
    if (localca == null) {
      bool = true;
    }
    Log.i("MicroMsg.ChattingDataAdapter", "[setShowHistoryMsgTipId] pos:%s msg is null? %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if ((localca != null) && (localca.field_msgId != 0L)) {
      this.WFs = localca.field_msgId;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(35007);
  }
  
  public final void avv(int paramInt)
  {
    AppMethodBeat.i(35015);
    ca localca = avt(paramInt);
    if ((localca != null) && (localca.field_msgId != 0L)) {
      this.WFq.add(Long.valueOf(localca.field_msgId));
    }
    AppMethodBeat.o(35015);
  }
  
  public final ca avw(int paramInt)
  {
    AppMethodBeat.i(161523);
    paramInt -= 1;
    if ((this.WFp != null) && (paramInt >= 0) && (paramInt < this.WFp.size()))
    {
      ca localca = (ca)this.WFp.get(paramInt);
      AppMethodBeat.o(161523);
      return localca;
    }
    AppMethodBeat.o(161523);
    return null;
  }
  
  public final boolean cn(ca paramca)
  {
    AppMethodBeat.i(284527);
    if ((paramca != null) && (cm(paramca)))
    {
      AppMethodBeat.o(284527);
      return true;
    }
    AppMethodBeat.o(284527);
    return false;
  }
  
  public final void dkS()
  {
    AppMethodBeat.i(35003);
    this.WFx = false;
    notifyDataSetChanged();
    Log.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
    this.WFc = this.WFd;
    this.WFe = this.WFf;
    this.WFg = this.WFh;
    this.WFi = this.WFj;
    this.WFk = this.WFl;
    AppMethodBeat.o(35003);
  }
  
  public final int dpe()
  {
    AppMethodBeat.i(34998);
    if (-1 == this.cUX)
    {
      bh.beI();
      this.cUX = com.tencent.mm.model.c.bbO().aOW(this.WbU.getTalkerUserName());
    }
    int i = this.cUX;
    AppMethodBeat.o(34998);
    return i;
  }
  
  public final void fB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35020);
    if (this.WbU == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    Object localObject1 = this.WbU.NKq;
    if (localObject1 == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyB();
    ca localca;
    Object localObject2;
    if (((as)localObject1).hxX())
    {
      localObject1 = new ArrayList();
      while (paramInt1 <= paramInt2)
      {
        localca = avw(paramInt1);
        if ((localca != null) && (localca.getType() == 285212721))
        {
          Log.v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + localca.field_msgId);
          ((List)localObject1).add(new String[] { String.valueOf(localca.field_msgId), localca.field_content, "-1" });
          localObject2 = new q();
          ((q)localObject2).msgId = localca.field_msgId;
          ((q)localObject2).lpy = localca.field_content;
          if (bool) {
            localLinkedList.add(localObject2);
          }
        }
        paramInt1 += 1;
      }
      if (((List)localObject1).size() > 0)
      {
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).k((List)localObject1, 0);
        if (bool) {
          ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).l(localLinkedList, 0);
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
      localca = avw(paramInt1);
      if ((localca != null) && ((localca.getType() & 0x31) != 0))
      {
        localObject2 = localca.field_content;
        if (localObject2 != null)
        {
          localObject2 = k.b.aG((String)localObject2, localca.field_reserved);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((k.b)localObject2).url)) && (((k.b)localObject2).url.contains(WeChatHosts.domainString(R.l.host_mp_weixin_qq_com))))
          {
            localObject3 = bz.dk(localca);
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.ui.chatting.viewitems.c)localObject3).a(this.WbU, localca);
              if (localObject3 != null)
              {
                str = ((ax)localObject1).field_username;
                if (str != null)
                {
                  j = ac.aN((String)localObject3, this.WbU.getTalkerUserName());
                  localObject4 = (com.tencent.mm.aj.e)((k.b)localObject2).ar(com.tencent.mm.aj.e.class);
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
    for (int i = ((com.tencent.mm.aj.e)localObject4).llp;; i = -1)
    {
      localObject4 = new ArrayList();
      ((List)localObject4).add(((k.b)localObject2).url);
      ((List)localObject4).add(String.valueOf(i));
      ((List)localObject4).add(String.valueOf(localca.field_msgSvrId));
      ((List)localObject4).add(str);
      ((List)localObject4).add(String.valueOf(j));
      ((List)localObject4).add(localObject3);
      ((List)localObject4).add(String.valueOf(localca.field_createTime));
      ((List)localObject4).add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).ape(str)));
      localLinkedList.add(localObject4);
      paramInt1 += 1;
      break;
      if (localLinkedList.size() > 0) {
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).j(localLinkedList, 1);
      }
      AppMethodBeat.o(35020);
      return;
    }
  }
  
  public final int fsW()
  {
    AppMethodBeat.i(35001);
    int i = this.WFu.size();
    AppMethodBeat.o(35001);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34990);
    int i = this.WFp.size();
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
    paramInt = bz.dl(avt(paramInt));
    AppMethodBeat.o(34991);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34993);
    ca localca = avt(paramInt);
    Log.i("MicroMsg.ChattingDataAdapter", "[getView] position:" + paramInt + " msgId:" + localca.field_msgId + " svrId:" + localca.field_msgSvrId + " type:" + localca.getType() + " send:" + localca.field_isSend + " talker:" + localca.field_talker + " msgSep:" + localca.field_msgSeq + " time:" + localca.field_createTime);
    if (paramInt == 0)
    {
      paramViewGroup = this.WbU;
      Log.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
      paramViewGroup.WQw.hNo();
    }
    int i;
    int j;
    label227:
    label246:
    Object localObject;
    if ((paramInt != 0) && (this.WFr.get(paramInt) == 0))
    {
      long l1 = avt(paramInt - 1).field_createTime;
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
        this.WFr.put(paramInt, 2);
      }
    }
    else
    {
      if (((this.WFr.get(paramInt) != 1) && (paramInt != 0) && (!this.WFq.contains(Long.valueOf(localca.field_msgId)))) || (localca.field_createTime <= 1000L)) {
        break label1235;
      }
      i = 1;
      label295:
      if (localca.field_msgId != this.WFs) {
        break label1241;
      }
      j = 1;
      label311:
      if (w.bnV().WM(this.WbU.getTalkerUserName()) == null)
      {
        bh.beI();
        ((Integer)com.tencent.mm.model.c.aHp().b(12311, Integer.valueOf(-2))).intValue();
      }
      if (paramView != null) {
        break label1247;
      }
      localObject = bz.dk(localca);
      paramView = ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(this.mYa, paramView);
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.setChattingItem((com.tencent.mm.ui.chatting.viewitems.c)localObject);
      label388:
      Log.d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", new Object[] { paramViewGroup.chattingItem });
      if (i == 0) {
        break label1258;
      }
      paramViewGroup.timeTV.setVisibility(0);
      paramViewGroup.timeTV.setText(com.tencent.mm.pluginsdk.j.f.d(this.WbU.WQv.getContext(), localca.field_createTime, false));
      if (paramViewGroup.timeTV.getTextSize() > com.tencent.mm.ci.a.fromDPToPix(this.WbU.WQv.getContext(), 25)) {
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
      if (this.WFt == -1L)
      {
        localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOI(this.WbU.getTalkerUserName());
        if (localObject == null) {
          break label1282;
        }
        this.WFt = ((et)localObject).field_msgId;
      }
      label573:
      if (paramViewGroup.noMoreMsgTip != null)
      {
        if ((!this.WFy) || (localca.field_msgId != this.WFt)) {
          break label1290;
        }
        paramViewGroup.noMoreMsgTip.setVisibility(0);
      }
      label608:
      localObject = paramViewGroup.chattingItem;
      paramViewGroup.playingMsgId = null;
      com.tencent.mm.bb.f localf = com.tencent.mm.bb.a.bnA();
      if ((localf != null) && (localf.lVt != null) && (localf.lVr == 0) && (com.tencent.mm.bb.a.bnx())) {
        paramViewGroup.playingMsgId = localf.lVt;
      }
      ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(paramViewGroup, paramInt, this.WbU, localca);
      localObject = ((com.tencent.mm.ui.chatting.d.b.c)this.WbU.bC(com.tencent.mm.ui.chatting.d.b.c.class)).hOH();
      if ((paramViewGroup.timeTV.getVisibility() == 0) && (localObject != null))
      {
        paramViewGroup.timeTV.setTextColor(((com.tencent.mm.pluginsdk.ui.f)localObject).RbV);
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).RbW) {
          break label1302;
        }
        paramViewGroup.timeTV.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.f)localObject).RbX);
        label747:
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).RbY) {
          break label1329;
        }
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).RbZ) {
          break label1316;
        }
        paramViewGroup.timeTV.setBackgroundResource(R.g.chat_tips_light_bg);
        label773:
        paramViewGroup.timeTV.setPadding(this.WFo, this.WFn, this.WFo, this.WFn);
      }
      label796:
      if ((paramViewGroup.userTV != null) && (paramViewGroup.userTV.getVisibility() == 0) && (localObject != null) && (!this.WbU.getTalkerUserName().equals("qqmail")) && (localca.getType() != 318767153))
      {
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).RbZ) {
          break label1340;
        }
        paramViewGroup.userTV.setTextColor(-1);
        paramViewGroup.userTV.setShadowLayer(com.tencent.mm.ci.a.fromDPToPix(paramViewGroup.userTV.getContext(), 2), 0.0F, com.tencent.mm.ci.a.fromDPToPix(paramViewGroup.userTV.getContext(), 1), this.WbU.WQv.getMMResources().getColor(R.e.BW_0_Alpha_0_5));
      }
      label909:
      if (paramViewGroup.maskView != null) {
        paramViewGroup.maskView.setTag(Long.valueOf(localca.field_msgId));
      }
      if (((!this.WFx) || (!cm(localca))) && (!this.WFz)) {
        break label1366;
      }
      if (paramViewGroup.checkBox != null) {
        paramViewGroup.checkBox.setChecked(this.WFu.contains(Long.valueOf(localca.field_msgId)));
      }
      if (paramViewGroup.maskView != null) {
        paramViewGroup.maskView.setOnClickListener(this.WFm);
      }
      paramViewGroup.showEditView(true);
      label1005:
      if ((!this.WFx) || (!this.JcX) || (this.WFu.contains(Long.valueOf(localca.field_msgId)))) {
        break label1374;
      }
      paramView.setAlpha(0.5F);
    }
    for (;;)
    {
      paramViewGroup = this.WFw.entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        localObject = (Map.Entry)paramViewGroup.next();
        if ((((Map.Entry)localObject).getValue() != null) && ((View)((WeakReference)((Map.Entry)localObject).getValue()).get() == paramView))
        {
          this.WFw.remove(((Map.Entry)localObject).getKey());
          this.WFv.remove(((Map.Entry)localObject).getKey());
        }
      }
      this.WFw.put(Long.valueOf(localca.field_msgId), new WeakReference(paramView));
      if (localca.hwG()) {
        this.WFv.put(Long.valueOf(localca.field_msgId), Integer.valueOf(localca.field_isSend));
      }
      AppMethodBeat.o(34993);
      return paramView;
      i = 0;
      break;
      label1217:
      j = 0;
      break label227;
      label1223:
      this.WFr.put(paramInt, 1);
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
      this.WFt = 0L;
      break label573;
      label1290:
      paramViewGroup.noMoreMsgTip.setVisibility(8);
      break label608;
      label1302:
      paramViewGroup.timeTV.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label747;
      label1316:
      paramViewGroup.timeTV.setBackgroundResource(R.g.chat_tips_bg);
      break label773;
      label1329:
      paramViewGroup.timeTV.setBackgroundColor(0);
      break label796;
      label1340:
      paramViewGroup.userTV.setTextColor(((com.tencent.mm.pluginsdk.ui.f)localObject).RbV);
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
    int i = bz.hTY();
    AppMethodBeat.o(34992);
    return i;
  }
  
  public final SparseArray<ca> hNB()
  {
    return this.WFp;
  }
  
  public final Set<Long> hND()
  {
    return this.WFu;
  }
  
  public final void hNE()
  {
    AppMethodBeat.i(35002);
    if (this.WFu != null) {
      this.WFu.clear();
    }
    AppMethodBeat.o(35002);
  }
  
  public final void hNF()
  {
    AppMethodBeat.i(35004);
    this.WFx = true;
    notifyDataSetChanged();
    hNC();
    AppMethodBeat.o(35004);
  }
  
  public final void hNG()
  {
    this.WFy = true;
  }
  
  public final boolean hNH()
  {
    return this.WFx;
  }
  
  public final void hNI()
  {
    AppMethodBeat.i(35006);
    if (this.WFC)
    {
      this.WFD += 1;
      Log.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.WFD);
      AppMethodBeat.o(35006);
      return;
    }
    if (!this.fdB)
    {
      Log.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
      AppMethodBeat.o(35006);
      return;
    }
    this.WFB.a(d.a.WYs, false, null);
    AppMethodBeat.o(35006);
  }
  
  public final void hNJ()
  {
    AppMethodBeat.i(35010);
    Log.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.WFC), Integer.valueOf(this.WFD) });
    if (this.WFC)
    {
      AppMethodBeat.o(35010);
      return;
    }
    this.WFC = true;
    this.WFD = 0;
    AppMethodBeat.o(35010);
  }
  
  public final void hNK()
  {
    AppMethodBeat.i(35011);
    Log.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.WFC), Integer.valueOf(this.WFD) });
    if (!this.WFC)
    {
      AppMethodBeat.o(35011);
      return;
    }
    this.WFC = false;
    if (this.WFD > 0) {
      this.WFB.a(d.a.WYs, false, null);
    }
    this.WFD = 0;
    AppMethodBeat.o(35011);
  }
  
  public final void hNL()
  {
    AppMethodBeat.i(35016);
    this.WFz = true;
    hNC();
    AppMethodBeat.o(35016);
  }
  
  public final x.a hNM()
  {
    return this.WFE;
  }
  
  public final t.f hNN()
  {
    return this.WFe;
  }
  
  public final t.g hNO()
  {
    return this.WFc;
  }
  
  public final af hNP()
  {
    return this.WFi;
  }
  
  public final com.tencent.mm.pluginsdk.ui.chat.l hNQ()
  {
    return this.WFg;
  }
  
  public final com.tencent.mm.ui.chatting.c hNR()
  {
    return this.WFk;
  }
  
  public final long hNS()
  {
    AppMethodBeat.i(35017);
    long l;
    if (this.WFF != -1L)
    {
      l = this.WFF;
      AppMethodBeat.o(35017);
      return l;
    }
    this.WFF = 0L;
    int i = getCount() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        ca localca = avt(i);
        if ((localca.field_isSend == 1) && ((localca.hxx & 0x4) != 4)) {
          this.WFF = localca.field_msgId;
        }
      }
      else
      {
        l = this.WFF;
        AppMethodBeat.o(35017);
        return l;
      }
      i -= 1;
    }
  }
  
  public final com.tencent.mm.ay.a.a.c hNT()
  {
    AppMethodBeat.i(35019);
    if (this.jjH == null) {
      hkz();
    }
    com.tencent.mm.ay.a.a.c localc = this.jjH;
    AppMethodBeat.o(35019);
    return localc;
  }
  
  public final void hhz()
  {
    AppMethodBeat.i(34997);
    com.tencent.mm.ui.chatting.e.a.hRl().post(new Runnable()
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
  
  public final void k(View.OnClickListener paramOnClickListener)
  {
    this.WFm = paramOnClickListener;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35005);
    super.notifyDataSetChanged();
    this.WFr.clear();
    AppMethodBeat.o(35005);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(34996);
    this.fdB = false;
    bh.beI();
    com.tencent.mm.model.c.bbO().a(this.GBj);
    com.tencent.mm.pluginsdk.ui.span.l.b(this.sCG);
    Log.i("MicroMsg.ChattingDataAdapter", "adapter pause");
    this.WFA.stopTimer();
    AppMethodBeat.o(34996);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(34995);
    this.fdB = true;
    Log.i("MicroMsg.ChattingDataAdapter", "adapter resume");
    bh.beI();
    com.tencent.mm.model.c.bbO().a(this.GBj, Looper.getMainLooper());
    com.tencent.mm.pluginsdk.ui.span.l.a(this.sCG);
    this.WFA.startTimer(300000L);
    if (this.WFB != null) {
      this.WFB.a(d.a.WYs, false, null);
    }
    AppMethodBeat.o(34995);
  }
  
  public final void t(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35012);
    if ((!this.WFw.containsKey(Long.valueOf(paramLong))) || (!this.WFv.containsKey(Long.valueOf(paramLong))))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35012);
      return;
    }
    Object localObject = (WeakReference)this.WFw.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        az.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramInt1, paramInt2);
      }
      AppMethodBeat.o(35012);
      return;
    }
  }
  
  public final void xM(boolean paramBoolean)
  {
    AppMethodBeat.i(284529);
    if (this.JcX != paramBoolean)
    {
      this.JcX = paramBoolean;
      notifyDataSetChanged();
    }
    AppMethodBeat.o(284529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a
 * JD-Core Version:    0.7.0.1
 */