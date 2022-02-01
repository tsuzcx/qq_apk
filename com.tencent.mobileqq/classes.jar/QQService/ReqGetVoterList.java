package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetVoterList
  extends JceStruct
{
  static ReqHead cache_stHeader;
  static UserCntlData cache_stUserData;
  public int iPageSize = -1;
  public ReqHead stHeader = null;
  public UserCntlData stUserData = null;
  
  public ReqGetVoterList() {}
  
  public ReqGetVoterList(ReqHead paramReqHead, UserCntlData paramUserCntlData, int paramInt)
  {
    this.stHeader = paramReqHead;
    this.stUserData = paramUserCntlData;
    this.iPageSize = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stUserData == null) {
      cache_stUserData = new UserCntlData();
    }
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 1, false));
    this.iPageSize = paramJceInputStream.read(this.iPageSize, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    UserCntlData localUserCntlData = this.stUserData;
    if (localUserCntlData != null) {
      paramJceOutputStream.write(localUserCntlData, 1);
    }
    paramJceOutputStream.write(this.iPageSize, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.ReqGetVoterList
 * JD-Core Version:    0.7.0.1
 */