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
import android.view.View.OnLayoutChangeListener;
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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.q;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.component.api.d;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.v.f;
import com.tencent.mm.ui.chatting.v.g;
import com.tencent.mm.ui.chatting.viewitems.az.a;
import com.tencent.mm.ui.chatting.viewitems.az.b;
import com.tencent.mm.ui.chatting.viewitems.bk.d;
import com.tencent.mm.ui.chatting.viewitems.ca;
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
  implements com.tencent.mm.ui.chatting.component.api.m
{
  protected i.a Mxs;
  private boolean PmU;
  private final View.OnLayoutChangeListener adAI;
  public com.tencent.mm.ui.chatting.d.a adHw;
  public v.g aemC;
  private v.g aemD;
  public v.f aemE;
  private v.f aemF;
  public l aemG;
  private l aemH;
  public ai aemI;
  private ai aemJ;
  public com.tencent.mm.ui.chatting.c aemK;
  private com.tencent.mm.ui.chatting.c aemL;
  private View.OnClickListener aemM;
  private final int aemN;
  private final int aemO;
  public SparseArray<cc> aemP;
  private HashSet<Long> aemQ;
  public SparseIntArray aemR;
  public long aemS;
  public long aemT;
  private CopyOnWriteArraySet<Long> aemU;
  private Map<Long, Integer> aemV;
  private Map<Long, WeakReference<View>> aemW;
  private boolean aemX;
  private boolean aemY;
  private boolean aemZ;
  private final MTimerHandler aena;
  public com.tencent.mm.ui.chatting.k.a.a aenb;
  private Runnable aenc;
  private boolean aend;
  private int aene;
  private aa.a aenf;
  private long aeng;
  Set<Integer> aenh;
  private int eQx;
  private boolean hhr;
  public com.tencent.mm.modelimage.loader.a.c lMm;
  private ListView mListView;
  private LayoutInflater pUI;
  private com.tencent.mm.pluginsdk.ui.span.m vIA;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, ListView paramListView)
  {
    AppMethodBeat.i(34989);
    this.aemM = null;
    this.aemP = new SparseArray();
    this.aemQ = new HashSet();
    this.aemR = new SparseIntArray();
    this.aemS = -1L;
    this.aemT = -1L;
    this.aemU = new CopyOnWriteArraySet();
    this.aemV = new HashMap();
    this.aemW = new HashMap();
    this.aemX = false;
    this.aemY = false;
    this.PmU = false;
    this.aemZ = false;
    this.aena = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34984);
        if ((a.a(a.this) != null) && (a.a(a.this).ffv))
        {
          Log.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
          a.this.jqp();
        }
        AppMethodBeat.o(34984);
        return true;
      }
    }, true);
    this.adAI = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(254363);
        long l1 = paramAnonymousInt8 - paramAnonymousInt6;
        long l2 = paramAnonymousInt4 - paramAnonymousInt2;
        if ((l1 > 0L) && (l2 > l1) && (a.a(a.this) != null) && (a.a(a.this).juJ())) {
          a.a(a.this).r(false, true, true);
        }
        AppMethodBeat.o(254363);
      }
    };
    this.eQx = -1;
    this.aend = false;
    this.aene = 0;
    this.Mxs = new i.a()
    {
      public final void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i paramAnonymousi, i.c paramAnonymousc)
      {
        AppMethodBeat.i(254367);
        if ((paramAnonymousi == null) || (paramAnonymousc == null))
        {
          AppMethodBeat.o(254367);
          return;
        }
        if ((paramAnonymousc.talker == null) || (a.a(a.this).getTalkerUserName() == null))
        {
          AppMethodBeat.o(254367);
          return;
        }
        if (paramAnonymousc.talker.equals(a.a(a.this).getTalkerUserName())) {
          a.this.jqp();
        }
        AppMethodBeat.o(254367);
      }
    };
    this.aenf = new aa.a()
    {
      public final void a(final aa.a.a paramAnonymousa)
      {
        AppMethodBeat.i(254366);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousa != null)
        {
          bool1 = bool2;
          if (paramAnonymousa.pbi != 3) {
            if ((paramAnonymousa.pbi != 2) && (paramAnonymousa.pbi != -1))
            {
              bool1 = bool2;
              if (paramAnonymousa.pbi != 1) {}
            }
            else
            {
              bool1 = bk.d.b(paramAnonymousa);
              com.tencent.threadpool.h.ahAA.bm(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(254370);
                  z localz = ab.Qo(paramAnonymousa.fileName);
                  if (localz != null)
                  {
                    cc localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localz.pbc);
                    if (Util.isNullOrNil(localcc.field_imgPath))
                    {
                      AppMethodBeat.o(254370);
                      return;
                    }
                    int i = localcc.getType();
                    Log.i("MicroMsg.ChattingDataAdapter", "updateStatus, check revoke status msg type %d", new Object[] { Integer.valueOf(i) });
                    if ((43 != i) && (62 != i) && (localz.status == 199) && (localcc.field_msgSvrId != localz.hTh) && (ab.bOG()))
                    {
                      Log.i("MicroMsg.ChattingDataAdapter", "had uploaded after msg revoke, do revoke again");
                      localcc.gX(localz.hTh);
                      localcc.setType(43);
                      com.tencent.threadpool.h.ahAA.bk(new a.5.1..ExternalSyntheticLambda0(this, localcc));
                    }
                  }
                  AppMethodBeat.o(254370);
                }
              });
            }
          }
        }
        if (!bool1) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(254360);
              a.this.jqp();
              AppMethodBeat.o(254360);
            }
          });
        }
        AppMethodBeat.o(254366);
      }
    };
    this.aeng = -1L;
    this.lMm = null;
    this.aenh = new HashSet();
    parama.a(com.tencent.mm.ui.chatting.component.api.m.class, this);
    this.mListView = paramListView;
    this.adHw = parama;
    this.pUI = af.mU(parama.aezO.getContext());
    this.aemN = parama.aezO.getMMResources().getDimensionPixelSize(R.f.SmallestPadding);
    this.aemO = parama.aezO.getMMResources().getDimensionPixelSize(R.f.LittlePadding);
    paramListView = new v.g();
    this.aemD = paramListView;
    this.aemC = paramListView;
    paramListView = new v.f(parama);
    this.aemF = paramListView;
    this.aemE = paramListView;
    paramListView = new l(parama.aezO.getContext());
    this.aemH = paramListView;
    this.aemG = paramListView;
    paramListView = new ai(parama);
    this.aemJ = paramListView;
    this.aemI = paramListView;
    paramListView = new com.tencent.mm.ui.chatting.c(parama);
    this.aemL = paramListView;
    this.aemK = paramListView;
    this.vIA = new aj(parama);
    iLq();
    AppMethodBeat.o(34989);
  }
  
  private static boolean cA(cc paramcc)
  {
    AppMethodBeat.i(254373);
    if ((paramcc.jbE()) || (paramcc.jbI()) || (paramcc.jbQ()))
    {
      AppMethodBeat.o(254373);
      return false;
    }
    AppMethodBeat.o(254373);
    return true;
  }
  
  private void iLq()
  {
    AppMethodBeat.i(35018);
    if (this.lMm == null)
    {
      com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
      locala.prefixPath = com.tencent.mm.an.a.e.Ni(this.adHw.getTalkerUserName());
      locala.oKp = true;
      locala.nqa = true;
      locala.oKB = R.k.default_avatar;
      try
      {
        this.lMm = locala.bKx();
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
  
  private void jqj()
  {
    AppMethodBeat.i(34994);
    Log.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
    this.aemC = null;
    this.aemE = null;
    this.aemG = null;
    this.aemI = null;
    this.aemK = null;
    AppMethodBeat.o(34994);
  }
  
  public final void C(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35012);
    if ((!this.aemW.containsKey(Long.valueOf(paramLong))) || (!this.aemV.containsKey(Long.valueOf(paramLong))))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35012);
      return;
    }
    Object localObject = (WeakReference)this.aemW.get(Long.valueOf(paramLong));
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
  
  public final void CD(boolean paramBoolean)
  {
    AppMethodBeat.i(254416);
    if (this.PmU != paramBoolean)
    {
      this.PmU = paramBoolean;
      notifyDataSetChanged();
    }
    AppMethodBeat.o(254416);
  }
  
  public final void a(int paramInt, d.a parama)
  {
    AppMethodBeat.i(35009);
    Log.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", new Object[] { Integer.valueOf(paramInt), parama });
    Bundle localBundle = new Bundle();
    localBundle.putInt("MSG_POSITION", paramInt);
    localBundle.putInt("SCENE", 2);
    this.aenb.a(parama, false, localBundle);
    AppMethodBeat.o(35009);
  }
  
  public final void a(long paramLong, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(35014);
    if ((!this.aemW.containsKey(Long.valueOf(paramLong))) || (!this.aemV.containsKey(Long.valueOf(paramLong))))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35014);
      return;
    }
    Object localObject = (WeakReference)this.aemW.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        az.a.a(this.adHw.aezO.getContext(), (com.tencent.mm.ui.chatting.viewitems.c.a)localObject, paramcc, paramBoolean);
      }
      AppMethodBeat.o(35014);
      return;
    }
  }
  
  public final void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4, d.a parama)
  {
    AppMethodBeat.i(254442);
    Log.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1), parama });
    Bundle localBundle = new Bundle();
    localBundle.putLong("MSG_ID", paramLong);
    localBundle.putInt("SCENE", 1);
    localBundle.putBoolean("IS_LOAD_ALL", paramBoolean1);
    localBundle.putBoolean("IS_HIGHLIGHT_ITEM", paramBoolean2);
    localBundle.putBoolean("IS_IDLE_VISBLE", paramBoolean3);
    localBundle.putInt("SELECTION_TOP_OFFSET", paramInt);
    localBundle.putBoolean("IS_SMOOTH_SCROLL", paramBoolean4);
    this.aenb.a(parama, true, localBundle);
    AppMethodBeat.o(254442);
  }
  
  public final cc aBV(int paramInt)
  {
    AppMethodBeat.i(34999);
    cc localcc = (cc)this.aemP.get(paramInt);
    AppMethodBeat.o(34999);
    return localcc;
  }
  
  public final void aBW(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(35007);
    cc localcc = aBV(paramInt);
    if (localcc == null) {
      bool = true;
    }
    Log.i("MicroMsg.ChattingDataAdapter", "[setShowHistoryMsgTipId] pos:%s msg is null? %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if ((localcc != null) && (localcc.field_msgId != 0L)) {
      this.aemS = localcc.field_msgId;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(35007);
  }
  
  public final void aBX(int paramInt)
  {
    AppMethodBeat.i(35015);
    cc localcc = aBV(paramInt);
    if ((localcc != null) && (localcc.field_msgId != 0L)) {
      this.aemQ.add(Long.valueOf(localcc.field_msgId));
    }
    AppMethodBeat.o(35015);
  }
  
  public final cc aBY(int paramInt)
  {
    AppMethodBeat.i(161523);
    paramInt -= 1;
    if ((this.aemP != null) && (paramInt >= 0) && (paramInt < this.aemP.size()))
    {
      cc localcc = (cc)this.aemP.get(paramInt);
      AppMethodBeat.o(161523);
      return localcc;
    }
    AppMethodBeat.o(161523);
    return null;
  }
  
  public final void aZ(Runnable paramRunnable)
  {
    this.aenc = paramRunnable;
  }
  
  public final void ab(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(35013);
    if ((!this.aemW.containsKey(Long.valueOf(paramLong))) || (!this.aemV.containsKey(Long.valueOf(paramLong))))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(35013);
      return;
    }
    Object localObject = (WeakReference)this.aemW.get(Long.valueOf(paramLong));
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
  
  public final boolean cB(cc paramcc)
  {
    AppMethodBeat.i(254409);
    if ((paramcc != null) && (cA(paramcc)))
    {
      AppMethodBeat.o(254409);
      return true;
    }
    AppMethodBeat.o(254409);
    return false;
  }
  
  public final void cE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(254477);
    if (paramBoolean)
    {
      this.aenh.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(254477);
      return;
    }
    this.aenh.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(254477);
  }
  
  public final void dRI()
  {
    AppMethodBeat.i(35003);
    this.aemX = false;
    notifyDataSetChanged();
    Log.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
    this.aemC = this.aemD;
    this.aemE = this.aemF;
    this.aemG = this.aemH;
    this.aemI = this.aemJ;
    this.aemK = this.aemL;
    AppMethodBeat.o(35003);
  }
  
  public final int dWF()
  {
    AppMethodBeat.i(34998);
    if (-1 == this.eQx)
    {
      bh.bCz();
      this.eQx = com.tencent.mm.model.c.bzD().aLW(this.adHw.getTalkerUserName());
    }
    int i = this.eQx;
    AppMethodBeat.o(34998);
    return i;
  }
  
  public final int gEF()
  {
    AppMethodBeat.i(35001);
    int i = this.aemU.size();
    AppMethodBeat.o(35001);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34990);
    int i = this.aemP.size();
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
    paramInt = ca.dL(aBV(paramInt));
    AppMethodBeat.o(34991);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34993);
    cc localcc = aBV(paramInt);
    boolean bool1;
    Object localObject;
    if (!this.aenh.isEmpty())
    {
      bool1 = true;
      localObject = new StringBuilder("[getView] position:").append(paramInt).append(" msgId:").append(localcc.field_msgId).append(" svrId:").append(localcc.field_msgSvrId).append(" type:").append(localcc.getType()).append(" send:").append(localcc.field_isSend).append(" talker:").append(localcc.field_talker).append(" msgSep:").append(localcc.field_msgSeq).append(" time:").append(localcc.getCreateTime()).append("convertView@:");
      if (paramView == null) {
        break label209;
      }
    }
    label209:
    for (paramViewGroup = Integer.valueOf(paramView.hashCode());; paramViewGroup = "null")
    {
      Log.i("MicroMsg.ChattingDataAdapter", paramViewGroup + "isInAnim:" + bool1);
      if ((!bool1) || (paramView == null)) {
        break label216;
      }
      AppMethodBeat.o(34993);
      return paramView;
      bool1 = false;
      break;
    }
    label216:
    if (paramInt == 0)
    {
      paramViewGroup = this.adHw;
      Log.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
      paramViewGroup.aezP.jpS();
    }
    long l;
    int i;
    int j;
    if ((paramInt != 0) && (this.aemR.get(paramInt) == 0))
    {
      l = aBV(paramInt - 1).getCreateTime();
      l = localcc.getCreateTime() - l;
      if ((l > 0L) && (l < 60000L))
      {
        i = 1;
        if ((l <= 0L) || (l / 180000L >= 1L)) {
          break label1349;
        }
        j = 1;
        label320:
        if ((i == 0) && (j == 0)) {
          break label1355;
        }
        this.aemR.put(paramInt, 2);
      }
    }
    else
    {
      label339:
      boolean bool2 = localcc.jcl();
      if (((this.aemR.get(paramInt) != 1) && (paramInt != 0) && (!this.aemQ.contains(Long.valueOf(localcc.field_msgId))) && (!bool2)) || (localcc.getCreateTime() <= 1000L)) {
        break label1367;
      }
      bool1 = true;
      label400:
      if (localcc.field_msgId != this.aemS) {
        break label1373;
      }
      i = 1;
      label416:
      if (Log.getLogLevel() <= 1) {
        Log.i("MicroMsg.ChattingDataAdapter", "getview isInviteNewUI:%s, showTime:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      }
      if (paramView != null) {
        break label1379;
      }
      localObject = ca.dK(localcc);
      paramView = ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(this.pUI, paramView);
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.setChattingItem((com.tencent.mm.ui.chatting.viewitems.c)localObject);
      label488:
      Log.d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", new Object[] { paramViewGroup.chattingItem });
      if (!bool1) {
        break label1390;
      }
      paramViewGroup.timeTV.setVisibility(0);
      l = localcc.getCreateTime();
      paramViewGroup.timeTV.setText(com.tencent.mm.pluginsdk.platformtools.f.d(this.adHw.aezO.getContext(), l, false));
      if (paramViewGroup.timeTV.getTextSize() > com.tencent.mm.cd.a.fromDPToPix(this.adHw.aezO.getContext(), 25)) {
        Log.e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", new Object[] { Float.valueOf(paramViewGroup.timeTV.getTextSize()) });
      }
      label604:
      if (paramViewGroup.historyMsgTip != null)
      {
        if (i == 0) {
          break label1402;
        }
        paramViewGroup.historyMsgTip.setVisibility(0);
      }
      label624:
      if (this.aemT == -1L)
      {
        localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLH(this.adHw.getTalkerUserName());
        if (localObject == null) {
          break label1414;
        }
        this.aemT = ((fi)localObject).field_msgId;
      }
      label677:
      if (paramViewGroup.noMoreMsgTip != null)
      {
        if ((!this.aemY) || (localcc.field_msgId != this.aemT)) {
          break label1422;
        }
        paramViewGroup.noMoreMsgTip.setVisibility(0);
      }
      label712:
      localObject = paramViewGroup.chattingItem;
      paramViewGroup.playingMsgId = null;
      com.tencent.mm.aw.f localf = com.tencent.mm.aw.a.bLn();
      if ((localf != null) && (localf.oOv != null) && (localf.oOt == 0) && (com.tencent.mm.aw.a.bLk())) {
        paramViewGroup.playingMsgId = localf.oOv;
      }
      ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(paramViewGroup, paramInt, this.adHw, localcc);
      localObject = ((d)this.adHw.cm(d.class)).jrx();
      if ((paramViewGroup.timeTV.getVisibility() == 0) && (localObject != null))
      {
        paramViewGroup.timeTV.setTextColor(((com.tencent.mm.pluginsdk.ui.f)localObject).XYa);
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).XYb) {
          break label1434;
        }
        paramViewGroup.timeTV.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.f)localObject).XYc);
        label851:
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).XYd) {
          break label1461;
        }
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).XYe) {
          break label1448;
        }
        paramViewGroup.timeTV.setBackgroundResource(R.g.chat_tips_light_bg);
        label877:
        paramViewGroup.timeTV.setPadding(this.aemO, this.aemN, this.aemO, this.aemN);
      }
      label900:
      if ((paramViewGroup.userTV != null) && (paramViewGroup.userTV.getVisibility() == 0) && (localObject != null) && (!this.adHw.getTalkerUserName().equals("qqmail")) && (localcc.getType() != 318767153))
      {
        if (!((com.tencent.mm.pluginsdk.ui.f)localObject).XYe) {
          break label1472;
        }
        paramViewGroup.userTV.setTextColor(-1);
        paramViewGroup.userTV.setShadowLayer(com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.userTV.getContext(), 2), 0.0F, com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.userTV.getContext(), 1), this.adHw.aezO.getMMResources().getColor(R.e.BW_0_Alpha_0_5));
      }
      label1013:
      if (paramViewGroup.maskView != null) {
        paramViewGroup.maskView.setTag(Long.valueOf(localcc.field_msgId));
      }
      if (((!this.aemX) || (!cA(localcc))) && (!this.aemZ)) {
        break label1498;
      }
      if (paramViewGroup.checkBox != null) {
        paramViewGroup.checkBox.setChecked(this.aemU.contains(Long.valueOf(localcc.field_msgId)));
      }
      if (paramViewGroup.maskView != null) {
        paramViewGroup.maskView.setOnClickListener(this.aemM);
      }
      paramViewGroup.showEditView(true);
      label1109:
      if ((!this.aemX) || (!this.PmU) || (this.aemU.contains(Long.valueOf(localcc.field_msgId)))) {
        break label1506;
      }
      paramView.setAlpha(0.5F);
    }
    for (;;)
    {
      paramViewGroup = this.aemW.entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        localObject = (Map.Entry)paramViewGroup.next();
        if ((((Map.Entry)localObject).getValue() != null) && ((View)((WeakReference)((Map.Entry)localObject).getValue()).get() == paramView))
        {
          this.aemW.remove(((Map.Entry)localObject).getKey());
          this.aemV.remove(((Map.Entry)localObject).getKey());
        }
      }
      this.aemW.put(Long.valueOf(localcc.field_msgId), new WeakReference(paramView));
      if (localcc.iYk()) {
        this.aemV.put(Long.valueOf(localcc.field_msgId), Integer.valueOf(localcc.field_isSend));
      }
      if ((paramView != null) && (((com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag()).chattingItem.jxg())) {
        paramView.addOnLayoutChangeListener(this.adAI);
      }
      AppMethodBeat.o(34993);
      return paramView;
      i = 0;
      break;
      label1349:
      j = 0;
      break label320;
      label1355:
      this.aemR.put(paramInt, 1);
      break label339;
      label1367:
      bool1 = false;
      break label400;
      label1373:
      i = 0;
      break label416;
      label1379:
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      break label488;
      label1390:
      paramViewGroup.timeTV.setVisibility(8);
      break label604;
      label1402:
      paramViewGroup.historyMsgTip.setVisibility(8);
      break label624;
      label1414:
      this.aemT = 0L;
      break label677;
      label1422:
      paramViewGroup.noMoreMsgTip.setVisibility(8);
      break label712;
      label1434:
      paramViewGroup.timeTV.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label851;
      label1448:
      paramViewGroup.timeTV.setBackgroundResource(R.g.chat_tips_bg);
      break label877;
      label1461:
      paramViewGroup.timeTV.setBackgroundColor(0);
      break label900;
      label1472:
      paramViewGroup.userTV.setTextColor(((com.tencent.mm.pluginsdk.ui.f)localObject).XYa);
      paramViewGroup.userTV.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label1013;
      label1498:
      paramViewGroup.showEditView(false);
      break label1109;
      label1506:
      paramView.setAlpha(1.0F);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(34992);
    int i = ca.jxD();
    AppMethodBeat.o(34992);
    return i;
  }
  
  public final void gt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35020);
    if (this.adHw == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    Object localObject1 = this.adHw.Uxa;
    if (localObject1 == null)
    {
      AppMethodBeat.o(35020);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    boolean bool = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbx();
    cc localcc;
    Object localObject2;
    if (((au)localObject1).iZC())
    {
      localObject1 = new ArrayList();
      while (paramInt1 <= paramInt2)
      {
        localcc = aBY(paramInt1);
        if ((localcc != null) && (localcc.getType() == 285212721))
        {
          Log.v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + localcc.field_msgId);
          ((List)localObject1).add(new String[] { String.valueOf(localcc.field_msgId), localcc.field_content, "-1" });
          localObject2 = new q();
          ((q)localObject2).msgId = localcc.field_msgId;
          ((q)localObject2).nUB = localcc.field_content;
          if (bool) {
            localLinkedList.add(localObject2);
          }
        }
        paramInt1 += 1;
      }
      if (((List)localObject1).size() > 0)
      {
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).t((List)localObject1, 0);
        if (bool) {
          ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).u(localLinkedList, 0);
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
      localcc = aBY(paramInt1);
      if ((localcc != null) && ((localcc.getType() & 0x31) != 0))
      {
        localObject2 = localcc.field_content;
        if (localObject2 != null)
        {
          localObject2 = k.b.aP((String)localObject2, localcc.field_reserved);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((k.b)localObject2).url)) && (((k.b)localObject2).url.contains(WeChatHosts.domainString(R.l.host_mp_weixin_qq_com))))
          {
            localObject3 = ca.dK(localcc);
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.ui.chatting.viewitems.c)localObject3).a(this.adHw, localcc);
              if (localObject3 != null)
              {
                str = ((az)localObject1).field_username;
                if (str != null)
                {
                  j = ac.aX((String)localObject3, this.adHw.getTalkerUserName());
                  localObject4 = (com.tencent.mm.message.e)((k.b)localObject2).aK(com.tencent.mm.message.e.class);
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
    for (int i = ((com.tencent.mm.message.e)localObject4).nQm;; i = -1)
    {
      localObject4 = new ArrayList();
      ((List)localObject4).add(((k.b)localObject2).url);
      ((List)localObject4).add(String.valueOf(i));
      ((List)localObject4).add(String.valueOf(localcc.field_msgSvrId));
      ((List)localObject4).add(str);
      ((List)localObject4).add(String.valueOf(j));
      ((List)localObject4).add(localObject3);
      ((List)localObject4).add(String.valueOf(localcc.getCreateTime()));
      ((List)localObject4).add(String.valueOf(((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiB(str)));
      localLinkedList.add(localObject4);
      paramInt1 += 1;
      break;
      if (localLinkedList.size() > 0) {
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).s(localLinkedList, 1);
      }
      AppMethodBeat.o(35020);
      return;
    }
  }
  
  public final View ht(long paramLong)
  {
    AppMethodBeat.i(254432);
    if (!this.aemW.containsKey(Long.valueOf(paramLong)))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(254432);
      return null;
    }
    Object localObject = (WeakReference)this.aemW.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(254432);
      return localObject;
    }
    AppMethodBeat.o(254432);
    return null;
  }
  
  public final void iIz()
  {
    AppMethodBeat.i(34997);
    com.tencent.mm.ui.chatting.d.a.juI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(254359);
        a.this.notifyDataSetChanged();
        AppMethodBeat.o(254359);
      }
    });
    AppMethodBeat.o(34997);
  }
  
  public final com.tencent.mm.modelimage.loader.a.c jqA()
  {
    AppMethodBeat.i(35019);
    if (this.lMm == null) {
      iLq();
    }
    com.tencent.mm.modelimage.loader.a.c localc = this.lMm;
    AppMethodBeat.o(35019);
    return localc;
  }
  
  public final SparseArray<cc> jqi()
  {
    return this.aemP;
  }
  
  public final Set<Long> jqk()
  {
    return this.aemU;
  }
  
  public final void jql()
  {
    AppMethodBeat.i(35002);
    if (this.aemU != null) {
      this.aemU.clear();
    }
    AppMethodBeat.o(35002);
  }
  
  public final void jqm()
  {
    AppMethodBeat.i(35004);
    this.aemX = true;
    notifyDataSetChanged();
    jqj();
    AppMethodBeat.o(35004);
  }
  
  public final void jqn()
  {
    this.aemY = true;
  }
  
  public final boolean jqo()
  {
    return this.aemX;
  }
  
  public final void jqp()
  {
    AppMethodBeat.i(35006);
    if (this.aend)
    {
      this.aene += 1;
      Log.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.aene);
      AppMethodBeat.o(35006);
      return;
    }
    if (!this.hhr)
    {
      Log.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
      AppMethodBeat.o(35006);
      return;
    }
    this.aenb.a(d.a.aeHS, false, null);
    AppMethodBeat.o(35006);
  }
  
  public final void jqq()
  {
    AppMethodBeat.i(35010);
    Log.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.aend), Integer.valueOf(this.aene) });
    if (this.aend)
    {
      AppMethodBeat.o(35010);
      return;
    }
    this.aend = true;
    this.aene = 0;
    AppMethodBeat.o(35010);
  }
  
  public final void jqr()
  {
    AppMethodBeat.i(35011);
    Log.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.aend), Integer.valueOf(this.aene) });
    if (!this.aend)
    {
      AppMethodBeat.o(35011);
      return;
    }
    this.aend = false;
    if (this.aene > 0) {
      this.aenb.a(d.a.aeHS, false, null);
    }
    this.aene = 0;
    AppMethodBeat.o(35011);
  }
  
  public final void jqs()
  {
    AppMethodBeat.i(35016);
    this.aemZ = true;
    jqj();
    AppMethodBeat.o(35016);
  }
  
  public final aa.a jqt()
  {
    return this.aenf;
  }
  
  public final v.f jqu()
  {
    return this.aemE;
  }
  
  public final v.g jqv()
  {
    return this.aemC;
  }
  
  public final ai jqw()
  {
    return this.aemI;
  }
  
  public final l jqx()
  {
    return this.aemG;
  }
  
  public final com.tencent.mm.ui.chatting.c jqy()
  {
    return this.aemK;
  }
  
  public final long jqz()
  {
    AppMethodBeat.i(35017);
    long l;
    if (this.aeng != -1L)
    {
      l = this.aeng;
      AppMethodBeat.o(35017);
      return l;
    }
    this.aeng = 0L;
    int i = getCount() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        cc localcc = aBV(i);
        if ((localcc.field_isSend == 1) && ((localcc.jUq & 0x4) != 4)) {
          this.aeng = localcc.field_msgId;
        }
      }
      else
      {
        l = this.aeng;
        AppMethodBeat.o(35017);
        return l;
      }
      i -= 1;
    }
  }
  
  public final void m(View.OnClickListener paramOnClickListener)
  {
    this.aemM = paramOnClickListener;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35005);
    super.notifyDataSetChanged();
    this.aemR.clear();
    if (this.aenc != null) {
      this.aenc.run();
    }
    this.aenh.clear();
    AppMethodBeat.o(35005);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(34996);
    this.hhr = false;
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(this.Mxs);
    p.b(this.vIA);
    Log.i("MicroMsg.ChattingDataAdapter", "adapter pause");
    this.aena.stopTimer();
    AppMethodBeat.o(34996);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(34995);
    this.hhr = true;
    Log.i("MicroMsg.ChattingDataAdapter", "adapter resume");
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(this.Mxs, Looper.getMainLooper());
    p.a(this.vIA);
    this.aena.startTimer(300000L);
    if (this.aenb != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("SCENE", 3);
      this.aenb.a(d.a.aeHS, false, localBundle);
    }
    AppMethodBeat.o(34995);
  }
  
  public final boolean zK(long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(35000);
    int i;
    label65:
    Object localObject;
    label128:
    label181:
    int k;
    if (this.aemU.contains(Long.valueOf(paramLong)))
    {
      Log.d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      this.aemU.remove(Long.valueOf(paramLong));
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
          ((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).checkBox.setChecked(this.aemU.contains(Long.valueOf(paramLong)));
        }
        AppMethodBeat.o(35000);
        return true;
      }
    }
    else
    {
      Log.d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      k = this.aemU.size();
      if (!this.aemY) {
        break label403;
      }
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpb, 99);
      Log.d("MicroMsg.recordSelect.SelectRecordConfig", "getSelectRecordMaxNum() num:%s", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      if (k >= i)
      {
        if (this.aemY) {}
        for (localObject = this.adHw.aezO.getMMResources().getString(R.l.gFs, new Object[] { Integer.valueOf(i) });; localObject = this.adHw.aezO.getMMResources().getString(R.l.gFr, new Object[] { Integer.valueOf(99) }))
        {
          k.c(this.adHw.aezO.getContext(), (String)localObject, "", true);
          AppMethodBeat.o(35000);
          return false;
        }
      }
      this.aemU.add(Long.valueOf(paramLong));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a
 * JD-Core Version:    0.7.0.1
 */