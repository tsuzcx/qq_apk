package com.tencent.mm.ui.chatting.c;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.ao.f;
import com.tencent.mm.aw.d;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.gallery.g.a;
import java.util.HashSet;
import java.util.LinkedList;

@com.tencent.mm.ui.chatting.c.a.a(eYT=s.class)
public class v
  extends a
  implements d.a, u.a, s
{
  private av Gvg;
  private com.tencent.mm.ui.chatting.gallery.g Gvh;
  private com.tencent.mm.sdk.b.c nMH;
  
  public v()
  {
    AppMethodBeat.i(35353);
    this.nMH = new com.tencent.mm.sdk.b.c() {};
    this.Gvg = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(35350);
        if (v.this.cOd == null)
        {
          AppMethodBeat.o(35350);
          return false;
        }
        boolean bool2 = com.tencent.mm.plugin.priority.a.a.a.a.daY();
        int i = v.this.cOd.getFirstVisiblePosition();
        int m = v.this.cOd.getHeaderViewsCount();
        int j = v.this.cOd.getLastVisiblePosition();
        int k = v.this.cOd.getHeaderViewsCount();
        i locali = (i)v.this.cOd.be(i.class);
        i = Math.max(i - m, 0);
        j = Math.max(Math.min(j - k, locali.getCount()), 0);
        ad.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + i + " last: " + j);
        if (j < i)
        {
          ad.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
          v.a(v.this).av(1000L, 1000L);
          AppMethodBeat.o(35350);
          return false;
        }
        o.ayG().hgc = true;
        if (i <= j)
        {
          bl localbl = locali.YE(i);
          e locale;
          boolean bool1;
          if ((localbl != null) && (localbl.field_isSend == 0) && (localbl.eJO()))
          {
            locale = o.ayF().mr(localbl.field_msgSvrId);
            if ((!locale.ayh()) && (localbl.ePd != 2)) {
              if (localbl.ePd != 1)
              {
                if (!bool2) {
                  break label323;
                }
                com.tencent.mm.modelcontrol.c.awQ();
                if (localbl != null) {
                  break label330;
                }
                ad.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
                bool1 = false;
              }
            }
          }
          for (;;)
          {
            if (bool1) {
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(localbl, new v.a(v.this, localbl, locale, i));
            }
            label323:
            i += 1;
            break;
            label330:
            if (!localbl.eJO())
            {
              ad.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
              bool1 = false;
            }
            else if (!com.tencent.mm.modelcontrol.c.H(localbl))
            {
              ad.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
              bool1 = false;
            }
            else
            {
              bool1 = com.tencent.mm.modelcontrol.c.awR();
            }
          }
        }
        o.ayG().ayf();
        AppMethodBeat.o(35350);
        return false;
      }
    }, false);
    this.Gvh = g.a.GBX;
    AppMethodBeat.o(35353);
  }
  
  private void exO()
  {
    AppMethodBeat.i(35356);
    stopTimer();
    com.tencent.mm.sdk.b.a.ESL.d(this.nMH);
    com.tencent.mm.ui.chatting.gallery.g localg = this.Gvh;
    localg.rJN.clear();
    localg.cAE();
    AppMethodBeat.o(35356);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(35355);
    if (com.tencent.mm.model.az.afw()) {
      o.ayG().a(this);
    }
    this.Gvg.stopTimer();
    AppMethodBeat.o(35355);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(35358);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).d(paramLong2, false, true);
    AppMethodBeat.o(35358);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(35357);
    if (!com.tencent.mm.plugin.priority.a.a.a.a.daY()) {
      o.ayG().a(this);
    }
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).d(paramLong2, bool, false);
      ((com.tencent.mm.plugin.priority.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.priority.a.a.class)).getC2CImgAutoDownloader().c(paramLong1, paramLong2, bool);
      com.tencent.mm.model.az.arV();
      paramObject = com.tencent.mm.model.c.apO().rm(paramLong2);
      ((i)this.cOd.be(i.class)).a(paramLong2, paramObject, bool);
      AppMethodBeat.o(35357);
      return;
    }
  }
  
  public final void eQB() {}
  
  public final void eQC()
  {
    AppMethodBeat.i(35362);
    com.tencent.mm.sdk.b.a.ESL.c(this.nMH);
    AppMethodBeat.o(35362);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35363);
    nv localnv = new nv();
    localnv.dsT.dsU = true;
    localnv.dsT.talker = this.cOd.zgX.field_username;
    com.tencent.mm.sdk.b.a.ESL.a(localnv, Looper.getMainLooper());
    u.b(this);
    AppMethodBeat.o(35363);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35364);
    nv localnv = new nv();
    localnv.dsT.dsU = false;
    localnv.dsT.talker = this.cOd.zgX.field_username;
    com.tencent.mm.sdk.b.a.ESL.a(localnv, Looper.getMainLooper());
    u.c(this);
    stopTimer();
    AppMethodBeat.o(35364);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35365);
    exO();
    AppMethodBeat.o(35365);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35361);
    super.eWx();
    exO();
    AppMethodBeat.o(35361);
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(35359);
    if ((bt.isNullOrNil(paramString)) || (paramBitmap == null) || (this.cOd == null))
    {
      AppMethodBeat.o(35359);
      return;
    }
    com.tencent.mm.ui.chatting.d.a.eZd().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35351);
        if (v.this.cOd != null) {
          v.this.cOd.bCM();
        }
        AppMethodBeat.o(35351);
      }
    });
    AppMethodBeat.o(35359);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(35360);
    super.onScrollStateChanged(paramAbsListView, paramInt);
    o.ayJ().cq(paramInt);
    if (paramInt == 0)
    {
      startTimer();
      AppMethodBeat.o(35360);
      return;
    }
    if (paramInt == 2) {
      stopTimer();
    }
    AppMethodBeat.o(35360);
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(35354);
    this.Gvg.stopTimer();
    this.Gvg.av(1000L, 1000L);
    AppMethodBeat.o(35354);
  }
  
  final class a
    implements Runnable
  {
    private bl drF;
    private int i;
    private e uQk;
    
    a(bl parambl, e parame, int paramInt)
    {
      this.drF = parambl;
      this.uQk = parame;
      this.i = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(35352);
      f.awL().haO.add("image_" + this.drF.field_msgId);
      o.ayG().a(this.uQk.deI, this.drF.field_msgId, 0, Integer.valueOf(this.i), 2131231564, v.this, -1, true);
      AppMethodBeat.o(35352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.v
 * JD-Core Version:    0.7.0.1
 */