package UserGrowth;

import java.io.Serializable;

public final class EnumMsgContentTemplate
  implements Serializable
{
  private static EnumMsgContentTemplate[] __values = new EnumMsgContentTemplate[4];
  public static final int _eHasBtnAndHasPic = 4;
  public static final int _eHasBtnAndNoPic = 3;
  public static final int _eNoBtnAndHasPic = 2;
  public static final int _eNoBtnAndNoPic = 1;
  public static final EnumMsgContentTemplate eHasBtnAndHasPic = new EnumMsgContentTemplate(3, 4, "eHasBtnAndHasPic");
  public static final EnumMsgContentTemplate eHasBtnAndNoPic;
  public static final EnumMsgContentTemplate eNoBtnAndHasPic;
  public static final EnumMsgContentTemplate eNoBtnAndNoPic = new EnumMsgContentTemplate(0, 1, "eNoBtnAndNoPic");
  private String __T = new String();
  private int __value;
  
  static
  {
    eNoBtnAndHasPic = new EnumMsgContentTemplate(1, 2, "eNoBtnAndHasPic");
    eHasBtnAndNoPic = new EnumMsgContentTemplate(2, 3, "eHasBtnAndNoPic");
  }
  
  private EnumMsgContentTemplate(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static EnumMsgContentTemplate convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EnumMsgContentTemplate[] arrayOfEnumMsgContentTemplate = __values;
      if (i >= arrayOfEnumMsgContentTemplate.length) {
        break;
      }
      if (arrayOfEnumMsgContentTemplate[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EnumMsgContentTemplate convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EnumMsgContentTemplate[] arrayOfEnumMsgContentTemplate = __values;
      if (i >= arrayOfEnumMsgContentTemplate.length) {
        break;
      }
      if (arrayOfEnumMsgContentTemplate[i].toString().equals(paramString)) {
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
 * Qualified Name:     UserGrowth.EnumMsgContentTemplate
 * JD-Core Version:    0.7.0.1
 */