package com.tencent.mm.plugin.multimediareport;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.gogcv.Api;
import com.tencent.mm.model.v;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;

public final class g
  extends p
  implements m
{
  private static Api Lik;
  private static boolean Lil;
  private static boolean lYs;
  private com.tencent.mm.am.h callback;
  private com.tencent.mm.am.c nao;
  
  static
  {
    AppMethodBeat.i(262718);
    Lik = new Api();
    lYs = false;
    Lil = false;
    AppMethodBeat.o(262718);
  }
  
  private g(d paramd, int paramInt, long paramLong)
  {
    AppMethodBeat.i(262708);
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).otE = new e();
    ((com.tencent.mm.am.c.a)localObject).otF = new f();
    ((com.tencent.mm.am.c.a)localObject).funcId = getType();
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/micromsg-bin/mulmediareportcgi";
    this.nao = ((com.tencent.mm.am.c.a)localObject).bEF();
    localObject = (e)c.b.b(this.nao.otB);
    ((e)localObject).Lij = paramd;
    ((e)localObject).scene = paramInt;
    ((e)localObject).timestamp = paramLong;
    com.tencent.mm.kernel.h.baC();
    ((e)localObject).Lii = com.tencent.mm.kernel.b.getUin();
    if (paramInt == 2)
    {
      paramd.Lif = v.getMembersCountByChatRoomName(paramd.waL);
      paramd.LhW = Util.safeParseLong(paramd.waL.substring(0, paramd.waL.indexOf('@')));
    }
    Log.i("MicroMsg.NetSceneMultiMediaReport", "NetSceneMultiMediaReport init, MediaScene:%s, mediaid:%s, MediaType:%s, MediaSource:%s, to_username:%s, chatromid:%s, sns_url:%s, fileid:%s, filekey:%s, md5:%s, createtime:%s, media_width:%s, media_height:%s, thumb_url:%s, video_len:%s, video_fps:%s, audio_sample_rate:%s, video_codec:%s, audio_codec:%s, qrcode_url：%s, chatroom_size:%s, uuid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramd.LhU), Integer.valueOf(paramd.LhV), Integer.valueOf(paramd.source), paramd.waL, Long.valueOf(paramd.LhW), paramd.LhX, paramd.fileid, paramd.LhY, paramd.md5, Long.valueOf(paramd.createtime), Integer.valueOf(paramd.LhZ), Integer.valueOf(paramd.Lia), paramd.mdZ, Integer.valueOf(paramd.Lib), Integer.valueOf(paramd.mMK), Integer.valueOf(paramd.Lic), paramd.Lid, paramd.Lie, paramd.wYJ, Integer.valueOf(paramd.Lif), paramd.uuid });
    AppMethodBeat.o(262708);
  }
  
  public static void a(d paramd, final int paramInt, long paramLong, final String paramString)
  {
    AppMethodBeat.i(262705);
    Log.i("MicroMsg.NetSceneMultiMediaReport", "goto report, id:%d", new Object[] { Long.valueOf(paramLong) });
    if (Util.isOverseasUser(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(262705);
      return;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zsZ, 0) != 1)
    {
      AppMethodBeat.o(262705);
      return;
    }
    if ((!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT >= ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztb, 29)))
    {
      localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztc, "");
      if ((!Util.isNullOrNil(Build.BRAND)) && (((String)localObject).toLowerCase().contains(Build.BRAND.toLowerCase())))
      {
        AppMethodBeat.o(262705);
        return;
      }
    }
    Object localObject = (com.tencent.mm.plugin.performance.a.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.performance.a.e.class);
    if ((localObject != null) && (((com.tencent.mm.plugin.performance.a.e)localObject).bUX()))
    {
      Log.i("MicroMsg.NetSceneMultiMediaReport", "gogcv disabled by memory degrade.");
      AppMethodBeat.o(262705);
      return;
    }
    if (!lYs)
    {
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      localObject = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(83, 2);
      if (!y.ZC((String)localObject)) {
        break label279;
      }
      if (com.tencent.mm.compatible.util.h.aQh())
      {
        k.load("ginfo");
        Lil = Lik.init((String)localObject);
        Log.w("MicroMsg.NetSceneMultiMediaReport", "init gogcv model! path: %s, result:%b", new Object[] { localObject, Boolean.valueOf(Lil) });
      }
    }
    for (;;)
    {
      lYs = true;
      if (Lil) {
        break;
      }
      AppMethodBeat.o(262705);
      return;
      label279:
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(83);
    }
    com.tencent.threadpool.h.ahAA.j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262712);
        Log.i("MicroMsg.NetSceneMultiMediaReport", "do report, id:%d", new Object[] { Long.valueOf(this.val$timestamp) });
        Object localObject;
        int i;
        if (paramString.LhV == 1)
        {
          localObject = BitmapUtil.getImageOptions(paramInt);
          i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztd, 2048);
          if (((BitmapFactory.Options)localObject).outWidth * ((BitmapFactory.Options)localObject).outHeight > i * i)
          {
            Log.w("MicroMsg.NetSceneMultiMediaReport", "image too large (%d * %d)", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject).outHeight) });
            localObject = new byte[0];
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.NetSceneMultiMediaReport", "gogcv check result:%s, path:%s", new Object[] { new String((byte[])localObject), paramInt });
          paramString.Lig = new com.tencent.mm.bx.b((byte[])localObject);
          localObject = new g(paramString, this.lyQ, this.val$timestamp, (byte)0);
          com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
          AppMethodBeat.o(262712);
          return;
          if (localObject != null)
          {
            paramString.LhZ = ((BitmapFactory.Options)localObject).outWidth;
            paramString.Lia = ((BitmapFactory.Options)localObject).outHeight;
          }
          localObject = BitmapUtil.decodeFile(y.n(paramInt, false), null);
          localObject = g.gdU().checkImage((Bitmap)localObject);
          continue;
          try
          {
            localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zta, "0,0.5,1.0").split(",");
            float[] arrayOfFloat = new float[localObject.length];
            i = 0;
            while (i < localObject.length)
            {
              arrayOfFloat[i] = Util.getFloat(localObject[i], 0.0F);
              i += 1;
            }
            g.gdU();
            localObject = Api.a(y.n(paramInt, false), arrayOfFloat);
            localObject = g.gdU().checkVideo((Bitmap[])localObject);
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.NetSceneMultiMediaReport", localException, String.format("error %s", new Object[] { paramInt }), new Object[0]);
            byte[] arrayOfByte = new byte[0];
          }
        }
      }
    }, "ginforeport");
    AppMethodBeat.o(262705);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(262725);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(262725);
    return i;
  }
  
  public final int getType()
  {
    return 5865;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262730);
    Log.i("MicroMsg.NetSceneMultiMediaReport", "onGYNetEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(262730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.g
 * JD-Core Version:    0.7.0.1
 */