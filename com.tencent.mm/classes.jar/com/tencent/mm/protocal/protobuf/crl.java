package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crl
  extends com.tencent.mm.bx.a
{
  public String HjP;
  public String HjQ;
  public int HjR;
  public int HjS = 0;
  public String HjT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117895);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HjP != null) {
        paramVarArgs.d(1, this.HjP);
      }
      if (this.HjQ != null) {
        paramVarArgs.d(2, this.HjQ);
      }
      paramVarArgs.aS(3, this.HjR);
      paramVarArgs.aS(4, this.HjS);
      if (this.HjT != null) {
        paramVarArgs.d(5, this.HjT);
      }
      AppMethodBeat.o(117895);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HjP == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.HjP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HjQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HjQ);
      }
      i = i + f.a.a.b.b.a.bz(3, this.HjR) + f.a.a.b.b.a.bz(4, this.HjS);
      paramInt = i;
      if (this.HjT != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HjT);
      }
      AppMethodBeat.o(117895);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117895);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        crl localcrl = (crl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117895);
          return -1;
        case 1: 
          localcrl.HjP = locala.NPN.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 2: 
          localcrl.HjQ = locala.NPN.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 3: 
          localcrl.HjR = locala.NPN.zc();
          AppMethodBeat.o(117895);
          return 0;
        case 4: 
          localcrl.HjS = locala.NPN.zc();
          AppMethodBeat.o(117895);
          return 0;
        }
        localcrl.HjT = locala.NPN.readString();
        AppMethodBeat.o(117895);
        return 0;
      }
      AppMethodBeat.o(117895);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crl
 * JD-Core Version:    0.7.0.1
 */