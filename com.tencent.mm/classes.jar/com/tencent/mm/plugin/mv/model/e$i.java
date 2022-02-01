package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.thumbplayer.a.b;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.h.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$LocalVideoData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "mediaId", "", "videoPath", "durationMs", "", "videoWidth", "", "videoHeight", "(Ljava/lang/String;Ljava/lang/String;JII)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "isDefault", "", "()Z", "setDefault", "(Z)V", "isLocal", "localFinderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMediaId", "()Ljava/lang/String;", "startMs", "getStartMs", "setStartMs", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "getVideoPath", "getVideoWidth", "setVideoWidth", "getFinderObj", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$i
  implements e.h
{
  public static final e.i.a LXd;
  private static long oTE;
  private final FinderObject LXe;
  private long durationMs;
  private final boolean hJv;
  private final String mediaId;
  public boolean oBZ;
  public long startMs;
  public int videoHeight;
  public final String videoPath;
  public int videoWidth;
  
  static
  {
    AppMethodBeat.i(286175);
    LXd = new e.i.a((byte)0);
    AppMethodBeat.o(286175);
  }
  
  public e$i(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286162);
    this.mediaId = paramString1;
    this.videoPath = paramString2;
    this.durationMs = paramLong;
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    this.hJv = true;
    this.LXe = new FinderObject();
    paramLong = cn.bDu();
    if (oTE == paramLong) {}
    for (oTE += 1L;; oTE = paramLong)
    {
      paramString2 = s.X("local_", Long.valueOf(oTE));
      paramString1 = new FinderMedia();
      paramString1.url = this.videoPath;
      this.LXe.objectNonceId = paramString2;
      paramString2 = this.LXe;
      FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
      localFinderObjectDesc.media.add(paramString1);
      paramString1 = ah.aiuX;
      paramString2.objectDesc = localFinderObjectDesc;
      AppMethodBeat.o(286162);
      return;
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
  
  public final b gpB()
  {
    AppMethodBeat.i(286213);
    b localb = new b(this.mediaId, this.videoPath, "", this.videoWidth, this.videoHeight);
    localb.TBJ = 2;
    localb.hVy = "xV2";
    localb.hJv = true;
    MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.ObB.cI(this.videoPath, true);
    long l;
    if (locala == null)
    {
      l = 0L;
      localb.vYw = l;
      if (locala != null) {
        break label107;
      }
    }
    label107:
    for (int i = 0;; i = locala.hYK)
    {
      localb.hYK = i;
      AppMethodBeat.o(286213);
      return localb;
      l = locala.duration;
      break;
    }
  }
  
  public final FinderObject gpC()
  {
    Object localObject2 = null;
    AppMethodBeat.i(286223);
    if (this.oBZ)
    {
      AppMethodBeat.o(286223);
      return null;
    }
    Object localObject1 = this.LXe.objectDesc;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((FinderMedia)localObject1).width = this.videoWidth;
      }
      localObject1 = this.LXe.objectDesc;
      if (localObject1 != null) {
        break label146;
      }
      localObject1 = null;
      label62:
      if (localObject1 != null) {
        ((FinderMedia)localObject1).height = this.videoHeight;
      }
      localObject1 = this.LXe.objectDesc;
      if (localObject1 != null) {
        break label172;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((FinderMedia)localObject1).videoDuration = a.eH((float)this.durationMs / 1000.0F);
      }
      localObject1 = this.LXe;
      AppMethodBeat.o(286223);
      return localObject1;
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = (FinderMedia)((LinkedList)localObject1).get(0);
      break;
      label146:
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label62;
      }
      localObject1 = (FinderMedia)((LinkedList)localObject1).get(0);
      break label62;
      label172:
      LinkedList localLinkedList = ((FinderObjectDesc)localObject1).media;
      localObject1 = localObject2;
      if (localLinkedList != null) {
        localObject1 = (FinderMedia)localLinkedList.get(0);
      }
    }
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
 * Qualified Name:     com.tencent.mm.plugin.mv.model.e.i
 * JD-Core Version:    0.7.0.1
 */