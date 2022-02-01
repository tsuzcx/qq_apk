package com.tencent.mm.plugin.vlog.remux;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/remux/SimpleAudioExtractor;", "", "()V", "TAG", "", "extract", "", "src", "dest", "plugin-vlog_release"})
public final class a
{
  public static final a Nqc;
  
  static
  {
    AppMethodBeat.i(232176);
    Nqc = new a();
    AppMethodBeat.o(232176);
  }
  
  public static boolean lH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232173);
    p.k(paramString1, "src");
    p.k(paramString2, "dest");
    for (;;)
    {
      long l1;
      c localc;
      Object localObject1;
      try
      {
        if (!u.agG(paramString1))
        {
          Log.i("MicroMsg.SimpleAudioExtractor", "src empty :".concat(String.valueOf(paramString1)));
          AppMethodBeat.o(232173);
          return false;
        }
        u.deleteFile(paramString2);
        u.bBV(paramString2);
        l1 = u.bBQ(paramString1);
        localc = new c();
        localc.setDataSource(paramString1);
        int j = localc.getTrackCount();
        i = 0;
        if (i >= j) {
          break label462;
        }
        localObject1 = localc.getTrackFormat(i);
        p.j(localObject1, "extractor.getTrackFormat(trackIndex)");
        localObject1 = ((MediaFormat)localObject1).getString("mime");
        p.j(localObject1, "mime");
        if (!n.a((CharSequence)localObject1, (CharSequence)"audio", false)) {
          break label467;
        }
        if (i == -1)
        {
          AppMethodBeat.o(232173);
          return false;
        }
        Object localObject2 = localc.getTrackFormat(i);
        p.j(localObject2, "extractor.getTrackFormat(audioIndex)");
        localObject1 = u.n(paramString2, true);
        if (localObject1 == null) {
          p.iCn();
        }
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
          ((MediaCodec.BufferInfo)localObject2).presentationTimeUs = localc.getSampleTime();
          ((MediaCodec.BufferInfo)localObject2).flags = localc.getSampleFlags();
          Log.d("MicroMsg.SimpleAudioExtractor", "extract audio pts:" + ((MediaCodec.BufferInfo)localObject2).presentationTimeUs);
          ((MediaMuxer)localObject1).writeSampleData(0, paramString1, (MediaCodec.BufferInfo)localObject2);
          localc.advance();
          continue;
        }
        ((MediaMuxer)localObject1).stop();
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.SimpleAudioExtractor", "extract aac error:" + paramString1.getMessage());
        AppMethodBeat.o(232173);
        return false;
      }
      ((MediaMuxer)localObject1).release();
      localc.release();
      long l2 = System.currentTimeMillis();
      long l3 = u.bBQ(paramString2);
      Log.d("MicroMsg.SimpleAudioExtractor", "extract aac success:" + paramString2 + ", length:" + l3 + ", cost:" + (l2 - l1) + "ms");
      AppMethodBeat.o(232173);
      return true;
      label462:
      int i = -1;
      continue;
      label467:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.a
 * JD-Core Version:    0.7.0.1
 */