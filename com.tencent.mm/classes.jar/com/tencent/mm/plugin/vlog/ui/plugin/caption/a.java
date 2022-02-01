package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import kotlinx.coroutines.ai;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "chanCfg", "extractFinish", "", "filePath", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "needRequest", "netScene", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "profile", "requesting", "getRequesting", "()Z", "setRequesting", "(Z)V", "sampleRate", "total", "transResult", "transRet", "voiceData", "Ljava/nio/ByteBuffer;", "doNetRequest", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "offset", "doNetVoiceTranslate", "getTransResult", "getTransStatus", "loadAudioTrackData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveBuffer2File", "setupExtractor", "voiceTransLate", "Companion", "plugin-vlog_release"})
public final class a
  implements i
{
  private static long GJV;
  public static final a.a GJW;
  String filePath;
  r<? super Integer, ? super String, ? super Integer, ? super ArrayList<sy>, x> hFV;
  volatile boolean ife;
  c igg;
  private int jcu;
  private int profile;
  private int sampleRate;
  boolean tUq;
  private boolean wJA;
  boolean wJB;
  int wJC;
  private int wJD;
  private e wJx;
  ArrayList<sy> wJy;
  private ByteBuffer wJz;
  
  static
  {
    AppMethodBeat.i(191605);
    GJW = new a.a((byte)0);
    AppMethodBeat.o(191605);
  }
  
  public a()
  {
    AppMethodBeat.i(191604);
    this.wJy = new ArrayList();
    this.filePath = "";
    this.wJB = true;
    this.profile = 2;
    this.sampleRate = 44100;
    this.wJD = 1;
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().a(3835, (i)this);
    AppMethodBeat.o(191604);
  }
  
  private final void a(int paramInt1, com.tencent.mm.bw.b paramb, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(191602);
    int i = this.jcu;
    Object localObject1 = this.wJx;
    e locale;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).GLl;
      locale = new e(paramInt1, paramb, paramInt2, paramInt3, i, (com.tencent.mm.bw.b)localObject1);
      localStringBuilder = new StringBuilder("[").append(hashCode()).append("]do voiceTransLate vid:");
      localObject1 = locale.GLl;
      if (localObject1 == null) {
        break label212;
      }
    }
    label212:
    for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toString("UTF-8");; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" seq:").append(paramInt2).append(" size:");
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = Integer.valueOf(paramb.zy.length);
      }
      Log.i("MicroMsg.EditCaptionDataManager", localObject1 + " offset:" + paramInt3);
      locale.setFilePath(this.filePath);
      this.wJx = locale;
      paramb = g.aAg();
      p.g(paramb, "MMKernel.network()");
      paramb.azz().b((q)this.wJx);
      AppMethodBeat.o(191602);
      return;
      localObject1 = null;
      break;
    }
  }
  
  final int axp(String paramString)
  {
    AppMethodBeat.i(191601);
    for (;;)
    {
      try
      {
        if (this.igg == null)
        {
          this.igg = new c();
          localObject1 = this.igg;
          if (localObject1 != null) {
            ((c)localObject1).setDataSource(paramString);
          }
          localObject1 = this.igg;
          if (localObject1 != null)
          {
            i = ((c)localObject1).getTrackCount();
            break label682;
            if (j >= i) {
              break label676;
            }
            localObject1 = this.igg;
            if (localObject1 == null) {
              break label309;
            }
            localObject1 = ((c)localObject1).getTrackFormat(j);
            if (localObject1 == null) {
              break label315;
            }
            localObject2 = ((MediaFormat)localObject1).getString("mime");
            Log.i("MicroMsg.EditCaptionDataManager", "track mime:".concat(String.valueOf(localObject2)));
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (localObject2 == null) || (n.J((String)localObject2, "audio/", false) != true)) {
              break label324;
            }
            localObject2 = this.igg;
            if (localObject2 == null) {
              break label321;
            }
            ((c)localObject2).selectTrack(j);
            if (localObject1 != null) {
              break label333;
            }
            Log.e("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "no audio track]");
            paramString = this.igg;
            if (paramString != null) {
              paramString.release();
            }
            this.igg = null;
            this.wJC = -2;
            AppMethodBeat.o(191601);
            return -2;
          }
        }
        else
        {
          Log.i("MicroMsg.EditCaptionDataManager", "already create extractor success");
          AppMethodBeat.o(191601);
          return 0;
        }
      }
      catch (Exception paramString)
      {
        localObject1 = this.igg;
        if (localObject1 != null) {
          ((c)localObject1).release();
        }
        this.igg = null;
        Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", (Throwable)paramString, "", new Object[0]);
        this.wJC = -3;
        AppMethodBeat.o(191601);
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
      paramString = MultiMediaVideoChecker.GyY.aTV(paramString);
      Log.i("MicroMsg.EditCaptionDataManager", "audio format:" + localObject1 + ", videoInfo:" + paramString);
      long l;
      label422:
      label432:
      float f1;
      float f2;
      if (paramString != null)
      {
        l = paramString.duration;
        p.h(localObject1, "$this$getLong");
        p.h("durationUs", "name");
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
        this.wJD = u.c((MediaFormat)localObject1, "channel-count", this.wJD);
        f1 = 2.0F * (i * ((float)l / 1000.0F / 1000.0F) / 8.0F);
        f2 = (float)l / 1000.0F / 20.0F * 7.0F;
        this.wJz = ByteBuffer.allocateDirect((int)(f1 + f2));
        localObject1 = new StringBuilder("[").append(hashCode()).append("]allocate buffer size:");
        paramString = this.wJz;
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
        AppMethodBeat.o(191601);
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
    AppMethodBeat.i(191603);
    if (paramq == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.NetSceneGetVideoCaption");
      AppMethodBeat.o(191603);
      throw paramString;
    }
    if ((p.j(((e)paramq).filePath, this.filePath)) && (!this.ife))
    {
      Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      int i = ((e)paramq).GKp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.wJy = ((e)paramq).GLj;
        Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]scene seq:" + ((e)paramq).jlm + " isLastRequest:" + ((e)paramq).GLk + " progress:" + ((e)paramq).getProgress());
        paramString = (Iterable)this.wJy;
        paramInt1 = 0;
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          Object localObject = paramString.next();
          if (paramInt1 < 0) {
            kotlin.a.j.hxH();
          }
          localObject = (sy)localObject;
          Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + paramInt1 + ": start:" + ((sy)localObject).LaT + " end:" + ((sy)localObject).LaU + " text:" + ((sy)localObject).LaS.toString("UTF-8"));
          if ((((e)paramq).GLk) && (((e)paramq).getProgress() >= 100))
          {
            long l = GJV + 1L;
            GJV = l;
            ((sy)localObject).id = l;
          }
          paramInt1 += 1;
        }
        Log.i("MicroMsg.EditCaptionDataManager", "\n");
        if (((e)paramq).GLk)
        {
          if (((e)paramq).getProgress() >= 100)
          {
            this.tUq = false;
            paramString = this.hFV;
            if (paramString != null)
            {
              paramq = this.filePath;
              if (!((Collection)this.wJy).isEmpty())
              {
                paramInt1 = 1;
                if (paramInt1 == 0) {
                  break label502;
                }
              }
              label502:
              for (paramInt1 = 0;; paramInt1 = -2)
              {
                paramString.invoke(Integer.valueOf(i), paramq, Integer.valueOf(paramInt1), this.wJy);
                AppMethodBeat.o(191603);
                return;
                paramInt1 = 0;
                break;
              }
            }
            AppMethodBeat.o(191603);
            return;
          }
          paramString = this.hFV;
          if (paramString != null) {
            paramString.invoke(Integer.valueOf(i), this.filePath, Integer.valueOf(0), this.wJy);
          }
          Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]repeat query voice data");
          paramString = this.wJx;
          if (paramString == null) {
            p.hyc();
          }
          a(i, null, paramString.jlm, 0);
          AppMethodBeat.o(191603);
        }
      }
      else if (((e)paramq).GLk)
      {
        this.wJC = -1;
        this.tUq = false;
        paramString = this.hFV;
        if (paramString != null) {
          paramString.invoke(Integer.valueOf(i), this.filePath, Integer.valueOf(-1), null);
        }
        this.wJB = true;
      }
    }
    AppMethodBeat.o(191603);
  }
  
  @f(c="com.tencent.mm.plugin.vlog.ui.plugin.caption.EditCaptionDataManager$voiceTransLate$1", f="EditCaptionDataManager.kt", hxM={}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ai, d<? super x>, Object>
  {
    int label;
    private ai p$;
    
    b(a parama, int paramInt, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(191599);
      p.h(paramd, "completion");
      paramd = new b(this.GJX, this.$type, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(191599);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(191600);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(191600);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(191598);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191598);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      a.a(this.GJX);
      a.a(this.GJX, this.$type);
      paramObject = x.SXb;
      AppMethodBeat.o(191598);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.a
 * JD-Core Version:    0.7.0.1
 */