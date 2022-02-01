package UserGrowth;

import java.io.Serializable;

public final class EnumMsgCategory
  implements Serializable
{
  private static EnumMsgCategory[] __values = new EnumMsgCategory[7];
  public static final int _eCommentType = 7;
  public static final int _eDingType = 2;
  public static final int _eFollowType = 4;
  public static final int _eFrdTAb = 6;
  public static final int _ePriMsgType = 5;
  public static final int _eRelatedToMeType = 1;
  public static final int _eRichDingType = 3;
  public static final EnumMsgCategory eCommentType = new EnumMsgCategory(6, 7, "eCommentType");
  public static final EnumMsgCategory eDingType;
  public static final EnumMsgCategory eFollowType;
  public static final EnumMsgCategory eFrdTAb;
  public static final EnumMsgCategory ePriMsgType;
  public static final EnumMsgCategory eRelatedToMeType = new EnumMsgCategory(0, 1, "eRelatedToMeType");
  public static final EnumMsgCategory eRichDingType;
  private String __T = new String();
  private int __value;
  
  static
  {
    eDingType = new EnumMsgCategory(1, 2, "eDingType");
    eRichDingType = new EnumMsgCategory(2, 3, "eRichDingType");
    eFollowType = new EnumMsgCategory(3, 4, "eFollowType");
    ePriMsgType = new EnumMsgCategory(4, 5, "ePriMsgType");
    eFrdTAb = new EnumMsgCategory(5, 6, "eFrdTAb");
  }
  
  private EnumMsgCategory(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static EnumMsgCategory convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EnumMsgCategory[] arrayOfEnumMsgCategory = __values;
      if (i >= arrayOfEnumMsgCategory.length) {
        break;
      }
      if (arrayOfEnumMsgCategory[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EnumMsgCategory convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EnumMsgCategory[] arrayOfEnumMsgCategory = __values;
      if (i >= arrayOfEnumMsgCategory.length) {
        break;
      }
      if (arrayOfEnumMsgCategory[i].toString().equals(paramString)) {
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
 * Qualified Name:     UserGrowth.EnumMsgCategory
 * JD-Core Version:    0.7.0.1
 */