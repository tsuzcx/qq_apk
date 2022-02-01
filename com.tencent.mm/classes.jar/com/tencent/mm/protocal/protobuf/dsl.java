package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsl
  extends com.tencent.mm.bw.a
{
  public String MUO;
  public int MUP;
  public String dSf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152686);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MUO != null) {
        paramVarArgs.e(1, this.MUO);
      }
      if (this.dSf != null) {
        paramVarArgs.e(2, this.dSf);
      }
      paramVarArgs.aM(3, this.MUP);
      AppMethodBeat.o(152686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MUO == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.MUO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dSf != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dSf);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MUP);
      AppMethodBeat.o(152686);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152686);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dsl localdsl = (dsl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152686);
          return -1;
        case 1: 
          localdsl.MUO = locala.UbS.readString();
          AppMethodBeat.o(152686);
          return 0;
        case 2: 
          localdsl.dSf = locala.UbS.readString();
          AppMethodBeat.o(152686);
          return 0;
        }
        localdsl.MUP = locala.UbS.zi();
        AppMethodBeat.o(152686);
        return 0;
      }
      AppMethodBeat.o(152686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsl
 * JD-Core Version:    0.7.0.1
 */