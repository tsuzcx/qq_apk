package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akd
  extends com.tencent.mm.cd.a
{
  public String SuS;
  public String SuT;
  public int vhF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200569);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SuS != null) {
        paramVarArgs.f(1, this.SuS);
      }
      if (this.SuT != null) {
        paramVarArgs.f(2, this.SuT);
      }
      paramVarArgs.aY(3, this.vhF);
      AppMethodBeat.o(200569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SuS == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.SuS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SuT != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SuT);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.vhF);
      AppMethodBeat.o(200569);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200569);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        akd localakd = (akd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200569);
          return -1;
        case 1: 
          localakd.SuS = locala.abFh.readString();
          AppMethodBeat.o(200569);
          return 0;
        case 2: 
          localakd.SuT = locala.abFh.readString();
          AppMethodBeat.o(200569);
          return 0;
        }
        localakd.vhF = locala.abFh.AK();
        AppMethodBeat.o(200569);
        return 0;
      }
      AppMethodBeat.o(200569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akd
 * JD-Core Version:    0.7.0.1
 */