package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class StrangerSkin
  extends JceStruct
{
  public int iItemId = -1;
  public String strImageUrl = "";
  public String strJumpUrl = "";
  public String strTextColor1 = "";
  public String strTextColor2 = "";
  
  public StrangerSkin() {}
  
  public StrangerSkin(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.strImageUrl = paramString1;
    this.strTextColor1 = paramString2;
    this.strTextColor2 = paramString3;
    this.iItemId = paramInt;
    this.strJumpUrl = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strImageUrl = paramJceInputStream.readString(0, false);
    this.strTextColor1 = paramJceInputStream.readString(1, false);
    this.strTextColor2 = paramJceInputStream.readString(2, false);
    this.iItemId = paramJceInputStream.read(this.iItemId, 3, false);
    this.strJumpUrl = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strImageUrl != null) {
      paramJceOutputStream.write(this.strImageUrl, 0);
    }
    if (this.strTextColor1 != null) {
      paramJceOutputStream.write(this.strTextColor1, 1);
    }
    if (this.strTextColor2 != null) {
      paramJceOutputStream.write(this.strTextColor2, 2);
    }
    paramJceOutputStream.write(this.iItemId, 3);
    if (this.strJumpUrl != null) {
      paramJceOutputStream.write(this.strJumpUrl, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.StrangerSkin
 * JD-Core Version:    0.7.0.1
 */