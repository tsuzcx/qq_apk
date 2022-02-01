package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ActYellowDiamond
  extends JceStruct
{
  public int iTenYearUser = 0;
  public String strPicZip = "";
  
  public ActYellowDiamond() {}
  
  public ActYellowDiamond(int paramInt, String paramString)
  {
    this.iTenYearUser = paramInt;
    this.strPicZip = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTenYearUser = paramJceInputStream.read(this.iTenYearUser, 0, false);
    this.strPicZip = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTenYearUser, 0);
    if (this.strPicZip != null) {
      paramJceOutputStream.write(this.strPicZip, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.ActYellowDiamond
 * JD-Core Version:    0.7.0.1
 */