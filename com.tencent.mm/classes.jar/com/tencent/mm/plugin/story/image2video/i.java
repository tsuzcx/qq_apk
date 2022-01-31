package com.tencent.mm.plugin.story.image2video;

import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.media.ExifInterface;
import android.opengl.GLES20;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/image2video/StoryImagePlayer;", "", "()V", "mFadeImageShader", "Lcom/tencent/mm/plugin/story/image2video/FadeImageShader;", "playItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/image2video/StoryImagePlayer$PlayItem;", "renderScriptBlur", "Lcom/tencent/mm/plugin/story/image2video/RenderScriptBlur;", "getRenderScriptBlur", "()Lcom/tencent/mm/plugin/story/image2video/RenderScriptBlur;", "setRenderScriptBlur", "(Lcom/tencent/mm/plugin/story/image2video/RenderScriptBlur;)V", "addBitmap", "", "bm", "Landroid/graphics/Bitmap;", "bmBg", "addImage", "path", "", "mWidth", "", "mHeight", "clearImages", "createPlayAction", "Lcom/tencent/mm/plugin/story/image2video/StoryImagePlayer$PlayAction;", "ts", "", "destroyRS", "initInGLThread", "loadImage", "playItem", "readPictureDegree", "resetTexId", "resizeBitmap", "bitmap", "start", "curTs", "viewPortWidth", "viewPortHeight", "Companion", "PlayAction", "PlayItem", "plugin-story_release"})
public final class i
{
  private static final String TAG = "MicroMsg.Story.StoryImagePlayer";
  private static final float[] stK;
  private static final float[] stL;
  private static final long stM = 1380L;
  private static final long stN = 300L;
  private static final long stO = 1530L;
  private static final long stP = 1680L;
  private static final long stQ = 15000L;
  public static final i.a stR;
  private final ArrayList<i.c> stH;
  final b stI;
  g stJ;
  
  static
  {
    AppMethodBeat.i(151050);
    stR = new i.a((byte)0);
    TAG = "MicroMsg.Story.StoryImagePlayer";
    stK = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    stL = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    stM = 1380L;
    stN = 300L;
    stO = stN / 2L + 1380L;
    stP = stN + stM;
    stQ = 15000L;
    AppMethodBeat.o(151050);
  }
  
  public i()
  {
    AppMethodBeat.i(151049);
    this.stH = new ArrayList();
    this.stI = new b();
    AppMethodBeat.o(151049);
  }
  
  private final void a(i.c paramc)
  {
    AppMethodBeat.i(151047);
    Bitmap localBitmap2;
    if ((paramc.frG == null) || (paramc.stX == null))
    {
      Object localObject2 = new a("addImage");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramc.path, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      localOptions.inSampleSize = com.tencent.mm.sdk.platformtools.d.I(i, j, d.getMaxSize(), d.getMaxSize());
      localOptions.inJustDecodeBounds = false;
      localBitmap2 = aa(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      ab.i(TAG, "resizeBitmap first ".concat(String.valueOf(localObject2)));
      long l = System.currentTimeMillis();
      localOptions.inSampleSize = com.tencent.mm.sdk.platformtools.d.I(i, j, d.getMaxSize() / 2, d.getMaxSize() / 2);
      Bitmap localBitmap1 = aa(MMBitmapFactory.decodeFile(paramc.path, localOptions));
      try
      {
        if (this.stJ == null) {
          this.stJ = new g(ah.getContext());
        }
        g localg = this.stJ;
        if (localg == null) {
          a.f.b.j.ebi();
        }
        localBitmap1 = localg.Z(localBitmap1);
        a.f.b.j.p(localBitmap1, "renderScriptBlur!!.blur(tmpBg, 4f)");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace(TAG, (Throwable)localException, "rsblur exception", new Object[0]);
          ab.i(TAG, "rsblur exception, path:%s", new Object[] { paramc.path });
          if (ab.getLogLevel() > 0) {
            Toast.makeText(ah.getContext(), (CharSequence)"RenderScript Exception", 0).show();
          }
          localObject1 = d.czT();
          localObject1 = com.tencent.mm.sdk.platformtools.d.au(Color.parseColor("#ff000000"), ((Point)localObject1).x, ((Point)localObject1).y);
          a.f.b.j.p(localObject1, "BitmapUtil.createColorBi…0000\"), point.x, point.y)");
        }
        paramc.frG = localBitmap2;
        paramc.stX = ((Bitmap)localObject1);
        Object localObject1 = paramc.frG;
        if (localObject1 != null) {
          break label541;
        }
        a.f.b.j.ebi();
        paramc.stY = ((Bitmap)localObject1).getWidth();
        localObject1 = paramc.frG;
        if (localObject1 != null) {
          break label564;
        }
        a.f.b.j.ebi();
        paramc.stZ = ((Bitmap)localObject1).getHeight();
      }
      ab.i(TAG, "fastblur cost:%s, sampleSize:%s, width:%s, height:%s resizeBitmap second ".concat(String.valueOf(localObject2)), new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localOptions.inSampleSize), Integer.valueOf(localBitmap1.getWidth()), Integer.valueOf(localBitmap1.getHeight()) });
      if (localBitmap2 != null)
      {
        i = acP(paramc.path);
        if (i != 0)
        {
          localObject2 = new android.graphics.Matrix();
          ((android.graphics.Matrix)localObject2).postRotate(i);
          localBitmap2 = Bitmap.createBitmap(localBitmap2, 0, 0, localBitmap2.getWidth(), localBitmap2.getHeight(), (android.graphics.Matrix)localObject2, true);
          localBitmap1 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), (android.graphics.Matrix)localObject2, true);
          paramc.frG = localBitmap2;
          localBitmap2 = paramc.frG;
          if (localBitmap2 == null) {
            a.f.b.j.ebi();
          }
          paramc.stY = localBitmap2.getWidth();
          localBitmap2 = paramc.frG;
          if (localBitmap2 == null) {
            a.f.b.j.ebi();
          }
          paramc.stZ = localBitmap2.getHeight();
          paramc.stX = localBitmap1;
          AppMethodBeat.o(151047);
          return;
        }
      }
    }
    label541:
    label564:
    AppMethodBeat.o(151047);
  }
  
  private static Bitmap aa(Bitmap paramBitmap)
  {
    AppMethodBeat.i(151048);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap.getWidth() % 2 == 1)
      {
        localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (localBitmap == null) {
          a.f.b.j.ebi();
        }
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawARGB(0, 0, 0, 0);
        localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      }
      AppMethodBeat.o(151048);
      return localBitmap;
    }
    AppMethodBeat.o(151048);
    return null;
  }
  
  private static int acP(String paramString)
  {
    AppMethodBeat.i(151045);
    a.f.b.j.q(paramString, "path");
    try
    {
      i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        int i;
        ab.printErrStackTrace(TAG, (Throwable)paramString, "readPictureDegree", new Object[0]);
      }
    }
    i = 0;
    for (;;)
    {
      AppMethodBeat.o(151045);
      return i;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  public final void a(String paramString, g paramg)
  {
    AppMethodBeat.i(151042);
    a.f.b.j.q(paramString, "path");
    a.f.b.j.q(paramg, "renderScriptBlur");
    ab.i(TAG, "addImage");
    paramg = new i.c(this);
    a.f.b.j.q(paramString, "<set-?>");
    paramg.path = paramString;
    this.stH.add(paramg);
    AppMethodBeat.o(151042);
  }
  
  public final void czV()
  {
    try
    {
      AppMethodBeat.i(151043);
      ab.i(TAG, "clearImages");
      this.stH.clear();
      AppMethodBeat.o(151043);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void czW()
  {
    AppMethodBeat.i(151044);
    Object localObject = this.stH;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        i.c localc = (i.c)((Iterator)localObject).next();
        localc.sua = 0;
        localc.sub = 0;
      }
      AppMethodBeat.o(151044);
      return;
    }
    AppMethodBeat.o(151044);
  }
  
  public final void czX()
  {
    AppMethodBeat.i(155293);
    g localg = this.stJ;
    if (localg != null) {
      localg.destroy();
    }
    this.stJ = null;
    AppMethodBeat.o(155293);
  }
  
  public final void n(long paramLong, int paramInt1, int paramInt2)
  {
    label414:
    label420:
    label426:
    label441:
    label849:
    label867:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(151046);
        i.b localb = new i.b(this);
        if (this.stH.size() == 0)
        {
          localb = null;
          if ((localb != null) && (localb.index >= 0)) {
            break label441;
          }
          AppMethodBeat.o(151046);
          return;
        }
        if (this.stH.size() == 1)
        {
          localb.index = 0;
          localb.stS = 0.0F;
          localb.stT = 1.0F;
          localObject2 = new float[16];
          tmp90_88 = localObject2;
          tmp90_88[0] = 1.0F;
          tmp94_90 = tmp90_88;
          tmp94_90[1] = 0.0F;
          tmp98_94 = tmp94_90;
          tmp98_94[2] = 0.0F;
          tmp102_98 = tmp98_94;
          tmp102_98[3] = 0.0F;
          tmp106_102 = tmp102_98;
          tmp106_102[4] = 0.0F;
          tmp110_106 = tmp106_102;
          tmp110_106[5] = 1.0F;
          tmp114_110 = tmp110_106;
          tmp114_110[6] = 0.0F;
          tmp119_114 = tmp114_110;
          tmp119_114[7] = 0.0F;
          tmp124_119 = tmp119_114;
          tmp124_119[8] = 0.0F;
          tmp129_124 = tmp124_119;
          tmp129_124[9] = 0.0F;
          tmp134_129 = tmp129_124;
          tmp134_129[10] = 1.0F;
          tmp139_134 = tmp134_129;
          tmp139_134[11] = 0.0F;
          tmp144_139 = tmp139_134;
          tmp144_139[12] = 0.0F;
          tmp149_144 = tmp144_139;
          tmp149_144[13] = 0.0F;
          tmp154_149 = tmp149_144;
          tmp154_149[14] = 0.0F;
          tmp159_154 = tmp154_149;
          tmp159_154[15] = 1.0F;
          tmp159_154;
          localObject2[0] = (1.0F + (float)paramLong / (float)stQ / 2.0F);
          localObject2[5] = localObject2[0];
          android.opengl.Matrix.multiplyMM(localb.stU, 0, stK, 0, stL, 0);
          android.opengl.Matrix.multiplyMM(localb.stV, 0, (float[])localObject2, 0, stL, 0);
        }
        else
        {
          android.opengl.Matrix.multiplyMM(localb.stU, 0, stK, 0, stL, 0);
          android.opengl.Matrix.multiplyMM(localb.stV, 0, stK, 0, stL, 0);
          if (paramLong < stO + stP * (this.stH.size() - 1))
          {
            i = 1;
            if (paramLong <= stO) {
              break label414;
            }
            l = ((paramLong - stO) / stP + 1L) % this.stH.size();
            localb.index = ((int)l);
            if ((l == 0L) && (i != 0)) {
              break label426;
            }
            l = paramLong;
            if (paramLong > stO) {
              l = (paramLong - stO) % stP;
            }
            if (l >= stN) {
              break label420;
            }
            i = 1;
            if (i == 0) {
              break label426;
            }
            localb.stT = ((float)l / (float)stN);
            localb.stS = (1.0F - localb.stT);
          }
        }
      }
      finally {}
      int i = 0;
      continue;
      long l = 0L;
      continue;
      i = 0;
      continue;
      localObject1.stS = 0.0F;
      localObject1.stT = 1.0F;
      break label867;
      i = 0;
      this.stI.czQ();
      if (localObject1.stS > 0.0F)
      {
        if (localObject1.index - 1 < 0) {
          break label849;
        }
        localObject2 = this.stH.get(localObject1.index - 1);
        a.f.b.j.p(localObject2, "playItems[playAction.index - 1]");
      }
      for (Object localObject2 = (i.c)localObject2;; localObject2 = (i.c)a.a.j.fS((List)this.stH))
      {
        a((i.c)localObject2);
        this.stI.b(paramInt1, paramInt2, ((i.c)localObject2).stY, ((i.c)localObject2).stZ, localObject1.stU[0]);
        this.stI.bg(localObject1.stS);
        GLES20.glActiveTexture(33984);
        ((i.c)localObject2).sua = b.b(((i.c)localObject2).frG, ((i.c)localObject2).sua);
        this.stI.fV(((i.c)localObject2).sua, 0);
        GLES20.glActiveTexture(33985);
        ((i.c)localObject2).sub = b.b(((i.c)localObject2).stX, ((i.c)localObject2).sub);
        b localb1 = this.stI;
        int j = ((i.c)localObject2).sub;
        i = 2;
        localb1.fW(j, 1);
        this.stI.j(localObject1.stU);
        b.czS();
        if (localObject1.stT > 0.0F)
        {
          localObject2 = this.stH.get(localObject1.index);
          a.f.b.j.p(localObject2, "playItems[playAction.index]");
          localObject2 = (i.c)localObject2;
          a((i.c)localObject2);
          this.stI.b(paramInt1, paramInt2, ((i.c)localObject2).stY, ((i.c)localObject2).stZ, localObject1.stV[0]);
          this.stI.bg(localObject1.stT);
          GLES20.glActiveTexture(33984 + i);
          ((i.c)localObject2).sua = b.b(((i.c)localObject2).frG, ((i.c)localObject2).sua);
          localb1 = this.stI;
          paramInt1 = ((i.c)localObject2).sua;
          paramInt2 = i + 1;
          localb1.fV(paramInt1, i);
          GLES20.glActiveTexture(33984 + paramInt2);
          ((i.c)localObject2).sub = b.b(((i.c)localObject2).stX, ((i.c)localObject2).sub);
          this.stI.fW(((i.c)localObject2).sub, paramInt2);
          this.stI.j(localObject1.stV);
          b.czS();
        }
        AppMethodBeat.o(151046);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.i
 * JD-Core Version:    0.7.0.1
 */