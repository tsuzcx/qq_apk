package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ut
  extends com.tencent.mm.bx.a
{
  public int FKm;
  public String FUo;
  public String dHX;
  public String oBR;
  public int oxQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113981);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dHX != null) {
        paramVarArgs.d(1, this.dHX);
      }
      if (this.oBR != null) {
        paramVarArgs.d(2, this.oBR);
      }
      paramVarArgs.aS(3, this.oxQ);
      paramVarArgs.aS(4, this.FKm);
      if (this.FUo != null) {
        paramVarArgs.d(5, this.FUo);
      }
      AppMethodBeat.o(113981);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dHX == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.dHX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oBR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oBR);
      }
      i = i + f.a.a.b.b.a.bz(3, this.oxQ) + f.a.a.b.b.a.bz(4, this.FKm);
      paramInt = i;
      if (this.FUo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FUo);
      }
      AppMethodBeat.o(113981);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113981);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ut localut = (ut)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113981);
          return -1;
        case 1: 
          localut.dHX = locala.NPN.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 2: 
          localut.oBR = locala.NPN.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 3: 
          localut.oxQ = locala.NPN.zc();
          AppMethodBeat.o(113981);
          return 0;
        case 4: 
          localut.FKm = locala.NPN.zc();
          AppMethodBeat.o(113981);
          return 0;
        }
        localut.FUo = locala.NPN.readString();
        AppMethodBeat.o(113981);
        return 0;
      }
      AppMethodBeat.o(113981);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ut
 * JD-Core Version:    0.7.0.1
 */