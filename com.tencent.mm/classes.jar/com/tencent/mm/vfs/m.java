package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class m
{
  final SchemeResolver Rds;
  SchemeResolver.a Rdt;
  
  m(SchemeResolver paramSchemeResolver)
  {
    this.Rds = paramSchemeResolver;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187739);
    if (this.Rds == null)
    {
      AppMethodBeat.o(187739);
      return "[NULL]";
    }
    String str = this.Rds.toString();
    AppMethodBeat.o(187739);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.m
 * JD-Core Version:    0.7.0.1
 */