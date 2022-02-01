package com.tenpay.ndk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class FitSmCertUtil
{
  private static volatile FitSmCertUtil instance = null;
  private final String SALT;
  private final String WXPAY_CERT;
  private FitScUtil fitScUtil;
  
  private FitSmCertUtil()
  {
    AppMethodBeat.i(208509);
    this.WXPAY_CERT = "-----BEGIN CERTIFICATE-----\nMIICczCCAhqgAwIBAgIKMTAwMDAwMDAwODAKBggqgRzPVQGDdTCBkTELMAkGA1UE\nBhMCQ04xEjAQBgNVBAgMCUd1YW5nRG9uZzERMA8GA1UEBwwIU2hlblpoZW4xFTAT\nBgNVBAoMDFRlbmNlbnQgSW5jLjEOMAwGA1UECwwFV3hQYXkxEjAQBgNVBAMMCVd4\nUGF5Um9vdDEgMB4GCSqGSIb3DQEJARYRV3hQYXlAdGVuY2VudC5jb20wIhgPMjAy\nMTA2MTgwNjI4NTFaGA8yMDMxMDYxNjA2Mjg1MVowgYQxCzAJBgNVBAYTAkNOMRIw\nEAYDVQQIDAlHdWFuZ0RvbmcxETAPBgNVBAcMCFNoZW5aaGVuMRAwDgYDVQQKDAdU\nZW5jZW50MQwwCgYDVQQLDANGaVQxDjAMBgNVBAMMBVd4UGF5MR4wHAYJKoZIhvcN\nAQkBFg9maXRAdGVuY2VudC5jb20wWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAASV\nbYnq4vzBvRE1YOfLFUAazwj1Nm9xwDnVE0afDpENK+1Jq4ZzRZi+T8VTeywmpgRL\no53QrgG37T/UKOR1k+pQo2EwXzAfBgNVHSMEGDAWgBRU79xm27+HDCM/rsUMBHly\nI9QA4TAdBgNVHQ4EFgQUFWGYHhMsuUuDhjiz083oBhxfnF8wDAYDVR0TAQH/BAIw\nADAPBgNVHQ8BAf8EBQMDBzgAMAoGCCqBHM9VAYN1A0cAMEQCIBJSYh5uw4EM1e5t\n56SuaIp9/mV9oAf8tn4OYGl54afcAiBbIjsONCMsq0KGHGwH4ofxCkoPMMxA6lsj\neIitvQnWvg==\n-----END CERTIFICATE-----";
    this.SALT = "prod-wxpay-pbkdf2";
    this.fitScUtil = null;
    this.fitScUtil = new FitScUtil();
    AppMethodBeat.o(208509);
  }
  
  public static void freeInstance()
  {
    AppMethodBeat.i(208515);
    if (instance != null)
    {
      instance.release();
      instance = null;
    }
    AppMethodBeat.o(208515);
  }
  
  public static FitSmCertUtil getInstance()
  {
    AppMethodBeat.i(208513);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new FitSmCertUtil();
      }
      FitSmCertUtil localFitSmCertUtil = instance;
      AppMethodBeat.o(208513);
      return localFitSmCertUtil;
    }
    finally
    {
      AppMethodBeat.o(208513);
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(208518);
    if (this.fitScUtil != null)
    {
      this.fitScUtil.release();
      this.fitScUtil = null;
    }
    AppMethodBeat.o(208518);
  }
  
  public String encryptPassword(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    AppMethodBeat.i(208526);
    String str = this.fitScUtil.encryptPass("-----BEGIN CERTIFICATE-----\nMIICczCCAhqgAwIBAgIKMTAwMDAwMDAwODAKBggqgRzPVQGDdTCBkTELMAkGA1UE\nBhMCQ04xEjAQBgNVBAgMCUd1YW5nRG9uZzERMA8GA1UEBwwIU2hlblpoZW4xFTAT\nBgNVBAoMDFRlbmNlbnQgSW5jLjEOMAwGA1UECwwFV3hQYXkxEjAQBgNVBAMMCVd4\nUGF5Um9vdDEgMB4GCSqGSIb3DQEJARYRV3hQYXlAdGVuY2VudC5jb20wIhgPMjAy\nMTA2MTgwNjI4NTFaGA8yMDMxMDYxNjA2Mjg1MVowgYQxCzAJBgNVBAYTAkNOMRIw\nEAYDVQQIDAlHdWFuZ0RvbmcxETAPBgNVBAcMCFNoZW5aaGVuMRAwDgYDVQQKDAdU\nZW5jZW50MQwwCgYDVQQLDANGaVQxDjAMBgNVBAMMBVd4UGF5MR4wHAYJKoZIhvcN\nAQkBFg9maXRAdGVuY2VudC5jb20wWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAASV\nbYnq4vzBvRE1YOfLFUAazwj1Nm9xwDnVE0afDpENK+1Jq4ZzRZi+T8VTeywmpgRL\no53QrgG37T/UKOR1k+pQo2EwXzAfBgNVHSMEGDAWgBRU79xm27+HDCM/rsUMBHly\nI9QA4TAdBgNVHQ4EFgQUFWGYHhMsuUuDhjiz083oBhxfnF8wDAYDVR0TAQH/BAIw\nADAPBgNVHQ8BAf8EBQMDBzgAMAoGCCqBHM9VAYN1A0cAMEQCIBJSYh5uw4EM1e5t\n56SuaIp9/mV9oAf8tn4OYGl54afcAiBbIjsONCMsq0KGHGwH4ofxCkoPMMxA6lsj\neIitvQnWvg==\n-----END CERTIFICATE-----", paramString1.getBytes(), "prod-wxpay-pbkdf2".getBytes(), paramLong, paramString2, paramInt);
    if (str == null)
    {
      Log.e("FitSmCertUtil", "encryptPassword is null, error code:%d,  pass length:%d, timeStamp:%d, nonce:%s, headType:%d", new Object[] { Integer.valueOf(this.fitScUtil.getLastError()), Integer.valueOf(paramString1.length()), Long.valueOf(paramLong), paramString2, Integer.valueOf(paramInt) });
      AppMethodBeat.o(208526);
      return null;
    }
    if (str.length() == 0)
    {
      Log.e("FitSmCertUtil", "encryptPassword length zero, error code:%d, pass length:%d, timeStamp:%d, nonce:%s, headType:%d", new Object[] { Integer.valueOf(this.fitScUtil.getLastError()), Integer.valueOf(paramString1.length()), Long.valueOf(paramLong), paramString2, Integer.valueOf(paramInt) });
      AppMethodBeat.o(208526);
      return str;
    }
    paramInt = this.fitScUtil.getLastError();
    if (paramInt != 0) {
      Log.e("FitSmCertUtil", "encryptPassword error, error code:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(208526);
    return str;
  }
  
  public boolean init(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(208523);
    boolean bool = this.fitScUtil.init(paramString1, paramString2, "wxpay", paramString3);
    AppMethodBeat.o(208523);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tenpay.ndk.FitSmCertUtil
 * JD-Core Version:    0.7.0.1
 */