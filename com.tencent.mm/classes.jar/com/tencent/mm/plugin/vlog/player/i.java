package com.tencent.mm.plugin.vlog.player;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.aj;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "", "previewPlay", "", "(Z)V", "imagePtsStep", "", "mute", "nextPtsStep", "playerList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "Lkotlin/collections/ArrayList;", "getPreviewPlay", "()Z", "setPreviewPlay", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "targetHeight", "", "targetWidth", "texCache", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "videoPtsStep", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "cacheMaterialPlayer", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "cacheMaterialPlayerByIndex", "index", "checkPreloadNextMaterials", "pts", "currentMaterial", "clearScreen", "", "doPreloadMaterials", "nextMaterialIndices", "drawImpl", "currentMaterials", "nextMaterialList", "outputTexture", "drawScript", "ptsMs", "outputTexId", "getPtsMaterials", "getPtsStep", "initXEffectInGlesThread", "width", "height", "needPreloadMaterials", "onPlayEnd", "loop", "pause", "prepareMaterial", "prepare", "release", "resetAllPlayers", "resume", "setMediaFps", "videoFps", "imageFps", "setMute", "setScript", "widthScale", "", "heightScale", "Companion", "plugin-vlog_release"})
public final class i
{
  public static final a NpH;
  ah NpB;
  ArrayList<b> NpC;
  j NpD;
  long NpE;
  long NpF;
  long NpG;
  boolean Npg;
  e jUF;
  boolean lhf;
  int targetHeight;
  int targetWidth;
  
  static
  {
    AppMethodBeat.i(229565);
    NpH = new a((byte)0);
    AppMethodBeat.o(229565);
  }
  
  public i(boolean paramBoolean)
  {
    AppMethodBeat.i(229562);
    this.Npg = paramBoolean;
    this.lhf = true;
    this.NpC = new ArrayList();
    this.NpD = new j();
    this.NpE = 33L;
    this.NpF = 16L;
    this.NpG = this.NpE;
    AppMethodBeat.o(229562);
  }
  
  final void Ar(boolean paramBoolean)
  {
    AppMethodBeat.i(229557);
    Log.i("MicroMsg.VLogScriptReader", "resetAllPlayers size:" + this.NpC.size());
    Iterator localIterator = ((Iterable)this.NpC).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.stop();
      if (paramBoolean) {
        localb.release();
      }
    }
    AppMethodBeat.o(229557);
  }
  
  final ArrayList<Integer> a(long paramLong, ArrayList<s> paramArrayList)
  {
    AppMethodBeat.i(229549);
    Object localObject1 = this.NpB;
    int j;
    int i;
    label78:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((ah)localObject1).Nnw;
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
              if ((p.h(locals.path, ((s)((List)localObject1).get(i)).path)) && (locals.startTime >= ((s)((List)localObject1).get(i)).startTime))
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
        AppMethodBeat.o(229549);
        return null;
      }
      paramArrayList = new ArrayList();
      paramArrayList.add(Integer.valueOf(j + 1));
      AppMethodBeat.o(229549);
      return paramArrayList;
    }
  }
  
  final ArrayList<s> a(ArrayList<Integer> paramArrayList, final long paramLong)
  {
    AppMethodBeat.i(229552);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    label135:
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      if (i < this.NpC.size()) {}
      for (paramArrayList = (b)this.NpC.get(i);; paramArrayList = null)
      {
        if ((paramArrayList == null) || (paramArrayList.NoX)) {
          break label135;
        }
        g.b((ak)br.abxo, (f)bc.iRs(), (m)new b(paramArrayList, null, this, paramLong, localArrayList), 2);
        localArrayList.add(paramArrayList.NoY);
        break;
      }
    }
    AppMethodBeat.o(229552);
    return localArrayList;
  }
  
  final void a(ArrayList<s> paramArrayList1, ArrayList<s> paramArrayList2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(229554);
    GLES20.glViewport(0, 0, this.targetWidth, this.targetHeight);
    Object localObject1 = c.lar;
    c.a.aVB();
    localObject1 = ((Iterable)this.NpC).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).active = false;
    }
    localObject1 = ((Iterable)paramArrayList1).iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (s)((Iterator)localObject1).next();
      Iterator localIterator = ((Iterable)this.NpC).iterator();
      label115:
      int i;
      if (localIterator.hasNext())
      {
        paramArrayList1 = localIterator.next();
        b localb = (b)paramArrayList1;
        if ((p.h(localb.NoY.path, ((s)localObject2).path)) && (localb.NoY.startTime >= ((s)localObject2).startTime))
        {
          i = 1;
          label178:
          if (i == 0) {
            break label373;
          }
          label183:
          paramArrayList1 = (b)paramArrayList1;
          if (paramArrayList1 != null)
          {
            if (!paramArrayList1.aMy)
            {
              Log.i("MicroMsg.VLogScriptReader", "drawImpl prepare material player: " + paramLong + ", " + ((s)localObject2).startTime + ", " + ((s)localObject2).path);
              paramArrayList1.prepare();
            }
            if (!paramArrayList1.NoX)
            {
              Log.i("MicroMsg.VLogScriptReader", "drawImpl play material player: " + paramLong + ", " + ((s)localObject2).startTime + ", " + ((s)localObject2).path);
              paramArrayList1.Ss(paramLong - paramArrayList1.NoY.startTime);
            }
            paramArrayList1.active = true;
            paramArrayList1.O(paramLong - paramArrayList1.NoY.startTime, true);
          }
          if (!(localObject2 instanceof aj)) {
            break label380;
          }
        }
      }
      label373:
      label380:
      for (long l = this.NpE;; l = this.NpF)
      {
        this.NpG = l;
        break;
        i = 0;
        break label178;
        break label115;
        paramArrayList1 = null;
        break label183;
      }
    }
    paramArrayList1 = this.jUF;
    if (paramArrayList1 != null) {
      e.a(paramArrayList1, 0, paramInt, false, 56);
    }
    paramArrayList1 = ((Iterable)this.NpC).iterator();
    label621:
    label624:
    while (paramArrayList1.hasNext())
    {
      localObject1 = (b)paramArrayList1.next();
      if (!((b)localObject1).active)
      {
        if (paramArrayList2 != null)
        {
          localObject2 = (Iterable)paramArrayList2;
          if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
            break label621;
          }
          localObject2 = ((Iterable)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          } while (!p.h(((s)((Iterator)localObject2).next()).path, ((b)localObject1).NoY.path));
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label624;
          }
          if ((paramLong - ((b)localObject1).NoY.endTime <= 0L) || (!((b)localObject1).NoX)) {
            break;
          }
          ((b)localObject1).stop();
          Log.i("MicroMsg.VLogScriptReader", "stop player " + ((b)localObject1).NoY.path + ", pts:" + paramLong + ", endTime:" + ((b)localObject1).NoY.endTime);
          break;
        }
      }
    }
    AppMethodBeat.o(229554);
  }
  
  public final void kI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229542);
    this.targetWidth = paramInt1;
    this.targetHeight = paramInt2;
    Log.i("MicroMsg.VLogScriptReader", "set target size:[" + this.targetWidth + ", " + this.targetHeight + ']');
    this.jUF = new e(this.targetWidth, this.targetHeight, 0);
    e locale = this.jUF;
    if (locale != null) {
      locale.setSize(this.targetWidth, this.targetHeight);
    }
    this.NpD.guo();
    AppMethodBeat.o(229542);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader$Companion;", "", "()V", "TAG", "", "preloadThresholdLowerBound", "", "preloadThresholdUpperBound", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$doPreloadMaterials$1$1$1", "com/tencent/mm/plugin/vlog/player/VLogScriptReader$$special$$inlined$apply$lambda$1"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ak, d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    b(b paramb, d paramd, i parami, long paramLong, ArrayList paramArrayList)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(251567);
      p.k(paramd, "completion");
      paramd = new b(this.NpI, paramd, jdField_this, paramLong, this.NpL);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(251567);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(251569);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(251569);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(251565);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(251565);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Log.i("MicroMsg.VLogScriptReader", "doPreloadMaterials, play: " + this.NpI.NoY.path + ", texture:" + this.NpI.NkK + ", pts:" + paramLong + ", startTime:" + this.NpI.NoY.startTime);
      if (!this.NpI.aMy) {
        this.NpI.prepare();
      }
      this.NpI.Ss(0L);
      this.NpI.O(0L, false);
      paramObject = x.aazN;
      AppMethodBeat.o(251565);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.i
 * JD-Core Version:    0.7.0.1
 */