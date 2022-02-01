package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zd
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String Dtb;
  public String Slg;
  public String Slh;
  public String Sli;
  public String Slj;
  public String Slk;
  public String Sll;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127628);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CPw);
      paramVarArgs.aY(2, this.rWu);
      if (this.Slg != null) {
        paramVarArgs.f(3, this.Slg);
      }
      if (this.Slh != null) {
        paramVarArgs.f(4, this.Slh);
      }
      if (this.Dtb != null) {
        paramVarArgs.f(5, this.Dtb);
      }
      if (this.Sli != null) {
        paramVarArgs.f(6, this.Sli);
      }
      if (this.Slj != null) {
        paramVarArgs.f(7, this.Slj);
      }
      if (this.Slk != null) {
        paramVarArgs.f(8, this.Slk);
      }
      if (this.Sll != null) {
        paramVarArgs.f(9, this.Sll);
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CPw) + 0 + g.a.a.b.b.a.bM(2, this.rWu);
      paramInt = i;
      if (this.Slg != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Slg);
      }
      i = paramInt;
      if (this.Slh != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Slh);
      }
      paramInt = i;
      if (this.Dtb != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Dtb);
      }
      i = paramInt;
      if (this.Sli != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Sli);
      }
      paramInt = i;
      if (this.Slj != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Slj);
      }
      i = paramInt;
      if (this.Slk != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Slk);
      }
      paramInt = i;
      if (this.Sll != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Sll);
      }
      AppMethodBeat.o(127628);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      zd localzd = (zd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127628);
        return -1;
      case 1: 
        localzd.CPw = locala.abFh.AK();
        AppMethodBeat.o(127628);
        return 0;
      case 2: 
        localzd.rWu = locala.abFh.AK();
        AppMethodBeat.o(127628);
        return 0;
      case 3: 
        localzd.Slg = locala.abFh.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 4: 
        localzd.Slh = locala.abFh.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 5: 
        localzd.Dtb = locala.abFh.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 6: 
        localzd.Sli = locala.abFh.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 7: 
        localzd.Slj = locala.abFh.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 8: 
        localzd.Slk = locala.abFh.readString();
        AppMethodBeat.o(127628);
        return 0;
      }
      localzd.Sll = locala.abFh.readString();
      AppMethodBeat.o(127628);
      return 0;
    }
    AppMethodBeat.o(127628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zd
 * JD-Core Version:    0.7.0.1
 */