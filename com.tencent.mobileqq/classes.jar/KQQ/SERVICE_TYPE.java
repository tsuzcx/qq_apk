package KQQ;

import java.io.Serializable;

public final class SERVICE_TYPE
  implements Serializable
{
  public static final SERVICE_TYPE ST_ADDRESS_LIST_STATE;
  public static final SERVICE_TYPE ST_APP_SDK_UPGRADE;
  public static final SERVICE_TYPE ST_DISGROUP_LIST;
  public static final SERVICE_TYPE ST_FMT_SERVERLIST;
  public static final SERVICE_TYPE ST_GAME_PLUGIN;
  public static final SERVICE_TYPE ST_GENERAL_SETTINGS;
  public static final SERVICE_TYPE ST_GROUP_MASK;
  public static final SERVICE_TYPE ST_HELLO_BLACK_LIST;
  public static final SERVICE_TYPE ST_NEIGHBOR_FEED;
  public static final SERVICE_TYPE ST_PLGUIN_LIST;
  public static final SERVICE_TYPE ST_QZONE_FEED;
  public static final SERVICE_TYPE ST_SELF_CARD;
  public static final SERVICE_TYPE ST_SELF_SIMPLE_INFO;
  public static final SERVICE_TYPE ST_SIGNATURE;
  public static final SERVICE_TYPE ST_TOKEN;
  public static final SERVICE_TYPE ST_USER_DEFINED_FACEID;
  public static final int _ST_ADDRESS_LIST_STATE = 19;
  public static final int _ST_APP_SDK_UPGRADE = 9;
  public static final int _ST_DISGROUP_LIST = 4;
  public static final int _ST_FMT_SERVERLIST = 16;
  public static final int _ST_GAME_PLUGIN = 22;
  public static final int _ST_GENERAL_SETTINGS = 21;
  public static final int _ST_GROUP_MASK = 6;
  public static final int _ST_HELLO_BLACK_LIST = 3;
  public static final int _ST_NEIGHBOR_FEED = 20;
  public static final int _ST_PLGUIN_LIST = 1;
  public static final int _ST_QZONE_FEED = 18;
  public static final int _ST_SELF_CARD = 2;
  public static final int _ST_SELF_SIMPLE_INFO = 5;
  public static final int _ST_SIGNATURE = 8;
  public static final int _ST_TOKEN = 17;
  public static final int _ST_USER_DEFINED_FACEID = 7;
  private static SERVICE_TYPE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!SERVICE_TYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new SERVICE_TYPE[16];
      ST_PLGUIN_LIST = new SERVICE_TYPE(0, 1, "ST_PLGUIN_LIST");
      ST_SELF_CARD = new SERVICE_TYPE(1, 2, "ST_SELF_CARD");
      ST_HELLO_BLACK_LIST = new SERVICE_TYPE(2, 3, "ST_HELLO_BLACK_LIST");
      ST_DISGROUP_LIST = new SERVICE_TYPE(3, 4, "ST_DISGROUP_LIST");
      ST_SELF_SIMPLE_INFO = new SERVICE_TYPE(4, 5, "ST_SELF_SIMPLE_INFO");
      ST_GROUP_MASK = new SERVICE_TYPE(5, 6, "ST_GROUP_MASK");
      ST_USER_DEFINED_FACEID = new SERVICE_TYPE(6, 7, "ST_USER_DEFINED_FACEID");
      ST_SIGNATURE = new SERVICE_TYPE(7, 8, "ST_SIGNATURE");
      ST_APP_SDK_UPGRADE = new SERVICE_TYPE(8, 9, "ST_APP_SDK_UPGRADE");
      ST_FMT_SERVERLIST = new SERVICE_TYPE(9, 16, "ST_FMT_SERVERLIST");
      ST_TOKEN = new SERVICE_TYPE(10, 17, "ST_TOKEN");
      ST_QZONE_FEED = new SERVICE_TYPE(11, 18, "ST_QZONE_FEED");
      ST_ADDRESS_LIST_STATE = new SERVICE_TYPE(12, 19, "ST_ADDRESS_LIST_STATE");
      ST_NEIGHBOR_FEED = new SERVICE_TYPE(13, 20, "ST_NEIGHBOR_FEED");
      ST_GENERAL_SETTINGS = new SERVICE_TYPE(14, 21, "ST_GENERAL_SETTINGS");
      ST_GAME_PLUGIN = new SERVICE_TYPE(15, 22, "ST_GAME_PLUGIN");
      return;
    }
  }
  
  private SERVICE_TYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static SERVICE_TYPE convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static SERVICE_TYPE convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     KQQ.SERVICE_TYPE
 * JD-Core Version:    0.7.0.1
 */