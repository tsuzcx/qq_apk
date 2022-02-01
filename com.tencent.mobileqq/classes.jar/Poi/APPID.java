package Poi;

import java.io.Serializable;

public final class APPID
  implements Serializable
{
  public static final APPID QQ_HOST_COVER_WEATHER = new APPID(15, 100206, "QQ_HOST_COVER_WEATHER");
  public static final APPID QQ_HOST_WEATHER_DETAIL = new APPID(16, 100207, "QQ_HOST_WEATHER_DETAIL");
  public static final APPID QQ_PRESS_ADDBUTTON;
  public static final APPID QQ_PRESS_FRIENDFEED;
  public static final APPID QQ_PUBLISH_PHOTO;
  public static final APPID QQ_PUBLISH_SHUOSHUO;
  public static final APPID QQ_PUBLISH_SIGN = new APPID(17, 100208, "QQ_PUBLISH_SIGN");
  public static final APPID QQ_SWITCH_CLIENT = new APPID(18, 100209, "QQ_SWITCH_CLIENT");
  public static final APPID QQ_USE_WATERMARK;
  public static final APPID QZONE_FRIEND_COVER_WEATHER;
  public static final APPID QZONE_FRIEND_WEATHER_DETAIL;
  public static final APPID QZONE_HOST_COVER_WEATHER;
  public static final APPID QZONE_HOST_WEATHER_DETAIL;
  public static final APPID QZONE_PRESS_ADDBUTTON;
  public static final APPID QZONE_PUBLISH_PHOTO;
  public static final APPID QZONE_PUBLISH_SHUOSHUO;
  public static final APPID QZONE_PUBLISH_SIGN;
  public static final APPID QZONE_PUBLISH_VIDEO;
  public static final APPID QZONE_USE_WATERMARK;
  public static final int _QQ_HOST_COVER_WEATHER = 100206;
  public static final int _QQ_HOST_WEATHER_DETAIL = 100207;
  public static final int _QQ_PRESS_ADDBUTTON = 100202;
  public static final int _QQ_PRESS_FRIENDFEED = 100201;
  public static final int _QQ_PUBLISH_PHOTO = 100205;
  public static final int _QQ_PUBLISH_SHUOSHUO = 100203;
  public static final int _QQ_PUBLISH_SIGN = 100208;
  public static final int _QQ_SWITCH_CLIENT = 100209;
  public static final int _QQ_USE_WATERMARK = 100204;
  public static final int _QZONE_FRIEND_COVER_WEATHER = 100110;
  public static final int _QZONE_FRIEND_WEATHER_DETAIL = 100111;
  public static final int _QZONE_HOST_COVER_WEATHER = 100108;
  public static final int _QZONE_HOST_WEATHER_DETAIL = 100109;
  public static final int _QZONE_PRESS_ADDBUTTON = 100102;
  public static final int _QZONE_PUBLISH_PHOTO = 100106;
  public static final int _QZONE_PUBLISH_SHUOSHUO = 100103;
  public static final int _QZONE_PUBLISH_SIGN = 100104;
  public static final int _QZONE_PUBLISH_VIDEO = 100107;
  public static final int _QZONE_USE_WATERMARK = 100105;
  private static APPID[] a = new APPID[19];
  private String __T = new String();
  private int __value;
  
  static
  {
    QZONE_PRESS_ADDBUTTON = new APPID(0, 100102, "QZONE_PRESS_ADDBUTTON");
    QZONE_PUBLISH_SHUOSHUO = new APPID(1, 100103, "QZONE_PUBLISH_SHUOSHUO");
    QZONE_PUBLISH_SIGN = new APPID(2, 100104, "QZONE_PUBLISH_SIGN");
    QZONE_USE_WATERMARK = new APPID(3, 100105, "QZONE_USE_WATERMARK");
    QZONE_PUBLISH_PHOTO = new APPID(4, 100106, "QZONE_PUBLISH_PHOTO");
    QZONE_PUBLISH_VIDEO = new APPID(5, 100107, "QZONE_PUBLISH_VIDEO");
    QZONE_HOST_COVER_WEATHER = new APPID(6, 100108, "QZONE_HOST_COVER_WEATHER");
    QZONE_HOST_WEATHER_DETAIL = new APPID(7, 100109, "QZONE_HOST_WEATHER_DETAIL");
    QZONE_FRIEND_COVER_WEATHER = new APPID(8, 100110, "QZONE_FRIEND_COVER_WEATHER");
    QZONE_FRIEND_WEATHER_DETAIL = new APPID(9, 100111, "QZONE_FRIEND_WEATHER_DETAIL");
    QQ_PRESS_FRIENDFEED = new APPID(10, 100201, "QQ_PRESS_FRIENDFEED");
    QQ_PRESS_ADDBUTTON = new APPID(11, 100202, "QQ_PRESS_ADDBUTTON");
    QQ_PUBLISH_SHUOSHUO = new APPID(12, 100203, "QQ_PUBLISH_SHUOSHUO");
    QQ_USE_WATERMARK = new APPID(13, 100204, "QQ_USE_WATERMARK");
    QQ_PUBLISH_PHOTO = new APPID(14, 100205, "QQ_PUBLISH_PHOTO");
  }
  
  private APPID(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static APPID convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      APPID[] arrayOfAPPID = a;
      if (i >= arrayOfAPPID.length) {
        break;
      }
      if (arrayOfAPPID[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static APPID convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      APPID[] arrayOfAPPID = a;
      if (i >= arrayOfAPPID.length) {
        break;
      }
      if (arrayOfAPPID[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Poi.APPID
 * JD-Core Version:    0.7.0.1
 */