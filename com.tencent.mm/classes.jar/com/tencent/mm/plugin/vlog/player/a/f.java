package com.tencent.mm.plugin.vlog.player.a;

import android.graphics.Point;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ai;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoVLogEffectRenderProc;", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "()V", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "vLogRender", "Lcom/tencent/mm/xeffect/VLogRendererJNI;", "checkCreateOutputTexture", "", "checkInitVLogRender", "release", "render", "Lcom/tencent/tav/coremedia/TextureInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "ptsMs", "", "inputTextures", "", "setEffectConfig", "Companion", "plugin-vlog_release"})
public final class f
  extends e
{
  public static final a Ltc;
  dkv LqR;
  private VLogRendererJNI Ltb;
  private d zwE;
  
  static
  {
    AppMethodBeat.i(201062);
    Ltc = new a((byte)0);
    AppMethodBeat.o(201062);
  }
  
  public final TextureInfo b(CIContext paramCIContext, long paramLong, List<? extends TextureInfo> paramList)
  {
    AppMethodBeat.i(201060);
    k.h(paramCIContext, "context");
    k.h(paramList, "inputTextures");
    if (this.Ltb == null)
    {
      this.Ltb = new VLogRendererJNI();
      paramCIContext = this.Ltb;
      if (paramCIContext != null) {
        paramCIContext.init();
      }
      if ((this.LsG.getWidth() > 0) && (this.LsG.getHeight() > 0))
      {
        paramCIContext = this.Ltb;
        if (paramCIContext != null) {
          paramCIContext.setSize(this.LsG.getWidth(), this.LsG.getHeight());
        }
        paramCIContext = this.LqR;
        if (paramCIContext == null) {
          break label485;
        }
        paramList = ai.cf(aj.getContext());
        paramList.y = ((int)(paramList.x * (this.LsG.getHeight() / this.LsG.getWidth())));
        float f1 = paramList.x / this.LsG.getWidth();
        float f2 = paramList.y / this.LsG.getHeight();
        localObject1 = this.Ltb;
        if (localObject1 != null) {
          ((VLogRendererJNI)localObject1).setEffectConfig(paramCIContext.toByteArray(), f1, f2);
        }
        ad.i("MiroMsg.MultiVideoVLogEffectRenderProc", "init xlab effect, size:" + this.LsG + ", widthScale:" + f1 + ", heightScale:" + f2 + ", screenSize:" + paramList);
      }
    }
    paramCIContext = this.Ltb;
    if (paramCIContext != null) {
      paramCIContext.setSize(this.LsG.getWidth(), this.LsG.getHeight());
    }
    if (this.zwE == null) {
      this.zwE = new d(true, 17L);
    }
    if ((this.LsG.getWidth() > 0) && (this.LsG.getHeight() > 0))
    {
      paramCIContext = this.zwE;
      if (paramCIContext != null) {
        d.a(paramCIContext, this.LsG.getWidth(), this.LsG.getHeight(), 0, null, 0, 0, 60);
      }
    }
    Object localObject1 = new LinkedList();
    paramCIContext = ((Iterable)this.LsZ).iterator();
    label382:
    Object localObject2;
    if (paramCIContext.hasNext())
    {
      paramList = ((u)paramCIContext.next()).texture;
      k.h(paramList, "$this$toInputTexture");
      i = paramList.textureID;
      int j = paramList.width;
      int k = paramList.height;
      if (paramList.textureType != 3553) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = new a(i, j, k, bool);
        ((a)localObject2).dwp = paramList.preferRotation;
        ((LinkedList)localObject1).add(localObject2);
        break label382;
        label485:
        ad.i("MiroMsg.MultiVideoVLogEffectRenderProc", "init xlab effect, size:" + this.LsG);
        break;
      }
    }
    paramCIContext = this.zwE;
    if (paramCIContext != null) {}
    for (int i = paramCIContext.gro;; i = 0)
    {
      paramList = new TextureInfo(i, 3553, this.LsG.getWidth(), this.LsG.getHeight(), 0);
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(201060);
      return paramList;
    }
    if (this.LqR != null)
    {
      localObject2 = this.Ltb;
      paramCIContext = paramList;
      if (localObject2 != null)
      {
        ((VLogRendererJNI)localObject2).renderWithConfig((List)localObject1, i, paramLong);
        paramCIContext = paramList;
      }
      AppMethodBeat.o(201060);
      return paramCIContext;
    }
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      paramCIContext = paramList;
      if (i == 0) {
        break;
      }
      paramCIContext = new TextureInfo(((a)((LinkedList)localObject1).get(0)).textureId, 3553, this.LsG.getWidth(), this.LsG.getHeight(), 0);
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(201061);
    Object localObject = this.Ltb;
    if (localObject != null) {
      ((VLogRendererJNI)localObject).destroy();
    }
    localObject = this.zwE;
    if (localObject != null)
    {
      ((d)localObject).close();
      AppMethodBeat.o(201061);
      return;
    }
    AppMethodBeat.o(201061);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoVLogEffectRenderProc$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a.f
 * JD-Core Version:    0.7.0.1
 */