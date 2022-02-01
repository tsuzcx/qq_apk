package com.tencent.mm.plugin.vlog.player;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.plugin.vlog.model.ab;
import com.tencent.mm.sdk.platformtools.ad;
import d.d.a.a;
import d.d.d;
import d.g.a.m;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "", "previewPlay", "", "(Z)V", "imagePtsStep", "", "mute", "nextPtsStep", "playerList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "Lkotlin/collections/ArrayList;", "getPreviewPlay", "()Z", "setPreviewPlay", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "targetHeight", "", "targetWidth", "texCache", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "videoPtsStep", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "cacheMaterialPlayer", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "cacheMaterialPlayerByIndex", "index", "checkPreloadNextMaterials", "pts", "currentMaterial", "clearScreen", "", "doPreloadMaterials", "nextMaterialIndices", "drawImpl", "currentMaterials", "nextMaterialList", "outputTexture", "drawScript", "ptsMs", "outputTexId", "getPtsMaterials", "getPtsStep", "initXEffectInGlesThread", "width", "height", "needPreloadMaterials", "onPlayEnd", "loop", "pause", "prepareMaterial", "prepare", "release", "resetAllPlayers", "resume", "setMediaFps", "videoFps", "imageFps", "setMute", "setScript", "widthScale", "", "heightScale", "Companion", "plugin-vlog_release"})
public final class i
{
  public static final a BIK;
  aa BIE;
  ArrayList<b> BIF;
  j BIG;
  long BIH;
  long BII;
  long BIJ;
  boolean BIi;
  com.tencent.mm.plugin.xlabeffect.b gtl;
  boolean hvp;
  int targetHeight;
  int targetWidth;
  
  static
  {
    AppMethodBeat.i(195952);
    BIK = new a((byte)0);
    AppMethodBeat.o(195952);
  }
  
  public i(boolean paramBoolean)
  {
    AppMethodBeat.i(195951);
    this.BIi = paramBoolean;
    this.hvp = true;
    this.BIF = new ArrayList();
    this.BIG = new j();
    this.BIH = 33L;
    this.BII = 16L;
    this.BIJ = this.BIH;
    AppMethodBeat.o(195951);
  }
  
  final ArrayList<Integer> a(long paramLong, ArrayList<com.tencent.mm.plugin.vlog.model.l> paramArrayList)
  {
    AppMethodBeat.i(195946);
    Object localObject1 = this.BIE;
    int j;
    int i;
    label78:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((aa)localObject1).BGM;
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
              com.tencent.mm.plugin.vlog.model.l locall = (com.tencent.mm.plugin.vlog.model.l)((Iterator)localObject2).next();
              if ((p.i(locall.path, ((com.tencent.mm.plugin.vlog.model.l)((List)localObject1).get(i)).path)) && (locall.startTime >= ((com.tencent.mm.plugin.vlog.model.l)((List)localObject1).get(i)).startTime))
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
        paramLong = ((com.tencent.mm.plugin.vlog.model.l)((List)localObject1).get(j + 1)).startTime - paramLong;
        if (400L <= paramLong) {
          break label247;
        }
      }
      label247:
      while (600L < paramLong)
      {
        AppMethodBeat.o(195946);
        return null;
      }
      paramArrayList = new ArrayList();
      paramArrayList.add(Integer.valueOf(j + 1));
      AppMethodBeat.o(195946);
      return paramArrayList;
    }
  }
  
  final ArrayList<com.tencent.mm.plugin.vlog.model.l> a(ArrayList<Integer> paramArrayList, final long paramLong)
  {
    AppMethodBeat.i(195947);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    label135:
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      if (i < this.BIF.size()) {}
      for (paramArrayList = (b)this.BIF.get(i);; paramArrayList = null)
      {
        if ((paramArrayList == null) || (paramArrayList.BHY)) {
          break label135;
        }
        kotlinx.coroutines.f.b((ah)bk.NII, (d.d.f)az.gvp(), (m)new b(paramArrayList, null, this, paramLong, localArrayList), 2);
        localArrayList.add(paramArrayList.BIa);
        break;
      }
    }
    AppMethodBeat.o(195947);
    return localArrayList;
  }
  
  final void a(ArrayList<com.tencent.mm.plugin.vlog.model.l> paramArrayList1, ArrayList<com.tencent.mm.plugin.vlog.model.l> paramArrayList2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(195948);
    GLES20.glViewport(0, 0, this.targetWidth, this.targetHeight);
    Object localObject1 = c.hoP;
    c.a.aug();
    localObject1 = ((Iterable)this.BIF).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).active = false;
    }
    localObject1 = ((Iterable)paramArrayList1).iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.vlog.model.l)((Iterator)localObject1).next();
      Iterator localIterator = ((Iterable)this.BIF).iterator();
      label115:
      int i;
      if (localIterator.hasNext())
      {
        paramArrayList1 = localIterator.next();
        b localb = (b)paramArrayList1;
        if ((p.i(localb.BIa.path, ((com.tencent.mm.plugin.vlog.model.l)localObject2).path)) && (localb.BIa.startTime >= ((com.tencent.mm.plugin.vlog.model.l)localObject2).startTime))
        {
          i = 1;
          label178:
          if (i == 0) {
            break label375;
          }
          label183:
          paramArrayList1 = (b)paramArrayList1;
          if (paramArrayList1 != null)
          {
            if (!paramArrayList1.bdb)
            {
              ad.i("MicroMsg.VLogScriptReader", "drawImpl prepare material player: " + paramLong + ", " + ((com.tencent.mm.plugin.vlog.model.l)localObject2).startTime + ", " + ((com.tencent.mm.plugin.vlog.model.l)localObject2).path);
              paramArrayList1.prepare();
            }
            if (!paramArrayList1.BHY)
            {
              ad.i("MicroMsg.VLogScriptReader", "drawImpl play material player: " + paramLong + ", " + ((com.tencent.mm.plugin.vlog.model.l)localObject2).startTime + ", " + ((com.tencent.mm.plugin.vlog.model.l)localObject2).path);
              paramArrayList1.Bm(paramLong - paramArrayList1.BIa.startTime);
            }
            paramArrayList1.active = true;
            paramArrayList1.H(paramLong - paramArrayList1.BIa.startTime, true);
          }
          if (!(localObject2 instanceof ab)) {
            break label382;
          }
        }
      }
      label375:
      label382:
      for (long l = this.BIH;; l = this.BII)
      {
        this.BIJ = l;
        break;
        i = 0;
        break label178;
        break label115;
        paramArrayList1 = null;
        break label183;
      }
    }
    paramArrayList1 = this.gtl;
    if (paramArrayList1 != null) {
      com.tencent.mm.plugin.xlabeffect.b.a(paramArrayList1, 0, paramInt, false, 56);
    }
    paramArrayList1 = ((Iterable)this.BIF).iterator();
    label624:
    label627:
    while (paramArrayList1.hasNext())
    {
      localObject1 = (b)paramArrayList1.next();
      if (!((b)localObject1).active)
      {
        if (paramArrayList2 != null)
        {
          localObject2 = (Iterable)paramArrayList2;
          if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
            break label624;
          }
          localObject2 = ((Iterable)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          } while (!p.i(((com.tencent.mm.plugin.vlog.model.l)((Iterator)localObject2).next()).path, ((b)localObject1).BIa.path));
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label627;
          }
          if ((paramLong - ((b)localObject1).BIa.endTime <= 0L) || (!((b)localObject1).BHY)) {
            break;
          }
          ((b)localObject1).stop();
          ad.i("MicroMsg.VLogScriptReader", "stop player " + ((b)localObject1).BIa.path + ", pts:" + paramLong + ", endTime:" + ((b)localObject1).BIa.endTime);
          break;
        }
      }
    }
    AppMethodBeat.o(195948);
  }
  
  public final void ip(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195945);
    this.targetWidth = paramInt1;
    this.targetHeight = paramInt2;
    ad.i("MicroMsg.VLogScriptReader", "set target size:[" + this.targetWidth + ", " + this.targetHeight + ']');
    this.gtl = new com.tencent.mm.plugin.xlabeffect.b(this.targetWidth, this.targetHeight, 0);
    com.tencent.mm.plugin.xlabeffect.b localb = this.gtl;
    if (localb != null) {
      localb.setSize(this.targetWidth, this.targetHeight);
    }
    this.BIG.esJ();
    AppMethodBeat.o(195945);
  }
  
  final void sS(boolean paramBoolean)
  {
    AppMethodBeat.i(195949);
    ad.i("MicroMsg.VLogScriptReader", "resetAllPlayers size:" + this.BIF.size());
    Iterator localIterator = ((Iterable)this.BIF).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.stop();
      if (paramBoolean) {
        localb.release();
      }
    }
    AppMethodBeat.o(195949);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader$Companion;", "", "()V", "TAG", "", "preloadThresholdLowerBound", "", "preloadThresholdUpperBound", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$doPreloadMaterials$1$1$1", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$$special$$inlined$apply$lambda$1"})
  static final class b
    extends d.d.b.a.j
    implements m<ah, d<? super z>, Object>
  {
    int label;
    private ah nWQ;
    
    b(b paramb, d paramd, i parami, long paramLong, ArrayList paramArrayList)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(195943);
      p.h(paramd, "completion");
      paramd = new b(this.BIL, paramd, jdField_this, paramLong, this.BIO);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(195943);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(195942);
      paramObject = a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(195942);
        throw paramObject;
      }
      ad.i("MicroMsg.VLogScriptReader", "doPreloadMaterials, play: " + this.BIL.BIa.path + ", texture:" + this.BIL.BHZ + ", pts:" + paramLong + ", startTime:" + this.BIL.BIa.startTime);
      if (!this.BIL.bdb) {
        this.BIL.prepare();
      }
      this.BIL.Bm(0L);
      this.BIL.H(0L, false);
      paramObject = z.MKo;
      AppMethodBeat.o(195942);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(195944);
      paramObject1 = ((b)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
      AppMethodBeat.o(195944);
      return paramObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.i
 * JD-Core Version:    0.7.0.1
 */