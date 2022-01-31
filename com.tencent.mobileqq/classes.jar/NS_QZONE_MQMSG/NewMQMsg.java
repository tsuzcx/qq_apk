package NS_QZONE_MQMSG;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class NewMQMsg
  extends JceStruct
{
  static ArrayList<single_feed> cache_all_feeds_data;
  static BottomCell cache_bottomCell;
  static Map<String, String> cache_mpExtent;
  static MsgBody cache_msgBody = new MsgBody();
  static MsgInteractData cache_msgInteractData = new MsgInteractData();
  static UserPersonalData cache_userPersonalData;
  public ArrayList<single_feed> all_feeds_data;
  public BottomCell bottomCell;
  public String jumpUrlToDetail = "";
  public Map<String, String> mpExtent;
  public MsgBody msgBody;
  public MsgInteractData msgInteractData;
  public int msgType;
  public String nick = "";
  public String promot = "";
  public long pushTime;
  public String title = "";
  public String userAvatar = "";
  public UserPersonalData userPersonalData;
  
  static
  {
    cache_bottomCell = new BottomCell();
    cache_mpExtent = new HashMap();
    cache_mpExtent.put("", "");
    cache_userPersonalData = new UserPersonalData();
    cache_all_feeds_data = new ArrayList();
    single_feed localsingle_feed = new single_feed();
    cache_all_feeds_data.add(localsingle_feed);
  }
  
  public NewMQMsg() {}
  
  public NewMQMsg(int paramInt, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, MsgBody paramMsgBody, MsgInteractData paramMsgInteractData, String paramString5, BottomCell paramBottomCell, Map<String, String> paramMap, UserPersonalData paramUserPersonalData, ArrayList<single_feed> paramArrayList)
  {
    this.msgType = paramInt;
    this.title = paramString1;
    this.pushTime = paramLong;
    this.userAvatar = paramString2;
    this.nick = paramString3;
    this.promot = paramString4;
    this.msgBody = paramMsgBody;
    this.msgInteractData = paramMsgInteractData;
    this.jumpUrlToDetail = paramString5;
    this.bottomCell = paramBottomCell;
    this.mpExtent = paramMap;
    this.userPersonalData = paramUserPersonalData;
    this.all_feeds_data = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.msgType = paramJceInputStream.read(this.msgType, 0, false);
    this.title = paramJceInputStream.readString(1, false);
    this.pushTime = paramJceInputStream.read(this.pushTime, 2, false);
    this.userAvatar = paramJceInputStream.readString(3, false);
    this.nick = paramJceInputStream.readString(4, false);
    this.promot = paramJceInputStream.readString(5, false);
    this.msgBody = ((MsgBody)paramJceInputStream.read(cache_msgBody, 6, false));
    this.msgInteractData = ((MsgInteractData)paramJceInputStream.read(cache_msgInteractData, 7, false));
    this.jumpUrlToDetail = paramJceInputStream.readString(8, false);
    this.bottomCell = ((BottomCell)paramJceInputStream.read(cache_bottomCell, 9, false));
    this.mpExtent = ((Map)paramJceInputStream.read(cache_mpExtent, 10, false));
    this.userPersonalData = ((UserPersonalData)paramJceInputStream.read(cache_userPersonalData, 11, false));
    this.all_feeds_data = ((ArrayList)paramJceInputStream.read(cache_all_feeds_data, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.msgType, 0);
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 1);
    }
    paramJceOutputStream.write(this.pushTime, 2);
    if (this.userAvatar != null) {
      paramJceOutputStream.write(this.userAvatar, 3);
    }
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 4);
    }
    if (this.promot != null) {
      paramJceOutputStream.write(this.promot, 5);
    }
    if (this.msgBody != null) {
      paramJceOutputStream.write(this.msgBody, 6);
    }
    if (this.msgInteractData != null) {
      paramJceOutputStream.write(this.msgInteractData, 7);
    }
    if (this.jumpUrlToDetail != null) {
      paramJceOutputStream.write(this.jumpUrlToDetail, 8);
    }
    if (this.bottomCell != null) {
      paramJceOutputStream.write(this.bottomCell, 9);
    }
    if (this.mpExtent != null) {
      paramJceOutputStream.write(this.mpExtent, 10);
    }
    if (this.userPersonalData != null) {
      paramJceOutputStream.write(this.userPersonalData, 11);
    }
    if (this.all_feeds_data != null) {
      paramJceOutputStream.write(this.all_feeds_data, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.NewMQMsg
 * JD-Core Version:    0.7.0.1
 */