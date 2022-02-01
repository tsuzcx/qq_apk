package com.tencent.mm.plugin.vlog.player;

import android.opengl.GLES20;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.plugin.vlog.model.h;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import d.d.a.a;
import d.d.b.a.j;
import d.d.f;
import d.g.a.m;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "", "previewPlay", "", "(Z)V", "imagePtsStep", "", "mute", "nextPtsStep", "playerList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "Lkotlin/collections/ArrayList;", "getPreviewPlay", "()Z", "setPreviewPlay", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "targetHeight", "", "targetWidth", "texCache", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "videoPtsStep", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "cacheMaterialPlayer", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "cacheMaterialPlayerByIndex", "index", "checkPreloadNextMaterials", "pts", "currentMaterial", "clearScreen", "", "doPreloadMaterials", "nextMaterialIndices", "drawImpl", "currentMaterials", "nextMaterialList", "outputTexture", "drawScript", "ptsMs", "outputTexId", "getPtsMaterials", "getPtsStep", "initXEffectInGlesThread", "width", "height", "needPreloadMaterials", "onPlayEnd", "loop", "pause", "prepareMaterial", "prepare", "release", "resetAllPlayers", "resume", "setMediaFps", "videoFps", "imageFps", "setMute", "setScript", "widthScale", "", "heightScale", "Companion", "plugin-vlog_release"})
public final class k
{
  public static final a Lsr;
  boolean LrX;
  ArrayList<b> Lsm;
  l Lsn;
  long Lso;
  long Lsp;
  long Lsq;
  XLabEffect fVU;
  boolean gCJ;
  int gnh;
  int gni;
  h zbt;
  
  static
  {
    AppMethodBeat.i(201044);
    Lsr = new a((byte)0);
    AppMethodBeat.o(201044);
  }
  
  public k(boolean paramBoolean)
  {
    AppMethodBeat.i(201043);
    this.LrX = paramBoolean;
    this.gCJ = true;
    this.Lsm = new ArrayList();
    this.Lsn = new l();
    this.Lso = 33L;
    this.Lsp = 16L;
    this.Lsq = this.Lso;
    AppMethodBeat.o(201043);
  }
  
  final ArrayList<Integer> a(long paramLong, ArrayList<com.tencent.mm.plugin.vlog.model.d> paramArrayList)
  {
    AppMethodBeat.i(201038);
    Object localObject1 = this.zbt;
    int j;
    int i;
    label78:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((h)localObject1).yZs;
      if (localObject1 != null)
      {
        j = 0;
        i = 0;
        int m = ((List)localObject1).size();
        if (i < m)
        {
          Object localObject2 = (Iterable)paramArrayList;
          if (!((Collection)localObject2).isEmpty())
          {
            localObject2 = ((Iterable)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              com.tencent.mm.plugin.vlog.model.d locald = (com.tencent.mm.plugin.vlog.model.d)((Iterator)localObject2).next();
              if ((d.g.b.k.g(locald.path, ((com.tencent.mm.plugin.vlog.model.d)((List)localObject1).get(i)).path)) && (locald.startTime >= ((com.tencent.mm.plugin.vlog.model.d)((List)localObject1).get(i)).startTime))
              {
                k = 1;
                label153:
                if (k == 0) {
                  break label190;
                }
                k = 1;
                label161:
                if ((k == 0) || (i < j)) {
                  break label282;
                }
                j = i;
              }
            }
          }
        }
      }
    }
    label282:
    for (;;)
    {
      i += 1;
      break;
      k = 0;
      break label153;
      label190:
      break label78;
      k = 0;
      break label161;
      if (j + 1 < ((List)localObject1).size())
      {
        paramLong = ((com.tencent.mm.plugin.vlog.model.d)((List)localObject1).get(j + 1)).startTime - paramLong;
        if (400L <= paramLong) {
          break label247;
        }
      }
      label247:
      while (600L < paramLong)
      {
        AppMethodBeat.o(201038);
        return null;
      }
      paramArrayList = new ArrayList();
      paramArrayList.add(Integer.valueOf(j + 1));
      AppMethodBeat.o(201038);
      return paramArrayList;
    }
  }
  
  final ArrayList<com.tencent.mm.plugin.vlog.model.d> a(ArrayList<Integer> paramArrayList, final long paramLong)
  {
    AppMethodBeat.i(201039);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    label135:
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      if (i < this.Lsm.size()) {}
      for (paramArrayList = (b)this.Lsm.get(i);; paramArrayList = null)
      {
        if ((paramArrayList == null) || (paramArrayList.yZR)) {
          break label135;
        }
        kotlinx.coroutines.d.a((kotlinx.coroutines.ad)bc.Kem, (f)at.fLg(), (m)new b(paramArrayList, null, this, paramLong, localArrayList), 2);
        localArrayList.add(paramArrayList.yZT);
        break;
      }
    }
    AppMethodBeat.o(201039);
    return localArrayList;
  }
  
  final void a(ArrayList<com.tencent.mm.plugin.vlog.model.d> paramArrayList1, ArrayList<com.tencent.mm.plugin.vlog.model.d> paramArrayList2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(201040);
    GLES20.glViewport(0, 0, this.gnh, this.gni);
    Object localObject1 = c.gwl;
    c.a.akz();
    localObject1 = ((Iterable)this.Lsm).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).active = false;
    }
    localObject1 = ((Iterable)paramArrayList1).iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.vlog.model.d)((Iterator)localObject1).next();
      Object localObject3 = ((Iterable)this.Lsm).iterator();
      label115:
      int i;
      label178:
      label183:
      int j;
      int k;
      int m;
      boolean bool;
      int n;
      int i1;
      int i2;
      int i3;
      if (((Iterator)localObject3).hasNext())
      {
        paramArrayList1 = ((Iterator)localObject3).next();
        b localb = (b)paramArrayList1;
        if ((d.g.b.k.g(localb.yZT.path, ((com.tencent.mm.plugin.vlog.model.d)localObject2).path)) && (localb.yZT.startTime >= ((com.tencent.mm.plugin.vlog.model.d)localObject2).startTime))
        {
          i = 1;
          if (i == 0) {
            break label510;
          }
          paramArrayList1 = (b)paramArrayList1;
          if (paramArrayList1 != null)
          {
            if (!paramArrayList1.aRL)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogScriptReader", "drawImpl prepare material player: " + paramLong + ", " + ((com.tencent.mm.plugin.vlog.model.d)localObject2).startTime + ", " + ((com.tencent.mm.plugin.vlog.model.d)localObject2).path);
              paramArrayList1.prepare();
            }
            if (!paramArrayList1.yZR)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogScriptReader", "drawImpl play material player: " + paramLong + ", " + ((com.tencent.mm.plugin.vlog.model.d)localObject2).startTime + ", " + ((com.tencent.mm.plugin.vlog.model.d)localObject2).path);
              paramArrayList1.ug(paramLong - paramArrayList1.yZT.startTime);
            }
            paramArrayList1.active = true;
            paramArrayList1.H(paramLong - paramArrayList1.yZT.startTime, true);
            localObject3 = this.fVU;
            if (localObject3 != null)
            {
              i = paramArrayList1.yZS;
              j = paramArrayList1.width;
              k = paramArrayList1.height;
              m = paramArrayList1.dwp;
              bool = paramArrayList1.isOES();
              n = paramArrayList1.yZN;
              i1 = paramArrayList1.yZO;
              i2 = paramArrayList1.yZP;
              i3 = paramArrayList1.yZQ;
              l = SystemClock.elapsedRealtime();
              if (((XLabEffect)localObject3).BLC != 0L) {
                break label517;
              }
              i = -1;
              label431:
              com.tencent.mm.sdk.platformtools.ad.d(XLabEffect.TAG, "addAuxiliaryTexture " + ((XLabEffect)localObject3).BLC + ' ' + i + ", cost:" + (SystemClock.elapsedRealtime() - l));
            }
          }
          if (!(localObject2 instanceof i)) {
            break label551;
          }
        }
      }
      label517:
      label551:
      for (long l = this.Lso;; l = this.Lsp)
      {
        this.Lsq = l;
        break;
        i = 0;
        break label178;
        label510:
        break label115;
        paramArrayList1 = null;
        break label183;
        i = ((XLabEffect)localObject3).nAddAuxiliaryTexture(((XLabEffect)localObject3).BLC, i, j, k, m, bool, false, n, i1, i2, i3);
        break label431;
      }
    }
    paramArrayList1 = this.fVU;
    if (paramArrayList1 != null) {
      XLabEffect.a(paramArrayList1, 0, paramInt, paramLong, false, 56);
    }
    paramArrayList1 = ((Iterable)this.Lsm).iterator();
    label795:
    label798:
    while (paramArrayList1.hasNext())
    {
      localObject1 = (b)paramArrayList1.next();
      if (!((b)localObject1).active)
      {
        if (paramArrayList2 != null)
        {
          localObject2 = (Iterable)paramArrayList2;
          if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
            break label795;
          }
          localObject2 = ((Iterable)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          } while (!d.g.b.k.g(((com.tencent.mm.plugin.vlog.model.d)((Iterator)localObject2).next()).path, ((b)localObject1).yZT.path));
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label798;
          }
          if ((paramLong - ((b)localObject1).yZT.endTime <= 0L) || (!((b)localObject1).yZR)) {
            break;
          }
          ((b)localObject1).stop();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogScriptReader", "stop player " + ((b)localObject1).yZT.path + ", pts:" + paramLong + ", endTime:" + ((b)localObject1).yZT.endTime);
          break;
        }
      }
    }
    AppMethodBeat.o(201040);
  }
  
  public final void lh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201037);
    this.gnh = paramInt1;
    this.gni = paramInt2;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogScriptReader", "set target size:[" + this.gnh + ", " + this.gni + ']');
    this.fVU = new XLabEffect(this.gnh, this.gni, 0, false);
    XLabEffect localXLabEffect = this.fVU;
    if (localXLabEffect != null) {
      localXLabEffect.setSize(this.gnh, this.gni);
    }
    this.Lsn.dRg();
    AppMethodBeat.o(201037);
  }
  
  final void zf(boolean paramBoolean)
  {
    AppMethodBeat.i(201041);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogScriptReader", "resetAllPlayers size:" + this.Lsm.size());
    Iterator localIterator = ((Iterable)this.Lsm).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.stop();
      if (paramBoolean) {
        localb.release();
      }
    }
    AppMethodBeat.o(201041);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader$Companion;", "", "()V", "TAG", "", "preloadThresholdLowerBound", "", "preloadThresholdUpperBound", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$doPreloadMaterials$1$1$1", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$$special$$inlined$apply$lambda$1"})
  static final class b
    extends j
    implements m<kotlinx.coroutines.ad, d.d.d<? super y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    
    b(b paramb, d.d.d paramd, k paramk, long paramLong, ArrayList paramArrayList)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(201035);
      d.g.b.k.h(paramd, "completion");
      paramd = new b(this.Lss, paramd, jdField_this, paramLong, this.Lsv);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(201035);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(201034);
      paramObject = a.JgJ;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(201034);
        throw paramObject;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogScriptReader", "doPreloadMaterials, play: " + this.Lss.yZT.path + ", texture:" + this.Lss.yZS + ", pts:" + paramLong + ", startTime:" + this.Lss.yZT.startTime);
      if (!this.Lss.aRL) {
        this.Lss.prepare();
      }
      this.Lss.ug(0L);
      this.Lss.H(0L, false);
      paramObject = y.JfV;
      AppMethodBeat.o(201034);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(201036);
      paramObject1 = ((b)a(paramObject1, (d.d.d)paramObject2)).cP(y.JfV);
      AppMethodBeat.o(201036);
      return paramObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.k
 * JD-Core Version:    0.7.0.1
 */