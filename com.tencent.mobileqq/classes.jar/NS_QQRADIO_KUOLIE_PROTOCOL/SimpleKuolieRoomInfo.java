package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SimpleKuolieRoomInfo
  extends JceStruct
{
  static Map<String, String> cache_extendInfo;
  static BackgroundColor cache_roomColor = new BackgroundColor();
  public String backgroundPicUrl = "";
  public String coverurl = "";
  public Map<String, String> extendInfo = null;
  public long favTime = 0L;
  public int isFav = 0;
  public String logo = "";
  public String nickname = "";
  public long onlineNum = 0L;
  public String owner = "";
  public BackgroundColor roomColor = null;
  public String roomID = "";
  public String roomName = "";
  public int roomStatus = 0;
  
  static
  {
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
  }
  
  public SimpleKuolieRoomInfo() {}
  
  public SimpleKuolieRoomInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong1, int paramInt1, long paramLong2, int paramInt2, BackgroundColor paramBackgroundColor, Map<String, String> paramMap)
  {
    this.roomID = paramString1;
    this.roomName = paramString2;
    this.owner = paramString3;
    this.nickname = paramString4;
    this.logo = paramString5;
    this.coverurl = paramString6;
    this.backgroundPicUrl = paramString7;
    this.onlineNum = paramLong1;
    this.isFav = paramInt1;
    this.favTime = paramLong2;
    this.roomStatus = paramInt2;
    this.roomColor = paramBackgroundColor;
    this.extendInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.roomID = paramJceInputStream.readString(0, false);
    this.roomName = paramJceInputStream.readString(1, false);
    this.owner = paramJceInputStream.readString(2, false);
    this.nickname = paramJceInputStream.readString(3, false);
    this.logo = paramJceInputStream.readString(4, false);
    this.coverurl = paramJceInputStream.readString(5, false);
    this.backgroundPicUrl = paramJceInputStream.readString(6, false);
    this.onlineNum = paramJceInputStream.read(this.onlineNum, 7, false);
    this.isFav = paramJceInputStream.read(this.isFav, 8, false);
    this.favTime = paramJceInputStream.read(this.favTime, 9, false);
    this.roomStatus = paramJceInputStream.read(this.roomStatus, 10, false);
    this.roomColor = ((BackgroundColor)paramJceInputStream.read(cache_roomColor, 11, false));
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.roomID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.roomName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.owner;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.nickname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.logo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.coverurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.backgroundPicUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.onlineNum, 7);
    paramJceOutputStream.write(this.isFav, 8);
    paramJceOutputStream.write(this.favTime, 9);
    paramJceOutputStream.write(this.roomStatus, 10);
    localObject = this.roomColor;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.extendInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.SimpleKuolieRoomInfo
 * JD-Core Version:    0.7.0.1
 */