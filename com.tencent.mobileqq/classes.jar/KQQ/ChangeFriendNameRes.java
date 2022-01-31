package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ChangeFriendNameRes
  extends JceStruct
{
  public byte cResult;
  
  public ChangeFriendNameRes() {}
  
  public ChangeFriendNameRes(byte paramByte)
  {
    this.cResult = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cResult = paramJceInputStream.read(this.cResult, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cResult, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.ChangeFriendNameRes
 * JD-Core Version:    0.7.0.1
 */