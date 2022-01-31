package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AddGroup
  extends JceStruct
{
  public long dwGroupID;
  public long dwSortID;
  public String strGroupName = "";
  
  public AddGroup() {}
  
  public AddGroup(long paramLong1, long paramLong2, String paramString)
  {
    this.dwGroupID = paramLong1;
    this.dwSortID = paramLong2;
    this.strGroupName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupID = paramJceInputStream.read(this.dwGroupID, 0, false);
    this.dwSortID = paramJceInputStream.read(this.dwSortID, 1, false);
    this.strGroupName = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupID, 0);
    paramJceOutputStream.write(this.dwSortID, 1);
    if (this.strGroupName != null) {
      paramJceOutputStream.write(this.strGroupName, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     IMMsgBodyPack.AddGroup
 * JD-Core Version:    0.7.0.1
 */