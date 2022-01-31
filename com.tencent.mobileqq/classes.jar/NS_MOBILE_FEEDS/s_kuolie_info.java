package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_kuolie_info
  extends JceStruct
{
  public int iDays;
  public int iFrdFlag;
  public int iFrdsCnt;
  public int iLastNuanTime;
  public int iState;
  
  public s_kuolie_info() {}
  
  public s_kuolie_info(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.iFrdFlag = paramInt1;
    this.iFrdsCnt = paramInt2;
    this.iState = paramInt3;
    this.iDays = paramInt4;
    this.iLastNuanTime = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFrdFlag = paramJceInputStream.read(this.iFrdFlag, 0, false);
    this.iFrdsCnt = paramJceInputStream.read(this.iFrdsCnt, 1, false);
    this.iState = paramJceInputStream.read(this.iState, 2, false);
    this.iDays = paramJceInputStream.read(this.iDays, 3, false);
    this.iLastNuanTime = paramJceInputStream.read(this.iLastNuanTime, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFrdFlag, 0);
    paramJceOutputStream.write(this.iFrdsCnt, 1);
    paramJceOutputStream.write(this.iState, 2);
    paramJceOutputStream.write(this.iDays, 3);
    paramJceOutputStream.write(this.iLastNuanTime, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_kuolie_info
 * JD-Core Version:    0.7.0.1
 */