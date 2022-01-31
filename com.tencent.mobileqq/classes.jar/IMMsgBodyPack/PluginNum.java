package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PluginNum
  extends JceStruct
{
  public byte cFlag;
  public long dwID;
  public long dwNUm;
  
  public PluginNum() {}
  
  public PluginNum(long paramLong1, long paramLong2, byte paramByte)
  {
    this.dwID = paramLong1;
    this.dwNUm = paramLong2;
    this.cFlag = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwID = paramJceInputStream.read(this.dwID, 0, false);
    this.dwNUm = paramJceInputStream.read(this.dwNUm, 1, false);
    this.cFlag = paramJceInputStream.read(this.cFlag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwID, 0);
    paramJceOutputStream.write(this.dwNUm, 1);
    paramJceOutputStream.write(this.cFlag, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     IMMsgBodyPack.PluginNum
 * JD-Core Version:    0.7.0.1
 */