package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public long aaN;
  public Throwable amz;
  public boolean anl;
  public String anm;
  public String ann;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\nPatchResult: \n");
    localStringBuffer.append("isSuccess:" + this.anl + "\n");
    localStringBuffer.append("rawPatchFilePath:" + this.anm + "\n");
    localStringBuffer.append("costTime:" + this.aaN + "\n");
    if (this.ann != null) {
      localStringBuffer.append("patchVersion:" + this.ann + "\n");
    }
    if (this.amz != null) {
      localStringBuffer.append("Throwable:" + this.amz.getMessage() + "\n");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.a
 * JD-Core Version:    0.7.0.1
 */