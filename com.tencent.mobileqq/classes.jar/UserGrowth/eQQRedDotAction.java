package UserGrowth;

import java.io.Serializable;

public final class eQQRedDotAction
  implements Serializable
{
  private static eQQRedDotAction[] __values = new eQQRedDotAction[2];
  public static final int _eQQRedDotActionExpose = 2;
  public static final int _eQQRedDotActionRequest = 1;
  public static final eQQRedDotAction eQQRedDotActionExpose = new eQQRedDotAction(1, 2, "eQQRedDotActionExpose");
  public static final eQQRedDotAction eQQRedDotActionRequest = new eQQRedDotAction(0, 1, "eQQRedDotActionRequest");
  private String __T = new String();
  private int __value;
  
  private eQQRedDotAction(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eQQRedDotAction convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      eQQRedDotAction[] arrayOfeQQRedDotAction = __values;
      if (i >= arrayOfeQQRedDotAction.length) {
        break;
      }
      if (arrayOfeQQRedDotAction[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static eQQRedDotAction convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      eQQRedDotAction[] arrayOfeQQRedDotAction = __values;
      if (i >= arrayOfeQQRedDotAction.length) {
        break;
      }
      if (arrayOfeQQRedDotAction[i].toString().equals(paramString)) {
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
 * Qualified Name:     UserGrowth.eQQRedDotAction
 * JD-Core Version:    0.7.0.1
 */