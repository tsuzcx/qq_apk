package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public Throwable Biq;
  public String BsF;
  public String BsG;
  public boolean csk;
  public long iHc;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\nPatchResult: \n");
    localStringBuffer.append("isSuccess:" + this.csk + "\n");
    localStringBuffer.append("rawPatchFilePath:" + this.BsF + "\n");
    localStringBuffer.append("costTime:" + this.iHc + "\n");
    if (this.BsG != null) {
      localStringBuffer.append("patchVersion:" + this.BsG + "\n");
    }
    if (this.Biq != null) {
      localStringBuffer.append("Throwable:" + this.Biq.getMessage() + "\n");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.lib.service.a
 * JD-Core Version:    0.7.0.1
 */