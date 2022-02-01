package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "chanCfg", "extractFinish", "", "filePath", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "needRequest", "netScene", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "profile", "requesting", "getRequesting", "()Z", "setRequesting", "(Z)V", "sampleRate", "total", "transResult", "transRet", "voiceData", "Ljava/nio/ByteBuffer;", "doNetRequest", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "offset", "doNetVoiceTranslate", "getTransResult", "getTransStatus", "loadAudioTrackData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveBuffer2File", "setupExtractor", "voiceTransLate", "Companion", "plugin-vlog_release"})
public final class a
  implements f
{
  public static final a.a Chj;
  private e Chb;
  ArrayList<rv> Chc;
  private ByteBuffer Chd;
  private boolean Che;
  boolean Chf;
  boolean Chg;
  int Chh;
  private int Chi;
  String filePath;
  r<? super Integer, ? super String, ? super Integer, ? super ArrayList<rv>, z> gPm;
  c hmL;
  volatile boolean hmi;
  private int ihz;
  private int profile;
  private int sampleRate;
  
  static
  {
    AppMethodBeat.i(191918);
    Chj = new a.a((byte)0);
    AppMethodBeat.o(191918);
  }
  
  public a()
  {
    AppMethodBeat.i(191917);
    this.Chc = new ArrayList();
    this.filePath = "";
    this.Chf = true;
    this.profile = 2;
    this.sampleRate = 44100;
    this.Chi = 1;
    com.tencent.mm.kernel.b localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().a(3835, (f)this);
    AppMethodBeat.o(191917);
  }
  
  private final void a(int paramInt1, com.tencent.mm.bw.b paramb, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(191915);
    int i = this.ihz;
    Object localObject1 = this.Chb;
    e locale;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).CiA;
      locale = new e(paramInt1, paramb, paramInt2, paramInt3, i, (com.tencent.mm.bw.b)localObject1);
      localStringBuilder = new StringBuilder("[").append(hashCode()).append("]do voiceTransLate vid:");
      localObject1 = locale.CiA;
      if (localObject1 == null) {
        break label219;
      }
    }
    label219:
    for (localObject1 = ((com.tencent.mm.bw.b)localObject1).toString("UTF-8");; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" seq:").append(paramInt2).append(" size:");
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = Integer.valueOf(paramb.size());
      }
      ae.i("MicroMsg.EditCaptionDataManager", localObject1 + " offset:" + paramInt3);
      paramb = this.filePath;
      p.h(paramb, "<set-?>");
      locale.filePath = paramb;
      this.Chb = locale;
      paramb = g.ajQ();
      p.g(paramb, "MMKernel.network()");
      paramb.ajj().b((com.tencent.mm.ak.n)this.Chb);
      AppMethodBeat.o(191915);
      return;
      localObject1 = null;
      break;
    }
  }
  
  final int aEP(String paramString)
  {
    AppMethodBeat.i(191914);
    for (;;)
    {
      try
      {
        if (this.hmL == null)
        {
          this.hmL = new c();
          localObject = this.hmL;
          if (localObject != null) {
            ((c)localObject).setDataSource(paramString);
          }
          paramString = this.hmL;
          if (paramString != null)
          {
            i = paramString.getTrackCount();
            break label532;
            if (j >= i) {
              break label527;
            }
            paramString = this.hmL;
            if (paramString == null) {
              break label282;
            }
            paramString = paramString.getTrackFormat(j);
            if (paramString == null) {
              break label287;
            }
            localObject = paramString.getString("mime");
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (localObject == null) || (d.n.n.nF((String)localObject, "audio/") != true)) {
              break label296;
            }
            localObject = this.hmL;
            if (localObject == null) {
              break label293;
            }
            ((c)localObject).selectTrack(j);
            if (paramString != null) {
              break label305;
            }
            ae.e("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "no audio track]");
            paramString = this.hmL;
            if (paramString != null) {
              paramString.release();
            }
            this.hmL = null;
            this.Chh = -2;
            AppMethodBeat.o(191914);
            return -2;
          }
        }
        else
        {
          ae.i("MicroMsg.EditCaptionDataManager", "already create extractor success");
          AppMethodBeat.o(191914);
          return 0;
        }
      }
      catch (Exception paramString)
      {
        localObject = this.hmL;
        if (localObject != null) {
          ((c)localObject).release();
        }
        this.hmL = null;
        ae.printErrStackTrace("MicroMsg.EditCaptionDataManager", (Throwable)paramString, "", new Object[0]);
        this.Chh = -3;
        AppMethodBeat.o(191914);
        return -3;
      }
      int i = 0;
      break label532;
      label282:
      paramString = null;
      continue;
      label287:
      Object localObject = null;
      continue;
      label293:
      continue;
      label296:
      j += 1;
      continue;
      label305:
      long l = paramString.getLong("durationUs");
      i = paramString.getInteger("bitrate");
      this.profile = com.tencent.mm.plugin.vlog.model.n.c(paramString, "profile", this.profile);
      this.sampleRate = com.tencent.mm.plugin.vlog.model.n.c(paramString, "sample-rate", this.sampleRate);
      this.Chi = com.tencent.mm.plugin.vlog.model.n.c(paramString, "channel-count", this.Chi);
      float f1 = 2.0F * (i * ((float)l / 1000.0F / 1000.0F) / 8.0F);
      float f2 = (float)l / 1000.0F / 20.0F * 7.0F;
      this.Chd = ByteBuffer.allocateDirect((int)(f1 + f2));
      localObject = new StringBuilder("[").append(hashCode()).append("]allocate buffer size:");
      paramString = this.Chd;
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.capacity());; paramString = null)
      {
        ae.i("MicroMsg.EditCaptionDataManager", paramString + ", voiceSize:" + f1 + ", adtsSize:" + f2 + ", duration:" + l + ", bitrate:" + i);
        AppMethodBeat.o(191914);
        return 0;
      }
      label527:
      paramString = null;
      continue;
      label532:
      int j = 0;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(191916);
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.NetSceneGetVideoCaption");
      AppMethodBeat.o(191916);
      throw paramString;
    }
    if ((p.i(((e)paramn).filePath, this.filePath)) && (!this.hmi))
    {
      ae.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      int i = ((e)paramn).ChD;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Chc = ((e)paramn).Ciy;
        ae.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]scene seq:" + ((e)paramn).iqb + " isLastRequest:" + ((e)paramn).Ciz + " progress:" + ((e)paramn).getProgress());
        paramString = (Iterable)this.Chc;
        paramInt1 = 0;
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          Object localObject = paramString.next();
          if (paramInt1 < 0) {
            j.gkd();
          }
          localObject = (rv)localObject;
          ae.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + paramInt1 + ": start:" + ((rv)localObject).Ggq + " end:" + ((rv)localObject).Ggr + " text:" + ((rv)localObject).Ggp.toString("UTF-8"));
          paramInt1 += 1;
        }
        ae.i("MicroMsg.EditCaptionDataManager", "\n");
        if (((e)paramn).Ciz)
        {
          if (((e)paramn).getProgress() >= 100)
          {
            this.Chg = false;
            paramString = this.gPm;
            if (paramString != null)
            {
              paramString.a(Integer.valueOf(i), this.filePath, Integer.valueOf(0), this.Chc);
              AppMethodBeat.o(191916);
              return;
            }
            AppMethodBeat.o(191916);
            return;
          }
          paramString = this.gPm;
          if (paramString != null) {
            paramString.a(Integer.valueOf(i), this.filePath, Integer.valueOf(0), this.Chc);
          }
          ae.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]repeat query voice data");
          paramString = this.Chb;
          if (paramString == null) {
            p.gkB();
          }
          a(i, null, paramString.iqb, 0);
          AppMethodBeat.o(191916);
        }
      }
      else if (((e)paramn).Ciz)
      {
        this.Chh = -1;
        this.Chg = false;
        paramString = this.gPm;
        if (paramString != null) {
          paramString.a(Integer.valueOf(i), this.filePath, Integer.valueOf(-1), null);
        }
        this.Chf = true;
      }
    }
    AppMethodBeat.o(191916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.a
 * JD-Core Version:    0.7.0.1
 */