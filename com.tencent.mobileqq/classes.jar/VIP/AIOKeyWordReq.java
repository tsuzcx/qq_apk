package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AIOKeyWordReq
  extends JceStruct
{
  public String sMatchKey = "";
  public String sUin = "";
  
  public AIOKeyWordReq() {}
  
  public AIOKeyWordReq(String paramString1, String paramString2)
  {
    this.sUin = paramString1;
    this.sMatchKey = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sUin = paramJceInputStream.readString(0, true);
    this.sMatchKey = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sUin, 0);
    paramJceOutputStream.write(this.sMatchKey, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.AIOKeyWordReq
 * JD-Core Version:    0.7.0.1
 */