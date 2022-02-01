package com.tencent.mm.plugin.vlog.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.b.a;
import com.tencent.mm.af.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class a$b
  extends kotlin.d.b.a.j
  implements kotlin.g.a.m<ak, d<? super String>, Object>
{
  Object L$0;
  int label;
  Object oDA;
  private ak p$;
  Object pGq;
  Object pGr;
  boolean pdt;
  Object rdb;
  Object sPl;
  Object sPm;
  Object sPn;
  Object sPo;
  Object sPp;
  
  a$b(a parama, String paramString, FinderObject paramFinderObject, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(228151);
    p.k(paramd, "completion");
    paramd = new b(this.Nrn, this.pqJ, this.Nro, paramd);
    paramd.p$ = ((ak)paramObject);
    AppMethodBeat.o(228151);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(228153);
    paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
    AppMethodBeat.o(228153);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(228148);
    kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    label111:
    int i;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(228148);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      localObject4 = this.p$;
      localObject1 = this.pqJ;
      paramObject = this.Nro.objectDesc;
      if (paramObject != null)
      {
        paramObject = paramObject.feedBgmInfo;
        if (paramObject != null)
        {
          localObject2 = paramObject.groupId;
          paramObject = localObject2;
          if (localObject2 != null) {
            break label111;
          }
        }
      }
      paramObject = "";
      p.j(paramObject, "finderObj.objectDesc?.feedBgmInfo?.groupId ?: \"\"");
      if (((CharSequence)paramObject).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label1388;
        }
        paramObject = Util.getUnsignedLongString(this.Nro.id);
        p.j(paramObject, "Util.getUnsignedLongString(finderObj.id)");
      }
      break;
    }
    label827:
    label833:
    label992:
    label1379:
    label1388:
    for (;;)
    {
      Object localObject5;
      try
      {
        localObject2 = (com.tencent.mm.an.c)new com.tencent.mm.plugin.findersdk.b.a(paramObject, kotlin.d.b.a.b.Xu(this.Nro.id));
        this.L$0 = localObject4;
        this.oDA = localObject1;
        this.pGq = paramObject;
        this.label = 1;
        localObject3 = new n(kotlin.d.a.b.k(this), 1);
        ((n)localObject3).iQM();
        localObject5 = (kotlinx.coroutines.m)localObject3;
        localObject6 = new com.tencent.mm.vending.e.c();
        ((com.tencent.mm.an.c)localObject2).bhW().a((com.tencent.mm.vending.e.b)localObject6).g((com.tencent.mm.vending.c.a)new b.a((kotlinx.coroutines.m)localObject5));
        ((kotlinx.coroutines.m)localObject5).am((kotlin.g.a.b)new b.b((com.tencent.mm.vending.e.c)localObject6));
        localObject2 = ((n)localObject3).getResult();
        if (localObject2 == kotlin.d.a.a.aaAA) {
          p.k(this, "frame");
        }
        if (localObject2 != locala) {
          break label1379;
        }
        AppMethodBeat.o(228148);
        return locala;
      }
      catch (com.tencent.mm.af.a paramObject)
      {
        avy localavy;
        boolean bool;
        Log.e("MicroMsg.EditAddMusicPlugin", "GetFinderTopic fail:" + paramObject.getLocalizedMessage());
        AppMethodBeat.o(228148);
        return null;
      }
      i = 0;
      break;
      Object localObject3 = (String)this.pGq;
      localObject1 = (String)this.oDA;
      localObject4 = (ak)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localavy = (avy)paramObject;
      paramObject = localavy.SIo;
      aa.f localf;
      Object localObject8;
      Object localObject9;
      if (paramObject != null)
      {
        localObject5 = paramObject.SVG;
        if (localObject5 == null) {
          break label1330;
        }
        localObject2 = Util.getUnsignedLongString(this.Nro.id);
        paramObject = ((bkq)localObject5).groupId;
        if (paramObject != null) {
          break label1376;
        }
        paramObject = localObject2;
        localObject6 = ((bkq)localObject5).contact;
        if (localObject6 != null)
        {
          localObject6 = ((FinderContact)localObject6).username;
          bool = p.h(localObject6, z.bdh());
          localObject6 = new aa.f();
          ((aa.f)localObject6).aaBC = null;
          localf = new aa.f();
          localf.aaBC = null;
          localObject7 = this.Nro.objectDesc;
          if (localObject7 == null) {
            break label827;
          }
          localObject7 = ((FinderObjectDesc)localObject7).media;
          if (localObject7 == null) {
            break label827;
          }
          localObject7 = (FinderMedia)kotlin.a.j.lp((List)localObject7);
          if (localObject7 == null) {
            break label827;
          }
          localObject7 = Integer.valueOf(((FinderMedia)localObject7).mediaType);
          if (localObject7 != null) {
            break label833;
          }
          if (localObject7 != null) {
            break label992;
          }
          localObject7 = (CharSequence)((aa.f)localObject6).aaBC;
          if ((localObject7 != null) && (((CharSequence)localObject7).length() != 0)) {
            break label1014;
          }
          i = 1;
          if (i == 0) {
            break label1361;
          }
          localObject7 = new aa.f();
          localObject8 = new StringBuilder();
          localObject9 = h.aHG();
          p.j(localObject9, "MMKernel.storage()");
          ((aa.f)localObject7).aaBC = (((com.tencent.mm.kernel.f)localObject9).getAccPath() + "finder/tmp/" + (String)localObject3);
          Log.i("MicroMsg.EditAddMusicPlugin", "originBgmUrl is null, ready to extract audio from " + this.pqJ + " to " + (String)((aa.f)localObject7).aaBC);
          localObject8 = (kotlin.d.f)bc.iRs();
          localObject9 = (kotlin.g.a.m)new a(this, (aa.f)localObject7, null);
          this.L$0 = localObject4;
          this.oDA = localObject1;
          this.pGq = localObject3;
          this.pGr = localavy;
          this.rdb = localObject5;
          this.sPl = localObject2;
          this.sPm = paramObject;
          this.pdt = bool;
          this.sPn = localObject6;
          this.sPo = localf;
          this.sPp = localObject7;
          this.label = 2;
          localObject4 = i.a((kotlin.d.f)localObject8, (kotlin.g.a.m)localObject9, this);
          if (localObject4 != locala) {
            break label1346;
          }
          AppMethodBeat.o(228148);
          return locala;
        }
      }
      else
      {
        localObject5 = null;
        continue;
      }
      Object localObject6 = null;
      continue;
      Object localObject7 = null;
      continue;
      if (((Integer)localObject7).intValue() == 2)
      {
        localObject9 = ((bkq)localObject5).musicInfo;
        if (localObject9 != null)
        {
          ((aa.f)localObject6).aaBC = ((bfg)localObject9).SPV;
          localf.aaBC = new bfg();
          localObject7 = (bfg)localf.aaBC;
          if (localObject7 != null) {
            ((bfg)localObject7).BHW = paramObject;
          }
          bfg localbfg = (bfg)localf.aaBC;
          if (localbfg != null)
          {
            localObject8 = ((bfg)localObject9).SPV;
            localObject7 = localObject8;
            if (localObject8 == null) {
              localObject7 = "";
            }
            localbfg.SPV = ((String)localObject7);
          }
          localObject7 = (bfg)localf.aaBC;
          if (localObject7 != null) {
            ((bfg)localObject7).artist = ((bfg)localObject9).artist;
          }
          localObject7 = (bfg)localf.aaBC;
          if (localObject7 != null)
          {
            ((bfg)localObject7).name = ((bfg)localObject9).name;
            continue;
            if (((Integer)localObject7).intValue() == 4)
            {
              ((aa.f)localObject6).aaBC = ((bkq)localObject5).audioTrackUrl;
              continue;
              label1014:
              i = 0;
              continue;
              localObject5 = (aa.f)this.sPp;
              localObject1 = (aa.f)this.sPo;
              localObject3 = (aa.f)this.sPn;
              localObject6 = (String)this.sPm;
              localObject2 = (String)this.sPl;
              ResultKt.throwOnFailure(paramObject);
              localObject4 = paramObject;
              paramObject = localObject6;
              if (((Boolean)localObject4).booleanValue())
              {
                Log.i("MicroMsg.EditAddMusicPlugin", "extract audio success!");
                localObject4 = (String)((aa.f)localObject5).aaBC;
                localObject5 = localObject1;
              }
              for (;;)
              {
                localObject1 = CaptureDataManager.HKJ;
                p.j(localObject1, "CaptureDataManager.INSTANCE");
                ((CaptureDataManager)localObject1).getExtData().putString("ORIGIN_MUSIC_ID", paramObject);
                paramObject = CaptureDataManager.HKJ;
                p.j(paramObject, "CaptureDataManager.INSTANCE");
                paramObject.getExtData().putString("ORIGIN_MUSIC_PATH", (String)localObject4);
                paramObject = CaptureDataManager.HKJ;
                p.j(paramObject, "CaptureDataManager.INSTANCE");
                localObject1 = paramObject.getExtData();
                paramObject = (bfg)((aa.f)localObject5).aaBC;
                if (paramObject != null)
                {
                  paramObject = paramObject.toByteArray();
                  ((Bundle)localObject1).putByteArray("ORIGIN_MUSIC_INFO", paramObject);
                  paramObject = CaptureDataManager.HKJ;
                  p.j(paramObject, "CaptureDataManager.INSTANCE");
                  paramObject = paramObject.getExtData();
                  localObject1 = this.Nrn.AQf;
                  if (localObject1 == null) {
                    break label1325;
                  }
                }
                for (i = ((AudioCacheInfo)localObject1).source;; i = 0)
                {
                  paramObject.putInt("SOUND_TRACK_TYPE", i);
                  paramObject = CaptureDataManager.HKJ;
                  p.j(paramObject, "CaptureDataManager.INSTANCE");
                  paramObject.getExtData().putString("ORIGIN_BGM_URL", (String)((aa.f)localObject3).aaBC);
                  paramObject = CaptureDataManager.HKJ;
                  p.j(paramObject, "CaptureDataManager.INSTANCE");
                  paramObject.getExtData().putString("MUSIC_FEED_ID", (String)localObject2);
                  AppMethodBeat.o(228148);
                  return localObject4;
                  Log.e("MicroMsg.EditAddMusicPlugin", "extract audio fail!");
                  AppMethodBeat.o(228148);
                  return null;
                  paramObject = null;
                  break;
                }
                Log.e("MicroMsg.EditAddMusicPlugin", "bgmInfo is null");
                AppMethodBeat.o(228148);
                return null;
                localObject1 = localf;
                localObject3 = localObject6;
                localObject5 = localObject7;
                break;
                localObject5 = localf;
                localObject3 = localObject6;
                localObject4 = localObject1;
              }
              continue;
              localObject3 = paramObject;
              paramObject = localObject2;
            }
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, d<? super Boolean>, Object>
  {
    int label;
    private ak p$;
    
    a(a.b paramb, aa.f paramf, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(233514);
      p.k(paramd, "completion");
      paramd = new a(this.Nrp, this.Nrq, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(233514);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(233516);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(233516);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(233511);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(233511);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = com.tencent.mm.plugin.vlog.remux.a.Nqc;
      boolean bool = com.tencent.mm.plugin.vlog.remux.a.lH(this.Nrp.pqJ, (String)this.Nrq.aaBC);
      AppMethodBeat.o(233511);
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.a.b
 * JD-Core Version:    0.7.0.1
 */