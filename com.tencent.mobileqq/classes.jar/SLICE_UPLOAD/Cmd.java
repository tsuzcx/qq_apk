package SLICE_UPLOAD;

import java.io.Serializable;

public final class Cmd
  implements Serializable
{
  public static final Cmd CMD_COMMIT = new Cmd(3, 3, "CMD_COMMIT");
  public static final Cmd CMD_CONTROL;
  public static final Cmd CMD_UNKNOWN;
  public static final Cmd CMD_UPLOAD;
  public static final int _CMD_COMMIT = 3;
  public static final int _CMD_CONTROL = 1;
  public static final int _CMD_UNKNOWN = 0;
  public static final int _CMD_UPLOAD = 2;
  private static Cmd[] __values = new Cmd[4];
  private String __T = new String();
  private int __value;
  
  static
  {
    CMD_UNKNOWN = new Cmd(0, 0, "CMD_UNKNOWN");
    CMD_CONTROL = new Cmd(1, 1, "CMD_CONTROL");
    CMD_UPLOAD = new Cmd(2, 2, "CMD_UPLOAD");
  }
  
  private Cmd(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static Cmd convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Cmd[] arrayOfCmd = __values;
      if (i >= arrayOfCmd.length) {
        break;
      }
      if (arrayOfCmd[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static Cmd convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      Cmd[] arrayOfCmd = __values;
      if (i >= arrayOfCmd.length) {
        break;
      }
      if (arrayOfCmd[i].toString().equals(paramString)) {
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
 * Qualified Name:     SLICE_UPLOAD.Cmd
 * JD-Core Version:    0.7.0.1
 */