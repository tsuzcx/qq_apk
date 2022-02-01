package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlh
  extends com.tencent.mm.bx.a
{
  public String YRR;
  public boolean aaRk;
  public int aaRl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259207);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRR != null) {
        paramVarArgs.g(1, this.YRR);
      }
      paramVarArgs.di(2, this.aaRk);
      paramVarArgs.bS(3, this.aaRl);
      AppMethodBeat.o(259207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRR == null) {
        break label298;
      }
    }
    label298:
    for (paramInt = i.a.a.b.b.a.h(1, this.YRR) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.cJ(3, this.aaRl);
      AppMethodBeat.o(259207);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259207);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dlh localdlh = (dlh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259207);
          return -1;
        case 1: 
          localdlh.YRR = locala.ajGk.readString();
          AppMethodBeat.o(259207);
          return 0;
        case 2: 
          localdlh.aaRk = locala.ajGk.aai();
          AppMethodBeat.o(259207);
          return 0;
        }
        localdlh.aaRl = locala.ajGk.aar();
        AppMethodBeat.o(259207);
        return 0;
      }
      AppMethodBeat.o(259207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlh
 * JD-Core Version:    0.7.0.1
 */