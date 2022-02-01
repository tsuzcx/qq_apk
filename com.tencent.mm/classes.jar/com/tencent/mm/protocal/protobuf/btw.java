package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btw
  extends com.tencent.mm.bw.a
{
  public int FJl;
  public String GYJ;
  public String HgS;
  public boolean HgT;
  public String HgU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123623);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FJl);
      if (this.HgS != null) {
        paramVarArgs.d(2, this.HgS);
      }
      paramVarArgs.bC(3, this.HgT);
      if (this.HgU != null) {
        paramVarArgs.d(4, this.HgU);
      }
      if (this.GYJ != null) {
        paramVarArgs.d(5, this.GYJ);
      }
      AppMethodBeat.o(123623);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FJl) + 0;
      paramInt = i;
      if (this.HgS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HgS);
      }
      i = paramInt + f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.HgU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HgU);
      }
      i = paramInt;
      if (this.GYJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GYJ);
      }
      AppMethodBeat.o(123623);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(123623);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btw localbtw = (btw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123623);
        return -1;
      case 1: 
        localbtw.FJl = locala.OmT.zc();
        AppMethodBeat.o(123623);
        return 0;
      case 2: 
        localbtw.HgS = locala.OmT.readString();
        AppMethodBeat.o(123623);
        return 0;
      case 3: 
        localbtw.HgT = locala.OmT.gvY();
        AppMethodBeat.o(123623);
        return 0;
      case 4: 
        localbtw.HgU = locala.OmT.readString();
        AppMethodBeat.o(123623);
        return 0;
      }
      localbtw.GYJ = locala.OmT.readString();
      AppMethodBeat.o(123623);
      return 0;
    }
    AppMethodBeat.o(123623);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btw
 * JD-Core Version:    0.7.0.1
 */