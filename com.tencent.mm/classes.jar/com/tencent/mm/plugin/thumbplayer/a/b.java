package com.tencent.mm.plugin.thumbplayer.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  public int TBJ;
  public boolean TBK = false;
  public boolean TBL = false;
  public long TBM = 0L;
  public long TBN = 0L;
  public long TBO = 0L;
  public Object TBP = null;
  public String decodeKey;
  public boolean hJv;
  public String hVy = "";
  public int hYK = 0;
  public int height = 0;
  public boolean loop = false;
  public String mediaId = "";
  public String msf = "";
  public String msh = "";
  public int nDl = 0;
  public String path = "";
  public String thumbPath = "";
  public String thumbUrl = "";
  public String url = "";
  public long vYw = 0L;
  public String videoFlag = null;
  public int width = 0;
  
  public b() {}
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.mediaId = paramString1;
    this.path = paramString2;
    this.url = paramString3;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public String toString()
  {
    AppMethodBeat.i(272020);
    String str = "TPMediaInfo{urlToken='" + this.msf + '\'' + ", decodeKey='" + this.decodeKey + '\'' + ", isLocal=" + this.hJv + ", rotate=" + this.hYK + ", loop=" + this.loop + ", mediaId='" + this.mediaId + '\'' + ", path='" + this.path + '\'' + ", url='" + this.url + '\'' + ", width=" + this.width + ", height=" + this.height + '}';
    AppMethodBeat.o(272020);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.a.b
 * JD-Core Version:    0.7.0.1
 */