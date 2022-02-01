package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class evo
  extends com.tencent.mm.cd.a
{
  public String DNV;
  public String GGC;
  public String ROm;
  public String ROn;
  public String fvP;
  public String llI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72615);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fvP != null) {
        paramVarArgs.f(1, this.fvP);
      }
      if (this.llI != null) {
        paramVarArgs.f(2, this.llI);
      }
      if (this.DNV != null) {
        paramVarArgs.f(3, this.DNV);
      }
      if (this.GGC != null) {
        paramVarArgs.f(4, this.GGC);
      }
      if (this.ROm != null) {
        paramVarArgs.f(5, this.ROm);
      }
      if (this.ROn != null) {
        paramVarArgs.f(6, this.ROn);
      }
      AppMethodBeat.o(72615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fvP == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.g(1, this.fvP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.llI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.llI);
      }
      i = paramInt;
      if (this.DNV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.DNV);
      }
      paramInt = i;
      if (this.GGC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.GGC);
      }
      i = paramInt;
      if (this.ROm != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ROm);
      }
      paramInt = i;
      if (this.ROn != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ROn);
      }
      AppMethodBeat.o(72615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72615);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        evo localevo = (evo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72615);
          return -1;
        case 1: 
          localevo.fvP = locala.abFh.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 2: 
          localevo.llI = locala.abFh.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 3: 
          localevo.DNV = locala.abFh.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 4: 
          localevo.GGC = locala.abFh.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 5: 
          localevo.ROm = locala.abFh.readString();
          AppMethodBeat.o(72615);
          return 0;
        }
        localevo.ROn = locala.abFh.readString();
        AppMethodBeat.o(72615);
        return 0;
      }
      AppMethodBeat.o(72615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evo
 * JD-Core Version:    0.7.0.1
 */