package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ir
  extends com.tencent.mm.cd.a
{
  public String DNV;
  public String IfQ;
  public String ROm;
  public String ROo;
  public boolean ROy;
  public String ROz;
  public String fvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19405);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.DNV != null) {
        paramVarArgs.f(1, this.DNV);
      }
      if (this.IfQ != null) {
        paramVarArgs.f(2, this.IfQ);
      }
      if (this.fvP != null) {
        paramVarArgs.f(3, this.fvP);
      }
      paramVarArgs.co(4, this.ROy);
      if (this.ROo != null) {
        paramVarArgs.f(5, this.ROo);
      }
      if (this.ROm != null) {
        paramVarArgs.f(6, this.ROm);
      }
      if (this.ROz != null) {
        paramVarArgs.f(7, this.ROz);
      }
      AppMethodBeat.o(19405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DNV == null) {
        break label575;
      }
    }
    label575:
    for (int i = g.a.a.b.b.a.g(1, this.DNV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IfQ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.IfQ);
      }
      i = paramInt;
      if (this.fvP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fvP);
      }
      i += g.a.a.b.b.a.gL(4) + 1;
      paramInt = i;
      if (this.ROo != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ROo);
      }
      i = paramInt;
      if (this.ROm != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ROm);
      }
      paramInt = i;
      if (this.ROz != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ROz);
      }
      AppMethodBeat.o(19405);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(19405);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ir localir = (ir)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(19405);
          return -1;
        case 1: 
          localir.DNV = locala.abFh.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 2: 
          localir.IfQ = locala.abFh.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 3: 
          localir.fvP = locala.abFh.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 4: 
          localir.ROy = locala.abFh.AB();
          AppMethodBeat.o(19405);
          return 0;
        case 5: 
          localir.ROo = locala.abFh.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 6: 
          localir.ROm = locala.abFh.readString();
          AppMethodBeat.o(19405);
          return 0;
        }
        localir.ROz = locala.abFh.readString();
        AppMethodBeat.o(19405);
        return 0;
      }
      AppMethodBeat.o(19405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ir
 * JD-Core Version:    0.7.0.1
 */