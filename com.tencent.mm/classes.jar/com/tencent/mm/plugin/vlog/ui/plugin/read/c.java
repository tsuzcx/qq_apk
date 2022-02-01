package com.tencent.mm.plugin.vlog.ui.plugin.read;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "", "()V", "remux", "", "src", "", "dest", "desSampleRate", "", "desChannels", "desBitDepth", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a Umv;
  
  static
  {
    AppMethodBeat.i(282947);
    Umv = new a((byte)0);
    AppMethodBeat.o(282947);
  }
  
  public static boolean aC(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(282943);
    s.u(paramString1, "src");
    s.u(paramString2, "dest");
    Object localObject2 = new MediaCodec.BufferInfo();
    MediaExtractor localMediaExtractor = new MediaExtractor();
    y.deleteFile(paramString2);
    y.bEp(paramString2);
    for (;;)
    {
      int i1;
      int i2;
      try
      {
        localObject3 = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject3);
        localMediaExtractor.setDataSource(paramString1);
        localMediaExtractor.selectTrack(0);
        Object localObject4 = localMediaExtractor.getTrackFormat(0);
        s.s(localObject4, "extractor.getTrackFormat(0)");
        localObject1 = ((MediaFormat)localObject4).getString("mime");
        s.checkNotNull(localObject1);
        localObject1 = MediaCodec.createDecoderByType((String)localObject1);
        s.s(localObject1, "createDecoderByType(inpu…(MediaFormat.KEY_MIME)!!)");
        ((MediaCodec)localObject1).configure((MediaFormat)localObject4, null, null, 0);
        ((MediaCodec)localObject1).start();
        if (!((MediaFormat)localObject4).containsKey("sample-rate")) {
          break label940;
        }
        i1 = ((MediaFormat)localObject4).getInteger("sample-rate");
        if (!((MediaFormat)localObject4).containsKey("channel-count")) {
          break label947;
        }
        i2 = ((MediaFormat)localObject4).getInteger("channel-count");
        paramString1 = new g(paramString1, i1, i2, 2, 44100, paramInt, 2);
        i1 = ((MediaCodec)localObject1).dequeueInputBuffer(1000L);
        if (i1 >= 0)
        {
          localObject4 = ((MediaCodec)localObject1).getInputBuffer(i1);
          s.checkNotNull(localObject4);
          i2 = localMediaExtractor.readSampleData((ByteBuffer)localObject4, 0);
          if (i2 >= 0) {
            continue;
          }
          ((MediaCodec)localObject1).queueInputBuffer(i1, 0, 0, 0L, 4);
        }
        i1 = ((MediaCodec)localObject1).dequeueOutputBuffer((MediaCodec.BufferInfo)localObject2, 1000L);
        switch (i1)
        {
        case -3: 
          localObject4 = ((MediaCodec)localObject1).getOutputBuffer(i1);
          byte[] arrayOfByte = new byte[((MediaCodec.BufferInfo)localObject2).size];
          if (localObject4 != null) {
            ((ByteBuffer)localObject4).get(arrayOfByte, 0, ((MediaCodec.BufferInfo)localObject2).size);
          }
          if (localObject4 != null) {
            ((ByteBuffer)localObject4).clear();
          }
          ((MediaCodec)localObject1).releaseOutputBuffer(i1, false);
          localDataOutputStream.write(paramString1.ae(arrayOfByte));
        }
      }
      catch (IOException paramString1)
      {
        Object localObject3;
        Object localObject1;
        long l;
        int i;
        int j;
        int k;
        int m;
        int n;
        Log.e("MicroMsg.SimpleAudioRemuxer", s.X("remux error:", paramString1.getMessage()));
        AppMethodBeat.o(282943);
        return false;
        s.s(((MediaCodec)localObject1).getOutputFormat(), "decoder.outputFormat");
        Log.d("MicroMsg.SimpleAudioRemuxer", "get output format");
        continue;
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.SimpleAudioRemuxer", s.X("remux error:", paramString1.getMessage()));
        AppMethodBeat.o(282943);
        return false;
      }
      if (((MediaCodec.BufferInfo)localObject2).flags != 0)
      {
        localObject2 = ((ByteArrayOutputStream)localObject3).toByteArray();
        localObject3 = new byte[localObject2.length + 44];
        i1 = localObject2.length;
        l = i1 + 36;
        i = (byte)(int)(0xFF & l);
        j = (byte)(int)(l >> 8 & 0xFF);
        k = (byte)(int)(l >> 16 & 0xFF);
        m = (byte)(int)(l >> 24 & 0xFF);
        n = (byte)paramInt;
        l = 44100 * paramInt * 16 / 8;
        System.arraycopy(new byte[] { 82, 73, 70, 70, i, j, k, m, 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, n, 0, 68, -84, 0, 0, (byte)(int)(0xFF & l), (byte)(int)(l >> 8 & 0xFF), (byte)(int)(l >> 16 & 0xFF), (byte)(int)(l >> 24 & 0xFF), (byte)(paramInt * 16 / 8), 0, 16, 0, 100, 97, 116, 97, (byte)(i1 & 0xFF), (byte)(i1 >> 8 & 0xFF), (byte)(i1 >> 16 & 0xFF), (byte)(i1 >> 24 & 0xFF) }, 0, localObject3, 0, 44);
        System.arraycopy(localObject2, 0, localObject3, 44, localObject2.length);
        y.f(paramString2, (byte[])localObject3, localObject3.length);
        ((MediaCodec)localObject1).stop();
        ((MediaCodec)localObject1).release();
        localMediaExtractor.release();
        paramString1.release();
        Log.d("MicroMsg.SimpleAudioRemuxer", s.X("remux success: ", paramString2));
        AppMethodBeat.o(282943);
        return true;
        ((MediaCodec)localObject1).queueInputBuffer(i1, 0, i2, localMediaExtractor.getSampleTime(), 0);
        localMediaExtractor.advance();
        continue;
        continue;
        label940:
        i1 = 44100;
        continue;
        label947:
        i2 = 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.c
 * JD-Core Version:    0.7.0.1
 */