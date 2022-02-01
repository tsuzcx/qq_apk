package QZONE_OPERATION_ENTRANCE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class EntranceRes
  extends JceStruct
{
  private static final long serialVersionUID = 0L;
  public long expireTime = 0L;
  public int limitCount = 0;
  public int loopCount = 0;
  public int oper = 0;
  public String resUrl = "";
  
  public EntranceRes() {}
  
  public EntranceRes(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.resUrl = paramString;
    this.expireTime = paramLong;
    this.oper = paramInt1;
    this.limitCount = paramInt2;
    this.loopCount = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.resUrl = paramJceInputStream.readString(0, false);
    this.expireTime = paramJceInputStream.read(this.expireTime, 1, false);
    this.oper = paramJceInputStream.read(this.oper, 2, false);
    this.limitCount = paramJceInputStream.read(this.limitCount, 3, false);
    this.loopCount = paramJceInputStream.read(this.loopCount, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.resUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.expireTime, 1);
    paramJceOutputStream.write(this.oper, 2);
    paramJceOutputStream.write(this.limitCount, 3);
    paramJceOutputStream.write(this.loopCount, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QZONE_OPERATION_ENTRANCE.EntranceRes
 * JD-Core Version:    0.7.0.1
 */