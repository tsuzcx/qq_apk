package MessageSvcPack;

import java.io.Serializable;

public final class MsgFilter
  implements Serializable
{
  public static final MsgFilter LIMIT_10_AND_IN_3_DAYS = new MsgFilter(1, 1, "LIMIT_10_AND_IN_3_DAYS");
  public static final MsgFilter NO_FILTER;
  public static final int _LIMIT_10_AND_IN_3_DAYS = 1;
  public static final int _NO_FILTER = 0;
  private static MsgFilter[] a = new MsgFilter[2];
  private String __T = new String();
  private int __value;
  
  static
  {
    NO_FILTER = new MsgFilter(0, 0, "NO_FILTER");
  }
  
  private MsgFilter(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static MsgFilter convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      MsgFilter[] arrayOfMsgFilter = a;
      if (i >= arrayOfMsgFilter.length) {
        break;
      }
      if (arrayOfMsgFilter[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static MsgFilter convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      MsgFilter[] arrayOfMsgFilter = a;
      if (i >= arrayOfMsgFilter.length) {
        break;
      }
      if (arrayOfMsgFilter[i].toString().equals(paramString)) {
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
 * Qualified Name:     MessageSvcPack.MsgFilter
 * JD-Core Version:    0.7.0.1
 */