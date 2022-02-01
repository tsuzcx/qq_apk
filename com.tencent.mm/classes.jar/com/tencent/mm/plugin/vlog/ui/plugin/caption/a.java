package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "chanCfg", "extractFinish", "", "filePath", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "needRequest", "netScene", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "profile", "requesting", "getRequesting", "()Z", "setRequesting", "(Z)V", "sampleRate", "total", "transResult", "transRet", "voiceData", "Ljava/nio/ByteBuffer;", "doNetRequest", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "offset", "doNetVoiceTranslate", "getTransResult", "getTransStatus", "loadAudioTrackData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveBuffer2File", "setupExtractor", "voiceTransLate", "Companion", "plugin-vlog_release"})
public final class a
  implements i
{
  private static long Nxw;
  public static final a Nxx;
  private e Nxp;
  ArrayList<ta> Nxq;
  private ByteBuffer Nxr;
  private boolean Nxs;
  boolean Nxt;
  int Nxu;
  private int Nxv;
  String filePath;
  volatile boolean kTS;
  com.tencent.mm.compatible.i.c kUU;
  r<? super Integer, ? super String, ? super Integer, ? super ArrayList<ta>, x> ktT;
  private int profile;
  private int sampleRate;
  private int total;
  boolean xFl;
  
  static
  {
    AppMethodBeat.i(228865);
    Nxx = new a((byte)0);
    AppMethodBeat.o(228865);
  }
  
  public a()
  {
    AppMethodBeat.i(228864);
    this.Nxq = new ArrayList();
    this.filePath = "";
    this.Nxt = true;
    this.profile = 2;
    this.sampleRate = 44100;
    this.Nxv = 1;
    com.tencent.mm.kernel.c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().a(3835, (i)this);
    AppMethodBeat.o(228864);
  }
  
  private final void a(int paramInt1, b paramb, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(228847);
    int i = this.total;
    Object localObject1 = this.Nxp;
    e locale;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).NyL;
      locale = new e(paramInt1, paramb, paramInt2, paramInt3, i, (b)localObject1);
      localStringBuilder = new StringBuilder("[").append(hashCode()).append("]do voiceTransLate vid:");
      localObject1 = locale.NyL;
      if (localObject1 == null) {
        break label220;
      }
    }
    label220:
    for (localObject1 = ((b)localObject1).toString("UTF-8");; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" seq:").append(paramInt2).append(" size:");
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = Integer.valueOf(paramb.UH.length);
      }
      Log.i("MicroMsg.EditCaptionDataManager", localObject1 + " offset:" + paramInt3);
      paramb = this.filePath;
      p.k(paramb, "<set-?>");
      locale.filePath = paramb;
      this.Nxp = locale;
      paramb = h.aHF();
      p.j(paramb, "MMKernel.network()");
      paramb.aGY().b((q)this.Nxp);
      AppMethodBeat.o(228847);
      return;
      localObject1 = null;
      break;
    }
  }
  
  final int bfM(String paramString)
  {
    AppMethodBeat.i(228845);
    for (;;)
    {
      try
      {
        if (this.kUU == null)
        {
          this.kUU = new com.tencent.mm.compatible.i.c();
          localObject1 = this.kUU;
          if (localObject1 != null) {
            ((com.tencent.mm.compatible.i.c)localObject1).setDataSource(paramString);
          }
          localObject1 = this.kUU;
          if (localObject1 != null)
          {
            i = ((com.tencent.mm.compatible.i.c)localObject1).getTrackCount();
            break label682;
            if (j >= i) {
              break label676;
            }
            localObject1 = this.kUU;
            if (localObject1 == null) {
              break label309;
            }
            localObject1 = ((com.tencent.mm.compatible.i.c)localObject1).getTrackFormat(j);
            if (localObject1 == null) {
              break label315;
            }
            localObject2 = ((MediaFormat)localObject1).getString("mime");
            Log.i("MicroMsg.EditCaptionDataManager", "track mime:".concat(String.valueOf(localObject2)));
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (localObject2 == null) || (n.M((String)localObject2, "audio/", false) != true)) {
              break label324;
            }
            localObject2 = this.kUU;
            if (localObject2 == null) {
              break label321;
            }
            ((com.tencent.mm.compatible.i.c)localObject2).selectTrack(j);
            if (localObject1 != null) {
              break label333;
            }
            Log.e("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "no audio track]");
            paramString = this.kUU;
            if (paramString != null) {
              paramString.release();
            }
            this.kUU = null;
            this.Nxu = -2;
            AppMethodBeat.o(228845);
            return -2;
          }
        }
        else
        {
          Log.i("MicroMsg.EditCaptionDataManager", "already create extractor success");
          AppMethodBeat.o(228845);
          return 0;
        }
      }
      catch (Exception paramString)
      {
        localObject1 = this.kUU;
        if (localObject1 != null) {
          ((com.tencent.mm.compatible.i.c)localObject1).release();
        }
        this.kUU = null;
        Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", (Throwable)paramString, "", new Object[0]);
        this.Nxu = -3;
        AppMethodBeat.o(228845);
        return -3;
      }
      int i = 0;
      break label682;
      label309:
      Object localObject1 = null;
      continue;
      label315:
      Object localObject2 = null;
      continue;
      label321:
      continue;
      label324:
      j += 1;
      continue;
      label333:
      paramString = MultiMediaVideoChecker.NmA.bfs(paramString);
      Log.i("MicroMsg.EditCaptionDataManager", "audio format:" + localObject1 + ", videoInfo:" + paramString);
      long l;
      label422:
      label432:
      float f1;
      float f2;
      if (paramString != null)
      {
        l = paramString.duration;
        p.k(localObject1, "$this$getLong");
        p.k("durationUs", "name");
        if (!((MediaFormat)localObject1).containsKey("durationUs")) {
          break label652;
        }
        l = ((MediaFormat)localObject1).getLong("durationUs");
        if (paramString == null) {
          break label663;
        }
        i = paramString.audioBitrate;
        i = u.c((MediaFormat)localObject1, "bitrate", i);
        this.profile = u.c((MediaFormat)localObject1, "profile", this.profile);
        this.sampleRate = u.c((MediaFormat)localObject1, "sample-rate", this.sampleRate);
        this.Nxv = u.c((MediaFormat)localObject1, "channel-count", this.Nxv);
        f1 = 2.0F * (i * ((float)l / 1000.0F / 1000.0F) / 8.0F);
        f2 = (float)l / 1000.0F / 20.0F * 7.0F;
        this.Nxr = ByteBuffer.allocateDirect((int)(f1 + f2));
        localObject1 = new StringBuilder("[").append(hashCode()).append("]allocate buffer size:");
        paramString = this.Nxr;
        if (paramString == null) {
          break label671;
        }
      }
      label652:
      label663:
      label671:
      for (paramString = Integer.valueOf(paramString.capacity());; paramString = null)
      {
        Log.i("MicroMsg.EditCaptionDataManager", paramString + ", voiceSize:" + f1 + ", adtsSize:" + f2 + ", duration:" + l + ", bitrate:" + i);
        AppMethodBeat.o(228845);
        return 0;
        l = 0L;
        break;
        l *= 1000L;
        break label422;
        i = 128000;
        break label432;
      }
      label676:
      localObject1 = null;
      continue;
      label682:
      int j = 0;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(228863);
    if (paramq == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.NetSceneGetVideoCaption");
      AppMethodBeat.o(228863);
      throw paramString;
    }
    if ((p.h(((e)paramq).filePath, this.filePath)) && (!this.kTS))
    {
      Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      int i = ((e)paramq).NxP;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Nxq = ((e)paramq).NyJ;
        Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]scene seq:" + ((e)paramq).mbp + " isLastRequest:" + ((e)paramq).NyK + " progress:" + ((e)paramq).getProgress());
        paramString = (Iterable)this.Nxq;
        paramInt1 = 0;
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          Object localObject = paramString.next();
          if (paramInt1 < 0) {
            kotlin.a.j.iBO();
          }
          localObject = (ta)localObject;
          Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + paramInt1 + ": start:" + ((ta)localObject).Scf + " end:" + ((ta)localObject).Scg + " text:" + ((ta)localObject).Sce.toString("UTF-8"));
          if ((((e)paramq).NyK) && (((e)paramq).getProgress() >= 100))
          {
            long l = Nxw + 1L;
            Nxw = l;
            ((ta)localObject).id = l;
          }
          paramInt1 += 1;
        }
        Log.i("MicroMsg.EditCaptionDataManager", "\n");
        if (((e)paramq).NyK)
        {
          if (((e)paramq).getProgress() >= 100)
          {
            this.xFl = false;
            paramString = this.ktT;
            if (paramString != null)
            {
              paramq = this.filePath;
              if (!((Collection)this.Nxq).isEmpty())
              {
                paramInt1 = 1;
                if (paramInt1 == 0) {
                  break label502;
                }
              }
              label502:
              for (paramInt1 = 0;; paramInt1 = -2)
              {
                paramString.a(Integer.valueOf(i), paramq, Integer.valueOf(paramInt1), this.Nxq);
                AppMethodBeat.o(228863);
                return;
                paramInt1 = 0;
                break;
              }
            }
            AppMethodBeat.o(228863);
            return;
          }
          paramString = this.ktT;
          if (paramString != null) {
            paramString.a(Integer.valueOf(i), this.filePath, Integer.valueOf(0), this.Nxq);
          }
          Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]repeat query voice data");
          paramString = this.Nxp;
          if (paramString == null) {
            p.iCn();
          }
          a(i, null, paramString.mbp, 0);
          AppMethodBeat.o(228863);
        }
      }
      else if (((e)paramq).NyK)
      {
        this.Nxu = -1;
        this.xFl = false;
        paramString = this.ktT;
        if (paramString != null) {
          paramString.a(Integer.valueOf(i), this.filePath, Integer.valueOf(-1), null);
        }
        this.Nxt = true;
      }
    }
    AppMethodBeat.o(228863);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager$Companion;", "", "()V", "BASE_CAPTION_ID", "", "CAPTION_EXTRACTOR_ERROR", "", "CAPTION_NO_AUDIO", "CAPTION_RESULT_ERROR", "CAPTION_RESULT_LOAD_MORE", "CAPTION_RESULT_OK", "DefaultAudioBitrate", "REQUEST_VOICE_SIZE", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ak, d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    b(a parama, int paramInt, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(231525);
      p.k(paramd, "completion");
      paramd = new b(this.Nxy, this.cPi, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(231525);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(231526);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(231526);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(231524);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(231524);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      a.a(this.Nxy);
      a.a(this.Nxy, this.cPi);
      paramObject = x.aazN;
      AppMethodBeat.o(231524);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.a
 * JD-Core Version:    0.7.0.1
 */