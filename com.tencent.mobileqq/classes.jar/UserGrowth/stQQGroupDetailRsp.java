package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stQQGroupDetailRsp
  extends JceStruct
{
  public String msg = "";
  public String schema = "";
  public String signature = "";
  public int status = 0;
  
  public stQQGroupDetailRsp() {}
  
  public stQQGroupDetailRsp(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.status = paramInt;
    this.msg = paramString1;
    this.signature = paramString2;
    this.schema = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.status = paramJceInputStream.read(this.status, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.signature = paramJceInputStream.readString(2, false);
    this.schema = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.status, 0);
    String str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.signature;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.schema;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stQQGroupDetailRsp
 * JD-Core Version:    0.7.0.1
 */