package com.tencent.recovery.wx;

import android.os.Environment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.File;

public class WXConstantsRecovery
{
  public static final String PublicKeyString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC0oMW80k4h7zmBbHGhzQzs5Jv1uy5j0JVUG//dWHeu0q6PF/xCU97h/e6h2Q9SXLu0M4TTd89QMXbab9MMUXrxqIqVjzm92A4WyNbAElAwhE9AGO16ryYn+tNzDfmwyjVz6dwLzZbNjjH7akYZRopJYqo17kKn+xrnqM+GRKMOJQIDAQAB";
  public static final String RecoveryConfigURL = "http://" + WeChatHosts.domainString(2131761706) + "/weixin/android/recovery-%s.conf";
  public static final String RecoverySDCardDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/recovery/";
  public static final String VersionInfoFile = "version.info";
  
  public static final class HandleReportKeys
  {
    public static final String KeyAlreadyRunning = "KeyAlreadyRunning";
    public static final String KeyConfigDecryptFail = "KeyConfigDecryptFail";
    public static final String KeyConfigHttpCode = "KeyConfigHttpCode";
    public static final String KeyConfigHttpInputStreamIsNull = "KeyConfigHttpInputStreamIsNull";
    public static final String KeyConfigHttpInputStreamReadDataIsNull = "KeyConfigHttpInputStreamReadDataIsNull";
    public static final String KeyConfigHttpInputStreamReadDataLengthZero = "KeyConfigHttpInputStreamReadDataLengthZero";
    public static final String KeyConfigParseFailCount = "KeyConfigParseFailCount";
    public static final String KeyNoNetWork = "KeyNoNetWork";
    public static final String KeyPatchCheckMd5Fail = "KeyPatchCheckMd5Fail";
    public static final String KeyPatchHttpCode = "KeyPatchHttpCode";
    public static final String KeyPatchHttpInputStreamIsNull = "KeyPatchHttpInputStreamIsNull";
    public static final String KeyPatchHttpInputStreamReadDataIsNull = "KeyPatchHttpInputStreamReadDataIsNull";
    public static final String KeyPatchHttpInputStreamReadDataLengthZero = "KeyPatchHttpInputStreamReadDataLengthZero";
    public static final String KeyPatchNoNeedCount = "KeyPatchNoNeedCount";
    public static final String KeyPatchResultFailCount = "KeyPatchResultFailCount";
    public static final String KeyPatchResultSuccessCount = "KeyPatchResultSuccessCount";
    public static final String KeyPatchResultTotalCount = "KeyPatchResultTotalCount";
    public static final String KeyPatchSaveFailCount = "KeyCheckPatchMd5FailCount";
    public static final String KeyPatchStartFailCount = "KeyPatchStartFailCount";
    public static final String KeyPatchStartSuccessCount = "KeyPatchStartSuccessCount";
    public static final String KeyTotalCount = "KeyTotalCount";
  }
  
  public static final class IntentAction
  {
    public static final String RECOVERY_STATUS_UPLOAD = "com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.WXConstantsRecovery
 * JD-Core Version:    0.7.0.1
 */