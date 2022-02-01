package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetReminderRsp
  extends JceStruct
{
  static ReminderInfo cache_stReminderInfo;
  public int iRet;
  public String sMsg = "";
  public ReminderInfo stReminderInfo;
  
  public GetReminderRsp() {}
  
  public GetReminderRsp(int paramInt, String paramString, ReminderInfo paramReminderInfo)
  {
    this.iRet = paramInt;
    this.sMsg = paramString;
    this.stReminderInfo = paramReminderInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.sMsg = paramJceInputStream.readString(1, true);
    if (cache_stReminderInfo == null) {
      cache_stReminderInfo = new ReminderInfo();
    }
    this.stReminderInfo = ((ReminderInfo)paramJceInputStream.read(cache_stReminderInfo, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.sMsg, 1);
    paramJceOutputStream.write(this.stReminderInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_VipReminderSvrProto.GetReminderRsp
 * JD-Core Version:    0.7.0.1
 */