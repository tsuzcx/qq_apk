package com.tencent.recovery;

import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.option.ProcessOptions.Builder;

public final class ConstantsRecovery$DefaultProcessOptions
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.recovery.ConstantsRecovery.DefaultProcessOptions
 * JD-Core Version:    0.7.0.1
 */