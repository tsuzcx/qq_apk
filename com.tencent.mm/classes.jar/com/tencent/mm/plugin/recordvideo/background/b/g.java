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
import com.tencent.mm.ae.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.blur.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;", "", "()V", "encoderX264Encoder", "", "getEncoderX264Encoder", "()Z", "setEncoderX264Encoder", "(Z)V", "mFadeImageShader", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/FadeImageShader;", "playItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "getRenderScriptBlur", "()Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "setRenderScriptBlur", "(Lcom/tencent/mm/ui/blur/RenderScriptBlur;)V", "addBitmap", "", "bm", "Landroid/graphics/Bitmap;", "bmBg", "addImage", "path", "", "mWidth", "", "mHeight", "clearImages", "createPlayAction", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "ts", "", "destroyRS", "initInGLThread", "loadImage", "playItem", "readPictureDegree", "resetTexId", "resizeBitmap", "bitmap", "start", "curTs", "viewPortWidth", "viewPortHeight", "Companion", "PlayAction", "PlayItem", "plugin-recordvideo_release"})
public final class g
{
  private static final float[] HIb;
  private static final float[] HIc;
  private static final long HId = 1380L;
  private static final long HIe = 300L;
  private static final long HIf = 1530L;
  private static final long HIg = 1680L;
  private static final long HIh = 15000L;
  public static final g.a HIi;
  private static final String TAG = "MicroMsg.Story.StoryImagePlayer";
  private final ArrayList<c> HHX;
  final b HHY;
  e HHZ;
  boolean HIa;
  
  static
  {
    AppMethodBeat.i(75315);
    HIi = new g.a((byte)0);
    TAG = "MicroMsg.Story.StoryImagePlayer";
    HIb = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    HIc = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    HId = 1380L;
    HIe = 300L;
    HIf = HIe / 2L + 1380L;
    HIg = HIe + HId;
    HIh = 15000L;
    AppMethodBeat.o(75315);
  }
  
  public g()
  {
    AppMethodBeat.i(75314);
    this.HHX = new ArrayList();
    this.HHY = new b();
    AppMethodBeat.o(75314);
  }
  
  private final void a(c paramc)
  {
    AppMethodBeat.i(75312);
    Bitmap localBitmap2;
    if ((paramc.lAx == null) || (paramc.HIo == null))
    {
      Object localObject2 = new c("addImage");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramc.path, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      localOptions.inSampleSize = BitmapUtil.calculateInSampleSize(i, j, f.HJU.fvE(), f.HJU.fvE());
      localOptions.inJustDecodeBounds = false;
      if ((Build.VERSION.SDK_INT > 26) && ((p.h(localOptions.outColorSpace, ColorSpace.get(ColorSpace.Named.DCI_P3))) || (p.h(localOptions.outColorSpace, ColorSpace.get(ColorSpace.Named.DISPLAY_P3))))) {
        localOptions.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
      }
      localBitmap2 = aj(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      Log.i(TAG, "resizeBitmap first ".concat(String.valueOf(localObject2)));
      long l = System.currentTimeMillis();
      localOptions.inSampleSize = BitmapUtil.calculateInSampleSize(i, j, f.HJU.fvE() / 2, f.HJU.fvE() / 2);
      Bitmap localBitmap1 = aj(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      try
      {
        if (this.HHZ == null) {
          this.HHZ = new e(MMApplicationContext.getContext());
        }
        e locale = this.HHZ;
        if (locale == null) {
          p.iCn();
        }
        localBitmap1 = locale.b(localBitmap1, 4.0F);
        p.j(localBitmap1, "renderScriptBlur!!.blur(tmpBg, 4f)");
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
          localObject1 = f.HJU.fvF();
          localObject1 = BitmapUtil.createColorBitmap(Color.parseColor("#ff000000"), ((Point)localObject1).x, ((Point)localObject1).y);
          p.j(localObject1, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
        }
        paramc.lAx = localBitmap2;
        paramc.HIo = ((Bitmap)localObject1);
        Object localObject1 = paramc.lAx;
        if (localObject1 != null) {
          break label614;
        }
        p.iCn();
        paramc.HIp = ((Bitmap)localObject1).getWidth();
        localObject1 = paramc.lAx;
        if (localObject1 != null) {
          break label637;
        }
        p.iCn();
        paramc.HIq = ((Bitmap)localObject1).getHeight();
      }
      Log.i(TAG, "fastblur cost:%s, sampleSize:%s, width:%s, height:%s resizeBitmap second ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localOptions.inSampleSize), Integer.valueOf(localBitmap1.getWidth()), Integer.valueOf(localBitmap1.getHeight()) });
      if (localBitmap2 != null)
      {
        i = aVO(paramc.path);
        if (i != 0)
        {
          localObject2 = new android.graphics.Matrix();
          ((android.graphics.Matrix)localObject2).postRotate(i);
          localBitmap2 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), localBitmap2.getHeight(), (android.graphics.Matrix)localObject2, true);
          localBitmap1 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), (android.graphics.Matrix)localObject2, true);
          paramc.lAx = localBitmap2;
          localBitmap2 = paramc.lAx;
          if (localBitmap2 == null) {
            p.iCn();
          }
          paramc.HIp = localBitmap2.getWidth();
          localBitmap2 = paramc.lAx;
          if (localBitmap2 == null) {
            p.iCn();
          }
          paramc.HIq = localBitmap2.getHeight();
          paramc.HIo = localBitmap1;
          AppMethodBeat.o(75312);
          return;
        }
      }
    }
    label614:
    label637:
    AppMethodBeat.o(75312);
  }
  
  private static int aVO(String paramString)
  {
    AppMethodBeat.i(75310);
    p.k(paramString, "path");
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
  
  private static Bitmap aj(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75313);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap.getWidth() % 2 == 1)
      {
        localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (localBitmap == null) {
          p.iCn();
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
  
  public final void a(String paramString, e parame)
  {
    AppMethodBeat.i(75306);
    p.k(paramString, "path");
    p.k(parame, "renderScriptBlur");
    Log.i(TAG, "addImage");
    parame = new c();
    p.k(paramString, "<set-?>");
    parame.path = paramString;
    this.HHX.add(parame);
    AppMethodBeat.o(75306);
  }
  
  public final void fvp()
  {
    try
    {
      AppMethodBeat.i(75307);
      Log.i(TAG, "clearImages");
      this.HHX.clear();
      AppMethodBeat.o(75307);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void fvq()
  {
    try
    {
      AppMethodBeat.i(75308);
      Object localObject1 = this.HHX;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          c localc = (c)((Iterator)localObject1).next();
          localc.HIr = 0;
          localc.HIs = 0;
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
  
  public final void fvr()
  {
    AppMethodBeat.i(75309);
    try
    {
      e locale = this.HHZ;
      if (locale != null) {
        locale.destroy();
      }
      this.HHZ = null;
      AppMethodBeat.o(75309);
      return;
    }
    catch (Exception localException)
    {
      this.HHZ = null;
      AppMethodBeat.o(75309);
    }
  }
  
  public final void o(long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        AppMethodBeat.i(75311);
        b localb = new b();
        if (this.HHX.size() == 0)
        {
          localb = null;
          if ((localb == null) || (localb.index < 0)) {
            AppMethodBeat.o(75311);
          }
        }
        else
        {
          if (this.HHX.size() == 1)
          {
            localb.index = 0;
            localb.HIj = 0.0F;
            localb.HIk = 1.0F;
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
            localObject2[0] = ((float)paramLong / (float)HIh / 2.0F + 1.0F);
            localObject2[5] = localObject2[0];
            android.opengl.Matrix.multiplyMM(localb.HIl, 0, HIb, 0, HIc, 0);
            android.opengl.Matrix.multiplyMM(localb.HIm, 0, (float[])localObject2, 0, HIc, 0);
            if (!this.HIa) {
              break label914;
            }
            android.opengl.Matrix.scaleM(localb.HIl, 0, 1.0F, -1.0F, 1.0F);
            android.opengl.Matrix.scaleM(localb.HIm, 0, 1.0F, -1.0F, 1.0F);
            break label914;
          }
          android.opengl.Matrix.multiplyMM(localb.HIl, 0, HIb, 0, HIc, 0);
          android.opengl.Matrix.multiplyMM(localb.HIm, 0, HIb, 0, HIc, 0);
          if (paramLong >= HIf + HIg * (this.HHX.size() - 1)) {
            break label920;
          }
          i = 1;
          if (paramLong <= HIf) {
            break label926;
          }
          l = ((paramLong - HIf) / HIg + 1L) % this.HHX.size();
          localb.index = ((int)l);
          if ((l != 0L) || (i == 0))
          {
            l = paramLong;
            if (paramLong > HIf) {
              l = (paramLong - HIf) % HIg;
            }
            if (l >= HIe) {
              break label932;
            }
            i = 1;
            if (i != 0)
            {
              localb.HIk = ((float)l / (float)HIe);
              localb.HIj = (1.0F - localb.HIk);
              if (!this.HIa) {
                break label917;
              }
              android.opengl.Matrix.scaleM(localb.HIl, 0, 1.0F, -1.0F, 1.0F);
              android.opengl.Matrix.scaleM(localb.HIm, 0, 1.0F, -1.0F, 1.0F);
              break label917;
            }
          }
          localb.HIj = 0.0F;
          localb.HIk = 1.0F;
          continue;
        }
        this.HHY.fvk();
      }
      finally {}
      if (localObject1.HIj > 0.0F) {
        if (localObject1.index - 1 >= 0)
        {
          localObject2 = this.HHX.get(localObject1.index - 1);
          p.j(localObject2, "playItems[playAction.index - 1]");
          localObject2 = (c)localObject2;
          label551:
          a((c)localObject2);
          this.HHY.a(paramInt1, paramInt2, ((c)localObject2).HIp, ((c)localObject2).HIq, localObject1.HIl[0]);
          this.HHY.bQ(localObject1.HIj);
          GLES20.glActiveTexture(33984);
          ((c)localObject2).HIr = b.i(((c)localObject2).lAx, ((c)localObject2).HIr);
          this.HHY.iY(((c)localObject2).HIr, 0);
          GLES20.glActiveTexture(33985);
          ((c)localObject2).HIs = b.i(((c)localObject2).HIo, ((c)localObject2).HIs);
          this.HHY.iZ(((c)localObject2).HIs, 1);
          this.HHY.n(localObject1.HIl);
          b.fvm();
        }
      }
      for (int i = 2;; i = 0)
      {
        if (localObject1.HIk > 0.0F)
        {
          localObject2 = this.HHX.get(localObject1.index);
          p.j(localObject2, "playItems[playAction.index]");
          localObject2 = (c)localObject2;
          a((c)localObject2);
          this.HHY.a(paramInt1, paramInt2, ((c)localObject2).HIp, ((c)localObject2).HIq, localObject1.HIm[0]);
          this.HHY.bQ(localObject1.HIk);
          GLES20.glActiveTexture(33984 + i);
          ((c)localObject2).HIr = b.i(((c)localObject2).lAx, ((c)localObject2).HIr);
          b localb1 = this.HHY;
          paramInt1 = ((c)localObject2).HIr;
          paramInt2 = i + 1;
          localb1.iY(paramInt1, i);
          GLES20.glActiveTexture(33984 + paramInt2);
          ((c)localObject2).HIs = b.i(((c)localObject2).HIo, ((c)localObject2).HIs);
          this.HHY.iZ(((c)localObject2).HIs, paramInt2);
          this.HHY.n(localObject1.HIm);
          b.fvm();
        }
        AppMethodBeat.o(75311);
        break;
        localObject2 = (c)j.lq((List)this.HHX);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bgAlpha", "", "getBgAlpha", "()F", "setBgAlpha", "(F)V", "bgMvpMatrix", "", "getBgMvpMatrix", "()[F", "setBgMvpMatrix", "([F)V", "fgAlpha", "getFgAlpha", "setFgAlpha", "fgMvpMatrix", "getFgMvpMatrix", "setFgMvpMatrix", "index", "", "getIndex", "()I", "setIndex", "(I)V", "plugin-recordvideo_release"})
  public final class b
  {
    float HIj;
    float HIk;
    float[] HIl;
    float[] HIm;
    int index;
    
    public b()
    {
      AppMethodBeat.i(75305);
      this.index = -1;
      this.HIj = 1.0F;
      this.HIl = new float[16];
      this.HIm = new float[16];
      AppMethodBeat.o(75305);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bm", "Landroid/graphics/Bitmap;", "getBm", "()Landroid/graphics/Bitmap;", "setBm", "(Landroid/graphics/Bitmap;)V", "bmBg", "getBmBg", "setBmBg", "bmHeight", "", "getBmHeight", "()I", "setBmHeight", "(I)V", "bmWidth", "getBmWidth", "setBmWidth", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "texBgId", "getTexBgId", "setTexBgId", "texId", "getTexId", "setTexId", "plugin-recordvideo_release"})
  public final class c
  {
    Bitmap HIo;
    int HIp;
    int HIq;
    int HIr;
    int HIs;
    Bitmap lAx;
    String path = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.g
 * JD-Core Version:    0.7.0.1
 */