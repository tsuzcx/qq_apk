package com.tencent.recovery.option;

import android.content.Context;

public abstract interface IOptionsCreator
{
  public abstract CommonOptions createCommonOptions(Context paramContext);
  
  public abstract ProcessOptions createProcessOptions(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.recovery.option.IOptionsCreator
 * JD-Core Version:    0.7.0.1
 */