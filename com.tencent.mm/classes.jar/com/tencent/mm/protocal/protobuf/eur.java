package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eur
  extends com.tencent.mm.bx.a
{
  public int oKu;
  public String resolution;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116475);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.resolution != null) {
        paramVarArgs.g(1, this.resolution);
      }
      paramVarArgs.bS(2, this.oKu);
      AppMethodBeat.o(116475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.resolution == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.resolution) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.oKu);
      AppMethodBeat.o(116475);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116475);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eur localeur = (eur)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116475);
          return -1;
        case 1: 
          localeur.resolution = locala.ajGk.readString();
          AppMethodBeat.o(116475);
          return 0;
        }
        localeur.oKu = locala.ajGk.aar();
        AppMethodBeat.o(116475);
        return 0;
      }
      AppMethodBeat.o(116475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eur
 * JD-Core Version:    0.7.0.1
 */