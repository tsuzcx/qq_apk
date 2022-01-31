package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public String cqq = "";
  public int id = 0;
  public String talker = "";
  public int uHk = 0;
  f.a uHl;
  
  protected final Object clone()
  {
    AppMethodBeat.i(26330);
    f localf = new f();
    localf.id = this.id;
    localf.talker = this.talker;
    localf.cqq = this.cqq;
    localf.uHk = this.uHk;
    localf.uHl = this.uHl;
    AppMethodBeat.o(26330);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26331);
    String str = "WearNotification [talker=" + this.talker + ", id=" + this.id + ", md5=" + this.cqq + ", ignoreInWatch=" + this.uHk + ", status=" + this.uHl + "]";
    AppMethodBeat.o(26331);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f
 * JD-Core Version:    0.7.0.1
 */