package com.tencent.mm.plugin.vlog.player;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.aj;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "", "previewPlay", "", "(Z)V", "imagePtsStep", "", "mute", "nextPtsStep", "playerList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "Lkotlin/collections/ArrayList;", "getPreviewPlay", "()Z", "setPreviewPlay", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "targetHeight", "", "targetWidth", "texCache", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "videoPtsStep", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "cacheMaterialPlayer", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "cacheMaterialPlayerByIndex", "index", "checkPreloadNextMaterials", "pts", "currentMaterial", "clearScreen", "", "doPreloadMaterials", "nextMaterialIndices", "drawImpl", "currentMaterials", "nextMaterialList", "outputTexture", "drawScript", "ptsMs", "outputTexId", "getPtsMaterials", "getPtsStep", "initXEffectInGlesThread", "width", "height", "needPreloadMaterials", "onPlayEnd", "loop", "pause", "prepareMaterial", "prepare", "release", "resetAllPlayers", "resume", "setMediaFps", "videoFps", "imageFps", "setMute", "setScript", "widthScale", "", "heightScale", "Companion", "plugin-vlog_release"})
public final class i
{
  public static final a GBW;
  ah GBQ;
  ArrayList<b> GBR;
  j GBS;
  long GBT;
  long GBU;
  long GBV;
  boolean GBu;
  com.tencent.mm.plugin.xlabeffect.b hiH;
  boolean isb;
  int targetHeight;
  int targetWidth;
  
  static
  {
    AppMethodBeat.i(190883);
    GBW = new a((byte)0);
    AppMethodBeat.o(190883);
  }
  
  public i(boolean paramBoolean)
  {
    AppMethodBeat.i(190882);
    this.GBu = paramBoolean;
    this.isb = true;
    this.GBR = new ArrayList();
    this.GBS = new j();
    this.GBT = 33L;
    this.GBU = 16L;
    this.GBV = this.GBT;
    AppMethodBeat.o(190882);
  }
  
  final ArrayList<Integer> a(long paramLong, ArrayList<s> paramArrayList)
  {
    AppMethodBeat.i(190877);
    Object localObject1 = this.GBQ;
    int j;
    int i;
    label78:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((ah)localObject1).GzQ;
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
              s locals = (s)((Iterator)localObject2).next();
              if ((p.j(locals.path, ((s)((List)localObject1).get(i)).path)) && (locals.startTime >= ((s)((List)localObject1).get(i)).startTime))
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
        paramLong = ((s)((List)localObject1).get(j + 1)).startTime - paramLong;
        if (400L <= paramLong) {
          break label247;
        }
      }
      label247:
      while (600L < paramLong)
      {
        AppMethodBeat.o(190877);
        return null;
      }
      paramArrayList = new ArrayList();
      paramArrayList.add(Integer.valueOf(j + 1));
      AppMethodBeat.o(190877);
      return paramArrayList;
    }
  }
  
  final ArrayList<s> a(ArrayList<Integer> paramArrayList, final long paramLong)
  {
    AppMethodBeat.i(190878);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    label135:
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      if (i < this.GBR.size()) {}
      for (paramArrayList = (b)this.GBR.get(i);; paramArrayList = null)
      {
        if ((paramArrayList == null) || (paramArrayList.GBl)) {
          break label135;
        }
        kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (m)new b(paramArrayList, null, this, paramLong, localArrayList), 2);
        localArrayList.add(paramArrayList.GBm);
        break;
      }
    }
    AppMethodBeat.o(190878);
    return localArrayList;
  }
  
  final void a(ArrayList<s> paramArrayList1, ArrayList<s> paramArrayList2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(190879);
    GLES20.glViewport(0, 0, this.targetWidth, this.targetHeight);
    Object localObject1 = c.ilt;
    c.a.aMY();
    localObject1 = ((Iterable)this.GBR).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).active = false;
    }
    localObject1 = ((Iterable)paramArrayList1).iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (s)((Iterator)localObject1).next();
      Iterator localIterator = ((Iterable)this.GBR).iterator();
      label115:
      int i;
      if (localIterator.hasNext())
      {
        paramArrayList1 = localIterator.next();
        b localb = (b)paramArrayList1;
        if ((p.j(localb.GBm.path, ((s)localObject2).path)) && (localb.GBm.startTime >= ((s)localObject2).startTime))
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
            if (!paramArrayList1.bcY)
            {
              Log.i("MicroMsg.VLogScriptReader", "drawImpl prepare material player: " + paramLong + ", " + ((s)localObject2).startTime + ", " + ((s)localObject2).path);
              paramArrayList1.prepare();
            }
            if (!paramArrayList1.GBl)
            {
              Log.i("MicroMsg.VLogScriptReader", "drawImpl play material player: " + paramLong + ", " + ((s)localObject2).startTime + ", " + ((s)localObject2).path);
              paramArrayList1.KV(paramLong - paramArrayList1.GBm.startTime);
            }
            paramArrayList1.active = true;
            paramArrayList1.O(paramLong - paramArrayList1.GBm.startTime, true);
          }
          if (!(localObject2 instanceof aj)) {
            break label382;
          }
        }
      }
      label375:
      label382:
      for (long l = this.GBT;; l = this.GBU)
      {
        this.GBV = l;
        break;
        i = 0;
        break label178;
        break label115;
        paramArrayList1 = null;
        break label183;
      }
    }
    paramArrayList1 = this.hiH;
    if (paramArrayList1 != null) {
      com.tencent.mm.plugin.xlabeffect.b.a(paramArrayList1, 0, paramInt, false, 56);
    }
    paramArrayList1 = ((Iterable)this.GBR).iterator();
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
          } while (!p.j(((s)((Iterator)localObject2).next()).path, ((b)localObject1).GBm.path));
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label627;
          }
          if ((paramLong - ((b)localObject1).GBm.endTime <= 0L) || (!((b)localObject1).GBl)) {
            break;
          }
          ((b)localObject1).stop();
          Log.i("MicroMsg.VLogScriptReader", "stop player " + ((b)localObject1).GBm.path + ", pts:" + paramLong + ", endTime:" + ((b)localObject1).GBm.endTime);
          break;
        }
      }
    }
    AppMethodBeat.o(190879);
  }
  
  public final void jv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190876);
    this.targetWidth = paramInt1;
    this.targetHeight = paramInt2;
    Log.i("MicroMsg.VLogScriptReader", "set target size:[" + this.targetWidth + ", " + this.targetHeight + ']');
    this.hiH = new com.tencent.mm.plugin.xlabeffect.b(this.targetWidth, this.targetHeight, (byte)0);
    com.tencent.mm.plugin.xlabeffect.b localb = this.hiH;
    if (localb != null) {
      localb.setSize(this.targetWidth, this.targetHeight);
    }
    this.GBS.fCp();
    AppMethodBeat.o(190876);
  }
  
  final void wD(boolean paramBoolean)
  {
    AppMethodBeat.i(190880);
    Log.i("MicroMsg.VLogScriptReader", "resetAllPlayers size:" + this.GBR.size());
    Iterator localIterator = ((Iterable)this.GBR).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.stop();
      if (paramBoolean) {
        localb.release();
      }
    }
    AppMethodBeat.o(190880);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader$Companion;", "", "()V", "TAG", "", "preloadThresholdLowerBound", "", "preloadThresholdUpperBound", "plugin-vlog_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$doPreloadMaterials$1$1$1", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$$special$$inlined$apply$lambda$1"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ai, d<? super x>, Object>
  {
    int label;
    private ai p$;
    
    b(b paramb, d paramd, i parami, long paramLong, ArrayList paramArrayList)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(190874);
      p.h(paramd, "completion");
      paramd = new b(this.GBX, paramd, jdField_this, paramLong, this.GCa);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(190874);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(190875);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(190875);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(190873);
      a locala = a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(190873);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Log.i("MicroMsg.VLogScriptReader", "doPreloadMaterials, play: " + this.GBX.GBm.path + ", texture:" + this.GBX.Gxi + ", pts:" + paramLong + ", startTime:" + this.GBX.GBm.startTime);
      if (!this.GBX.bcY) {
        this.GBX.prepare();
      }
      this.GBX.KV(0L);
      this.GBX.O(0L, false);
      paramObject = x.SXb;
      AppMethodBeat.o(190873);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.i
 * JD-Core Version:    0.7.0.1
 */