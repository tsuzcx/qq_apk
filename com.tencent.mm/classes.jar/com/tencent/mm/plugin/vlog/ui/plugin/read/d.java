package com.tencent.mm.plugin.vlog.ui.plugin.read;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "", "()V", "remux", "", "src", "", "dest", "desSampleRate", "", "desChannels", "desBitDepth", "Companion", "plugin-vlog_release"})
public final class d
{
  public static final a BRu;
  
  static
  {
    AppMethodBeat.i(196625);
    BRu = new a((byte)0);
    AppMethodBeat.o(196625);
  }
  
  public static void s(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196624);
    p.h(paramString1, "src");
    p.h(paramString2, "dest");
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    MediaExtractor localMediaExtractor = new MediaExtractor();
    i.deleteFile(paramString2);
    i.aYs(paramString2);
    for (;;)
    {
      MediaCodec localMediaCodec;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localByteArrayOutputStream);
        localMediaExtractor.setDataSource(paramString1);
        localMediaExtractor.selectTrack(0);
        Object localObject = localMediaExtractor.getTrackFormat(0);
        localMediaCodec = MediaCodec.createDecoderByType(((MediaFormat)localObject).getString("mime"));
        localMediaCodec.configure((MediaFormat)localObject, null, null, 0);
        localMediaCodec.start();
        paramString1 = new f(paramString1, ((MediaFormat)localObject).getInteger("sample-rate"), ((MediaFormat)localObject).getInteger("channel-count"), ((MediaFormat)localObject).getInteger("bitrate"), 44100, paramInt1, paramInt2);
        paramInt2 = localMediaCodec.dequeueInputBuffer(1000L);
        int i;
        if (paramInt2 >= 0)
        {
          i = localMediaExtractor.readSampleData(localMediaCodec.getInputBuffer(paramInt2), 0);
          if (i < 0) {
            localMediaCodec.queueInputBuffer(paramInt2, 0, 0, 0L, 4);
          }
        }
        else
        {
          paramInt2 = localMediaCodec.dequeueOutputBuffer(localBufferInfo, 1000L);
        }
        switch (paramInt2)
        {
        case -3: 
          localObject = localMediaCodec.getOutputBuffer(paramInt2);
          byte[] arrayOfByte = new byte[localBufferInfo.size];
          if (localObject != null) {
            ((ByteBuffer)localObject).get(arrayOfByte, 0, localBufferInfo.size);
          }
          if (localObject != null) {
            ((ByteBuffer)localObject).clear();
          }
          localMediaCodec.releaseOutputBuffer(paramInt2, false);
          localDataOutputStream.write(paramString1.J(arrayOfByte));
        case -1: 
          if (localBufferInfo.flags == 0) {
            continue;
          }
          i.C(paramString2, c.W(localByteArrayOutputStream.toByteArray(), paramInt1));
          localMediaCodec.stop();
          localMediaCodec.release();
          localMediaExtractor.release();
          paramString1.release();
          ad.d("MicroMsg.SimpleAudioRemuxer", "remux success: ".concat(String.valueOf(paramString2)));
          AppMethodBeat.o(196624);
          return;
          localMediaCodec.queueInputBuffer(paramInt2, 0, i, localMediaExtractor.getSampleTime(), 0);
          localMediaExtractor.advance();
          break;
        case -2: 
          p.g(localMediaCodec, "decoder");
        }
      }
      catch (IOException paramString1)
      {
        ad.e("MicroMsg.SimpleAudioRemuxer", "remux error:" + paramString1.getMessage());
        AppMethodBeat.o(196624);
        return;
      }
      localMediaCodec.getOutputFormat();
      ad.d("MicroMsg.SimpleAudioRemuxer", "get output format");
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.d
 * JD-Core Version:    0.7.0.1
 */