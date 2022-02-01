package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class beu
  extends com.tencent.mm.bx.a
{
  public String ZOX;
  public String ZPd;
  public long begin_time;
  public long wwF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258629);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOX != null) {
        paramVarArgs.g(1, this.ZOX);
      }
      paramVarArgs.bv(2, this.begin_time);
      paramVarArgs.bv(3, this.wwF);
      if (this.ZPd != null) {
        paramVarArgs.g(4, this.ZPd);
      }
      AppMethodBeat.o(258629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOX == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZOX) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.begin_time) + i.a.a.b.b.a.q(3, this.wwF);
      paramInt = i;
      if (this.ZPd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZPd);
      }
      AppMethodBeat.o(258629);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258629);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        beu localbeu = (beu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258629);
          return -1;
        case 1: 
          localbeu.ZOX = locala.ajGk.readString();
          AppMethodBeat.o(258629);
          return 0;
        case 2: 
          localbeu.begin_time = locala.ajGk.aaw();
          AppMethodBeat.o(258629);
          return 0;
        case 3: 
          localbeu.wwF = locala.ajGk.aaw();
          AppMethodBeat.o(258629);
          return 0;
        }
        localbeu.ZPd = locala.ajGk.readString();
        AppMethodBeat.o(258629);
        return 0;
      }
      AppMethodBeat.o(258629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beu
 * JD-Core Version:    0.7.0.1
 */