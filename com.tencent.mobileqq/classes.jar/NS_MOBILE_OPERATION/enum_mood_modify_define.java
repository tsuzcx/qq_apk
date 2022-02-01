package NS_MOBILE_OPERATION;

import java.io.Serializable;

public final class enum_mood_modify_define
  implements Serializable
{
  private static enum_mood_modify_define[] __values = new enum_mood_modify_define[1];
  public static final int _enum_modify_content = 1;
  public static final int _enum_modify_ugcright = 2;
  public static final enum_mood_modify_define enum_modify_content = new enum_mood_modify_define(0, 1, "enum_modify_content");
  private String __T = new String();
  private int __value;
  
  private enum_mood_modify_define(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static enum_mood_modify_define convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      enum_mood_modify_define[] arrayOfenum_mood_modify_define = __values;
      if (i >= arrayOfenum_mood_modify_define.length) {
        break;
      }
      if (arrayOfenum_mood_modify_define[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static enum_mood_modify_define convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      enum_mood_modify_define[] arrayOfenum_mood_modify_define = __values;
      if (i >= arrayOfenum_mood_modify_define.length) {
        break;
      }
      if (arrayOfenum_mood_modify_define[i].toString().equals(paramString)) {
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
 * Qualified Name:     NS_MOBILE_OPERATION.enum_mood_modify_define
 * JD-Core Version:    0.7.0.1
 */