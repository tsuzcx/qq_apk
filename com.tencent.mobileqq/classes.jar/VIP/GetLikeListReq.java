package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetLikeListReq
  extends JceStruct
{
  static SourceInfo cache_stSource = new SourceInfo();
  public long iNum = 0L;
  public long iUin = 0L;
  public String sCookie = "";
  public SourceInfo stSource = null;
  
  public GetLikeListReq() {}
  
  public GetLikeListReq(long paramLong1, String paramString, long paramLong2, SourceInfo paramSourceInfo)
  {
    this.iUin = paramLong1;
    this.sCookie = paramString;
    this.iNum = paramLong2;
    this.stSource = paramSourceInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
    this.sCookie = paramJceInputStream.readString(1, false);
    this.iNum = paramJceInputStream.read(this.iNum, 2, false);
    this.stSource = ((SourceInfo)paramJceInputStream.read(cache_stSource, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    if (this.sCookie != null) {
      paramJceOutputStream.write(this.sCookie, 1);
    }
    paramJceOutputStream.write(this.iNum, 2);
    if (this.stSource != null) {
      paramJceOutputStream.write(this.stSource, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.GetLikeListReq
 * JD-Core Version:    0.7.0.1
 */