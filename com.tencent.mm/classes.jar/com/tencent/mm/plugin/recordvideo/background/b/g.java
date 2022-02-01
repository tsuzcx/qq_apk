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
import com.tencent.mm.plugin.recordvideo.c.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.blur.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;", "", "()V", "encoderX264Encoder", "", "getEncoderX264Encoder", "()Z", "setEncoderX264Encoder", "(Z)V", "mFadeImageShader", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/FadeImageShader;", "playItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "getRenderScriptBlur", "()Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "setRenderScriptBlur", "(Lcom/tencent/mm/ui/blur/RenderScriptBlur;)V", "addBitmap", "", "bm", "Landroid/graphics/Bitmap;", "bmBg", "addImage", "path", "", "mWidth", "", "mHeight", "clearImages", "createPlayAction", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "ts", "", "destroyRS", "initInGLThread", "loadImage", "playItem", "readPictureDegree", "resetTexId", "resizeBitmap", "bitmap", "start", "curTs", "viewPortWidth", "viewPortHeight", "Companion", "PlayAction", "PlayItem", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static final long NFA;
  public static final g.a NFp;
  private static final float[] NFu;
  private static final float[] NFv;
  private static final long NFw;
  private static final long NFx;
  private static final long NFy;
  private static final long NFz;
  private static final String TAG;
  private final ArrayList<c> NFq;
  final b NFr;
  e NFs;
  boolean NFt;
  
  static
  {
    AppMethodBeat.i(75315);
    NFp = new g.a((byte)0);
    TAG = "MicroMsg.Story.StoryImagePlayer";
    NFu = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    NFv = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    NFw = 1380L;
    NFx = 300L;
    NFy = 1380L + NFx / 2L;
    NFz = NFx + NFw;
    NFA = 15000L;
    AppMethodBeat.o(75315);
  }
  
  public g()
  {
    AppMethodBeat.i(75314);
    this.NFq = new ArrayList();
    this.NFr = new b();
    AppMethodBeat.o(75314);
  }
  
  private final void a(c paramc)
  {
    AppMethodBeat.i(75312);
    Bitmap localBitmap2;
    if ((paramc.orY == null) || (paramc.NFG == null))
    {
      Object localObject2 = new c("addImage");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramc.path, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      localOptions.inSampleSize = BitmapUtil.calculateInSampleSize(i, j, f.NGM.gHs(), f.NGM.gHs());
      localOptions.inJustDecodeBounds = false;
      if ((Build.VERSION.SDK_INT > 26) && ((s.p(localOptions.outColorSpace, ColorSpace.get(ColorSpace.Named.DCI_P3))) || (s.p(localOptions.outColorSpace, ColorSpace.get(ColorSpace.Named.DISPLAY_P3))))) {
        localOptions.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
      }
      localBitmap2 = aw(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      Log.i(TAG, s.X("resizeBitmap first ", localObject2));
      long l = System.currentTimeMillis();
      localOptions.inSampleSize = BitmapUtil.calculateInSampleSize(i, j, f.NGM.gHs() / 2, f.NGM.gHs() / 2);
      Bitmap localBitmap1 = aw(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      try
      {
        if (this.NFs == null) {
          this.NFs = new e(MMApplicationContext.getContext());
        }
        e locale = this.NFs;
        s.checkNotNull(locale);
        localBitmap1 = locale.c(localBitmap1, 4.0F);
        s.s(localBitmap1, "renderScriptBlur!!.blur(tmpBg, 4f)");
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
          localObject1 = f.NGM.gHt();
          localObject1 = BitmapUtil.createColorBitmap(Color.parseColor("#ff000000"), ((Point)localObject1).x, ((Point)localObject1).y);
          s.s(localObject1, "createColorBitmap(Color.…0000\"), point.x, point.y)");
        }
        paramc.orY = localBitmap2;
        paramc.NFG = ((Bitmap)localObject1);
        Object localObject1 = paramc.orY;
        s.checkNotNull(localObject1);
        paramc.NFH = ((Bitmap)localObject1).getWidth();
        localObject1 = paramc.orY;
        s.checkNotNull(localObject1);
        paramc.NFI = ((Bitmap)localObject1).getHeight();
      }
      Log.i(TAG, s.X("fastblur cost:%s, sampleSize:%s, width:%s, height:%s resizeBitmap second ", localObject2), new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localOptions.inSampleSize), Integer.valueOf(localBitmap1.getWidth()), Integer.valueOf(localBitmap1.getHeight()) });
      if (localBitmap2 != null)
      {
        i = aSW(paramc.path);
        if (i != 0)
        {
          localObject2 = new android.graphics.Matrix();
          ((android.graphics.Matrix)localObject2).postRotate(i);
          localBitmap2 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), localBitmap2.getHeight(), (android.graphics.Matrix)localObject2, true);
          localBitmap1 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), (android.graphics.Matrix)localObject2, true);
          paramc.orY = localBitmap2;
          localBitmap2 = paramc.orY;
          s.checkNotNull(localBitmap2);
          paramc.NFH = localBitmap2.getWidth();
          localBitmap2 = paramc.orY;
          s.checkNotNull(localBitmap2);
          paramc.NFI = localBitmap2.getHeight();
          paramc.NFG = localBitmap1;
          AppMethodBeat.o(75312);
          return;
        }
      }
    }
    AppMethodBeat.o(75312);
  }
  
  private static int aSW(String paramString)
  {
    AppMethodBeat.i(75310);
    s.u(paramString, "path");
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
  
  private static Bitmap aw(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75313);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap.getWidth() % 2 == 1)
      {
        localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        s.checkNotNull(localBitmap);
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
    s.u(paramString, "path");
    s.u(parame, "renderScriptBlur");
    Log.i(TAG, "addImage");
    parame = new c();
    s.u(paramString, "<set-?>");
    parame.path = paramString;
    this.NFq.add(parame);
    AppMethodBeat.o(75306);
  }
  
  public final void gHf()
  {
    try
    {
      AppMethodBeat.i(75307);
      Log.i(TAG, "clearImages");
      this.NFq.clear();
      AppMethodBeat.o(75307);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void gHg()
  {
    try
    {
      AppMethodBeat.i(75308);
      Object localObject1 = this.NFq;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          c localc = (c)((Iterator)localObject1).next();
          localc.NFJ = 0;
          localc.NFK = 0;
        }
      }
      AppMethodBeat.o(75308);
    }
    finally {}
  }
  
  public final void gHh()
  {
    AppMethodBeat.i(75309);
    try
    {
      e locale = this.NFs;
      if (locale != null) {
        locale.destroy();
      }
      this.NFs = null;
      AppMethodBeat.o(75309);
      return;
    }
    catch (Exception localException)
    {
      this.NFs = null;
      AppMethodBeat.o(75309);
    }
  }
  
  public final void w(long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        AppMethodBeat.i(75311);
        b localb = new b();
        if (this.NFq.size() == 0)
        {
          localb = null;
          if ((localb == null) || (localb.index < 0)) {
            AppMethodBeat.o(75311);
          }
        }
        else
        {
          if (this.NFq.size() == 1)
          {
            localb.index = 0;
            localb.NFB = 0.0F;
            localb.NFC = 1.0F;
            localObject2 = new float[16];
            localObject2[0] = 1.0F;
            localObject2[1] = 0.0F;
            localObject2[2] = 0.0F;
            localObject2[3] = 0.0F;
            localObject2[4] = 0.0F;
            localObject2[5] = 1.0F;
            localObject2[6] = 0.0F;
            localObject2[7] = 0.0F;
            localObject2[8] = 0.0F;
            localObject2[9] = 0.0F;
            localObject2[10] = 1.0F;
            localObject2[11] = 0.0F;
            localObject2[12] = 0.0F;
            localObject2[13] = 0.0F;
            localObject2[14] = 0.0F;
            localObject2[15] = 1.0F;
            localObject2[0] = ((float)paramLong / (float)NFA / 2.0F + 1.0F);
            localObject2[5] = localObject2[0];
            android.opengl.Matrix.multiplyMM(localb.NFD, 0, NFu, 0, NFv, 0);
            android.opengl.Matrix.multiplyMM(localb.NFE, 0, (float[])localObject2, 0, NFv, 0);
            if (!this.NFt) {
              break label933;
            }
            android.opengl.Matrix.scaleM(localb.NFD, 0, 1.0F, -1.0F, 1.0F);
            android.opengl.Matrix.scaleM(localb.NFE, 0, 1.0F, -1.0F, 1.0F);
            break label933;
          }
          android.opengl.Matrix.multiplyMM(localb.NFD, 0, NFu, 0, NFv, 0);
          android.opengl.Matrix.multiplyMM(localb.NFE, 0, NFu, 0, NFv, 0);
          if (paramLong >= NFy + NFz * (this.NFq.size() - 1)) {
            break label939;
          }
          i = 1;
          if (paramLong <= NFy) {
            break label945;
          }
          l = ((paramLong - NFy) / NFz + 1L) % this.NFq.size();
          localb.index = ((int)l);
          if ((l != 0L) || (i == 0))
          {
            l = paramLong;
            if (paramLong > NFy) {
              l = (paramLong - NFy) % NFz;
            }
            if (l >= NFx) {
              break label951;
            }
            i = 1;
            if (i != 0)
            {
              localb.NFC = ((float)l / (float)NFx);
              localb.NFB = (1.0F - localb.NFC);
              if (!this.NFt) {
                break label936;
              }
              android.opengl.Matrix.scaleM(localb.NFD, 0, 1.0F, -1.0F, 1.0F);
              android.opengl.Matrix.scaleM(localb.NFE, 0, 1.0F, -1.0F, 1.0F);
              break label936;
            }
          }
          localb.NFB = 0.0F;
          localb.NFC = 1.0F;
          continue;
        }
        this.NFr.gHb();
      }
      finally {}
      if (localObject1.NFB > 0.0F) {
        if (localObject1.index - 1 >= 0)
        {
          localObject2 = this.NFq.get(localObject1.index - 1);
          s.s(localObject2, "playItems[playAction.index - 1]");
          localObject2 = (c)localObject2;
          label564:
          a((c)localObject2);
          this.NFr.b(paramInt1, paramInt2, ((c)localObject2).NFH, ((c)localObject2).NFI, localObject1.NFD[0]);
          this.NFr.cU(localObject1.NFB);
          GLES20.glActiveTexture(33984);
          ((c)localObject2).NFJ = b.h(((c)localObject2).orY, ((c)localObject2).NFJ);
          this.NFr.kE(((c)localObject2).NFJ, 0);
          GLES20.glActiveTexture(33985);
          ((c)localObject2).NFK = b.h(((c)localObject2).NFG, ((c)localObject2).NFK);
          this.NFr.kF(((c)localObject2).NFK, 1);
          this.NFr.v(localObject1.NFD);
          GLES20.glDrawArrays(5, 0, 4);
        }
      }
      for (int i = 2;; i = 0)
      {
        if (localObject1.NFC > 0.0F)
        {
          localObject2 = this.NFq.get(localObject1.index);
          s.s(localObject2, "playItems[playAction.index]");
          localObject2 = (c)localObject2;
          a((c)localObject2);
          this.NFr.b(paramInt1, paramInt2, ((c)localObject2).NFH, ((c)localObject2).NFI, localObject1.NFE[0]);
          this.NFr.cU(localObject1.NFC);
          GLES20.glActiveTexture(33984 + i);
          ((c)localObject2).NFJ = b.h(((c)localObject2).orY, ((c)localObject2).NFJ);
          b localb1 = this.NFr;
          paramInt1 = ((c)localObject2).NFJ;
          paramInt2 = i + 1;
          localb1.kE(paramInt1, i);
          GLES20.glActiveTexture(33984 + paramInt2);
          ((c)localObject2).NFK = b.h(((c)localObject2).NFG, ((c)localObject2).NFK);
          this.NFr.kF(((c)localObject2).NFK, paramInt2);
          this.NFr.v(localObject1.NFE);
          GLES20.glDrawArrays(5, 0, 4);
        }
        AppMethodBeat.o(75311);
        break;
        localObject2 = (c)p.oM((List)this.NFq);
        break label564;
      }
      label933:
      continue;
      label936:
      continue;
      label939:
      i = 0;
      continue;
      label945:
      long l = 0L;
      continue;
      label951:
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bgAlpha", "", "getBgAlpha", "()F", "setBgAlpha", "(F)V", "bgMvpMatrix", "", "getBgMvpMatrix", "()[F", "setBgMvpMatrix", "([F)V", "fgAlpha", "getFgAlpha", "setFgAlpha", "fgMvpMatrix", "getFgMvpMatrix", "setFgMvpMatrix", "index", "", "getIndex", "()I", "setIndex", "(I)V", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    float NFB;
    float NFC;
    float[] NFD;
    float[] NFE;
    int index;
    
    public b()
    {
      AppMethodBeat.i(75305);
      this.index = -1;
      this.NFB = 1.0F;
      this.NFD = new float[16];
      this.NFE = new float[16];
      AppMethodBeat.o(75305);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bm", "Landroid/graphics/Bitmap;", "getBm", "()Landroid/graphics/Bitmap;", "setBm", "(Landroid/graphics/Bitmap;)V", "bmBg", "getBmBg", "setBmBg", "bmHeight", "", "getBmHeight", "()I", "setBmHeight", "(I)V", "bmWidth", "getBmWidth", "setBmWidth", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "texBgId", "getTexBgId", "setTexBgId", "texId", "getTexId", "setTexId", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
  {
    Bitmap NFG;
    int NFH;
    int NFI;
    int NFJ;
    int NFK;
    Bitmap orY;
    String path;
    
    public c()
    {
      AppMethodBeat.i(279497);
      this.path = "";
      AppMethodBeat.o(279497);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.g
 * JD-Core Version:    0.7.0.1
 */