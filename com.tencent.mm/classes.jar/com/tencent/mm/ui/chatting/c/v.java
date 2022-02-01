package com.tencent.mm.ui.chatting.c;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.an.f;
import com.tencent.mm.av.d;
import com.tencent.mm.av.d.a;
import com.tencent.mm.av.e;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.gallery.g.a;
import java.util.HashSet;
import java.util.LinkedList;

@com.tencent.mm.ui.chatting.c.a.a(foJ=s.class)
public class v
  extends a
  implements d.a, u.a, s
{
  private au HUX;
  private com.tencent.mm.ui.chatting.gallery.g HUY;
  private com.tencent.mm.sdk.b.c opH;
  
  public v()
  {
    AppMethodBeat.i(35353);
    this.opH = new com.tencent.mm.sdk.b.c() {};
    this.HUX = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(35350);
        if (v.this.cLy == null)
        {
          AppMethodBeat.o(35350);
          return false;
        }
        boolean bool2 = com.tencent.mm.plugin.priority.a.a.a.a.doG();
        int i = v.this.cLy.getFirstVisiblePosition();
        int m = v.this.cLy.getHeaderViewsCount();
        int j = v.this.cLy.getLastVisiblePosition();
        int k = v.this.cLy.getHeaderViewsCount();
        i locali = (i)v.this.cLy.bf(i.class);
        i = Math.max(i - m, 0);
        j = Math.max(Math.min(j - k, locali.getCount()), 0);
        ac.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + i + " last: " + j);
        if (j < i)
        {
          ac.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
          v.a(v.this).au(1000L, 1000L);
          AppMethodBeat.o(35350);
          return false;
        }
        o.aFy().hGF = true;
        if (i <= j)
        {
          bo localbo = locali.aaP(i);
          e locale;
          boolean bool1;
          if ((localbo != null) && (localbo.field_isSend == 0) && (localbo.eZm()))
          {
            locale = o.aFx().qf(localbo.field_msgSvrId);
            if ((!locale.aEZ()) && (localbo.eSl != 2)) {
              if (localbo.eSl != 1)
              {
                if (!bool2) {
                  break label323;
                }
                com.tencent.mm.modelcontrol.c.aDI();
                if (localbo != null) {
                  break label330;
                }
                ac.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
                bool1 = false;
              }
            }
          }
          for (;;)
          {
            if (bool1) {
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(localbo, new v.a(v.this, localbo, locale, i));
            }
            label323:
            i += 1;
            break;
            label330:
            if (!localbo.eZm())
            {
              ac.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
              bool1 = false;
            }
            else if (!com.tencent.mm.modelcontrol.c.H(localbo))
            {
              ac.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
              bool1 = false;
            }
            else
            {
              bool1 = com.tencent.mm.modelcontrol.c.aDJ();
            }
          }
        }
        o.aFy().aEX();
        AppMethodBeat.o(35350);
        return false;
      }
    }, false);
    this.HUY = g.a.IbR;
    AppMethodBeat.o(35353);
  }
  
  private void eNi()
  {
    AppMethodBeat.i(35356);
    stopTimer();
    com.tencent.mm.sdk.b.a.GpY.d(this.opH);
    com.tencent.mm.ui.chatting.gallery.g localg = this.HUY;
    localg.sRC.clear();
    localg.cNO();
    AppMethodBeat.o(35356);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(35355);
    if (az.agM()) {
      o.aFy().a(this);
    }
    this.HUX.stopTimer();
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
    if (!com.tencent.mm.plugin.priority.a.a.a.a.doG()) {
      o.aFy().a(this);
    }
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, bool, false);
      ((com.tencent.mm.plugin.priority.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.priority.a.a.class)).getC2CImgAutoDownloader().c(paramLong1, paramLong2, bool);
      az.ayM();
      paramObject = com.tencent.mm.model.c.awD().vP(paramLong2);
      ((i)this.cLy.bf(i.class)).a(paramLong2, paramObject, bool);
      AppMethodBeat.o(35357);
      return;
    }
  }
  
  public final void fgh() {}
  
  public final void fgi()
  {
    AppMethodBeat.i(35362);
    com.tencent.mm.sdk.b.a.GpY.c(this.opH);
    AppMethodBeat.o(35362);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35363);
    oe localoe = new oe();
    localoe.dqD.dqE = true;
    localoe.dqD.talker = this.cLy.AzG.field_username;
    com.tencent.mm.sdk.b.a.GpY.a(localoe, Looper.getMainLooper());
    u.b(this);
    AppMethodBeat.o(35363);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35364);
    oe localoe = new oe();
    localoe.dqD.dqE = false;
    localoe.dqD.talker = this.cLy.AzG.field_username;
    com.tencent.mm.sdk.b.a.GpY.a(localoe, Looper.getMainLooper());
    u.c(this);
    stopTimer();
    AppMethodBeat.o(35364);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35365);
    eNi();
    AppMethodBeat.o(35365);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35361);
    super.fmj();
    eNi();
    AppMethodBeat.o(35361);
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(35359);
    if ((bs.isNullOrNil(paramString)) || (paramBitmap == null) || (this.cLy == null))
    {
      AppMethodBeat.o(35359);
      return;
    }
    com.tencent.mm.ui.chatting.d.a.foS().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35351);
        if (v.this.cLy != null) {
          v.this.cLy.bJU();
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
    o.aFB().cp(paramInt);
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
    this.HUX.stopTimer();
    this.HUX.au(1000L, 1000L);
    AppMethodBeat.o(35354);
  }
  
  final class a
    implements Runnable
  {
    private bo dpq;
    private int i;
    private e vZa;
    
    a(bo parambo, e parame, int paramInt)
    {
      this.dpq = parambo;
      this.vZa = parame;
      this.i = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(35352);
      f.aDD().hBp.add("image_" + this.dpq.field_msgId);
      o.aFy().a(this.vZa.dcd, this.dpq.field_msgId, 0, Integer.valueOf(this.i), 2131231564, v.this, -1, true);
      AppMethodBeat.o(35352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.v
 * JD-Core Version:    0.7.0.1
 */