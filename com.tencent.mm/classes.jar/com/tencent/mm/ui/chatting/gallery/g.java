package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.ae;
import com.tencent.mm.modelvideo.ae.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.thumbplayer.downloader.i.d;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.io.IOException;
import java.lang.ref.WeakReference;

public abstract class g
  extends a
  implements i.d
{
  private static com.tencent.mm.message.y aeAt = null;
  protected com.tencent.mm.ui.chatting.i.e aeAu = null;
  private com.tencent.mm.ui.chatting.i.e aeAv = null;
  int mScrollState = 0;
  
  public g(h paramh)
  {
    super(paramh);
    aeAt = null;
  }
  
  static boolean a(final z paramz, com.tencent.mm.message.y paramy, final cc paramcc, final int paramInt, final boolean paramBoolean, final g paramg)
  {
    paramg = new WeakReference(paramg);
    t localt = t.aeGb;
    t.a(paramy, paramcc.field_imgPath, new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
      {
        AppMethodBeat.i(254404);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  end do exchange video link success");
          paramAnonymousString = (cpu)c.c.b(paramAnonymousc.otC);
          paramAnonymousc = t.aeGb;
          t.a(g.this.Hl(paramcc.field_imgPath), paramAnonymousString);
          if ((paramg.get() == null) || (((g)paramg.get()).efT()))
          {
            AppMethodBeat.o(254404);
            return;
          }
          paramAnonymousc = (g)paramg.get();
          r localr = paramAnonymousc.aCt(paramInt);
          if (paramAnonymousString.block == 1)
          {
            Log.w("MicroMsg.Imagegallery.handler.video", "doGetPlayUrl block %s", new Object[] { paramAnonymousString.aawp });
            paramAnonymousc.a(paramAnonymousc.aCt(paramInt));
            v.bOh();
            com.tencent.mm.vfs.y.deleteFile(aa.PX(paramcc.field_imgPath));
            paramz.status = 111;
            v.bOh().c(paramz);
            if (paramAnonymousc.aeAg.jve() == localr) {
              paramAnonymousc.a(localr, paramAnonymousString.aawp);
            }
            AppMethodBeat.o(254404);
            return;
          }
          if (!paramBoolean)
          {
            paramz.omT = paramAnonymousString.Zhu;
            paramz.pbk.nTu = paramAnonymousString.OQR;
            v.bOh().c(paramz);
          }
          if ((!paramBoolean) && (paramAnonymousc.aeAg.jve() == localr) && (!paramAnonymousc.aeAg.aeAB.fjy())) {
            paramAnonymousc.k(paramcc, paramInt);
          }
          AppMethodBeat.o(254404);
          return;
        }
        Log.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR  end do exchange video link fail %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
        AppMethodBeat.o(254404);
      }
    });
  }
  
  static void b(r paramr)
  {
    if ((paramr == null) || (paramr.jwq() == null)) {
      return;
    }
    paramr.jwq().aeFu.setVisibility(8);
  }
  
  private static com.tencent.mm.message.y ca(Activity paramActivity)
  {
    byte[] arrayOfByte;
    if (aeAt == null)
    {
      arrayOfByte = paramActivity.getIntent().getByteArrayExtra("img_gallery_mp_share_video_info");
      if (Util.isNullOrNil(arrayOfByte))
      {
        Log.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo data is null");
        paramActivity.finish();
        return null;
      }
    }
    try
    {
      com.tencent.mm.message.y localy = new com.tencent.mm.message.y();
      localy.parseFrom(arrayOfByte);
      aeAt = localy;
      return aeAt;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo ex %s", new Object[] { localIOException.getMessage() });
        paramActivity.finish();
      }
    }
  }
  
  public static com.tencent.mm.message.y dc(cc paramcc)
  {
    if (paramcc.jbt()) {
      return new com.tencent.mm.message.y().a(paramcc.adks);
    }
    paramcc = k.b.aP(paramcc.field_content, paramcc.field_reserved);
    if (paramcc == null)
    {
      Log.w("MicroMsg.Imagegallery.handler.video", "getVideoInfo content is null");
      return null;
    }
    paramcc = (com.tencent.mm.message.e)paramcc.aK(com.tencent.mm.message.e.class);
    if ((paramcc != null) && (paramcc.nQs != null)) {}
    for (paramcc = paramcc.nQs;; paramcc = null) {
      return paramcc;
    }
  }
  
  public static z dd(cc paramcc)
  {
    if (!h.m(paramcc)) {
      return null;
    }
    return ab.Qo(paramcc.field_imgPath);
  }
  
  public static z de(cc paramcc)
  {
    z localz = dd(paramcc);
    if (localz != null) {
      return localz;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "insert video info:" + paramcc.toString());
    localz = new z();
    localz.hVQ = paramcc.field_talker;
    localz.fileName = paramcc.field_imgPath;
    if (paramcc.getCreateTime() <= 0L) {}
    for (long l = System.currentTimeMillis();; l = paramcc.getCreateTime())
    {
      localz.createTime = l;
      localz.hTh = paramcc.field_msgSvrId;
      localz.pbh = paramcc.field_content;
      localz.pbc = ((int)paramcc.field_msgId);
      com.tencent.mm.message.y localy = dc(paramcc);
      if (localy != null)
      {
        if (TextUtils.isEmpty(paramcc.field_imgPath))
        {
          paramcc.BT(aa.PW(paramcc.field_talker));
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
        }
        localz.fileName = paramcc.field_imgPath;
        t localt = t.aeGb;
        localz.a(Util.nullAs(t.ajV(localy.Hl(paramcc.field_imgPath)), localy.videoUrl), localy.videoDuration, localy.title, localy.YMm, "", "", "");
        localz.status = 111;
      }
      v.bOh().b(localz);
      return localz;
    }
  }
  
  public static cc g(String paramString, Activity paramActivity)
  {
    cc localcc = new cc();
    localcc.setType(486539313);
    localcc.BS(paramString);
    localcc.adkt = true;
    localcc.adks = ca(paramActivity);
    localcc.BT(paramActivity.getIntent().getStringExtra("img_gallery_path"));
    return localcc;
  }
  
  abstract void a(r paramr);
  
  void a(r paramr, String paramString)
  {
    if ((paramr == null) || (paramr.jwq() == null) || (this.aeAg == null)) {
      return;
    }
    paramr.jwq().aeFu.setVisibility(0);
    paramr.jwq().aeFv.setText(Util.nullAs(paramString, this.aeAg.aeAB.getString(R.l.video_play_faile)));
    paramr.jwq().aeFp.setVisibility(0);
    paramr.jwq().aeFq.setVisibility(8);
    a(paramr);
  }
  
  public final void a(Long paramLong, long paramLong1, long paramLong2)
  {
    if (paramLong == null) {
      Log.i("MicroMsg.Imagegallery.handler.video", "onDownloadProgress, it's not origin video task, return");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = d.aeAp;
        if (d.Ai(paramLong.longValue()) == null)
        {
          Log.i("MicroMsg.Imagegallery.handler.video", "onFinishDownload, downloader is null, ignore it");
          return;
        }
      } while ((this.aeAg == null) || (this.aeAg.aeAB == null) || (this.mScrollState != 0));
      localObject = this.aeAg.jvd();
    } while (paramLong.longValue() != ((fi)localObject).field_msgId);
    int i = Math.round((float)paramLong1 * 100.0F / (float)paramLong2);
    this.aeAg.aeAB.aCV(i);
  }
  
  abstract void aCw(int paramInt);
  
  abstract void aCx(int paramInt);
  
  public final void aCy(int paramInt)
  {
    Log.i("MicroMsg.Imagegallery.handler.video", "viewOriginVideo, pos = ".concat(String.valueOf(paramInt)));
    cc localcc = this.aeAg.aBV(paramInt);
    if ((localcc == null) || (localcc.field_msgId == 0L)) {
      Log.e("MicroMsg.Imagegallery.handler.video", "msg is null");
    }
    z localz;
    Object localObject2;
    do
    {
      return;
      if (!h.m(localcc))
      {
        Log.e("MicroMsg.Imagegallery.handler.video", "not video can't download origin");
        return;
      }
      localz = dd(localcc);
      if (localz == null)
      {
        Log.i("MicroMsg.Imagegallery.handler.video", "no video info for download origin video");
        return;
      }
      localObject1 = ae.pbN;
      localObject1 = ae.a.Qv(localz.bOu());
      if ((localObject1 == null) || (Util.isNullOrNil(((ae)localObject1).pbQ)))
      {
        Log.i("MicroMsg.Imagegallery.handler.video", "no origin video cdn url");
        return;
      }
      localObject2 = new c(localcc, localz, new com.tencent.mm.plugin.thumbplayer.f.b(Util.nowMilliSecond()), (ae)localObject1);
      localObject1 = new b(localcc, localz.getFileName(), true);
      localObject2 = new com.tencent.mm.plugin.thumbplayer.downloader.d((com.tencent.mm.plugin.thumbplayer.downloader.h)localObject2);
      ((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).a((com.tencent.mm.plugin.thumbplayer.f.a)localObject1);
      ((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).TCn = this;
    } while (!((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2).start());
    Object localObject1 = d.aeAp;
    d.a(localcc.field_msgId, (com.tencent.mm.plugin.thumbplayer.downloader.d)localObject2);
    this.aeAv = new com.tencent.mm.ui.chatting.i.e(localcc, localz.getFileName(), false, 4);
    this.aeAv.aeJr = System.currentTimeMillis();
  }
  
  public final void aCz(int paramInt)
  {
    Log.i("MicroMsg.Imagegallery.handler.video", "viewOriginVideo, pos = ".concat(String.valueOf(paramInt)));
    cc localcc = this.aeAg.aBV(paramInt);
    if ((localcc == null) || (localcc.field_msgId == 0L)) {
      Log.e("MicroMsg.Imagegallery.handler.video", "msg is null");
    }
    z localz;
    Object localObject;
    do
    {
      return;
      if (!h.m(localcc))
      {
        Log.e("MicroMsg.Imagegallery.handler.video", "not video can't download origin");
        return;
      }
      localz = dd(localcc);
      if (localz == null)
      {
        Log.i("MicroMsg.Imagegallery.handler.video", "no video info for download origin video");
        return;
      }
      localObject = d.aeAp;
      localObject = d.Aj(localcc.field_msgId);
    } while (localObject == null);
    ((com.tencent.mm.plugin.thumbplayer.downloader.i)localObject).stop();
    if (this.aeAv != null)
    {
      this.aeAv.jwR();
      this.aeAv.report();
    }
    this.aeAv = new com.tencent.mm.ui.chatting.i.e(localcc, localz.getFileName(), false, 5);
    this.aeAv.report();
    this.aeAv = null;
  }
  
  public void detach()
  {
    super.detach();
    d locald = d.aeAp;
    d.clearCallback();
    if (this.aeAu != null) {
      this.aeAu.report();
    }
    if (this.aeAv != null) {
      this.aeAv.report();
    }
  }
  
  abstract void di(int paramInt1, int paramInt2);
  
  final boolean efT()
  {
    if ((this.aeAg == null) || (this.aeAg.aeAB == null)) {
      return true;
    }
    return this.aeAg.aeAB.isFinishing();
  }
  
  abstract void juY();
  
  abstract void juZ();
  
  public final void jva()
  {
    Object localObject = this.aeAg.jvd();
    if (localObject != null)
    {
      long l = ((fi)localObject).field_msgId;
      localObject = d.aeAp;
      localObject = d.Ai(l);
      if ((localObject != null) && (!((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject).mhq)) {
        ((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject).TCn = this;
      }
    }
  }
  
  public final w jvb()
  {
    Object localObject = this.aeAg.jvd();
    if (localObject == null)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, msgInfo is null");
      return null;
    }
    if ((!((cc)localObject).dSI()) && (((cc)localObject).isClean()))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, msgInfo is cleaned");
      return w.aeGm;
    }
    localObject = dd((cc)localObject);
    if ((localObject == null) || (((z)localObject).status == 198))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, videoInfo is null or failed");
      return w.aeGm;
    }
    if (((z)localObject).bOx())
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, downloaded");
      return w.aeGo;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, not downloaded");
    return w.aeGn;
  }
  
  abstract void k(cc paramcc, int paramInt);
  
  abstract void l(cc paramcc, int paramInt);
  
  public final void n(Long paramLong)
  {
    if (paramLong == null) {
      Log.i("MicroMsg.Imagegallery.handler.video", "onStartDownload, it's not origin video task, return");
    }
  }
  
  public final void o(Long paramLong)
  {
    if (paramLong == null) {
      Log.i("MicroMsg.Imagegallery.handler.video", "onMoovReady, it's not origin video task, return");
    }
  }
  
  abstract void onResume();
  
  public final void p(Long paramLong)
  {
    if (paramLong == null)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "onStopDownload, it's not origin video task, return");
      return;
    }
    d locald = d.aeAp;
    paramLong = d.Aj(paramLong.longValue());
    if (paramLong == null)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "onFinishDownload, downloader is null, ignore it");
      return;
    }
    paramLong.TCn = null;
  }
  
  public final void q(final Long paramLong)
  {
    if (paramLong == null) {
      Log.i("MicroMsg.Imagegallery.handler.video", "onFinishDownload, it's not origin video task, return");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = d.aeAp;
          localObject = d.Aj(paramLong.longValue());
          if (localObject == null)
          {
            Log.i("MicroMsg.Imagegallery.handler.video", "onFinishDownload, downloader is null, ignore it");
            return;
          }
          ((com.tencent.mm.plugin.thumbplayer.downloader.d)localObject).TCn = null;
        } while ((this.aeAg == null) || (this.aeAg.aeAB == null));
        localObject = this.aeAg.jvd();
      } while (paramLong.longValue() != ((fi)localObject).field_msgId);
      paramLong = this.aeAg.jve();
    } while ((paramLong == null) || (paramLong.aeFr == null));
    if (this.aeAv != null)
    {
      this.aeAv.jwR();
      this.aeAv.report();
      this.aeAv = null;
    }
    paramLong.convertView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(254402);
        ImageGalleryUI localImageGalleryUI = g.this.aeAg.aeAB;
        com.tencent.mm.plugin.gallery.model.e.fAo().postToMainThread(new ImageGalleryUI.40(localImageGalleryUI));
        g.this.a(paramLong);
        g.this.k(this.oiV, paramLong.mPosition);
        AppMethodBeat.o(254402);
      }
    });
  }
  
  public final void r(Long paramLong)
  {
    if (paramLong == null) {
      Log.i("MicroMsg.Imagegallery.handler.video", "onDataAvailable, it's not origin video task, return");
    }
  }
  
  abstract void stopAll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.g
 * JD-Core Version:    0.7.0.1
 */