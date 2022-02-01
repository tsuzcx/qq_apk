package RegisterProxySvcPack;

import java.io.Serializable;

public final class eNoticeFlag
  implements Serializable
{
  public static final eNoticeFlag NOTICE_MSG_END = new eNoticeFlag(0, 1, "NOTICE_MSG_END");
  public static final int _NOTICE_MSG_END = 1;
  private static eNoticeFlag[] a = new eNoticeFlag[1];
  private String __T = new String();
  private int __value;
  
  private eNoticeFlag(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static eNoticeFlag convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      eNoticeFlag[] arrayOfeNoticeFlag = a;
      if (i >= arrayOfeNoticeFlag.length) {
        break;
      }
      if (arrayOfeNoticeFlag[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static eNoticeFlag convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      eNoticeFlag[] arrayOfeNoticeFlag = a;
      if (i >= arrayOfeNoticeFlag.length) {
        break;
      }
      if (arrayOfeNoticeFlag[i].toString().equals(paramString)) {
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
 * Qualified Name:     RegisterProxySvcPack.eNoticeFlag
 * JD-Core Version:    0.7.0.1
 */