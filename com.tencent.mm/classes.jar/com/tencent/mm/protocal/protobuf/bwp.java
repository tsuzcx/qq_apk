package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwp
  extends com.tencent.mm.bx.a
{
  public String aafB;
  public long aafC;
  public boolean aafD;
  public int icon;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258512);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aafB != null) {
        paramVarArgs.g(1, this.aafB);
      }
      paramVarArgs.bv(2, this.aafC);
      paramVarArgs.di(3, this.aafD);
      paramVarArgs.bS(4, this.icon);
      AppMethodBeat.o(258512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aafB == null) {
        break label346;
      }
    }
    label346:
    for (paramInt = i.a.a.b.b.a.h(1, this.aafB) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.aafC);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.cJ(4, this.icon);
      AppMethodBeat.o(258512);
      return paramInt + i + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258512);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bwp localbwp = (bwp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258512);
          return -1;
        case 1: 
          localbwp.aafB = locala.ajGk.readString();
          AppMethodBeat.o(258512);
          return 0;
        case 2: 
          localbwp.aafC = locala.ajGk.aaw();
          AppMethodBeat.o(258512);
          return 0;
        case 3: 
          localbwp.aafD = locala.ajGk.aai();
          AppMethodBeat.o(258512);
          return 0;
        }
        localbwp.icon = locala.ajGk.aar();
        AppMethodBeat.o(258512);
        return 0;
      }
      AppMethodBeat.o(258512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwp
 * JD-Core Version:    0.7.0.1
 */