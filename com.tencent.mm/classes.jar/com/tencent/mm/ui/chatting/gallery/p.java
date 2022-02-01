package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ra;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ae;
import com.tencent.mm.modelvideo.ae.a;
import com.tencent.mm.modelvideo.ag.a;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.network.ah;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.drh;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.chatting.RevokeMsgListener;
import com.tencent.mm.ui.chatting.RevokeMsgListener.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class p
  extends g
  implements d.a, aa.a
{
  public static boolean aeEA = false;
  int Aqc;
  private int Aqd;
  private com.tencent.mm.plugin.sight.decode.ui.b Aqj;
  private com.tencent.mm.plugin.u.b KSQ;
  private MTimerHandler QTh;
  private com.tencent.mm.pluginsdk.ui.tools.i.e RgB;
  private boolean RgL;
  private long RgP;
  private long RgQ;
  private long Rhh;
  private int Rhi;
  private HashMap<String, a> aeCv;
  MMHandler aeEB;
  private int aeEC;
  private IListener<ra> aeED;
  private boolean aeEE;
  private int aeEF;
  private int[] aeEG;
  private IListener aeEr;
  final SparseArray<z> aeEs;
  private v aeEt;
  private boolean aeEu;
  private boolean aeEv;
  private boolean aeEw;
  private int aeEx;
  private int aeEy;
  private boolean aeEz;
  private String filename;
  private long lastCheckTime;
  private PowerManager.WakeLock mUJ;
  private long sJl;
  private com.tencent.mm.model.d vZw;
  private MTimerHandler wCj;
  
  public p(h paramh)
  {
    super(paramh);
    AppMethodBeat.i(36261);
    this.aeEs = new SparseArray();
    this.aeEu = false;
    this.aeEv = false;
    this.aeEw = false;
    this.Aqd = 0;
    this.sJl = 0L;
    this.lastCheckTime = 0L;
    this.aeEx = 0;
    this.aeEy = 0;
    this.RgP = 0L;
    this.RgQ = 0L;
    this.Aqc = 0;
    this.aeEz = false;
    this.aeEB = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(36254);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = p.this.aeAg.jve();
          if ((paramAnonymousMessage != null) && (!Util.isNullOrNil(p.a(p.this))))
          {
            Log.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", new Object[] { Integer.valueOf(hashCode()), p.a(p.this) });
            if (!p.b(p.this)) {
              com.tencent.mm.modelvideo.ab.k(p.a(p.this), paramAnonymousMessage.jwq().aeFr.getCurrentPosition(), p.c(p.this));
            }
            p.g(paramAnonymousMessage);
            p.a(p.this, paramAnonymousMessage);
            p.d(p.this).gR(false);
            if (p.c(p.this))
            {
              p.e(p.this).dead();
              p.f(p.this).jws();
              p.a(p.this, false);
            }
          }
          p.g(p.this);
        }
        AppMethodBeat.o(36254);
        return false;
      }
    });
    this.aeEC = 0;
    this.QTh = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36258);
        if (!p.f(p.this).isStreaming())
        {
          AppMethodBeat.o(36258);
          return false;
        }
        r localr = p.this.aeAg.jve();
        if (localr == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localr.aeFo == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localr.jwq().aeFo.getVisibility() != 0)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        boolean bool = true;
        if (localr.jwq().aeFr.isPlaying()) {
          bool = p.b(p.this, localr);
        }
        if (bool)
        {
          int i = localr.jwq().aeFr.getCurrentPosition() / 1000;
          bool = p.f(p.this).xa(i);
          AppMethodBeat.o(36258);
          return bool;
        }
        AppMethodBeat.o(36258);
        return false;
      }
    }, true);
    this.wCj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36259);
        if (p.this.aeAg == null)
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
          AppMethodBeat.o(36259);
          return false;
        }
        r localr = p.this.aeAg.jve();
        if (localr == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localr.aeFo == null)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        if (localr.jwq().aeFo.getVisibility() != 0)
        {
          AppMethodBeat.o(36259);
          return false;
        }
        int i = p.this.aeAg.aeAB.getCurrentItem();
        if ((z)p.this.aeEs.get(i) == null)
        {
          p.this.aCw(i);
          AppMethodBeat.o(36259);
          return false;
        }
        if (!localr.jwq().aeFr.isPlaying())
        {
          Log.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
          AppMethodBeat.o(36259);
          return false;
        }
        p.a(p.this, localr.jwq().aeFr.getCurrentPosition());
        p.this.aCX(p.n(p.this) / 1000);
        AppMethodBeat.o(36259);
        return true;
      }
    }, true);
    this.Aqj = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void blc()
      {
        AppMethodBeat.i(36244);
        if (p.this.aeAg.jve() != null) {
          p.a(p.this, p.this.aeAg.jve());
        }
        p.this.aeAg.aeAB.Aqi.stopTimer();
        AppMethodBeat.o(36244);
      }
      
      public final void tS(int paramAnonymousInt)
      {
        AppMethodBeat.i(36245);
        localObject = null;
        try
        {
          String str = p.this.aeAg.jve().jwq().aeFr.getVideoPath();
          localObject = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
            Log.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + localException.toString());
            continue;
            boolean bool = p.f(p.this).cL(paramAnonymousInt, true);
            continue;
            localObject = p.this.aeAg.jvd();
            if ((localObject != null) && (((cc)localObject).dSH())) {
              com.tencent.mm.modelvideo.ab.k(((fi)localObject).field_imgPath, paramAnonymousInt * 1000, p.c(p.this));
            }
            p.this.aeAg.aCE(p.this.aeAg.aeAB.getCurrentItem());
          }
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(p.c(p.this)), localObject });
        p.this.aeAg.jve().jwq().aeFq.setVisibility(8);
        if (!Util.isNullOrNil((String)localObject)) {
          if (!p.c(p.this))
          {
            p.this.bJ(paramAnonymousInt, true);
            bool = true;
            if (bool) {
              p.this.ho(false);
            }
            p.this.aeAg.aeAB.jvR();
            localObject = p.this.aeAg.jvd();
            if ((localObject != null) && (((cc)localObject).dSI())) {
              p.this.aeAg.aeAB.aeCD.n((cc)localObject, 13);
            }
            AppMethodBeat.o(36245);
            return;
          }
        }
      }
      
      public final void tT(int paramAnonymousInt) {}
    };
    this.aeED = new ImageGalleryVideoHandler.12(this, com.tencent.mm.app.f.hfK);
    this.aeEE = false;
    this.aeEF = 0;
    this.aeEG = new int[] { -1000, -2000, 3400 };
    this.RgB = new com.tencent.mm.pluginsdk.ui.tools.i.e()
    {
      public final void onTextureUpdate()
      {
        AppMethodBeat.i(36250);
        Log.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[] { Integer.valueOf(p.this.hashCode()) });
        try
        {
          p.this.aeAg.jve().d(true, 1.0F);
          AppMethodBeat.o(36250);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + localException.toString());
          AppMethodBeat.o(36250);
        }
      }
    };
    this.KSQ = new com.tencent.mm.plugin.u.b()
    {
      public final long gbz()
      {
        AppMethodBeat.i(36251);
        Log.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[] { Integer.valueOf(p.this.hashCode()) });
        bh.bCz();
        c.ban().set(at.a.acPO, Boolean.TRUE);
        try
        {
          if ((p.c(p.this)) && (p.f(p.this) != null))
          {
            int i = p.f(p.this).oYz;
            long l = i;
            AppMethodBeat.o(36251);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(36251);
        }
        return 0L;
      }
    };
    this.aeCv = new HashMap();
    this.aeEt = new v(this);
    this.aeEr = new RevokeMsgListener(RevokeMsgListener.a.aelv, paramh.aeAB);
    this.aeEr.alive();
    this.aeED.alive();
    this.vZw = new com.tencent.mm.model.d();
    AppMethodBeat.o(36261);
  }
  
  private void a(cc paramcc, z paramz, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36274);
    if ((paramcc == null) || (paramz == null))
    {
      AppMethodBeat.o(36274);
      return;
    }
    if ((!paramcc.dSI()) && (paramcc.isClean()))
    {
      Toast.makeText(this.aeAg.aeAB, R.l.gXE, 0).show();
      AppMethodBeat.o(36274);
      return;
    }
    Object localObject3;
    Object localObject1;
    if (paramz.pbi == -1)
    {
      localObject3 = paramz.bOt();
      localObject1 = localObject3;
      if (!com.tencent.mm.vfs.y.ZC((String)localObject3))
      {
        com.tencent.mm.modelvideo.v.bOh();
        localObject1 = com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath);
        if ((localObject1 != null) && (com.tencent.mm.vfs.y.ZC((String)localObject1))) {
          break label336;
        }
        Toast.makeText(this.aeAg.aeAB, R.l.gXE, 0).show();
        AppMethodBeat.o(36274);
      }
    }
    else
    {
      com.tencent.mm.modelvideo.v.bOh();
      localObject3 = com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath);
      localObject1 = localObject3;
      if (paramcc.field_isSend == 1)
      {
        localObject1 = localObject3;
        if (paramz.pbl != null)
        {
          localObject1 = localObject3;
          if (!paramz.pbl.aaSg) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.vfs.y.bEo((String)localObject3);
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        str = com.tencent.mm.vfs.y.bEq((String)localObject3);
        localObject1 = (String)localObject1 + str + "_hd.mp4";
        bool = com.tencent.mm.vfs.y.ZC((String)localObject1);
        Log.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[] { localObject1, Boolean.valueOf(bool) });
        if (!bool) {
          break label1065;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[] { localException.getMessage() });
        localObject2 = localObject3;
      }
      break;
      label336:
      localObject3 = aCt(paramInt);
      if (localObject3 == null)
      {
        AppMethodBeat.o(36274);
        return;
      }
      int i = 0;
      if (au.bwE(paramz.bOs())) {
        i = com.tencent.mm.model.v.getMembersCountByChatRoomName(paramz.bOs());
      }
      boolean bool = com.tencent.mm.modelvideo.y.PK(localObject2);
      int j = this.aeAg.aeAB.An(paramcc.field_msgId);
      Log.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Boolean.valueOf(this.aeEz) });
      if (!bool)
      {
        if ((af.lYj.lUr == 1) && (com.tencent.mm.pluginsdk.k.b.a.a.c(paramz.getFileName(), this.aeAg.aeAB.getContext(), bool)))
        {
          AppMethodBeat.o(36274);
          return;
        }
        bh.bCz();
        if ((((Integer)c.ban().get(at.a.acOt, Integer.valueOf(0))).intValue() == 1) && (((r)localObject3).aeFt != null))
        {
          ((r)localObject3).aeFt.setVisibility(0);
          ((r)localObject3).aeFt.setText(com.tencent.mm.plugin.sight.base.f.aMu(localObject2));
        }
        ((r)localObject3).a(paramz.omT, paramz.osy, i, paramz.bOs(), z.PM(paramz.bOu()), paramz.createTime);
        this.RgL = paramBoolean;
        this.aeEu = true;
        this.filename = paramz.getFileName();
        if (j == 3)
        {
          ((r)localObject3).jwq().aeFr.setMute(true);
          if ((((r)localObject3).jwq().aeFr.getVideoPath() == null) || (!((r)localObject3).jwq().aeFr.getVideoPath().equals(localObject2)) || (((r)localObject3).jwq().aeFr.isPlaying()) || (this.aeEz)) {
            break label822;
          }
          ((r)localObject3).d(true, 1.0F);
          ((r)localObject3).jwq().aeFr.start();
          hmH();
          if (!paramBoolean) {
            bBo(this.filename);
          }
          aCX(((r)localObject3).jwq().aeFr.getCurrentPosition() / 1000);
          ho(false);
          label740:
          b(paramInt, paramz);
          this.aeAg.aeAB.setVideoStateIv(false);
          this.aeAg.aeAB.getContext().getWindow().addFlags(128);
          this.vZw.a(this);
        }
      }
      for (;;)
      {
        ((r)localObject3).jwq().aeFs.setVisibility(8);
        AppMethodBeat.o(36274);
        return;
        ((r)localObject3).jwq().aeFr.setMute(false);
        break;
        label822:
        this.aeEw = false;
        this.aeEz = false;
        ((r)localObject3).jwq().aeFr.setVideoPath(localObject2);
        if ((((r)localObject3).jwq().aeFr instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)((r)localObject3).jwq().aeFr).setIOnlineCache(this.KSQ);
          ((VideoPlayerTextureView)((r)localObject3).jwq().aeFr).setNeedResetExtractor(dTa());
          ((VideoPlayerTextureView)((r)localObject3).jwq().aeFr).setIsOnlineVideoType(paramBoolean);
        }
        ((r)localObject3).d(true, 0.0F);
        break label740;
        com.tencent.mm.plugin.report.service.h.OAn.b(12084, new Object[] { Integer.valueOf(paramz.osy), Integer.valueOf(paramz.omT * 1000), Integer.valueOf(0), Integer.valueOf(3), paramz.bOs(), Integer.valueOf(i), z.PM(paramz.bOu()), Long.valueOf(paramz.createTime) });
        if (!com.tencent.mm.pluginsdk.k.b.a.a.d(localObject2, this.aeAg.aeAB.getContext(), bool)) {
          Toast.makeText(this.aeAg.aeAB.getContext(), this.aeAg.aeAB.getString(R.l.video_play_export_file_error), 0).show();
        }
      }
      label1065:
      Object localObject2 = localObject3;
    }
  }
  
  private void b(int paramInt, z paramz)
  {
    AppMethodBeat.i(36290);
    this.aeEs.put(paramInt, paramz);
    AppMethodBeat.o(36290);
  }
  
  private void b(cc paramcc, z paramz)
  {
    AppMethodBeat.i(36275);
    if ((!ah.eb(this.aeAg.aeAB.getContext())) && (!aeEA)) {
      aeEA = true;
    }
    c(paramcc, paramz);
    AppMethodBeat.o(36275);
  }
  
  private boolean b(a parama)
  {
    AppMethodBeat.i(36278);
    if (parama == null)
    {
      AppMethodBeat.o(36278);
      return false;
    }
    com.tencent.mm.modelvideo.v.bOh().a(this);
    if (this.aeAg.aeAB.getCurrentItem() == parama.pos)
    {
      parama = aCt(parama.pos);
      if (parama != null)
      {
        parama.jwq().aeFB.setVisibility(8);
        parama.jwq().aeFs.setVisibility(8);
        parama.jwq().aeFq.setVisibility(8);
      }
      this.aeEE = true;
      this.aeAg.aeAB.jvG();
      AppMethodBeat.o(36278);
      return true;
    }
    this.aeAg.aCG(parama.pos);
    AppMethodBeat.o(36278);
    return false;
  }
  
  private void c(cc paramcc, z paramz)
  {
    AppMethodBeat.i(36276);
    Log.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[] { Integer.valueOf(hashCode()) });
    if ((paramcc == null) || (paramz == null))
    {
      AppMethodBeat.o(36276);
      return;
    }
    r localr = this.aeAg.jve();
    if (localr == null)
    {
      AppMethodBeat.o(36276);
      return;
    }
    ac.am(paramcc);
    int i = this.aeAg.aeAB.An(paramcc.field_msgId);
    Log.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      Log.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36276);
      return;
    case 3: 
      Log.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i) });
    case 0: 
      if ((this.aeEt.bBq(paramcc.field_imgPath)) || (this.aeEt.e(paramcc, paramz)))
      {
        Log.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
        this.RgL = true;
        com.tencent.mm.modelvideo.v.bOh().a(this);
        localr.jwq().aeFq.setVisibility(8);
        localr.jwq().aeFs.setVisibility(8);
        localr.jwq().aeFB.setVisibility(0);
        AppMethodBeat.o(36276);
        return;
      }
      Log.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
      this.RgL = false;
      com.tencent.mm.modelvideo.v.bOh().a(this, Looper.getMainLooper());
      com.tencent.mm.modelvideo.ab.Qj(paramcc.field_imgPath);
      localr.jwq().aeFq.setVisibility(8);
      localr.jwq().aeFs.setVisibility(0);
      localr.jwq().aeFs.setProgress(com.tencent.mm.modelvideo.ab.g(paramz));
      AppMethodBeat.o(36276);
      return;
    }
    if (paramz.bOw())
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
      com.tencent.mm.modelvideo.ab.Qu(paramcc.field_imgPath);
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.v.bOh().a(this, Looper.getMainLooper());
      localr.jwq().aeFq.setVisibility(8);
      localr.jwq().aeFs.setVisibility(0);
      localr.jwq().aeFs.setProgress(com.tencent.mm.modelvideo.ab.g(paramz));
      if (i != 2) {
        break;
      }
      jwg();
      AppMethodBeat.o(36276);
      return;
      Log.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
      iU(paramcc.field_imgPath, 10);
      com.tencent.mm.modelvideo.ab.Qj(paramcc.field_imgPath);
    }
    jwf();
    AppMethodBeat.o(36276);
  }
  
  private void d(r paramr)
  {
    AppMethodBeat.i(36281);
    if (paramr == null)
    {
      AppMethodBeat.o(36281);
      return;
    }
    releaseWakeLock();
    hmt();
    Log.d("MicroMsg.Imagegallery.handler.video", "pause video.");
    if (paramr.jwq().aeFr.isPlaying())
    {
      paramr.jwq().aeFr.pause();
      hmI();
    }
    AppMethodBeat.o(36281);
  }
  
  private boolean dTa()
  {
    AppMethodBeat.i(36307);
    if (!this.RgL)
    {
      AppMethodBeat.o(36307);
      return false;
    }
    bh.bCz();
    boolean bool = c.ban().getBoolean(at.a.acPO, false);
    AppMethodBeat.o(36307);
    return bool;
  }
  
  private static void e(r paramr)
  {
    AppMethodBeat.i(36283);
    if ((paramr == null) || (paramr.jwq() == null))
    {
      AppMethodBeat.o(36283);
      return;
    }
    if (paramr.jwq().aeFr.isPlaying()) {
      r.bo(paramr.jwq().aeFq, 0);
    }
    AppMethodBeat.o(36283);
  }
  
  private boolean f(r paramr)
  {
    AppMethodBeat.i(36304);
    int i = this.Aqd;
    this.Aqd = paramr.jwq().aeFr.getCurrentPosition();
    int j;
    if (i != this.Aqd)
    {
      this.lastCheckTime = Util.nowMilliSecond();
      long l = paramr.jwq().aeFr.getLastSurfaceUpdateTime();
      if ((l > 0L) && (l != this.sJl))
      {
        this.sJl = l;
        j = this.aeEx;
        switch (j)
        {
        default: 
          this.aeEx = 0;
        }
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(36304);
        return true;
        i = 21;
        for (;;)
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), this.filename });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.b(13836, new Object[] { Integer.valueOf(301), Long.valueOf(Util.nowSecond()), "" });
          break;
          i = 22;
          continue;
          i = 23;
        }
        if (this.aeEx != -1)
        {
          this.aeEx += 1;
          Log.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[] { Integer.valueOf(this.aeEx), Integer.valueOf(this.aeEy) });
          if (this.aeEy >= 2) {
            this.aeEt.jwt();
          }
          switch (this.aeEx)
          {
          case 0: 
          case 1: 
          default: 
            Log.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
            Log.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[] { Integer.valueOf(hashCode()), this.filename });
            com.tencent.mm.plugin.report.service.h.OAn.b(13836, new Object[] { Integer.valueOf(300), Long.valueOf(Util.nowSecond()), "" });
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 20L, 1L, false);
            this.aeEx = -1;
          }
        }
      }
      i = this.Aqd / 1000;
      Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      bJ(i, true);
      this.aeEy += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.Aqd - 2000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      bJ(i, true);
      this.aeEy += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.Aqd - 4000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      bJ(i, true);
      this.aeEy += 1;
      AppMethodBeat.o(36304);
      return false;
      Log.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[] { Long.valueOf(this.lastCheckTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(i), Integer.valueOf(this.Aqd) });
    } while ((this.lastCheckTime <= 0L) || (Util.milliSecondsToNow(this.lastCheckTime) < 1500L));
    Log.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
    i = this.aeAg.jve().aeFr.getCurrentPosition();
    hmt();
    com.tencent.mm.modelvideo.ab.k(this.filename, i, this.RgL);
    this.aeAg.jve().aeFr.stop();
    this.aeEt.jwt();
    paramr = (a)this.aeCv.get(this.filename);
    if ((paramr == null) || (paramr.hzO == null))
    {
      AppMethodBeat.o(36304);
      return false;
    }
    z localz = dd(paramr.hzO);
    a(paramr.hzO, localz, paramr.pos, this.RgL);
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36304);
    return false;
  }
  
  private void hmH()
  {
    AppMethodBeat.i(36300);
    this.Rhh = Util.nowMilliSecond();
    Log.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[] { this.filename, Long.valueOf(this.Rhh) });
    if ((this.aeAg != null) && (this.aeAg.aeAB != null)) {
      this.aeAg.aeAB.aeCD.du(this.aeAg.jvd());
    }
    AppMethodBeat.o(36300);
  }
  
  private void hmI()
  {
    AppMethodBeat.i(36301);
    if (this.Rhh > 0L) {
      this.Rhi = ((int)(this.Rhi + (Util.nowMilliSecond() - this.Rhh) / 1000L));
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[] { this.filename, Integer.valueOf(this.Rhi) });
    this.Rhh = 0L;
    if ((this.aeAg != null) && (this.aeAg.aeAB != null)) {
      this.aeAg.aeAB.aeCD.dt(this.aeAg.jvd());
    }
    AppMethodBeat.o(36301);
  }
  
  private void hmt()
  {
    AppMethodBeat.i(36288);
    Log.i("MicroMsg.Imagegallery.handler.video", "clear timer");
    this.QTh.stopTimer();
    this.wCj.stopTimer();
    AppMethodBeat.o(36288);
  }
  
  private void iU(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(36277);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36253);
        com.tencent.mm.modelvideo.ab.bh(paramString, paramInt);
        AppMethodBeat.o(36253);
      }
    });
    AppMethodBeat.o(36277);
  }
  
  private void jwd()
  {
    AppMethodBeat.i(254478);
    if (this.aeAg == null)
    {
      AppMethodBeat.o(254478);
      return;
    }
    if (this.aeAg.aeAB == null)
    {
      AppMethodBeat.o(254478);
      return;
    }
    if (this.aeAg.aeAB.getWindow() == null)
    {
      AppMethodBeat.o(254478);
      return;
    }
    this.aeAg.aeAB.getWindow().clearFlags(128);
    AppMethodBeat.o(254478);
  }
  
  private void jwe()
  {
    AppMethodBeat.i(36293);
    try
    {
      this.aeAg.aeAB.jvo().SGW.setIplaySeekCallback(this.Aqj);
      AppMethodBeat.o(36293);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(36293);
    }
  }
  
  private static void jwf()
  {
    AppMethodBeat.i(36305);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 11L, 1L, false);
    AppMethodBeat.o(36305);
  }
  
  private static void jwg()
  {
    AppMethodBeat.i(36306);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 14L, 1L, false);
    AppMethodBeat.o(36306);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(36268);
    if ((this.mUJ != null) && (this.mUJ.isHeld()))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "release waklock");
      PowerManager.WakeLock localWakeLock = this.mUJ;
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler", "releaseWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      localWakeLock.release();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler", "releaseWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    AppMethodBeat.o(36268);
  }
  
  public final void a(aa.a.a parama)
  {
    AppMethodBeat.i(36292);
    Object localObject2 = parama.fileName;
    if ((Util.isNullOrNil((String)localObject2)) || (this.aeCv == null))
    {
      AppMethodBeat.o(36292);
      return;
    }
    parama = (a)this.aeCv.get(localObject2);
    if (parama == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    Object localObject1 = parama.hzO;
    if ((localObject1 == null) || (((fi)localObject1).field_imgPath == null) || (!((fi)localObject1).field_imgPath.equals(localObject2)))
    {
      AppMethodBeat.o(36292);
      return;
    }
    localObject2 = dd((cc)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    if (((!((cc)localObject1).dSI()) && (((cc)localObject1).isClean())) || (((z)localObject2).status == 198))
    {
      if (b(parama)) {
        Toast.makeText(this.aeAg.aeAB, R.l.gXE, 0).show();
      }
      AppMethodBeat.o(36292);
      return;
    }
    int i = com.tencent.mm.modelvideo.ab.g((z)localObject2);
    r localr = aCt(parama.pos);
    if ((this.aeAg.aeAB.getCurrentItem() == parama.pos) && (localr != null))
    {
      localr.jwq().aeFs.setVisibility(0);
      localr.jwq().aeFs.setProgress(i);
    }
    while (i < localr.jwq().aeFs.getMax())
    {
      AppMethodBeat.o(36292);
      return;
      if (localr == null)
      {
        AppMethodBeat.o(36292);
        return;
      }
    }
    Log.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[] { Integer.valueOf(((z)localObject2).status) });
    if (((((z)localObject2).status == 199) || (((z)localObject2).status == 199)) && (b(parama))) {
      i = this.aeAg.aeAB.An(((fi)localObject1).field_msgId);
    }
    switch (i)
    {
    default: 
      Log.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36292);
      return;
    case 0: 
    case 3: 
      a((cc)localObject1, (z)localObject2, this.aeAg.aeAB.getCurrentItem(), false);
      AppMethodBeat.o(36292);
      return;
    case 1: 
      Log.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 15L, 1L, false);
      this.aeAg.dm((cc)localObject1);
      this.aeAg.aeAB.Ao(-1L);
      if (this.RgL)
      {
        i = this.aeAg.jve().aeFr.getCurrentPosition();
        com.tencent.mm.modelvideo.ab.k(this.filename, i, this.RgL);
        this.aeEz = true;
      }
      this.RgL = false;
      AppMethodBeat.o(36292);
      return;
    case 2: 
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 16L, 1L, false);
      h.b(this.aeAg.aeAB, (cc)localObject1);
      this.aeAg.aeAB.Ao(-1L);
      if (this.RgL)
      {
        i = this.aeAg.jve().aeFr.getCurrentPosition();
        com.tencent.mm.modelvideo.ab.k(this.filename, i, this.RgL);
        this.aeEz = true;
      }
      this.RgL = false;
      AppMethodBeat.o(36292);
      return;
    }
    this.aeAg.aeAB.Ao(-1L);
    parama = this.aeAg.aeAB;
    Log.i("MicroMsg.ImageGalleryUI", "launchAppBrandIfNeed");
    if (parama.aeDM != null)
    {
      parama = parama.aeDM;
      Log.i("MicroMsg.ImageGalleryUI", "executePendingLaunchAppBrandTaskIfNeed");
      localObject1 = (ImageGalleryUI)parama.YtG.get();
      if (localObject1 == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "executePendingLaunchAppBrandTaskIfNeed, ui is null");
        AppMethodBeat.o(36292);
        return;
      }
      if ((parama.aeEp != null) && (parama.aeEq != null) && (parama.aeEq.equals(((ImageGalleryUI)localObject1).aeAg.jvd())))
      {
        Log.i("MicroMsg.ImageGalleryUI", "executePendingLaunchAppBrandTask");
        com.tencent.mm.plugin.appbrand.openmaterial.k.trz.an(parama.aeEp);
      }
      parama.aeEp = null;
      parama.aeEq = null;
    }
    AppMethodBeat.o(36292);
  }
  
  final void a(r paramr)
  {
    AppMethodBeat.i(36280);
    Log.i("MicroMsg.Imagegallery.handler.video", "stop");
    hmt();
    if (paramr == null)
    {
      AppMethodBeat.o(36280);
      return;
    }
    hmI();
    if (this.RgL) {
      this.aeEt.jws();
    }
    if (!this.aeEv) {
      com.tencent.mm.modelvideo.ab.k(this.filename, this.Aqd - 1000, this.RgL);
    }
    paramr.jwq().aeFs.setVisibility(8);
    paramr.jwq().aeFB.setVisibility(8);
    paramr.jwq().aeFr.stop();
    aCX(0);
    paramr.d(false, 0.0F);
    this.RgL = false;
    this.aeEE = false;
    this.aeEz = false;
    this.filename = null;
    this.Rhi = 0;
    this.Rhh = 0L;
    this.aeEF = 0;
    this.aeEC = 0;
    this.aeEy = 0;
    this.aeEx = 0;
    this.sJl = 0L;
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36280);
  }
  
  public final boolean a(r paramr, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(36262);
    super.a(paramr, paramcc, paramInt);
    Object localObject1 = de(paramcc);
    if (paramcc == null)
    {
      Log.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
      AppMethodBeat.o(36262);
      return false;
    }
    if (this.aeCv != null) {
      this.aeCv.put(paramcc.field_imgPath, new a(paramcc, paramInt));
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(36262);
      return false;
      Log.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
    }
    Object localObject2;
    if (paramcc.dSI())
    {
      localObject1 = dc(paramcc);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.pluginsdk.model.y.bpF(((com.tencent.mm.message.y)localObject1).nUM);
        com.tencent.mm.modelimage.loader.a locala = com.tencent.mm.modelimage.r.bKe();
        String str = ((com.tencent.mm.message.y)localObject1).nUM;
        ImageView localImageView = paramr.jwq().aeFp;
        c.a locala1 = new c.a();
        locala1.fullPath = ((String)localObject2);
        locala1.oKp = true;
        locala.a(str, localImageView, locala1.bKx());
        localObject2 = t.aeGb;
        paramcc = t.bBp(((com.tencent.mm.message.y)localObject1).Hl(paramcc.field_imgPath));
        if (paramcc.block == 1) {
          a(paramr, paramcc.aawp);
        }
      }
      else
      {
        if (paramr.jwq().aeFr.isPlaying()) {
          paramr.jwq().aeFr.stop();
        }
        if ((paramr.jwq().aeFr instanceof VideoPlayerTextureView))
        {
          if ((!aw.jkS()) && (!aw.ato())) {
            break label465;
          }
          ((VideoPlayerTextureView)paramr.jwq().aeFr).setScaleType(com.tencent.mm.pluginsdk.ui.i.e.XYM);
        }
      }
    }
    for (;;)
    {
      paramr.aeFt.setVisibility(8);
      paramr.jwq().aeFs.setVisibility(8);
      paramr.jwq().aeFB.setVisibility(8);
      paramr.d(false, 0.0F);
      this.aeEx = 0;
      this.RgP = Util.nowMilliSecond();
      AppMethodBeat.o(36262);
      return true;
      b(paramr);
      break;
      localObject1 = paramr.jwq().aeFp;
      Log.i("MicroMsg.Imagegallery.handler.video", "[+] [tomys] Easy crash pos, bitmap will be down sample to reduce mem cost.");
      com.tencent.mm.modelvideo.v.bOh();
      paramcc = com.tencent.mm.modelvideo.aa.PY(paramcc.field_imgPath);
      localObject2 = BackwardSupportUtil.BitmapFactory.decodeFileWithMemLimit(paramcc, 4194304);
      if (localObject2 != null) {
        Log.i("MicroMsg.Imagegallery.handler.video", "[+] [tomys] Bitmap decoded, file: %s, w: %s, h: %s", new Object[] { paramcc, Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
      }
      for (;;)
      {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
        b(paramr);
        break;
        Log.e("MicroMsg.Imagegallery.handler.video", "[-] [tomys] Fail to decode file: %s", new Object[] { paramcc });
      }
      label465:
      ((VideoPlayerTextureView)paramr.jwq().aeFr).setScaleType(com.tencent.mm.pluginsdk.ui.i.e.XYK);
    }
  }
  
  protected final void aCX(int paramInt)
  {
    AppMethodBeat.i(36298);
    paramInt = Math.max(0, paramInt);
    this.aeAg.aeAB.jvo().SGW.seek(paramInt);
    if ((this.aeEt != null) && (this.aeEt.oYz > 0L)) {
      this.aeAg.aeAB.jvo().SGW.axi((int)this.aeEt.oYz);
    }
    AppMethodBeat.o(36298);
  }
  
  public final void aCw(int paramInt)
  {
    AppMethodBeat.i(36291);
    this.aeEs.remove(paramInt);
    AppMethodBeat.o(36291);
  }
  
  public final void aCx(int paramInt)
  {
    AppMethodBeat.i(36267);
    d(aCt(paramInt));
    this.vZw.gR(false);
    this.aeAg.aeAB.setVideoStateIv(true);
    AppMethodBeat.o(36267);
  }
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  protected final void bBo(String paramString)
  {
    AppMethodBeat.i(36299);
    if ((!this.aeEE) && (!b((a)this.aeCv.get(paramString)))) {
      Log.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
    }
    AppMethodBeat.o(36299);
  }
  
  protected final void bJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36295);
    r localr = this.aeAg.jve();
    if (localr == null)
    {
      AppMethodBeat.o(36295);
      return;
    }
    hmH();
    localr.jwq().aeFB.setVisibility(8);
    localr.jwq().aeFr.c(paramInt * 1000, paramBoolean);
    this.aeAg.aeAB.setVideoStateIv(false);
    ho(false);
    AppMethodBeat.o(36295);
  }
  
  protected final void bNT()
  {
    AppMethodBeat.i(36296);
    r localr = this.aeAg.jve();
    if (localr == null)
    {
      AppMethodBeat.o(36296);
      return;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "start to pause");
    this.aeAg.aeAB.setVideoStateIv(true);
    localr.jwq().aeFB.setVisibility(0);
    localr.jwq().aeFr.pause();
    hmI();
    AppMethodBeat.o(36296);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36284);
    Log.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.RgQ = Util.nowMilliSecond();
    this.aeEB.removeMessages(1);
    hmt();
    this.aeEr.dead();
    this.aeED.dead();
    stopAll();
    this.aeAg.aeAB.getContext().getWindow().clearFlags(128);
    this.aeAg.aeAB.jvo().SGW.setIplaySeekCallback(null);
    super.detach();
    this.aeCv.clear();
    this.aeCv = null;
    com.tencent.mm.modelvideo.v.bOh().a(this);
    this.aeEs.clear();
    v localv = this.aeEt;
    localv.reset();
    localv.RhG = null;
    localv.aeGj = null;
    localv.aeGk = null;
    if (com.tencent.mm.plugin.u.f.gbB()) {
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36252);
          String str = com.tencent.mm.plugin.u.f.gbC();
          if (!Util.isNullOrNil(str))
          {
            com.tencent.mm.plugin.report.service.h.OAn.kvStat(14092, str);
            AppMethodBeat.o(36252);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(14092, "0");
          AppMethodBeat.o(36252);
        }
      });
    }
    com.tencent.mm.modelvideo.v.bOm().bOJ();
    com.tencent.mm.modelvideo.v.bOm().run();
    AppMethodBeat.o(36284);
  }
  
  public final void di(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254705);
    boolean bool2 = this.RgL;
    Object localObject = this.aeEt;
    boolean bool1;
    if ((!Util.isNullOrNil(((v)localObject).mediaId)) && (((v)localObject).oYs == 1))
    {
      bool1 = true;
      Log.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      jwd();
      this.aeEv = true;
      this.Aqc = paramInt2;
      if (!this.RgL) {
        break label285;
      }
      if (paramInt1 != -1) {
        break label197;
      }
      hmt();
      this.aeAg.jve().aeFr.stop();
      this.aeEt.jwt();
    }
    label197:
    do
    {
      for (;;)
      {
        this.aeEE = false;
        this.aeAg.aeAB.setVideoStateIv(true);
        this.aeAg.jve().jwq().aeFB.setVisibility(0);
        hmI();
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 18L, 1L, false);
        AppMethodBeat.o(254705);
        return;
        bool1 = false;
        break;
        if (paramInt1 != -2) {
          break label260;
        }
        hmt();
        paramInt1 = this.aeAg.jve().aeFr.getCurrentPosition();
        com.tencent.mm.modelvideo.ab.k(this.filename, paramInt1, this.RgL);
        this.aeAg.jve().aeFr.stop();
        this.aeEt.jwt();
      }
    } while (paramInt1 != -3);
    label260:
    this.aeEv = false;
    this.aeEt.jwt();
    AppMethodBeat.o(254705);
    return;
    label285:
    com.tencent.mm.modelvideo.ab.Qq(this.filename);
    hmI();
    if ((this.aeAg != null) && (this.aeAg.jve() != null) && (this.aeAg.jve().aeFr != null))
    {
      localObject = this.aeAg.jve().aeFr.getVideoPath();
      this.aeAg.jve().aeFr.stop();
    }
    while (this.aeEw)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(254705);
      return;
      localObject = "";
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36256);
        if ((p.this.aeAg == null) || (p.this.aeAg.jve() == null) || (p.l(p.this) == null))
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
          AppMethodBeat.o(36256);
          return;
        }
        p.this.aeAg.jve().d(false, 0.0F);
        if (!Util.isNullOrNil(this.Aqm)) {
          Log.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", new Object[] { this.Aqm });
        }
        try
        {
          Object localObject2 = new Intent();
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          FileProviderHelper.setIntentDataAndType(p.this.aeAg.aeAB, (Intent)localObject2, new u(this.Aqm), "video/*", false);
          Object localObject1 = p.this.aeAg.aeAB;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = (p.a)p.l(p.this).get(p.a(p.this));
          if ((localObject1 == null) || (((p.a)localObject1).hzO == null))
          {
            AppMethodBeat.o(36256);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
            com.tencent.mm.ui.base.k.s(p.this.aeAg.aeAB, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
          }
          p.this.aCw(localException.pos);
          AppMethodBeat.o(36256);
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 25L, 1L, false);
    AppMethodBeat.o(254705);
  }
  
  protected final void di(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(36294);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36248);
        Log.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if (p.l(p.this) == null)
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
          AppMethodBeat.o(36248);
          return;
        }
        p.a locala = (p.a)p.l(p.this).get(paramString);
        if ((locala == null) || (locala.hzO == null))
        {
          AppMethodBeat.o(36248);
          return;
        }
        z localz = g.dd(locala.hzO);
        if (p.this.aeAg.aeAB.getCurrentItem() == locala.pos)
        {
          p.a(p.this, locala.hzO, localz, locala.pos, paramBoolean);
          p.this.bBo(paramString);
          AppMethodBeat.o(36248);
          return;
        }
        Log.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[] { Integer.valueOf(p.this.aeAg.aeAB.getCurrentItem()), Integer.valueOf(locala.pos) });
        AppMethodBeat.o(36248);
      }
    });
    AppMethodBeat.o(36294);
  }
  
  protected final int getPlayVideoDuration()
  {
    AppMethodBeat.i(36302);
    if (this.Rhi < 0) {
      this.Rhi = 0;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[] { this.filename, Integer.valueOf(this.Rhi) });
    int i = this.Rhi;
    AppMethodBeat.o(36302);
    return i;
  }
  
  protected final int getUiStayTime()
  {
    AppMethodBeat.i(36303);
    if ((this.RgQ > 0L) && (this.RgP > 0L)) {}
    for (int i = (int)(this.RgQ - this.RgP);; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      Log.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[] { Integer.valueOf(hashCode()), this.filename, Integer.valueOf(j), Long.valueOf(this.RgQ), Long.valueOf(this.RgP) });
      AppMethodBeat.o(36303);
      return j;
    }
  }
  
  protected final boolean hmF()
  {
    AppMethodBeat.i(36297);
    r localr = this.aeAg.jve();
    if (localr == null)
    {
      AppMethodBeat.o(36297);
      return false;
    }
    boolean bool = true;
    if (!localr.jwq().aeFr.isPlaying())
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "start to play");
      this.aeAg.aeAB.setVideoStateIv(false);
      localr.jwq().aeFB.setVisibility(8);
      bool = localr.jwq().aeFr.start();
      hmH();
    }
    if (localr.jwq().aeFB.getVisibility() != 8) {
      localr.jwq().aeFB.setVisibility(8);
    }
    AppMethodBeat.o(36297);
    return bool;
  }
  
  protected final void ho(boolean paramBoolean)
  {
    AppMethodBeat.i(36289);
    if (!this.aeEv)
    {
      if (this.RgL)
      {
        if (paramBoolean)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36257);
              for (;;)
              {
                try
                {
                  if (!Util.isNullOrNil(p.this.aeAg.jve().jwq().aeFr.getVideoPath())) {
                    continue;
                  }
                  i = com.tencent.mm.modelvideo.ab.X(p.f(p.this).oYv, p.a(p.this));
                  p.f(p.this).xa(i);
                }
                catch (Exception localException)
                {
                  int i;
                  Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "start timer error[%s]", new Object[] { localException.toString() });
                  continue;
                }
                p.m(p.this).startTimer(500L);
                AppMethodBeat.o(36257);
                return;
                i = p.this.aeAg.jve().jwq().aeFr.getCurrentPosition() / 1000;
              }
            }
          });
          AppMethodBeat.o(36289);
          return;
        }
        this.QTh.startTimer(500L);
        AppMethodBeat.o(36289);
        return;
      }
      this.wCj.startTimer(500L);
    }
    AppMethodBeat.o(36289);
  }
  
  public final void juY()
  {
    AppMethodBeat.i(254694);
    this.aeEv = false;
    this.Aqc = 0;
    if (this.aeAg != null) {}
    for (Object localObject = this.aeAg.jve(); localObject == null; localObject = null)
    {
      Log.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
      AppMethodBeat.o(254694);
      return;
    }
    final int i = Util.videoMsToSec(((r)localObject).jwq().aeFr.getDuration());
    int j = this.aeAg.aeAB.jvo().SGW.getVideoTotalTime();
    Log.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    if ((j <= 0) || (Math.abs(j - i) >= 2)) {
      this.aeAg.aeAB.jvo().SGW.setVideoTotalTime(i);
    }
    jwe();
    if ((i == 0) || (i >= 1800))
    {
      Log.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      i = com.tencent.mm.modelvideo.ab.X(i, this.filename);
      Log.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[] { Boolean.valueOf(this.RgL), Integer.valueOf(i), Boolean.valueOf(this.aeEu), Boolean.valueOf(this.aeEv) });
      ((r)localObject).jwq().aeFr.setOneTimeVideoTextureUpdateCallback(this.RgB);
      if (!this.aeEu) {
        break label399;
      }
      if (this.RgL) {
        break label347;
      }
      this.aeEt.reset();
      hmH();
      bJ(i, true);
    }
    for (;;)
    {
      ho(false);
      AppMethodBeat.o(254694);
      return;
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36249);
          com.tencent.mm.modelvideo.ab.bg(p.a(p.this), i);
          AppMethodBeat.o(36249);
        }
      });
      break;
      label347:
      localObject = this.aeEt;
      if (i > 0)
      {
        Log.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(i)));
        ((v)localObject).oYw = i;
        ((v)localObject).oYy = true;
        ((v)localObject).oYt = 2;
      }
      this.aeEt.xa(0);
    }
    label399:
    if (!this.RgL) {
      bJ(i, false);
    }
    for (;;)
    {
      aCX(i);
      this.aeAg.aeAB.setVideoStateIv(true);
      hmt();
      AppMethodBeat.o(254694);
      return;
      this.aeEt.cL(i, false);
    }
  }
  
  public final void juZ()
  {
    AppMethodBeat.i(254699);
    Log.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.RgL);
    hmt();
    jwd();
    releaseWakeLock();
    hmI();
    Object localObject1;
    if ((this.RgL) && (this.aeAg != null) && (this.aeAg.jve() != null))
    {
      localObject1 = this.aeAg.jve().jwq().aeFr;
      if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.ui.tools.i)localObject1).getCurrentPosition() + 2000 < ((com.tencent.mm.pluginsdk.ui.tools.i)localObject1).getDuration())) {
        Log.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.i)localObject1).getCurrentPosition()), Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.i)localObject1).getDuration()) });
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36255);
            p.h(p.this);
            p.a(p.this, p.i(p.this));
            p.d(p.this).gR(false);
            p.j(p.this);
            if (p.c(p.this))
            {
              p.b(p.this, Util.nowMilliSecond());
              p.f(p.this).jws();
              p.f(p.this).reset();
              p.a(p.this, false);
              p.k(p.this);
            }
            com.tencent.mm.modelvideo.ab.k(p.a(p.this), 0, p.c(p.this));
            if (p.l(p.this) != null)
            {
              p.a locala = (p.a)p.l(p.this).get(p.a(p.this));
              if (locala != null)
              {
                r localr = p.this.aeAg.jve();
                localr.jwq().aeFr.stop();
                p.a(p.this, 0);
                p.this.a(localr, locala.hzO, locala.pos);
                p.this.aCX(0);
                if (localr.jwq().aeFB.getVisibility() != 8) {
                  localr.jwq().aeFB.setVisibility(8);
                }
              }
            }
            AppMethodBeat.o(36255);
          }
        });
        AppMethodBeat.o(254699);
        return;
      }
      try
      {
        i = this.aeAg.jve().aeFr.getCurrentPosition();
        com.tencent.mm.modelvideo.ab.k(this.filename, i, this.RgL);
        this.aeAg.jve().aeFr.stop();
        this.aeEt.jwt();
        i = this.aeEC + 1;
        this.aeEC = i;
        if (i <= 3)
        {
          localObject1 = (a)this.aeCv.get(this.filename);
          if (localObject1 != null)
          {
            localObject2 = ((a)localObject1).hzO;
            if (localObject2 != null) {}
          }
          else
          {
            AppMethodBeat.o(254699);
            return;
          }
          Object localObject2 = dd(((a)localObject1).hzO);
          a(((a)localObject1).hzO, (z)localObject2, ((a)localObject1).pos, this.RgL);
        }
        AppMethodBeat.o(254699);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "notify video completion error[%s]", new Object[] { localException.toString() });
        AppMethodBeat.o(254699);
        return;
      }
    }
  }
  
  public final void k(final cc paramcc, final int paramInt)
  {
    AppMethodBeat.i(36270);
    Log.i("MicroMsg.Imagegallery.handler.video", "toggle video");
    if (paramcc == null)
    {
      AppMethodBeat.o(36270);
      return;
    }
    if ((!h.m(paramcc)) && (!h.df(paramcc)))
    {
      AppMethodBeat.o(36270);
      return;
    }
    final z localz = de(paramcc);
    Object localObject1 = ae.pbN;
    localObject1 = ae.a.Qv(localz.bOu());
    int i;
    if ((localObject1 != null) && (((ae)localObject1).pbO))
    {
      localObject1 = aCt(paramInt);
      if (localObject1 != null) {
        r.bo(((r)localObject1).aeFq, 8);
      }
      if (cn.bDu() - paramcc.getCreateTime() > 432000000L)
      {
        this.aeAg.aeAB.bBj(this.aeAg.aeAB.getString(R.l.gRn));
        i = 1;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(36270);
      return;
      com.tencent.threadpool.h.ahAA.bk(new p..ExternalSyntheticLambda0(this));
      com.tencent.mm.modelvideo.v.bOh().a(new aa.a()
      {
        public final void a(aa.a.a paramAnonymousa)
        {
          AppMethodBeat.i(254661);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(254661);
            return;
          }
          if (!localz.getFileName().equals(paramAnonymousa.fileName))
          {
            AppMethodBeat.o(254661);
            return;
          }
          paramAnonymousa = com.tencent.mm.modelvideo.ab.Qo(paramAnonymousa.fileName);
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(254661);
            return;
          }
          ae.a locala = ae.pbN;
          paramAnonymousa = ae.a.Qv(paramAnonymousa.bOu());
          if (paramAnonymousa == null)
          {
            AppMethodBeat.o(254661);
            return;
          }
          if (!paramAnonymousa.pbO)
          {
            com.tencent.threadpool.h.ahAA.bk(new p.1..ExternalSyntheticLambda0(this, paramcc, paramInt));
            com.tencent.mm.modelvideo.v.bOh().a(this);
          }
          AppMethodBeat.o(254661);
        }
      }, Looper.getMainLooper());
      i = 1;
      continue;
      i = 0;
    }
    this.filename = localz.getFileName();
    if ((localz.status == 199) || (localz.status == 123)) {}
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (paramcc.dSI())
      {
        Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO toggle mp video,status : %d", new Object[] { Integer.valueOf(localz.status) });
        com.tencent.mm.modelvideo.v.bOh();
        localObject1 = com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath);
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!com.tencent.mm.vfs.y.ZC((String)localObject1))
          {
            bool2 = false;
            localz.status = 111;
            com.tencent.mm.modelvideo.v.bOh().c(localz);
            Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_WARN user delete local file,reset video info status");
          }
        }
      }
      if (!paramcc.dSI()) {
        break label647;
      }
      localObject1 = dc(paramcc);
      if (localObject1 != null) {
        break;
      }
      Log.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR mpShareVideoInfo is null");
      AppMethodBeat.o(36270);
      return;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "mpVideo videoDownload %b, playKey %s", new Object[] { Boolean.valueOf(bool2), ((com.tencent.mm.message.y)localObject1).Hl(paramcc.field_imgPath) });
    Object localObject2 = t.aeGb;
    localObject2 = t.ajV(((com.tencent.mm.message.y)localObject1).Hl(paramcc.field_imgPath));
    Object localObject3 = t.aeGb;
    localObject3 = t.bBp(((com.tencent.mm.message.y)localObject1).Hl(paramcc.field_imgPath));
    if (((drh)localObject3).block == 1)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO block video");
      a(aCt(paramInt), ((drh)localObject3).aawp);
      AppMethodBeat.o(36270);
      return;
    }
    b(aCt(paramInt));
    if ((!Util.isNullOrNil((String)localObject2)) && ((localz.osy <= 0) || (!((String)localObject2).equals(localz.pbk.nTu))))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  update video info. playUrl:%s, length:%d", new Object[] { localObject2, Integer.valueOf(((drh)localObject3).Zhu) });
      localz.pbk.nTu = ((String)localObject2);
      localz.osy = ((drh)localObject3).Zhu;
      com.tencent.mm.modelvideo.v.bOh().c(localz);
    }
    if ((a(localz, (com.tencent.mm.message.y)localObject1, paramcc, paramInt, bool2, this)) && (!bool2))
    {
      paramcc = aCt(paramInt);
      if ((paramcc != null) && (paramcc.jwq() != null))
      {
        paramcc.jwq().aeFq.setVisibility(8);
        paramcc.jwq().aeFB.setVisibility(0);
      }
      AppMethodBeat.o(36270);
      return;
      label647:
      b(aCt(paramInt));
    }
    if ((this.RgL) && (this.aeEt != null) && (this.aeEt.oYy))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36270);
      return;
    }
    if (this.aeAg.aeAB.fjy())
    {
      e(aCt(paramInt));
      d(aCt(paramInt));
      this.aeAg.aeAB.setVideoStateIv(true);
      this.aeAg.aeAB.Aqi.stopTimer();
      this.vZw.gR(false);
      releaseWakeLock();
      Log.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
      AppMethodBeat.o(36270);
      return;
    }
    bh.bCz();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.aa.j(this.aeAg.aeAB.getContext(), null);
      AppMethodBeat.o(36270);
      return;
    }
    int j;
    if (this.RgL)
    {
      j = 0;
      i = j;
    }
    for (;;)
    {
      try
      {
        if (this.aeAg.jve().aeFr != null) {
          i = this.aeAg.jve().aeFr.getCurrentPosition() / 1000;
        }
        if (this.aeEt != null) {
          if (this.aeEt.xb(i))
          {
            Log.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
            a(paramcc, localz, paramInt, this.RgL);
            if (this.aeAg.aeAB.aeDV) {
              this.aeAg.aeAB.jvR();
            }
            jwe();
            this.mUJ = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Imagegallery.handler.video");
            paramcc = this.mUJ;
            com.tencent.mm.hellhoundlib.a.a.b(paramcc, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler", "acuquireWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
            paramcc.acquire();
            com.tencent.mm.hellhoundlib.a.a.c(paramcc, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler", "acuquireWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
            Log.i("MicroMsg.Imagegallery.handler.video", "acquire wakelock");
            AppMethodBeat.o(36270);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
        i = j;
        continue;
        Log.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
        ho(false);
        continue;
        Log.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[] { Integer.valueOf(hashCode()) });
        continue;
      }
      if (paramcc.field_isSend == 0)
      {
        if ((localz.status != 113) && (localz.status != 198)) {
          break label1211;
        }
        b(paramcc, localz);
      }
      for (;;)
      {
        if (paramcc.field_isSend != 1) {
          break label1312;
        }
        i = localz.status;
        if ((i != 111) && (i != 113) && (i != 112) && (i != 121) && (i != 122)) {
          break label1314;
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[] { paramcc.field_talker, Integer.valueOf(i) });
        b(paramcc, localz);
        break;
        label1211:
        if (localz.status == 199) {
          a(paramcc, localz, paramInt, false);
        }
        if (localz.status == 111) {
          b(paramcc, localz);
        }
        if (localz.status == 112) {
          b(paramcc, localz);
        }
        if ((localz.status == 121) || (localz.status == 122)) {
          b(paramcc, localz);
        }
        if (localz.status == 123) {
          a(paramcc, localz, paramInt, false);
        }
      }
      label1312:
      continue;
      label1314:
      a(paramcc, localz, paramInt, false);
    }
  }
  
  public final void l(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(36273);
    Log.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
    z localz = com.tencent.mm.modelvideo.ab.Qo(paramcc.field_imgPath);
    if ((localz != null) && (!localz.bOx()))
    {
      d(aCt(paramInt));
      this.aeAg.aeAB.setVideoStateIv(true);
      if (this.RgL)
      {
        this.aeEt.jws();
        this.aeEt.reset();
      }
      b(paramcc, localz);
      if (this.aeAg.aeAB.An(paramcc.field_msgId) == 2)
      {
        iU(paramcc.field_imgPath, 8);
        AppMethodBeat.o(36273);
        return;
      }
      iU(paramcc.field_imgPath, 5);
    }
    AppMethodBeat.o(36273);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(254681);
    this.aeEB.sendEmptyMessageDelayed(1, 200L);
    AppMethodBeat.o(254681);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(36282);
    Log.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
    this.aeEB.removeMessages(1);
    this.aeED.alive();
    if ((this.aeAg != null) && (com.tencent.mm.compatible.util.d.rb(21)))
    {
      r localr = this.aeAg.jve();
      if ((localr != null) && (localr.aeFr != null))
      {
        if ((localr.aeFr instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)localr.aeFr).cxp();
          AppMethodBeat.o(36282);
          return;
        }
        if ((localr.aeFr instanceof VideoTextureView)) {
          ((VideoTextureView)localr.aeFr).cxp();
        }
      }
    }
    AppMethodBeat.o(36282);
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(36279);
    Log.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
    this.RgQ = Util.nowMilliSecond();
    SparseArray localSparseArray = this.aeAg.adVc;
    int j = 0;
    int i = 0;
    if (j < localSparseArray.size())
    {
      int k = localSparseArray.keyAt(j);
      if ((localSparseArray.get(k) == null) || (((View)localSparseArray.get(k)).getTag() == null)) {
        break label253;
      }
      r localr = (r)((View)localSparseArray.get(k)).getTag();
      if ((localr.aeFo == null) || (localr.jwq().aeFo.getVisibility() != 0) || ((((View)localr.jwq().aeFr).getVisibility() != 0) && (Util.isNullOrNil(localr.jwq().aeFr.getVideoPath())) && ((!this.RgL) || (!this.aeEt.isStreaming())))) {
        break label253;
      }
      a(localr);
      i = 1;
    }
    label253:
    for (;;)
    {
      j += 1;
      break;
      this.vZw.gR(false);
      if ((i == 0) && (this.RgL))
      {
        this.aeEt.jws();
        this.RgL = false;
      }
      hmt();
      this.aeEs.clear();
      releaseWakeLock();
      AppMethodBeat.o(36279);
      return;
    }
  }
  
  public static final class a
  {
    public cc hzO;
    public int pos;
    
    public a(cc paramcc, int paramInt)
    {
      this.hzO = paramcc;
      this.pos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.p
 * JD-Core Version:    0.7.0.1
 */