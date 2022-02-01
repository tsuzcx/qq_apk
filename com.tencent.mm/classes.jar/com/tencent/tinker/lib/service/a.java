package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public String KqL;
  public String KqM;
  public boolean deB;
  public Throwable e;
  public long lTa;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\nPatchResult: \n");
    localStringBuffer.append("isSuccess:" + this.deB + "\n");
    localStringBuffer.append("rawPatchFilePath:" + this.KqL + "\n");
    localStringBuffer.append("costTime:" + this.lTa + "\n");
    if (this.KqM != null) {
      localStringBuffer.append("patchVersion:" + this.KqM + "\n");
    }
    if (this.e != null) {
      localStringBuffer.append("Throwable:" + this.e.getMessage() + "\n");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.service.a
 * JD-Core Version:    0.7.0.1
 */