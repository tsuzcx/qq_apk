package com.tencent.mm.plugin.multimediareport;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.gogcv.Api;
import com.tencent.mm.model.v;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class g
  extends q
  implements m
{
  private static Api Fmi;
  private static boolean Fmj;
  private static boolean jvb;
  private com.tencent.mm.an.i callback;
  private com.tencent.mm.an.d kwO;
  
  static
  {
    AppMethodBeat.i(187577);
    Fmi = new Api();
    jvb = false;
    Fmj = false;
    AppMethodBeat.o(187577);
  }
  
  private g(d paramd, int paramInt, long paramLong)
  {
    AppMethodBeat.i(187566);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new e();
    ((d.a)localObject).lBV = new f();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mulmediareportcgi";
    this.kwO = ((d.a)localObject).bgN();
    localObject = (e)d.b.b(this.kwO.lBR);
    ((e)localObject).Fmh = paramd;
    ((e)localObject).scene = paramInt;
    ((e)localObject).timestamp = paramLong;
    com.tencent.mm.kernel.h.aHE();
    ((e)localObject).Fmg = com.tencent.mm.kernel.b.getUin();
    if (paramInt == 2)
    {
      paramd.Fmd = v.Pu(paramd.sWA);
      paramd.FlU = Util.safeParseLong(paramd.sWA.substring(0, paramd.sWA.indexOf('@')));
    }
    Log.i("MicroMsg.NetSceneMultiMediaReport", "NetSceneMultiMediaReport init, MediaScene:%s, mediaid:%s, MediaType:%s, MediaSource:%s, to_username:%s, chatromid:%s, sns_url:%s, fileid:%s, filekey:%s, md5:%s, createtime:%s, media_width:%s, media_height:%s, thumb_url:%s, video_len:%s, video_fps:%s, audio_sample_rate:%s, video_codec:%s, audio_codec:%s, qrcode_url：%s, chatroom_size:%s, uuid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramd.FlS), Integer.valueOf(paramd.FlT), Integer.valueOf(paramd.source), paramd.sWA, Long.valueOf(paramd.FlU), paramd.FlV, paramd.fileid, paramd.FlW, paramd.md5, Long.valueOf(paramd.createtime), Integer.valueOf(paramd.FlX), Integer.valueOf(paramd.FlY), paramd.jEd, Integer.valueOf(paramd.FlZ), Integer.valueOf(paramd.klF), Integer.valueOf(paramd.Fma), paramd.Fmb, paramd.Fmc, paramd.tVp, Integer.valueOf(paramd.Fmd), paramd.uuid });
    AppMethodBeat.o(187566);
  }
  
  public static void a(d paramd, final int paramInt, long paramLong, final String paramString)
  {
    AppMethodBeat.i(187562);
    Log.i("MicroMsg.NetSceneMultiMediaReport", "goto report, id:%d", new Object[] { Long.valueOf(paramLong) });
    if (Util.isOverseasUser(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(187562);
      return;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZy, 0) != 1)
    {
      AppMethodBeat.o(187562);
      return;
    }
    if ((!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT >= ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZA, 29)))
    {
      localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZB, "");
      if ((!Util.isNullOrNil(Build.BRAND)) && (((String)localObject).toLowerCase().contains(Build.BRAND.toLowerCase())))
      {
        AppMethodBeat.o(187562);
        return;
      }
    }
    Object localObject = (com.tencent.mm.plugin.performance.a.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.performance.a.e.class);
    if ((localObject != null) && (((com.tencent.mm.plugin.performance.a.e)localObject).bwe()))
    {
      Log.i("MicroMsg.NetSceneMultiMediaReport", "gogcv disabled by memory degrade.");
      AppMethodBeat.o(187562);
      return;
    }
    if (!jvb)
    {
      com.tencent.mm.pluginsdk.k.a.a.b.hii();
      localObject = com.tencent.mm.pluginsdk.k.a.a.b.lV(83, 2);
      if (!u.agG((String)localObject)) {
        break label273;
      }
      j.load("ginfo");
      Fmj = Fmi.init((String)localObject);
      Log.w("MicroMsg.NetSceneMultiMediaReport", "init gogcv model! path: %s, result:%b", new Object[] { localObject, Boolean.valueOf(Fmj) });
    }
    for (;;)
    {
      jvb = true;
      if (Fmj) {
        break;
      }
      AppMethodBeat.o(187562);
      return;
      label273:
      com.tencent.mm.pluginsdk.k.a.a.b.hii();
      com.tencent.mm.pluginsdk.k.a.a.b.apP(83);
    }
    com.tencent.e.h.ZvG.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187556);
        Log.i("MicroMsg.NetSceneMultiMediaReport", "do report, id:%d", new Object[] { Long.valueOf(this.val$timestamp) });
        Object localObject;
        int i;
        if (paramString.FlT == 1)
        {
          localObject = BitmapUtil.getImageOptions(paramInt);
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZC, 2048);
          if (((BitmapFactory.Options)localObject).outWidth * ((BitmapFactory.Options)localObject).outHeight > i * i)
          {
            Log.w("MicroMsg.NetSceneMultiMediaReport", "image too large (%d * %d)", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight) });
            localObject = new byte[0];
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.NetSceneMultiMediaReport", "gogcv check result:%s, path:%s", new Object[] { new String((byte[])localObject), paramInt });
          paramString.Fme = new com.tencent.mm.cd.b((byte[])localObject);
          localObject = new g(paramString, this.iWM, this.val$timestamp, (byte)0);
          com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
          AppMethodBeat.o(187556);
          return;
          if (localObject != null)
          {
            paramString.FlX = ((BitmapFactory.Options)localObject).outWidth;
            paramString.FlY = ((BitmapFactory.Options)localObject).outHeight;
          }
          localObject = BitmapUtil.decodeFile(u.n(paramInt, false), null);
          localObject = g.eVh().checkImage((Bitmap)localObject);
          continue;
          try
          {
            localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZz, "0,0.5,1.0").split(",");
            float[] arrayOfFloat = new float[localObject.length];
            i = 0;
            while (i < localObject.length)
            {
              arrayOfFloat[i] = Util.getFloat(localObject[i], 0.0F);
              i += 1;
            }
            g.eVh();
            localObject = Api.a(u.n(paramInt, false), arrayOfFloat);
            localObject = g.eVh().checkVideo((Bitmap[])localObject);
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.NetSceneMultiMediaReport", localException, String.format("error %s", new Object[] { paramInt }), new Object[0]);
            byte[] arrayOfByte = new byte[0];
          }
        }
      }
    }, "ginforeport");
    AppMethodBeat.o(187562);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(187569);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(187569);
    return i;
  }
  
  public final int getType()
  {
    return 5865;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187572);
    Log.i("MicroMsg.NetSceneMultiMediaReport", "onGYNetEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(187572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.g
 * JD-Core Version:    0.7.0.1
 */