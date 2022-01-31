package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelGroup
  extends JceStruct
{
  public long dwGroupID;
  
  public DelGroup() {}
  
  public DelGroup(long paramLong)
  {
    this.dwGroupID = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupID = paramJceInputStream.read(this.dwGroupID, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupID, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     IMMsgBodyPack.DelGroup
 * JD-Core Version:    0.7.0.1
 */