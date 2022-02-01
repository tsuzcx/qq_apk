package com.tencent.mm.sdk.crash;

import android.content.Context;

public abstract interface ICrashReporter
{
  public abstract void addCrashReportListener(ICrashReportListener paramICrashReportListener);
  
  public abstract void addExtraMessageGetter(ICrashReportExtraMessageGetter paramICrashReportExtraMessageGetter);
  
  public abstract void init(Context paramContext, boolean paramBoolean);
  
  public abstract void removeCrashReportListener(ICrashReportListener paramICrashReportListener);
  
  public abstract void reportCrashMessage(String paramString1, String paramString2);
  
  public abstract void reportJniCrash(int paramInt, String paramString1, String paramString2);
  
  public abstract void reportRawMessage(String paramString1, String paramString2);
  
  public abstract void setCallbackForReset(CallbackForReset paramCallbackForReset);
  
  public abstract void setReportID(String paramString);
  
  public abstract void setupSubReporter(ISubReporter paramISubReporter);
  
  public static abstract interface ICrashReportExtraMessageGetter
  {
    public abstract String getCrashReportExtraMessage();
  }
  
  public static abstract interface ICrashReportListener
  {
    public abstract void onCrashDumped(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.crash.ICrashReporter
 * JD-Core Version:    0.7.0.1
 */