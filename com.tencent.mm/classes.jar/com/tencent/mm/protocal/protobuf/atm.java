package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class atm
  extends com.tencent.mm.bx.a
{
  public String GrB;
  public long GrC;
  public int dqI;
  public String id;
  public int tnE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32213);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      paramVarArgs.aS(2, this.tnE);
      if (this.GrB != null) {
        paramVarArgs.d(3, this.GrB);
      }
      paramVarArgs.aY(4, this.GrC);
      paramVarArgs.aS(5, this.dqI);
      AppMethodBeat.o(32213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label421;
      }
    }
    label421:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.tnE);
      paramInt = i;
      if (this.GrB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GrB);
      }
      i = f.a.a.b.b.a.p(4, this.GrC);
      int j = f.a.a.b.b.a.bz(5, this.dqI);
      AppMethodBeat.o(32213);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32213);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        atm localatm = (atm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32213);
          return -1;
        case 1: 
          localatm.id = locala.NPN.readString();
          AppMethodBeat.o(32213);
          return 0;
        case 2: 
          localatm.tnE = locala.NPN.zc();
          AppMethodBeat.o(32213);
          return 0;
        case 3: 
          localatm.GrB = locala.NPN.readString();
          AppMethodBeat.o(32213);
          return 0;
        case 4: 
          localatm.GrC = locala.NPN.zd();
          AppMethodBeat.o(32213);
          return 0;
        }
        localatm.dqI = locala.NPN.zc();
        AppMethodBeat.o(32213);
        return 0;
      }
      AppMethodBeat.o(32213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atm
 * JD-Core Version:    0.7.0.1
 */