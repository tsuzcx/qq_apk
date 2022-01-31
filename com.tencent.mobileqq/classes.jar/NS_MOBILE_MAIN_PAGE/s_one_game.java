package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_one_game
  extends JceStruct
{
  public String strDesc = "";
  public String strGameUrl = "";
  public String strIconUrl = "";
  public long uCount;
  
  public s_one_game() {}
  
  public s_one_game(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.uCount = paramLong;
    this.strIconUrl = paramString1;
    this.strDesc = paramString2;
    this.strGameUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uCount = paramJceInputStream.read(this.uCount, 0, false);
    this.strIconUrl = paramJceInputStream.readString(1, false);
    this.strDesc = paramJceInputStream.readString(2, false);
    this.strGameUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uCount, 0);
    if (this.strIconUrl != null) {
      paramJceOutputStream.write(this.strIconUrl, 1);
    }
    if (this.strDesc != null) {
      paramJceOutputStream.write(this.strDesc, 2);
    }
    if (this.strGameUrl != null) {
      paramJceOutputStream.write(this.strGameUrl, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_one_game
 * JD-Core Version:    0.7.0.1
 */