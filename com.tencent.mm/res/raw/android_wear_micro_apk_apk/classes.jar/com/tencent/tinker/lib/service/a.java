package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public Throwable aiX;
  public boolean ajJ;
  public String ajK;
  public long ajL;
  public String ajM;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\nPatchResult: \n");
    localStringBuffer.append("isSuccess:" + this.ajJ + "\n");
    localStringBuffer.append("rawPatchFilePath:" + this.ajK + "\n");
    localStringBuffer.append("costTime:" + this.ajL + "\n");
    if (this.ajM != null) {
      localStringBuffer.append("patchVersion:" + this.ajM + "\n");
    }
    if (this.aiX != null) {
      localStringBuffer.append("Throwable:" + this.aiX.getMessage() + "\n");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.a
 * JD-Core Version:    0.7.0.1
 */