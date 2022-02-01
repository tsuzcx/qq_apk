package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public String MDH;
  public long MDI;
  public boolean MDJ;
  public String MDK;
  public boolean drc;
  public Throwable e;
  public long mxN;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\nPatchResult: \n");
    localStringBuffer.append("isSuccess:" + this.drc + "\n");
    localStringBuffer.append("rawPatchFilePath:" + this.MDH + "\n");
    localStringBuffer.append("costTime:" + this.mxN + "\n");
    localStringBuffer.append("dexoptTriggerTime:" + this.MDI + "\n");
    localStringBuffer.append("isOatGenerated:" + this.MDJ + "\n");
    if (this.MDK != null) {
      localStringBuffer.append("patchVersion:" + this.MDK + "\n");
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