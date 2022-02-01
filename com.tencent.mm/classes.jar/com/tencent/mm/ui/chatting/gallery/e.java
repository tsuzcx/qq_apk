package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.c.et;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.aa.f;

public abstract class e
  extends a
{
  private static com.tencent.mm.aj.y WQR = null;
  
  public e(f paramf)
  {
    super(paramf);
    WQR = null;
  }
  
  static boolean a(final w paramw, com.tencent.mm.aj.y paramy, final ca paramca, final int paramInt, final boolean paramBoolean, final e parame)
  {
    parame = new WeakReference(parame);
    Object localObject = r.WWC;
    localObject = paramca.field_imgPath;
    paramca = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(265674);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Log.i("MicroMsg.Imagegallery.handler.video", "MP_VIDEO  end do exchange video link success");
          paramAnonymousString = (cal)d.c.b(paramAnonymousd.lBS);
          paramAnonymousd = r.WWC;
          r.a(this.WQS.OW(paramca.field_imgPath), paramAnonymousString);
          if ((parame.get() == null) || (((e)parame.get()).evg()))
          {
            AppMethodBeat.o(265674);
            return;
          }
          paramAnonymousd = (e)parame.get();
          p localp = paramAnonymousd.avN(paramInt);
          if (paramAnonymousString.block == 1)
          {
            Log.w("MicroMsg.Imagegallery.handler.video", "doGetPlayUrl block %s", new Object[] { paramAnonymousString.TiP });
            paramAnonymousd.a(paramAnonymousd.avN(paramInt));
            s.bqB();
            com.tencent.mm.vfs.u.deleteFile(x.XT(paramca.field_imgPath));
            paramw.status = 111;
            s.bqB().c(paramw);
            if (paramAnonymousd.WQM.hRG() == localp) {
              paramAnonymousd.a(localp, paramAnonymousString.TiP);
            }
            AppMethodBeat.o(265674);
            return;
          }
          if (!paramBoolean)
          {
            paramw.lvw = paramAnonymousString.Sjq;
            paramw.mhZ.lor = paramAnonymousString.IKh;
            s.bqB().c(paramw);
          }
          if ((!paramBoolean) && (paramAnonymousd.WQM.hRG() == localp) && (!paramAnonymousd.WQM.WQV.ehu())) {
            paramAnonymousd.k(paramca, paramInt);
          }
          AppMethodBeat.o(265674);
          return;
        }
        Log.w("MicroMsg.Imagegallery.handler.video", "MP_VIDEO_ERROR  end do exchange video link fail %d/%d %s", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), paramAnonymousString });
        AppMethodBeat.o(265674);
      }
    };
    kotlin.g.b.p.k(paramy, "mPShareVideoInfo");
    kotlin.g.b.p.k(localObject, "imgPath");
    kotlin.g.b.p.k(paramca, "callBack");
    paramw = paramy.OW((String)localObject);
    long l = ad.beh().I(paramw, true).Mh(r.WWy);
    if (Math.abs(System.currentTimeMillis() - l) < 300000L)
    {
      kotlin.g.b.p.j(paramw, "key");
      if (!Util.isNullOrNil(r.aqw(paramw)))
      {
        Log.i(r.TAG, "not do cgi in 5 min");
        return false;
      }
    }
    if ((r.WWB.containsKey(paramw)) && (r.WWB.get(paramw) != null))
    {
      parame = r.WWB.get(paramw);
      if (parame == null) {
        kotlin.g.b.p.iCn();
      }
      if (((Boolean)parame).booleanValue())
      {
        Log.w(r.TAG, paramw + " is doing");
        return false;
      }
    }
    Log.i(r.TAG, "MP_VIDEO  start do exchange video link");
    parame = (Map)r.WWB;
    kotlin.g.b.p.j(paramw, "key");
    parame.put(paramw, Boolean.TRUE);
    parame = new aa.f();
    parame.aaBC = new WeakReference(paramca);
    paramca = new cak();
    paramca.vid = paramy.RPa;
    paramca.TiN = paramy.ROZ;
    paramca.TiO = paramy.videoUrl;
    paramy = new d.a();
    paramy.lBU = ((com.tencent.mm.cd.a)paramca);
    paramy.lBV = ((com.tencent.mm.cd.a)new cal());
    paramy.uri = "/cgi-bin/mmbiz-bin/appmsg/getplayurl";
    paramy.funcId = 2962;
    paramy.lBW = 0;
    paramy.respCmdId = 0;
    IPCRunCgi.a(paramy.bgN(), (IPCRunCgi.a)new r.a(paramw, parame));
    return true;
  }
  
  static void b(p paramp)
  {
    if (paramp != null)
    {
      paramp.hSL();
      paramp.hSL().WVO.setVisibility(8);
    }
  }
  
  private static com.tencent.mm.aj.y bw(Activity paramActivity)
  {
    byte[] arrayOfByte;
    if (WQR == null)
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
      com.tencent.mm.aj.y localy = new com.tencent.mm.aj.y();
      localy.parseFrom(arrayOfByte);
      WQR = localy;
      return WQR;
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
  
  public static com.tencent.mm.aj.y cG(ca paramca)
  {
    if (paramca.hzq()) {
      return new com.tencent.mm.aj.y().a(paramca.VGz);
    }
    paramca = k.b.aG(paramca.field_content, paramca.field_reserved);
    if (paramca == null)
    {
      Log.w("MicroMsg.Imagegallery.handler.video", "getVideoInfo content is null");
      return null;
    }
    paramca = (com.tencent.mm.aj.e)paramca.ar(com.tencent.mm.aj.e.class);
    if ((paramca != null) && (paramca.llv != null)) {}
    for (paramca = paramca.llv;; paramca = null) {
      return paramca;
    }
  }
  
  public static w cH(ca paramca)
  {
    if (!f.m(paramca)) {
      return null;
    }
    return com.tencent.mm.modelvideo.y.Yk(paramca.field_imgPath);
  }
  
  public static w cI(ca paramca)
  {
    w localw = cH(paramca);
    if (localw != null) {
      return localw;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "insert video info:" + paramca.toString());
    localw = new w();
    localw.fPV = paramca.field_talker;
    localw.fileName = paramca.field_imgPath;
    if (paramca.field_createTime <= 0L) {}
    for (long l = System.currentTimeMillis();; l = paramca.field_createTime)
    {
      localw.createTime = l;
      localw.fNu = paramca.field_msgSvrId;
      localw.mhW = paramca.field_content;
      localw.mhR = ((int)paramca.field_msgId);
      com.tencent.mm.aj.y localy = cG(paramca);
      if (localy != null)
      {
        if (TextUtils.isEmpty(paramca.field_imgPath))
        {
          paramca.Jn(x.XS(paramca.field_talker));
          bh.beI();
          c.bbO().a(paramca.field_msgId, paramca);
        }
        localw.fileName = paramca.field_imgPath;
        r localr = r.WWC;
        localw.a(Util.nullAs(r.aqw(localy.OW(paramca.field_imgPath)), localy.videoUrl), localy.videoDuration, localy.title, localy.ROZ, "", "", "");
        localw.status = 111;
      }
      s.bqB().b(localw);
      return localw;
    }
  }
  
  public static ca f(String paramString, Activity paramActivity)
  {
    ca localca = new ca();
    localca.setType(486539313);
    localca.Jm(paramString);
    localca.VGA = true;
    localca.VGz = bw(paramActivity);
    localca.Jn(paramActivity.getIntent().getStringExtra("img_gallery_path"));
    return localca;
  }
  
  abstract void MX(int paramInt);
  
  abstract void a(p paramp);
  
  void a(p paramp, String paramString)
  {
    if (paramp != null)
    {
      paramp.hSL();
      if (this.WQM != null) {}
    }
    else
    {
      return;
    }
    paramp.hSL().WVO.setVisibility(0);
    paramp.hSL().WVP.setText(Util.nullAs(paramString, this.WQM.WQV.getString(R.l.video_play_faile)));
    paramp.hSL().WVJ.setVisibility(0);
    paramp.hSL().WVK.setVisibility(8);
    a(paramp);
  }
  
  abstract void avQ(int paramInt);
  
  abstract void cv(int paramInt1, int paramInt2);
  
  final boolean evg()
  {
    if ((this.WQM == null) || (this.WQM.WQV == null)) {
      return true;
    }
    return this.WQM.WQV.isFinishing();
  }
  
  abstract void hRB();
  
  abstract void hRC();
  
  public final u hRD()
  {
    Object localObject = this.WQM.hRF();
    if (localObject == null)
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, msgInfo is null");
      return null;
    }
    if ((!((ca)localObject).dlS()) && (((ca)localObject).Ic()))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, msgInfo is cleaned");
      return u.WWI;
    }
    localObject = cH((ca)localObject);
    if ((localObject == null) || (((w)localObject).status == 198))
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, videoInfo is null or failed");
      return u.WWI;
    }
    if (((w)localObject).bqS())
    {
      Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, downloaded");
      return u.WWK;
    }
    Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, not downloaded");
    return u.WWJ;
  }
  
  abstract void k(ca paramca, int paramInt);
  
  abstract void l(ca paramca, int paramInt);
  
  abstract void onResume();
  
  abstract void stopAll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e
 * JD-Core Version:    0.7.0.1
 */