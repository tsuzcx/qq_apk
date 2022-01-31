package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_PrdData
  extends JceStruct
{
  public int iType;
  public String strColorBegin = "";
  public String strColorEnd = "";
  public String strResUrl = "";
  
  public s_PrdData() {}
  
  public s_PrdData(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.iType = paramInt;
    this.strResUrl = paramString1;
    this.strColorBegin = paramString2;
    this.strColorEnd = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, false);
    this.strResUrl = paramJceInputStream.readString(1, false);
    this.strColorBegin = paramJceInputStream.readString(2, false);
    this.strColorEnd = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    if (this.strResUrl != null) {
      paramJceOutputStream.write(this.strResUrl, 1);
    }
    if (this.strColorBegin != null) {
      paramJceOutputStream.write(this.strColorBegin, 2);
    }
    if (this.strColorEnd != null) {
      paramJceOutputStream.write(this.strColorEnd, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_PrdData
 * JD-Core Version:    0.7.0.1
 */