package com.tencent.mm.plugin.vlog.ui.plugin.read;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "", "()V", "remux", "", "src", "", "dest", "desSampleRate", "", "desChannels", "desBitDepth", "Companion", "plugin-vlog_release"})
public final class d
{
  public static final a CiU;
  
  static
  {
    AppMethodBeat.i(192086);
    CiU = new a((byte)0);
    AppMethodBeat.o(192086);
  }
  
  public static boolean ag(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(192085);
    p.h(paramString1, "src");
    p.h(paramString2, "dest");
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    MediaExtractor localMediaExtractor = new MediaExtractor();
    o.deleteFile(paramString2);
    o.aZV(paramString2);
    for (;;)
    {
      int i;
      int j;
      try
      {
        localByteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localByteArrayOutputStream);
        localMediaExtractor.setDataSource(paramString1);
        localMediaExtractor.selectTrack(0);
        Object localObject = localMediaExtractor.getTrackFormat(0);
        localMediaCodec = MediaCodec.createDecoderByType(((MediaFormat)localObject).getString("mime"));
        localMediaCodec.configure((MediaFormat)localObject, null, null, 0);
        localMediaCodec.start();
        if (!((MediaFormat)localObject).containsKey("sample-rate")) {
          break label491;
        }
        i = ((MediaFormat)localObject).getInteger("sample-rate");
        if (!((MediaFormat)localObject).containsKey("channel-count")) {
          break label497;
        }
        j = ((MediaFormat)localObject).getInteger("channel-count");
        paramString1 = new f(paramString1, i, j, 2, 44100, paramInt, 2);
        i = localMediaCodec.dequeueInputBuffer(1000L);
        if (i >= 0)
        {
          j = localMediaExtractor.readSampleData(localMediaCodec.getInputBuffer(i), 0);
          if (j >= 0) {
            continue;
          }
          localMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        }
        i = localMediaCodec.dequeueOutputBuffer(localBufferInfo, 1000L);
        switch (i)
        {
        case -3: 
          localObject = localMediaCodec.getOutputBuffer(i);
          byte[] arrayOfByte = new byte[localBufferInfo.size];
          if (localObject != null) {
            ((ByteBuffer)localObject).get(arrayOfByte, 0, localBufferInfo.size);
          }
          if (localObject != null) {
            ((ByteBuffer)localObject).clear();
          }
          localMediaCodec.releaseOutputBuffer(i, false);
          localDataOutputStream.write(paramString1.J(arrayOfByte));
        }
      }
      catch (IOException paramString1)
      {
        ByteArrayOutputStream localByteArrayOutputStream;
        MediaCodec localMediaCodec;
        ae.e("MicroMsg.SimpleAudioRemuxer", "remux error:" + paramString1.getMessage());
        AppMethodBeat.o(192085);
        return false;
        p.g(localMediaCodec, "decoder");
        localMediaCodec.getOutputFormat();
        ae.d("MicroMsg.SimpleAudioRemuxer", "get output format");
        continue;
      }
      catch (Exception paramString1)
      {
        ae.e("MicroMsg.SimpleAudioRemuxer", "remux error:" + paramString1.getMessage());
        AppMethodBeat.o(192085);
        return false;
      }
      if (localBufferInfo.flags != 0)
      {
        o.C(paramString2, c.aa(localByteArrayOutputStream.toByteArray(), paramInt));
        localMediaCodec.stop();
        localMediaCodec.release();
        localMediaExtractor.release();
        paramString1.release();
        ae.d("MicroMsg.SimpleAudioRemuxer", "remux success: ".concat(String.valueOf(paramString2)));
        AppMethodBeat.o(192085);
        return true;
        localMediaCodec.queueInputBuffer(i, 0, j, localMediaExtractor.getSampleTime(), 0);
        localMediaExtractor.advance();
        continue;
        continue;
        label491:
        i = 44100;
        continue;
        label497:
        j = 1;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.d
 * JD-Core Version:    0.7.0.1
 */