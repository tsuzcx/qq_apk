package UserGrowth;

import java.io.Serializable;

public final class eFeedType
  implements Serializable
{
  private static eFeedType[] __values = new eFeedType[4];
  public static final int _eFeedTypeFriendFeeds = 4;
  public static final int _eFeedTypePerson = 1;
  public static final int _eFeedTypeSplitBlock = 3;
  public static final int _eFeedTypeVideo = 2;
  public static final eFeedType eFeedTypeFriendFeeds = new eFeedType(3, 4, "eFeedTypeFriendFeeds");
  public static final eFeedType eFeedTypePerson = new eFeedType(0, 1, "eFeedTypePerson");
  public static final eFeedType eFeedTypeSplitBlock;
  public static final eFeedType eFeedTypeVideo = new eFeedType(1, 2, "eFeedTypeVideo");
  private String __T = new String();
  private int __value;
  
  static
  {
    eFeedTypeSplitBlock = new eFeedType(2, 3, "eFeedTypeSplitBlock");
  }
  
  private eFeedType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eFeedType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      eFeedType[] arrayOfeFeedType = __values;
      if (i >= arrayOfeFeedType.length) {
        break;
      }
      if (arrayOfeFeedType[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static eFeedType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      eFeedType[] arrayOfeFeedType = __values;
      if (i >= arrayOfeFeedType.length) {
        break;
      }
      if (arrayOfeFeedType[i].toString().equals(paramString)) {
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
 * Qualified Name:     UserGrowth.eFeedType
 * JD-Core Version:    0.7.0.1
 */