package KQQ;

import java.io.Serializable;

public final class BATCH_TYPE
  implements Serializable
{
  public static final BATCH_TYPE GROUP_PHOTO = new BATCH_TYPE(2, 2, "GROUP_PHOTO");
  public static final BATCH_TYPE NONE;
  public static final BATCH_TYPE OIDB2;
  public static final int _GROUP_PHOTO = 2;
  public static final int _NONE = 0;
  public static final int _OIDB2 = 1;
  private static BATCH_TYPE[] a = new BATCH_TYPE[3];
  private String __T = new String();
  private int __value;
  
  static
  {
    NONE = new BATCH_TYPE(0, 0, "NONE");
    OIDB2 = new BATCH_TYPE(1, 1, "OIDB2");
  }
  
  private BATCH_TYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static BATCH_TYPE convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      BATCH_TYPE[] arrayOfBATCH_TYPE = a;
      if (i >= arrayOfBATCH_TYPE.length) {
        break;
      }
      if (arrayOfBATCH_TYPE[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static BATCH_TYPE convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      BATCH_TYPE[] arrayOfBATCH_TYPE = a;
      if (i >= arrayOfBATCH_TYPE.length) {
        break;
      }
      if (arrayOfBATCH_TYPE[i].toString().equals(paramString)) {
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
 * Qualified Name:     KQQ.BATCH_TYPE
 * JD-Core Version:    0.7.0.1
 */