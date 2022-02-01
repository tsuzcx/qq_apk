package LBSAddrProtocol;

import java.io.Serializable;

public final class RESULTCODE
  implements Serializable
{
  public static final RESULTCODE RESULT_AUTH_FAIL;
  public static final RESULTCODE RESULT_EXCEPTION;
  public static final RESULTCODE RESULT_GET_FAIL = new RESULTCODE(7, 3002, "RESULT_GET_FAIL");
  public static final RESULTCODE RESULT_INPUT_ERROR;
  public static final RESULTCODE RESULT_POSITION_FAIL;
  public static final RESULTCODE RESULT_PUSH_FAIL;
  public static final RESULTCODE RESULT_RESTRICTED = new RESULTCODE(8, 4001, "RESULT_RESTRICTED");
  public static final RESULTCODE RESULT_SUCC;
  public static final RESULTCODE RESULT_TIME_OUT;
  public static final int _RESULT_AUTH_FAIL = 201;
  public static final int _RESULT_EXCEPTION = 101;
  public static final int _RESULT_GET_FAIL = 3002;
  public static final int _RESULT_INPUT_ERROR = 202;
  public static final int _RESULT_POSITION_FAIL = 102;
  public static final int _RESULT_PUSH_FAIL = 3001;
  public static final int _RESULT_RESTRICTED = 4001;
  public static final int _RESULT_SUCC = 0;
  public static final int _RESULT_TIME_OUT = 103;
  private static RESULTCODE[] a = new RESULTCODE[9];
  private String __T = new String();
  private int __value;
  
  static
  {
    RESULT_SUCC = new RESULTCODE(0, 0, "RESULT_SUCC");
    RESULT_EXCEPTION = new RESULTCODE(1, 101, "RESULT_EXCEPTION");
    RESULT_POSITION_FAIL = new RESULTCODE(2, 102, "RESULT_POSITION_FAIL");
    RESULT_TIME_OUT = new RESULTCODE(3, 103, "RESULT_TIME_OUT");
    RESULT_AUTH_FAIL = new RESULTCODE(4, 201, "RESULT_AUTH_FAIL");
    RESULT_INPUT_ERROR = new RESULTCODE(5, 202, "RESULT_INPUT_ERROR");
    RESULT_PUSH_FAIL = new RESULTCODE(6, 3001, "RESULT_PUSH_FAIL");
  }
  
  private RESULTCODE(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static RESULTCODE convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      RESULTCODE[] arrayOfRESULTCODE = a;
      if (i >= arrayOfRESULTCODE.length) {
        break;
      }
      if (arrayOfRESULTCODE[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static RESULTCODE convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      RESULTCODE[] arrayOfRESULTCODE = a;
      if (i >= arrayOfRESULTCODE.length) {
        break;
      }
      if (arrayOfRESULTCODE[i].toString().equals(paramString)) {
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
 * Qualified Name:     LBSAddrProtocol.RESULTCODE
 * JD-Core Version:    0.7.0.1
 */