package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespUpdateIntro
  extends JceStruct
{
  static RespHead cache_stHeader;
  public RespHead stHeader = null;
  
  public RespUpdateIntro() {}
  
  public RespUpdateIntro(RespHead paramRespHead)
  {
    this.stHeader = paramRespHead;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.RespUpdateIntro
 * JD-Core Version:    0.7.0.1
 */