package com.tencent.mm.ui.chatting.d;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.aq.f;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.ay.g;
import com.tencent.mm.f.a.bk;
import com.tencent.mm.f.a.qe;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
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
import com.tencent.mm.ui.chatting.d.b.w;
import com.tencent.mm.ui.chatting.gallery.k.a;
import java.util.HashSet;
import java.util.LinkedList;

@com.tencent.mm.ui.chatting.d.a.a(hRc=w.class)
public class aa
  extends a
  implements e.a, u.a, w
{
  private MTimerHandler WKE;
  private com.tencent.mm.ui.chatting.gallery.k WKF;
  private IListener tNl;
  
  public aa()
  {
    AppMethodBeat.i(35353);
    this.tNl = new IListener() {};
    this.WKE = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(35350);
        if (aa.this.fgR == null)
        {
          AppMethodBeat.o(35350);
          return false;
        }
        boolean bool2 = com.tencent.mm.plugin.priority.a.a.a.a.foK();
        int i = aa.this.fgR.getFirstVisiblePosition();
        int m = aa.this.fgR.hMq();
        int j = aa.this.fgR.getLastVisiblePosition();
        int k = aa.this.fgR.hMq();
        com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)aa.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
        i = Math.max(i - m, 0);
        j = Math.max(Math.min(j - k, localk.getCount()), 0);
        Log.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + i + " last: " + j);
        if (j < i)
        {
          Log.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
          aa.a(aa.this).startTimer(1000L);
          AppMethodBeat.o(35350);
          return false;
        }
        com.tencent.mm.ay.q.bmi().lNA = true;
        if (i <= j)
        {
          ca localca = localk.avt(i);
          g localg;
          boolean bool1;
          if ((localca != null) && (localca.field_isSend == 0) && (localca.hwG()))
          {
            localg = com.tencent.mm.ay.q.bmh().C(localca.field_talker, localca.field_msgSvrId);
            if ((!localg.blJ()) && (localca.ilr != 2)) {
              if (localca.ilr != 1)
              {
                if (!bool2) {
                  break label325;
                }
                d.bkm();
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
              ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).a(localca, new aa.a(aa.this, localca, localg, i));
            }
            label325:
            i += 1;
            break;
            label332:
            if (!localca.hwG())
            {
              Log.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
              bool1 = false;
            }
            else if (!d.Z(localca))
            {
              Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
              bool1 = false;
            }
            else
            {
              bool1 = d.bkn();
            }
          }
        }
        com.tencent.mm.ay.q.bmi().blD();
        AppMethodBeat.o(35350);
        return false;
      }
    }, false);
    this.WKF = k.a.WSQ;
    AppMethodBeat.o(35353);
  }
  
  private void hjX()
  {
    AppMethodBeat.i(35356);
    stopTimer();
    EventCenter.instance.removeListener(this.tNl);
    com.tencent.mm.ui.chatting.gallery.k localk = this.WKF;
    localk.CcG.clear();
    localk.euK();
    AppMethodBeat.o(35356);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(35355);
    if (bh.aHB()) {
      com.tencent.mm.ay.q.bmi().a(this);
    }
    this.WKE.stopTimer();
    AppMethodBeat.o(35355);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(35358);
    ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    AppMethodBeat.o(35358);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.an.q paramq) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(35357);
    if (!com.tencent.mm.plugin.priority.a.a.a.a.foK()) {
      com.tencent.mm.ay.q.bmi().a(this);
    }
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, bool, false);
      ((com.tencent.mm.plugin.priority.a.a)h.ag(com.tencent.mm.plugin.priority.a.a.class)).getC2CImgAutoDownloader().b(paramLong1, paramLong2, bool);
      bh.beI();
      paramObject = c.bbO().Oq(paramLong2);
      ((com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).a(paramLong2, paramObject, bool);
      AppMethodBeat.o(35357);
      return;
    }
  }
  
  public final void hGV() {}
  
  public final void hGW()
  {
    AppMethodBeat.i(35362);
    EventCenter.instance.addListener(this.tNl);
    AppMethodBeat.o(35362);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35363);
    qe localqe = new qe();
    localqe.fOR.pause = true;
    localqe.fOR.talker = this.fgR.NKq.field_username;
    EventCenter.instance.asyncPublish(localqe, Looper.getMainLooper());
    u.b(this);
    AppMethodBeat.o(35363);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35364);
    qe localqe = new qe();
    localqe.fOR.pause = false;
    localqe.fOR.talker = this.fgR.NKq.field_username;
    EventCenter.instance.asyncPublish(localqe, Looper.getMainLooper());
    u.c(this);
    stopTimer();
    AppMethodBeat.o(35364);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35365);
    hjX();
    AppMethodBeat.o(35365);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35361);
    super.hNZ();
    hjX();
    AppMethodBeat.o(35361);
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(35359);
    if ((Util.isNullOrNil(paramString)) || (paramBitmap == null) || (this.fgR == null))
    {
      AppMethodBeat.o(35359);
      return;
    }
    com.tencent.mm.ui.chatting.e.a.hRl().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35351);
        if (aa.this.fgR != null) {
          aa.this.fgR.cAe();
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
    com.tencent.mm.ay.q.bml().onScrollStateChanged(paramInt);
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
    this.WKE.stopTimer();
    this.WKE.startTimer(1000L);
    AppMethodBeat.o(35354);
  }
  
  final class a
    implements Runnable
  {
    private g HqT;
    private ca fNz;
    private int i;
    
    a(ca paramca, g paramg, int paramInt)
    {
      this.fNz = paramca;
      this.HqT = paramg;
      this.i = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(35352);
      f.bkg().lHW.add("image_" + this.fNz.field_msgId);
      com.tencent.mm.ay.q.bmi().a(this.HqT.localId, this.fNz.field_msgId, 0, Integer.valueOf(this.i), R.g.chat_img_template, aa.this, -1, true);
      AppMethodBeat.o(35352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aa
 * JD-Core Version:    0.7.0.1
 */