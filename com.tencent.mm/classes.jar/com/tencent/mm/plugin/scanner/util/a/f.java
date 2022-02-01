package com.tencent.mm.plugin.scanner.util.a;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressDefaultRequest;", "Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressRequest;", "imagePath", "", "session", "", "(Ljava/lang/String;J)V", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "getSession", "()J", "setSession", "(J)V", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class f
  implements g
{
  private long hBk;
  String imagePath;
  
  public f(String paramString, long paramLong)
  {
    this.imagePath = paramString;
    this.hBk = paramLong;
  }
  
  public final long bSj()
  {
    return this.hBk;
  }
  
  public final String gUr()
  {
    return this.imagePath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a.f
 * JD-Core Version:    0.7.0.1
 */