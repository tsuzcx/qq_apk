package com.tencent.mm.plugin.qqmail.b;

import d.a.a.b;

public final class o
  extends com.tencent.mm.bv.a
{
  public String lCF;
  public String name;
  public int ndO;
  public int ndP;
  public String ndQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.name == null) {
        throw new b("Not all required fields were included: name");
      }
      if (this.lCF == null) {
        throw new b("Not all required fields were included: addr");
      }
      paramVarArgs.gB(1, this.ndO);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.lCF != null) {
        paramVarArgs.d(3, this.lCF);
      }
      paramVarArgs.gB(4, this.ndP);
      if (this.ndQ != null) {
        paramVarArgs.d(5, this.ndQ);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.ndO) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.lCF != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.lCF);
      }
      i += d.a.a.a.gy(4, this.ndP);
      paramInt = i;
    } while (this.ndQ == null);
    return i + d.a.a.b.b.a.e(5, this.ndQ);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.name == null) {
        throw new b("Not all required fields were included: name");
      }
      if (this.lCF == null) {
        throw new b("Not all required fields were included: addr");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localo.ndO = locala.xpH.oD();
        return 0;
      case 2: 
        localo.name = locala.xpH.readString();
        return 0;
      case 3: 
        localo.lCF = locala.xpH.readString();
        return 0;
      case 4: 
        localo.ndP = locala.xpH.oD();
        return 0;
      }
      localo.ndQ = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.o
 * JD-Core Version:    0.7.0.1
 */