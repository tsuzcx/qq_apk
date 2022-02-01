package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dww
  extends com.tencent.mm.bx.a
{
  public int DTx;
  public String EKK;
  public boolean EKP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EKK != null) {
        paramVarArgs.d(1, this.EKK);
      }
      paramVarArgs.bg(2, this.EKP);
      paramVarArgs.aR(3, this.DTx);
      AppMethodBeat.o(50127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EKK == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = f.a.a.b.b.a.e(1, this.EKK) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.bA(3, this.DTx);
      AppMethodBeat.o(50127);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(50127);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dww localdww = (dww)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50127);
          return -1;
        case 1: 
          localdww.EKK = locala.KhF.readString();
          AppMethodBeat.o(50127);
          return 0;
        case 2: 
          localdww.EKP = locala.KhF.fHu();
          AppMethodBeat.o(50127);
          return 0;
        }
        localdww.DTx = locala.KhF.xS();
        AppMethodBeat.o(50127);
        return 0;
      }
      AppMethodBeat.o(50127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dww
 * JD-Core Version:    0.7.0.1
 */