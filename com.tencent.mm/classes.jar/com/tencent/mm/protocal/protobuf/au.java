package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class au
  extends com.tencent.mm.bx.a
{
  public String oyT;
  public String oyU;
  public String oyV;
  public String oyW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113931);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oyT != null) {
        paramVarArgs.d(1, this.oyT);
      }
      if (this.oyU != null) {
        paramVarArgs.d(2, this.oyU);
      }
      if (this.oyV != null) {
        paramVarArgs.d(3, this.oyV);
      }
      if (this.oyW != null) {
        paramVarArgs.d(4, this.oyW);
      }
      AppMethodBeat.o(113931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oyT == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.oyT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oyU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oyU);
      }
      i = paramInt;
      if (this.oyV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oyV);
      }
      paramInt = i;
      if (this.oyW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oyW);
      }
      AppMethodBeat.o(113931);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113931);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113931);
          return -1;
        case 1: 
          localau.oyT = locala.NPN.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 2: 
          localau.oyU = locala.NPN.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 3: 
          localau.oyV = locala.NPN.readString();
          AppMethodBeat.o(113931);
          return 0;
        }
        localau.oyW = locala.NPN.readString();
        AppMethodBeat.o(113931);
        return 0;
      }
      AppMethodBeat.o(113931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.au
 * JD-Core Version:    0.7.0.1
 */