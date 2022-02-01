package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public String MgK;
  public long MgL;
  public boolean MgM;
  public String MgN;
  public boolean dpX;
  public Throwable e;
  public long msQ;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\nPatchResult: \n");
    localStringBuffer.append("isSuccess:" + this.dpX + "\n");
    localStringBuffer.append("rawPatchFilePath:" + this.MgK + "\n");
    localStringBuffer.append("costTime:" + this.msQ + "\n");
    localStringBuffer.append("dexoptTriggerTime:" + this.MgL + "\n");
    localStringBuffer.append("isOatGenerated:" + this.MgM + "\n");
    if (this.MgN != null) {
      localStringBuffer.append("patchVersion:" + this.MgN + "\n");
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