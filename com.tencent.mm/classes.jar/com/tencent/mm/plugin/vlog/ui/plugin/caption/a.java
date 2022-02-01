package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "chanCfg", "extractFinish", "", "filePath", "isRelease", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "needRequest", "netScene", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "profile", "requesting", "getRequesting", "()Z", "setRequesting", "(Z)V", "sampleRate", "total", "transResult", "transRet", "voiceData", "Ljava/nio/ByteBuffer;", "doNetRequest", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "offset", "doNetVoiceTranslate", "getTransResult", "getTransStatus", "loadAudioTrackData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveBuffer2File", "setupExtractor", "voiceTransLate", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.am.h
{
  public static final a.a Ukq;
  private static long Uky;
  boolean Bcz;
  private e Ukr;
  ArrayList<uq> Uks;
  private ByteBuffer Ukt;
  private boolean Uku;
  boolean Ukv;
  int Ukw;
  private int Ukx;
  String filePath;
  r<? super Integer, ? super String, ? super Integer, ? super ArrayList<uq>, ah> mXP;
  com.tencent.mm.compatible.i.c nAr;
  volatile boolean nzB;
  private int profile;
  private int sampleRate;
  private int total;
  
  static
  {
    AppMethodBeat.i(283255);
    Ukq = new a.a((byte)0);
    AppMethodBeat.o(283255);
  }
  
  public a()
  {
    AppMethodBeat.i(283224);
    this.Uks = new ArrayList();
    this.filePath = "";
    this.Ukv = true;
    this.profile = 2;
    this.sampleRate = 44100;
    this.Ukx = 1;
    com.tencent.mm.kernel.h.baD().mCm.a(3835, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(283224);
  }
  
  private final void a(int paramInt1, b paramb, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(283235);
    int i = this.total;
    Object localObject1 = this.Ukr;
    e locale;
    if (localObject1 == null)
    {
      localObject1 = null;
      locale = new e(paramInt1, paramb, paramInt2, paramInt3, i, (b)localObject1);
      StringBuilder localStringBuilder = new StringBuilder("[").append(hashCode()).append("]do voiceTransLate vid:");
      localObject1 = locale.UlI;
      if (localObject1 != null) {
        break label195;
      }
      localObject1 = null;
      label84:
      localObject1 = localStringBuilder.append(localObject1).append(" seq:").append(paramInt2).append(" size:");
      if (paramb != null) {
        break label207;
      }
    }
    label195:
    label207:
    for (paramb = localObject2;; paramb = Integer.valueOf(paramb.Op.length))
    {
      Log.i("MicroMsg.EditCaptionDataManager", paramb + " offset:" + paramInt3);
      paramb = this.filePath;
      kotlin.g.b.s.u(paramb, "<set-?>");
      locale.filePath = paramb;
      this.Ukr = locale;
      com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)this.Ukr, 0);
      AppMethodBeat.o(283235);
      return;
      localObject1 = ((e)localObject1).UlI;
      break;
      localObject1 = ((b)localObject1).toString("UTF-8");
      break label84;
    }
  }
  
  final int bfs(String paramString)
  {
    AppMethodBeat.i(283271);
    label81:
    label727:
    label736:
    for (;;)
    {
      Object localObject1;
      int i;
      int j;
      int m;
      int k;
      label126:
      long l;
      try
      {
        if (this.nAr == null)
        {
          this.nAr = new com.tencent.mm.compatible.i.c();
          localObject1 = this.nAr;
          if (localObject1 != null) {
            ((com.tencent.mm.compatible.i.c)localObject1).setDataSource(paramString);
          }
          localObject1 = this.nAr;
          if (localObject1 == null)
          {
            i = 0;
            break label674;
            m = j + 1;
            localObject1 = this.nAr;
            if (localObject1 != null) {
              continue;
            }
            localObject1 = null;
            break label685;
            Log.i("MicroMsg.EditCaptionDataManager", kotlin.g.b.s.X("track mime:", localObject2));
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label702;
            }
            if ((localObject2 == null) || (n.U((String)localObject2, "audio/", false) != true)) {
              break label696;
            }
            k = 1;
            if (k == 0) {
              break label702;
            }
            com.tencent.mm.compatible.i.c localc = this.nAr;
            localObject2 = localObject1;
            if (localc != null)
            {
              localc.selectTrack(j);
              localObject2 = localObject1;
            }
            if (localObject2 != null) {
              continue;
            }
            Log.e("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "no audio track]");
            paramString = this.nAr;
            if (paramString != null) {
              paramString.lZm.release();
            }
            this.nAr = null;
            this.Ukw = -2;
            AppMethodBeat.o(283271);
            return -2;
          }
        }
        else
        {
          Log.i("MicroMsg.EditCaptionDataManager", "already create extractor success");
          AppMethodBeat.o(283271);
          return 0;
        }
        i = ((com.tencent.mm.compatible.i.c)localObject1).lZm.getTrackCount();
        break label674;
        localObject1 = ((com.tencent.mm.compatible.i.c)localObject1).getTrackFormat(j);
        break label685;
        localObject2 = ((MediaFormat)localObject1).getString("mime");
        continue;
        paramString = MultiMediaVideoChecker.ObB.aTG(paramString);
        Log.i("MicroMsg.EditCaptionDataManager", "audio format:" + localObject2 + ", videoInfo:" + paramString);
        if (paramString == null)
        {
          l = 0L;
          kotlin.g.b.s.u(localObject2, "<this>");
          kotlin.g.b.s.u("durationUs", "name");
          if (!((MediaFormat)localObject2).containsKey("durationUs")) {
            break label727;
          }
          l = ((MediaFormat)localObject2).getLong("durationUs");
          break label715;
          i = u.c((MediaFormat)localObject2, "bitrate", i);
          this.profile = u.c((MediaFormat)localObject2, "profile", this.profile);
          this.sampleRate = u.c((MediaFormat)localObject2, "sample-rate", this.sampleRate);
          this.Ukx = u.c((MediaFormat)localObject2, "channel-count", this.Ukx);
          float f1 = 2.0F * (i * ((float)l / 1000.0F / 1000.0F) / 8.0F);
          float f2 = (float)l / 1000.0F / 20.0F * 7.0F;
          this.Ukt = ByteBuffer.allocateDirect((int)(f1 + f2));
          localObject1 = new StringBuilder("[").append(hashCode()).append("]allocate buffer size:");
          paramString = this.Ukt;
          if (paramString == null)
          {
            paramString = null;
            Log.i("MicroMsg.EditCaptionDataManager", paramString + ", voiceSize:" + f1 + ", adtsSize:" + f2 + ", duration:" + l + ", bitrate:" + i);
            AppMethodBeat.o(283271);
            return 0;
          }
        }
        else
        {
          l = paramString.duration;
          continue;
          i = paramString.audioBitrate;
          continue;
        }
        j = paramString.capacity();
        paramString = Integer.valueOf(j);
        continue;
        j = m;
      }
      catch (Exception paramString)
      {
        localObject1 = this.nAr;
        if (localObject1 != null) {
          ((com.tencent.mm.compatible.i.c)localObject1).lZm.release();
        }
        this.nAr = null;
        Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", (Throwable)paramString, "", new Object[0]);
        this.Ukw = -3;
        AppMethodBeat.o(283271);
        return -3;
      }
      do
      {
        break;
        if (i <= 0) {
          break label709;
        }
        j = 0;
        break;
        if (localObject1 != null) {
          break label269;
        }
        localObject2 = null;
        break label81;
        k = 0;
        break label126;
      } while (m < i);
      Object localObject2 = null;
      continue;
      for (;;)
      {
        if (paramString != null) {
          break label736;
        }
        i = 128000;
        break;
        l *= 1000L;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(283287);
    if (paramp == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.NetSceneGetVideoCaption");
      AppMethodBeat.o(283287);
      throw paramString;
    }
    if ((kotlin.g.b.s.p(((e)paramp).filePath, this.filePath)) && (!this.nzB))
    {
      Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      int i = ((e)paramp).UkR;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Uks = ((e)paramp).UlJ;
        Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]scene seq:" + ((e)paramp).oUj + " isLastRequest:" + ((e)paramp).UlK + " progress:" + ((e)paramp).getProgress());
        paramString = (Iterable)this.Uks;
        paramInt1 = 0;
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          Object localObject = paramString.next();
          if (paramInt1 < 0) {
            kotlin.a.p.kkW();
          }
          localObject = (uq)localObject;
          Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + paramInt1 + ": start:" + ((uq)localObject).YZX + " end:" + ((uq)localObject).YZY + " text:" + ((uq)localObject).YZW.toString("UTF-8"));
          if ((((e)paramp).UlK) && (((e)paramp).getProgress() >= 100))
          {
            long l = Uky + 1L;
            Uky = l;
            ((uq)localObject).id = l;
          }
          paramInt1 += 1;
        }
        Log.i("MicroMsg.EditCaptionDataManager", "\n");
        if (((e)paramp).UlK) {
          if (((e)paramp).getProgress() >= 100)
          {
            this.Bcz = false;
            paramString = this.mXP;
            if (paramString != null)
            {
              paramp = this.filePath;
              if (!((Collection)this.Uks).isEmpty())
              {
                paramInt1 = 1;
                if (paramInt1 == 0) {
                  break label502;
                }
              }
              label502:
              for (paramInt1 = 0;; paramInt1 = -2)
              {
                paramString.a(Integer.valueOf(i), paramp, Integer.valueOf(paramInt1), this.Uks);
                AppMethodBeat.o(283287);
                return;
                paramInt1 = 0;
                break;
              }
            }
          }
          else
          {
            paramString = this.mXP;
            if (paramString != null) {
              paramString.a(Integer.valueOf(i), this.filePath, Integer.valueOf(0), this.Uks);
            }
            Log.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]repeat query voice data");
            paramString = this.Ukr;
            kotlin.g.b.s.checkNotNull(paramString);
            a(i, null, paramString.oUj, 0);
            AppMethodBeat.o(283287);
          }
        }
      }
      else if (((e)paramp).UlK)
      {
        this.Ukw = -1;
        this.Bcz = false;
        paramString = this.mXP;
        if (paramString != null) {
          paramString.a(Integer.valueOf(i), this.filePath, Integer.valueOf(-1), null);
        }
        this.Ukv = true;
      }
    }
    AppMethodBeat.o(283287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.a
 * JD-Core Version:    0.7.0.1
 */