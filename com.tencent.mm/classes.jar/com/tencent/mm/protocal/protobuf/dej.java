package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dej
  extends com.tencent.mm.bx.a
{
  public String HsK;
  public String HsL;
  public String HsM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HsK != null) {
        paramVarArgs.d(1, this.HsK);
      }
      if (this.HsL != null) {
        paramVarArgs.d(2, this.HsL);
      }
      if (this.HsM != null) {
        paramVarArgs.d(3, this.HsM);
      }
      AppMethodBeat.o(32455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HsK == null) {
        break label343;
      }
    }
    label343:
    for (int i = f.a.a.b.b.a.e(1, this.HsK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HsL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HsL);
      }
      i = paramInt;
      if (this.HsM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HsM);
      }
      AppMethodBeat.o(32455);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32455);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dej localdej = (dej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32455);
          return -1;
        case 1: 
          localdej.HsK = locala.NPN.readString();
          AppMethodBeat.o(32455);
          return 0;
        case 2: 
          localdej.HsL = locala.NPN.readString();
          AppMethodBeat.o(32455);
          return 0;
        }
        localdej.HsM = locala.NPN.readString();
        AppMethodBeat.o(32455);
        return 0;
      }
      AppMethodBeat.o(32455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dej
 * JD-Core Version:    0.7.0.1
 */