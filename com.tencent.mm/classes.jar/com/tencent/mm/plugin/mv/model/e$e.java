package com.tencent.mm.plugin.mv.model;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderVideoData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "isLocal", "", "()Z", "startMs", "getStartMs", "setStartMs", "getFinderObj", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$e
  implements e.h
{
  private final FinderObject EDa;
  private long durationMs;
  private final boolean hJv;
  private long startMs;
  
  public e$e(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(286165);
    this.EDa = paramFinderObject;
    paramFinderObject = this.EDa.objectDesc;
    int i;
    if (paramFinderObject == null) {
      i = 0;
    }
    for (;;)
    {
      this.durationMs = (i * 1000L);
      AppMethodBeat.o(286165);
      return;
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject == null)
      {
        i = 0;
      }
      else
      {
        paramFinderObject = (FinderMedia)p.oL((List)paramFinderObject);
        if (paramFinderObject == null) {
          i = 0;
        } else {
          i = paramFinderObject.videoDuration;
        }
      }
    }
  }
  
  public final boolean eDB()
  {
    return this.hJv;
  }
  
  public final long getDurationMs()
  {
    return this.durationMs;
  }
  
  public final long gpA()
  {
    return this.startMs;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.a.b gpB()
  {
    AppMethodBeat.i(286210);
    Object localObject1 = this.EDa.objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 != null)
      {
        FinderMedia localFinderMedia = (FinderMedia)p.oL((List)localObject1);
        if (localFinderMedia != null)
        {
          Object localObject2 = s.X("video_", Long.valueOf(this.EDa.id));
          localObject1 = g.LMs;
          String str2 = g.aOY((String)localObject2);
          localObject1 = com.tencent.mm.plugin.thumbplayer.b.TBI;
          localObject1 = MMApplicationContext.getContext();
          s.s(localObject1, "getContext()");
          localObject1 = com.tencent.mm.plugin.thumbplayer.b.p((Context)localObject1, (int)localFinderMedia.width, (int)localFinderMedia.height);
          ((Bundle)localObject1).getInt("width", 0);
          ((Bundle)localObject1).getInt("height", 0);
          String str1 = localFinderMedia.url;
          localObject1 = str1;
          if (str1 == null) {
            localObject1 = "";
          }
          localObject2 = new com.tencent.mm.plugin.thumbplayer.a.b((String)localObject2, str2, (String)localObject1, (int)localFinderMedia.width, (int)localFinderMedia.height);
          ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).TBJ = 2;
          ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).hVy = "xV2";
          str1 = localFinderMedia.url_token;
          localObject1 = str1;
          if (str1 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).msf = ((String)localObject1);
          ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).decodeKey = localFinderMedia.decodeKey;
          ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).vYw = (localFinderMedia.videoDuration * 1000L);
          ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).thumbUrl = s.X(localFinderMedia.thumbUrl, localFinderMedia.thumb_url_token);
          localObject1 = g.LMs;
          ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).thumbPath = g.aOX(s.X("thumb_", Long.valueOf(this.EDa.id)));
          AppMethodBeat.o(286210);
          return localObject2;
        }
      }
    }
    AppMethodBeat.o(286210);
    return null;
  }
  
  public final FinderObject gpC()
  {
    return this.EDa;
  }
  
  public final void sE(long paramLong)
  {
    this.durationMs = paramLong;
  }
  
  public final void sF(long paramLong)
  {
    this.startMs = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.e.e
 * JD-Core Version:    0.7.0.1
 */