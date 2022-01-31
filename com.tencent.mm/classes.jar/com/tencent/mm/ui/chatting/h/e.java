package com.tencent.mm.ui.chatting.h;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.d;
import com.tencent.mm.as.d.a;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.a.b;
import com.tencent.mm.ui.chatting.gallery.h.a;
import com.tencent.mm.ui.chatting.gallery.h.b;
import com.tencent.mm.ui.chatting.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class e
  implements d.a, t.a, a.a, h.b
{
  static int count = 0;
  private String drJ;
  private ArrayList<b.c> hka = null;
  private GridLayoutManager kif;
  boolean kig = false;
  private int kih = 0;
  private Context mContext;
  private ah mHandler = new ah(Looper.getMainLooper());
  private long voj;
  private com.tencent.mm.sdk.b.c vqD = new e.9(this);
  private int vyN = 0;
  private a.b vyR;
  b vyS;
  private int vyT = 0;
  private boolean vyU = false;
  
  public e(Context paramContext)
  {
    this.mContext = paramContext;
    this.hka = new ArrayList();
  }
  
  private static String c(bi parambi, com.tencent.mm.modelvideo.s params)
  {
    Object localObject;
    if (params.eHO == -1)
    {
      params = params.SC();
      localObject = params;
      if (!com.tencent.mm.vfs.e.bK(params))
      {
        com.tencent.mm.modelvideo.o.Sr();
        localObject = t.nS(parambi.field_imgPath);
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          return localObject;
          com.tencent.mm.modelvideo.o.Sr();
          str = t.nS(parambi.field_imgPath);
          localObject = str;
        } while (parambi.field_isSend != 1);
        localObject = str;
      } while (params.eHR == null);
      localObject = str;
    } while (!params.eHR.tra);
    for (;;)
    {
      try
      {
        params = com.tencent.mm.vfs.e.aeS(str);
        parambi = params;
        if (!params.endsWith("/")) {
          parambi = params + "/";
        }
        params = com.tencent.mm.vfs.e.aeV(str);
        parambi = parambi + params + "_hd.mp4";
        boolean bool = com.tencent.mm.vfs.e.bK(parambi);
        y.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", new Object[] { parambi, Boolean.valueOf(bool) });
        if (bool) {
          return parambi;
        }
      }
      catch (Exception parambi)
      {
        y.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", new Object[] { parambi.getMessage() });
        return str;
      }
      parambi = str;
    }
  }
  
  private void c(cj paramcj)
  {
    paramcj.bIw.bID = 45;
    paramcj.bIw.activity = ((Activity)this.mContext);
    com.tencent.mm.sdk.b.a.udP.m(paramcj);
    if ((paramcj.bIx.ret == -2) || (paramcj.bIx.ret > 0)) {}
    while (paramcj.bIx.ret > 0) {
      return;
    }
    if (14 != paramcj.bIw.type)
    {
      y.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
      return;
    }
    if (paramcj.bIw.bIz == null)
    {
      y.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(11142, new Object[] { Integer.valueOf(paramcj.bIw.bIz.sXr), Integer.valueOf(paramcj.bIw.bIz.sXs), Integer.valueOf(paramcj.bIw.bIz.sXt), Integer.valueOf(paramcj.bIw.bIz.sXu), Integer.valueOf(paramcj.bIw.bIz.sXv), Integer.valueOf(paramcj.bIw.bIz.sXw), Integer.valueOf(paramcj.bIw.bIz.sXx), Integer.valueOf(paramcj.bIw.bIz.sXy), Integer.valueOf(paramcj.bIw.bIz.sXz), Integer.valueOf(paramcj.bIw.bIz.sXA), Integer.valueOf(paramcj.bIw.bIz.sXB), Integer.valueOf(paramcj.bIw.bIz.sXC), Integer.valueOf(paramcj.bIw.bIz.sXD), Integer.valueOf(paramcj.bIw.bIz.sXE), Integer.valueOf(paramcj.bIw.bIz.sXF) });
  }
  
  private boolean cGP()
  {
    return this.vyT == 0;
  }
  
  private void ec(List<bi> paramList)
  {
    com.tencent.mm.sdk.f.e.post(new e.2(this, paramList), "handleSave");
  }
  
  private void ed(List<bi> paramList)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!ae.aF((bi)((Iterator)localObject).next()))
      {
        com.tencent.mm.ui.base.s.makeText(this.mContext, R.l.favorite_fail_open_im_withdown_download, 0).show();
        return;
      }
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 18L, 1L, true);
    cj localcj = new cj();
    if (com.tencent.mm.pluginsdk.model.g.a(this.mContext, localcj, this.drJ, paramList, false, false))
    {
      c(localcj);
      ef(paramList);
    }
    for (;;)
    {
      this.vyR.aRP();
      return;
      if (paramList.size() > 1)
      {
        Context localContext = this.mContext;
        if (localcj.bIw.bIC >= 0)
        {
          localObject = this.mContext.getString(R.l.favorite_fail_recordtype_error);
          label146:
          if (localcj.bIw.bIC < 0) {
            break label218;
          }
        }
        label218:
        for (String str = this.mContext.getString(R.l.confirm_dialog_ok);; str = this.mContext.getString(R.l.plugin_favorite_opt))
        {
          com.tencent.mm.ui.base.h.a(localContext, (String)localObject, "", str, this.mContext.getString(R.l.confirm_dialog_cancel), new e.4(this, localcj, paramList), null);
          break;
          localObject = this.mContext.getString(R.l.favorite_fail_record_expired_bigfile);
          break label146;
        }
      }
      com.tencent.mm.ui.base.h.h(this.mContext, localcj.bIw.bIC, 0);
    }
  }
  
  private void ee(List<bi> paramList)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(11627, new Object[] { Integer.valueOf(5) });
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localTreeSet.add(Long.valueOf(((bi)localIterator.next()).field_msgId));
    }
    com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.confirm_delete), "", this.mContext.getString(R.l.delete_message), this.mContext.getString(R.l.app_cancel), new e.5(this, localTreeSet, paramList), null);
  }
  
  private static void ef(List<bi> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.vgo, a.d.vgt, localbi, 0);
    }
  }
  
  public final String VE()
  {
    return this.mContext.getString(R.l.all_pictures_video);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm)
  {
    y.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    y.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", new Object[] { Integer.valueOf(this.vyT), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString });
    if (!this.vyR.cFL()) {}
    do
    {
      return;
      this.vyT -= 1;
      au.Hx();
      paramObject = com.tencent.mm.model.c.Fy().fd(paramLong2);
      if (!com.tencent.mm.ui.chatting.gallery.c.b(this.mContext, paramObject, false)) {
        this.vyU = true;
      }
    } while (!cGP());
    if (!this.vyU)
    {
      this.mHandler.post(new e.11(this));
      return;
    }
    this.mHandler.post(new e.12(this));
  }
  
  public final void a(t.a.a parama)
  {
    if (!this.vyR.cFL()) {}
    for (;;)
    {
      return;
      com.tencent.mm.modelvideo.s locals = u.oe(parama.fileName);
      y.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", new Object[] { Integer.valueOf(this.vyT), parama.eHY, parama.fileName });
      if (locals != null) {
        if (locals.SG())
        {
          this.vyT -= 1;
          au.Hx();
          parama = com.tencent.mm.model.c.Fy().fd(locals.eHI);
          com.tencent.mm.ui.chatting.gallery.c.a(this.mContext, parama, false);
        }
      }
      while (cGP())
      {
        if (!this.vyU) {
          break label162;
        }
        this.mHandler.post(new e.13(this));
        return;
        y.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
        cFI();
        this.vyR.Hh(0);
      }
    }
    label162:
    this.mHandler.post(new e.14(this));
  }
  
  public final RecyclerView.a aA(String paramString, long paramLong)
  {
    this.drJ = paramString;
    this.voj = paramLong;
    if (paramLong == -1L) {}
    for (this.vyS = new b(this.mContext, this.hka, paramString);; this.vyS = new b(this.mContext, this.hka, paramString, paramLong))
    {
      this.vyS.vok = new e.10(this);
      return this.vyS;
    }
  }
  
  public final void aRO()
  {
    this.vyS.khJ = true;
    h.a.cGc().khC = true;
    GridLayoutManager localGridLayoutManager = (GridLayoutManager)aRV();
    int i = localGridLayoutManager.gY();
    int j = localGridLayoutManager.ha();
    this.vyS.c(i, j - i + 1, Integer.valueOf(0));
  }
  
  public final void aRP()
  {
    this.vyS.khJ = false;
    h.a.cGc().clear();
    h.a.cGc().khC = false;
    this.vyS.agL.notifyChanged();
  }
  
  public final <T extends RecyclerView.i> T aRV()
  {
    if (this.kif == null)
    {
      this.kif = new GridLayoutManager(4);
      this.kif.adw = new e.1(this);
    }
    return this.kif;
  }
  
  public final boolean aRY()
  {
    return h.a.cGc().khC;
  }
  
  public final int cFH()
  {
    return h.a.cGc().khB.size();
  }
  
  public final void cFI()
  {
    com.tencent.mm.as.o.OK().a(this);
    com.tencent.mm.modelvideo.o.Sr().a(this);
    this.vyR.cFI();
  }
  
  public final void cFZ()
  {
    this.kig = true;
  }
  
  public final void clear() {}
  
  public final RecyclerView.h df(Context paramContext)
  {
    return new e.8(this, paramContext);
  }
  
  public final void l(boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) && (this.kih + this.vyN == this.hka.size()))
    {
      y.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", new Object[] { Integer.valueOf(this.kih), Integer.valueOf(paramInt) });
      return;
    }
    this.vyS.khH = true;
    this.vyR.ga(paramBoolean);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new e.7(this, paramBoolean, paramInt));
  }
  
  public final void onDetach()
  {
    this.vqD.dead();
    this.vyR.a(null);
    this.vyR = null;
    com.tencent.mm.as.o.OK().a(this);
    com.tencent.mm.modelvideo.o.Sr().a(this);
    h.a.cGc().detach();
  }
  
  public final void onResume()
  {
    if ((this.kig) && (h.a.cGc().khC))
    {
      this.vyR.re(h.a.cGc().khB.size());
      this.vyS.agL.notifyChanged();
    }
  }
  
  public final void rg(int paramInt)
  {
    y.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList1 = h.a.cGc().khB;
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      this.vyR.cFJ();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        bi localbi = (bi)localIterator.next();
        if ((!com.tencent.mm.ui.chatting.gallery.c.bg(localbi)) && (!com.tencent.mm.ui.chatting.gallery.c.bh(localbi))) {
          localArrayList2.add(localbi);
        }
      }
      if (localArrayList2.size() != localArrayList1.size())
      {
        com.tencent.mm.ui.base.h.a(this.mContext, R.l.gallery_save_sight_tips, R.l.app_tip, new e.15(this, localArrayList2), null);
        return;
      }
      ec(localArrayList2);
      return;
    case 1: 
      ed(localArrayList1);
      return;
    case 0: 
      com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 19L, 1L, true);
      boolean bool = com.tencent.mm.model.s.fn(this.drJ);
      l.a(this.mContext, localArrayList1, bool, this.drJ, new e.6(this));
      this.vyR.aRP();
      return;
    }
    ee(localArrayList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e
 * JD-Core Version:    0.7.0.1
 */