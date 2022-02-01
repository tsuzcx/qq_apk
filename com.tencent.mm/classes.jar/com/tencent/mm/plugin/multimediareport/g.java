package com.tencent.mm.plugin.multimediareport;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.gogcv.Api;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.v;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends q
  implements m
{
  private static boolean gKM;
  private static Api zGY;
  private static boolean zGZ;
  private com.tencent.mm.ak.i callback;
  private com.tencent.mm.ak.d hJu;
  
  static
  {
    AppMethodBeat.i(194284);
    zGY = new Api();
    gKM = false;
    zGZ = false;
    AppMethodBeat.o(194284);
  }
  
  private g(d paramd, int paramInt, long paramLong)
  {
    AppMethodBeat.i(194281);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new e();
    ((d.a)localObject).iLO = new f();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mulmediareportcgi";
    this.hJu = ((d.a)localObject).aXF();
    localObject = (e)this.hJu.iLK.iLR;
    ((e)localObject).zGX = paramd;
    ((e)localObject).scene = paramInt;
    ((e)localObject).timestamp = paramLong;
    com.tencent.mm.kernel.g.aAf();
    ((e)localObject).zGW = a.getUin();
    if (paramInt == 2)
    {
      paramd.zGT = v.Ie(paramd.pPz);
      paramd.zGK = Util.safeParseLong(paramd.pPz.substring(0, paramd.pPz.indexOf('@')));
    }
    Log.i("MicroMsg.NetSceneMultiMediaReport", "NetSceneMultiMediaReport init, MediaScene:%s, mediaid:%s, MediaType:%s, MediaSource:%s, to_username:%s, chatromid:%s, sns_url:%s, fileid:%s, filekey:%s, md5:%s, createtime:%s, media_width:%s, media_height:%s, thumb_url:%s, video_len:%s, video_fps:%s, audio_sample_rate:%s, video_codec:%s, audio_codec:%s, qrcode_url：%s, chatroom_size:%s, uuid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramd.zGI), Integer.valueOf(paramd.zGJ), Integer.valueOf(paramd.source), paramd.pPz, Long.valueOf(paramd.zGK), paramd.zGL, paramd.fileid, paramd.zGM, paramd.md5, Long.valueOf(paramd.createtime), Integer.valueOf(paramd.zGN), Integer.valueOf(paramd.zGO), paramd.gTB, Integer.valueOf(paramd.zGP), Integer.valueOf(paramd.hyI), Integer.valueOf(paramd.zGQ), paramd.zGR, paramd.zGS, paramd.qwo, Integer.valueOf(paramd.zGT), paramd.uuid });
    AppMethodBeat.o(194281);
  }
  
  public static void a(d paramd, final int paramInt, long paramLong, final String paramString)
  {
    AppMethodBeat.i(194280);
    Log.i("MicroMsg.NetSceneMultiMediaReport", "goto report, id:%d", new Object[] { Long.valueOf(paramLong) });
    if (Util.isOverseasUser(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(194280);
      return;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sob, 0) != 1)
    {
      AppMethodBeat.o(194280);
      return;
    }
    String str;
    if ((!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT >= ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sod, 29)))
    {
      str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soe, "");
      if ((!Util.isNullOrNil(Build.BRAND)) && (str.toLowerCase().contains(Build.BRAND.toLowerCase())))
      {
        AppMethodBeat.o(194280);
        return;
      }
    }
    if (!gKM)
    {
      com.tencent.mm.pluginsdk.j.a.a.b.gnC();
      str = com.tencent.mm.pluginsdk.j.a.a.b.kC(83, 2);
      if (!com.tencent.mm.vfs.s.YS(str)) {
        break label233;
      }
      j.load("ginfo");
      zGZ = zGY.init(str);
      Log.w("MicroMsg.NetSceneMultiMediaReport", "init gogcv model! path: %s, result:%b", new Object[] { str, Boolean.valueOf(zGZ) });
    }
    for (;;)
    {
      gKM = true;
      if (zGZ) {
        break;
      }
      AppMethodBeat.o(194280);
      return;
      label233:
      com.tencent.mm.pluginsdk.j.a.a.b.gnC();
      com.tencent.mm.pluginsdk.j.a.a.b.ahP(83);
    }
    h.RTc.e(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194279);
        Log.i("MicroMsg.NetSceneMultiMediaReport", "do report, id:%d", new Object[] { Long.valueOf(this.val$timestamp) });
        Object localObject;
        int i;
        if (paramString.zGJ == 1)
        {
          localObject = BitmapUtil.getImageOptions(paramInt);
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sof, 2048);
          if (((BitmapFactory.Options)localObject).outWidth * ((BitmapFactory.Options)localObject).outHeight > i * i)
          {
            Log.w("MicroMsg.NetSceneMultiMediaReport", "image too large (%d * %d)", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight) });
            localObject = new byte[0];
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.NetSceneMultiMediaReport", "gogcv check result:%s, path:%s", new Object[] { new String((byte[])localObject), paramInt });
          paramString.zGU = new com.tencent.mm.bw.b((byte[])localObject);
          localObject = new g(paramString, this.gsA, this.val$timestamp, (byte)0);
          com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
          AppMethodBeat.o(194279);
          return;
          if (localObject != null)
          {
            paramString.zGN = ((BitmapFactory.Options)localObject).outWidth;
            paramString.zGO = ((BitmapFactory.Options)localObject).outHeight;
          }
          localObject = BitmapUtil.decodeFile(com.tencent.mm.vfs.s.k(paramInt, false), null);
          localObject = g.ely().checkImage((Bitmap)localObject);
          continue;
          try
          {
            localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soc, "0,0.5,1.0").split(",");
            float[] arrayOfFloat = new float[localObject.length];
            i = 0;
            while (i < localObject.length)
            {
              arrayOfFloat[i] = Util.getFloat(localObject[i], 0.0F);
              i += 1;
            }
            g.ely();
            localObject = Api.a(com.tencent.mm.vfs.s.k(paramInt, false), arrayOfFloat);
            localObject = g.ely().checkVideo((Bitmap[])localObject);
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.NetSceneMultiMediaReport", localException, String.format("error %s", new Object[] { paramInt }), new Object[0]);
            byte[] arrayOfByte = new byte[0];
          }
        }
      }
    }, "ginforeport");
    AppMethodBeat.o(194280);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(194282);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(194282);
    return i;
  }
  
  public final int getType()
  {
    return 5865;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194283);
    Log.i("MicroMsg.NetSceneMultiMediaReport", "onGYNetEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(194283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.g
 * JD-Core Version:    0.7.0.1
 */