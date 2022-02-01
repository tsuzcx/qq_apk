package Sound;

import java.io.Serializable;

public final class Format
  implements Serializable
{
  private static Format[] __values = new Format[2];
  public static final int _kAmr = 1;
  public static final int _kMp3 = 2;
  public static final Format kAmr = new Format(0, 1, "kAmr");
  public static final Format kMp3 = new Format(1, 2, "kMp3");
  private String __T = new String();
  private int __value;
  
  private Format(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static Format convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Format[] arrayOfFormat = __values;
      if (i >= arrayOfFormat.length) {
        break;
      }
      if (arrayOfFormat[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static Format convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      Format[] arrayOfFormat = __values;
      if (i >= arrayOfFormat.length) {
        break;
      }
      if (arrayOfFormat[i].toString().equals(paramString)) {
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
 * Qualified Name:     Sound.Format
 * JD-Core Version:    0.7.0.1
 */