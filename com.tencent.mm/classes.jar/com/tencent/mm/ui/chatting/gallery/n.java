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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.f.a.pn;
import com.tencent.mm.f.a.pn.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.ac.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.appbrand.openmaterial.l;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.event.EventCenter;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.al.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class n
  extends e
  implements d.a, x.a
{
  public static boolean WUP = false;
  private com.tencent.mm.plugin.u.b EXe;
  private long KHG;
  private int KHH;
  private k.e KHb;
  private boolean KHl;
  private long KHp;
  private long KHq;
  private MTimerHandler Kux;
  private HashMap<String, a> WSS;
  private IListener WUG;
  final SparseArray<com.tencent.mm.modelvideo.w> WUH;
  private t WUI;
  private boolean WUJ;
  private boolean WUK;
  private boolean WUL;
  private int WUM;
  private int WUN;
  private boolean WUO;
  MMHandler WUQ;
  private int WUR;
  private IListener<pn> WUS;
  private boolean WUT;
  private int WUU;
  private int[] WUV;
  private String filename;
  private PowerManager.WakeLock kqO;
  private long lastCheckTime;
  private long pDZ;
  private com.tencent.mm.model.d sUi;
  private MTimerHandler txN;
  private int wTA;
  private com.tencent.mm.plugin.sight.decode.ui.b wTG;
  int wTz;
  
  public n(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(36261);
    this.WUH = new SparseArray();
    this.WUJ = false;
    this.WUK = false;
    this.WUL = false;
    this.wTA = 0;
    this.pDZ = 0L;
    this.lastCheckTime = 0L;
    this.WUM = 0;
    this.WUN = 0;
    this.KHp = 0L;
    this.KHq = 0L;
    this.wTz = 0;
    this.WUO = false;
    this.WUQ = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(272025);
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = n.this.WQM.hRG();
          if ((paramAnonymousMessage != null) && (!Util.isNullOrNil(n.a(n.this))))
          {
            Log.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", new Object[] { Integer.valueOf(hashCode()), n.a(n.this) });
            if (!n.b(n.this)) {
              com.tencent.mm.modelvideo.y.j(n.a(n.this), paramAnonymousMessage.hSL().WVL.getCurrentPosition(), n.c(n.this));
            }
            n.g(paramAnonymousMessage);
            n.a(n.this, paramAnonymousMessage);
            n.d(n.this).fZ(false);
            if (n.c(n.this))
            {
              EventCenter.instance.removeListener(n.e(n.this));
              n.f(n.this).hSP();
              n.a(n.this, false);
            }
          }
          n.g(n.this);
        }
        AppMethodBeat.o(272025);
        return false;
      }
    });
    this.WUR = 0;
    this.Kux = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(282391);
        if (!n.f(n.this).isStreaming())
        {
          AppMethodBeat.o(282391);
          return false;
        }
        p localp = n.this.WQM.hRG();
        if (localp == null)
        {
          AppMethodBeat.o(282391);
          return false;
        }
        if (localp.WVI == null)
        {
          AppMethodBeat.o(282391);
          return false;
        }
        if (localp.hSL().WVI.getVisibility() != 0)
        {
          AppMethodBeat.o(282391);
          return false;
        }
        boolean bool = true;
        if (localp.hSL().WVL.isPlaying()) {
          bool = n.b(n.this, localp);
        }
        if (bool)
        {
          int i = localp.hSL().WVL.getCurrentPosition() / 1000;
          bool = n.f(n.this).xa(i);
          AppMethodBeat.o(282391);
          return bool;
        }
        AppMethodBeat.o(282391);
        return false;
      }
    }, true);
    this.txN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36258);
        if (n.this.WQM == null)
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
          AppMethodBeat.o(36258);
          return false;
        }
        p localp = n.this.WQM.hRG();
        if (localp == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localp.WVI == null)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        if (localp.hSL().WVI.getVisibility() != 0)
        {
          AppMethodBeat.o(36258);
          return false;
        }
        int i = n.this.WQM.WQV.getCurrentItem();
        if ((com.tencent.mm.modelvideo.w)n.this.WUH.get(i) == null)
        {
          n.this.avQ(i);
          AppMethodBeat.o(36258);
          return false;
        }
        if (!localp.hSL().WVL.isPlaying())
        {
          Log.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
          AppMethodBeat.o(36258);
          return false;
        }
        n.a(n.this, localp.hSL().WVL.getCurrentPosition());
        n.this.awn(n.n(n.this) / 1000);
        AppMethodBeat.o(36258);
        return true;
      }
    }, true);
    this.wTG = new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aRo()
      {
        AppMethodBeat.i(291541);
        if (n.this.WQM.hRG() != null) {
          n.a(n.this, n.this.WQM.hRG());
        }
        n.this.WQM.WQV.wTF.stopTimer();
        AppMethodBeat.o(291541);
      }
      
      public final void tY(int paramAnonymousInt)
      {
        AppMethodBeat.i(291542);
        localObject = null;
        try
        {
          String str = n.this.WQM.hRG().hSL().WVL.getVideoPath();
          localObject = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
            Log.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + localException.toString());
            continue;
            boolean bool = n.f(n.this).bY(paramAnonymousInt, true);
            continue;
            localObject = n.this.WQM.hRF();
            if ((localObject != null) && (((ca)localObject).dlR())) {
              com.tencent.mm.modelvideo.y.j(((et)localObject).field_imgPath, paramAnonymousInt * 1000, n.c(n.this));
            }
            n.this.WQM.avV(n.this.WQM.WQV.getCurrentItem());
          }
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(n.c(n.this)), localObject });
        n.this.WQM.hRG().hSL().WVK.setVisibility(8);
        if (!Util.isNullOrNil((String)localObject)) {
          if (!n.c(n.this))
          {
            n.this.bc(paramAnonymousInt, true);
            bool = true;
            if (bool) {
              n.this.gA(false);
            }
            n.this.WQM.WQV.hSs();
            localObject = n.this.WQM.hRF();
            if ((localObject != null) && (((ca)localObject).dlS())) {
              n.this.WQM.WQV.WTa.n((ca)localObject, 13);
            }
            AppMethodBeat.o(291542);
            return;
          }
        }
      }
    };
    this.WUS = new IListener()
    {
      private boolean a(pn paramAnonymouspn)
      {
        AppMethodBeat.i(285695);
        if (!n.f(n.this).bbW(paramAnonymouspn.fOh.mediaId))
        {
          AppMethodBeat.o(285695);
          return false;
        }
        if ((paramAnonymouspn.fOh.retCode != 0) && (paramAnonymouspn.fOh.retCode != -21006))
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + paramAnonymouspn.fOh.retCode);
          n.a(n.this, paramAnonymouspn.fOh.mediaId, paramAnonymouspn.fOh.retCode);
          AppMethodBeat.o(285695);
          return false;
        }
        switch (paramAnonymouspn.fOh.fDn)
        {
        default: 
          Log.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + paramAnonymouspn.fOh.fDn);
        }
        for (;;)
        {
          AppMethodBeat.o(285695);
          return false;
          t localt = n.f(n.this);
          long l2 = paramAnonymouspn.fOh.offset;
          long l1 = paramAnonymouspn.fOh.fOi;
          boolean bool = paramAnonymouspn.fOh.fOj;
          Log.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", new Object[] { Long.valueOf(l2), Integer.valueOf(localt.mfA), Integer.valueOf(localt.mfz), Long.valueOf(l1), Long.valueOf(localt.iVa) });
          if (localt.mfz != 0) {
            Log.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
          }
          for (;;)
          {
            n.a(n.this, true);
            break;
            if (l1 > localt.iVa) {}
            for (;;)
            {
              for (;;)
              {
                localt.iVa = l1;
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 5L, 1L, false);
                localt.KIk = Util.nowMilliSecond();
                s.bqB();
                paramAnonymouspn = com.tencent.mm.modelvideo.x.XT(localt.filename);
                try
                {
                  if (localt.KIg != null) {
                    break label435;
                  }
                  Log.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                }
                catch (Exception paramAnonymouspn)
                {
                  Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", paramAnonymouspn, "", new Object[0]);
                  Log.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + paramAnonymouspn.toString());
                }
              }
              break;
              l1 = localt.iVa;
            }
            label435:
            if (localt.KIg.K(paramAnonymouspn, l2))
            {
              localt.mfz = localt.KIg.mHG;
              Log.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", new Object[] { Integer.valueOf(localt.mfz), localt.filename, Boolean.valueOf(bool) });
              if (!bool) {
                MMHandlerThread.postToMainThread(new t.1(localt));
              }
              if (localt.mfA == -1) {}
              for (localt.mfx = 1;; localt.mfx = 2)
              {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 7L, 1L, false);
                break;
              }
            }
            Log.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
            s.bqC();
            com.tencent.mm.aq.e.s(localt.mediaId, 0, -1);
            com.tencent.mm.modelvideo.y.aR(localt.filename, 15);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 8L, 1L, false);
            Log.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", new Object[] { Integer.valueOf(localt.hashCode()), localt.filename });
            com.tencent.mm.plugin.report.service.h.IzE.a(13836, new Object[] { Integer.valueOf(302), Long.valueOf(Util.nowSecond()), "" });
          }
          localt = n.f(n.this);
          Object localObject = paramAnonymouspn.fOh.mediaId;
          int i = paramAnonymouspn.fOh.offset;
          int j = paramAnonymouspn.fOh.length;
          localt.mfG = false;
          if ((i < 0) || (j < 0)) {
            Log.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          }
          while (!localt.bbW((String)localObject))
          {
            if (paramAnonymouspn.fOh.length <= 0) {
              break;
            }
            n.this.gA(true);
            break;
          }
          localObject = localt.mediaId + i + "_" + j;
          localObject = (Integer)localt.KIf.get(localObject);
          if ((localObject != null) && (((Integer)localObject).intValue() > 0)) {
            localt.mfD = ((Integer)localObject).intValue();
          }
          for (;;)
          {
            Log.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localt.mfD) });
            break;
            try
            {
              localt.mfD = localt.KIg.ee(i, j);
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
              Log.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + localException.toString());
            }
          }
          n.this.gA(true);
          continue;
          paramAnonymouspn = n.f(n.this);
          Log.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", new Object[] { Integer.valueOf(paramAnonymouspn.mfx) });
          paramAnonymouspn.mfG = false;
          paramAnonymouspn.mfw = 3;
          if (paramAnonymouspn.mfx == 0)
          {
            Log.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
            paramAnonymouspn.fUE();
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 6L, 1L, false);
          }
          for (;;)
          {
            paramAnonymouspn.gnS();
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 26L, 1L, false);
            n.this.gA(true);
            break;
            if (paramAnonymouspn.mfx == 5)
            {
              Log.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + paramAnonymouspn.mediaId);
              paramAnonymouspn.fUE();
            }
          }
          localt = n.f(n.this);
          String str = paramAnonymouspn.fOh.mediaId;
          i = paramAnonymouspn.fOh.offset;
          if (localt.bbW(str))
          {
            if (localt.nEz != 0) {
              localt.KIi = (i * 100 / localt.nEz);
            }
            Log.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + localt.KIi);
          }
          if (localt.KIi >= 100)
          {
            localt.mfw = 3;
            continue;
            paramAnonymouspn = n.f(n.this);
            Log.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
            paramAnonymouspn.gnS();
            paramAnonymouspn.fUE();
          }
        }
      }
    };
    this.WUT = false;
    this.WUU = 0;
    this.WUV = new int[] { -1000, -2000, 3400 };
    this.KHb = new k.e()
    {
      public final void bXh()
      {
        AppMethodBeat.i(290560);
        Log.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[] { Integer.valueOf(n.this.hashCode()) });
        try
        {
          n.this.WQM.hRG().d(true, 1.0F);
          AppMethodBeat.o(290560);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + localException.toString());
          AppMethodBeat.o(290560);
        }
      }
    };
    this.EXe = new com.tencent.mm.plugin.u.b()
    {
      public final long eSG()
      {
        AppMethodBeat.i(266403);
        Log.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[] { Integer.valueOf(n.this.hashCode()) });
        bh.beI();
        c.aHp().set(ar.a.Vos, Boolean.TRUE);
        try
        {
          if ((n.c(n.this)) && (n.f(n.this) != null))
          {
            int i = n.f(n.this).mfD;
            long l = i;
            AppMethodBeat.o(266403);
            return l;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(266403);
        }
        return 0L;
      }
    };
    this.WSS = new HashMap();
    this.WUI = new t(this);
    EventCenter localEventCenter = EventCenter.instance;
    paramf = new al(al.a.WDV, paramf.WQV);
    this.WUG = paramf;
    localEventCenter.addListener(paramf);
    EventCenter.instance.addListener(this.WUS);
    this.sUi = com.tencent.mm.model.d.bcs();
    AppMethodBeat.o(36261);
  }
  
  private void a(ca paramca, com.tencent.mm.modelvideo.w paramw)
  {
    AppMethodBeat.i(36275);
    if ((!ag.dj(this.WQM.WQV.getContext())) && (!WUP)) {
      WUP = true;
    }
    b(paramca, paramw);
    AppMethodBeat.o(36275);
  }
  
  private void a(ca paramca, com.tencent.mm.modelvideo.w paramw, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36274);
    if ((paramca == null) || (paramw == null))
    {
      AppMethodBeat.o(36274);
      return;
    }
    if ((!paramca.dlS()) && (paramca.Ic()))
    {
      Toast.makeText(this.WQM.WQV, R.l.eUF, 0).show();
      AppMethodBeat.o(36274);
      return;
    }
    Object localObject3;
    Object localObject1;
    if (paramw.mhX == -1)
    {
      localObject3 = paramw.bqN();
      localObject1 = localObject3;
      if (!u.agG((String)localObject3))
      {
        s.bqB();
        localObject1 = com.tencent.mm.modelvideo.x.XT(paramca.field_imgPath);
        if ((localObject1 != null) && (u.agG((String)localObject1))) {
          break label336;
        }
        Toast.makeText(this.WQM.WQV, R.l.eUF, 0).show();
        AppMethodBeat.o(36274);
      }
    }
    else
    {
      s.bqB();
      localObject3 = com.tencent.mm.modelvideo.x.XT(paramca.field_imgPath);
      localObject1 = localObject3;
      if (paramca.field_isSend == 1)
      {
        localObject1 = localObject3;
        if (paramw.mia != null)
        {
          localObject1 = localObject3;
          if (!paramw.mia.TCA) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        String str = u.bBT((String)localObject3);
        localObject1 = str;
        if (!str.endsWith("/")) {
          localObject1 = str + "/";
        }
        str = u.bBW((String)localObject3);
        localObject1 = (String)localObject1 + str + "_hd.mp4";
        bool = u.agG((String)localObject1);
        Log.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[] { localObject1, Boolean.valueOf(bool) });
        if (!bool) {
          break label1074;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[] { localException.getMessage() });
        localObject2 = localObject3;
      }
      break;
      label336:
      localObject3 = avN(paramInt);
      if (localObject3 == null)
      {
        AppMethodBeat.o(36274);
        return;
      }
      int i = 0;
      if (com.tencent.mm.model.ab.Lj(paramw.bqM())) {
        i = com.tencent.mm.model.v.Pu(paramw.bqM());
      }
      boolean bool = com.tencent.mm.modelvideo.v.XI(localObject2);
      int j = this.WQM.WQV.Wc(paramca.field_msgId);
      Log.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Boolean.valueOf(this.WUO) });
      if (!bool)
      {
        if ((af.juS.jrd == 1) && (com.tencent.mm.pluginsdk.l.b.a.a.b(paramw.getFileName(), this.WQM.WQV.getContext(), bool)))
        {
          AppMethodBeat.o(36274);
          return;
        }
        bh.beI();
        if ((((Integer)c.aHp().get(ar.a.VmY, Integer.valueOf(0))).intValue() == 1) && (((p)localObject3).WVN != null))
        {
          ((p)localObject3).WVN.setVisibility(0);
          ((p)localObject3).WVN.setText(com.tencent.mm.plugin.sight.base.f.aPw(localObject2));
        }
        ((p)localObject3).a(paramw.lvw, paramw.lAW, i, paramw.bqM(), com.tencent.mm.modelvideo.w.XK(paramw.bqO()), paramw.createTime);
        this.KHl = paramBoolean;
        this.WUJ = true;
        this.filename = paramw.getFileName();
        if (j == 3)
        {
          ((p)localObject3).hSL().WVL.setMute(true);
          if ((((p)localObject3).hSL().WVL.getVideoPath() == null) || (!((p)localObject3).hSL().WVL.getVideoPath().equals(localObject2)) || (((p)localObject3).hSL().WVL.isPlaying()) || (this.WUO)) {
            break label822;
          }
          ((p)localObject3).d(true, 1.0F);
          ((p)localObject3).hSL().WVL.start();
          fUn();
          if (!paramBoolean) {
            bzA(this.filename);
          }
          awn(((p)localObject3).hSL().WVL.getCurrentPosition() / 1000);
          gA(false);
          label740:
          b(paramInt, paramw);
          this.WQM.WQV.setVideoStateIv(false);
          this.WQM.WQV.getContext().getWindow().addFlags(128);
          this.sUi.a(this);
        }
      }
      for (;;)
      {
        ((p)localObject3).hSL().WVM.setVisibility(8);
        AppMethodBeat.o(36274);
        return;
        ((p)localObject3).hSL().WVL.setMute(false);
        break;
        label822:
        this.WUL = false;
        this.WUO = false;
        ((p)localObject3).hSL().WVL.setVideoPath(localObject2);
        if ((((p)localObject3).hSL().WVL instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)((p)localObject3).hSL().WVL).setIOnlineCache(this.EXe);
          ((VideoPlayerTextureView)((p)localObject3).hSL().WVL).setNeedResetExtractor(dmk());
          ((VideoPlayerTextureView)((p)localObject3).hSL().WVL).setIsOnlineVideoType(paramBoolean);
        }
        ((p)localObject3).d(true, 0.0F);
        break label740;
        com.tencent.mm.plugin.report.service.h.IzE.a(12084, new Object[] { Integer.valueOf(paramw.lAW), Integer.valueOf(paramw.lvw * 1000), Integer.valueOf(0), Integer.valueOf(3), paramw.bqM(), Integer.valueOf(i), com.tencent.mm.modelvideo.w.XK(paramw.bqO()), Long.valueOf(paramw.createTime) });
        if (!com.tencent.mm.pluginsdk.l.b.a.a.c(localObject2, this.WQM.WQV.getContext(), bool)) {
          Toast.makeText(this.WQM.WQV.getContext(), this.WQM.WQV.getString(R.l.video_play_export_file_error), 0).show();
        }
      }
      label1074:
      Object localObject2 = localObject3;
    }
  }
  
  private void b(int paramInt, com.tencent.mm.modelvideo.w paramw)
  {
    AppMethodBeat.i(36290);
    this.WUH.put(paramInt, paramw);
    AppMethodBeat.o(36290);
  }
  
  private void b(ca paramca, com.tencent.mm.modelvideo.w paramw)
  {
    AppMethodBeat.i(36276);
    Log.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[] { Integer.valueOf(hashCode()) });
    if ((paramca == null) || (paramw == null))
    {
      AppMethodBeat.o(36276);
      return;
    }
    p localp = this.WQM.hRG();
    if (localp == null)
    {
      AppMethodBeat.o(36276);
      return;
    }
    com.tencent.mm.modelsimple.ab.ah(paramca);
    int i = this.WQM.WQV.Wc(paramca.field_msgId);
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
      if ((this.WUI.bzC(paramca.field_imgPath)) || (this.WUI.d(paramca, paramw)))
      {
        Log.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
        this.KHl = true;
        s.bqB().a(this);
        localp.hSL().WVK.setVisibility(8);
        localp.hSL().WVM.setVisibility(8);
        localp.hSL().WVV.setVisibility(0);
        AppMethodBeat.o(36276);
        return;
      }
      Log.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
      this.KHl = false;
      s.bqB().a(this, Looper.getMainLooper());
      com.tencent.mm.modelvideo.y.Yf(paramca.field_imgPath);
      localp.hSL().WVK.setVisibility(8);
      localp.hSL().WVM.setVisibility(0);
      localp.hSL().WVM.setProgress(com.tencent.mm.modelvideo.y.g(paramw));
      AppMethodBeat.o(36276);
      return;
    }
    if (paramw.bqR())
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
      com.tencent.mm.modelvideo.y.Yq(paramca.field_imgPath);
    }
    for (;;)
    {
      s.bqB().a(this, Looper.getMainLooper());
      localp.hSL().WVK.setVisibility(8);
      localp.hSL().WVM.setVisibility(0);
      localp.hSL().WVM.setProgress(com.tencent.mm.modelvideo.y.g(paramw));
      if (i != 2) {
        break;
      }
      hSC();
      AppMethodBeat.o(36276);
      return;
      Log.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
      hN(paramca.field_imgPath, 10);
      com.tencent.mm.modelvideo.y.Yf(paramca.field_imgPath);
    }
    hSB();
    AppMethodBeat.o(36276);
  }
  
  private boolean b(a parama)
  {
    AppMethodBeat.i(36278);
    if (parama == null)
    {
      AppMethodBeat.o(36278);
      return false;
    }
    s.bqB().a(this);
    if (this.WQM.WQV.getCurrentItem() == parama.pos)
    {
      parama = avN(parama.pos);
      if (parama != null)
      {
        parama.hSL().WVV.setVisibility(8);
        parama.hSL().WVM.setVisibility(8);
        parama.hSL().WVK.setVisibility(8);
      }
      this.WUT = true;
      this.WQM.WQV.hSg();
      AppMethodBeat.o(36278);
      return true;
    }
    this.WQM.avX(parama.pos);
    AppMethodBeat.o(36278);
    return false;
  }
  
  private void d(p paramp)
  {
    AppMethodBeat.i(36281);
    if (paramp == null)
    {
      AppMethodBeat.o(36281);
      return;
    }
    releaseWakeLock();
    fTZ();
    Log.d("MicroMsg.Imagegallery.handler.video", "pause video.");
    if (paramp.hSL().WVL.isPlaying())
    {
      paramp.hSL().WVL.pause();
      fUo();
    }
    AppMethodBeat.o(36281);
  }
  
  private boolean dmk()
  {
    AppMethodBeat.i(36307);
    if (!this.KHl)
    {
      AppMethodBeat.o(36307);
      return false;
    }
    bh.beI();
    boolean bool = c.aHp().getBoolean(ar.a.Vos, false);
    AppMethodBeat.o(36307);
    return bool;
  }
  
  private static void e(p paramp)
  {
    AppMethodBeat.i(36283);
    if (paramp != null)
    {
      paramp.hSL();
      if (paramp.hSL().WVL.isPlaying()) {
        p.aR(paramp.hSL().WVK, 0);
      }
      AppMethodBeat.o(36283);
      return;
    }
    AppMethodBeat.o(36283);
  }
  
  private boolean f(p paramp)
  {
    AppMethodBeat.i(36304);
    int i = this.wTA;
    this.wTA = paramp.hSL().WVL.getCurrentPosition();
    int j;
    if (i != this.wTA)
    {
      this.lastCheckTime = Util.nowMilliSecond();
      long l = paramp.hSL().WVL.getLastSurfaceUpdateTime();
      if ((l > 0L) && (l != this.pDZ))
      {
        this.pDZ = l;
        j = this.WUM;
        switch (j)
        {
        default: 
          this.WUM = 0;
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
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, i, 1L, false);
          com.tencent.mm.plugin.report.service.h.IzE.a(13836, new Object[] { Integer.valueOf(301), Long.valueOf(Util.nowSecond()), "" });
          break;
          i = 22;
          continue;
          i = 23;
        }
        if (this.WUM != -1)
        {
          this.WUM += 1;
          Log.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", new Object[] { Integer.valueOf(this.WUM), Integer.valueOf(this.WUN) });
          if (this.WUN >= 2) {
            this.WUI.hSQ();
          }
          switch (this.WUM)
          {
          case 0: 
          case 1: 
          default: 
            Log.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
            Log.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", new Object[] { Integer.valueOf(hashCode()), this.filename });
            com.tencent.mm.plugin.report.service.h.IzE.a(13836, new Object[] { Integer.valueOf(300), Long.valueOf(Util.nowSecond()), "" });
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 20L, 1L, false);
            this.WUM = -1;
          }
        }
      }
      i = this.wTA / 1000;
      Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      bc(i, true);
      this.WUN += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.wTA - 2000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      bc(i, true);
      this.WUN += 1;
      AppMethodBeat.o(36304);
      return false;
      j = (this.wTA - 4000) / 1000;
      i = j;
      if (j < 0) {
        i = 0;
      }
      Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", new Object[] { Integer.valueOf(i) });
      bc(i, true);
      this.WUN += 1;
      AppMethodBeat.o(36304);
      return false;
      Log.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", new Object[] { Long.valueOf(this.lastCheckTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(i), Integer.valueOf(this.wTA) });
    } while ((this.lastCheckTime <= 0L) || (Util.milliSecondsToNow(this.lastCheckTime) < 1500L));
    Log.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
    i = this.WQM.hRG().WVL.getCurrentPosition();
    fTZ();
    com.tencent.mm.modelvideo.y.j(this.filename, i, this.KHl);
    this.WQM.hRG().WVL.stop();
    this.WUI.hSQ();
    paramp = (a)this.WSS.get(this.filename);
    if ((paramp == null) || (paramp.fvt == null))
    {
      AppMethodBeat.o(36304);
      return false;
    }
    com.tencent.mm.modelvideo.w localw = cH(paramp.fvt);
    a(paramp.fvt, localw, paramp.pos, this.KHl);
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36304);
    return false;
  }
  
  private void fTZ()
  {
    AppMethodBeat.i(36288);
    Log.i("MicroMsg.Imagegallery.handler.video", "clear timer");
    this.Kux.stopTimer();
    this.txN.stopTimer();
    AppMethodBeat.o(36288);
  }
  
  private void fUn()
  {
    AppMethodBeat.i(36300);
    this.KHG = Util.nowMilliSecond();
    Log.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[] { this.filename, Long.valueOf(this.KHG) });
    if ((this.WQM != null) && (this.WQM.WQV != null)) {
      this.WQM.WQV.WTa.cX(this.WQM.hRF());
    }
    AppMethodBeat.o(36300);
  }
  
  private void fUo()
  {
    AppMethodBeat.i(36301);
    if (this.KHG > 0L) {
      this.KHH = ((int)(this.KHH + (Util.nowMilliSecond() - this.KHG) / 1000L));
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[] { this.filename, Integer.valueOf(this.KHH) });
    this.KHG = 0L;
    if ((this.WQM != null) && (this.WQM.WQV != null)) {
      this.WQM.WQV.WTa.cW(this.WQM.hRF());
    }
    AppMethodBeat.o(36301);
  }
  
  private void hN(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(36277);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(225604);
        com.tencent.mm.modelvideo.y.aT(paramString, paramInt);
        AppMethodBeat.o(225604);
      }
    });
    AppMethodBeat.o(36277);
  }
  
  private void hSA()
  {
    AppMethodBeat.i(36293);
    try
    {
      this.WQM.WQV.hRQ().Mfz.setIplaySeekCallback(this.wTG);
      AppMethodBeat.o(36293);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(36293);
    }
  }
  
  private static void hSB()
  {
    AppMethodBeat.i(36305);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 11L, 1L, false);
    AppMethodBeat.o(36305);
  }
  
  private static void hSC()
  {
    AppMethodBeat.i(36306);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 14L, 1L, false);
    AppMethodBeat.o(36306);
  }
  
  private void releaseWakeLock()
  {
    AppMethodBeat.i(36268);
    if ((this.kqO != null) && (this.kqO.isHeld()))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "release waklock");
      PowerManager.WakeLock localWakeLock = this.kqO;
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler", "releaseWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      localWakeLock.release();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler", "releaseWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    AppMethodBeat.o(36268);
  }
  
  public final void MX(int paramInt)
  {
    AppMethodBeat.i(36267);
    d(avN(paramInt));
    this.sUi.fZ(false);
    this.WQM.WQV.setVideoStateIv(true);
    AppMethodBeat.o(36267);
  }
  
  public final void a(x.a.a parama)
  {
    AppMethodBeat.i(36292);
    Object localObject2 = parama.fileName;
    if ((Util.isNullOrNil((String)localObject2)) || (this.WSS == null))
    {
      AppMethodBeat.o(36292);
      return;
    }
    parama = (a)this.WSS.get(localObject2);
    if (parama == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    Object localObject1 = parama.fvt;
    if ((localObject1 == null) || (((et)localObject1).field_imgPath == null) || (!((et)localObject1).field_imgPath.equals(localObject2)))
    {
      AppMethodBeat.o(36292);
      return;
    }
    localObject2 = cH((ca)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(36292);
      return;
    }
    if (((!((ca)localObject1).dlS()) && (((ca)localObject1).Ic())) || (((com.tencent.mm.modelvideo.w)localObject2).status == 198))
    {
      if (b(parama)) {
        Toast.makeText(this.WQM.WQV, R.l.eUF, 0).show();
      }
      AppMethodBeat.o(36292);
      return;
    }
    int i = com.tencent.mm.modelvideo.y.g((com.tencent.mm.modelvideo.w)localObject2);
    p localp = avN(parama.pos);
    if ((this.WQM.WQV.getCurrentItem() == parama.pos) && (localp != null))
    {
      localp.hSL().WVM.setVisibility(0);
      localp.hSL().WVM.setProgress(i);
    }
    while (i < localp.hSL().WVM.getMax())
    {
      AppMethodBeat.o(36292);
      return;
      if (localp == null)
      {
        AppMethodBeat.o(36292);
        return;
      }
    }
    Log.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.w)localObject2).status) });
    if (((((com.tencent.mm.modelvideo.w)localObject2).status == 199) || (((com.tencent.mm.modelvideo.w)localObject2).status == 199)) && (b(parama))) {
      i = this.WQM.WQV.Wc(((et)localObject1).field_msgId);
    }
    switch (i)
    {
    default: 
      Log.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(36292);
      return;
    case 0: 
    case 3: 
      a((ca)localObject1, (com.tencent.mm.modelvideo.w)localObject2, this.WQM.WQV.getCurrentItem(), false);
      AppMethodBeat.o(36292);
      return;
    case 1: 
      Log.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 15L, 1L, false);
      this.WQM.cP((ca)localObject1);
      this.WQM.WQV.Wd(-1L);
      if (this.KHl)
      {
        i = this.WQM.hRG().WVL.getCurrentPosition();
        com.tencent.mm.modelvideo.y.j(this.filename, i, this.KHl);
        this.WUO = true;
      }
      this.KHl = false;
      AppMethodBeat.o(36292);
      return;
    case 2: 
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 16L, 1L, false);
      f.a(this.WQM.WQV, (ca)localObject1);
      this.WQM.WQV.Wd(-1L);
      if (this.KHl)
      {
        i = this.WQM.hRG().WVL.getCurrentPosition();
        com.tencent.mm.modelvideo.y.j(this.filename, i, this.KHl);
        this.WUO = true;
      }
      this.KHl = false;
      AppMethodBeat.o(36292);
      return;
    }
    this.WQM.WQV.Wd(-1L);
    parama = this.WQM.WQV;
    Log.i("MicroMsg.ImageGalleryUI", "launchAppBrandIfNeed");
    if (parama.WUd != null)
    {
      parama = parama.WUd;
      Log.i("MicroMsg.ImageGalleryUI", "executePendingLaunchAppBrandTaskIfNeed");
      localObject1 = (ImageGalleryUI)parama.Rxt.get();
      if (localObject1 == null)
      {
        Log.i("MicroMsg.ImageGalleryUI", "executePendingLaunchAppBrandTaskIfNeed, ui is null");
        AppMethodBeat.o(36292);
        return;
      }
      if ((parama.WUE != null) && (parama.WUF != null) && (parama.WUF.equals(((ImageGalleryUI)localObject1).WQM.hRF())))
      {
        Log.i("MicroMsg.ImageGalleryUI", "executePendingLaunchAppBrandTask");
        l.qmQ.ah(parama.WUE);
      }
      parama.WUE = null;
      parama.WUF = null;
    }
    AppMethodBeat.o(36292);
  }
  
  final void a(p paramp)
  {
    AppMethodBeat.i(36280);
    Log.i("MicroMsg.Imagegallery.handler.video", "stop");
    fTZ();
    if (paramp == null)
    {
      AppMethodBeat.o(36280);
      return;
    }
    fUo();
    if (this.KHl) {
      this.WUI.hSP();
    }
    if (!this.WUK) {
      com.tencent.mm.modelvideo.y.j(this.filename, this.wTA - 1000, this.KHl);
    }
    paramp.hSL().WVM.setVisibility(8);
    paramp.hSL().WVV.setVisibility(8);
    paramp.hSL().WVL.stop();
    awn(0);
    paramp.d(false, 0.0F);
    this.KHl = false;
    this.WUT = false;
    this.WUO = false;
    this.filename = null;
    this.KHH = 0;
    this.KHG = 0L;
    this.WUU = 0;
    this.WUR = 0;
    this.WUN = 0;
    this.WUM = 0;
    this.pDZ = 0L;
    this.lastCheckTime = 0L;
    AppMethodBeat.o(36280);
  }
  
  public final boolean a(p paramp, ca paramca, int paramInt)
  {
    AppMethodBeat.i(36262);
    super.a(paramp, paramca, paramInt);
    Object localObject1 = cI(paramca);
    if (paramca == null)
    {
      Log.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
      AppMethodBeat.o(36262);
      return false;
    }
    if (this.WSS != null) {
      this.WSS.put(paramca.field_imgPath, new a(paramca, paramInt));
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(36262);
      return false;
      Log.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
    }
    Object localObject2;
    if (paramca.dlS())
    {
      localObject1 = cG(paramca);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.pluginsdk.model.w.bpO(((com.tencent.mm.aj.y)localObject1).lpK);
        com.tencent.mm.ay.a.a locala = com.tencent.mm.ay.q.bml();
        String str = ((com.tencent.mm.aj.y)localObject1).lpK;
        ImageView localImageView = paramp.hSL().WVJ;
        c.a locala1 = new c.a();
        locala1.fullPath = ((String)localObject2);
        locala1.lRD = true;
        locala.a(str, localImageView, locala1.bmL());
        localObject2 = r.WWC;
        paramca = r.bzB(((com.tencent.mm.aj.y)localObject1).OW(paramca.field_imgPath));
        if (paramca.block == 1) {
          a(paramp, paramca.TiP);
        }
      }
      else
      {
        if (paramp.hSL().WVL.isPlaying()) {
          paramp.hSL().WVL.stop();
        }
        if ((paramp.hSL().WVL instanceof VideoPlayerTextureView))
        {
          if ((!ar.hIH()) && (!ar.hIM())) {
            break label465;
          }
          ((VideoPlayerTextureView)paramp.hSL().WVL).setScaleType(i.e.RcG);
        }
      }
    }
    for (;;)
    {
      paramp.WVN.setVisibility(8);
      paramp.hSL().WVM.setVisibility(8);
      paramp.hSL().WVV.setVisibility(8);
      paramp.d(false, 0.0F);
      this.WUM = 0;
      this.KHp = Util.nowMilliSecond();
      AppMethodBeat.o(36262);
      return true;
      b(paramp);
      break;
      localObject1 = paramp.hSL().WVJ;
      Log.i("MicroMsg.Imagegallery.handler.video", "[+] [tomys] Easy crash pos, bitmap will be down sample to reduce mem cost.");
      s.bqB();
      paramca = com.tencent.mm.modelvideo.x.XU(paramca.field_imgPath);
      localObject2 = BackwardSupportUtil.BitmapFactory.decodeFileWithMemLimit(paramca, 4194304);
      if (localObject2 != null) {
        Log.i("MicroMsg.Imagegallery.handler.video", "[+] [tomys] Bitmap decoded, file: %s, w: %s, h: %s", new Object[] { paramca, Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
      }
      for (;;)
      {
        ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
        b(paramp);
        break;
        Log.e("MicroMsg.Imagegallery.handler.video", "[-] [tomys] Fail to decode file: %s", new Object[] { paramca });
      }
      label465:
      ((VideoPlayerTextureView)paramp.hSL().WVL).setScaleType(i.e.RcE);
    }
  }
  
  public final void avQ(int paramInt)
  {
    AppMethodBeat.i(36291);
    this.WUH.remove(paramInt);
    AppMethodBeat.o(36291);
  }
  
  protected final void awn(int paramInt)
  {
    AppMethodBeat.i(36298);
    paramInt = Math.max(0, paramInt);
    this.WQM.WQV.hRQ().Mfz.seek(paramInt);
    if ((this.WUI != null) && (this.WUI.mfD > 0L)) {
      this.WQM.WQV.hRQ().Mfz.arc((int)this.WUI.mfD);
    }
    AppMethodBeat.o(36298);
  }
  
  protected final void bc(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36295);
    p localp = this.WQM.hRG();
    if (localp == null)
    {
      AppMethodBeat.o(36295);
      return;
    }
    fUn();
    localp.hSL().WVV.setVisibility(8);
    localp.hSL().WVL.b(paramInt * 1000, paramBoolean);
    this.WQM.WQV.setVideoStateIv(false);
    gA(false);
    AppMethodBeat.o(36295);
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  protected final void bqn()
  {
    AppMethodBeat.i(36296);
    p localp = this.WQM.hRG();
    if (localp == null)
    {
      AppMethodBeat.o(36296);
      return;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "start to pause");
    this.WQM.WQV.setVideoStateIv(true);
    localp.hSL().WVV.setVisibility(0);
    localp.hSL().WVL.pause();
    fUo();
    AppMethodBeat.o(36296);
  }
  
  protected final void bzA(String paramString)
  {
    AppMethodBeat.i(36299);
    if ((!this.WUT) && (!b((a)this.WSS.get(paramString)))) {
      Log.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
    }
    AppMethodBeat.o(36299);
  }
  
  protected final void cD(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(36294);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275380);
        Log.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if (n.l(n.this) == null)
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
          AppMethodBeat.o(275380);
          return;
        }
        n.a locala = (n.a)n.l(n.this).get(paramString);
        if ((locala == null) || (locala.fvt == null))
        {
          AppMethodBeat.o(275380);
          return;
        }
        com.tencent.mm.modelvideo.w localw = e.cH(locala.fvt);
        if (n.this.WQM.WQV.getCurrentItem() == locala.pos)
        {
          n.a(n.this, locala.fvt, localw, locala.pos, paramBoolean);
          n.this.bzA(paramString);
          AppMethodBeat.o(275380);
          return;
        }
        Log.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[] { Integer.valueOf(n.this.WQM.WQV.getCurrentItem()), Integer.valueOf(locala.pos) });
        AppMethodBeat.o(275380);
      }
    });
    AppMethodBeat.o(36294);
  }
  
  public final void cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197568);
    boolean bool2 = this.KHl;
    Object localObject = this.WUI;
    boolean bool1;
    if ((!Util.isNullOrNil(((t)localObject).mediaId)) && (((t)localObject).mfw == 1))
    {
      bool1 = true;
      Log.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      this.WUK = true;
      this.wTz = paramInt2;
      if (!this.KHl) {
        break label281;
      }
      if (paramInt1 != -1) {
        break label193;
      }
      fTZ();
      this.WQM.hRG().WVL.stop();
      this.WUI.hSQ();
    }
    label193:
    do
    {
      for (;;)
      {
        this.WUT = false;
        this.WQM.WQV.setVideoStateIv(true);
        this.WQM.hRG().hSL().WVV.setVisibility(0);
        fUo();
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 18L, 1L, false);
        AppMethodBeat.o(197568);
        return;
        bool1 = false;
        break;
        if (paramInt1 != -2) {
          break label256;
        }
        fTZ();
        paramInt1 = this.WQM.hRG().WVL.getCurrentPosition();
        com.tencent.mm.modelvideo.y.j(this.filename, paramInt1, this.KHl);
        this.WQM.hRG().WVL.stop();
        this.WUI.hSQ();
      }
    } while (paramInt1 != -3);
    label256:
    this.WUK = false;
    this.WUI.hSQ();
    AppMethodBeat.o(197568);
    return;
    label281:
    com.tencent.mm.modelvideo.y.Ym(this.filename);
    fUo();
    if ((this.WQM != null) && (this.WQM.hRG() != null) && (this.WQM.hRG().WVL != null))
    {
      localObject = this.WQM.hRG().WVL.getVideoPath();
      this.WQM.hRG().WVL.stop();
    }
    while (this.WUL)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(197568);
      return;
      localObject = "";
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36255);
        if ((n.this.WQM == null) || (n.this.WQM.hRG() == null) || (n.l(n.this) == null))
        {
          Log.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
          AppMethodBeat.o(36255);
          return;
        }
        n.this.WQM.hRG().d(false, 0.0F);
        if (!Util.isNullOrNil(this.wTJ)) {
          Log.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", new Object[] { this.wTJ });
        }
        try
        {
          Object localObject2 = new Intent();
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          FileProviderHelper.setIntentDataAndType(n.this.WQM.WQV, (Intent)localObject2, new com.tencent.mm.vfs.q(this.wTJ), "video/*", false);
          Object localObject1 = n.this.WQM.WQV;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$4", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$4", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = (n.a)n.l(n.this).get(n.a(n.this));
          if ((localObject1 == null) || (((n.a)localObject1).fvt == null))
          {
            AppMethodBeat.o(36255);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
            com.tencent.mm.ui.base.h.p(n.this.WQM.WQV, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
          }
          n.this.avQ(localException.pos);
          AppMethodBeat.o(36255);
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 25L, 1L, false);
    AppMethodBeat.o(197568);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36284);
    Log.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.KHq = Util.nowMilliSecond();
    this.WUQ.removeMessages(1);
    fTZ();
    EventCenter.instance.removeListener(this.WUG);
    EventCenter.instance.removeListener(this.WUS);
    stopAll();
    this.WQM.WQV.getContext().getWindow().clearFlags(128);
    this.WQM.WQV.hRQ().Mfz.setIplaySeekCallback(null);
    super.detach();
    this.WSS.clear();
    this.WSS = null;
    s.bqB().a(this);
    this.WUH.clear();
    t localt = this.WUI;
    localt.reset();
    localt.KIg = null;
    localt.WWF = null;
    localt.WWG = null;
    if (com.tencent.mm.plugin.u.f.eSI()) {
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(277332);
          String str = com.tencent.mm.plugin.u.f.eSJ();
          if (!Util.isNullOrNil(str))
          {
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(14092, str);
            AppMethodBeat.o(277332);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(14092, "0");
          AppMethodBeat.o(277332);
        }
      });
    }
    s.bqG().brd();
    s.bqG().run();
    AppMethodBeat.o(36284);
  }
  
  protected final boolean fUl()
  {
    AppMethodBeat.i(36297);
    p localp = this.WQM.hRG();
    if (localp == null)
    {
      AppMethodBeat.o(36297);
      return false;
    }
    boolean bool = true;
    if (!localp.hSL().WVL.isPlaying())
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "start to play");
      this.WQM.WQV.setVideoStateIv(false);
      localp.hSL().WVV.setVisibility(8);
      bool = localp.hSL().WVL.start();
      fUn();
    }
    if (localp.hSL().WVV.getVisibility() != 8) {
      localp.hSL().WVV.setVisibility(8);
    }
    AppMethodBeat.o(36297);
    return bool;
  }
  
  protected final void gA(boolean paramBoolean)
  {
    AppMethodBeat.i(36289);
    if (!this.WUK)
    {
      if (this.KHl)
      {
        if (paramBoolean)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36256);
              for (;;)
              {
                try
                {
                  if (!Util.isNullOrNil(n.this.WQM.hRG().hSL().WVL.getVideoPath())) {
                    continue;
                  }
                  i = com.tencent.mm.modelvideo.y.S(n.f(n.this).mfz, n.a(n.this));
                  n.f(n.this).xa(i);
                }
                catch (Exception localException)
                {
                  int i;
                  Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "start timer error[%s]", new Object[] { localException.toString() });
                  continue;
                }
                n.m(n.this).startTimer(500L);
                AppMethodBeat.o(36256);
                return;
                i = n.this.WQM.hRG().hSL().WVL.getCurrentPosition() / 1000;
              }
            }
          });
          AppMethodBeat.o(36289);
          return;
        }
        this.Kux.startTimer(500L);
        AppMethodBeat.o(36289);
        return;
      }
      this.txN.startTimer(500L);
    }
    AppMethodBeat.o(36289);
  }
  
  protected final int getPlayVideoDuration()
  {
    AppMethodBeat.i(36302);
    if (this.KHH < 0) {
      this.KHH = 0;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[] { this.filename, Integer.valueOf(this.KHH) });
    int i = this.KHH;
    AppMethodBeat.o(36302);
    return i;
  }
  
  protected final int getUiStayTime()
  {
    AppMethodBeat.i(36303);
    if ((this.KHq > 0L) && (this.KHp > 0L)) {}
    for (int i = (int)(this.KHq - this.KHp);; i = 0)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      Log.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[] { Integer.valueOf(hashCode()), this.filename, Integer.valueOf(j), Long.valueOf(this.KHq), Long.valueOf(this.KHp) });
      AppMethodBeat.o(36303);
      return j;
    }
  }
  
  public final void hRB()
  {
    AppMethodBeat.i(197560);
    this.WUK = false;
    this.wTz = 0;
    if (this.WQM != null) {}
    for (Object localObject = this.WQM.hRG(); localObject == null; localObject = null)
    {
      Log.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
      AppMethodBeat.o(197560);
      return;
    }
    final int i = Util.videoMsToSec(((p)localObject).hSL().WVL.getDuration());
    int j = this.WQM.WQV.hRQ().Mfz.getVideoTotalTime();
    Log.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    if ((j <= 0) || (Math.abs(j - i) >= 2)) {
      this.WQM.WQV.hRQ().Mfz.setVideoTotalTime(i);
    }
    hSA();
    if ((i == 0) || (i >= 1800))
    {
      Log.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), this.filename });
      i = com.tencent.mm.modelvideo.y.S(i, this.filename);
      Log.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[] { Boolean.valueOf(this.KHl), Integer.valueOf(i), Boolean.valueOf(this.WUJ), Boolean.valueOf(this.WUK) });
      ((p)localObject).hSL().WVL.setOneTimeVideoTextureUpdateCallback(this.KHb);
      if (!this.WUJ) {
        break label399;
      }
      if (this.KHl) {
        break label347;
      }
      this.WUI.reset();
      fUn();
      bc(i, true);
    }
    for (;;)
    {
      gA(false);
      AppMethodBeat.o(197560);
      return;
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(36248);
          com.tencent.mm.modelvideo.y.aS(n.a(n.this), i);
          AppMethodBeat.o(36248);
        }
      });
      break;
      label347:
      localObject = this.WUI;
      if (i > 0)
      {
        Log.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(i)));
        ((t)localObject).mfA = i;
        ((t)localObject).mfC = true;
        ((t)localObject).mfx = 2;
      }
      this.WUI.xa(0);
    }
    label399:
    if (!this.KHl) {
      bc(i, false);
    }
    for (;;)
    {
      awn(i);
      this.WQM.WQV.setVideoStateIv(true);
      fTZ();
      AppMethodBeat.o(197560);
      return;
      this.WUI.bY(i, false);
    }
  }
  
  public final void hRC()
  {
    AppMethodBeat.i(197564);
    Log.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.KHl);
    fTZ();
    releaseWakeLock();
    fUo();
    Object localObject1;
    if ((this.KHl) && (this.WQM != null) && (this.WQM.hRG() != null))
    {
      localObject1 = this.WQM.hRG().hSL().WVL;
      if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).getCurrentPosition() + 2000 < ((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).getDuration())) {
        Log.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).getCurrentPosition()), Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).getDuration()) });
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
            AppMethodBeat.i(272769);
            n.h(n.this);
            n.a(n.this, n.i(n.this));
            n.d(n.this).fZ(false);
            n.j(n.this);
            if (n.c(n.this))
            {
              n.b(n.this, Util.nowMilliSecond());
              n.f(n.this).hSP();
              n.f(n.this).reset();
              n.a(n.this, false);
              n.k(n.this);
            }
            com.tencent.mm.modelvideo.y.j(n.a(n.this), 0, n.c(n.this));
            if (n.l(n.this) != null)
            {
              n.a locala = (n.a)n.l(n.this).get(n.a(n.this));
              if (locala != null)
              {
                p localp = n.this.WQM.hRG();
                localp.hSL().WVL.stop();
                n.a(n.this, 0);
                n.this.a(localp, locala.fvt, locala.pos);
                n.this.awn(0);
                if (localp.hSL().WVV.getVisibility() != 8) {
                  localp.hSL().WVV.setVisibility(8);
                }
              }
            }
            AppMethodBeat.o(272769);
          }
        });
        AppMethodBeat.o(197564);
        return;
      }
      try
      {
        i = this.WQM.hRG().WVL.getCurrentPosition();
        com.tencent.mm.modelvideo.y.j(this.filename, i, this.KHl);
        this.WQM.hRG().WVL.stop();
        this.WUI.hSQ();
        i = this.WUR + 1;
        this.WUR = i;
        if (i <= 3)
        {
          localObject1 = (a)this.WSS.get(this.filename);
          if (localObject1 != null)
          {
            localObject2 = ((a)localObject1).fvt;
            if (localObject2 != null) {}
          }
          else
          {
            AppMethodBeat.o(197564);
            return;
          }
          Object localObject2 = cH(((a)localObject1).fvt);
          a(((a)localObject1).fvt, (com.tencent.mm.modelvideo.w)localObject2, ((a)localObject1).pos, this.KHl);
        }
        AppMethodBeat.o(197564);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "notify video completion error[%s]", new Object[] { localException.toString() });
        AppMethodBeat.o(197564);
        return;
      }
    }
  }
  
  public final void k(ca paramca, int paramInt)
  {
    AppMethodBeat.i(36270);
    Log.i("MicroMsg.Imagegallery.handler.video", "toggle video");
    if (paramca == null)
    {
      AppMethodBeat.o(36270);
      return;
    }
    if ((!f.m(paramca)) && (!f.cJ(paramca)))
    {
      AppMethodBeat.o(36270);
      return;
    }
    com.tencent.mm.modelvideo.w localw = cI(paramca);
    this.filename = localw.getFileName();
    if ((localw.status == 199) || (localw.status == 123)) {}
    boolean bool2;
    Object localObject1;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (paramca.dlS())
      {
        Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO toggle mp video,status : %d", new Object[] { Integer.valueOf(localw.status) });
        s.bqB();
        localObject1 = com.tencent.mm.modelvideo.x.XT(paramca.field_imgPath);
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!u.agG((String)localObject1))
          {
            bool2 = false;
            localw.status = 111;
            s.bqB().c(localw);
            Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_WARN user delete local file,reset video info status");
          }
        }
      }
      if (!paramca.dlS()) {
        break label496;
      }
      localObject1 = cG(paramca);
      if (localObject1 != null) {
        break;
      }
      Log.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR mpShareVideoInfo is null");
      AppMethodBeat.o(36270);
      return;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "mpVideo videoDownload %b, playKey %s", new Object[] { Boolean.valueOf(bool2), ((com.tencent.mm.aj.y)localObject1).OW(paramca.field_imgPath) });
    Object localObject2 = r.WWC;
    localObject2 = r.aqw(((com.tencent.mm.aj.y)localObject1).OW(paramca.field_imgPath));
    Object localObject3 = r.WWC;
    localObject3 = r.bzB(((com.tencent.mm.aj.y)localObject1).OW(paramca.field_imgPath));
    if (((daa)localObject3).block == 1)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO block video");
      a(avN(paramInt), ((daa)localObject3).TiP);
      AppMethodBeat.o(36270);
      return;
    }
    b(avN(paramInt));
    if ((!Util.isNullOrNil((String)localObject2)) && ((localw.lAW <= 0) || (!((String)localObject2).equals(localw.mhZ.lor))))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  update video info. playUrl:%s, length:%d", new Object[] { localObject2, Integer.valueOf(((daa)localObject3).Sjq) });
      localw.mhZ.lor = ((String)localObject2);
      localw.lAW = ((daa)localObject3).Sjq;
      s.bqB().c(localw);
    }
    if ((a(localw, (com.tencent.mm.aj.y)localObject1, paramca, paramInt, bool2, this)) && (!bool2))
    {
      paramca = avN(paramInt);
      if (paramca != null)
      {
        paramca.hSL();
        paramca.hSL().WVK.setVisibility(8);
        paramca.hSL().WVV.setVisibility(0);
      }
      AppMethodBeat.o(36270);
      return;
      label496:
      b(avN(paramInt));
    }
    if ((this.KHl) && (this.WUI != null) && (this.WUI.mfC))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(36270);
      return;
    }
    if (this.WQM.WQV.ehu())
    {
      e(avN(paramInt));
      d(avN(paramInt));
      this.WQM.WQV.setVideoStateIv(true);
      this.WQM.WQV.wTF.stopTimer();
      this.sUi.fZ(false);
      releaseWakeLock();
      Log.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
      AppMethodBeat.o(36270);
      return;
    }
    bh.beI();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.g(this.WQM.WQV.getContext(), null);
      AppMethodBeat.o(36270);
      return;
    }
    int j;
    int i;
    if (this.KHl)
    {
      j = 0;
      i = j;
    }
    for (;;)
    {
      try
      {
        if (this.WQM.hRG().WVL != null) {
          i = this.WQM.hRG().WVL.getCurrentPosition() / 1000;
        }
        if (this.WUI != null) {
          if (this.WUI.xb(i))
          {
            Log.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
            a(paramca, localw, paramInt, this.KHl);
            if (this.WQM.WQV.WUm) {
              this.WQM.WQV.hSs();
            }
            hSA();
            this.kqO = ((PowerManager)MMApplicationContext.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Imagegallery.handler.video");
            paramca = this.kqO;
            com.tencent.mm.hellhoundlib.a.a.b(paramca, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler", "acuquireWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
            paramca.acquire();
            com.tencent.mm.hellhoundlib.a.a.c(paramca, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler", "acuquireWakeLock", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
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
        gA(false);
        continue;
        Log.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[] { Integer.valueOf(hashCode()) });
        continue;
      }
      if (paramca.field_isSend == 0)
      {
        if ((localw.status != 113) && (localw.status != 198)) {
          break label1060;
        }
        a(paramca, localw);
      }
      for (;;)
      {
        if (paramca.field_isSend != 1) {
          break label1161;
        }
        i = localw.status;
        if ((i != 111) && (i != 113) && (i != 112) && (i != 121) && (i != 122)) {
          break label1163;
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[] { paramca.field_talker, Integer.valueOf(i) });
        a(paramca, localw);
        break;
        label1060:
        if (localw.status == 199) {
          a(paramca, localw, paramInt, false);
        }
        if (localw.status == 111) {
          a(paramca, localw);
        }
        if (localw.status == 112) {
          a(paramca, localw);
        }
        if ((localw.status == 121) || (localw.status == 122)) {
          a(paramca, localw);
        }
        if (localw.status == 123) {
          a(paramca, localw, paramInt, false);
        }
      }
      label1161:
      continue;
      label1163:
      a(paramca, localw, paramInt, false);
    }
  }
  
  public final void l(ca paramca, int paramInt)
  {
    AppMethodBeat.i(36273);
    Log.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
    com.tencent.mm.modelvideo.w localw = com.tencent.mm.modelvideo.y.Yk(paramca.field_imgPath);
    if ((localw != null) && (!localw.bqS()))
    {
      d(avN(paramInt));
      this.WQM.WQV.setVideoStateIv(true);
      if (this.KHl)
      {
        this.WUI.hSP();
        this.WUI.reset();
      }
      a(paramca, localw);
      if (this.WQM.WQV.Wc(paramca.field_msgId) == 2)
      {
        hN(paramca.field_imgPath, 8);
        AppMethodBeat.o(36273);
        return;
      }
      hN(paramca.field_imgPath, 5);
    }
    AppMethodBeat.o(36273);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(197546);
    this.WUQ.sendEmptyMessageDelayed(1, 200L);
    AppMethodBeat.o(197546);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(36282);
    Log.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
    this.WUQ.removeMessages(1);
    EventCenter.instance.addListener(this.WUS);
    if ((this.WQM != null) && (com.tencent.mm.compatible.util.d.qV(21)))
    {
      p localp = this.WQM.hRG();
      if ((localp != null) && (localp.WVL != null))
      {
        if ((localp.WVL instanceof VideoPlayerTextureView))
        {
          ((VideoPlayerTextureView)localp.WVL).bXe();
          AppMethodBeat.o(36282);
          return;
        }
        if ((localp.WVL instanceof VideoTextureView)) {
          ((VideoTextureView)localp.WVL).bXe();
        }
      }
    }
    AppMethodBeat.o(36282);
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(36279);
    Log.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
    this.KHq = Util.nowMilliSecond();
    SparseArray localSparseArray = this.WQM.WnN;
    int j = 0;
    int i = 0;
    if (j < localSparseArray.size())
    {
      int k = localSparseArray.keyAt(j);
      if ((localSparseArray.get(k) == null) || (((View)localSparseArray.get(k)).getTag() == null)) {
        break label253;
      }
      p localp = (p)((View)localSparseArray.get(k)).getTag();
      if ((localp.WVI == null) || (localp.hSL().WVI.getVisibility() != 0) || ((((View)localp.hSL().WVL).getVisibility() != 0) && (Util.isNullOrNil(localp.hSL().WVL.getVideoPath())) && ((!this.KHl) || (!this.WUI.isStreaming())))) {
        break label253;
      }
      a(localp);
      i = 1;
    }
    label253:
    for (;;)
    {
      j += 1;
      break;
      this.sUi.fZ(false);
      if ((i == 0) && (this.KHl))
      {
        this.WUI.hSP();
        this.KHl = false;
      }
      fTZ();
      this.WUH.clear();
      releaseWakeLock();
      AppMethodBeat.o(36279);
      return;
    }
  }
  
  public static final class a
  {
    public ca fvt;
    public int pos;
    
    public a(ca paramca, int paramInt)
    {
      this.fvt = paramca;
      this.pos = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.n
 * JD-Core Version:    0.7.0.1
 */