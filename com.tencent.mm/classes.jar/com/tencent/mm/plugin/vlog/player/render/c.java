package com.tencent.mm.plugin.vlog.player.render;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.p;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import d.a.j;
import d.a.v;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.vlog.model.p;>;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoCompositionEffect;", "Lcom/tencent/mm/plugin/vlog/player/render/BaseMultiVideoCompositionEffect;", "()V", "blendRenderProc", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoBitmapBlendRenderProc;", "cropRenderProc", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoCropRenderProc;", "effectRenderProc", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoXLabEffectRenderProc;", "frameTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "renderProcList", "", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "vLogRenderProc", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoVLogEffectRenderProc;", "getFrameTexture", "", "getFrameTextureHeight", "getFrameTextureWidth", "release", "", "renderTracks", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "trackList", "Lcom/tencent/mm/plugin/vlog/model/TrackRenderInfo;", "setBlendBitmapProvider", "blendBitmapProvider", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "setCropRect", "rect", "Landroid/graphics/Rect;", "setFilter", "path", "", "weight", "", "setVLogEffectConfig", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "Companion", "plugin-vlog_release"})
public final class c
  extends a
{
  public static final c.a AqZ;
  private TextureInfo AqT;
  f AqU;
  public g AqV;
  private b AqW;
  private d AqX;
  private List<? extends e> AqY;
  
  static
  {
    AppMethodBeat.i(207741);
    AqZ = new c.a((byte)0);
    AppMethodBeat.o(207741);
  }
  
  public c()
  {
    AppMethodBeat.i(207740);
    this.AqU = new f();
    this.AqV = new g();
    this.AqW = new b();
    this.AqX = new d();
    this.AqY = j.listOf(new e[] { (e)this.AqU, (e)this.AqV, (e)this.AqW, (e)this.AqX });
    AppMethodBeat.o(207740);
  }
  
  public final void D(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(207738);
    k.h(paramb, "blendBitmapProvider");
    b localb = this.AqW;
    k.h(paramb, "blendBitmapProvider");
    ac.i("MicroMsg.MultiVideoBitmapBlendRenderProc", "setBlendBitmapProvider:" + paramb.hashCode());
    localb.gSX = paramb;
    AppMethodBeat.o(207738);
  }
  
  public final TextureInfo a(CIContext paramCIContext, long paramLong, List<p> paramList)
  {
    AppMethodBeat.i(207736);
    k.h(paramCIContext, "context");
    k.h(paramList, "trackList");
    Object localObject1 = ((Iterable)this.AqY).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      k.h(paramList, "track");
      ((e)localObject2).Arg.clear();
      ((e)localObject2).Arg.addAll((Collection)paramList);
      localObject3 = this.AqM;
      k.h(localObject3, "size");
      if ((((e)localObject2).AqM.getWidth() != ((Size)localObject3).getWidth()) || (((e)localObject2).AqM.getHeight() != ((Size)localObject3).getHeight())) {
        ac.i("MicroMsg.MultiVideoRenderProc", "render size changed:".concat(String.valueOf(localObject3)));
      }
      ((e)localObject2).AqM = new Size(((Size)localObject3).getWidth(), ((Size)localObject3).getHeight());
    }
    if (this.AqO) {}
    for (Object localObject2 = new StringBuilder();; localObject2 = null)
    {
      if (localObject2 != null) {
        ((StringBuilder)localObject2).append("pts: " + paramLong + ", inputSize " + paramList.size() + ", renderSize " + this.AqM + ", renderContext " + paramCIContext.getRenderContext().width() + ' ' + paramCIContext.getRenderContext().height() + ' ');
      }
      paramList = this.AqU.b(paramCIContext, paramLong, (List)v.KTF);
      if (localObject2 != null) {
        ((StringBuilder)localObject2).append("vlogOutput: " + paramList.textureID + " size: " + paramList.width + ", " + paramList.height + ' ');
      }
      this.AqT = paramList;
      localObject1 = this.AqV;
      localObject3 = ((g)localObject1).fZP;
      if (localObject3 != null)
      {
        if (((XLabEffect)localObject3).DdX == -1L) {
          break label1584;
        }
        i = 1;
        if (i == 1) {}
      }
      else
      {
        if (((CharSequence)((g)localObject1).Ark).length() <= 0) {
          break label1590;
        }
        i = 1;
        label420:
        if ((i == 0) || (((g)localObject1).Arl <= 0.0D)) {
          break label1596;
        }
      }
      int i = 1;
      label439:
      if (i != 0)
      {
        localObject1 = this.AqV;
        paramList = j.listOf(paramList);
        k.h(paramCIContext, "context");
        k.h(paramList, "inputTextures");
        if ((((g)localObject1).fZP == null) && (((e)localObject1).AqM.getWidth() > 0) && (((e)localObject1).AqM.getHeight() > 0)) {
          ((g)localObject1).fZP = new XLabEffect(((e)localObject1).AqM.getWidth(), ((e)localObject1).AqM.getHeight(), 0, false);
        }
        localObject3 = ((g)localObject1).fZP;
        if (localObject3 != null) {
          ((XLabEffect)localObject3).setSize(((e)localObject1).AqM.getWidth(), ((e)localObject1).AqM.getHeight());
        }
        if ((((g)localObject1).gqY == null) && (((e)localObject1).AqM.getWidth() > 0) && (((e)localObject1).AqM.getHeight() > 0)) {
          ((g)localObject1).gqY = new com.tencent.mm.media.f.d(true, 17L);
        }
        localObject3 = ((g)localObject1).gqY;
        if (localObject3 != null) {
          com.tencent.mm.media.f.d.a((com.tencent.mm.media.f.d)localObject3, ((e)localObject1).AqM.getWidth(), ((e)localObject1).AqM.getHeight(), 0, null, 0, 0, 60);
        }
        localObject3 = ((g)localObject1).gqY;
        if (localObject3 != null)
        {
          i = ((com.tencent.mm.media.f.d)localObject3).gRW;
          if (!paramList.isEmpty()) {
            break label1608;
          }
          paramList = new TextureInfo(i, 3553, ((e)localObject1).AqM.getWidth(), ((e)localObject1).AqM.getHeight(), 0);
        }
      }
      for (;;)
      {
        label668:
        label722:
        b localb;
        label917:
        label943:
        label1122:
        int j;
        if (this.AqW.gSX != null)
        {
          i = 1;
          localObject1 = paramList;
          if (i != 0)
          {
            localb = this.AqW;
            localObject1 = j.listOf(paramList);
            k.h(paramCIContext, "context");
            k.h(localObject1, "inputTextures");
            if (localb.AqQ == null) {
              localb.AqQ = new com.tencent.mm.media.i.b.b(localb.AqM.getWidth(), localb.AqM.getHeight(), localb.AqM.getWidth(), localb.AqM.getHeight(), 2, 1);
            }
            paramList = localb.AqQ;
            if (paramList != null) {
              paramList.textureType = 3553;
            }
            paramList = localb.AqQ;
            if (paramList != null) {
              paramList.cS(localb.AqM.getWidth(), localb.AqM.getHeight());
            }
            paramList = localb.AqQ;
            if (paramList != null) {
              paramList.cR(localb.AqM.getWidth(), localb.AqM.getHeight());
            }
            paramList = localb.AqQ;
            if (paramList == null) {
              break label1809;
            }
            paramList = paramList.gVr;
            localb.AqR = paramList;
            paramList = localb.AqR;
            if (paramList == null) {
              break label1815;
            }
            i = paramList.gRW;
            if (!((List)localObject1).isEmpty()) {
              break label1821;
            }
            paramList = new TextureInfo(i, 3553, localb.AqM.getWidth(), localb.AqM.getHeight(), 0);
            localObject1 = paramList;
            if (localObject2 != null)
            {
              ((StringBuilder)localObject2).append("blendOutput: " + paramList.textureID + " size: " + paramList.width + ", " + paramList.height + ' ');
              localObject1 = paramList;
            }
          }
          if (this.AqX.gUl == null) {
            break label1985;
          }
          i = 1;
          label1070:
          paramList = (List<p>)localObject1;
          if (i != 0)
          {
            paramList = this.AqX;
            localObject1 = j.listOf(localObject1);
            k.h(paramCIContext, "context");
            k.h(localObject1, "inputTextures");
            paramCIContext = paramList.gUl;
            if (paramCIContext == null) {
              break label1991;
            }
            i = paramCIContext.width();
            j = Math.abs(i);
            paramCIContext = paramList.gUl;
            if (paramCIContext == null) {
              break label1997;
            }
            i = paramCIContext.height();
            label1145:
            int m = Math.abs(i);
            i = paramList.AqM.getWidth();
            int k = paramList.AqM.getHeight();
            if ((paramList.gUl != null) && (j > 0) && (m > 0) && ((paramList.Ara == null) || (paramList.Arc)))
            {
              if (paramList.Arb == null) {
                paramList.Arb = new com.tencent.mm.media.i.b.e(i, k, i, k, 2, 4);
              }
              paramCIContext = paramList.Arb;
              if (paramCIContext == null) {
                break label2003;
              }
              paramCIContext = paramCIContext.gVr;
              label1251:
              paramList.Ara = paramCIContext;
              j = i * m / j;
              paramCIContext = paramList.Arb;
              if (paramCIContext != null) {
                paramCIContext.cR(i, j);
              }
              paramCIContext = paramList.Arb;
              if (paramCIContext != null) {
                paramCIContext.cS(i, k);
              }
              paramCIContext = paramList.Arb;
              if (paramCIContext != null) {
                paramCIContext.gVo = paramList.gUl;
              }
              paramList.Are = new Size(i, j);
              ac.i("MicroMsg.MultiVideoCropRenderProc", "checkInitCropOutputTextureInfo, cropRect:" + paramList.gUl + ", cropProc drawSize:[" + i + ", " + j + "], renderSize:[" + i + ", " + k + ']');
              paramList.Arc = false;
            }
            paramCIContext = paramList.Ara;
            if (paramCIContext == null) {
              break label2008;
            }
            i = paramCIContext.gRW;
            label1436:
            if (!((List)localObject1).isEmpty()) {
              break label2014;
            }
          }
        }
        for (paramCIContext = new TextureInfo(i, 3553, paramList.AqM.getWidth(), paramList.AqM.getHeight(), 0);; paramCIContext = new TextureInfo(i, 3553, paramList.Are.getWidth(), paramList.Are.getHeight(), 0))
        {
          paramList = paramCIContext;
          if (localObject2 != null)
          {
            ((StringBuilder)localObject2).append("cropOutput: " + paramCIContext.textureID + " size: " + paramCIContext.width + ", " + paramCIContext.height + ' ');
            paramList = paramCIContext;
          }
          if (localObject2 != null) {
            ac.i("MicroMsg.MultiVideoCompositionEffect", "renderTracks: " + ((StringBuilder)localObject2).toString());
          }
          AppMethodBeat.o(207736);
          return paramList;
          label1584:
          i = 0;
          break;
          label1590:
          i = 0;
          break label420;
          label1596:
          i = 0;
          break label439;
          i = 0;
          break label668;
          label1608:
          paramList = (TextureInfo)j.iO(paramList);
          if (((CharSequence)((g)localObject1).Ark).length() > 0) {}
          for (j = 1;; j = 0)
          {
            if ((j != 0) && (((g)localObject1).Arl > 0.0F))
            {
              ac.d("MicroMsg.MultiVideoXLabEffectRenderProc", "xlab effect filterPath:" + ((g)localObject1).Ark + ", filterWeight:" + ((g)localObject1).Arl);
              localObject3 = ((g)localObject1).fZP;
              if (localObject3 != null) {
                ((XLabEffect)localObject3).m(((g)localObject1).Ark, ((g)localObject1).Arl);
              }
              ((g)localObject1).Ark = "";
              ((g)localObject1).Arl = 0.0F;
            }
            localObject3 = ((g)localObject1).fZP;
            if (localObject3 != null) {
              XLabEffect.a((XLabEffect)localObject3, paramList.textureID, i, 0L, false, 60);
            }
            paramList = new TextureInfo(i, 3553, ((e)localObject1).AqM.getWidth(), ((e)localObject1).AqM.getHeight(), 0);
            break;
          }
          i = 0;
          break label722;
          label1809:
          paramList = null;
          break label917;
          label1815:
          i = 0;
          break label943;
          label1821:
          localObject3 = (TextureInfo)j.iO((List)localObject1);
          paramList = localb.gSX;
          if (paramList != null) {}
          for (localObject1 = (Bitmap)paramList.ay(Long.valueOf(paramLong));; localObject1 = null)
          {
            paramList = (List<p>)localObject3;
            if (localObject1 == null) {
              break;
            }
            paramList = localb.AqQ;
            if (paramList != null) {
              paramList.gVv = true;
            }
            paramList = localb.AqQ;
            if (paramList != null) {
              paramList.gqX = ((TextureInfo)localObject3).textureID;
            }
            paramList = localb.AqQ;
            if (paramList != null) {
              paramList.b((Bitmap)localObject1, true);
            }
            paramList = localb.AqQ;
            if (paramList != null) {
              paramList.ajG();
            }
            paramList = new TextureInfo(i, 3553, localb.AqM.getWidth(), localb.AqM.getHeight(), 0);
            break;
          }
          label1985:
          i = 0;
          break label1070;
          label1991:
          i = 0;
          break label1122;
          label1997:
          i = 0;
          break label1145;
          label2003:
          paramCIContext = null;
          break label1251;
          label2008:
          i = 0;
          break label1436;
          label2014:
          paramCIContext = (TextureInfo)j.iO((List)localObject1);
          localObject1 = paramList.Arb;
          if (localObject1 != null) {
            ((com.tencent.mm.media.i.b.e)localObject1).gqX = paramCIContext.textureID;
          }
          paramCIContext = paramList.Arb;
          if (paramCIContext != null) {
            paramCIContext.ajG();
          }
        }
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(207739);
    super.release();
    Iterator localIterator = ((Iterable)this.AqY).iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).release();
    }
    AppMethodBeat.o(207739);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(207737);
    k.h(paramRect, "rect");
    d locald = this.AqX;
    k.h(paramRect, "rect");
    ac.i("MicroMsg.MultiVideoCropRenderProc", "setCropRect:".concat(String.valueOf(paramRect)));
    if ((k.g(paramRect, locald.gUl) ^ true))
    {
      locald.gUl = paramRect;
      locald.Arc = true;
    }
    AppMethodBeat.o(207737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.render.c
 * JD-Core Version:    0.7.0.1
 */