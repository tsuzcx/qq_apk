package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetGroupRedPackListRsp
  extends JceStruct
{
  static ArrayList cache_vecRedPackList = new ArrayList();
  public int iRedPackNum;
  public int iRetCode;
  public long lFailureTime;
  public ArrayList vecRedPackList;
  
  static
  {
    RedPackGrapInfo localRedPackGrapInfo = new RedPackGrapInfo();
    cache_vecRedPackList.add(localRedPackGrapInfo);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRetCode = paramJceInputStream.read(this.iRetCode, 0, false);
    this.iRedPackNum = paramJceInputStream.read(this.iRedPackNum, 1, false);
    this.vecRedPackList = ((ArrayList)paramJceInputStream.read(cache_vecRedPackList, 2, false));
    this.lFailureTime = paramJceInputStream.read(this.lFailureTime, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRetCode, 0);
    paramJceOutputStream.write(this.iRedPackNum, 1);
    if (this.vecRedPackList != null) {
      paramJceOutputStream.write(this.vecRedPackList, 2);
    }
    paramJceOutputStream.write(this.lFailureTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.GetGroupRedPackListRsp
 * JD-Core Version:    0.7.0.1
 */