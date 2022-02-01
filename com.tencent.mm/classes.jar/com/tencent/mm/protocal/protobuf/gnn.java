package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gnn
  extends com.tencent.mm.bx.a
{
  public int abdZ;
  public boolean aciC;
  public String acix;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50127);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acix != null) {
        paramVarArgs.g(1, this.acix);
      }
      paramVarArgs.di(2, this.aciC);
      paramVarArgs.bS(3, this.abdZ);
      AppMethodBeat.o(50127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acix == null) {
        break label298;
      }
    }
    label298:
    for (paramInt = i.a.a.b.b.a.h(1, this.acix) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.cJ(3, this.abdZ);
      AppMethodBeat.o(50127);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50127);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gnn localgnn = (gnn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50127);
          return -1;
        case 1: 
          localgnn.acix = locala.ajGk.readString();
          AppMethodBeat.o(50127);
          return 0;
        case 2: 
          localgnn.aciC = locala.ajGk.aai();
          AppMethodBeat.o(50127);
          return 0;
        }
        localgnn.abdZ = locala.ajGk.aar();
        AppMethodBeat.o(50127);
        return 0;
      }
      AppMethodBeat.o(50127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnn
 * JD-Core Version:    0.7.0.1
 */