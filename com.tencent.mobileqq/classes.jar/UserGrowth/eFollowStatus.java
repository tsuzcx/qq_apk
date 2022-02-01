package UserGrowth;

import java.io.Serializable;

public final class eFollowStatus
  implements Serializable
{
  private static eFollowStatus[] __values = new eFollowStatus[5];
  public static final int _eStatusBidirectFollow = 3;
  public static final int _eStatusDoesNotFollow = 2;
  public static final int _eStatusHasFollow = 1;
  public static final int _eStatusHasReverseFollow = 4;
  public static final int _eStatusNoFollow = 0;
  public static final eFollowStatus eStatusBidirectFollow = new eFollowStatus(3, 3, "eStatusBidirectFollow");
  public static final eFollowStatus eStatusDoesNotFollow;
  public static final eFollowStatus eStatusHasFollow;
  public static final eFollowStatus eStatusHasReverseFollow = new eFollowStatus(4, 4, "eStatusHasReverseFollow");
  public static final eFollowStatus eStatusNoFollow = new eFollowStatus(0, 0, "eStatusNoFollow");
  private String __T = new String();
  private int __value;
  
  static
  {
    eStatusHasFollow = new eFollowStatus(1, 1, "eStatusHasFollow");
    eStatusDoesNotFollow = new eFollowStatus(2, 2, "eStatusDoesNotFollow");
  }
  
  private eFollowStatus(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static eFollowStatus convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      eFollowStatus[] arrayOfeFollowStatus = __values;
      if (i >= arrayOfeFollowStatus.length) {
        break;
      }
      if (arrayOfeFollowStatus[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static eFollowStatus convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      eFollowStatus[] arrayOfeFollowStatus = __values;
      if (i >= arrayOfeFollowStatus.length) {
        break;
      }
      if (arrayOfeFollowStatus[i].toString().equals(paramString)) {
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
 * Qualified Name:     UserGrowth.eFollowStatus
 * JD-Core Version:    0.7.0.1
 */