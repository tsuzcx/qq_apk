package ResPackage;

import java.io.Serializable;

public final class ResourceID
  implements Serializable
{
  public static final ResourceID RES_AVATARURL;
  public static final ResourceID RES_BANNERIMG = new ResourceID(4, 4, "RES_BANNERIMG");
  public static final ResourceID RES_CHATAVATAR;
  public static final ResourceID RES_INIT;
  public static final ResourceID RES_USEDAVATAR;
  public static final int _RES_AVATARURL = 2;
  public static final int _RES_BANNERIMG = 4;
  public static final int _RES_CHATAVATAR = 1;
  public static final int _RES_INIT = 0;
  public static final int _RES_USEDAVATAR = 3;
  private static ResourceID[] a = new ResourceID[5];
  private String __T = new String();
  private int __value;
  
  static
  {
    RES_INIT = new ResourceID(0, 0, "RES_INIT");
    RES_CHATAVATAR = new ResourceID(1, 1, "RES_CHATAVATAR");
    RES_AVATARURL = new ResourceID(2, 2, "RES_AVATARURL");
    RES_USEDAVATAR = new ResourceID(3, 3, "RES_USEDAVATAR");
  }
  
  private ResourceID(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static ResourceID convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      ResourceID[] arrayOfResourceID = a;
      if (i >= arrayOfResourceID.length) {
        break;
      }
      if (arrayOfResourceID[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static ResourceID convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      ResourceID[] arrayOfResourceID = a;
      if (i >= arrayOfResourceID.length) {
        break;
      }
      if (arrayOfResourceID[i].toString().equals(paramString)) {
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
 * Qualified Name:     ResPackage.ResourceID
 * JD-Core Version:    0.7.0.1
 */