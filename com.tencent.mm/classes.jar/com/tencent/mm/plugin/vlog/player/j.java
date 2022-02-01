package com.tencent.mm.plugin.vlog.player;

import android.opengl.GLES20;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import d.d.a.a;
import d.d.d;
import d.g.a.m;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bh;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "", "previewPlay", "", "(Z)V", "imagePtsStep", "", "mute", "nextPtsStep", "playerList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "Lkotlin/collections/ArrayList;", "getPreviewPlay", "()Z", "setPreviewPlay", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "targetHeight", "", "targetWidth", "texCache", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "videoPtsStep", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "cacheMaterialPlayer", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "cacheMaterialPlayerByIndex", "index", "checkPreloadNextMaterials", "pts", "currentMaterial", "clearScreen", "", "doPreloadMaterials", "nextMaterialIndices", "drawImpl", "currentMaterials", "nextMaterialList", "outputTexture", "drawScript", "ptsMs", "outputTexId", "getPtsMaterials", "getPtsStep", "initXEffectInGlesThread", "width", "height", "needPreloadMaterials", "onPlayEnd", "loop", "pause", "prepareMaterial", "prepare", "release", "resetAllPlayers", "resume", "setMediaFps", "videoFps", "imageFps", "setMute", "setScript", "widthScale", "", "heightScale", "Companion", "plugin-vlog_release"})
public final class j
{
  public static final j.a Aqn;
  boolean ApK;
  com.tencent.mm.plugin.vlog.model.y Aqh;
  ArrayList<b> Aqi;
  k Aqj;
  long Aqk;
  long Aql;
  long Aqm;
  XLabEffect fZP;
  int gNU;
  int gNV;
  boolean hdh;
  
  static
  {
    AppMethodBeat.i(207730);
    Aqn = new j.a((byte)0);
    AppMethodBeat.o(207730);
  }
  
  public j(boolean paramBoolean)
  {
    AppMethodBeat.i(207729);
    this.ApK = paramBoolean;
    this.hdh = true;
    this.Aqi = new ArrayList();
    this.Aqj = new k();
    this.Aqk = 33L;
    this.Aql = 16L;
    this.Aqm = this.Aqk;
    AppMethodBeat.o(207729);
  }
  
  final ArrayList<Integer> a(long paramLong, ArrayList<com.tencent.mm.plugin.vlog.model.i> paramArrayList)
  {
    AppMethodBeat.i(207724);
    Object localObject1 = this.Aqh;
    int j;
    int i;
    label78:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.vlog.model.y)localObject1).AoV;
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
              com.tencent.mm.plugin.vlog.model.i locali = (com.tencent.mm.plugin.vlog.model.i)((Iterator)localObject2).next();
              if ((d.g.b.k.g(locali.path, ((com.tencent.mm.plugin.vlog.model.i)((List)localObject1).get(i)).path)) && (locali.startTime >= ((com.tencent.mm.plugin.vlog.model.i)((List)localObject1).get(i)).startTime))
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
        paramLong = ((com.tencent.mm.plugin.vlog.model.i)((List)localObject1).get(j + 1)).startTime - paramLong;
        if (400L <= paramLong) {
          break label247;
        }
      }
      label247:
      while (600L < paramLong)
      {
        AppMethodBeat.o(207724);
        return null;
      }
      paramArrayList = new ArrayList();
      paramArrayList.add(Integer.valueOf(j + 1));
      AppMethodBeat.o(207724);
      return paramArrayList;
    }
  }
  
  final ArrayList<com.tencent.mm.plugin.vlog.model.i> a(ArrayList<Integer> paramArrayList, final long paramLong)
  {
    AppMethodBeat.i(207725);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    label135:
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      if (i < this.Aqi.size()) {}
      for (paramArrayList = (b)this.Aqi.get(i);; paramArrayList = null)
      {
        if ((paramArrayList == null) || (paramArrayList.Apr)) {
          break label135;
        }
        kotlinx.coroutines.f.b((ag)bh.LRM, (d.d.f)ay.gdP(), (m)new b(paramArrayList, null, this, paramLong, localArrayList), 2);
        localArrayList.add(paramArrayList.Apt);
        break;
      }
    }
    AppMethodBeat.o(207725);
    return localArrayList;
  }
  
  final void a(ArrayList<com.tencent.mm.plugin.vlog.model.i> paramArrayList1, ArrayList<com.tencent.mm.plugin.vlog.model.i> paramArrayList2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(207726);
    GLES20.glViewport(0, 0, this.gNU, this.gNV);
    Object localObject1 = c.gWJ;
    c.a.art();
    localObject1 = ((Iterable)this.Aqi).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).active = false;
    }
    localObject1 = ((Iterable)paramArrayList1).iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.vlog.model.i)((Iterator)localObject1).next();
      Object localObject3 = ((Iterable)this.Aqi).iterator();
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
        if ((d.g.b.k.g(localb.Apt.path, ((com.tencent.mm.plugin.vlog.model.i)localObject2).path)) && (localb.Apt.startTime >= ((com.tencent.mm.plugin.vlog.model.i)localObject2).startTime))
        {
          i = 1;
          if (i == 0) {
            break label510;
          }
          paramArrayList1 = (b)paramArrayList1;
          if (paramArrayList1 != null)
          {
            if (!paramArrayList1.aSG)
            {
              ac.i("MicroMsg.VLogScriptReader", "drawImpl prepare material player: " + paramLong + ", " + ((com.tencent.mm.plugin.vlog.model.i)localObject2).startTime + ", " + ((com.tencent.mm.plugin.vlog.model.i)localObject2).path);
              paramArrayList1.prepare();
            }
            if (!paramArrayList1.Apr)
            {
              ac.i("MicroMsg.VLogScriptReader", "drawImpl play material player: " + paramLong + ", " + ((com.tencent.mm.plugin.vlog.model.i)localObject2).startTime + ", " + ((com.tencent.mm.plugin.vlog.model.i)localObject2).path);
              paramArrayList1.yJ(paramLong - paramArrayList1.Apt.startTime);
            }
            paramArrayList1.active = true;
            paramArrayList1.H(paramLong - paramArrayList1.Apt.startTime, true);
            localObject3 = this.fZP;
            if (localObject3 != null)
            {
              i = paramArrayList1.Aps;
              j = paramArrayList1.width;
              k = paramArrayList1.height;
              m = paramArrayList1.duc;
              bool = paramArrayList1.isOES();
              n = paramArrayList1.cropLeft;
              i1 = paramArrayList1.cropTop;
              i2 = paramArrayList1.cropRight;
              i3 = paramArrayList1.cropBottom;
              l = SystemClock.elapsedRealtime();
              if (((XLabEffect)localObject3).DdK != 0L) {
                break label517;
              }
              i = -1;
              label431:
              ac.d(XLabEffect.TAG, "addAuxiliaryTexture " + ((XLabEffect)localObject3).DdK + ' ' + i + ", cost:" + (SystemClock.elapsedRealtime() - l));
            }
          }
          if (!(localObject2 instanceof z)) {
            break label551;
          }
        }
      }
      label517:
      label551:
      for (long l = this.Aqk;; l = this.Aql)
      {
        this.Aqm = l;
        break;
        i = 0;
        break label178;
        label510:
        break label115;
        paramArrayList1 = null;
        break label183;
        i = ((XLabEffect)localObject3).nAddAuxiliaryTexture(((XLabEffect)localObject3).DdK, i, j, k, m, bool, false, n, i1, i2, i3);
        break label431;
      }
    }
    paramArrayList1 = this.fZP;
    if (paramArrayList1 != null) {
      XLabEffect.a(paramArrayList1, 0, paramInt, paramLong, false, 56);
    }
    paramArrayList1 = ((Iterable)this.Aqi).iterator();
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
          } while (!d.g.b.k.g(((com.tencent.mm.plugin.vlog.model.i)((Iterator)localObject2).next()).path, ((b)localObject1).Apt.path));
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label798;
          }
          if ((paramLong - ((b)localObject1).Apt.endTime <= 0L) || (!((b)localObject1).Apr)) {
            break;
          }
          ((b)localObject1).stop();
          ac.i("MicroMsg.VLogScriptReader", "stop player " + ((b)localObject1).Apt.path + ", pts:" + paramLong + ", endTime:" + ((b)localObject1).Apt.endTime);
          break;
        }
      }
    }
    AppMethodBeat.o(207726);
  }
  
  public final void hZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207723);
    this.gNU = paramInt1;
    this.gNV = paramInt2;
    ac.i("MicroMsg.VLogScriptReader", "set target size:[" + this.gNU + ", " + this.gNV + ']');
    this.fZP = new XLabEffect(this.gNU, this.gNV, 0, false);
    XLabEffect localXLabEffect = this.fZP;
    if (localXLabEffect != null) {
      localXLabEffect.setSize(this.gNU, this.gNV);
    }
    this.Aqj.efW();
    AppMethodBeat.o(207723);
  }
  
  final void sm(boolean paramBoolean)
  {
    AppMethodBeat.i(207727);
    ac.i("MicroMsg.VLogScriptReader", "resetAllPlayers size:" + this.Aqi.size());
    Iterator localIterator = ((Iterable)this.Aqi).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.stop();
      if (paramBoolean) {
        localb.release();
      }
    }
    AppMethodBeat.o(207727);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$doPreloadMaterials$1$1$1", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$$special$$inlined$apply$lambda$1"})
  static final class b
    extends d.d.b.a.i
    implements m<ag, d<? super d.y>, Object>
  {
    int label;
    private ag nvs;
    
    b(b paramb, d paramd, j paramj, long paramLong, ArrayList paramArrayList)
    {
      super();
    }
    
    public final d<d.y> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(207721);
      d.g.b.k.h(paramd, "completion");
      paramd = new b(this.Aqo, paramd, jdField_this, paramLong, this.Aqr);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(207721);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(207720);
      paramObject = a.KUd;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(207720);
        throw paramObject;
      }
      ac.i("MicroMsg.VLogScriptReader", "doPreloadMaterials, play: " + this.Aqo.Apt.path + ", texture:" + this.Aqo.Aps + ", pts:" + paramLong + ", startTime:" + this.Aqo.Apt.startTime);
      if (!this.Aqo.aSG) {
        this.Aqo.prepare();
      }
      this.Aqo.yJ(0L);
      this.Aqo.H(0L, false);
      paramObject = d.y.KTp;
      AppMethodBeat.o(207720);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(207722);
      paramObject1 = ((b)a(paramObject1, (d)paramObject2)).cO(d.y.KTp);
      AppMethodBeat.o(207722);
      return paramObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.j
 * JD-Core Version:    0.7.0.1
 */