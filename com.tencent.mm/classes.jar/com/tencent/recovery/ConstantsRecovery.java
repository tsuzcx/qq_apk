package com.tencent.recovery;

public class ConstantsRecovery
{
  public static final int DEFAULT_RETRY_HANDLE_INTERVAL = 600000;
  public static final int DEFAULT_UPLOAD_INTERVAL = 600000;
  public static final String ISOLATE_PROCESS_NAME = "ISOLATE_PROCESS";
  public static final int MAX_EXCEPTION_HISTORY_SIZE = 15;
  public static final String RECOVERY_CONF_NAME = "recovery";
  public static final String RECOVERY_INFO_CONF_NAME = "recovery-info";
  public static final int RETRY_HANDLE_ALARM_REQUEST_CODE = 1000002;
  public static final int UPLOAD_ALARM_REQUEST_CODE = 1000001;
  
  public static final class IntentAction
  {
    public static final String ACTION_LOG = "com.tecent.recovery.intent.action.LOG";
  }
  
  public static final class Message
  {
    public static final int MarkActivityOnCreateNormal = 3;
    public static final int MarkApplicationOnCreateNormal = 1;
    public static final int MarkBackgroundOnCreateNormal = 2;
  }
  
  public static final class ProcessStage
  {
    public static final int All = 17;
    public static final int ApplicationOnCreate = 1;
    public static final int ComponentOnCreate = 16;
  }
  
  public static final class ProcessStartFlag
  {
    public static final int All = 17;
    public static final int Background = 16;
    public static final int Foreground = 1;
  }
  
  public static final class ReportType
  {
    public static final String HandleStatus = "HandleStatus";
    public static final String ProcessStatus = "ProcessStatus";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.ConstantsRecovery
 * JD-Core Version:    0.7.0.1
 */