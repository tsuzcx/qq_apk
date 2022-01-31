package RegisterProxySvcPack;

import java.io.Serializable;

public final class eRequestOptional
  implements Serializable
{
  public static final eRequestOptional IS_NEED_GETMSGV2;
  public static final eRequestOptional IS_NEED_PB_GETMSG;
  public static final eRequestOptional IS_NEED_PB_PULLDISPMSG;
  public static final eRequestOptional IS_NEED_PB_PULLGROUPMSG;
  public static final eRequestOptional IS_NEED_PULLDISMSG;
  public static final eRequestOptional IS_NEED_PULLGROUPMSG;
  public static final eRequestOptional IS_NEED_PULL_LIST_BY_SERVER;
  public static final eRequestOptional IS_NEED_PULL_PUBACCOUNT_MSG;
  public static final eRequestOptional IS_NEED_QUERY_EXT_ROAM_FLAG;
  public static final eRequestOptional IS_NEED_QUERY_IPWD_STAT;
  public static final eRequestOptional IS_NEED_QUERY_STRONG_ONLINE;
  public static final eRequestOptional IS_NEED_REGIST;
  public static final eRequestOptional IS_NEED_SAVE_TRAFFIC_OFF;
  public static final eRequestOptional IS_NEED_SAVE_TRAFFIC_ON;
  public static final eRequestOptional IS_NEED_STATUS_HB;
  public static final int _IS_NEED_GETMSGV2 = 2;
  public static final int _IS_NEED_PB_GETMSG = 64;
  public static final int _IS_NEED_PB_PULLDISPMSG = 256;
  public static final int _IS_NEED_PB_PULLGROUPMSG = 128;
  public static final int _IS_NEED_PULLDISMSG = 8;
  public static final int _IS_NEED_PULLGROUPMSG = 4;
  public static final int _IS_NEED_PULL_LIST_BY_SERVER = 16384;
  public static final int _IS_NEED_PULL_PUBACCOUNT_MSG = 8192;
  public static final int _IS_NEED_QUERY_EXT_ROAM_FLAG = 4096;
  public static final int _IS_NEED_QUERY_IPWD_STAT = 32;
  public static final int _IS_NEED_QUERY_STRONG_ONLINE = 1;
  public static final int _IS_NEED_REGIST = 16;
  public static final int _IS_NEED_SAVE_TRAFFIC_OFF = 1024;
  public static final int _IS_NEED_SAVE_TRAFFIC_ON = 512;
  public static final int _IS_NEED_STATUS_HB = 2048;
  private static eRequestOptional[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!eRequestOptional.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new eRequestOptional[13];
      IS_NEED_QUERY_STRONG_ONLINE = new eRequestOptional(0, 1, "IS_NEED_QUERY_STRONG_ONLINE");
      IS_NEED_GETMSGV2 = new eRequestOptional(1, 2, "IS_NEED_GETMSGV2");
      IS_NEED_PULLGROUPMSG = new eRequestOptional(2, 4, "IS_NEED_PULLGROUPMSG");
      IS_NEED_PULLDISMSG = new eRequestOptional(3, 8, "IS_NEED_PULLDISMSG");
      IS_NEED_REGIST = new eRequestOptional(4, 16, "IS_NEED_REGIST");
      IS_NEED_QUERY_IPWD_STAT = new eRequestOptional(5, 32, "IS_NEED_QUERY_IPWD_STAT");
      IS_NEED_PB_GETMSG = new eRequestOptional(6, 64, "IS_NEED_PB_GETMSG");
      IS_NEED_PB_PULLGROUPMSG = new eRequestOptional(7, 128, "IS_NEED_PB_PULLGROUPMSG");
      IS_NEED_PB_PULLDISPMSG = new eRequestOptional(8, 256, "IS_NEED_PB_PULLDISPMSG");
      IS_NEED_SAVE_TRAFFIC_ON = new eRequestOptional(9, 512, "IS_NEED_SAVE_TRAFFIC_ON");
      IS_NEED_SAVE_TRAFFIC_OFF = new eRequestOptional(10, 1024, "IS_NEED_SAVE_TRAFFIC_OFF");
      IS_NEED_STATUS_HB = new eRequestOptional(11, 2048, "IS_NEED_STATUS_HB");
      IS_NEED_QUERY_EXT_ROAM_FLAG = new eRequestOptional(12, 4096, "IS_NEED_QUERY_EXT_ROAM_FLAG");
      IS_NEED_PULL_PUBACCOUNT_MSG = new eRequestOptional(13, 8192, "IS_NEED_PULL_PUBACCOUNT_MSG");
      IS_NEED_PULL_LIST_BY_SERVER = new eRequestOptional(14, 16384, "IS_NEED_PULL_LIST_BY_SERVER");
      return;
    }
  }
  
  private eRequestOptional(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static eRequestOptional convert(int paramInt)
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
  
  public static eRequestOptional convert(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     RegisterProxySvcPack.eRequestOptional
 * JD-Core Version:    0.7.0.1
 */