package com.tencent.mm.plugin.vlog.parallel;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/parallel/ParallelMuxTrackInfo;", "", "isVideoTrack", "", "trackId", "", "mediaFormat", "Landroid/media/MediaFormat;", "frameCount", "trackDuration", "localSavePath", "", "pendingMediaDts", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pendingMediaPts", "(ZILandroid/media/MediaFormat;IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "TAG", "bFrameSize", "getFrameCount", "()I", "setFrameCount", "(I)V", "()Z", "setVideoTrack", "(Z)V", "getLocalSavePath", "()Ljava/lang/String;", "setLocalSavePath", "(Ljava/lang/String;)V", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "getPendingMediaDts", "()Ljava/util/ArrayList;", "setPendingMediaDts", "(Ljava/util/ArrayList;)V", "getPendingMediaPts", "setPendingMediaPts", "getTrackDuration", "setTrackDuration", "getTrackId", "setTrackId", "writeStream", "Ljava/io/FileOutputStream;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "countFps", "", "equals", "other", "hasBFrame", "hashCode", "toString", "writeSampleData", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "writeSampleDataFinish", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Ucz;
  private final String TAG;
  boolean UcA;
  int UcB;
  String UcC;
  ArrayList<Long> UcD;
  ArrayList<Long> UcE;
  private FileOutputStream UcF;
  int UcG;
  int frameCount;
  MediaFormat mediaFormat;
  int trackId;
  
  static
  {
    AppMethodBeat.i(281263);
    Ucz = new a((byte)0);
    AppMethodBeat.o(281263);
  }
  
  private a(boolean paramBoolean, int paramInt, MediaFormat paramMediaFormat, String paramString, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2)
  {
    AppMethodBeat.i(281251);
    this.UcA = paramBoolean;
    this.trackId = paramInt;
    this.mediaFormat = paramMediaFormat;
    this.frameCount = 0;
    this.UcB = 0;
    this.UcC = paramString;
    this.UcD = paramArrayList1;
    this.UcE = paramArrayList2;
    this.TAG = "MicroMsg.ParallelMuxTrackInfo";
    AppMethodBeat.o(281251);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(281298);
    if (this == paramObject)
    {
      AppMethodBeat.o(281298);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(281298);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.UcA != paramObject.UcA)
    {
      AppMethodBeat.o(281298);
      return false;
    }
    if (this.trackId != paramObject.trackId)
    {
      AppMethodBeat.o(281298);
      return false;
    }
    if (!s.p(this.mediaFormat, paramObject.mediaFormat))
    {
      AppMethodBeat.o(281298);
      return false;
    }
    if (this.frameCount != paramObject.frameCount)
    {
      AppMethodBeat.o(281298);
      return false;
    }
    if (this.UcB != paramObject.UcB)
    {
      AppMethodBeat.o(281298);
      return false;
    }
    if (!s.p(this.UcC, paramObject.UcC))
    {
      AppMethodBeat.o(281298);
      return false;
    }
    if (!s.p(this.UcD, paramObject.UcD))
    {
      AppMethodBeat.o(281298);
      return false;
    }
    if (!s.p(this.UcE, paramObject.UcE))
    {
      AppMethodBeat.o(281298);
      return false;
    }
    AppMethodBeat.o(281298);
    return true;
  }
  
  public final void hRR()
  {
    AppMethodBeat.i(281277);
    try
    {
      FileOutputStream localFileOutputStream = this.UcF;
      if (localFileOutputStream != null) {
        localFileOutputStream.flush();
      }
      localFileOutputStream = this.UcF;
      if (localFileOutputStream != null)
      {
        localFileOutputStream.close();
        AppMethodBeat.o(281277);
        return;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(281277);
    }
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void k(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    int k = 1;
    AppMethodBeat.i(281273);
    s.u(paramByteBuffer, "byteBuf");
    s.u(paramBufferInfo, "bufferInfo");
    this.frameCount += 1;
    int i = kotlin.h.a.eH((float)paramBufferInfo.presentationTimeUs / 1000.0F);
    if (i > this.UcB) {
      this.UcB = i;
    }
    if (this.UcF == null)
    {
      new File(this.UcC).createNewFile();
      this.UcF = new FileOutputStream(this.UcC);
      Log.i(this.TAG, s.X("create localSavePath:", this.UcC));
    }
    for (;;)
    {
      try
      {
        i = paramByteBuffer.position();
        if ((paramByteBuffer.remaining() <= 0) || (paramByteBuffer.get(i) != -1)) {
          break label432;
        }
        i = 0;
        if ((!this.UcA) && (i != 0))
        {
          if (!this.mediaFormat.containsKey("aac-profile")) {
            continue;
          }
          i = this.mediaFormat.getInteger("aac-profile");
          if (!this.mediaFormat.containsKey("sample-rate")) {
            continue;
          }
          j = this.mediaFormat.getInteger("sample-rate");
          if (this.mediaFormat.containsKey("channel-count")) {
            k = this.mediaFormat.getInteger("channel-count");
          }
          localObject1 = SightVideoJNI.getAACADTSHeaderData(paramByteBuffer.limit(), paramBufferInfo.presentationTimeUs, i, j, k);
          Object localObject2 = this.UcF;
          if (localObject2 != null)
          {
            localObject2 = ((FileOutputStream)localObject2).getChannel();
            if (localObject2 != null) {
              ((FileChannel)localObject2).write(ByteBuffer.wrap((byte[])localObject1));
            }
          }
        }
        if ((this.UcA) && (paramBufferInfo.presentationTimeUs < ((Number)p.oM((List)this.UcD)).longValue())) {
          this.UcG += 1;
        }
        Object localObject1 = this.UcF;
        if (localObject1 != null)
        {
          localObject1 = ((FileOutputStream)localObject1).getChannel();
          if (localObject1 != null) {
            ((FileChannel)localObject1).write(paramByteBuffer);
          }
        }
      }
      catch (Exception paramByteBuffer)
      {
        int j;
        Log.printErrStackTrace(this.TAG, (Throwable)paramByteBuffer, "", new Object[0]);
        continue;
        this.UcE.add(Long.valueOf(paramBufferInfo.presentationTimeUs));
        AppMethodBeat.o(281273);
        return;
      }
      if ((paramBufferInfo.presentationTimeUs == 0L) && (this.UcE.size() > 0))
      {
        Log.e(this.TAG, s.X("happen error ,bufferInfo size:", Integer.valueOf(paramBufferInfo.size)));
        AppMethodBeat.o(281273);
        return;
        i = 2;
        continue;
        j = 4;
      }
      else
      {
        label432:
        i = 1;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(281285);
    String str = "ParallelMuxTrackInfo(isVideoTrack=" + this.UcA + ", trackId=" + this.trackId + ", mediaFormat=" + this.mediaFormat + ", frameCount=" + this.frameCount + ", trackDuration=" + this.UcB + ", localSavePath=" + this.UcC + ", pendingMediaDts=" + this.UcD + ", pendingMediaPts=" + this.UcE + ')';
    AppMethodBeat.o(281285);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/parallel/ParallelMuxTrackInfo$Companion;", "", "()V", "AUDIO_DEFAULT_ID", "", "VIDEO_DEFAULT_ID", "createInstanceTrackInfo", "Lcom/tencent/mm/plugin/vlog/parallel/ParallelMuxTrackInfo;", "format", "Landroid/media/MediaFormat;", "fileName", "", "parallelTmpTrackSavePath", "isVideo", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a b(MediaFormat paramMediaFormat, String paramString)
    {
      AppMethodBeat.i(281268);
      s.u(paramMediaFormat, "format");
      s.u(paramString, "fileName");
      Object localObject = paramMediaFormat.getString("mime");
      boolean bool;
      int i;
      if ((localObject != null) && (n.a((CharSequence)localObject, (CharSequence)"video", false) == true))
      {
        bool = true;
        if (!bool) {
          break label127;
        }
        i = 1;
        label56:
        if (!bool) {
          break label132;
        }
        localObject = com.tencent.mm.plugin.s.a.KOy;
        localObject = am.aixg;
        paramString = String.format(Locale.ENGLISH, s.X(com.tencent.mm.plugin.s.a.gaE(), "/%s.h264"), Arrays.copyOf(new Object[] { paramString }, 1));
        s.s(paramString, "java.lang.String.format(locale, format, *args)");
      }
      for (;;)
      {
        paramMediaFormat = new a(bool, i, paramMediaFormat, paramString);
        AppMethodBeat.o(281268);
        return paramMediaFormat;
        bool = false;
        break;
        label127:
        i = 0;
        break label56;
        label132:
        localObject = com.tencent.mm.plugin.s.a.KOy;
        localObject = am.aixg;
        paramString = String.format(Locale.ENGLISH, s.X(com.tencent.mm.plugin.s.a.gaE(), "/%s.aac"), Arrays.copyOf(new Object[] { paramString }, 1));
        s.s(paramString, "java.lang.String.format(locale, format, *args)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.parallel.a
 * JD-Core Version:    0.7.0.1
 */