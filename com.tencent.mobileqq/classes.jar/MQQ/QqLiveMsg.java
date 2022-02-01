package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QqLiveMsg
  extends JceStruct
{
  public String ShopPicUrl = "";
  public String ShopText = "";
  public String anchorUrl = "";
  public String anchorUrlMd5 = "";
  public int isPreload = 0;
  public int isShopEntrance = 0;
  public String plus_text = "";
  public String recomm_room_schema = "";
  public String recomm_roomid = "";
  public String viewerUrl = "";
  public String viewerUrlMd5 = "";
  
  public QqLiveMsg() {}
  
  public QqLiveMsg(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.anchorUrl = paramString1;
    this.anchorUrlMd5 = paramString2;
    this.viewerUrl = paramString3;
    this.viewerUrlMd5 = paramString4;
    this.isPreload = paramInt1;
    this.isShopEntrance = paramInt2;
    this.ShopText = paramString5;
    this.ShopPicUrl = paramString6;
    this.plus_text = paramString7;
    this.recomm_roomid = paramString8;
    this.recomm_room_schema = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.anchorUrl = paramJceInputStream.readString(0, false);
    this.anchorUrlMd5 = paramJceInputStream.readString(1, false);
    this.viewerUrl = paramJceInputStream.readString(2, false);
    this.viewerUrlMd5 = paramJceInputStream.readString(3, false);
    this.isPreload = paramJceInputStream.read(this.isPreload, 4, false);
    this.isShopEntrance = paramJceInputStream.read(this.isShopEntrance, 5, false);
    this.ShopText = paramJceInputStream.readString(6, false);
    this.ShopPicUrl = paramJceInputStream.readString(7, false);
    this.plus_text = paramJceInputStream.readString(8, false);
    this.recomm_roomid = paramJceInputStream.readString(9, false);
    this.recomm_room_schema = paramJceInputStream.readString(10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.anchorUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.anchorUrlMd5;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.viewerUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.viewerUrlMd5;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.isPreload, 4);
    paramJceOutputStream.write(this.isShopEntrance, 5);
    str = this.ShopText;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.ShopPicUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.plus_text;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.recomm_roomid;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.recomm_room_schema;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.QqLiveMsg
 * JD-Core Version:    0.7.0.1
 */