package com.tencent.mm.ui.chatting.d;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.av.e;
import com.tencent.mm.av.e.a;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.w;
import com.tencent.mm.ui.chatting.gallery.g.a;
import java.util.HashSet;
import java.util.LinkedList;

@com.tencent.mm.ui.chatting.d.a.a(gRF=w.class)
public class z
  extends a
  implements e.a, u.a, w
{
  private MTimerHandler Pqi;
  private com.tencent.mm.ui.chatting.gallery.g Pqj;
  private IListener qoC;
  
  public z()
  {
    AppMethodBeat.i(35353);
    this.qoC = new IListener() {};
    this.Pqi = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(35350);
        if (z.this.dom == null)
        {
          AppMethodBeat.o(35350);
          return false;
        }
        boolean bool2 = com.tencent.mm.plugin.priority.a.a.a.a.eCR();
        int i = z.this.dom.getFirstVisiblePosition();
        int m = z.this.dom.getHeaderViewsCount();
        int j = z.this.dom.getLastVisiblePosition();
        int k = z.this.dom.getHeaderViewsCount();
        k localk = (k)z.this.dom.bh(k.class);
        i = Math.max(i - m, 0);
        j = Math.max(Math.min(j - k, localk.getCount()), 0);
        Log.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + i + " last: " + j);
        if (j < i)
        {
          Log.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
          z.a(z.this).startTimer(1000L);
          AppMethodBeat.o(35350);
          return false;
        }
        com.tencent.mm.av.q.bcS().iXf = true;
        if (i <= j)
        {
          ca localca = localk.amt(i);
          com.tencent.mm.av.g localg;
          boolean bool1;
          if ((localca != null) && (localca.field_isSend == 0) && (localca.gAz()))
          {
            localg = com.tencent.mm.av.q.bcR().G(localca.field_talker, localca.field_msgSvrId);
            if ((!localg.bcu()) && (localca.fRb != 2)) {
              if (localca.fRb != 1)
              {
                if (!bool2) {
                  break label325;
                }
                d.baW();
                if (localca != null) {
                  break label332;
                }
                Log.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
                bool1 = false;
              }
            }
          }
          for (;;)
          {
            if (bool1) {
              ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).a(localca, new z.a(z.this, localca, localg, i));
            }
            label325:
            i += 1;
            break;
            label332:
            if (!localca.gAz())
            {
              Log.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
              bool1 = false;
            }
            else if (!d.T(localca))
            {
              Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
              bool1 = false;
            }
            else
            {
              bool1 = d.baX();
            }
          }
        }
        com.tencent.mm.av.q.bcS().bco();
        AppMethodBeat.o(35350);
        return false;
      }
    }, false);
    this.Pqj = g.a.Pyr;
    AppMethodBeat.o(35353);
  }
  
  private void gpe()
  {
    AppMethodBeat.i(35356);
    stopTimer();
    EventCenter.instance.removeListener(this.qoC);
    com.tencent.mm.ui.chatting.gallery.g localg = this.Pqj;
    localg.xql.clear();
    localg.dSj();
    AppMethodBeat.o(35356);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(35355);
    if (bg.aAc()) {
      com.tencent.mm.av.q.bcS().a(this);
    }
    this.Pqi.stopTimer();
    AppMethodBeat.o(35355);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(35358);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    AppMethodBeat.o(35358);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.ak.q paramq) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(35357);
    if (!com.tencent.mm.plugin.priority.a.a.a.a.eCR()) {
      com.tencent.mm.av.q.bcS().a(this);
    }
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, bool, false);
      ((com.tencent.mm.plugin.priority.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.priority.a.a.class)).getC2CImgAutoDownloader().b(paramLong1, paramLong2, bool);
      bg.aVF();
      paramObject = c.aSQ().Hb(paramLong2);
      ((k)this.dom.bh(k.class)).a(paramLong2, paramObject, bool);
      AppMethodBeat.o(35357);
      return;
    }
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35363);
    pg localpg = new pg();
    localpg.dVo.pause = true;
    localpg.dVo.talker = this.dom.GUe.field_username;
    EventCenter.instance.asyncPublish(localpg, Looper.getMainLooper());
    u.b(this);
    AppMethodBeat.o(35363);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35364);
    pg localpg = new pg();
    localpg.dVo.pause = false;
    localpg.dVo.talker = this.dom.GUe.field_username;
    EventCenter.instance.asyncPublish(localpg, Looper.getMainLooper());
    u.c(this);
    stopTimer();
    AppMethodBeat.o(35364);
  }
  
  public final void gIl() {}
  
  public final void gIm()
  {
    AppMethodBeat.i(35362);
    EventCenter.instance.addListener(this.qoC);
    AppMethodBeat.o(35362);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35365);
    gpe();
    AppMethodBeat.o(35365);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35361);
    super.gOK();
    gpe();
    AppMethodBeat.o(35361);
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(35359);
    if ((Util.isNullOrNil(paramString)) || (paramBitmap == null) || (this.dom == null))
    {
      AppMethodBeat.o(35359);
      return;
    }
    com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35351);
        if (z.this.dom != null) {
          z.this.dom.cmy();
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
    com.tencent.mm.av.q.bcV().onScrollStateChanged(paramInt);
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
    this.Pqi.stopTimer();
    this.Pqi.startTimer(1000L);
    AppMethodBeat.o(35354);
  }
  
  final class a
    implements Runnable
  {
    private com.tencent.mm.av.g Bwy;
    private ca dTX;
    private int i;
    
    a(ca paramca, com.tencent.mm.av.g paramg, int paramInt)
    {
      this.dTX = paramca;
      this.Bwy = paramg;
      this.i = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(35352);
      f.baQ().iRE.add("image_" + this.dTX.field_msgId);
      com.tencent.mm.av.q.bcS().a(this.Bwy.localId, this.dTX.field_msgId, 0, Integer.valueOf(this.i), 2131231628, z.this, -1, true);
      AppMethodBeat.o(35352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.z
 * JD-Core Version:    0.7.0.1
 */