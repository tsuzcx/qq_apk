package com.tencent.mm.ui.chatting.i;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.f;
import com.tencent.mm.ui.chatting.e.b.b;
import com.tencent.mm.ui.chatting.k;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public abstract class b
  implements c.f, com.tencent.mm.ui.chatting.e.b.a
{
  protected String ejr;
  protected ArrayList<c.b> iVH = null;
  private LinearLayoutManager jvX;
  private boolean kFs = false;
  protected Context mContext;
  private long zKL = 0L;
  protected b.b zPc;
  com.tencent.mm.ui.chatting.a.c zPd;
  protected ArrayList<c.b> zPe = null;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.iVH = new ArrayList();
  }
  
  protected static String b(bi parambi, boolean paramBoolean)
  {
    String str1 = null;
    String str2 = null;
    if (parambi == null) {}
    do
    {
      return str2;
      if (parambi.field_isSend == 1) {
        return r.Zn();
      }
      if (paramBoolean) {
        str1 = bf.pu(parambi.field_content);
      }
      str2 = str1;
    } while (!bo.isNullOrNil(str1));
    return parambi.field_talker;
  }
  
  private void bI(bi parambi)
  {
    cm localcm = new cm();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambi);
    if (g.a(this.mContext, localcm, this.ejr, localArrayList, false))
    {
      c(localcm);
      return;
    }
    ab.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
  }
  
  private void bJ(bi parambi)
  {
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 19L, 1L, true);
    boolean bool = this.ejr.toLowerCase().endsWith("@chatroom");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambi);
    k.a(this.mContext, localArrayList, bool, this.ejr, new b.3(this));
  }
  
  private void bK(bi parambi)
  {
    com.tencent.mm.plugin.report.service.h.qsU.e(11627, new Object[] { Integer.valueOf(5) });
    TreeSet localTreeSet = new TreeSet();
    localTreeSet.add(Long.valueOf(parambi.field_msgId));
    com.tencent.mm.ui.base.h.d(this.mContext, this.mContext.getString(2131298494), "", this.mContext.getString(2131298950), this.mContext.getString(2131296888), new b.4(this, localTreeSet, parambi), null);
  }
  
  private void c(cm paramcm)
  {
    paramcm.cpR.cpY = 45;
    paramcm.cpR.activity = ((Activity)this.mContext);
    a.ymk.l(paramcm);
    if ((paramcm.cpS.ret == -2) || (paramcm.cpS.ret > 0)) {}
    while (paramcm.cpS.ret > 0) {
      return;
    }
    if (14 != paramcm.cpR.type)
    {
      ab.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
      return;
    }
    if (paramcm.cpR.cpU == null)
    {
      ab.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(11142, new Object[] { Integer.valueOf(paramcm.cpR.cpU.wVr), Integer.valueOf(paramcm.cpR.cpU.wVs), Integer.valueOf(paramcm.cpR.cpU.wVt), Integer.valueOf(paramcm.cpR.cpU.wVu), Integer.valueOf(paramcm.cpR.cpU.wVv), Integer.valueOf(paramcm.cpR.cpU.wVw), Integer.valueOf(paramcm.cpR.cpU.wVx), Integer.valueOf(paramcm.cpR.cpU.fileCount), Integer.valueOf(paramcm.cpR.cpU.wVy), Integer.valueOf(paramcm.cpR.cpU.wVz), Integer.valueOf(paramcm.cpR.cpU.wVA), Integer.valueOf(paramcm.cpR.cpU.wVB), Integer.valueOf(paramcm.cpR.cpU.wVC), Integer.valueOf(paramcm.cpR.cpU.wVD), Integer.valueOf(paramcm.cpR.cpU.wVE) });
  }
  
  public final c.b PD(int paramInt)
  {
    if ((this.iVH == null) || (this.iVH.size() <= paramInt)) {
      return null;
    }
    return (c.b)this.iVH.get(paramInt);
  }
  
  public final RecyclerView.a auc(String paramString)
  {
    this.ejr = paramString;
    this.zPd = new com.tencent.mm.ui.chatting.a.c(this.mContext, this);
    com.tencent.mm.ui.chatting.a.c.zDM = dJR();
    return this.zPd;
  }
  
  public final void d(int paramInt, bi parambi)
  {
    ab.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      bI(parambi);
      return;
    case 0: 
      bJ(parambi);
      return;
    }
    bK(parambi);
  }
  
  public final RecyclerView.h dJP()
  {
    return new b.1(this);
  }
  
  public final com.tencent.mm.modelvoiceaddr.ui.b.a dJS()
  {
    return new b.2(this);
  }
  
  protected final boolean dKb()
  {
    long l1 = this.zKL;
    long l2 = System.currentTimeMillis();
    this.zKL = l2;
    if (l1 + 30000L < l2)
    {
      aw.aaz();
      this.kFs = com.tencent.mm.model.c.isSDCardAvailable();
    }
    return this.kFs;
  }
  
  public final int getCount()
  {
    if (this.iVH == null) {
      return 0;
    }
    return this.iVH.size();
  }
  
  public final void onDetach()
  {
    this.zPc.a(null);
    this.zPc = null;
    if (this.zPd != null)
    {
      com.tencent.mm.ui.chatting.a.c.zDM = null;
      com.tencent.mm.ui.chatting.a.c.zDN = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.b
 * JD-Core Version:    0.7.0.1
 */