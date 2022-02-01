package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class elx
  extends com.tencent.mm.cd.a
{
  public String UnQ;
  public String UnR;
  public int UnS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200393);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UnQ != null) {
        paramVarArgs.f(1, this.UnQ);
      }
      if (this.UnR != null) {
        paramVarArgs.f(2, this.UnR);
      }
      paramVarArgs.aY(3, this.UnS);
      AppMethodBeat.o(200393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UnQ == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.UnQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UnR != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UnR);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.UnS);
      AppMethodBeat.o(200393);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200393);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        elx localelx = (elx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200393);
          return -1;
        case 1: 
          localelx.UnQ = locala.abFh.readString();
          AppMethodBeat.o(200393);
          return 0;
        case 2: 
          localelx.UnR = locala.abFh.readString();
          AppMethodBeat.o(200393);
          return 0;
        }
        localelx.UnS = locala.abFh.AK();
        AppMethodBeat.o(200393);
        return 0;
      }
      AppMethodBeat.o(200393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elx
 * JD-Core Version:    0.7.0.1
 */