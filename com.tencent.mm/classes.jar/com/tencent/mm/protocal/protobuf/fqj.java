package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fqj
  extends com.tencent.mm.cd.a
{
  public String CSc;
  public String CSe;
  public String CSf;
  public int CSg;
  public String Cqt;
  public int UOf;
  public String UOg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152730);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UOf);
      if (this.Cqt != null) {
        paramVarArgs.f(2, this.Cqt);
      }
      if (this.CSc != null) {
        paramVarArgs.f(3, this.CSc);
      }
      if (this.UOg != null) {
        paramVarArgs.f(4, this.UOg);
      }
      if (this.CSe != null) {
        paramVarArgs.f(5, this.CSe);
      }
      if (this.CSf != null) {
        paramVarArgs.f(6, this.CSf);
      }
      paramVarArgs.aY(7, this.CSg);
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.UOf) + 0;
      paramInt = i;
      if (this.Cqt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Cqt);
      }
      i = paramInt;
      if (this.CSc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CSc);
      }
      paramInt = i;
      if (this.UOg != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UOg);
      }
      i = paramInt;
      if (this.CSe != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CSe);
      }
      paramInt = i;
      if (this.CSf != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CSf);
      }
      i = g.a.a.b.b.a.bM(7, this.CSg);
      AppMethodBeat.o(152730);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fqj localfqj = (fqj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152730);
        return -1;
      case 1: 
        localfqj.UOf = locala.abFh.AK();
        AppMethodBeat.o(152730);
        return 0;
      case 2: 
        localfqj.Cqt = locala.abFh.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 3: 
        localfqj.CSc = locala.abFh.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 4: 
        localfqj.UOg = locala.abFh.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 5: 
        localfqj.CSe = locala.abFh.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 6: 
        localfqj.CSf = locala.abFh.readString();
        AppMethodBeat.o(152730);
        return 0;
      }
      localfqj.CSg = locala.abFh.AK();
      AppMethodBeat.o(152730);
      return 0;
    }
    AppMethodBeat.o(152730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqj
 * JD-Core Version:    0.7.0.1
 */