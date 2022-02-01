package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public String SjJ;
  public long SjK;
  public boolean SjL;
  public String SjM;
  public long costTime;
  public Throwable e;
  public boolean isSuccess;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\nPatchResult: \n");
    localStringBuffer.append("isSuccess:" + this.isSuccess + "\n");
    localStringBuffer.append("rawPatchFilePath:" + this.SjJ + "\n");
    localStringBuffer.append("costTime:" + this.costTime + "\n");
    localStringBuffer.append("dexoptTriggerTime:" + this.SjK + "\n");
    localStringBuffer.append("isOatGenerated:" + this.SjL + "\n");
    if (this.SjM != null) {
      localStringBuffer.append("patchVersion:" + this.SjM + "\n");
    }
    if (this.e != null) {
      localStringBuffer.append("Throwable:" + this.e.getMessage() + "\n");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.a
 * JD-Core Version:    0.7.0.1
 */