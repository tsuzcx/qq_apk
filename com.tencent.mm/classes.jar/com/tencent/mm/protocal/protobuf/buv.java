package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buv
  extends com.tencent.mm.bx.a
{
  public String GOO;
  public String GOP;
  public int GOQ;
  public int GOR;
  public long GOS;
  public long GOT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211969);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GOO != null) {
        paramVarArgs.d(1, this.GOO);
      }
      if (this.GOP != null) {
        paramVarArgs.d(2, this.GOP);
      }
      paramVarArgs.aS(3, this.GOQ);
      paramVarArgs.aS(4, this.GOR);
      paramVarArgs.aY(5, this.GOS);
      paramVarArgs.aY(6, this.GOT);
      AppMethodBeat.o(211969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GOO == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.GOO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GOP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GOP);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GOQ);
      int j = f.a.a.b.b.a.bz(4, this.GOR);
      int k = f.a.a.b.b.a.p(5, this.GOS);
      int m = f.a.a.b.b.a.p(6, this.GOT);
      AppMethodBeat.o(211969);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(211969);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        buv localbuv = (buv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211969);
          return -1;
        case 1: 
          localbuv.GOO = locala.NPN.readString();
          AppMethodBeat.o(211969);
          return 0;
        case 2: 
          localbuv.GOP = locala.NPN.readString();
          AppMethodBeat.o(211969);
          return 0;
        case 3: 
          localbuv.GOQ = locala.NPN.zc();
          AppMethodBeat.o(211969);
          return 0;
        case 4: 
          localbuv.GOR = locala.NPN.zc();
          AppMethodBeat.o(211969);
          return 0;
        case 5: 
          localbuv.GOS = locala.NPN.zd();
          AppMethodBeat.o(211969);
          return 0;
        }
        localbuv.GOT = locala.NPN.zd();
        AppMethodBeat.o(211969);
        return 0;
      }
      AppMethodBeat.o(211969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buv
 * JD-Core Version:    0.7.0.1
 */