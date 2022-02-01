package com.tencent.mm.ui.chatting.d;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.ao.f;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.g.a;
import java.util.HashSet;
import java.util.LinkedList;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.u.class)
public class x
  extends a
  implements e.a, u.a, com.tencent.mm.ui.chatting.d.b.u
{
  private av JJv;
  private com.tencent.mm.ui.chatting.gallery.g JJw;
  private com.tencent.mm.sdk.b.c oTc;
  
  public x()
  {
    AppMethodBeat.i(35353);
    this.oTc = new com.tencent.mm.sdk.b.c() {};
    this.JJv = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(35350);
        if (x.this.cWM == null)
        {
          AppMethodBeat.o(35350);
          return false;
        }
        boolean bool2 = com.tencent.mm.plugin.priority.a.a.a.a.dzi();
        int i = x.this.cWM.getFirstVisiblePosition();
        int m = x.this.cWM.getHeaderViewsCount();
        int j = x.this.cWM.getLastVisiblePosition();
        int k = x.this.cWM.getHeaderViewsCount();
        k localk = (k)x.this.cWM.bh(k.class);
        i = Math.max(i - m, 0);
        j = Math.max(Math.min(j - k, localk.getCount()), 0);
        ad.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + i + " last: " + j);
        if (j < i)
        {
          ad.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
          x.a(x.this).az(1000L, 1000L);
          AppMethodBeat.o(35350);
          return false;
        }
        q.aIG().hZp = true;
        if (i <= j)
        {
          bu localbu = localk.ada(i);
          com.tencent.mm.aw.g localg;
          boolean bool1;
          if ((localbu != null) && (localbu.field_isSend == 0) && (localbu.fpi()))
          {
            localg = q.aIF().F(localbu.field_talker, localbu.field_msgSvrId);
            if ((!localg.aIi()) && (localbu.fkA != 2)) {
              if (localbu.fkA != 1)
              {
                if (!bool2) {
                  break label328;
                }
                com.tencent.mm.modelcontrol.c.aGN();
                if (localbu != null) {
                  break label335;
                }
                ad.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
                bool1 = false;
              }
            }
          }
          for (;;)
          {
            if (bool1) {
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(localbu, new x.a(x.this, localbu, localg, i));
            }
            label328:
            i += 1;
            break;
            label335:
            if (!localbu.fpi())
            {
              ad.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
              bool1 = false;
            }
            else if (!com.tencent.mm.modelcontrol.c.K(localbu))
            {
              ad.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
              bool1 = false;
            }
            else
            {
              bool1 = com.tencent.mm.modelcontrol.c.aGO();
            }
          }
        }
        q.aIG().aId();
        AppMethodBeat.o(35350);
        return false;
      }
    }, false);
    this.JJw = g.a.JRj;
    AppMethodBeat.o(35353);
  }
  
  private void fch()
  {
    AppMethodBeat.i(35356);
    stopTimer();
    com.tencent.mm.sdk.b.a.IbL.d(this.oTc);
    com.tencent.mm.ui.chatting.gallery.g localg = this.JJw;
    localg.tOg.clear();
    localg.cWg();
    AppMethodBeat.o(35356);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(35355);
    if (ba.ajx()) {
      q.aIG().a(this);
    }
    this.JJv.stopTimer();
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
    if (!com.tencent.mm.plugin.priority.a.a.a.a.dzi()) {
      q.aIG().a(this);
    }
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, bool, false);
      ((com.tencent.mm.plugin.priority.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.priority.a.a.class)).getC2CImgAutoDownloader().c(paramLong1, paramLong2, bool);
      ba.aBQ();
      paramObject = com.tencent.mm.model.c.azs().xY(paramLong2);
      ((k)this.cWM.bh(k.class)).a(paramLong2, paramObject, bool);
      AppMethodBeat.o(35357);
      return;
    }
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35361);
    super.fCC();
    fch();
    AppMethodBeat.o(35361);
  }
  
  public final void fwt() {}
  
  public final void fwu()
  {
    AppMethodBeat.i(35362);
    com.tencent.mm.sdk.b.a.IbL.c(this.oTc);
    AppMethodBeat.o(35362);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35363);
    on localon = new on();
    localon.dCu.dCv = true;
    localon.dCu.talker = this.cWM.BYG.field_username;
    com.tencent.mm.sdk.b.a.IbL.a(localon, Looper.getMainLooper());
    com.tencent.mm.platformtools.u.b(this);
    AppMethodBeat.o(35363);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35364);
    on localon = new on();
    localon.dCu.dCv = false;
    localon.dCu.talker = this.cWM.BYG.field_username;
    com.tencent.mm.sdk.b.a.IbL.a(localon, Looper.getMainLooper());
    com.tencent.mm.platformtools.u.c(this);
    stopTimer();
    AppMethodBeat.o(35364);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35365);
    fch();
    AppMethodBeat.o(35365);
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(35359);
    if ((bt.isNullOrNil(paramString)) || (paramBitmap == null) || (this.cWM == null))
    {
      AppMethodBeat.o(35359);
      return;
    }
    com.tencent.mm.ui.chatting.e.a.fFx().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35351);
        if (x.this.cWM != null) {
          x.this.cWM.bOo();
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
    q.aIJ().cp(paramInt);
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
    this.JJv.stopTimer();
    this.JJv.az(1000L, 1000L);
    AppMethodBeat.o(35354);
  }
  
  final class a
    implements Runnable
  {
    private bu dBd;
    private int i;
    private com.tencent.mm.aw.g xgF;
    
    a(bu parambu, com.tencent.mm.aw.g paramg, int paramInt)
    {
      this.dBd = parambu;
      this.xgF = paramg;
      this.i = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(35352);
      f.aGI().hTO.add("image_" + this.dBd.field_msgId);
      q.aIG().a(this.xgF.dnz, this.dBd.field_msgId, 0, Integer.valueOf(this.i), 2131231564, x.this, -1, true);
      AppMethodBeat.o(35352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.x
 * JD-Core Version:    0.7.0.1
 */