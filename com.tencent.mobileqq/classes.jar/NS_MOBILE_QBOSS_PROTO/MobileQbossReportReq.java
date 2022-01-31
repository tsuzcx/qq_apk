package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MobileQbossReportReq
  extends JceStruct
{
  static ArrayList<tMobileQbossFeedBackInfo> cache_vecMobileQbossFeedBackInfo;
  public ArrayList<tMobileQbossFeedBackInfo> vecMobileQbossFeedBackInfo;
  
  public MobileQbossReportReq() {}
  
  public MobileQbossReportReq(ArrayList<tMobileQbossFeedBackInfo> paramArrayList)
  {
    this.vecMobileQbossFeedBackInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecMobileQbossFeedBackInfo == null)
    {
      cache_vecMobileQbossFeedBackInfo = new ArrayList();
      tMobileQbossFeedBackInfo localtMobileQbossFeedBackInfo = new tMobileQbossFeedBackInfo();
      cache_vecMobileQbossFeedBackInfo.add(localtMobileQbossFeedBackInfo);
    }
    this.vecMobileQbossFeedBackInfo = ((ArrayList)paramJceInputStream.read(cache_vecMobileQbossFeedBackInfo, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecMobileQbossFeedBackInfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_QBOSS_PROTO.MobileQbossReportReq
 * JD-Core Version:    0.7.0.1
 */