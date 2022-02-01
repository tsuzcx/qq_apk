package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fkl
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b RLr;
  public int RVD;
  public boolean UJe;
  public boolean UJf;
  public String Ueg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32564);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ueg == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32564);
        throw paramVarArgs;
      }
      if (this.Ueg != null) {
        paramVarArgs.f(1, this.Ueg);
      }
      paramVarArgs.aY(2, this.RVD);
      if (this.RLr != null) {
        paramVarArgs.c(3, this.RLr);
      }
      paramVarArgs.co(4, this.UJe);
      paramVarArgs.co(5, this.UJf);
      AppMethodBeat.o(32564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ueg == null) {
        break label465;
      }
    }
    label465:
    for (paramInt = g.a.a.b.b.a.g(1, this.Ueg) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RVD);
      paramInt = i;
      if (this.RLr != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.RLr);
      }
      i = g.a.a.b.b.a.gL(4);
      int j = g.a.a.b.b.a.gL(5);
      AppMethodBeat.o(32564);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Ueg == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32564);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32564);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fkl localfkl = (fkl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32564);
          return -1;
        case 1: 
          localfkl.Ueg = locala.abFh.readString();
          AppMethodBeat.o(32564);
          return 0;
        case 2: 
          localfkl.RVD = locala.abFh.AK();
          AppMethodBeat.o(32564);
          return 0;
        case 3: 
          localfkl.RLr = locala.abFh.iUw();
          AppMethodBeat.o(32564);
          return 0;
        case 4: 
          localfkl.UJe = locala.abFh.AB();
          AppMethodBeat.o(32564);
          return 0;
        }
        localfkl.UJf = locala.abFh.AB();
        AppMethodBeat.o(32564);
        return 0;
      }
      AppMethodBeat.o(32564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkl
 * JD-Core Version:    0.7.0.1
 */