package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public boolean bKQ;
  public long gYL;
  public Throwable wKQ;
  public String wWa;
  public String wWb;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\nPatchResult: \n");
    localStringBuffer.append("isSuccess:" + this.bKQ + "\n");
    localStringBuffer.append("rawPatchFilePath:" + this.wWa + "\n");
    localStringBuffer.append("costTime:" + this.gYL + "\n");
    if (this.wWb != null) {
      localStringBuffer.append("patchVersion:" + this.wWb + "\n");
    }
    if (this.wKQ != null) {
      localStringBuffer.append("Throwable:" + this.wKQ.getMessage() + "\n");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.lib.service.a
 * JD-Core Version:    0.7.0.1
 */