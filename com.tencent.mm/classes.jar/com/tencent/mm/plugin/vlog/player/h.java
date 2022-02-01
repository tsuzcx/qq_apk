package com.tencent.mm.plugin.vlog.player;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.plugin.vlog.model.ak;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "", "previewPlay", "", "(Z)V", "imagePtsStep", "", "mute", "nextPtsStep", "playerList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "Lkotlin/collections/ArrayList;", "getPreviewPlay", "()Z", "setPreviewPlay", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "targetHeight", "", "targetWidth", "texCache", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptTexCache;", "videoPtsStep", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "cacheMaterialPlayer", "material", "Lcom/tencent/mm/plugin/vlog/model/Material;", "cacheMaterialPlayerByIndex", "index", "checkPreloadNextMaterials", "pts", "currentMaterial", "clearScreen", "", "doPreloadMaterials", "nextMaterialIndices", "drawImpl", "currentMaterials", "nextMaterialList", "outputTexture", "drawScript", "ptsMs", "outputTexId", "getPtsMaterials", "getPtsStep", "initXEffectInGlesThread", "width", "height", "needPreloadMaterials", "onPlayEnd", "loop", "pause", "prepareMaterial", "prepare", "release", "resetAllPlayers", "resume", "setMediaFps", "videoFps", "imageFps", "setMute", "setScript", "widthScale", "", "heightScale", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final a Udu;
  boolean UcU;
  long UdA;
  com.tencent.mm.plugin.vlog.model.ah Udv;
  ArrayList<b> Udw;
  i Udx;
  long Udy;
  long Udz;
  com.tencent.mm.plugin.xlabeffect.k muW;
  boolean nLP;
  int nxO;
  int nxP;
  
  static
  {
    AppMethodBeat.i(281205);
    Udu = new a((byte)0);
    AppMethodBeat.o(281205);
  }
  
  public h(boolean paramBoolean)
  {
    AppMethodBeat.i(281197);
    this.UcU = paramBoolean;
    this.nLP = true;
    this.Udw = new ArrayList();
    this.Udx = new i();
    this.Udy = 33L;
    this.Udz = 16L;
    this.UdA = this.Udy;
    AppMethodBeat.o(281197);
  }
  
  final void FQ(boolean paramBoolean)
  {
    AppMethodBeat.i(281226);
    Log.i("MicroMsg.VLogScriptReader", kotlin.g.b.s.X("resetAllPlayers size:", Integer.valueOf(this.Udw.size())));
    Iterator localIterator = ((Iterable)this.Udw).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.stop();
      if (paramBoolean) {
        localb.release();
      }
    }
    AppMethodBeat.o(281226);
  }
  
  final ArrayList<Integer> a(long paramLong, ArrayList<com.tencent.mm.plugin.vlog.model.s> paramArrayList)
  {
    AppMethodBeat.i(281214);
    Object localObject1 = this.Udv;
    int j;
    int n;
    int i;
    int m;
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.vlog.model.ah)localObject1).UaY;
      if (localObject1 != null)
      {
        j = 0;
        n = ((List)localObject1).size();
        if (n > 0)
        {
          i = 0;
          j = 0;
          m = i + 1;
          Object localObject2 = (Iterable)paramArrayList;
          if (((Collection)localObject2).isEmpty()) {
            break label282;
          }
          localObject2 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label282;
          }
          com.tencent.mm.plugin.vlog.model.s locals = (com.tencent.mm.plugin.vlog.model.s)((Iterator)localObject2).next();
          if ((!kotlin.g.b.s.p(locals.path, ((com.tencent.mm.plugin.vlog.model.s)((List)localObject1).get(i)).path)) || (locals.startTime < ((com.tencent.mm.plugin.vlog.model.s)((List)localObject1).get(i)).startTime)) {
            break label276;
          }
          k = 1;
          label160:
          if (k == 0) {
            break label280;
          }
          k = 1;
          label168:
          if ((k == 0) || (i < j)) {
            break label326;
          }
        }
      }
    }
    for (;;)
    {
      if (m >= n)
      {
        j = i;
        if (j + 1 < ((List)localObject1).size())
        {
          paramLong = ((com.tencent.mm.plugin.vlog.model.s)((List)localObject1).get(j + 1)).startTime - paramLong;
          if (400L <= paramLong) {
            if (paramLong <= 600L) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label300;
            }
            paramArrayList = new ArrayList();
            paramArrayList.add(Integer.valueOf(j + 1));
            AppMethodBeat.o(281214);
            return paramArrayList;
            label276:
            k = 0;
            break label160;
            label280:
            break;
            label282:
            k = 0;
            break label168;
            i = 0;
            continue;
            i = 0;
          }
        }
        label300:
        AppMethodBeat.o(281214);
        return null;
      }
      j = m;
      k = i;
      i = j;
      j = k;
      break;
      label326:
      i = j;
    }
  }
  
  final ArrayList<com.tencent.mm.plugin.vlog.model.s> a(ArrayList<Integer> paramArrayList, final long paramLong)
  {
    AppMethodBeat.i(281218);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    label133:
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      if (i < this.Udw.size()) {}
      for (paramArrayList = (b)this.Udw.get(i);; paramArrayList = null)
      {
        if ((paramArrayList == null) || (paramArrayList.UcS)) {
          break label133;
        }
        j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new b(paramArrayList, paramLong, null), 2);
        localArrayList.add(paramArrayList.UcR);
        break;
      }
    }
    AppMethodBeat.o(281218);
    return localArrayList;
  }
  
  final void a(ArrayList<com.tencent.mm.plugin.vlog.model.s> paramArrayList1, ArrayList<com.tencent.mm.plugin.vlog.model.s> paramArrayList2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(281223);
    GLES20.glViewport(0, 0, this.nxO, this.nxP);
    Object localObject1 = c.nFs;
    c.a.bqi();
    localObject1 = ((Iterable)this.Udw).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).active = false;
    }
    localObject1 = ((Iterable)paramArrayList1).iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.vlog.model.s)((Iterator)localObject1).next();
      Iterator localIterator = ((Iterable)this.Udw).iterator();
      label115:
      int i;
      if (localIterator.hasNext())
      {
        paramArrayList1 = localIterator.next();
        b localb = (b)paramArrayList1;
        if ((kotlin.g.b.s.p(localb.UcR.path, ((com.tencent.mm.plugin.vlog.model.s)localObject2).path)) && (localb.UcR.startTime >= ((com.tencent.mm.plugin.vlog.model.s)localObject2).startTime))
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
            if (!paramArrayList1.cGv)
            {
              Log.i("MicroMsg.VLogScriptReader", "drawImpl prepare material player: " + paramLong + ", " + ((com.tencent.mm.plugin.vlog.model.s)localObject2).startTime + ", " + ((com.tencent.mm.plugin.vlog.model.s)localObject2).path);
              paramArrayList1.prepare();
            }
            if (!paramArrayList1.UcS)
            {
              Log.i("MicroMsg.VLogScriptReader", "drawImpl play material player: " + paramLong + ", " + ((com.tencent.mm.plugin.vlog.model.s)localObject2).startTime + ", " + ((com.tencent.mm.plugin.vlog.model.s)localObject2).path);
              paramArrayList1.wG(paramLong - paramArrayList1.UcR.startTime);
            }
            paramArrayList1.active = true;
            paramArrayList1.Z(paramLong - paramArrayList1.UcR.startTime, true);
          }
          if (!(localObject2 instanceof ak)) {
            break label380;
          }
        }
      }
      label373:
      label380:
      for (long l = this.Udy;; l = this.Udz)
      {
        this.UdA = l;
        break;
        i = 0;
        break label178;
        break label115;
        paramArrayList1 = null;
        break label183;
      }
    }
    paramArrayList1 = this.muW;
    if (paramArrayList1 != null) {
      com.tencent.mm.plugin.xlabeffect.k.a(paramArrayList1, 0, paramInt, false, 56);
    }
    paramArrayList1 = ((Iterable)this.Udw).iterator();
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
          } while (!kotlin.g.b.s.p(((com.tencent.mm.plugin.vlog.model.s)((Iterator)localObject2).next()).path, ((b)localObject1).UcR.path));
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label624;
          }
          if ((paramLong - ((b)localObject1).UcR.endTime <= 0L) || (!((b)localObject1).UcS)) {
            break;
          }
          ((b)localObject1).stop();
          Log.i("MicroMsg.VLogScriptReader", "stop player " + ((b)localObject1).UcR.path + ", pts:" + paramLong + ", endTime:" + ((b)localObject1).UcR.endTime);
          break;
        }
      }
    }
    AppMethodBeat.o(281223);
  }
  
  public final void my(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(281208);
    this.nxO = paramInt1;
    this.nxP = paramInt2;
    Log.i("MicroMsg.VLogScriptReader", "set target size:[" + this.nxO + ", " + this.nxP + ']');
    this.muW = new com.tencent.mm.plugin.xlabeffect.k(this.nxO, this.nxP, 0);
    com.tencent.mm.plugin.xlabeffect.k localk = this.muW;
    if (localk != null) {
      localk.setSize(this.nxO, this.nxP);
    }
    this.Udx.hSd();
    AppMethodBeat.o(281208);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader$Companion;", "", "()V", "TAG", "", "preloadThresholdLowerBound", "", "preloadThresholdUpperBound", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, d<? super kotlin.ah>, Object>
  {
    int label;
    
    b(b paramb, long paramLong, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(281240);
      paramObject = (d)new b(this.UdB, paramLong, paramd);
      AppMethodBeat.o(281240);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281236);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281236);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Log.i("MicroMsg.VLogScriptReader", "doPreloadMaterials, play: " + this.UdB.UcR.path + ", texture:" + this.UdB.TXY + ", pts:" + paramLong + ", startTime:" + this.UdB.UcR.startTime);
      if (!this.UdB.cGv) {
        this.UdB.prepare();
      }
      this.UdB.wG(0L);
      this.UdB.Z(0L, false);
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(281236);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.h
 * JD-Core Version:    0.7.0.1
 */