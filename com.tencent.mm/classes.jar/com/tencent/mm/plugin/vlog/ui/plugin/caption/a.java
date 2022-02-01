package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "chanCfg", "extractFinish", "", "filePath", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "needRequest", "netScene", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "profile", "requesting", "getRequesting", "()Z", "setRequesting", "(Z)V", "sampleRate", "total", "transResult", "transRet", "voiceData", "Ljava/nio/ByteBuffer;", "doNetRequest", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "offset", "doNetVoiceTranslate", "getTransResult", "getTransStatus", "loadAudioTrackData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveBuffer2File", "setupExtractor", "voiceTransLate", "Companion", "plugin-vlog_release"})
public final class a
  implements f
{
  public static final a.a BPK;
  private e BPC;
  ArrayList<rt> BPD;
  private ByteBuffer BPE;
  private boolean BPF;
  boolean BPG;
  boolean BPH;
  int BPI;
  private int BPJ;
  String filePath;
  r<? super Integer, ? super String, ? super Integer, ? super ArrayList<rt>, z> gMD;
  c hjX;
  volatile boolean hju;
  private int ieH;
  private int profile;
  private int sampleRate;
  
  static
  {
    AppMethodBeat.i(196459);
    BPK = new a.a((byte)0);
    AppMethodBeat.o(196459);
  }
  
  public a()
  {
    AppMethodBeat.i(196458);
    this.BPD = new ArrayList();
    this.filePath = "";
    this.BPG = true;
    this.profile = 2;
    this.sampleRate = 44100;
    this.BPJ = 1;
    com.tencent.mm.kernel.b localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().a(3835, (f)this);
    AppMethodBeat.o(196458);
  }
  
  private final void a(int paramInt1, com.tencent.mm.bx.b paramb, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(196456);
    int i = this.ieH;
    Object localObject1 = this.BPC;
    e locale;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).BRb;
      locale = new e(paramInt1, paramb, paramInt2, paramInt3, i, (com.tencent.mm.bx.b)localObject1);
      localStringBuilder = new StringBuilder("[").append(hashCode()).append("]do voiceTransLate vid:");
      localObject1 = locale.BRb;
      if (localObject1 == null) {
        break label219;
      }
    }
    label219:
    for (localObject1 = ((com.tencent.mm.bx.b)localObject1).toString("UTF-8");; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" seq:").append(paramInt2).append(" size:");
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = Integer.valueOf(paramb.size());
      }
      ad.i("MicroMsg.EditCaptionDataManager", localObject1 + " offset:" + paramInt3);
      paramb = this.filePath;
      p.h(paramb, "<set-?>");
      locale.filePath = paramb;
      this.BPC = locale;
      paramb = g.ajB();
      p.g(paramb, "MMKernel.network()");
      paramb.aiU().b((com.tencent.mm.al.n)this.BPC);
      AppMethodBeat.o(196456);
      return;
      localObject1 = null;
      break;
    }
  }
  
  final int aDw(String paramString)
  {
    AppMethodBeat.i(196455);
    for (;;)
    {
      try
      {
        if (this.hjX == null)
        {
          this.hjX = new c();
          localObject = this.hjX;
          if (localObject != null) {
            ((c)localObject).setDataSource(paramString);
          }
          paramString = this.hjX;
          if (paramString != null)
          {
            i = paramString.getTrackCount();
            break label532;
            if (j >= i) {
              break label527;
            }
            paramString = this.hjX;
            if (paramString == null) {
              break label282;
            }
            paramString = paramString.getTrackFormat(j);
            if (paramString == null) {
              break label287;
            }
            localObject = paramString.getString("mime");
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (localObject == null) || (d.n.n.nz((String)localObject, "audio/") != true)) {
              break label296;
            }
            localObject = this.hjX;
            if (localObject == null) {
              break label293;
            }
            ((c)localObject).selectTrack(j);
            if (paramString != null) {
              break label305;
            }
            ad.e("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "no audio track]");
            paramString = this.hjX;
            if (paramString != null) {
              paramString.release();
            }
            this.hjX = null;
            this.BPI = -2;
            AppMethodBeat.o(196455);
            return -2;
          }
        }
        else
        {
          ad.i("MicroMsg.EditCaptionDataManager", "already create extractor success");
          AppMethodBeat.o(196455);
          return 0;
        }
      }
      catch (Exception paramString)
      {
        localObject = this.hjX;
        if (localObject != null) {
          ((c)localObject).release();
        }
        this.hjX = null;
        ad.printErrStackTrace("MicroMsg.EditCaptionDataManager", (Throwable)paramString, "", new Object[0]);
        this.BPI = -3;
        AppMethodBeat.o(196455);
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
      this.BPJ = com.tencent.mm.plugin.vlog.model.n.c(paramString, "channel-count", this.BPJ);
      float f1 = 2.0F * (i * ((float)l / 1000.0F / 1000.0F) / 8.0F);
      float f2 = (float)l / 1000.0F / 20.0F * 7.0F;
      this.BPE = ByteBuffer.allocateDirect((int)(f1 + f2));
      localObject = new StringBuilder("[").append(hashCode()).append("]allocate buffer size:");
      paramString = this.BPE;
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.capacity());; paramString = null)
      {
        ad.i("MicroMsg.EditCaptionDataManager", paramString + ", voiceSize:" + f1 + ", adtsSize:" + f2 + ", duration:" + l + ", bitrate:" + i);
        AppMethodBeat.o(196455);
        return 0;
      }
      label527:
      paramString = null;
      continue;
      label532:
      int j = 0;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(196457);
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.NetSceneGetVideoCaption");
      AppMethodBeat.o(196457);
      throw paramString;
    }
    if ((p.i(((e)paramn).filePath, this.filePath)) && (!this.hju))
    {
      ad.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      int i = ((e)paramn).BQe;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.BPD = ((e)paramn).BQZ;
        ad.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]scene seq:" + ((e)paramn).inh + " isLastRequest:" + ((e)paramn).BRa + " progress:" + ((e)paramn).getProgress());
        paramString = (Iterable)this.BPD;
        paramInt1 = 0;
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          Object localObject = paramString.next();
          if (paramInt1 < 0) {
            j.gfB();
          }
          localObject = (rt)localObject;
          ad.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + paramInt1 + ": start:" + ((rt)localObject).FNR + " end:" + ((rt)localObject).FNS + " text:" + ((rt)localObject).FNQ.toString("UTF-8"));
          paramInt1 += 1;
        }
        ad.i("MicroMsg.EditCaptionDataManager", "\n");
        if (((e)paramn).BRa)
        {
          if (((e)paramn).getProgress() >= 100)
          {
            this.BPH = false;
            paramString = this.gMD;
            if (paramString != null)
            {
              paramString.a(Integer.valueOf(i), this.filePath, Integer.valueOf(0), this.BPD);
              AppMethodBeat.o(196457);
              return;
            }
            AppMethodBeat.o(196457);
            return;
          }
          paramString = this.gMD;
          if (paramString != null) {
            paramString.a(Integer.valueOf(i), this.filePath, Integer.valueOf(0), this.BPD);
          }
          ad.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]repeat query voice data");
          paramString = this.BPC;
          if (paramString == null) {
            p.gfZ();
          }
          a(i, null, paramString.inh, 0);
          AppMethodBeat.o(196457);
        }
      }
      else if (((e)paramn).BRa)
      {
        this.BPI = -1;
        this.BPH = false;
        paramString = this.gMD;
        if (paramString != null) {
          paramString.a(Integer.valueOf(i), this.filePath, Integer.valueOf(-1), null);
        }
        this.BPG = true;
      }
    }
    AppMethodBeat.o(196457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.a
 * JD-Core Version:    0.7.0.1
 */