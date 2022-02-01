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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.f;
import d.a.j;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;", "", "()V", "encoderX264Encoder", "", "getEncoderX264Encoder", "()Z", "setEncoderX264Encoder", "(Z)V", "mFadeImageShader", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/FadeImageShader;", "playItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "getRenderScriptBlur", "()Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "setRenderScriptBlur", "(Lcom/tencent/mm/ui/blur/RenderScriptBlur;)V", "addBitmap", "", "bm", "Landroid/graphics/Bitmap;", "bmBg", "addImage", "path", "", "mWidth", "", "mHeight", "clearImages", "createPlayAction", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "ts", "", "destroyRS", "initInGLThread", "loadImage", "playItem", "readPictureDegree", "resetTexId", "resizeBitmap", "bitmap", "start", "curTs", "viewPortWidth", "viewPortHeight", "Companion", "PlayAction", "PlayItem", "plugin-recordvideo_release"})
public final class g
{
  private static final String TAG = "MicroMsg.Story.StoryImagePlayer";
  private static final float[] wnW;
  private static final float[] wnX;
  private static final long wnY = 1380L;
  private static final long wnZ = 300L;
  private static final long woa = 1530L;
  private static final long wob = 1680L;
  private static final long woc = 15000L;
  public static final g.a wod;
  com.tencent.mm.ui.blur.e rbR;
  private final ArrayList<c> wnT;
  final b wnU;
  boolean wnV;
  
  static
  {
    AppMethodBeat.i(75315);
    wod = new g.a((byte)0);
    TAG = "MicroMsg.Story.StoryImagePlayer";
    wnW = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    wnX = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    wnY = 1380L;
    wnZ = 300L;
    woa = wnZ / 2L + 1380L;
    wob = wnZ + wnY;
    woc = 15000L;
    AppMethodBeat.o(75315);
  }
  
  public g()
  {
    AppMethodBeat.i(75314);
    this.wnT = new ArrayList();
    this.wnU = new b();
    AppMethodBeat.o(75314);
  }
  
  private final void a(c paramc)
  {
    AppMethodBeat.i(75312);
    Bitmap localBitmap2;
    if ((paramc.hua == null) || (paramc.woj == null))
    {
      Object localObject2 = new com.tencent.mm.ac.b("addImage");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramc.path, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      localOptions.inSampleSize = f.O(i, j, com.tencent.mm.plugin.recordvideo.b.e.wps.getMaxSize(), com.tencent.mm.plugin.recordvideo.b.e.wps.getMaxSize());
      localOptions.inJustDecodeBounds = false;
      localBitmap2 = aa(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      ac.i(TAG, "resizeBitmap first ".concat(String.valueOf(localObject2)));
      long l = System.currentTimeMillis();
      localOptions.inSampleSize = f.O(i, j, com.tencent.mm.plugin.recordvideo.b.e.wps.getMaxSize() / 2, com.tencent.mm.plugin.recordvideo.b.e.wps.getMaxSize() / 2);
      Bitmap localBitmap1 = aa(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      try
      {
        if (this.rbR == null) {
          this.rbR = new com.tencent.mm.ui.blur.e(ai.getContext());
        }
        com.tencent.mm.ui.blur.e locale = this.rbR;
        if (locale == null) {
          k.fOy();
        }
        localBitmap1 = locale.d(localBitmap1, 4.0F);
        k.g(localBitmap1, "renderScriptBlur!!.blur(tmpBg, 4f)");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace(TAG, (Throwable)localException, "rsblur exception", new Object[0]);
          ac.i(TAG, "rsblur exception, path:%s", new Object[] { paramc.path });
          if (ac.getLogLevel() > 0) {
            Toast.makeText(ai.getContext(), (CharSequence)"RenderScript Exception", 0).show();
          }
          localObject1 = com.tencent.mm.plugin.recordvideo.b.e.wps.duW();
          localObject1 = f.aH(Color.parseColor("#ff000000"), ((Point)localObject1).x, ((Point)localObject1).y);
          k.g(localObject1, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
        }
        paramc.hua = localBitmap2;
        paramc.woj = ((Bitmap)localObject1);
        Object localObject1 = paramc.hua;
        if (localObject1 != null) {
          break label560;
        }
        k.fOy();
        paramc.wok = ((Bitmap)localObject1).getWidth();
        localObject1 = paramc.hua;
        if (localObject1 != null) {
          break label583;
        }
        k.fOy();
        paramc.wol = ((Bitmap)localObject1).getHeight();
      }
      ac.i(TAG, "fastblur cost:%s, sampleSize:%s, width:%s, height:%s resizeBitmap second ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localOptions.inSampleSize), Integer.valueOf(localBitmap1.getWidth()), Integer.valueOf(localBitmap1.getHeight()) });
      if (localBitmap2 != null)
      {
        i = aqF(paramc.path);
        if (i != 0)
        {
          localObject2 = new android.graphics.Matrix();
          ((android.graphics.Matrix)localObject2).postRotate(i);
          localBitmap2 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), localBitmap2.getHeight(), (android.graphics.Matrix)localObject2, true);
          localBitmap1 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), (android.graphics.Matrix)localObject2, true);
          paramc.hua = localBitmap2;
          localBitmap2 = paramc.hua;
          if (localBitmap2 == null) {
            k.fOy();
          }
          paramc.wok = localBitmap2.getWidth();
          localBitmap2 = paramc.hua;
          if (localBitmap2 == null) {
            k.fOy();
          }
          paramc.wol = localBitmap2.getHeight();
          paramc.woj = localBitmap1;
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
          k.fOy();
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
  
  private static int aqF(String paramString)
  {
    AppMethodBeat.i(75310);
    k.h(paramString, "path");
    try
    {
      i = BackwardSupportUtil.ExifHelper.ce(paramString);
      AppMethodBeat.o(75310);
      return i;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace(TAG, (Throwable)paramString, "readPictureDegree", new Object[0]);
        int i = 0;
      }
    }
  }
  
  public final void a(String paramString, com.tencent.mm.ui.blur.e parame)
  {
    AppMethodBeat.i(75306);
    k.h(paramString, "path");
    k.h(parame, "renderScriptBlur");
    ac.i(TAG, "addImage");
    parame = new c();
    k.h(paramString, "<set-?>");
    parame.path = paramString;
    this.wnT.add(parame);
    AppMethodBeat.o(75306);
  }
  
  public final void duM()
  {
    try
    {
      AppMethodBeat.i(75307);
      ac.i(TAG, "clearImages");
      this.wnT.clear();
      AppMethodBeat.o(75307);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void duN()
  {
    try
    {
      AppMethodBeat.i(75308);
      Object localObject1 = this.wnT;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          c localc = (c)((Iterator)localObject1).next();
          localc.wom = 0;
          localc.won = 0;
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
  
  public final void duO()
  {
    AppMethodBeat.i(75309);
    try
    {
      com.tencent.mm.ui.blur.e locale = this.rbR;
      if (locale != null) {
        locale.destroy();
      }
      this.rbR = null;
      AppMethodBeat.o(75309);
      return;
    }
    catch (Exception localException)
    {
      this.rbR = null;
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
        if (this.wnT.size() == 0)
        {
          localb = null;
          if ((localb == null) || (localb.index < 0)) {
            AppMethodBeat.o(75311);
          }
        }
        else
        {
          if (this.wnT.size() == 1)
          {
            localb.index = 0;
            localb.woe = 0.0F;
            localb.wof = 1.0F;
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
            localObject2[0] = ((float)paramLong / (float)woc / 2.0F + 1.0F);
            localObject2[5] = localObject2[0];
            android.opengl.Matrix.multiplyMM(localb.wog, 0, wnW, 0, wnX, 0);
            android.opengl.Matrix.multiplyMM(localb.woh, 0, (float[])localObject2, 0, wnX, 0);
            if (!this.wnV) {
              break label914;
            }
            android.opengl.Matrix.scaleM(localb.wog, 0, 1.0F, -1.0F, 1.0F);
            android.opengl.Matrix.scaleM(localb.woh, 0, 1.0F, -1.0F, 1.0F);
            break label914;
          }
          android.opengl.Matrix.multiplyMM(localb.wog, 0, wnW, 0, wnX, 0);
          android.opengl.Matrix.multiplyMM(localb.woh, 0, wnW, 0, wnX, 0);
          if (paramLong >= woa + wob * (this.wnT.size() - 1)) {
            break label920;
          }
          i = 1;
          if (paramLong <= woa) {
            break label926;
          }
          l = ((paramLong - woa) / wob + 1L) % this.wnT.size();
          localb.index = ((int)l);
          if ((l != 0L) || (i == 0))
          {
            l = paramLong;
            if (paramLong > woa) {
              l = (paramLong - woa) % wob;
            }
            if (l >= wnZ) {
              break label932;
            }
            i = 1;
            if (i != 0)
            {
              localb.wof = ((float)l / (float)wnZ);
              localb.woe = (1.0F - localb.wof);
              if (!this.wnV) {
                break label917;
              }
              android.opengl.Matrix.scaleM(localb.wog, 0, 1.0F, -1.0F, 1.0F);
              android.opengl.Matrix.scaleM(localb.woh, 0, 1.0F, -1.0F, 1.0F);
              break label917;
            }
          }
          localb.woe = 0.0F;
          localb.wof = 1.0F;
          continue;
        }
        this.wnU.duH();
      }
      finally {}
      if (localObject1.woe > 0.0F) {
        if (localObject1.index - 1 >= 0)
        {
          localObject2 = this.wnT.get(localObject1.index - 1);
          k.g(localObject2, "playItems[playAction.index - 1]");
          localObject2 = (c)localObject2;
          label551:
          a((c)localObject2);
          this.wnU.a(paramInt1, paramInt2, ((c)localObject2).wok, ((c)localObject2).wol, localObject1.wog[0]);
          this.wnU.bo(localObject1.woe);
          GLES20.glActiveTexture(33984);
          ((c)localObject2).wom = b.f(((c)localObject2).hua, ((c)localObject2).wom);
          this.wnU.gQ(((c)localObject2).wom, 0);
          GLES20.glActiveTexture(33985);
          ((c)localObject2).won = b.f(((c)localObject2).woj, ((c)localObject2).won);
          this.wnU.gR(((c)localObject2).won, 1);
          this.wnU.o(localObject1.wog);
          b.duJ();
        }
      }
      for (int i = 2;; i = 0)
      {
        if (localObject1.wof > 0.0F)
        {
          localObject2 = this.wnT.get(localObject1.index);
          k.g(localObject2, "playItems[playAction.index]");
          localObject2 = (c)localObject2;
          a((c)localObject2);
          this.wnU.a(paramInt1, paramInt2, ((c)localObject2).wok, ((c)localObject2).wol, localObject1.woh[0]);
          this.wnU.bo(localObject1.wof);
          GLES20.glActiveTexture(33984 + i);
          ((c)localObject2).wom = b.f(((c)localObject2).hua, ((c)localObject2).wom);
          b localb1 = this.wnU;
          paramInt1 = ((c)localObject2).wom;
          paramInt2 = i + 1;
          localb1.gQ(paramInt1, i);
          GLES20.glActiveTexture(33984 + paramInt2);
          ((c)localObject2).won = b.f(((c)localObject2).woj, ((c)localObject2).won);
          this.wnU.gR(((c)localObject2).won, paramInt2);
          this.wnU.o(localObject1.woh);
          b.duJ();
        }
        AppMethodBeat.o(75311);
        break;
        localObject2 = (c)j.iQ((List)this.wnT);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayAction;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bgAlpha", "", "getBgAlpha", "()F", "setBgAlpha", "(F)V", "bgMvpMatrix", "", "getBgMvpMatrix", "()[F", "setBgMvpMatrix", "([F)V", "fgAlpha", "getFgAlpha", "setFgAlpha", "fgMvpMatrix", "getFgMvpMatrix", "setFgMvpMatrix", "index", "", "getIndex", "()I", "setIndex", "(I)V", "plugin-recordvideo_release"})
  public final class b
  {
    int index;
    float woe;
    float wof;
    float[] wog;
    float[] woh;
    
    public b()
    {
      AppMethodBeat.i(75305);
      this.index = -1;
      this.woe = 1.0F;
      this.wog = new float[16];
      this.woh = new float[16];
      AppMethodBeat.o(75305);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer$PlayItem;", "", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImagePlayer;)V", "bm", "Landroid/graphics/Bitmap;", "getBm", "()Landroid/graphics/Bitmap;", "setBm", "(Landroid/graphics/Bitmap;)V", "bmBg", "getBmBg", "setBmBg", "bmHeight", "", "getBmHeight", "()I", "setBmHeight", "(I)V", "bmWidth", "getBmWidth", "setBmWidth", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "texBgId", "getTexBgId", "setTexBgId", "texId", "getTexId", "setTexId", "plugin-recordvideo_release"})
  public final class c
  {
    Bitmap hua;
    String path = "";
    Bitmap woj;
    int wok;
    int wol;
    int wom;
    int won;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.g
 * JD-Core Version:    0.7.0.1
 */