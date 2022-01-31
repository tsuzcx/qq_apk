package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetRecommender
  extends JceStruct
{
  static int cache_eTimingType;
  static ReqUserInfo cache_stUserInfo;
  public int eTimingType = 0;
  public ReqUserInfo stUserInfo;
  
  public ReqGetRecommender() {}
  
  public ReqGetRecommender(ReqUserInfo paramReqUserInfo, int paramInt)
  {
    this.stUserInfo = paramReqUserInfo;
    this.eTimingType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 0, true));
    this.eTimingType = paramJceInputStream.read(this.eTimingType, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUserInfo, 0);
    paramJceOutputStream.write(this.eTimingType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     EncounterSvc.ReqGetRecommender
 * JD-Core Version:    0.7.0.1
 */