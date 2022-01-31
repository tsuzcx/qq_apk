package com.tencent.mm.plugin.wear.model;

public final class f
{
  public String bIW = "";
  public int id = 0;
  public int qSd = 0;
  f.a qSe;
  public String talker = "";
  
  protected final Object clone()
  {
    f localf = new f();
    localf.id = this.id;
    localf.talker = this.talker;
    localf.bIW = this.bIW;
    localf.qSd = this.qSd;
    localf.qSe = this.qSe;
    return localf;
  }
  
  public final String toString()
  {
    return "WearNotification [talker=" + this.talker + ", id=" + this.id + ", md5=" + this.bIW + ", ignoreInWatch=" + this.qSd + ", status=" + this.qSe + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f
 * JD-Core Version:    0.7.0.1
 */