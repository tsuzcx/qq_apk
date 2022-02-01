package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.Point;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;", "", "()V", "encoderX264Encoder", "", "getEncoderX264Encoder", "()Z", "setEncoderX264Encoder", "(Z)V", "mFadeImageShader", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/FadeImageShader;", "playItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "getRenderScriptBlur", "()Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "setRenderScriptBlur", "(Lcom/tencent/mm/ui/blur/RenderScriptBlur;)V", "addBitmap", "", "bm", "Landroid/graphics/Bitmap;", "bmBg", "addImage", "path", "", "mWidth", "", "mHeight", "clearImages", "createPlayAction", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "ts", "", "destroyRS", "initInGLThread", "loadImage", "playItem", "readPictureDegree", "resetTexId", "resizeBitmap", "bitmap", "start", "curTs", "viewPortWidth", "viewPortHeight", "Companion", "PlayAction", "PlayItem", "plugin-recordvideo_release"})
public final class g
{
  private static final float[] BLQ;
  private static final float[] BLR;
  private static final long BLS = 1380L;
  private static final long BLT = 300L;
  private static final long BLU = 1530L;
  private static final long BLV = 1680L;
  private static final long BLW = 15000L;
  public static final g.a BLX;
  private static final String TAG = "MicroMsg.Story.StoryImagePlayer";
  private final ArrayList<c> BLM;
  final b BLN;
  com.tencent.mm.ui.blur.e BLO;
  boolean BLP;
  
  static
  {
    AppMethodBeat.i(75315);
    BLX = new g.a((byte)0);
    TAG = "MicroMsg.Story.StoryImagePlayer";
    BLQ = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    BLR = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    BLS = 1380L;
    BLT = 300L;
    BLU = BLT / 2L + 1380L;
    BLV = BLT + BLS;
    BLW = 15000L;
    AppMethodBeat.o(75315);
  }
  
  public g()
  {
    AppMethodBeat.i(75314);
    this.BLM = new ArrayList();
    this.BLN = new b();
    AppMethodBeat.o(75314);
  }
  
  private final void a(c paramc)
  {
    AppMethodBeat.i(75312);
    Bitmap localBitmap2;
    if ((paramc.iKs == null) || (paramc.BMd == null))
    {
      Object localObject2 = new c("addImage");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramc.path, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      localOptions.inSampleSize = BitmapUtil.calculateInSampleSize(i, j, com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize(), com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize());
      localOptions.inJustDecodeBounds = false;
      if ((Build.VERSION.SDK_INT > 26) && ((p.j(localOptions.outColorSpace, ColorSpace.get(ColorSpace.Named.DCI_P3))) || (p.j(localOptions.outColorSpace, ColorSpace.get(ColorSpace.Named.DISPLAY_P3))))) {
        localOptions.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
      }
      localBitmap2 = am(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      Log.i(TAG, "resizeBitmap first ".concat(String.valueOf(localObject2)));
      long l = System.currentTimeMillis();
      localOptions.inSampleSize = BitmapUtil.calculateInSampleSize(i, j, com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize() / 2, com.tencent.mm.plugin.recordvideo.b.e.BNm.getMaxSize() / 2);
      Bitmap localBitmap1 = am(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      try
      {
        if (this.BLO == null) {
          this.BLO = new com.tencent.mm.ui.blur.e(MMApplicationContext.getContext());
        }
        com.tencent.mm.ui.blur.e locale = this.BLO;
        if (locale == null) {
          p.hyc();
        }
        localBitmap1 = locale.b(localBitmap1, 4.0F);
        p.g(localBitmap1, "renderScriptBlur!!.blur(tmpBg, 4f)");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "rsblur exception", new Object[0]);
          Log.i(TAG, "rsblur exception, path:%s", new Object[] { paramc.path });
          if (Log.getLogLevel() > 0) {
            Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"RenderScript Exception", 0).show();
          }
          localObject1 = com.tencent.mm.plugin.recordvideo.b.e.BNm.eJv();
          localObject1 = BitmapUtil.createColorBitmap(Color.parseColor("#ff000000"), ((Point)localObject1).x, ((Point)localObject1).y);
          p.g(localObject1, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
        }
        paramc.iKs = localBitmap2;
        paramc.BMd = ((Bitmap)localObject1);
        Object localObject1 = paramc.iKs;
        if (localObject1 != null) {
          break label614;
        }
        p.hyc();
        paramc.BMe = ((Bitmap)localObject1).getWidth();
        localObject1 = paramc.iKs;
        if (localObject1 != null) {
          break label637;
        }
        p.hyc();
        paramc.BMf = ((Bitmap)localObject1).getHeight();
      }
      Log.i(TAG, "fastblur cost:%s, sampleSize:%s, width:%s, height:%s resizeBitmap second ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localOptions.inSampleSize), Integer.valueOf(localBitmap1.getWidth()), Integer.valueOf(localBitmap1.getHeight()) });
      if (localBitmap2 != null)
      {
        i = aLm(paramc.path);
        if (i != 0)
        {
          localObject2 = new android.graphics.Matrix();
          ((android.graphics.Matrix)localObject2).postRotate(i);
          localBitmap2 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), localBitmap2.getHeight(), (android.graphics.Matrix)localObject2, true);
          localBitmap1 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), (android.graphics.Matrix)localObject2, true);
          paramc.iKs = localBitmap2;
          localBitmap2 = paramc.iKs;
          if (localBitmap2 == null) {
            p.hyc();
          }
          paramc.BMe = localBitmap2.getWidth();
          localBitmap2 = paramc.iKs;
          if (localBitmap2 == null) {
            p.hyc();
          }
          paramc.BMf = localBitmap2.getHeight();
          paramc.BMd = localBitmap1;
          AppMethodBeat.o(75312);
          return;
        }
      }
    }
    label614:
    label637:
    AppMethodBeat.o(75312);
  }
  
  private static int aLm(String paramString)
  {
    AppMethodBeat.i(75310);
    p.h(paramString, "path");
    try
    {
      i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
      AppMethodBeat.o(75310);
      return i;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramString, "readPictureDegree", new Object[0]);
        int i = 0;
      }
    }
  }
  
  private static Bitmap am(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75313);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap.getWidth() % 2 == 1)
      {
        localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (localBitmap == null) {
          p.hyc();
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
  
  public final void a(String paramString, com.tencent.mm.ui.blur.e parame)
  {
    AppMethodBeat.i(75306);
    p.h(paramString, "path");
    p.h(parame, "renderScriptBlur");
    Log.i(TAG, "addImage");
    parame = new c();
    p.h(paramString, "<set-?>");
    parame.path = paramString;
    this.BLM.add(parame);
    AppMethodBeat.o(75306);
  }
  
  public final void eJm()
  {
    try
    {
      AppMethodBeat.i(75307);
      Log.i(TAG, "clearImages");
      this.BLM.clear();
      AppMethodBeat.o(75307);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void eJn()
  {
    try
    {
      AppMethodBeat.i(75308);
      Object localObject1 = this.BLM;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          c localc = (c)((Iterator)localObject1).next();
          localc.cKI = 0;
          localc.BMg = 0;
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
  
  public final void eJo()
  {
    AppMethodBeat.i(75309);
    try
    {
      com.tencent.mm.ui.blur.e locale = this.BLO;
      if (locale != null) {
        locale.destroy();
      }
      this.BLO = null;
      AppMethodBeat.o(75309);
      return;
    }
    catch (Exception localException)
    {
      this.BLO = null;
      AppMethodBeat.o(75309);
    }
  }
  
  public final void n(long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        AppMethodBeat.i(75311);
        b localb = new b();
        if (this.BLM.size() == 0)
        {
          localb = null;
          if ((localb == null) || (localb.index < 0)) {
            AppMethodBeat.o(75311);
          }
        }
        else
        {
          if (this.BLM.size() == 1)
          {
            localb.index = 0;
            localb.BLY = 0.0F;
            localb.BLZ = 1.0F;
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
            localObject2[0] = ((float)paramLong / (float)BLW / 2.0F + 1.0F);
            localObject2[5] = localObject2[0];
            android.opengl.Matrix.multiplyMM(localb.BMa, 0, BLQ, 0, BLR, 0);
            android.opengl.Matrix.multiplyMM(localb.BMb, 0, (float[])localObject2, 0, BLR, 0);
            if (!this.BLP) {
              break label914;
            }
            android.opengl.Matrix.scaleM(localb.BMa, 0, 1.0F, -1.0F, 1.0F);
            android.opengl.Matrix.scaleM(localb.BMb, 0, 1.0F, -1.0F, 1.0F);
            break label914;
          }
          android.opengl.Matrix.multiplyMM(localb.BMa, 0, BLQ, 0, BLR, 0);
          android.opengl.Matrix.multiplyMM(localb.BMb, 0, BLQ, 0, BLR, 0);
          if (paramLong >= BLU + BLV * (this.BLM.size() - 1)) {
            break label920;
          }
          i = 1;
          if (paramLong <= BLU) {
            break label926;
          }
          l = ((paramLong - BLU) / BLV + 1L) % this.BLM.size();
          localb.index = ((int)l);
          if ((l != 0L) || (i == 0))
          {
            l = paramLong;
            if (paramLong > BLU) {
              l = (paramLong - BLU) % BLV;
            }
            if (l >= BLT) {
              break label932;
            }
            i = 1;
            if (i != 0)
            {
              localb.BLZ = ((float)l / (float)BLT);
              localb.BLY = (1.0F - localb.BLZ);
              if (!this.BLP) {
                break label917;
              }
              android.opengl.Matrix.scaleM(localb.BMa, 0, 1.0F, -1.0F, 1.0F);
              android.opengl.Matrix.scaleM(localb.BMb, 0, 1.0F, -1.0F, 1.0F);
              break label917;
            }
          }
          localb.BLY = 0.0F;
          localb.BLZ = 1.0F;
          continue;
        }
        this.BLN.eJh();
      }
      finally {}
      if (localObject1.BLY > 0.0F) {
        if (localObject1.index - 1 >= 0)
        {
          localObject2 = this.BLM.get(localObject1.index - 1);
          p.g(localObject2, "playItems[playAction.index - 1]");
          localObject2 = (c)localObject2;
          label551:
          a((c)localObject2);
          this.BLN.a(paramInt1, paramInt2, ((c)localObject2).BMe, ((c)localObject2).BMf, localObject1.BMa[0]);
          this.BLN.bK(localObject1.BLY);
          GLES20.glActiveTexture(33984);
          ((c)localObject2).cKI = b.h(((c)localObject2).iKs, ((c)localObject2).cKI);
          this.BLN.hT(((c)localObject2).cKI, 0);
          GLES20.glActiveTexture(33985);
          ((c)localObject2).BMg = b.h(((c)localObject2).BMd, ((c)localObject2).BMg);
          this.BLN.hU(((c)localObject2).BMg, 1);
          this.BLN.m(localObject1.BMa);
          b.eJj();
        }
      }
      for (int i = 2;; i = 0)
      {
        if (localObject1.BLZ > 0.0F)
        {
          localObject2 = this.BLM.get(localObject1.index);
          p.g(localObject2, "playItems[playAction.index]");
          localObject2 = (c)localObject2;
          a((c)localObject2);
          this.BLN.a(paramInt1, paramInt2, ((c)localObject2).BMe, ((c)localObject2).BMf, localObject1.BMb[0]);
          this.BLN.bK(localObject1.BLZ);
          GLES20.glActiveTexture(33984 + i);
          ((c)localObject2).cKI = b.h(((c)localObject2).iKs, ((c)localObject2).cKI);
          b localb1 = this.BLN;
          paramInt1 = ((c)localObject2).cKI;
          paramInt2 = i + 1;
          localb1.hT(paramInt1, i);
          GLES20.glActiveTexture(33984 + paramInt2);
          ((c)localObject2).BMg = b.h(((c)localObject2).BMd, ((c)localObject2).BMg);
          this.BLN.hU(((c)localObject2).BMg, paramInt2);
          this.BLN.m(localObject1.BMb);
          b.eJj();
        }
        AppMethodBeat.o(75311);
        break;
        localObject2 = (c)j.ku((List)this.BLM);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bgAlpha", "", "getBgAlpha", "()F", "setBgAlpha", "(F)V", "bgMvpMatrix", "", "getBgMvpMatrix", "()[F", "setBgMvpMatrix", "([F)V", "fgAlpha", "getFgAlpha", "setFgAlpha", "fgMvpMatrix", "getFgMvpMatrix", "setFgMvpMatrix", "index", "", "getIndex", "()I", "setIndex", "(I)V", "plugin-recordvideo_release"})
  public final class b
  {
    float BLY;
    float BLZ;
    float[] BMa;
    float[] BMb;
    int index;
    
    public b()
    {
      AppMethodBeat.i(75305);
      this.index = -1;
      this.BLY = 1.0F;
      this.BMa = new float[16];
      this.BMb = new float[16];
      AppMethodBeat.o(75305);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bm", "Landroid/graphics/Bitmap;", "getBm", "()Landroid/graphics/Bitmap;", "setBm", "(Landroid/graphics/Bitmap;)V", "bmBg", "getBmBg", "setBmBg", "bmHeight", "", "getBmHeight", "()I", "setBmHeight", "(I)V", "bmWidth", "getBmWidth", "setBmWidth", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "texBgId", "getTexBgId", "setTexBgId", "texId", "getTexId", "setTexId", "plugin-recordvideo_release"})
  public final class c
  {
    Bitmap BMd;
    int BMe;
    int BMf;
    int BMg;
    int cKI;
    Bitmap iKs;
    String path = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.g
 * JD-Core Version:    0.7.0.1
 */