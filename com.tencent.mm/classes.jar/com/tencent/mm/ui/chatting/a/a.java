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
import com.tencent.mm.af.j.b;
import com.tencent.mm.ba.r;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.s.f;
import com.tencent.mm.ui.chatting.s.g;
import com.tencent.mm.ui.chatting.viewitems.ae.a;
import com.tencent.mm.ui.chatting.viewitems.ae.b;
import com.tencent.mm.ui.chatting.viewitems.ba;
import com.tencent.mm.ui.w;
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
  implements com.tencent.mm.ui.chatting.c.b.h
{
  private boolean bYJ;
  public com.tencent.mm.at.a.a.c eiK;
  private int ejZ;
  private LayoutInflater exe;
  private ListView mListView;
  protected h.a zDA;
  private t.a zDB;
  private long zDC;
  public s.g zDa;
  private s.g zDb;
  public s.f zDc;
  private s.f zDd;
  public l zDe;
  private l zDf;
  public y zDg;
  private y zDh;
  public com.tencent.mm.ui.chatting.c zDi;
  private com.tencent.mm.ui.chatting.c zDj;
  private View.OnClickListener zDk;
  private final int zDl;
  private final int zDm;
  public SparseArray<bi> zDn;
  private HashSet<Long> zDo;
  public SparseIntArray zDp;
  public long zDq;
  private TreeSet<Long> zDr;
  private Map<Long, Integer> zDs;
  private Map<Long, WeakReference<View>> zDt;
  private boolean zDu;
  private boolean zDv;
  private final ap zDw;
  public com.tencent.mm.ui.chatting.l.a.a zDx;
  private boolean zDy;
  private int zDz;
  private com.tencent.mm.ui.chatting.d.a zcV;
  private com.tencent.mm.pluginsdk.ui.d.g zwd;
  
  public a(com.tencent.mm.ui.chatting.d.a parama, ListView paramListView)
  {
    AppMethodBeat.i(31100);
    this.zDk = null;
    this.zDn = new SparseArray();
    this.zDo = new HashSet();
    this.zDp = new SparseIntArray();
    this.zDq = -1L;
    this.zDr = new TreeSet();
    this.zDs = new HashMap();
    this.zDt = new HashMap();
    this.zDu = false;
    this.zDv = false;
    this.zDw = new ap(new a.1(this), true);
    this.ejZ = -1;
    this.zDy = false;
    this.zDz = 0;
    this.zDA = new a.3(this);
    this.zDB = new a.4(this);
    this.zDC = -1L;
    this.eiK = null;
    parama.a(com.tencent.mm.ui.chatting.c.b.h.class, this);
    this.mListView = paramListView;
    this.zcV = parama;
    this.exe = w.hM(parama.zJz.getContext());
    this.zDl = parama.zJz.getMMResources().getDimensionPixelSize(2131427861);
    this.zDm = parama.zJz.getMMResources().getDimensionPixelSize(2131427782);
    paramListView = new s.g();
    this.zDb = paramListView;
    this.zDa = paramListView;
    paramListView = new s.f(parama);
    this.zDd = paramListView;
    this.zDc = paramListView;
    paramListView = new l(parama.zJz.getContext());
    this.zDf = paramListView;
    this.zDe = paramListView;
    paramListView = new y(parama);
    this.zDh = paramListView;
    this.zDg = paramListView;
    paramListView = new com.tencent.mm.ui.chatting.c(parama);
    this.zDj = paramListView;
    this.zDi = paramListView;
    this.zwd = new af(parama);
    dnC();
    AppMethodBeat.o(31100);
  }
  
  private void dGY()
  {
    AppMethodBeat.i(31105);
    ab.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
    this.zDa = null;
    this.zDc = null;
    this.zDe = null;
    this.zDg = null;
    this.zDi = null;
    AppMethodBeat.o(31105);
  }
  
  private void dnC()
  {
    AppMethodBeat.i(153835);
    if (this.eiK == null)
    {
      com.tencent.mm.at.a.a.c.a locala = new com.tencent.mm.at.a.a.c.a();
      locala.eNP = com.tencent.mm.aj.a.e.su(this.zcV.getTalkerUserName());
      locala.eNM = true;
      locala.eOe = true;
      locala.eNY = 2131231207;
      try
      {
        this.eiK = locala.ahY();
        AppMethodBeat.o(153835);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        ab.printErrStackTrace("MicroMsg.ChattingDataAdapter", localNullPointerException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(153835);
  }
  
  public final void C(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(31124);
    if ((!this.zDt.containsKey(Long.valueOf(paramLong))) || (!this.zDs.containsKey(Long.valueOf(paramLong))))
    {
      ab.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(31124);
      return;
    }
    Object localObject = (WeakReference)this.zDt.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ae.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramBoolean);
      }
      AppMethodBeat.o(31124);
      return;
    }
  }
  
  public final void PA(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(31118);
    bi localbi = Pz(paramInt);
    if (localbi == null) {
      bool = true;
    }
    ab.i("MicroMsg.ChattingDataAdapter", "[setShowHistoryMsgTipId] pos:%s msg is null? %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if ((localbi != null) && (localbi.field_msgId != 0L)) {
      this.zDq = localbi.field_msgId;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(31118);
  }
  
  public final void PB(int paramInt)
  {
    AppMethodBeat.i(31126);
    bi localbi = Pz(paramInt);
    if ((localbi != null) && (localbi.field_msgId != 0L)) {
      this.zDo.add(Long.valueOf(localbi.field_msgId));
    }
    AppMethodBeat.o(31126);
  }
  
  public final bi Pz(int paramInt)
  {
    AppMethodBeat.i(31110);
    bi localbi = (bi)this.zDn.get(paramInt);
    AppMethodBeat.o(31110);
    return localbi;
  }
  
  public final void a(int paramInt, d.a parama)
  {
    AppMethodBeat.i(31120);
    ab.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", new Object[] { Integer.valueOf(paramInt), parama });
    Bundle localBundle = new Bundle();
    localBundle.putInt("MSG_POSITION", paramInt);
    localBundle.putInt("SCENE", 2);
    this.zDx.a(parama, false, localBundle);
    AppMethodBeat.o(31120);
  }
  
  public final void a(long paramLong, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(31125);
    if ((!this.zDt.containsKey(Long.valueOf(paramLong))) || (!this.zDs.containsKey(Long.valueOf(paramLong))))
    {
      ab.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(31125);
      return;
    }
    Object localObject = (WeakReference)this.zDt.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
        ae.a.a(this.zcV.zJz.getContext(), (com.tencent.mm.ui.chatting.viewitems.c.a)localObject, parambi, paramBoolean);
      }
      AppMethodBeat.o(31125);
      return;
    }
  }
  
  public final void a(long paramLong, boolean paramBoolean, d.a parama)
  {
    AppMethodBeat.i(31119);
    ab.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), parama });
    Bundle localBundle = new Bundle();
    localBundle.putLong("MSG_ID", paramLong);
    localBundle.putInt("SCENE", 1);
    localBundle.putBoolean("IS_LOAD_ALL", paramBoolean);
    this.zDx.a(parama, true, localBundle);
    AppMethodBeat.o(31119);
  }
  
  public final void bxH()
  {
    AppMethodBeat.i(31114);
    this.zDu = false;
    notifyDataSetChanged();
    ab.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
    this.zDa = this.zDb;
    this.zDc = this.zDd;
    this.zDe = this.zDf;
    this.zDg = this.zDh;
    this.zDi = this.zDj;
    AppMethodBeat.o(31114);
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    this.zDk = paramOnClickListener;
  }
  
  public final int ces()
  {
    AppMethodBeat.i(31112);
    int i = this.zDr.size();
    AppMethodBeat.o(31112);
    return i;
  }
  
  public final Set<Long> dGZ()
  {
    return this.zDr;
  }
  
  public final void dHa()
  {
    AppMethodBeat.i(31113);
    if (this.zDr != null) {
      this.zDr.clear();
    }
    AppMethodBeat.o(31113);
  }
  
  public final void dHb()
  {
    AppMethodBeat.i(31115);
    this.zDu = true;
    notifyDataSetChanged();
    dGY();
    AppMethodBeat.o(31115);
  }
  
  public final void dHc()
  {
    AppMethodBeat.i(31117);
    if (this.zDy)
    {
      this.zDz += 1;
      ab.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.zDz);
      AppMethodBeat.o(31117);
      return;
    }
    if (!this.bYJ)
    {
      ab.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
      AppMethodBeat.o(31117);
      return;
    }
    this.zDx.a(d.a.zOy, false, null);
    AppMethodBeat.o(31117);
  }
  
  public final void dHd()
  {
    AppMethodBeat.i(31121);
    ab.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.zDy), Integer.valueOf(this.zDz) });
    if (this.zDy)
    {
      AppMethodBeat.o(31121);
      return;
    }
    this.zDy = true;
    this.zDz = 0;
    AppMethodBeat.o(31121);
  }
  
  public final void dHe()
  {
    AppMethodBeat.i(31122);
    ab.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.zDy), Integer.valueOf(this.zDz) });
    if (!this.zDy)
    {
      AppMethodBeat.o(31122);
      return;
    }
    this.zDy = false;
    if (this.zDz > 0) {
      this.zDx.a(d.a.zOy, false, null);
    }
    this.zDz = 0;
    AppMethodBeat.o(31122);
  }
  
  public final void dHf()
  {
    AppMethodBeat.i(31127);
    this.zDv = true;
    dGY();
    AppMethodBeat.o(31127);
  }
  
  public final t.a dHg()
  {
    return this.zDB;
  }
  
  public final s.f dHh()
  {
    return this.zDc;
  }
  
  public final s.g dHi()
  {
    return this.zDa;
  }
  
  public final y dHj()
  {
    return this.zDg;
  }
  
  public final l dHk()
  {
    return this.zDe;
  }
  
  public final com.tencent.mm.ui.chatting.c dHl()
  {
    return this.zDi;
  }
  
  public final long dHm()
  {
    AppMethodBeat.i(31128);
    long l;
    if (this.zDC != -1L)
    {
      l = this.zDC;
      AppMethodBeat.o(31128);
      return l;
    }
    this.zDC = 0L;
    int i = getCount() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        bi localbi = Pz(i);
        if ((localbi.field_isSend == 1) && ((localbi.dnr & 0x4) != 4)) {
          this.zDC = localbi.field_msgId;
        }
      }
      else
      {
        l = this.zDC;
        AppMethodBeat.o(31128);
        return l;
      }
      i -= 1;
    }
  }
  
  public final com.tencent.mm.at.a.a.c dHn()
  {
    AppMethodBeat.i(153836);
    if (this.eiK == null) {
      dnC();
    }
    com.tencent.mm.at.a.a.c localc = this.eiK;
    AppMethodBeat.o(153836);
    return localc;
  }
  
  public final void dI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31129);
    if (this.zcV == null)
    {
      AppMethodBeat.o(31129);
      return;
    }
    Object localObject1 = this.zcV.txj;
    if (localObject1 == null)
    {
      AppMethodBeat.o(31129);
      return;
    }
    if (((com.tencent.mm.storage.ad)localObject1).dwz())
    {
      localObject1 = new ArrayList();
      while (paramInt1 <= paramInt2)
      {
        localObject2 = (bi)this.zDn.get(paramInt1);
        if ((localObject2 != null) && (((bi)localObject2).getType() == 285212721))
        {
          ab.v("MicroMsg.ChattingDataAdapter", "terry checkpreload:" + ((dd)localObject2).field_msgId);
          ((List)localObject1).add(new String[] { String.valueOf(((dd)localObject2).field_msgId), ((dd)localObject2).field_content, "-1" });
        }
        paramInt1 += 1;
      }
      if (((List)localObject1).size() > 0) {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).j((List)localObject1, 0);
      }
      AppMethodBeat.o(31129);
      return;
    }
    Object localObject2 = new LinkedList();
    bi localbi;
    Object localObject3;
    Object localObject4;
    String str;
    int j;
    Object localObject5;
    if (paramInt1 <= paramInt2)
    {
      localbi = (bi)this.zDn.get(paramInt1);
      if ((localbi != null) && ((localbi.getType() & 0x31) != 0))
      {
        localObject3 = localbi.field_content;
        if (localObject3 != null)
        {
          localObject3 = j.b.ab((String)localObject3, localbi.field_reserved);
          if ((localObject3 != null) && (!TextUtils.isEmpty(((j.b)localObject3).url)) && (((j.b)localObject3).url.contains("mp.weixin.qq.com")))
          {
            localObject4 = ba.bN(localbi);
            if (localObject4 != null)
            {
              localObject4 = ((com.tencent.mm.ui.chatting.viewitems.c)localObject4).b(this.zcV, localbi);
              if (localObject4 != null)
              {
                str = ((aq)localObject1).field_username;
                if (str != null)
                {
                  j = u.ah((String)localObject4, this.zcV.getTalkerUserName());
                  localObject5 = (com.tencent.mm.af.e)((j.b)localObject3).R(com.tencent.mm.af.e.class);
                  if (localObject5 == null) {
                    break label550;
                  }
                }
              }
            }
          }
        }
      }
    }
    label550:
    for (int i = ((com.tencent.mm.af.e)localObject5).fgh;; i = -1)
    {
      localObject5 = new ArrayList();
      ((List)localObject5).add(((j.b)localObject3).url);
      ((List)localObject5).add(String.valueOf(i));
      ((List)localObject5).add(String.valueOf(localbi.field_msgSvrId));
      ((List)localObject5).add(str);
      ((List)localObject5).add(String.valueOf(j));
      ((List)localObject5).add(localObject4);
      ((List)localObject5).add(String.valueOf(localbi.field_createTime));
      ((List)localObject5).add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).GK(str)));
      ((List)localObject2).add(localObject5);
      paramInt1 += 1;
      break;
      if (((List)localObject2).size() > 0) {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).i((List)localObject2, 1);
      }
      AppMethodBeat.o(31129);
      return;
    }
  }
  
  public final void dlE()
  {
    AppMethodBeat.i(31108);
    com.tencent.mm.ui.chatting.d.a.dJI().post(new a.2(this));
    AppMethodBeat.o(31108);
  }
  
  public final int dwi()
  {
    AppMethodBeat.i(31109);
    if (-1 == this.ejZ)
    {
      aw.aaz();
      this.ejZ = com.tencent.mm.model.c.YC().TA(this.zcV.getTalkerUserName());
    }
    int i = this.ejZ;
    AppMethodBeat.o(31109);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(31101);
    int i = this.zDn.size();
    AppMethodBeat.o(31101);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(31102);
    paramInt = ba.bO(Pz(paramInt));
    AppMethodBeat.o(31102);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31104);
    bi localbi = Pz(paramInt);
    ab.i("MicroMsg.ChattingDataAdapter", "[getView] position:" + paramInt + " msgId:" + localbi.field_msgId + " svrId:" + localbi.field_msgSvrId + " type:" + localbi.getType() + " send:" + localbi.field_isSend + " talker:" + localbi.field_talker + " msgSep:" + localbi.field_msgSeq + " time:" + localbi.field_createTime);
    if (paramInt == 0)
    {
      paramViewGroup = this.zcV;
      ab.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
      paramViewGroup.zJA.dGO();
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
    if ((paramInt != 0) && (this.zDp.get(paramInt) == 0))
    {
      long l1 = Pz(paramInt - 1).field_createTime;
      long l2 = localbi.field_createTime;
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
        this.zDp.put(paramInt, 2);
      }
    }
    else
    {
      if (((this.zDp.get(paramInt) != 1) && (paramInt != 0) && (!this.zDo.contains(Long.valueOf(localbi.field_msgId)))) || (localbi.field_createTime <= 1000L)) {
        break label1133;
      }
      i = 1;
      if (localbi.field_msgId != this.zDq) {
        break label1139;
      }
      j = 1;
      paramViewGroup = r.aiQ().tS(this.zcV.getTalkerUserName());
      bool = true;
      if (paramViewGroup != null) {
        break label1145;
      }
      aw.aaz();
      k = ((Integer)com.tencent.mm.model.c.Ru().get(12311, Integer.valueOf(-2))).intValue();
      if (k != -2) {
        bool = false;
      }
      if (paramView != null) {
        break label1154;
      }
      localObject = ba.bN(localbi);
      paramView = ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(this.exe, paramView);
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.zRE = ((com.tencent.mm.ui.chatting.viewitems.c)localObject);
      paramViewGroup.setChattingBG(bool);
      label409:
      ab.d("MicroMsg.ChattingDataAdapter", "dealItemView() ChattingItem:%s", new Object[] { paramViewGroup.zRE });
      if (i == 0) {
        break label1171;
      }
      paramViewGroup.ekh.setVisibility(0);
      paramViewGroup.ekh.setText(com.tencent.mm.pluginsdk.f.h.c(this.zcV.zJz.getContext(), localbi.field_createTime, false));
      if (paramViewGroup.ekh.getTextSize() > com.tencent.mm.cb.a.fromDPToPix(this.zcV.zJz.getContext(), 25)) {
        ab.e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", new Object[] { Float.valueOf(paramViewGroup.ekh.getTextSize()) });
      }
      label519:
      if (paramViewGroup.zRB != null)
      {
        if (j == 0) {
          break label1183;
        }
        paramViewGroup.zRB.setVisibility(0);
      }
      label539:
      localObject = paramViewGroup.zRE;
      paramViewGroup.zRD = null;
      com.tencent.mm.aw.e locale = com.tencent.mm.aw.a.aiz();
      if ((locale != null) && (locale.fKj != null) && (locale.fKh == 0) && (com.tencent.mm.aw.a.aiw())) {
        paramViewGroup.zRD = locale.fKj;
      }
      ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(paramViewGroup, paramInt, this.zcV, localbi);
      localObject = ((com.tencent.mm.ui.chatting.c.b.c)this.zcV.ay(com.tencent.mm.ui.chatting.c.b.c.class)).dHS();
      if ((paramViewGroup.ekh.getVisibility() == 0) && (localObject != null))
      {
        paramViewGroup.ekh.setTextColor(((com.tencent.mm.pluginsdk.ui.e)localObject).vQa);
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).vQb) {
          break label1195;
        }
        paramViewGroup.ekh.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.e)localObject).vQc);
        label678:
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).vQd) {
          break label1222;
        }
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).vQe) {
          break label1209;
        }
        paramViewGroup.ekh.setBackgroundResource(2130838246);
        label704:
        paramViewGroup.ekh.setPadding(this.zDm, this.zDl, this.zDm, this.zDl);
      }
      label727:
      if ((paramViewGroup.qFY != null) && (paramViewGroup.qFY.getVisibility() == 0) && (localObject != null) && (!this.zcV.getTalkerUserName().equals("qqmail")) && (localbi.getType() != 318767153))
      {
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).vQe) {
          break label1233;
        }
        paramViewGroup.qFY.setTextColor(-1);
        paramViewGroup.qFY.setShadowLayer(com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.qFY.getContext(), 2), 0.0F, com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.qFY.getContext(), 1), this.zcV.zJz.getMMResources().getColor(2131689485));
      }
      label840:
      if (paramViewGroup.jbK != null) {
        paramViewGroup.jbK.setTag(Long.valueOf(localbi.field_msgId));
      }
      if (this.zDu)
      {
        if (!localbi.isSystem()) {
          break label1259;
        }
        paramInt = 0;
        label879:
        if (paramInt != 0) {}
      }
      else
      {
        if (!this.zDv) {
          break label1264;
        }
      }
      if (paramViewGroup.mCC != null) {
        paramViewGroup.mCC.setChecked(this.zDr.contains(Long.valueOf(localbi.field_msgId)));
      }
      if (paramViewGroup.jbK != null) {
        paramViewGroup.jbK.setOnClickListener(this.zDk);
      }
      paramViewGroup.rc(true);
    }
    for (;;)
    {
      paramViewGroup = this.zDt.entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        localObject = (Map.Entry)paramViewGroup.next();
        if ((((Map.Entry)localObject).getValue() != null) && ((View)((WeakReference)((Map.Entry)localObject).getValue()).get() == paramView))
        {
          this.zDt.remove(((Map.Entry)localObject).getKey());
          this.zDs.remove(((Map.Entry)localObject).getKey());
        }
      }
      this.zDt.put(Long.valueOf(localbi.field_msgId), new WeakReference(paramView));
      if (localbi.dvX()) {
        this.zDs.put(Long.valueOf(localbi.field_msgId), Integer.valueOf(localbi.field_isSend));
      }
      AppMethodBeat.o(31104);
      return paramView;
      i = 0;
      break;
      label1115:
      j = 0;
      break label226;
      label1121:
      this.zDp.put(paramInt, 1);
      break label245;
      label1133:
      i = 0;
      break label294;
      label1139:
      j = 0;
      break label310;
      label1145:
      k = paramViewGroup.fMk;
      break label357;
      label1154:
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.setChattingBG(bool);
      break label409;
      label1171:
      paramViewGroup.ekh.setVisibility(8);
      break label519;
      label1183:
      paramViewGroup.zRB.setVisibility(8);
      break label539;
      label1195:
      paramViewGroup.ekh.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label678;
      label1209:
      paramViewGroup.ekh.setBackgroundResource(2130838245);
      break label704;
      label1222:
      paramViewGroup.ekh.setBackgroundColor(0);
      break label727;
      label1233:
      paramViewGroup.qFY.setTextColor(((com.tencent.mm.pluginsdk.ui.e)localObject).vQa);
      paramViewGroup.qFY.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label840;
      label1259:
      paramInt = 1;
      break label879;
      label1264:
      paramViewGroup.rc(false);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(31103);
    int i = ba.dLy();
    AppMethodBeat.o(31103);
    return i;
  }
  
  public final boolean isInEditMode()
  {
    return this.zDu;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(31116);
    super.notifyDataSetChanged();
    this.zDp.clear();
    AppMethodBeat.o(31116);
  }
  
  public final void o(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31123);
    if ((!this.zDt.containsKey(Long.valueOf(paramLong))) || (!this.zDs.containsKey(Long.valueOf(paramLong))))
    {
      ab.d("MicroMsg.ChattingDataAdapter", "msg not display, ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(31123);
      return;
    }
    Object localObject = (WeakReference)this.zDt.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ae.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag(), paramInt1, paramInt2);
      }
      AppMethodBeat.o(31123);
      return;
    }
  }
  
  public final boolean oC(long paramLong)
  {
    AppMethodBeat.i(31111);
    int i;
    label60:
    Object localObject;
    if (this.zDr.contains(Long.valueOf(paramLong)))
    {
      ab.d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      this.zDr.remove(Long.valueOf(paramLong));
      if (this.mListView == null) {
        break label291;
      }
      i = 0;
      if (i >= this.mListView.getChildCount()) {
        break label291;
      }
      localObject = this.mListView.getChildAt(i);
      com.tencent.mm.ui.chatting.viewitems.c.a locala = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((locala == null) || (locala.jbK == null) || (((Long)locala.jbK.getTag()).longValue() != paramLong)) {
        break label284;
      }
      label123:
      if (localObject == null) {
        break label297;
      }
      localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).mCC != null) && (((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).mCC.getVisibility() == 0)) {
        ((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).mCC.setChecked(this.zDr.contains(Long.valueOf(paramLong)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31111);
      return true;
      ab.d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      if (this.zDr.size() >= 100)
      {
        com.tencent.mm.ui.base.h.b(this.zcV.zJz.getContext(), this.zcV.zJz.getMMResources().getString(2131299334, new Object[] { Integer.valueOf(100) }), "", true);
        AppMethodBeat.o(31111);
        return false;
      }
      this.zDr.add(Long.valueOf(paramLong));
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
  
  public final void pause()
  {
    AppMethodBeat.i(31107);
    this.bYJ = false;
    aw.aaz();
    com.tencent.mm.model.c.YC().a(this.zDA);
    j.b(this.zwd);
    ab.i("MicroMsg.ChattingDataAdapter", "adapter pause");
    this.zDw.stopTimer();
    AppMethodBeat.o(31107);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(31106);
    this.bYJ = true;
    ab.i("MicroMsg.ChattingDataAdapter", "adapter resume");
    aw.aaz();
    com.tencent.mm.model.c.YC().a(this.zDA, Looper.getMainLooper());
    j.a(this.zwd);
    this.zDw.ag(300000L, 300000L);
    if (this.zDx != null) {
      this.zDx.a(d.a.zOy, false, null);
    }
    AppMethodBeat.o(31106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a
 * JD-Core Version:    0.7.0.1
 */