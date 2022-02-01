package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dqe
  extends com.tencent.mm.bx.a
{
  public int HEq;
  public int HEr;
  public String HEs;
  public b HEt;
  public int HEu;
  public int HEv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HEq);
      paramVarArgs.aS(2, this.HEr);
      if (this.HEs != null) {
        paramVarArgs.d(3, this.HEs);
      }
      if (this.HEt != null) {
        paramVarArgs.c(4, this.HEt);
      }
      paramVarArgs.aS(5, this.HEu);
      paramVarArgs.aS(6, this.HEv);
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HEq) + 0 + f.a.a.b.b.a.bz(2, this.HEr);
      paramInt = i;
      if (this.HEs != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HEs);
      }
      i = paramInt;
      if (this.HEt != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.HEt);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.HEu);
      int j = f.a.a.b.b.a.bz(6, this.HEv);
      AppMethodBeat.o(82481);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dqe localdqe = (dqe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(82481);
        return -1;
      case 1: 
        localdqe.HEq = locala.NPN.zc();
        AppMethodBeat.o(82481);
        return 0;
      case 2: 
        localdqe.HEr = locala.NPN.zc();
        AppMethodBeat.o(82481);
        return 0;
      case 3: 
        localdqe.HEs = locala.NPN.readString();
        AppMethodBeat.o(82481);
        return 0;
      case 4: 
        localdqe.HEt = locala.NPN.gxI();
        AppMethodBeat.o(82481);
        return 0;
      case 5: 
        localdqe.HEu = locala.NPN.zc();
        AppMethodBeat.o(82481);
        return 0;
      }
      localdqe.HEv = locala.NPN.zc();
      AppMethodBeat.o(82481);
      return 0;
    }
    AppMethodBeat.o(82481);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqe
 * JD-Core Version:    0.7.0.1
 */