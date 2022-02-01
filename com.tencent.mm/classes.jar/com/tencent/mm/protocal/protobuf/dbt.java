package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbt
  extends com.tencent.mm.cd.a
{
  public int SpF;
  public int TJp;
  public String TJq;
  public String TJr;
  public String ThL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115847);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ThL != null) {
        paramVarArgs.f(1, this.ThL);
      }
      paramVarArgs.aY(2, this.TJp);
      if (this.TJq != null) {
        paramVarArgs.f(3, this.TJq);
      }
      paramVarArgs.aY(4, this.SpF);
      if (this.TJr != null) {
        paramVarArgs.f(5, this.TJr);
      }
      AppMethodBeat.o(115847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ThL == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.g(1, this.ThL) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TJp);
      paramInt = i;
      if (this.TJq != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TJq);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.SpF);
      paramInt = i;
      if (this.TJr != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TJr);
      }
      AppMethodBeat.o(115847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(115847);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dbt localdbt = (dbt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115847);
          return -1;
        case 1: 
          localdbt.ThL = locala.abFh.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 2: 
          localdbt.TJp = locala.abFh.AK();
          AppMethodBeat.o(115847);
          return 0;
        case 3: 
          localdbt.TJq = locala.abFh.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 4: 
          localdbt.SpF = locala.abFh.AK();
          AppMethodBeat.o(115847);
          return 0;
        }
        localdbt.TJr = locala.abFh.readString();
        AppMethodBeat.o(115847);
        return 0;
      }
      AppMethodBeat.o(115847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbt
 * JD-Core Version:    0.7.0.1
 */