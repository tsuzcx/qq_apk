package NeighborComm;

import java.io.Serializable;

public final class REPLYCODE
  implements Serializable
{
  public static final REPLYCODE REPLYCODE_ERROR_EXCEPTION;
  public static final REPLYCODE REPLYCODE_ERROR_FUNCNAME;
  public static final REPLYCODE REPLYCODE_ERR_CHECKIN_TIMEOUT;
  public static final REPLYCODE REPLYCODE_ERR_CHECK_SIG_FAILED;
  public static final REPLYCODE REPLYCODE_ERR_FILTERED;
  public static final REPLYCODE REPLYCODE_ERR_GETNBS_TIMEOUT;
  public static final REPLYCODE REPLYCODE_ERR_LBS_AUTH_FAIL;
  public static final REPLYCODE REPLYCODE_ERR_LBS_EXCEPTION;
  public static final REPLYCODE REPLYCODE_ERR_LBS_INPUT_ERROR;
  public static final REPLYCODE REPLYCODE_ERR_LBS_POSITION_FAIL;
  public static final REPLYCODE REPLYCODE_ERR_LBS_RESP_TIMEOUT;
  public static final REPLYCODE REPLYCODE_ERR_MG_Action;
  public static final REPLYCODE REPLYCODE_ERR_MG_NextPage;
  public static final REPLYCODE REPLYCODE_ERR_NO_Robot;
  public static final REPLYCODE REPLYCODE_ERR_OIDB_EXCEPTION;
  public static final REPLYCODE REPLYCODE_ERR_SEARCH_ACCOUNT;
  public static final REPLYCODE REPLYCODE_ERR_Session_TimeOut;
  public static final REPLYCODE REPLYCODE_ERR_TAF_rpc_call_async;
  public static final REPLYCODE REPLYCODE_ROAM_ERROR1;
  public static final REPLYCODE REPLYCODE_ROAM_ERROR2;
  public static final REPLYCODE REPLYCODE_SUCC;
  public static final REPLYCODE REPLYCODE_SUCC_NOPENGYOU_INFO;
  public static final int _REPLYCODE_ERROR_EXCEPTION = 1;
  public static final int _REPLYCODE_ERROR_FUNCNAME = 2;
  public static final int _REPLYCODE_ERR_CHECKIN_TIMEOUT = 3;
  public static final int _REPLYCODE_ERR_CHECK_SIG_FAILED = 601;
  public static final int _REPLYCODE_ERR_FILTERED = 602;
  public static final int _REPLYCODE_ERR_GETNBS_TIMEOUT = 4;
  public static final int _REPLYCODE_ERR_LBS_AUTH_FAIL = 201;
  public static final int _REPLYCODE_ERR_LBS_EXCEPTION = 101;
  public static final int _REPLYCODE_ERR_LBS_INPUT_ERROR = 202;
  public static final int _REPLYCODE_ERR_LBS_POSITION_FAIL = 102;
  public static final int _REPLYCODE_ERR_LBS_RESP_TIMEOUT = 103;
  public static final int _REPLYCODE_ERR_MG_Action = 51;
  public static final int _REPLYCODE_ERR_MG_NextPage = 52;
  public static final int _REPLYCODE_ERR_NO_Robot = 5;
  public static final int _REPLYCODE_ERR_OIDB_EXCEPTION = 500;
  public static final int _REPLYCODE_ERR_SEARCH_ACCOUNT = 600;
  public static final int _REPLYCODE_ERR_Session_TimeOut = 7;
  public static final int _REPLYCODE_ERR_TAF_rpc_call_async = 6;
  public static final int _REPLYCODE_ROAM_ERROR1 = 100500;
  public static final int _REPLYCODE_ROAM_ERROR2 = 100501;
  public static final int _REPLYCODE_SUCC = 0;
  public static final int _REPLYCODE_SUCC_NOPENGYOU_INFO = 300;
  private static REPLYCODE[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!REPLYCODE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new REPLYCODE[22];
      REPLYCODE_SUCC = new REPLYCODE(0, 0, "REPLYCODE_SUCC");
      REPLYCODE_ERROR_EXCEPTION = new REPLYCODE(1, 1, "REPLYCODE_ERROR_EXCEPTION");
      REPLYCODE_ERROR_FUNCNAME = new REPLYCODE(2, 2, "REPLYCODE_ERROR_FUNCNAME");
      REPLYCODE_ERR_CHECKIN_TIMEOUT = new REPLYCODE(3, 3, "REPLYCODE_ERR_CHECKIN_TIMEOUT");
      REPLYCODE_ERR_GETNBS_TIMEOUT = new REPLYCODE(4, 4, "REPLYCODE_ERR_GETNBS_TIMEOUT");
      REPLYCODE_ERR_NO_Robot = new REPLYCODE(5, 5, "REPLYCODE_ERR_NO_Robot");
      REPLYCODE_ERR_TAF_rpc_call_async = new REPLYCODE(6, 6, "REPLYCODE_ERR_TAF_rpc_call_async");
      REPLYCODE_ERR_Session_TimeOut = new REPLYCODE(7, 7, "REPLYCODE_ERR_Session_TimeOut");
      REPLYCODE_ERR_MG_Action = new REPLYCODE(8, 51, "REPLYCODE_ERR_MG_Action");
      REPLYCODE_ERR_MG_NextPage = new REPLYCODE(9, 52, "REPLYCODE_ERR_MG_NextPage");
      REPLYCODE_ERR_LBS_EXCEPTION = new REPLYCODE(10, 101, "REPLYCODE_ERR_LBS_EXCEPTION");
      REPLYCODE_ERR_LBS_POSITION_FAIL = new REPLYCODE(11, 102, "REPLYCODE_ERR_LBS_POSITION_FAIL");
      REPLYCODE_ERR_LBS_RESP_TIMEOUT = new REPLYCODE(12, 103, "REPLYCODE_ERR_LBS_RESP_TIMEOUT");
      REPLYCODE_ERR_LBS_AUTH_FAIL = new REPLYCODE(13, 201, "REPLYCODE_ERR_LBS_AUTH_FAIL");
      REPLYCODE_ERR_LBS_INPUT_ERROR = new REPLYCODE(14, 202, "REPLYCODE_ERR_LBS_INPUT_ERROR");
      REPLYCODE_SUCC_NOPENGYOU_INFO = new REPLYCODE(15, 300, "REPLYCODE_SUCC_NOPENGYOU_INFO");
      REPLYCODE_ERR_OIDB_EXCEPTION = new REPLYCODE(16, 500, "REPLYCODE_ERR_OIDB_EXCEPTION");
      REPLYCODE_ERR_SEARCH_ACCOUNT = new REPLYCODE(17, 600, "REPLYCODE_ERR_SEARCH_ACCOUNT");
      REPLYCODE_ERR_CHECK_SIG_FAILED = new REPLYCODE(18, 601, "REPLYCODE_ERR_CHECK_SIG_FAILED");
      REPLYCODE_ERR_FILTERED = new REPLYCODE(19, 602, "REPLYCODE_ERR_FILTERED");
      REPLYCODE_ROAM_ERROR1 = new REPLYCODE(20, 100500, "REPLYCODE_ROAM_ERROR1");
      REPLYCODE_ROAM_ERROR2 = new REPLYCODE(21, 100501, "REPLYCODE_ROAM_ERROR2");
      return;
    }
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
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static REPLYCODE convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NeighborComm.REPLYCODE
 * JD-Core Version:    0.7.0.1
 */