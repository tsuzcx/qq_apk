package com.tencent.mm.plugin.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "", "mediaId", "", "path", "url", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "decodeKey", "getDecodeKey", "()Ljava/lang/String;", "setDecodeKey", "(Ljava/lang/String;)V", "defaultVideo", "", "getDefaultVideo", "()Z", "setDefaultVideo", "(Z)V", "fileFormat", "getFileFormat", "setFileFormat", "getHeight", "()I", "setHeight", "(I)V", "isAlbumVideo", "setAlbumVideo", "isLocal", "setLocal", "loop", "getLoop", "setLoop", "getMediaId", "setMediaId", "getPath", "refObj", "getRefObj", "()Ljava/lang/Object;", "setRefObj", "(Ljava/lang/Object;)V", "reqFormat", "getReqFormat", "()Ljava/lang/Integer;", "setReqFormat", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "rotate", "getRotate", "setRotate", "scaleType", "getScaleType", "setScaleType", "thumbPath", "getThumbPath", "setThumbPath", "thumbUrl", "getThumbUrl", "setThumbUrl", "thumbUrlToken", "getThumbUrlToken", "setThumbUrlToken", "timeLengthInMvMs", "", "getTimeLengthInMvMs", "()J", "setTimeLengthInMvMs", "(J)V", "timeOffsetInClipMs", "getTimeOffsetInClipMs", "setTimeOffsetInClipMs", "timeOffsetInMvMs", "getTimeOffsetInMvMs", "setTimeOffsetInMvMs", "getUrl", "urlToken", "getUrlToken", "setUrlToken", "videoDuration", "getVideoDuration", "setVideoDuration", "videoFlag", "getVideoFlag", "setVideoFlag", "getWidth", "setWidth", "plugin-thumbplayer_release"})
public class d
{
  public Integer MSA;
  public boolean MSB;
  public String MSC;
  public boolean MSD;
  public long MSE;
  public long MSF;
  public long MSG;
  public Object MSH;
  public String decodeKey;
  public boolean fEF;
  public String fPD;
  public int fSM;
  public int height;
  public int kYn;
  public boolean loop;
  public String mediaId;
  public final String path;
  public long sTg;
  public String thumbPath;
  public String thumbUrl;
  public final String url;
  public String videoFlag;
  public int width;
  public String zZu;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190014);
    this.mediaId = paramString1;
    this.path = paramString2;
    this.url = paramString3;
    this.width = paramInt1;
    this.height = paramInt2;
    this.zZu = "";
    paramString1 = MMThumbPlayerTextureView.MUw;
    this.kYn = MMThumbPlayerTextureView.goY();
    this.thumbUrl = "";
    this.MSC = "";
    this.thumbPath = "";
    AppMethodBeat.o(190014);
  }
  
  public final void ON(String paramString)
  {
    AppMethodBeat.i(190010);
    p.k(paramString, "<set-?>");
    this.thumbPath = paramString;
    AppMethodBeat.o(190010);
  }
  
  public final void Oc(String paramString)
  {
    AppMethodBeat.i(190005);
    p.k(paramString, "<set-?>");
    this.thumbUrl = paramString;
    AppMethodBeat.o(190005);
  }
  
  public final void beR(String paramString)
  {
    AppMethodBeat.i(190003);
    p.k(paramString, "<set-?>");
    this.zZu = paramString;
    AppMethodBeat.o(190003);
  }
  
  public final void beS(String paramString)
  {
    AppMethodBeat.i(190007);
    p.k(paramString, "<set-?>");
    this.MSC = paramString;
    AppMethodBeat.o(190007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.d
 * JD-Core Version:    0.7.0.1
 */