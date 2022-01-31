package com.tencent.mm.ui.chatting.i;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.d.a;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.e.a.a;
import com.tencent.mm.ui.chatting.e.a.b;
import com.tencent.mm.ui.chatting.gallery.h.a;
import com.tencent.mm.ui.chatting.gallery.h.b;
import com.tencent.mm.ui.chatting.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class e
  implements d.a, t.a, a.a, h.b
{
  static int count = 0;
  private String ejr;
  private ArrayList<b.c> iVH;
  private com.tencent.mm.sdk.b.c kFH;
  private GridLayoutManager kFI;
  boolean mCM;
  private int mCN;
  private Context mContext;
  private ak mHandler;
  private long zDF;
  private int zPk;
  private a.b zPo;
  b zPp;
  private int zPq;
  private boolean zPr;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(32576);
    this.iVH = null;
    this.kFH = new e.9(this);
    this.mCM = false;
    this.zPq = 0;
    this.mHandler = new ak(Looper.getMainLooper());
    this.zPr = false;
    this.zPk = 0;
    this.mCN = 0;
    this.mContext = paramContext;
    this.iVH = new ArrayList();
    AppMethodBeat.o(32576);
  }
  
  private static String c(bi parambi, s params)
  {
    AppMethodBeat.i(32593);
    Object localObject;
    if (params.fXE == -1)
    {
      params = params.alO();
      localObject = params;
      if (!com.tencent.mm.vfs.e.cN(params))
      {
        com.tencent.mm.modelvideo.o.alE();
        localObject = com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath);
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(32593);
          return localObject;
          com.tencent.mm.modelvideo.o.alE();
          str = com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath);
          localObject = str;
        } while (parambi.field_isSend != 1);
        localObject = str;
      } while (params.fXH == null);
      localObject = str;
    } while (!params.fXH.xra);
    for (;;)
    {
      try
      {
        params = com.tencent.mm.vfs.e.avK(str);
        parambi = params;
        if (!params.endsWith("/")) {
          parambi = params + "/";
        }
        params = com.tencent.mm.vfs.e.avM(str);
        parambi = parambi + params + "_hd.mp4";
        boolean bool = com.tencent.mm.vfs.e.cN(parambi);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", new Object[] { parambi, Boolean.valueOf(bool) });
        if (!bool) {
          break label228;
        }
        localObject = parambi;
      }
      catch (Exception parambi)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", new Object[] { parambi.getMessage() });
        localObject = str;
      }
      break;
      label228:
      parambi = str;
    }
  }
  
  private void c(cm paramcm)
  {
    AppMethodBeat.i(32597);
    paramcm.cpR.cpY = 45;
    paramcm.cpR.activity = ((Activity)this.mContext);
    com.tencent.mm.sdk.b.a.ymk.l(paramcm);
    if ((paramcm.cpS.ret == -2) || (paramcm.cpS.ret > 0))
    {
      AppMethodBeat.o(32597);
      return;
    }
    if (paramcm.cpS.ret <= 0)
    {
      if (14 != paramcm.cpR.type)
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
        AppMethodBeat.o(32597);
        return;
      }
      if (paramcm.cpR.cpU == null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
        AppMethodBeat.o(32597);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11142, new Object[] { Integer.valueOf(paramcm.cpR.cpU.wVr), Integer.valueOf(paramcm.cpR.cpU.wVs), Integer.valueOf(paramcm.cpR.cpU.wVt), Integer.valueOf(paramcm.cpR.cpU.wVu), Integer.valueOf(paramcm.cpR.cpU.wVv), Integer.valueOf(paramcm.cpR.cpU.wVw), Integer.valueOf(paramcm.cpR.cpU.wVx), Integer.valueOf(paramcm.cpR.cpU.fileCount), Integer.valueOf(paramcm.cpR.cpU.wVy), Integer.valueOf(paramcm.cpR.cpU.wVz), Integer.valueOf(paramcm.cpR.cpU.wVA), Integer.valueOf(paramcm.cpR.cpU.wVB), Integer.valueOf(paramcm.cpR.cpU.wVC), Integer.valueOf(paramcm.cpR.cpU.wVD), Integer.valueOf(paramcm.cpR.cpU.wVE) });
    }
    AppMethodBeat.o(32597);
  }
  
  private boolean dLb()
  {
    return this.zPq == 0;
  }
  
  private void fm(List<bi> paramList)
  {
    AppMethodBeat.i(32592);
    com.tencent.mm.sdk.g.d.post(new e.2(this, paramList), "handleSave");
    AppMethodBeat.o(32592);
  }
  
  private void fn(List<bi> paramList)
  {
    AppMethodBeat.i(32594);
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!com.tencent.mm.ui.chatting.ab.aP((bi)((Iterator)localObject).next()))
      {
        com.tencent.mm.ui.base.t.makeText(this.mContext, 2131299722, 0).show();
        AppMethodBeat.o(32594);
        return;
      }
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 18L, 1L, true);
    cm localcm = new cm();
    if (com.tencent.mm.pluginsdk.model.g.a(this.mContext, localcm, this.ejr, paramList, false))
    {
      c(localcm);
      fp(paramList);
    }
    for (;;)
    {
      this.zPo.byi();
      AppMethodBeat.o(32594);
      return;
      if (paramList.size() > 1)
      {
        Context localContext = this.mContext;
        if (localcm.cpR.cpX >= 0)
        {
          localObject = this.mContext.getString(2131299727);
          label163:
          if (localcm.cpR.cpX < 0) {
            break label235;
          }
        }
        label235:
        for (String str = this.mContext.getString(2131298501);; str = this.mContext.getString(2131302102))
        {
          com.tencent.mm.ui.base.h.d(localContext, (String)localObject, "", str, this.mContext.getString(2131298499), new e.4(this, localcm, paramList), null);
          break;
          localObject = this.mContext.getString(2131299726);
          break label163;
        }
      }
      com.tencent.mm.ui.base.h.h(this.mContext, localcm.cpR.cpX, 0);
    }
  }
  
  private void fo(List<bi> paramList)
  {
    AppMethodBeat.i(32595);
    com.tencent.mm.plugin.report.service.h.qsU.e(11627, new Object[] { Integer.valueOf(5) });
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localTreeSet.add(Long.valueOf(((bi)localIterator.next()).field_msgId));
    }
    com.tencent.mm.ui.base.h.d(this.mContext, this.mContext.getString(2131298494), "", this.mContext.getString(2131298950), this.mContext.getString(2131296888), new e.5(this, localTreeSet, paramList), null);
    AppMethodBeat.o(32595);
  }
  
  private static void fp(List<bi> paramList)
  {
    AppMethodBeat.i(32596);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.zvl, a.d.zvq, localbi, 0);
    }
    AppMethodBeat.o(32596);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm)
  {
    AppMethodBeat.i(32588);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(32588);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    AppMethodBeat.i(32589);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Integer.valueOf(this.zPq), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
    if (!this.zPo.dJO())
    {
      AppMethodBeat.o(32589);
      return;
    }
    this.zPq -= 1;
    aw.aaz();
    paramObject = com.tencent.mm.model.c.YC().kB(paramLong2);
    if (!com.tencent.mm.ui.chatting.gallery.c.b(this.mContext, paramObject, false)) {
      this.zPr = true;
    }
    if (dLb())
    {
      if (!this.zPr)
      {
        this.mHandler.post(new e.11(this));
        AppMethodBeat.o(32589);
        return;
      }
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(32572);
          if (e.c(e.this) != null) {
            e.c(e.this).PO(2131300315);
          }
          AppMethodBeat.o(32572);
        }
      });
    }
    AppMethodBeat.o(32589);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(32591);
    if ((this.zPo == null) || (!this.zPo.dJO()))
    {
      AppMethodBeat.o(32591);
      return;
    }
    s locals = u.vr(parama.fileName);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", new Object[] { Integer.valueOf(this.zPq), parama.fXO, parama.fileName });
    if (locals != null) {
      if (locals.alS())
      {
        this.zPq -= 1;
        aw.aaz();
        parama = com.tencent.mm.model.c.YC().kB(locals.fXy);
        com.tencent.mm.ui.chatting.gallery.c.a(this.mContext, parama, false);
      }
    }
    while (dLb()) {
      if (this.zPr)
      {
        this.mHandler.post(new e.13(this));
        AppMethodBeat.o(32591);
        return;
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
        dJL();
        this.zPo.PO(0);
      }
      else
      {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32574);
            if (e.c(e.this) != null) {
              e.c(e.this).dJN();
            }
            AppMethodBeat.o(32574);
          }
        });
      }
    }
    AppMethodBeat.o(32591);
  }
  
  public final String apc()
  {
    AppMethodBeat.i(32581);
    String str = this.mContext.getString(2131296525);
    AppMethodBeat.o(32581);
    return str;
  }
  
  public final <T extends RecyclerView.i> T bgA()
  {
    AppMethodBeat.i(32578);
    if (this.kFI == null)
    {
      this.kFI = new GridLayoutManager(4);
      this.kFI.afL = new e.1(this);
    }
    GridLayoutManager localGridLayoutManager = this.kFI;
    AppMethodBeat.o(32578);
    return localGridLayoutManager;
  }
  
  public final RecyclerView.a bi(String paramString, long paramLong)
  {
    AppMethodBeat.i(32580);
    this.ejr = paramString;
    this.zDF = paramLong;
    if (paramLong == -1L) {}
    for (this.zPp = new b(this.mContext, this.iVH, paramString);; this.zPp = new b(this.mContext, this.iVH, paramString, paramLong))
    {
      this.zPp.zDG = new e.10(this);
      paramString = this.zPp;
      AppMethodBeat.o(32580);
      return paramString;
    }
  }
  
  public final void byh()
  {
    AppMethodBeat.i(32584);
    this.zPp.mCr = true;
    h.a.dKg().mCm = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)bgA();
    int i = localGridLayoutManager.it();
    int j = localGridLayoutManager.iv();
    this.zPp.e(i, j - i + 1, Integer.valueOf(0));
    AppMethodBeat.o(32584);
  }
  
  public final void byi()
  {
    AppMethodBeat.i(32585);
    this.zPp.mCr = false;
    h.a.dKg().clear();
    h.a.dKg().mCm = false;
    this.zPp.ajb.notifyChanged();
    AppMethodBeat.o(32585);
  }
  
  public final boolean byp()
  {
    AppMethodBeat.i(32586);
    boolean bool = h.a.dKg().mCm;
    AppMethodBeat.o(32586);
    return bool;
  }
  
  public final void clear() {}
  
  public final int dJK()
  {
    AppMethodBeat.i(32583);
    int i = h.a.dKg().mCl.size();
    AppMethodBeat.o(32583);
    return i;
  }
  
  public final void dJL()
  {
    AppMethodBeat.i(32590);
    com.tencent.mm.at.o.ahD().a(this);
    com.tencent.mm.modelvideo.o.alE().a(this);
    this.zPo.dJL();
    AppMethodBeat.o(32590);
  }
  
  public final void dKd()
  {
    this.mCM = true;
  }
  
  public final RecyclerView.h dR(Context paramContext)
  {
    AppMethodBeat.i(32579);
    paramContext = new e.8(this, paramContext);
    AppMethodBeat.o(32579);
    return paramContext;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(32577);
    this.kFH.dead();
    this.zPo.a(null);
    this.zPo = null;
    com.tencent.mm.at.o.ahD().a(this);
    com.tencent.mm.modelvideo.o.alE().a(this);
    h.a.dKg().detach();
    k.dGm();
    AppMethodBeat.o(32577);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(32587);
    if ((this.mCM) && (h.a.dKg().mCm))
    {
      this.zPo.wa(h.a.dKg().mCl.size());
      this.zPp.ajb.notifyChanged();
    }
    AppMethodBeat.o(32587);
  }
  
  public final void v(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(32598);
    if ((!paramBoolean) && (this.mCN + this.zPk == this.iVH.size()))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", new Object[] { Integer.valueOf(this.mCN), Integer.valueOf(paramInt) });
      AppMethodBeat.o(32598);
      return;
    }
    this.zPp.kFv = true;
    this.zPo.gf(paramBoolean);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new e.7(this, paramBoolean, paramInt));
    AppMethodBeat.o(32598);
  }
  
  public final void wc(int paramInt)
  {
    AppMethodBeat.i(32582);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList1 = h.a.dKg().mCl;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(32582);
      return;
      this.zPo.dJM();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        bi localbi = (bi)localIterator.next();
        if ((!com.tencent.mm.ui.chatting.gallery.c.bq(localbi)) && (!com.tencent.mm.ui.chatting.gallery.c.br(localbi))) {
          localArrayList2.add(localbi);
        }
      }
      if (localArrayList2.size() != localArrayList1.size())
      {
        com.tencent.mm.ui.base.h.a(this.mContext, 2131300304, 2131297087, new e.15(this, localArrayList2), null);
        AppMethodBeat.o(32582);
        return;
      }
      fm(localArrayList2);
      AppMethodBeat.o(32582);
      return;
      fn(localArrayList1);
      AppMethodBeat.o(32582);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 19L, 1L, true);
      boolean bool = com.tencent.mm.model.t.lA(this.ejr);
      k.a(this.mContext, localArrayList1, bool, this.ejr, new e.6(this));
      this.zPo.byi();
      AppMethodBeat.o(32582);
      return;
      fo(localArrayList1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.e
 * JD-Core Version:    0.7.0.1
 */