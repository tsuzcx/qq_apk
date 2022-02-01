package com.tencent.mm.ui.chatting.component;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.rr;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.priority.a.a.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.z;
import com.tencent.mm.ui.chatting.gallery.m.a;
import java.util.HashSet;
import java.util.LinkedList;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=z.class)
public class ad
  extends a
  implements f.a, r.a, z
{
  private MTimerHandler aesI;
  private com.tencent.mm.ui.chatting.gallery.m aesJ;
  private IListener wQB;
  
  public ad()
  {
    AppMethodBeat.i(35353);
    this.wQB = new GetImageComponent.1(this, com.tencent.mm.app.f.hfK);
    this.aesI = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(35350);
        if (ad.this.hlc == null)
        {
          AppMethodBeat.o(35350);
          return false;
        }
        boolean bool2 = com.tencent.mm.plugin.priority.a.a.a.a.gzN();
        int i = ad.this.hlc.getFirstVisiblePosition();
        int m = ad.this.hlc.joT();
        int j = ad.this.hlc.getLastVisiblePosition();
        int k = ad.this.hlc.joT();
        com.tencent.mm.ui.chatting.component.api.m localm = (com.tencent.mm.ui.chatting.component.api.m)ad.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class);
        i = Math.max(i - m, 0);
        j = Math.max(Math.min(j - k, localm.getCount()), 0);
        Log.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + i + " last: " + j);
        if (j < i)
        {
          Log.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
          ad.a(ad.this).startTimer(1000L);
          AppMethodBeat.o(35350);
          return false;
        }
        com.tencent.mm.modelimage.r.bKb().oGk = true;
        if (i <= j)
        {
          cc localcc = localm.aBV(i);
          com.tencent.mm.modelimage.h localh;
          label280:
          boolean bool1;
          if ((localcc != null) && (localcc.iYk()))
          {
            if (localcc.kLl == 0)
            {
              localh = com.tencent.mm.modelimage.r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
              if (!localh.bJD()) {
                break label399;
              }
              Log.i("MicroMsg.ChattingUI.GetImageComponent", "create hd thumb for backup msg");
              com.tencent.threadpool.h.ahAA.g(new ad.b(ad.this, localcc, localh), "MicroMsg.ChattingUI.GetImageComponent");
            }
            if (localcc.field_isSend != 0)
            {
              localh = com.tencent.mm.modelimage.r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
              if ((!localh.bJD()) && (localcc.kLq != 2)) {
                if (localcc.kLq != 1)
                {
                  if (!bool2) {
                    break label392;
                  }
                  d.bId();
                  if (localcc != null) {
                    break label424;
                  }
                  Log.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
                  bool1 = false;
                }
              }
            }
          }
          for (;;)
          {
            if (bool1) {
              ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).a(localcc, new ad.a(ad.this, localcc, localh, i));
            }
            label392:
            i += 1;
            break;
            label399:
            Log.i("MicroMsg.ChattingUI.GetImageComponent", "create hd thumb for backup msg fail, img not completed %s", new Object[] { Long.valueOf(localcc.field_msgSvrId) });
            break label280;
            label424:
            if (!localcc.iYk())
            {
              Log.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
              bool1 = false;
            }
            else if (!d.ae(localcc))
            {
              Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
              bool1 = false;
            }
            else
            {
              bool1 = d.bIe();
            }
          }
        }
        com.tencent.mm.modelimage.r.bKb().bJB();
        AppMethodBeat.o(35350);
        return false;
      }
    }, false);
    this.aesJ = m.a.aeCt;
    AppMethodBeat.o(35353);
  }
  
  private void iKP()
  {
    AppMethodBeat.i(35356);
    stopTimer();
    this.wQB.dead();
    com.tencent.mm.ui.chatting.gallery.m localm = this.aesJ;
    localm.HOJ.clear();
    localm.fBF();
    AppMethodBeat.o(35356);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(35355);
    if (bh.baz()) {
      com.tencent.mm.modelimage.r.bKb().a(this);
    }
    this.aesI.stopTimer();
    AppMethodBeat.o(35355);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(35358);
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).b(paramLong2, false, true);
    AppMethodBeat.o(35358);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, p paramp) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, p paramp)
  {
    AppMethodBeat.i(35357);
    if (!com.tencent.mm.plugin.priority.a.a.a.a.gzN()) {
      com.tencent.mm.modelimage.r.bKb().a(this);
    }
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).b(paramLong2, bool, false);
      ((com.tencent.mm.plugin.priority.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.priority.a.a.class)).getC2CImgAutoDownloader().b(paramLong1, paramLong2, bool);
      bh.bCz();
      paramObject = com.tencent.mm.model.c.bzD().sl(paramLong2);
      ((com.tencent.mm.ui.chatting.component.api.m)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.m.class)).a(paramLong2, paramObject, bool);
      AppMethodBeat.o(35357);
      return;
    }
  }
  
  public final void jjg() {}
  
  public final void jjh()
  {
    AppMethodBeat.i(35362);
    this.wQB.alive();
    AppMethodBeat.o(35362);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35363);
    rr localrr = new rr();
    localrr.hUK.pause = true;
    localrr.hUK.talker = this.hlc.Uxa.field_username;
    localrr.asyncPublish(Looper.getMainLooper());
    com.tencent.mm.platformtools.r.b(this);
    AppMethodBeat.o(35363);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35364);
    rr localrr = new rr();
    localrr.hUK.pause = false;
    localrr.hUK.talker = this.hlc.Uxa.field_username;
    localrr.asyncPublish(Looper.getMainLooper());
    com.tencent.mm.platformtools.r.c(this);
    stopTimer();
    AppMethodBeat.o(35364);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35365);
    iKP();
    AppMethodBeat.o(35365);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35361);
    super.jqF();
    iKP();
    AppMethodBeat.o(35361);
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(35359);
    if ((Util.isNullOrNil(paramString)) || (paramBitmap == null) || (this.hlc == null))
    {
      AppMethodBeat.o(35359);
      return;
    }
    com.tencent.mm.ui.chatting.d.a.juI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35351);
        if (ad.this.hlc != null) {
          ad.this.hlc.dcZ();
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
    com.tencent.mm.modelimage.r.bKe().onScrollStateChanged(paramInt);
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
    this.aesI.stopTimer();
    this.aesI.startTimer(1000L);
    AppMethodBeat.o(35354);
  }
  
  final class a
    implements Runnable
  {
    private com.tencent.mm.modelimage.h NoG;
    private cc hTm;
    private int i;
    
    a(cc paramcc, com.tencent.mm.modelimage.h paramh, int paramInt)
    {
      this.hTm = paramcc;
      this.NoG = paramh;
      this.i = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(35352);
      k.bHW().oAv.add("image_" + this.hTm.field_msgId);
      com.tencent.mm.modelimage.r.bKb().a(this.NoG.localId, this.hTm.field_msgId, 0, Integer.valueOf(this.i), R.g.chat_img_template, ad.this, -1, true);
      AppMethodBeat.o(35352);
    }
  }
  
  final class b
    implements Runnable
  {
    private com.tencent.mm.modelimage.h NoG;
    private cc hTm;
    
    b(cc paramcc, com.tencent.mm.modelimage.h paramh)
    {
      this.hTm = paramcc;
      this.NoG = paramh;
    }
    
    public final void run()
    {
      AppMethodBeat.i(255948);
      if (com.tencent.mm.modelimage.r.bKa().a(this.hTm, R.g.chat_img_template, 0))
      {
        this.hTm.pY(1);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.hTm.field_msgId, this.hTm);
      }
      AppMethodBeat.o(255948);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ad
 * JD-Core Version:    0.7.0.1
 */