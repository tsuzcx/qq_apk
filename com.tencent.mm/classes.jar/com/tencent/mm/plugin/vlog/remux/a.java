package com.tencent.mm.plugin.vlog.remux;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/remux/SimpleAudioExtractor;", "", "()V", "TAG", "", "extract", "", "src", "dest", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a UdR;
  
  static
  {
    AppMethodBeat.i(281333);
    UdR = new a();
    AppMethodBeat.o(281333);
  }
  
  public static boolean nr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(281330);
    s.u(paramString1, "src");
    s.u(paramString2, "dest");
    for (;;)
    {
      long l1;
      c localc;
      int k;
      int j;
      Object localObject1;
      try
      {
        if (!y.ZC(paramString1))
        {
          Log.i("MicroMsg.SimpleAudioExtractor", s.X("src empty :", paramString1));
          AppMethodBeat.o(281330);
          return false;
        }
        y.deleteFile(paramString2);
        y.bEp(paramString2);
        l1 = y.bEl(paramString1);
        localc = new c();
        localc.setDataSource(paramString1);
        k = localc.lZm.getTrackCount();
        if (k <= 0) {
          break label476;
        }
        i = 0;
        j = i + 1;
        localObject1 = localc.getTrackFormat(i);
        s.s(localObject1, "extractor.getTrackFormat(trackIndex)");
        localObject1 = ((MediaFormat)localObject1).getString("mime");
        s.checkNotNull(localObject1);
        s.s(localObject1, "trackFormat.getString(MediaFormat.KEY_MIME)!!");
        if (!n.a((CharSequence)localObject1, (CharSequence)"audio", false)) {
          break label470;
        }
        if (i == -1)
        {
          AppMethodBeat.o(281330);
          return false;
        }
        Object localObject2 = localc.getTrackFormat(i);
        s.s(localObject2, "extractor.getTrackFormat(audioIndex)");
        localObject1 = y.n(paramString2, true);
        s.checkNotNull(localObject1);
        localObject1 = new MediaMuxer((String)localObject1, 0);
        ((MediaMuxer)localObject1).addTrack((MediaFormat)localObject2);
        ((MediaMuxer)localObject1).start();
        Log.i("MicroMsg.SimpleAudioExtractor", "[extract] src = " + paramString1 + ",length:" + l1);
        paramString1 = ByteBuffer.allocate(1048576);
        localc.selectTrack(i);
        l1 = System.currentTimeMillis();
        localObject2 = new MediaCodec.BufferInfo();
        i = localc.readSampleData(paramString1, 0);
        if (i >= 0)
        {
          ((MediaCodec.BufferInfo)localObject2).offset = 0;
          ((MediaCodec.BufferInfo)localObject2).size = i;
          ((MediaCodec.BufferInfo)localObject2).presentationTimeUs = localc.lZm.getSampleTime();
          ((MediaCodec.BufferInfo)localObject2).flags = localc.lZm.getSampleFlags();
          Log.d("MicroMsg.SimpleAudioExtractor", s.X("extract audio pts:", Long.valueOf(((MediaCodec.BufferInfo)localObject2).presentationTimeUs)));
          ((MediaMuxer)localObject1).writeSampleData(0, paramString1, (MediaCodec.BufferInfo)localObject2);
          localc.lZm.advance();
          continue;
        }
        ((MediaMuxer)localObject1).stop();
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.SimpleAudioExtractor", s.X("extract aac error:", paramString1.getMessage()));
        AppMethodBeat.o(281330);
        return false;
      }
      ((MediaMuxer)localObject1).release();
      localc.lZm.release();
      l2 = System.currentTimeMillis();
      l3 = y.bEl(paramString2);
      Log.d("MicroMsg.SimpleAudioExtractor", "extract aac success:" + paramString2 + ", length:" + l3 + ", cost:" + (l2 - l1) + "ms");
      AppMethodBeat.o(281330);
      return true;
      label470:
      while (j < k)
      {
        long l2;
        long l3;
        i = j;
        break;
      }
      label476:
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.a
 * JD-Core Version:    0.7.0.1
 */