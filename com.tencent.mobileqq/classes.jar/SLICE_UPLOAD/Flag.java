package SLICE_UPLOAD;

import java.io.Serializable;

public final class Flag
  implements Serializable
{
  public static final Flag FLAG_ERROR;
  public static final Flag FLAG_FILECOMPLETE;
  public static final Flag FLAG_FILENEEDCOMMIT;
  public static final Flag FLAG_RETRY_CTRL_NOSESSION = new Flag(6, 13, "FLAG_RETRY_CTRL_NOSESSION");
  public static final Flag FLAG_RETRY_CTRL_SESSION;
  public static final Flag FLAG_RETRY_CURRENT;
  public static final Flag FLAG_RETRY_RECONNECT_CTRL_NOSESSION = new Flag(7, 14, "FLAG_RETRY_RECONNECT_CTRL_NOSESSION");
  public static final Flag FLAG_SUCC;
  public static final int _FLAG_ERROR = 10;
  public static final int _FLAG_FILECOMPLETE = 1;
  public static final int _FLAG_FILENEEDCOMMIT = 2;
  public static final int _FLAG_RETRY_CTRL_NOSESSION = 13;
  public static final int _FLAG_RETRY_CTRL_SESSION = 12;
  public static final int _FLAG_RETRY_CURRENT = 11;
  public static final int _FLAG_RETRY_RECONNECT_CTRL_NOSESSION = 14;
  public static final int _FLAG_SUCC = 0;
  private static Flag[] __values = new Flag[8];
  private String __T = new String();
  private int __value;
  
  static
  {
    FLAG_SUCC = new Flag(0, 0, "FLAG_SUCC");
    FLAG_FILECOMPLETE = new Flag(1, 1, "FLAG_FILECOMPLETE");
    FLAG_FILENEEDCOMMIT = new Flag(2, 2, "FLAG_FILENEEDCOMMIT");
    FLAG_ERROR = new Flag(3, 10, "FLAG_ERROR");
    FLAG_RETRY_CURRENT = new Flag(4, 11, "FLAG_RETRY_CURRENT");
    FLAG_RETRY_CTRL_SESSION = new Flag(5, 12, "FLAG_RETRY_CTRL_SESSION");
  }
  
  private Flag(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static Flag convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Flag[] arrayOfFlag = __values;
      if (i >= arrayOfFlag.length) {
        break;
      }
      if (arrayOfFlag[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static Flag convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      Flag[] arrayOfFlag = __values;
      if (i >= arrayOfFlag.length) {
        break;
      }
      if (arrayOfFlag[i].toString().equals(paramString)) {
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
 * Qualified Name:     SLICE_UPLOAD.Flag
 * JD-Core Version:    0.7.0.1
 */