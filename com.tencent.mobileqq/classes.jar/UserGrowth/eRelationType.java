package UserGrowth;

import java.io.Serializable;

public final class eRelationType
  implements Serializable
{
  private static eRelationType[] __values = new eRelationType[3];
  public static final int _eRelationTypeMajorFriend = 1;
  public static final int _eRelationTypeMinorFriend = 2;
  public static final int _eRelationTypeNotFriend = 0;
  public static final eRelationType eRelationTypeMajorFriend = new eRelationType(1, 1, "eRelationTypeMajorFriend");
  public static final eRelationType eRelationTypeMinorFriend = new eRelationType(2, 2, "eRelationTypeMinorFriend");
  public static final eRelationType eRelationTypeNotFriend = new eRelationType(0, 0, "eRelationTypeNotFriend");
  private String __T = new String();
  private int __value;
  
  private eRelationType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eRelationType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      eRelationType[] arrayOfeRelationType = __values;
      if (i >= arrayOfeRelationType.length) {
        break;
      }
      if (arrayOfeRelationType[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static eRelationType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      eRelationType[] arrayOfeRelationType = __values;
      if (i >= arrayOfeRelationType.length) {
        break;
      }
      if (arrayOfeRelationType[i].toString().equals(paramString)) {
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
 * Qualified Name:     UserGrowth.eRelationType
 * JD-Core Version:    0.7.0.1
 */