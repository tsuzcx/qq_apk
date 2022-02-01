package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ModGroupName
  extends JceStruct
{
  public long dwGroupID = 0L;
  public String strGroupName = "";
  
  public ModGroupName() {}
  
  public ModGroupName(long paramLong, String paramString)
  {
    this.dwGroupID = paramLong;
    this.strGroupName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupID = paramJceInputStream.read(this.dwGroupID, 0, false);
    this.strGroupName = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupID, 0);
    String str = this.strGroupName;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     IMMsgBodyPack.ModGroupName
 * JD-Core Version:    0.7.0.1
 */