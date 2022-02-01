package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzu
  extends com.tencent.mm.bx.a
{
  public String Fsb;
  public boolean HMO;
  public String HMP;
  public int HMQ;
  public int HMR;
  public int HMS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147805);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.HMO);
      if (this.Fsb != null) {
        paramVarArgs.d(2, this.Fsb);
      }
      if (this.HMP != null) {
        paramVarArgs.d(3, this.HMP);
      }
      paramVarArgs.aS(4, this.HMQ);
      paramVarArgs.aS(5, this.HMR);
      paramVarArgs.aS(6, this.HMS);
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0;
      paramInt = i;
      if (this.Fsb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fsb);
      }
      i = paramInt;
      if (this.HMP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HMP);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HMQ);
      int j = f.a.a.b.b.a.bz(5, this.HMR);
      int k = f.a.a.b.b.a.bz(6, this.HMS);
      AppMethodBeat.o(147805);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzu localdzu = (dzu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147805);
        return -1;
      case 1: 
        localdzu.HMO = locala.NPN.grw();
        AppMethodBeat.o(147805);
        return 0;
      case 2: 
        localdzu.Fsb = locala.NPN.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 3: 
        localdzu.HMP = locala.NPN.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 4: 
        localdzu.HMQ = locala.NPN.zc();
        AppMethodBeat.o(147805);
        return 0;
      case 5: 
        localdzu.HMR = locala.NPN.zc();
        AppMethodBeat.o(147805);
        return 0;
      }
      localdzu.HMS = locala.NPN.zc();
      AppMethodBeat.o(147805);
      return 0;
    }
    AppMethodBeat.o(147805);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzu
 * JD-Core Version:    0.7.0.1
 */