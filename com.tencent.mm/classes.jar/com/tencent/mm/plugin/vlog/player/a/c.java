package com.tencent.mm.plugin.vlog.player.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import d.a.j;
import d.a.v;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.vlog.model.u;>;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoCompositionEffect;", "Lcom/tencent/mm/plugin/vlog/player/render/BaseMultiVideoCompositionEffect;", "()V", "blendRenderProc", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoBitmapBlendRenderProc;", "cropRenderProc", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoCropRenderProc;", "effectRenderProc", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoXLabEffectRenderProc;", "frameTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "renderProcList", "", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "vLogRenderProc", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoVLogEffectRenderProc;", "getFrameTexture", "", "getFrameTextureHeight", "getFrameTextureWidth", "release", "", "renderTracks", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "trackList", "Lcom/tencent/mm/plugin/vlog/model/TrackRenderInfo;", "setBlendBitmapProvider", "blendBitmapProvider", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "setCropRect", "rect", "Landroid/graphics/Rect;", "setFilter", "path", "", "weight", "", "setVLogEffectConfig", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "Companion", "plugin-vlog_release"})
public final class c
  extends a
{
  public static final a LsS;
  public TextureInfo LsM;
  f LsN;
  private g LsO;
  private b LsP;
  private d LsQ;
  private List<? extends e> LsR;
  
  static
  {
    AppMethodBeat.i(201056);
    LsS = new a((byte)0);
    AppMethodBeat.o(201056);
  }
  
  public c()
  {
    AppMethodBeat.i(201055);
    this.LsN = new f();
    this.LsO = new g();
    this.LsP = new b();
    this.LsQ = new d();
    this.LsR = j.listOf(new e[] { (e)this.LsN, (e)this.LsO, (e)this.LsP, (e)this.LsQ });
    AppMethodBeat.o(201055);
  }
  
  public final void K(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(201052);
    k.h(paramb, "blendBitmapProvider");
    b localb = this.LsP;
    k.h(paramb, "blendBitmapProvider");
    ad.i("MicroMsg.MultiVideoBitmapBlendRenderProc", "setBlendBitmapProvider:" + paramb.hashCode());
    localb.gsq = paramb;
    AppMethodBeat.o(201052);
  }
  
  public final TextureInfo a(CIContext paramCIContext, long paramLong, List<u> paramList)
  {
    AppMethodBeat.i(201050);
    k.h(paramCIContext, "context");
    k.h(paramList, "trackList");
    Object localObject1 = ((Iterable)this.LsR).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      k.h(paramList, "track");
      ((e)localObject2).LsZ.clear();
      ((e)localObject2).LsZ.addAll((Collection)paramList);
      localObject3 = this.LsG;
      k.h(localObject3, "size");
      if ((((e)localObject2).LsG.getWidth() != ((Size)localObject3).getWidth()) || (((e)localObject2).LsG.getHeight() != ((Size)localObject3).getHeight())) {
        ad.i("MicroMsg.MultiVideoRenderProc", "render size changed:".concat(String.valueOf(localObject3)));
      }
      ((e)localObject2).LsG = new Size(((Size)localObject3).getWidth(), ((Size)localObject3).getHeight());
    }
    localObject1 = this.LsN.b(paramCIContext, paramLong, (List)v.Jgl);
    this.LsM = ((TextureInfo)localObject1);
    paramList = this.LsO;
    Object localObject2 = paramList.fVU;
    if (localObject2 != null)
    {
      if (((XLabEffect)localObject2).Lwh == -1L) {
        break label1241;
      }
      i = 1;
      if (i == 1) {}
    }
    else
    {
      if (((CharSequence)paramList.Ltd).length() <= 0) {
        break label1247;
      }
      i = 1;
      label249:
      if ((i == 0) || (paramList.Lte <= 0.0D)) {
        break label1253;
      }
    }
    int i = 1;
    label268:
    if (i != 0)
    {
      paramList = this.LsO;
      localObject1 = j.listOf(localObject1);
      k.h(paramCIContext, "context");
      k.h(localObject1, "inputTextures");
      if ((paramList.fVU == null) && (paramList.LsG.getWidth() > 0) && (paramList.LsG.getHeight() > 0)) {
        paramList.fVU = new XLabEffect(paramList.LsG.getWidth(), paramList.LsG.getHeight(), 0, false);
      }
      localObject2 = paramList.fVU;
      if (localObject2 != null) {
        ((XLabEffect)localObject2).setSize(paramList.LsG.getWidth(), paramList.LsG.getHeight());
      }
      if ((paramList.zwE == null) && (paramList.LsG.getWidth() > 0) && (paramList.LsG.getHeight() > 0)) {
        paramList.zwE = new com.tencent.mm.media.f.d(true, 17L);
      }
      localObject2 = paramList.zwE;
      if (localObject2 != null) {
        com.tencent.mm.media.f.d.a((com.tencent.mm.media.f.d)localObject2, paramList.LsG.getWidth(), paramList.LsG.getHeight(), 0, null, 0, 0, 60);
      }
      localObject2 = paramList.zwE;
      if (localObject2 != null)
      {
        i = ((com.tencent.mm.media.f.d)localObject2).gro;
        label497:
        if (!((List)localObject1).isEmpty()) {
          break label1265;
        }
        localObject1 = new TextureInfo(i, 3553, paramList.LsG.getWidth(), paramList.LsG.getHeight(), 0);
      }
    }
    for (;;)
    {
      label551:
      label746:
      label878:
      int j;
      if (this.LsP.gsq != null)
      {
        i = 1;
        paramList = (List<u>)localObject1;
        if (i != 0)
        {
          localObject3 = this.LsP;
          localObject1 = j.listOf(localObject1);
          k.h(paramCIContext, "context");
          k.h(localObject1, "inputTextures");
          if (((b)localObject3).LsJ == null) {
            ((b)localObject3).LsJ = new com.tencent.mm.media.i.b.b(((e)localObject3).LsG.getWidth(), ((e)localObject3).LsG.getHeight(), ((e)localObject3).LsG.getWidth(), ((e)localObject3).LsG.getHeight(), 2, 1);
          }
          paramList = ((b)localObject3).LsJ;
          if (paramList != null) {
            paramList.textureType = 3553;
          }
          paramList = ((b)localObject3).LsJ;
          if (paramList != null) {
            paramList.cS(((e)localObject3).LsG.getWidth(), ((e)localObject3).LsG.getHeight());
          }
          paramList = ((b)localObject3).LsJ;
          if (paramList != null) {
            paramList.cT(((e)localObject3).LsG.getWidth(), ((e)localObject3).LsG.getHeight());
          }
          paramList = ((b)localObject3).LsJ;
          if (paramList == null) {
            break label1466;
          }
          paramList = paramList.guU;
          ((b)localObject3).LsK = paramList;
          paramList = ((b)localObject3).LsK;
          if (paramList == null) {
            break label1472;
          }
          i = paramList.gro;
          label772:
          if (!((List)localObject1).isEmpty()) {
            break label1478;
          }
          paramList = new TextureInfo(i, 3553, ((e)localObject3).LsG.getWidth(), ((e)localObject3).LsG.getHeight(), 0);
        }
        if (this.LsQ.gtE == null) {
          break label1642;
        }
        i = 1;
        label826:
        localObject1 = paramList;
        if (i != 0)
        {
          localObject1 = this.LsQ;
          paramList = j.listOf(paramList);
          k.h(paramCIContext, "context");
          k.h(paramList, "inputTextures");
          paramCIContext = ((d)localObject1).gtE;
          if (paramCIContext == null) {
            break label1648;
          }
          i = paramCIContext.width();
          j = Math.abs(i);
          paramCIContext = ((d)localObject1).gtE;
          if (paramCIContext == null) {
            break label1654;
          }
          i = paramCIContext.height();
          label901:
          int m = Math.abs(i);
          i = ((e)localObject1).LsG.getWidth();
          int k = ((e)localObject1).LsG.getHeight();
          if ((((d)localObject1).gtE != null) && (j > 0) && (m > 0) && ((((d)localObject1).LsT == null) || (((d)localObject1).LsV)))
          {
            if (((d)localObject1).LsU == null) {
              ((d)localObject1).LsU = new com.tencent.mm.media.i.b.d(i, k, i, k, 2, 4);
            }
            paramCIContext = ((d)localObject1).LsU;
            if (paramCIContext == null) {
              break label1660;
            }
            paramCIContext = paramCIContext.guU;
            label1007:
            ((d)localObject1).LsT = paramCIContext;
            j = i * m / j;
            paramCIContext = ((d)localObject1).LsU;
            if (paramCIContext != null) {
              paramCIContext.cT(i, j);
            }
            paramCIContext = ((d)localObject1).LsU;
            if (paramCIContext != null) {
              paramCIContext.cS(i, k);
            }
            paramCIContext = ((d)localObject1).LsU;
            if (paramCIContext != null) {
              paramCIContext.guP = ((d)localObject1).gtE;
            }
            ((d)localObject1).LsX = new Size(i, j);
            ad.i("MicroMsg.MultiVideoCropRenderProc", "checkInitCropOutputTextureInfo, cropRect:" + ((d)localObject1).gtE + ", cropProc drawSize:[" + i + ", " + j + "], renderSize:[" + i + ", " + k + ']');
            ((d)localObject1).LsV = false;
          }
          paramCIContext = ((d)localObject1).LsT;
          if (paramCIContext == null) {
            break label1665;
          }
          i = paramCIContext.gro;
          label1192:
          if (!paramList.isEmpty()) {
            break label1671;
          }
        }
      }
      for (localObject1 = new TextureInfo(i, 3553, ((e)localObject1).LsG.getWidth(), ((e)localObject1).LsG.getHeight(), 0);; localObject1 = new TextureInfo(i, 3553, ((d)localObject1).LsX.getWidth(), ((d)localObject1).LsX.getHeight(), 0))
      {
        AppMethodBeat.o(201050);
        return localObject1;
        label1241:
        i = 0;
        break;
        label1247:
        i = 0;
        break label249;
        label1253:
        i = 0;
        break label268;
        i = 0;
        break label497;
        label1265:
        localObject1 = (TextureInfo)j.iy((List)localObject1);
        if (((CharSequence)paramList.Ltd).length() > 0) {}
        for (j = 1;; j = 0)
        {
          if ((j != 0) && (paramList.Lte > 0.0F))
          {
            ad.d("MicroMsg.MultiVideoXLabEffectRenderProc", "xlab effect filterPath:" + paramList.Ltd + ", filterWeight:" + paramList.Lte);
            localObject2 = paramList.fVU;
            if (localObject2 != null) {
              ((XLabEffect)localObject2).m(paramList.Ltd, paramList.Lte);
            }
            paramList.Ltd = "";
            paramList.Lte = 0.0F;
          }
          localObject2 = paramList.fVU;
          if (localObject2 != null) {
            XLabEffect.a((XLabEffect)localObject2, ((TextureInfo)localObject1).textureID, i, 0L, false, 60);
          }
          localObject1 = new TextureInfo(i, 3553, paramList.LsG.getWidth(), paramList.LsG.getHeight(), 0);
          break;
        }
        i = 0;
        break label551;
        label1466:
        paramList = null;
        break label746;
        label1472:
        i = 0;
        break label772;
        label1478:
        localObject2 = (TextureInfo)j.iy((List)localObject1);
        paramList = ((b)localObject3).gsq;
        if (paramList != null) {}
        for (localObject1 = (Bitmap)paramList.aA(Long.valueOf(paramLong));; localObject1 = null)
        {
          paramList = (List<u>)localObject2;
          if (localObject1 == null) {
            break;
          }
          paramList = ((b)localObject3).LsJ;
          if (paramList != null) {
            paramList.guY = true;
          }
          paramList = ((b)localObject3).LsJ;
          if (paramList != null) {
            paramList.guC = ((TextureInfo)localObject2).textureID;
          }
          paramList = ((b)localObject3).LsJ;
          if (paramList != null) {
            paramList.d((Bitmap)localObject1, true);
          }
          paramList = ((b)localObject3).LsJ;
          if (paramList != null) {
            paramList.akk();
          }
          paramList = new TextureInfo(i, 3553, ((e)localObject3).LsG.getWidth(), ((e)localObject3).LsG.getHeight(), 0);
          break;
        }
        label1642:
        i = 0;
        break label826;
        label1648:
        i = 0;
        break label878;
        label1654:
        i = 0;
        break label901;
        label1660:
        paramCIContext = null;
        break label1007;
        label1665:
        i = 0;
        break label1192;
        label1671:
        paramCIContext = (TextureInfo)j.iy(paramList);
        paramList = ((d)localObject1).LsU;
        if (paramList != null) {
          paramList.guC = paramCIContext.textureID;
        }
        paramCIContext = ((d)localObject1).LsU;
        if (paramCIContext != null) {
          paramCIContext.akk();
        }
      }
    }
  }
  
  public final void p(String paramString, float paramFloat)
  {
    AppMethodBeat.i(201053);
    k.h(paramString, "path");
    g localg = this.LsO;
    k.h(paramString, "path");
    ad.i("MicroMsg.MultiVideoXLabEffectRenderProc", "setFilter, path:" + paramString + ", weight:" + paramFloat + ", xLabEffect:" + localg.fVU);
    localg.Ltd = paramString;
    localg.Lte = paramFloat;
    AppMethodBeat.o(201053);
  }
  
  public final void release()
  {
    AppMethodBeat.i(201054);
    super.release();
    Iterator localIterator = ((Iterable)this.LsR).iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).release();
    }
    AppMethodBeat.o(201054);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(201051);
    k.h(paramRect, "rect");
    d locald = this.LsQ;
    k.h(paramRect, "rect");
    ad.i("MicroMsg.MultiVideoCropRenderProc", "setCropRect:".concat(String.valueOf(paramRect)));
    if ((k.g(paramRect, locald.gtE) ^ true))
    {
      locald.gtE = paramRect;
      locald.LsV = true;
    }
    AppMethodBeat.o(201051);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoCompositionEffect$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a.c
 * JD-Core Version:    0.7.0.1
 */