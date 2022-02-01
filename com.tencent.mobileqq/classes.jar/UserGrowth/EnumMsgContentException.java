package UserGrowth;

import java.io.Serializable;

public final class EnumMsgContentException
  implements Serializable
{
  private static EnumMsgContentException[] __values = new EnumMsgContentException[7];
  public static final int _eCommentDel = 16;
  public static final int _eDescCommentDel = 64;
  public static final int _eFeedDel = 8;
  public static final int _eFeedHit = 2;
  public static final int _eFeedPrivate = 4;
  public static final int _eNotSupplement = 32;
  public static final int _eOperHit = 1;
  public static final EnumMsgContentException eCommentDel;
  public static final EnumMsgContentException eDescCommentDel = new EnumMsgContentException(6, 64, "eDescCommentDel");
  public static final EnumMsgContentException eFeedDel;
  public static final EnumMsgContentException eFeedHit;
  public static final EnumMsgContentException eFeedPrivate;
  public static final EnumMsgContentException eNotSupplement;
  public static final EnumMsgContentException eOperHit = new EnumMsgContentException(0, 1, "eOperHit");
  private String __T = new String();
  private int __value;
  
  static
  {
    eFeedHit = new EnumMsgContentException(1, 2, "eFeedHit");
    eFeedPrivate = new EnumMsgContentException(2, 4, "eFeedPrivate");
    eFeedDel = new EnumMsgContentException(3, 8, "eFeedDel");
    eCommentDel = new EnumMsgContentException(4, 16, "eCommentDel");
    eNotSupplement = new EnumMsgContentException(5, 32, "eNotSupplement");
  }
  
  private EnumMsgContentException(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static EnumMsgContentException convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EnumMsgContentException[] arrayOfEnumMsgContentException = __values;
      if (i >= arrayOfEnumMsgContentException.length) {
        break;
      }
      if (arrayOfEnumMsgContentException[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EnumMsgContentException convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EnumMsgContentException[] arrayOfEnumMsgContentException = __values;
      if (i >= arrayOfEnumMsgContentException.length) {
        break;
      }
      if (arrayOfEnumMsgContentException[i].toString().equals(paramString)) {
        return __values[i];
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
 * Qualified Name:     UserGrowth.EnumMsgContentException
 * JD-Core Version:    0.7.0.1
 */