package NearbyGroup;

import java.io.Serializable;

public final class REPLYCODE
  implements Serializable
{
  public static final REPLYCODE RC_ERR_EXCEPTION;
  public static final REPLYCODE RC_ERR_LBS_AUTH_FAIL = new REPLYCODE(6, 201, "RC_ERR_LBS_AUTH_FAIL");
  public static final REPLYCODE RC_ERR_LBS_EXCEPTION;
  public static final REPLYCODE RC_ERR_LBS_INPUT_ERROR = new REPLYCODE(7, 202, "RC_ERR_LBS_INPUT_ERROR");
  public static final REPLYCODE RC_ERR_LBS_POSITION_FAIL;
  public static final REPLYCODE RC_ERR_PARAM_ERR;
  public static final REPLYCODE RC_ERR_Session_TimeOut;
  public static final REPLYCODE RC_SUCC;
  public static final int _RC_ERR_EXCEPTION = 1;
  public static final int _RC_ERR_LBS_AUTH_FAIL = 201;
  public static final int _RC_ERR_LBS_EXCEPTION = 101;
  public static final int _RC_ERR_LBS_INPUT_ERROR = 202;
  public static final int _RC_ERR_LBS_POSITION_FAIL = 102;
  public static final int _RC_ERR_PARAM_ERR = 2;
  public static final int _RC_ERR_Session_TimeOut = 3;
  public static final int _RC_SUCC = 0;
  private static REPLYCODE[] a = new REPLYCODE[8];
  private String __T = new String();
  private int __value;
  
  static
  {
    RC_SUCC = new REPLYCODE(0, 0, "RC_SUCC");
    RC_ERR_EXCEPTION = new REPLYCODE(1, 1, "RC_ERR_EXCEPTION");
    RC_ERR_PARAM_ERR = new REPLYCODE(2, 2, "RC_ERR_PARAM_ERR");
    RC_ERR_Session_TimeOut = new REPLYCODE(3, 3, "RC_ERR_Session_TimeOut");
    RC_ERR_LBS_EXCEPTION = new REPLYCODE(4, 101, "RC_ERR_LBS_EXCEPTION");
    RC_ERR_LBS_POSITION_FAIL = new REPLYCODE(5, 102, "RC_ERR_LBS_POSITION_FAIL");
  }
  
  private REPLYCODE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static REPLYCODE convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      REPLYCODE[] arrayOfREPLYCODE = a;
      if (i >= arrayOfREPLYCODE.length) {
        break;
      }
      if (arrayOfREPLYCODE[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static REPLYCODE convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      REPLYCODE[] arrayOfREPLYCODE = a;
      if (i >= arrayOfREPLYCODE.length) {
        break;
      }
      if (arrayOfREPLYCODE[i].toString().equals(paramString)) {
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
 * Qualified Name:     NearbyGroup.REPLYCODE
 * JD-Core Version:    0.7.0.1
 */