package NeighborComm;

import java.io.Serializable;

public final class UserIdentityType
  implements Serializable
{
  public static final UserIdentityType UserIdentityType_Merchant = new UserIdentityType(1, 1, "UserIdentityType_Merchant");
  public static final UserIdentityType UserIdentityType_Nomal;
  public static final UserIdentityType UserIdentityType_Official = new UserIdentityType(2, 2, "UserIdentityType_Official");
  public static final int _UserIdentityType_Merchant = 1;
  public static final int _UserIdentityType_Nomal = 0;
  public static final int _UserIdentityType_Official = 2;
  private static UserIdentityType[] a = new UserIdentityType[3];
  private String __T = new String();
  private int __value;
  
  static
  {
    UserIdentityType_Nomal = new UserIdentityType(0, 0, "UserIdentityType_Nomal");
  }
  
  private UserIdentityType(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static UserIdentityType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      UserIdentityType[] arrayOfUserIdentityType = a;
      if (i >= arrayOfUserIdentityType.length) {
        break;
      }
      if (arrayOfUserIdentityType[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static UserIdentityType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      UserIdentityType[] arrayOfUserIdentityType = a;
      if (i >= arrayOfUserIdentityType.length) {
        break;
      }
      if (arrayOfUserIdentityType[i].toString().equals(paramString)) {
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
 * Qualified Name:     NeighborComm.UserIdentityType
 * JD-Core Version:    0.7.0.1
 */