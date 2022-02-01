package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cij
  extends com.tencent.mm.bx.a
{
  public String CEQ;
  public int Ebj;
  public String oXi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32411);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oXi != null) {
        paramVarArgs.d(1, this.oXi);
      }
      if (this.CEQ != null) {
        paramVarArgs.d(2, this.CEQ);
      }
      paramVarArgs.aR(3, this.Ebj);
      AppMethodBeat.o(32411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oXi == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.oXi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CEQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CEQ);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.Ebj);
      AppMethodBeat.o(32411);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32411);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cij localcij = (cij)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32411);
          return -1;
        case 1: 
          localcij.oXi = locala.KhF.readString();
          AppMethodBeat.o(32411);
          return 0;
        case 2: 
          localcij.CEQ = locala.KhF.readString();
          AppMethodBeat.o(32411);
          return 0;
        }
        localcij.Ebj = locala.KhF.xS();
        AppMethodBeat.o(32411);
        return 0;
      }
      AppMethodBeat.o(32411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cij
 * JD-Core Version:    0.7.0.1
 */