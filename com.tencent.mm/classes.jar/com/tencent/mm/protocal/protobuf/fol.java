package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fol
  extends com.tencent.mm.bx.a
{
  public long ADo;
  public int Bbt;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258117);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      paramVarArgs.bS(2, this.Bbt);
      paramVarArgs.bv(3, this.ADo);
      AppMethodBeat.o(258117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.name) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Bbt);
      int j = i.a.a.b.b.a.q(3, this.ADo);
      AppMethodBeat.o(258117);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258117);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fol localfol = (fol)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258117);
          return -1;
        case 1: 
          localfol.name = locala.ajGk.readString();
          AppMethodBeat.o(258117);
          return 0;
        case 2: 
          localfol.Bbt = locala.ajGk.aar();
          AppMethodBeat.o(258117);
          return 0;
        }
        localfol.ADo = locala.ajGk.aaw();
        AppMethodBeat.o(258117);
        return 0;
      }
      AppMethodBeat.o(258117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fol
 * JD-Core Version:    0.7.0.1
 */