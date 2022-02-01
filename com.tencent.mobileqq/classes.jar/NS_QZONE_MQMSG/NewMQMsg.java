package NS_QZONE_MQMSG;

import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
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
  static PostBar cache_postGuide = new PostBar();
  static UserPersonalData cache_userPersonalData;
  public ArrayList<single_feed> all_feeds_data = null;
  public BottomCell bottomCell = null;
  public String content = "";
  public int isNewStyle = 0;
  public String jumpUrlToDetail = "";
  public Map<String, String> mpExtent = null;
  public MsgBody msgBody = null;
  public MsgInteractData msgInteractData = null;
  public long msgSize = 0L;
  public int msgType = 0;
  public String nick = "";
  public PostBar postGuide = null;
  public String promot = "";
  public long pushTime = 0L;
  public String reportValue = "";
  public String title = "";
  public String userAvatar = "";
  public UserPersonalData userPersonalData = null;
  
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
  
  public NewMQMsg(int paramInt1, String paramString1, long paramLong1, String paramString2, String paramString3, String paramString4, MsgBody paramMsgBody, MsgInteractData paramMsgInteractData, String paramString5, BottomCell paramBottomCell, Map<String, String> paramMap, UserPersonalData paramUserPersonalData, ArrayList<single_feed> paramArrayList, String paramString6, String paramString7, long paramLong2, int paramInt2, PostBar paramPostBar)
  {
    this.msgType = paramInt1;
    this.title = paramString1;
    this.pushTime = paramLong1;
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
    this.reportValue = paramString6;
    this.content = paramString7;
    this.msgSize = paramLong2;
    this.isNewStyle = paramInt2;
    this.postGuide = paramPostBar;
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
    this.reportValue = paramJceInputStream.readString(13, false);
    this.content = paramJceInputStream.readString(14, false);
    this.msgSize = paramJceInputStream.read(this.msgSize, 15, false);
    this.isNewStyle = paramJceInputStream.read(this.isNewStyle, 16, false);
    this.postGuide = ((PostBar)paramJceInputStream.read(cache_postGuide, 17, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.msgType, 0);
    Object localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.pushTime, 2);
    localObject = this.userAvatar;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.nick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.promot;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.msgBody;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.msgInteractData;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.jumpUrlToDetail;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.bottomCell;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.mpExtent;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 10);
    }
    localObject = this.userPersonalData;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.all_feeds_data;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 12);
    }
    localObject = this.reportValue;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    paramJceOutputStream.write(this.msgSize, 15);
    paramJceOutputStream.write(this.isNewStyle, 16);
    localObject = this.postGuide;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.NewMQMsg
 * JD-Core Version:    0.7.0.1
 */