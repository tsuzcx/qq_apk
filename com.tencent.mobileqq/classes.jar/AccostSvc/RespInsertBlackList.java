package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespInsertBlackList
  extends JceStruct
{
  static RespHeader cache_stHeader;
  public RespHeader stHeader = null;
  
  public RespInsertBlackList() {}
  
  public RespInsertBlackList(RespHeader paramRespHeader)
  {
    this.stHeader = paramRespHeader;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     AccostSvc.RespInsertBlackList
 * JD-Core Version:    0.7.0.1
 */