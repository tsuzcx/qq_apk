package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stNotifyMsg
  extends JceStruct
{
  static stMsgContentAssociateInfo cache_associate = new stMsgContentAssociateInfo();
  static stMsgContent cache_content = new stMsgContent();
  static stMsgContentPersonInfo cache_oper = new stMsgContentPersonInfo();
  public stMsgContentAssociateInfo associate = null;
  public stMsgContent content = null;
  public String contentFeedID = "";
  public long createTime = 0L;
  public int delFlag = 0;
  public int flag = 0;
  public String msgID = "";
  public stMsgContentPersonInfo oper = null;
  
  public stNotifyMsg() {}
  
  public stNotifyMsg(String paramString1, stMsgContent paramstMsgContent, int paramInt1, stMsgContentPersonInfo paramstMsgContentPersonInfo, String paramString2, stMsgContentAssociateInfo paramstMsgContentAssociateInfo, long paramLong, int paramInt2)
  {
    this.msgID = paramString1;
    this.content = paramstMsgContent;
    this.flag = paramInt1;
    this.oper = paramstMsgContentPersonInfo;
    this.contentFeedID = paramString2;
    this.associate = paramstMsgContentAssociateInfo;
    this.createTime = paramLong;
    this.delFlag = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.msgID = paramJceInputStream.readString(0, false);
    this.content = ((stMsgContent)paramJceInputStream.read(cache_content, 1, false));
    this.flag = paramJceInputStream.read(this.flag, 2, false);
    this.oper = ((stMsgContentPersonInfo)paramJceInputStream.read(cache_oper, 3, false));
    this.contentFeedID = paramJceInputStream.readString(4, false);
    this.associate = ((stMsgContentAssociateInfo)paramJceInputStream.read(cache_associate, 5, false));
    this.createTime = paramJceInputStream.read(this.createTime, 6, false);
    this.delFlag = paramJceInputStream.read(this.delFlag, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.msgID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    paramJceOutputStream.write(this.flag, 2);
    localObject = this.oper;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.contentFeedID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.associate;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.createTime, 6);
    paramJceOutputStream.write(this.delFlag, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stNotifyMsg
 * JD-Core Version:    0.7.0.1
 */