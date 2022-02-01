package com.tencent.recovery;

import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;

public final class ConstantsRecovery$DefaultCommonOptions
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.recovery.ConstantsRecovery.DefaultCommonOptions
 * JD-Core Version:    0.7.0.1
 */