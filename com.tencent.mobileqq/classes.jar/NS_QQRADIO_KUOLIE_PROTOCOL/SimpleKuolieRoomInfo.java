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
  public Map<String, String> extendInfo;
  public long favTime;
  public int isFav;
  public String logo = "";
  public String nickname = "";
  public long onlineNum;
  public String owner = "";
  public BackgroundColor roomColor;
  public String roomID = "";
  public String roomName = "";
  public int roomStatus;
  
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
    if (this.roomID != null) {
      paramJceOutputStream.write(this.roomID, 0);
    }
    if (this.roomName != null) {
      paramJceOutputStream.write(this.roomName, 1);
    }
    if (this.owner != null) {
      paramJceOutputStream.write(this.owner, 2);
    }
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 3);
    }
    if (this.logo != null) {
      paramJceOutputStream.write(this.logo, 4);
    }
    if (this.coverurl != null) {
      paramJceOutputStream.write(this.coverurl, 5);
    }
    if (this.backgroundPicUrl != null) {
      paramJceOutputStream.write(this.backgroundPicUrl, 6);
    }
    paramJceOutputStream.write(this.onlineNum, 7);
    paramJceOutputStream.write(this.isFav, 8);
    paramJceOutputStream.write(this.favTime, 9);
    paramJceOutputStream.write(this.roomStatus, 10);
    if (this.roomColor != null) {
      paramJceOutputStream.write(this.roomColor, 11);
    }
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.SimpleKuolieRoomInfo
 * JD-Core Version:    0.7.0.1
 */