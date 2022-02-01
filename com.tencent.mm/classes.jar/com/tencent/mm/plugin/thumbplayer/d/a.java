package com.tencent.mm.plugin.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "", "mediaId", "", "path", "url", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "decodeKey", "getDecodeKey", "()Ljava/lang/String;", "setDecodeKey", "(Ljava/lang/String;)V", "defaultVideo", "", "getDefaultVideo", "()Z", "setDefaultVideo", "(Z)V", "fileFormat", "getFileFormat", "setFileFormat", "getHeight", "()I", "setHeight", "(I)V", "isLocal", "setLocal", "loop", "getLoop", "setLoop", "getMediaId", "getPath", "refObj", "getRefObj", "()Ljava/lang/Object;", "setRefObj", "(Ljava/lang/Object;)V", "reqFormat", "getReqFormat", "()Ljava/lang/Integer;", "setReqFormat", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "rotate", "getRotate", "setRotate", "scaleType", "getScaleType", "setScaleType", "thumbPath", "getThumbPath", "setThumbPath", "thumbUrl", "getThumbUrl", "setThumbUrl", "thumbUrlToken", "getThumbUrlToken", "setThumbUrlToken", "timeLengthInMvMs", "", "getTimeLengthInMvMs", "()J", "setTimeLengthInMvMs", "(J)V", "timeOffsetInClipMs", "getTimeOffsetInClipMs", "setTimeOffsetInClipMs", "timeOffsetInMvMs", "getTimeOffsetInMvMs", "setTimeOffsetInMvMs", "getUrl", "urlToken", "getUrlToken", "setUrlToken", "videoDuration", "getVideoDuration", "setVideoDuration", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "plugin-thumbplayer_release"})
public final class a
{
  public Integer Ghr;
  public String Ghs;
  public boolean Ght;
  public long Ghu;
  public long Ghv;
  public long Ghw;
  public Object Ghx;
  public boolean dLQ;
  public String dVY;
  public int dYT;
  public String decodeKey;
  public int height;
  public boolean loop;
  public final String mediaId;
  public long pLQ;
  public final String path;
  public int scaleType;
  public String thumbPath;
  public String thumbUrl;
  public final String url;
  public String viB;
  public int width;
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238677);
    this.mediaId = paramString1;
    this.path = paramString2;
    this.url = paramString3;
    this.width = paramInt1;
    this.height = paramInt2;
    this.viB = "";
    paramString1 = MMThumbPlayerTextureView.GiC;
    this.scaleType = MMThumbPlayerTextureView.fxh();
    this.thumbUrl = "";
    this.Ghs = "";
    this.thumbPath = "";
    AppMethodBeat.o(238677);
  }
  
  public final void GR(String paramString)
  {
    AppMethodBeat.i(238675);
    p.h(paramString, "<set-?>");
    this.thumbUrl = paramString;
    AppMethodBeat.o(238675);
  }
  
  public final void aTt(String paramString)
  {
    AppMethodBeat.i(238674);
    p.h(paramString, "<set-?>");
    this.viB = paramString;
    AppMethodBeat.o(238674);
  }
  
  public final void aTu(String paramString)
  {
    AppMethodBeat.i(238676);
    p.h(paramString, "<set-?>");
    this.Ghs = paramString;
    AppMethodBeat.o(238676);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238680);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(this.mediaId, paramObject.mediaId)) || (!p.j(this.path, paramObject.path)) || (!p.j(this.url, paramObject.url)) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
      }
    }
    else
    {
      AppMethodBeat.o(238680);
      return true;
    }
    AppMethodBeat.o(238680);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(238679);
    String str = this.mediaId;
    int i;
    if (str != null)
    {
      i = str.hashCode();
      str = this.path;
      if (str == null) {
        break label104;
      }
    }
    label104:
    for (int j = str.hashCode();; j = 0)
    {
      str = this.url;
      if (str != null) {
        k = str.hashCode();
      }
      int m = this.width;
      int n = this.height;
      AppMethodBeat.o(238679);
      return (((j + i * 31) * 31 + k) * 31 + m) * 31 + n;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(238678);
    String str = "TPMediaInfo(mediaId=" + this.mediaId + ", path=" + this.path + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ")";
    AppMethodBeat.o(238678);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.a
 * JD-Core Version:    0.7.0.1
 */