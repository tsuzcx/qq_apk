package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddj
  extends com.tencent.mm.bx.a
{
  public int FKm;
  public String dHX;
  public int oBB;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114074);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dHX != null) {
        paramVarArgs.d(1, this.dHX);
      }
      paramVarArgs.aS(2, this.oBB);
      paramVarArgs.aS(3, this.FKm);
      paramVarArgs.aY(4, this.seq);
      AppMethodBeat.o(114074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dHX == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.dHX) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.oBB);
      int j = f.a.a.b.b.a.bz(3, this.FKm);
      int k = f.a.a.b.b.a.p(4, this.seq);
      AppMethodBeat.o(114074);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114074);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddj localddj = (ddj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114074);
          return -1;
        case 1: 
          localddj.dHX = locala.NPN.readString();
          AppMethodBeat.o(114074);
          return 0;
        case 2: 
          localddj.oBB = locala.NPN.zc();
          AppMethodBeat.o(114074);
          return 0;
        case 3: 
          localddj.FKm = locala.NPN.zc();
          AppMethodBeat.o(114074);
          return 0;
        }
        localddj.seq = locala.NPN.zd();
        AppMethodBeat.o(114074);
        return 0;
      }
      AppMethodBeat.o(114074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddj
 * JD-Core Version:    0.7.0.1
 */