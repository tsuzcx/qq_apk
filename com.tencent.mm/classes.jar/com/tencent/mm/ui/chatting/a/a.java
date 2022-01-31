package com.tencent.mm.ui.chatting.a;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.b.b.b;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.chatting.t.f;
import com.tencent.mm.ui.chatting.viewitems.ab.a;
import com.tencent.mm.ui.chatting.viewitems.ab.b;
import com.tencent.mm.ui.chatting.viewitems.ax;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public final class a
  extends BaseAdapter
  implements com.tencent.mm.ui.chatting.b.b.g
{
  private ListView Nn;
  private boolean bwW;
  public com.tencent.mm.as.a.a.c drd = null;
  private int dsr = -1;
  private LayoutInflater fhz;
  private com.tencent.mm.ui.chatting.c.a uPh;
  private com.tencent.mm.pluginsdk.ui.d.g vhi;
  public t.f vnE;
  private t.f vnF;
  public t.e vnG;
  private t.e vnH;
  public l vnI;
  private l vnJ;
  public ab vnK;
  private ab vnL;
  public com.tencent.mm.ui.chatting.c vnM;
  private com.tencent.mm.ui.chatting.c vnN;
  private View.OnClickListener vnO = null;
  private final int vnP;
  private final int vnQ;
  public SparseArray<bi> vnR = new SparseArray();
  private HashSet<Long> vnS = new HashSet();
  public SparseIntArray vnT = new SparseIntArray();
  public long vnU = -1L;
  private TreeSet<Long> vnV = new TreeSet();
  private Map<Long, Integer> vnW = new HashMap();
  private Map<Long, View> vnX = new HashMap();
  private boolean vnY = false;
  private boolean vnZ = false;
  private final am voa = new am(new a.1(this), true);
  public com.tencent.mm.ui.chatting.k.a.a vob;
  private boolean voc = false;
  private int vod = 0;
  protected g.a voe = new a.3(this);
  private t.a vof = new a.4(this);
  private long vog = -1L;
  
  public a(com.tencent.mm.ui.chatting.c.a parama, ListView paramListView)
  {
    parama.a(com.tencent.mm.ui.chatting.b.b.g.class, this);
    this.Nn = paramListView;
    this.uPh = parama;
    this.fhz = com.tencent.mm.ui.y.gt(parama.vtz.getContext());
    this.vnP = parama.vtz.getMMResources().getDimensionPixelSize(R.f.SmallestPadding);
    this.vnQ = parama.vtz.getMMResources().getDimensionPixelSize(R.f.LittlePadding);
    paramListView = new t.f();
    this.vnF = paramListView;
    this.vnE = paramListView;
    paramListView = new t.e(parama);
    this.vnH = paramListView;
    this.vnG = paramListView;
    paramListView = new l(parama.vtz.getContext());
    this.vnJ = paramListView;
    this.vnI = paramListView;
    paramListView = new ab(parama);
    this.vnL = paramListView;
    this.vnK = paramListView;
    paramListView = new com.tencent.mm.ui.chatting.c(parama);
    this.vnN = paramListView;
    this.vnM = paramListView;
    this.vhi = new ai(parama);
    if (this.drd == null)
    {
      parama = new com.tencent.mm.as.a.a.c.a();
      parama.eri = com.tencent.mm.ai.a.e.ly(this.uPh.getTalkerUserName());
      parama.erf = true;
      parama.erC = true;
      parama.eru = R.k.default_avatar;
      this.drd = parama.OV();
    }
  }
  
  private void cDj()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingDataAdapter", "disable clickListener");
    this.vnE = null;
    this.vnG = null;
    this.vnI = null;
    this.vnK = null;
    this.vnM = null;
  }
  
  public final bi GW(int paramInt)
  {
    return (bi)this.vnR.get(paramInt);
  }
  
  public final void GX(int paramInt)
  {
    boolean bool = false;
    bi localbi = GW(paramInt);
    if (localbi == null) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingDataAdapter", "[setShowHistoryMsgTipId] pos:%s msg is null? %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    if ((localbi != null) && (localbi.field_msgId != 0L)) {
      this.vnU = localbi.field_msgId;
    }
    notifyDataSetChanged();
  }
  
  public final void GY(int paramInt)
  {
    bi localbi = GW(paramInt);
    if ((localbi != null) && (localbi.field_msgId != 0L)) {
      this.vnS.add(Long.valueOf(localbi.field_msgId));
    }
  }
  
  public final void a(int paramInt, d.a parama)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] position:%s mode:%s", new Object[] { Integer.valueOf(paramInt), parama });
    Bundle localBundle = new Bundle();
    localBundle.putInt("MSG_POSITION", paramInt);
    localBundle.putInt("SCENE", 2);
    this.vob.a(parama, false, localBundle);
  }
  
  public final void a(long paramLong, bi parambi, boolean paramBoolean)
  {
    if ((!this.vnX.containsKey(Long.valueOf(paramLong))) || (!this.vnW.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingDataAdapter", "msg not display, " + paramLong);
      return;
    }
    com.tencent.mm.ui.chatting.viewitems.c.a locala = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)this.vnX.get(Long.valueOf(paramLong))).getTag();
    ab.a.a(this.uPh.vtz.getContext(), locala, parambi, paramBoolean);
  }
  
  public final void a(long paramLong, boolean paramBoolean, d.a parama)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingDataAdapter", "[locationByMsgId] messageId:%s loadAllBottomMsg:%s mode:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), parama });
    Bundle localBundle = new Bundle();
    localBundle.putLong("MSG_ID", paramLong);
    localBundle.putInt("SCENE", 1);
    localBundle.putBoolean("IS_LOAD_ALL", paramBoolean);
    this.vob.a(parama, true, localBundle);
  }
  
  public final void aRs()
  {
    this.vnY = false;
    notifyDataSetChanged();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingDataAdapter", "enable ClickListener");
    this.vnE = this.vnF;
    this.vnG = this.vnH;
    this.vnI = this.vnJ;
    this.vnK = this.vnL;
    this.vnM = this.vnN;
  }
  
  public final int bug()
  {
    return this.vnV.size();
  }
  
  public final int cDk()
  {
    if (-1 == this.dsr)
    {
      au.Hx();
      this.dsr = com.tencent.mm.model.c.Fy().HP(this.uPh.getTalkerUserName());
    }
    return this.dsr;
  }
  
  public final Set<Long> cDl()
  {
    return this.vnV;
  }
  
  public final void cDm()
  {
    if (this.vnV != null) {
      this.vnV.clear();
    }
  }
  
  public final void cDn()
  {
    this.vnY = true;
    notifyDataSetChanged();
    cDj();
  }
  
  public final void cDo()
  {
    if (this.voc)
    {
      this.vod += 1;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] isLockNotify:" + this.vod);
      return;
    }
    if (!this.bwW)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingDataAdapter", "[handleMsgChange] is not resumeState ");
      return;
    }
    this.vob.a(d.a.vyd, false, null);
  }
  
  public final void cDp()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingDataAdapter", "[lockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.voc), Integer.valueOf(this.vod) });
    if (this.voc) {
      return;
    }
    this.voc = true;
    this.vod = 0;
  }
  
  public final void cDq()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingDataAdapter", "[unLockNotify] isLockNotify:%s notifyCountWhileLock:%s", new Object[] { Boolean.valueOf(this.voc), Integer.valueOf(this.vod) });
    if (!this.voc) {
      return;
    }
    this.voc = false;
    if (this.vod > 0) {
      this.vob.a(d.a.vyd, false, null);
    }
    this.vod = 0;
  }
  
  public final void cDr()
  {
    this.vnZ = true;
    cDj();
  }
  
  public final t.a cDs()
  {
    return this.vof;
  }
  
  public final t.e cDt()
  {
    return this.vnG;
  }
  
  public final t.f cDu()
  {
    return this.vnE;
  }
  
  public final ab cDv()
  {
    return this.vnK;
  }
  
  public final l cDw()
  {
    return this.vnI;
  }
  
  public final com.tencent.mm.ui.chatting.c cDx()
  {
    return this.vnM;
  }
  
  public final long cDy()
  {
    if (this.vog != -1L) {
      return this.vog;
    }
    this.vog = 0L;
    int i = getCount() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        bi localbi = GW(i);
        if ((localbi.field_isSend == 1) && ((localbi.czq & 0x4) != 4)) {
          this.vog = localbi.field_msgId;
        }
      }
      else
      {
        return this.vog;
      }
      i -= 1;
    }
  }
  
  public final com.tencent.mm.as.a.a.c cDz()
  {
    return this.drd;
  }
  
  public final void ckV()
  {
    com.tencent.mm.ui.chatting.c.a.cFG().post(new a.2(this));
  }
  
  public final void e(View.OnClickListener paramOnClickListener)
  {
    this.vnO = paramOnClickListener;
  }
  
  public final int getCount()
  {
    return this.vnR.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return ax.bD(GW(paramInt));
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bi localbi = GW(paramInt);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingDataAdapter", "[getView] position:" + paramInt + " msgId:" + localbi.field_msgId + " svrId:" + localbi.field_msgSvrId + " type:" + localbi.getType() + " send:" + localbi.field_isSend + " talker:" + localbi.field_talker + " msgSep:" + localbi.field_msgSeq + " time:" + localbi.field_createTime);
    if (paramInt == 0)
    {
      paramViewGroup = this.uPh;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingContext", "[scrollToLastProtect]");
      paramViewGroup.vtA.cDc();
    }
    int i;
    int j;
    label221:
    label240:
    Object localObject;
    if ((paramInt != 0) && (this.vnT.get(paramInt) == 0))
    {
      long l1 = GW(paramInt - 1).field_createTime;
      long l2 = localbi.field_createTime;
      if (l2 - l1 < 60000L)
      {
        i = 1;
        if ((l2 - l1) / 180000L >= 1L) {
          break label956;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label962;
        }
        this.vnT.put(paramInt, 2);
      }
    }
    else
    {
      if (((this.vnT.get(paramInt) != 1) && (paramInt != 0) && (!this.vnS.contains(Long.valueOf(localbi.field_msgId)))) || (localbi.field_createTime <= 1000L)) {
        break label974;
      }
      i = 1;
      label289:
      if (localbi.field_msgId != this.vnU) {
        break label980;
      }
      j = 1;
      label305:
      if (paramView != null) {
        break label986;
      }
      localObject = ax.bC(localbi);
      paramView = ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(this.fhz, paramView);
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      paramViewGroup.vBc = ((com.tencent.mm.ui.chatting.viewitems.c)localObject);
      label341:
      if (i == 0) {
        break label997;
      }
      paramViewGroup.dsz.setVisibility(0);
      paramViewGroup.dsz.setText(com.tencent.mm.pluginsdk.f.h.c(this.uPh.vtz.getContext(), localbi.field_createTime, false));
      if (paramViewGroup.dsz.getTextSize() > com.tencent.mm.cb.a.fromDPToPix(this.uPh.vtz.getContext(), 25)) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingDataAdapter", "WDF!!! TextSize:%s", new Object[] { Float.valueOf(paramViewGroup.dsz.getTextSize()) });
      }
      label433:
      if (paramViewGroup.vAZ != null)
      {
        if (j == 0) {
          break label1009;
        }
        paramViewGroup.vAZ.setVisibility(0);
      }
      label453:
      localObject = paramViewGroup.vBc;
      paramViewGroup.vBb = null;
      com.tencent.mm.av.e locale = com.tencent.mm.av.a.Pw();
      if ((locale != null) && (locale.eux != null) && (locale.euv == 0) && (com.tencent.mm.av.a.Pu())) {
        paramViewGroup.vBb = locale.eux;
      }
      ((com.tencent.mm.ui.chatting.viewitems.c)localObject).a(paramViewGroup, paramInt, this.uPh, localbi);
      localObject = ((b)this.uPh.ac(b.class)).cEc();
      if ((paramViewGroup.dsz.getVisibility() == 0) && (localObject != null))
      {
        paramViewGroup.dsz.setTextColor(((com.tencent.mm.pluginsdk.ui.e)localObject).rZj);
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).rZk) {
          break label1021;
        }
        paramViewGroup.dsz.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.e)localObject).rZl);
        label592:
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).rZm) {
          break label1048;
        }
        if (!((com.tencent.mm.pluginsdk.ui.e)localObject).rZn) {
          break label1035;
        }
        paramViewGroup.dsz.setBackgroundResource(R.g.chat_tips_light_bg);
        label618:
        paramViewGroup.dsz.setPadding(this.vnQ, this.vnP, this.vnQ, this.vnP);
      }
      label641:
      if ((paramViewGroup.nSa != null) && (paramViewGroup.nSa.getVisibility() == 0) && (localObject != null) && (!this.uPh.getTalkerUserName().equals("qqmail")) && (localbi.getType() != 318767153))
      {
        paramViewGroup.nSa.setTextColor(((com.tencent.mm.pluginsdk.ui.e)localObject).rZo);
        paramViewGroup.nSa.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      if (paramViewGroup.hoY != null) {
        paramViewGroup.hoY.setTag(Long.valueOf(localbi.field_msgId));
      }
      if (this.vnY)
      {
        if (!localbi.isSystem()) {
          break label1059;
        }
        paramInt = 0;
        label752:
        if (paramInt != 0) {}
      }
      else
      {
        if (!this.vnZ) {
          break label1064;
        }
      }
      if (paramViewGroup.khV != null) {
        paramViewGroup.khV.setChecked(this.vnV.contains(Long.valueOf(localbi.field_msgId)));
      }
      if (paramViewGroup.hoY != null) {
        paramViewGroup.hoY.setOnClickListener(this.vnO);
      }
      paramViewGroup.nt(true);
    }
    for (;;)
    {
      paramViewGroup = this.vnX.entrySet().iterator();
      while (paramViewGroup.hasNext())
      {
        localObject = (Map.Entry)paramViewGroup.next();
        if (((Map.Entry)localObject).getValue() == paramView)
        {
          this.vnX.remove(((Map.Entry)localObject).getKey());
          this.vnW.remove(((Map.Entry)localObject).getKey());
        }
      }
      this.vnX.put(Long.valueOf(localbi.field_msgId), paramView);
      if (localbi.ctB()) {
        this.vnW.put(Long.valueOf(localbi.field_msgId), Integer.valueOf(localbi.field_isSend));
      }
      return paramView;
      i = 0;
      break;
      label956:
      j = 0;
      break label221;
      label962:
      this.vnT.put(paramInt, 1);
      break label240;
      label974:
      i = 0;
      break label289;
      label980:
      j = 0;
      break label305;
      label986:
      paramViewGroup = (com.tencent.mm.ui.chatting.viewitems.c.a)paramView.getTag();
      break label341;
      label997:
      paramViewGroup.dsz.setVisibility(8);
      break label433;
      label1009:
      paramViewGroup.vAZ.setVisibility(8);
      break label453;
      label1021:
      paramViewGroup.dsz.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label592;
      label1035:
      paramViewGroup.dsz.setBackgroundResource(R.g.chat_tips_bg);
      break label618;
      label1048:
      paramViewGroup.dsz.setBackgroundColor(0);
      break label641;
      label1059:
      paramInt = 1;
      break label752;
      label1064:
      paramViewGroup.nt(false);
    }
  }
  
  public final int getViewTypeCount()
  {
    return ax.cHi();
  }
  
  public final boolean hQ(long paramLong)
  {
    int i;
    label55:
    Object localObject;
    if (this.vnV.contains(Long.valueOf(paramLong)))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingDataAdapter", "remove select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      this.vnV.remove(Long.valueOf(paramLong));
      if (this.Nn == null) {
        break label275;
      }
      i = 0;
      if (i >= this.Nn.getChildCount()) {
        break label275;
      }
      localObject = this.Nn.getChildAt(i);
      com.tencent.mm.ui.chatting.viewitems.c.a locala = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((locala == null) || (locala.hoY == null) || (((Long)locala.hoY.getTag()).longValue() != paramLong)) {
        break label268;
      }
      label118:
      if (localObject == null) {
        break label281;
      }
      localObject = (com.tencent.mm.ui.chatting.viewitems.c.a)((View)localObject).getTag();
      if ((((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).khV != null) && (((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).khV.getVisibility() == 0)) {
        ((com.tencent.mm.ui.chatting.viewitems.c.a)localObject).khV.setChecked(this.vnV.contains(Long.valueOf(paramLong)));
      }
    }
    for (;;)
    {
      return true;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingDataAdapter", "add select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      if (this.vnV.size() >= 100)
      {
        com.tencent.mm.ui.base.h.b(this.uPh.vtz.getContext(), this.uPh.vtz.getMMResources().getString(R.l.exceed_select_item_warning, new Object[] { Integer.valueOf(100) }), "", true);
        return false;
      }
      this.vnV.add(Long.valueOf(paramLong));
      break;
      label268:
      i += 1;
      break label55;
      label275:
      localObject = null;
      break label118;
      label281:
      notifyDataSetChanged();
    }
  }
  
  public final boolean isInEditMode()
  {
    return this.vnY;
  }
  
  public final void j(long paramLong, int paramInt1, int paramInt2)
  {
    if ((!this.vnX.containsKey(Long.valueOf(paramLong))) || (!this.vnW.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingDataAdapter", "msg not display, " + paramLong);
      return;
    }
    ab.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)this.vnX.get(Long.valueOf(paramLong))).getTag(), paramInt1, paramInt2);
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.vnT.clear();
  }
  
  public final void pause()
  {
    this.bwW = false;
    au.Hx();
    com.tencent.mm.model.c.Fy().a(this.voe);
    j.b(this.vhi);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingDataAdapter", "adapter pause");
    this.voa.stopTimer();
  }
  
  public final void resume()
  {
    this.bwW = true;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingDataAdapter", "adapter resume");
    au.Hx();
    com.tencent.mm.model.c.Fy().a(this.voe, Looper.getMainLooper());
    j.a(this.vhi);
    this.voa.S(300000L, 300000L);
    if (this.vob != null) {
      this.vob.a(d.a.vyd, false, null);
    }
  }
  
  public final void v(long paramLong, boolean paramBoolean)
  {
    if ((!this.vnX.containsKey(Long.valueOf(paramLong))) || (!this.vnW.containsKey(Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingDataAdapter", "msg not display, " + paramLong);
      return;
    }
    ab.b.a((com.tencent.mm.ui.chatting.viewitems.c.a)((View)this.vnX.get(Long.valueOf(paramLong))).getTag(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a
 * JD-Core Version:    0.7.0.1
 */