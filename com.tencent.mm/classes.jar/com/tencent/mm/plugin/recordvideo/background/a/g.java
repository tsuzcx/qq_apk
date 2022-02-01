package com.tencent.mm.plugin.recordvideo.background.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.opengl.GLES20;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.f;
import d.a.j;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;", "", "()V", "encoderX264Encoder", "", "getEncoderX264Encoder", "()Z", "setEncoderX264Encoder", "(Z)V", "mFadeImageShader", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/FadeImageShader;", "playItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "getRenderScriptBlur", "()Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "setRenderScriptBlur", "(Lcom/tencent/mm/ui/blur/RenderScriptBlur;)V", "addBitmap", "", "bm", "Landroid/graphics/Bitmap;", "bmBg", "addImage", "path", "", "mWidth", "", "mHeight", "clearImages", "createPlayAction", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "ts", "", "destroyRS", "initInGLThread", "loadImage", "playItem", "readPictureDegree", "resetTexId", "resizeBitmap", "bitmap", "start", "curTs", "viewPortWidth", "viewPortHeight", "Companion", "PlayAction", "PlayItem", "plugin-recordvideo_release"})
public final class g
{
  private static final String TAG = "MicroMsg.Story.StoryImagePlayer";
  private static final float[] vfk;
  private static final float[] vfl;
  private static final long vfm = 1380L;
  private static final long vfn = 300L;
  private static final long vfo = 1530L;
  private static final long vfp = 1680L;
  private static final long vfq = 15000L;
  public static final g.a vfr;
  private final ArrayList<c> vfg;
  final b vfh;
  com.tencent.mm.ui.blur.e vfi;
  boolean vfj;
  
  static
  {
    AppMethodBeat.i(75315);
    vfr = new g.a((byte)0);
    TAG = "MicroMsg.Story.StoryImagePlayer";
    vfk = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    vfl = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    vfm = 1380L;
    vfn = 300L;
    vfo = vfn / 2L + 1380L;
    vfp = vfn + vfm;
    vfq = 15000L;
    AppMethodBeat.o(75315);
  }
  
  public g()
  {
    AppMethodBeat.i(75314);
    this.vfg = new ArrayList();
    this.vfh = new b();
    AppMethodBeat.o(75314);
  }
  
  private final void a(c paramc)
  {
    AppMethodBeat.i(75312);
    Bitmap localBitmap2;
    if ((paramc.gTB == null) || (paramc.vfx == null))
    {
      Object localObject2 = new com.tencent.mm.ad.b("addImage");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramc.path, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      localOptions.inSampleSize = f.M(i, j, com.tencent.mm.plugin.recordvideo.b.e.vgG.getMaxSize(), com.tencent.mm.plugin.recordvideo.b.e.vgG.getMaxSize());
      localOptions.inJustDecodeBounds = false;
      localBitmap2 = aa(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      ad.i(TAG, "resizeBitmap first ".concat(String.valueOf(localObject2)));
      long l = System.currentTimeMillis();
      localOptions.inSampleSize = f.M(i, j, com.tencent.mm.plugin.recordvideo.b.e.vgG.getMaxSize() / 2, com.tencent.mm.plugin.recordvideo.b.e.vgG.getMaxSize() / 2);
      Bitmap localBitmap1 = aa(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      try
      {
        if (this.vfi == null) {
          this.vfi = new com.tencent.mm.ui.blur.e(aj.getContext());
        }
        com.tencent.mm.ui.blur.e locale = this.vfi;
        if (locale == null) {
          k.fvU();
        }
        localBitmap1 = locale.d(localBitmap1, 4.0F);
        k.g(localBitmap1, "renderScriptBlur!!.blur(tmpBg, 4f)");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace(TAG, (Throwable)localException, "rsblur exception", new Object[0]);
          ad.i(TAG, "rsblur exception, path:%s", new Object[] { paramc.path });
          if (ad.getLogLevel() > 0) {
            Toast.makeText(aj.getContext(), (CharSequence)"RenderScript Exception", 0).show();
          }
          localObject1 = com.tencent.mm.plugin.recordvideo.b.e.vgG.dhq();
          localObject1 = f.aG(Color.parseColor("#ff000000"), ((Point)localObject1).x, ((Point)localObject1).y);
          k.g(localObject1, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
        }
        paramc.gTB = localBitmap2;
        paramc.vfx = ((Bitmap)localObject1);
        Object localObject1 = paramc.gTB;
        if (localObject1 != null) {
          break label560;
        }
        k.fvU();
        paramc.vfy = ((Bitmap)localObject1).getWidth();
        localObject1 = paramc.gTB;
        if (localObject1 != null) {
          break label583;
        }
        k.fvU();
        paramc.vfz = ((Bitmap)localObject1).getHeight();
      }
      ad.i(TAG, "fastblur cost:%s, sampleSize:%s, width:%s, height:%s resizeBitmap second ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localOptions.inSampleSize), Integer.valueOf(localBitmap1.getWidth()), Integer.valueOf(localBitmap1.getHeight()) });
      if (localBitmap2 != null)
      {
        i = alG(paramc.path);
        if (i != 0)
        {
          localObject2 = new android.graphics.Matrix();
          ((android.graphics.Matrix)localObject2).postRotate(i);
          localBitmap2 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), localBitmap2.getHeight(), (android.graphics.Matrix)localObject2, true);
          localBitmap1 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), (android.graphics.Matrix)localObject2, true);
          paramc.gTB = localBitmap2;
          localBitmap2 = paramc.gTB;
          if (localBitmap2 == null) {
            k.fvU();
          }
          paramc.vfy = localBitmap2.getWidth();
          localBitmap2 = paramc.gTB;
          if (localBitmap2 == null) {
            k.fvU();
          }
          paramc.vfz = localBitmap2.getHeight();
          paramc.vfx = localBitmap1;
          AppMethodBeat.o(75312);
          return;
        }
      }
    }
    label560:
    label583:
    AppMethodBeat.o(75312);
  }
  
  private static Bitmap aa(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75313);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap.getWidth() % 2 == 1)
      {
        localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (localBitmap == null) {
          k.fvU();
        }
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawARGB(0, 0, 0, 0);
        localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      }
      AppMethodBeat.o(75313);
      return localBitmap;
    }
    AppMethodBeat.o(75313);
    return null;
  }
  
  private static int alG(String paramString)
  {
    AppMethodBeat.i(75310);
    k.h(paramString, "path");
    try
    {
      i = BackwardSupportUtil.ExifHelper.co(paramString);
      AppMethodBeat.o(75310);
      return i;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace(TAG, (Throwable)paramString, "readPictureDegree", new Object[0]);
        int i = 0;
      }
    }
  }
  
  public final void a(String paramString, com.tencent.mm.ui.blur.e parame)
  {
    AppMethodBeat.i(75306);
    k.h(paramString, "path");
    k.h(parame, "renderScriptBlur");
    ad.i(TAG, "addImage");
    parame = new c();
    k.h(paramString, "<set-?>");
    parame.path = paramString;
    this.vfg.add(parame);
    AppMethodBeat.o(75306);
  }
  
  public final void dhe()
  {
    try
    {
      AppMethodBeat.i(75307);
      ad.i(TAG, "clearImages");
      this.vfg.clear();
      AppMethodBeat.o(75307);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dhf()
  {
    try
    {
      AppMethodBeat.i(75308);
      Object localObject1 = this.vfg;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          c localc = (c)((Iterator)localObject1).next();
          localc.vfA = 0;
          localc.vfB = 0;
        }
        AppMethodBeat.o(75308);
      }
    }
    finally {}
    for (;;)
    {
      return;
      AppMethodBeat.o(75308);
    }
  }
  
  public final void dhg()
  {
    AppMethodBeat.i(75309);
    try
    {
      com.tencent.mm.ui.blur.e locale = this.vfi;
      if (locale != null) {
        locale.destroy();
      }
      this.vfi = null;
      AppMethodBeat.o(75309);
      return;
    }
    catch (Exception localException)
    {
      this.vfi = null;
      AppMethodBeat.o(75309);
    }
  }
  
  public final void m(long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        AppMethodBeat.i(75311);
        b localb = new b();
        if (this.vfg.size() == 0)
        {
          localb = null;
          if ((localb == null) || (localb.index < 0)) {
            AppMethodBeat.o(75311);
          }
        }
        else
        {
          if (this.vfg.size() == 1)
          {
            localb.index = 0;
            localb.vfs = 0.0F;
            localb.vft = 1.0F;
            localObject2 = new float[16];
            Object tmp90_88 = localObject2;
            tmp90_88[0] = 1.0F;
            Object tmp94_90 = tmp90_88;
            tmp94_90[1] = 0.0F;
            Object tmp98_94 = tmp94_90;
            tmp98_94[2] = 0.0F;
            Object tmp102_98 = tmp98_94;
            tmp102_98[3] = 0.0F;
            Object tmp106_102 = tmp102_98;
            tmp106_102[4] = 0.0F;
            Object tmp110_106 = tmp106_102;
            tmp110_106[5] = 1.0F;
            Object tmp114_110 = tmp110_106;
            tmp114_110[6] = 0.0F;
            Object tmp119_114 = tmp114_110;
            tmp119_114[7] = 0.0F;
            Object tmp124_119 = tmp119_114;
            tmp124_119[8] = 0.0F;
            Object tmp129_124 = tmp124_119;
            tmp129_124[9] = 0.0F;
            Object tmp134_129 = tmp129_124;
            tmp134_129[10] = 1.0F;
            Object tmp139_134 = tmp134_129;
            tmp139_134[11] = 0.0F;
            Object tmp144_139 = tmp139_134;
            tmp144_139[12] = 0.0F;
            Object tmp149_144 = tmp144_139;
            tmp149_144[13] = 0.0F;
            Object tmp154_149 = tmp149_144;
            tmp154_149[14] = 0.0F;
            Object tmp159_154 = tmp154_149;
            tmp159_154[15] = 1.0F;
            tmp159_154;
            localObject2[0] = ((float)paramLong / (float)vfq / 2.0F + 1.0F);
            localObject2[5] = localObject2[0];
            android.opengl.Matrix.multiplyMM(localb.vfu, 0, vfk, 0, vfl, 0);
            android.opengl.Matrix.multiplyMM(localb.vfv, 0, (float[])localObject2, 0, vfl, 0);
            if (!this.vfj) {
              break label914;
            }
            android.opengl.Matrix.scaleM(localb.vfu, 0, 1.0F, -1.0F, 1.0F);
            android.opengl.Matrix.scaleM(localb.vfv, 0, 1.0F, -1.0F, 1.0F);
            break label914;
          }
          android.opengl.Matrix.multiplyMM(localb.vfu, 0, vfk, 0, vfl, 0);
          android.opengl.Matrix.multiplyMM(localb.vfv, 0, vfk, 0, vfl, 0);
          if (paramLong >= vfo + vfp * (this.vfg.size() - 1)) {
            break label920;
          }
          i = 1;
          if (paramLong <= vfo) {
            break label926;
          }
          l = ((paramLong - vfo) / vfp + 1L) % this.vfg.size();
          localb.index = ((int)l);
          if ((l != 0L) || (i == 0))
          {
            l = paramLong;
            if (paramLong > vfo) {
              l = (paramLong - vfo) % vfp;
            }
            if (l >= vfn) {
              break label932;
            }
            i = 1;
            if (i != 0)
            {
              localb.vft = ((float)l / (float)vfn);
              localb.vfs = (1.0F - localb.vft);
              if (!this.vfj) {
                break label917;
              }
              android.opengl.Matrix.scaleM(localb.vfu, 0, 1.0F, -1.0F, 1.0F);
              android.opengl.Matrix.scaleM(localb.vfv, 0, 1.0F, -1.0F, 1.0F);
              break label917;
            }
          }
          localb.vfs = 0.0F;
          localb.vft = 1.0F;
          continue;
        }
        this.vfh.dgZ();
      }
      finally {}
      if (localObject1.vfs > 0.0F) {
        if (localObject1.index - 1 >= 0)
        {
          localObject2 = this.vfg.get(localObject1.index - 1);
          k.g(localObject2, "playItems[playAction.index - 1]");
          localObject2 = (c)localObject2;
          label551:
          a((c)localObject2);
          this.vfh.a(paramInt1, paramInt2, ((c)localObject2).vfy, ((c)localObject2).vfz, localObject1.vfu[0]);
          this.vfh.bh(localObject1.vfs);
          GLES20.glActiveTexture(33984);
          ((c)localObject2).vfA = b.f(((c)localObject2).gTB, ((c)localObject2).vfA);
          this.vfh.gJ(((c)localObject2).vfA, 0);
          GLES20.glActiveTexture(33985);
          ((c)localObject2).vfB = b.f(((c)localObject2).vfx, ((c)localObject2).vfB);
          this.vfh.gK(((c)localObject2).vfB, 1);
          this.vfh.o(localObject1.vfu);
          b.dhb();
        }
      }
      for (int i = 2;; i = 0)
      {
        if (localObject1.vft > 0.0F)
        {
          localObject2 = this.vfg.get(localObject1.index);
          k.g(localObject2, "playItems[playAction.index]");
          localObject2 = (c)localObject2;
          a((c)localObject2);
          this.vfh.a(paramInt1, paramInt2, ((c)localObject2).vfy, ((c)localObject2).vfz, localObject1.vfv[0]);
          this.vfh.bh(localObject1.vft);
          GLES20.glActiveTexture(33984 + i);
          ((c)localObject2).vfA = b.f(((c)localObject2).gTB, ((c)localObject2).vfA);
          b localb1 = this.vfh;
          paramInt1 = ((c)localObject2).vfA;
          paramInt2 = i + 1;
          localb1.gJ(paramInt1, i);
          GLES20.glActiveTexture(33984 + paramInt2);
          ((c)localObject2).vfB = b.f(((c)localObject2).vfx, ((c)localObject2).vfB);
          this.vfh.gK(((c)localObject2).vfB, paramInt2);
          this.vfh.o(localObject1.vfv);
          b.dhb();
        }
        AppMethodBeat.o(75311);
        break;
        localObject2 = (c)j.iA((List)this.vfg);
        break label551;
      }
      label914:
      continue;
      label917:
      continue;
      label920:
      i = 0;
      continue;
      label926:
      long l = 0L;
      continue;
      label932:
      i = 0;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bgAlpha", "", "getBgAlpha", "()F", "setBgAlpha", "(F)V", "bgMvpMatrix", "", "getBgMvpMatrix", "()[F", "setBgMvpMatrix", "([F)V", "fgAlpha", "getFgAlpha", "setFgAlpha", "fgMvpMatrix", "getFgMvpMatrix", "setFgMvpMatrix", "index", "", "getIndex", "()I", "setIndex", "(I)V", "plugin-recordvideo_release"})
  public final class b
  {
    int index;
    float vfs;
    float vft;
    float[] vfu;
    float[] vfv;
    
    public b()
    {
      AppMethodBeat.i(75305);
      this.index = -1;
      this.vfs = 1.0F;
      this.vfu = new float[16];
      this.vfv = new float[16];
      AppMethodBeat.o(75305);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bm", "Landroid/graphics/Bitmap;", "getBm", "()Landroid/graphics/Bitmap;", "setBm", "(Landroid/graphics/Bitmap;)V", "bmBg", "getBmBg", "setBmBg", "bmHeight", "", "getBmHeight", "()I", "setBmHeight", "(I)V", "bmWidth", "getBmWidth", "setBmWidth", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "texBgId", "getTexBgId", "setTexBgId", "texId", "getTexId", "setTexId", "plugin-recordvideo_release"})
  public final class c
  {
    Bitmap gTB;
    String path = "";
    int vfA;
    int vfB;
    Bitmap vfx;
    int vfy;
    int vfz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.g
 * JD-Core Version:    0.7.0.1
 */