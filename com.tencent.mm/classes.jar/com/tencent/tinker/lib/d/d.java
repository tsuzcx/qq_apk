package com.tencent.tinker.lib.d;

import android.content.Intent;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public abstract interface d
{
  public abstract void J(Intent paramIntent);
  
  public abstract void a(File paramFile, SharePatchInfo paramSharePatchInfo, String paramString);
  
  public abstract void a(File paramFile1, File paramFile2, String paramString, int paramInt);
  
  public abstract void a(File paramFile, String paramString1, String paramString2);
  
  public abstract void a(File paramFile, Throwable paramThrowable);
  
  public abstract void a(File paramFile, List<File> paramList, Throwable paramThrowable);
  
  public abstract void a(File paramFile, boolean paramBoolean, long paramLong);
  
  public abstract void d(File paramFile, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.d.d
 * JD-Core Version:    0.7.0.1
 */