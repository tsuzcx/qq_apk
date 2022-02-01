package com.tencent.mm.ui.chatting.d;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.g.a;
import java.util.HashSet;
import java.util.LinkedList;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.u.class)
public class x
  extends a
  implements e.a, u.a, com.tencent.mm.ui.chatting.d.b.u
{
  private com.tencent.mm.sdk.platformtools.aw Ker;
  private com.tencent.mm.ui.chatting.gallery.g Kes;
  private com.tencent.mm.sdk.b.c oZE;
  
  public x()
  {
    AppMethodBeat.i(35353);
    this.oZE = new com.tencent.mm.sdk.b.c() {};
    this.Ker = new com.tencent.mm.sdk.platformtools.aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(35350);
        if (x.this.cXJ == null)
        {
          AppMethodBeat.o(35350);
          return false;
        }
        boolean bool2 = com.tencent.mm.plugin.priority.a.a.a.a.dCz();
        int i = x.this.cXJ.getFirstVisiblePosition();
        int m = x.this.cXJ.getHeaderViewsCount();
        int j = x.this.cXJ.getLastVisiblePosition();
        int k = x.this.cXJ.getHeaderViewsCount();
        k localk = (k)x.this.cXJ.bh(k.class);
        i = Math.max(i - m, 0);
        j = Math.max(Math.min(j - k, localk.getCount()), 0);
        ae.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + i + " last: " + j);
        if (j < i)
        {
          ae.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
          x.a(x.this).ay(1000L, 1000L);
          AppMethodBeat.o(35350);
          return false;
        }
        q.aIY().ich = true;
        if (i <= j)
        {
          bv localbv = localk.adI(i);
          com.tencent.mm.av.g localg;
          boolean bool1;
          if ((localbv != null) && (localbv.field_isSend == 0) && (localbv.ftg()))
          {
            localg = q.aIX().F(localbv.field_talker, localbv.field_msgSvrId);
            if ((!localg.aIA()) && (localbv.fmx != 2)) {
              if (localbv.fmx != 1)
              {
                if (!bool2) {
                  break label328;
                }
                com.tencent.mm.modelcontrol.c.aHe();
                if (localbv != null) {
                  break label335;
                }
                ae.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
                bool1 = false;
              }
            }
          }
          for (;;)
          {
            if (bool1) {
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(localbv, new x.a(x.this, localbv, localg, i));
            }
            label328:
            i += 1;
            break;
            label335:
            if (!localbv.ftg())
            {
              ae.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
              bool1 = false;
            }
            else if (!com.tencent.mm.modelcontrol.c.K(localbv))
            {
              ae.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
              bool1 = false;
            }
            else
            {
              bool1 = com.tencent.mm.modelcontrol.c.aHf();
            }
          }
        }
        q.aIY().aIu();
        AppMethodBeat.o(35350);
        return false;
      }
    }, false);
    this.Kes = g.a.Kmu;
    AppMethodBeat.o(35353);
  }
  
  private void ffV()
  {
    AppMethodBeat.i(35356);
    stopTimer();
    com.tencent.mm.sdk.b.a.IvT.d(this.oZE);
    com.tencent.mm.ui.chatting.gallery.g localg = this.Kes;
    localg.tYX.clear();
    localg.cYL();
    AppMethodBeat.o(35356);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(35355);
    if (bc.ajM()) {
      q.aIY().a(this);
    }
    this.Ker.stopTimer();
    AppMethodBeat.o(35355);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(35358);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    AppMethodBeat.o(35358);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(35357);
    if (!com.tencent.mm.plugin.priority.a.a.a.a.dCz()) {
      q.aIY().a(this);
    }
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, bool, false);
      ((com.tencent.mm.plugin.priority.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.priority.a.a.class)).getC2CImgAutoDownloader().c(paramLong1, paramLong2, bool);
      bc.aCg();
      paramObject = com.tencent.mm.model.c.azI().ys(paramLong2);
      ((k)this.cXJ.bh(k.class)).a(paramLong2, paramObject, bool);
      AppMethodBeat.o(35357);
      return;
    }
  }
  
  public final void fAt() {}
  
  public final void fAu()
  {
    AppMethodBeat.i(35362);
    com.tencent.mm.sdk.b.a.IvT.c(this.oZE);
    AppMethodBeat.o(35362);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35363);
    oo localoo = new oo();
    localoo.dDz.dDA = true;
    localoo.dDz.talker = this.cXJ.Cqh.field_username;
    com.tencent.mm.sdk.b.a.IvT.a(localoo, Looper.getMainLooper());
    com.tencent.mm.platformtools.u.b(this);
    AppMethodBeat.o(35363);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35364);
    oo localoo = new oo();
    localoo.dDz.dDA = false;
    localoo.dDz.talker = this.cXJ.Cqh.field_username;
    com.tencent.mm.sdk.b.a.IvT.a(localoo, Looper.getMainLooper());
    com.tencent.mm.platformtools.u.c(this);
    stopTimer();
    AppMethodBeat.o(35364);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35365);
    ffV();
    AppMethodBeat.o(35365);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35361);
    super.fGE();
    ffV();
    AppMethodBeat.o(35361);
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(35359);
    if ((bu.isNullOrNil(paramString)) || (paramBitmap == null) || (this.cXJ == null))
    {
      AppMethodBeat.o(35359);
      return;
    }
    com.tencent.mm.ui.chatting.e.a.fJE().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35351);
        if (x.this.cXJ != null) {
          x.this.cXJ.bPl();
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
    q.aJb().cp(paramInt);
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
    this.Ker.stopTimer();
    this.Ker.ay(1000L, 1000L);
    AppMethodBeat.o(35354);
  }
  
  final class a
    implements Runnable
  {
    private bv dCi;
    private int i;
    private com.tencent.mm.av.g xwx;
    
    a(bv parambv, com.tencent.mm.av.g paramg, int paramInt)
    {
      this.dCi = parambv;
      this.xwx = paramg;
      this.i = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(35352);
      f.aGZ().hWG.add("image_" + this.dCi.field_msgId);
      q.aIY().a(this.xwx.doE, this.dCi.field_msgId, 0, Integer.valueOf(this.i), 2131231564, x.this, -1, true);
      AppMethodBeat.o(35352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.x
 * JD-Core Version:    0.7.0.1
 */