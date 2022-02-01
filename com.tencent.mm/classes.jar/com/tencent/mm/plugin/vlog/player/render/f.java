package com.tencent.mm.plugin.vlog.player.render;

import android.graphics.Point;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.vlog.model.p;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.aj;
import com.tencent.mm.xeffect.VLogRendererJNI;
import com.tencent.mm.xeffect.a;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoVLogEffectRenderProc;", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "()V", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "vLogRender", "Lcom/tencent/mm/xeffect/VLogRendererJNI;", "checkCreateOutputTexture", "", "checkInitVLogRender", "release", "render", "Lcom/tencent/tav/coremedia/TextureInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "ptsMs", "", "inputTextures", "", "setEffectConfig", "Companion", "plugin-vlog_release"})
public final class f
  extends e
{
  public static final a Arj;
  dqm AnZ;
  private VLogRendererJNI Ari;
  private d gqY;
  
  static
  {
    AppMethodBeat.i(207747);
    Arj = new a((byte)0);
    AppMethodBeat.o(207747);
  }
  
  public final TextureInfo b(CIContext paramCIContext, long paramLong, List<? extends TextureInfo> paramList)
  {
    AppMethodBeat.i(207745);
    k.h(paramCIContext, "context");
    k.h(paramList, "inputTextures");
    if (this.Ari == null)
    {
      this.Ari = new VLogRendererJNI();
      paramCIContext = this.Ari;
      if (paramCIContext != null) {
        paramCIContext.init();
      }
      if ((this.AqM.getWidth() > 0) && (this.AqM.getHeight() > 0))
      {
        paramCIContext = this.Ari;
        if (paramCIContext != null) {
          paramCIContext.setSize(this.AqM.getWidth(), this.AqM.getHeight());
        }
        paramCIContext = this.AnZ;
        if (paramCIContext == null) {
          break label485;
        }
        paramList = aj.cl(ai.getContext());
        paramList.y = ((int)(paramList.x * (this.AqM.getHeight() / this.AqM.getWidth())));
        float f1 = paramList.x / this.AqM.getWidth();
        float f2 = paramList.y / this.AqM.getHeight();
        localObject1 = this.Ari;
        if (localObject1 != null) {
          ((VLogRendererJNI)localObject1).setEffectConfig(paramCIContext.toByteArray(), f1, f2);
        }
        ac.i("MiroMsg.MultiVideoVLogEffectRenderProc", "init xlab effect, size:" + this.AqM + ", widthScale:" + f1 + ", heightScale:" + f2 + ", screenSize:" + paramList);
      }
    }
    paramCIContext = this.Ari;
    if (paramCIContext != null) {
      paramCIContext.setSize(this.AqM.getWidth(), this.AqM.getHeight());
    }
    if (this.gqY == null) {
      this.gqY = new d(true, 17L);
    }
    if ((this.AqM.getWidth() > 0) && (this.AqM.getHeight() > 0))
    {
      paramCIContext = this.gqY;
      if (paramCIContext != null) {
        d.a(paramCIContext, this.AqM.getWidth(), this.AqM.getHeight(), 0, null, 0, 0, 60);
      }
    }
    Object localObject1 = new LinkedList();
    paramCIContext = ((Iterable)this.Arg).iterator();
    label382:
    Object localObject2;
    if (paramCIContext.hasNext())
    {
      paramList = ((p)paramCIContext.next()).texture;
      k.h(paramList, "$this$toInputTexture");
      i = paramList.textureID;
      int j = paramList.width;
      int k = paramList.height;
      if (paramList.textureType != 3553) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = new a(i, j, k, bool);
        ((a)localObject2).duc = paramList.preferRotation;
        ((LinkedList)localObject1).add(localObject2);
        break label382;
        label485:
        ac.i("MiroMsg.MultiVideoVLogEffectRenderProc", "init xlab effect, size:" + this.AqM);
        break;
      }
    }
    paramCIContext = this.gqY;
    if (paramCIContext != null) {}
    for (int i = paramCIContext.gRW;; i = 0)
    {
      paramList = new TextureInfo(i, 3553, this.AqM.getWidth(), this.AqM.getHeight(), 0);
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(207745);
      return paramList;
    }
    if (this.AnZ != null)
    {
      localObject2 = this.Ari;
      paramCIContext = paramList;
      if (localObject2 != null)
      {
        ((VLogRendererJNI)localObject2).renderWithConfig((List)localObject1, i, paramLong);
        paramCIContext = paramList;
      }
      AppMethodBeat.o(207745);
      return paramCIContext;
    }
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      paramCIContext = paramList;
      if (i == 0) {
        break;
      }
      paramCIContext = new TextureInfo(((a)((LinkedList)localObject1).get(0)).textureId, 3553, this.AqM.getWidth(), this.AqM.getHeight(), 0);
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(207746);
    Object localObject = this.Ari;
    if (localObject != null) {
      ((VLogRendererJNI)localObject).destroy();
    }
    localObject = this.gqY;
    if (localObject != null)
    {
      ((d)localObject).close();
      AppMethodBeat.o(207746);
      return;
    }
    AppMethodBeat.o(207746);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoVLogEffectRenderProc$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.render.f
 * JD-Core Version:    0.7.0.1
 */