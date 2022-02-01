package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public String IEC;
  public String IED;
  public boolean dhg;
  public Throwable e;
  public long lrf;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\nPatchResult: \n");
    localStringBuffer.append("isSuccess:" + this.dhg + "\n");
    localStringBuffer.append("rawPatchFilePath:" + this.IEC + "\n");
    localStringBuffer.append("costTime:" + this.lrf + "\n");
    if (this.IED != null) {
      localStringBuffer.append("patchVersion:" + this.IED + "\n");
    }
    if (this.e != null) {
      localStringBuffer.append("Throwable:" + this.e.getMessage() + "\n");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.lib.service.a
 * JD-Core Version:    0.7.0.1
 */