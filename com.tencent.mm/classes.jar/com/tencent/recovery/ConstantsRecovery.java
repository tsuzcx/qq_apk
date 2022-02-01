package com.tencent.recovery;

import com.tencent.recovery.config.Express;
import com.tencent.recovery.config.ExpressItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.option.ProcessOptions.Builder;
import java.util.ArrayList;
import java.util.List;

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
  
  public static final class DefaultCommonOptions
  {
    public static final CommonOptions DefaultOptions;
    
    static
    {
      CommonOptions.Builder localBuilder = new CommonOptions.Builder();
      localBuilder.setUUID("");
      localBuilder.setClientVersion("");
      localBuilder.setConfigUrl("");
      localBuilder.setRecoveryHandleService("");
      localBuilder.setRecoveryUploadService("");
      DefaultOptions = localBuilder.build();
    }
  }
  
  public static final class DefaultExpress
  {
    public static final Express Background = new Express();
    public static final Express Foreground;
    public static final Express ForegroundCrash;
    
    static
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(17, 17, 1114112, 3));
      Background.addCondition(localArrayList);
      Foreground = new Express();
      localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(1, 17, 1118208, 3));
      Foreground.addCondition(localArrayList);
      ForegroundCrash = new Express();
      localArrayList = new ArrayList();
      localArrayList.add(new ExpressItem(1, 17, 1114112, 3));
      ForegroundCrash.addCondition(localArrayList);
    }
  }
  
  public static final class DefaultProcessOptions
  {
    public static final ProcessOptions Background;
    public static final ProcessOptions Foreground;
    public static final ProcessOptions ForegroundCrash;
    
    static
    {
      ProcessOptions.Builder localBuilder = new ProcessOptions.Builder();
      localBuilder.setExpress(ConstantsRecovery.DefaultExpress.Background);
      localBuilder.setTimeout(10000);
      Background = localBuilder.build();
      localBuilder = new ProcessOptions.Builder();
      localBuilder.setExpress(ConstantsRecovery.DefaultExpress.Foreground);
      localBuilder.setTimeout(10000);
      Foreground = localBuilder.build();
      localBuilder = new ProcessOptions.Builder();
      localBuilder.setExpress(ConstantsRecovery.DefaultExpress.ForegroundCrash);
      localBuilder.setTimeout(10000);
      ForegroundCrash = localBuilder.build();
    }
  }
  
  public static final class IntentAction
  {
    public static final String ACTION_LOG = "com.tecent.recovery.intent.action.LOG";
  }
  
  public static final class IntentKeys
  {
    public static final String KeyIsRetry = "KeyIsRetry";
    public static final String KeyProcessName = "KeyProcessName";
    public static final String KeyRecoveryData = "KeyRecoveryData";
    public static final String KeyReportHandleClassName = "KeyReportHandleClassName";
    public static final String KeyReportItem = "KeyReportItem";
    public static final String KeyReportType = "KeyReportType";
    public static final String KeyReportUploadClassName = "KeyReportUploadClassName";
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
  
  public static final class ProcessStatus
  {
    public static final int AllException = 1118208;
    public static final int AllNormal = 273;
    public static final int Anr = 1048576;
    public static final int BgNormal = 16;
    public static final int Crash = 65536;
    public static final int PointNormal = 256;
    public static final int TimeNormal = 1;
    public static final int TimeOut = 4096;
  }
  
  public static final class ReportType
  {
    public static final String HandleStatus = "HandleStatus";
    public static final String ProcessStatus = "ProcessStatus";
  }
  
  public static final class SpKeys
  {
    public static final String KeyAppOnCreateExceptionType = "KeyAppOnCreateExceptionType";
    public static final String KeyAppOnCreateForeground = "KeyAppOnCreateForeground";
    public static final String KeyAppOnCreateNormalType = "KeyAppOnCreateNormalType";
    public static final String KeyComponentOnCreateExceptionType = "KeyComponentOnCreateExceptionType";
    public static final String KeyComponentOnCreateForeground = "KeyComponentOnCreateForeground";
    public static final String KeyComponentOnCreateNormalType = "KeyComponentOnCreateNormalType";
    public static final String KeyHistoryExceptionTypeList = "KeyHistoryExceptionTypeList";
    public static final String KeyLastUploadTime = "KeyLastUploadTime";
    public static final String KeyRecoveryVersion = "KeyRecoveryVersion";
    public static final String KeySafeModeUUID = "KeySafeModeUUID";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.ConstantsRecovery
 * JD-Core Version:    0.7.0.1
 */