package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public String ahRw;
  public long ahRx;
  public boolean ahRy;
  public String ahRz;
  public long costTime;
  public Throwable e;
  public boolean isSuccess;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\nPatchResult: \n");
    localStringBuffer.append("isSuccess:" + this.isSuccess + "\n");
    localStringBuffer.append("rawPatchFilePath:" + this.ahRw + "\n");
    localStringBuffer.append("costTime:" + this.costTime + "\n");
    localStringBuffer.append("dexoptTriggerTime:" + this.ahRx + "\n");
    localStringBuffer.append("isOatGenerated:" + this.ahRy + "\n");
    if (this.ahRz != null) {
      localStringBuffer.append("patchVersion:" + this.ahRz + "\n");
    }
    if (this.e != null) {
      localStringBuffer.append("Throwable:" + this.e.getMessage() + "\n");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.service.a
 * JD-Core Version:    0.7.0.1
 */