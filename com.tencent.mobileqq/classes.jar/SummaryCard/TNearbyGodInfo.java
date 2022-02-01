package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TNearbyGodInfo
  extends JceStruct
{
  public int iIsGodFlag = 0;
  public String strJumpUrl = "";
  
  public TNearbyGodInfo() {}
  
  public TNearbyGodInfo(int paramInt, String paramString)
  {
    this.iIsGodFlag = paramInt;
    this.strJumpUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iIsGodFlag = paramJceInputStream.read(this.iIsGodFlag, 0, false);
    this.strJumpUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iIsGodFlag, 0);
    String str = this.strJumpUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.TNearbyGodInfo
 * JD-Core Version:    0.7.0.1
 */