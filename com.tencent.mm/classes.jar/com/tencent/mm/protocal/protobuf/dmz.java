package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dmz
  extends com.tencent.mm.bx.a
{
  public String FxR;
  public String hzB;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124569);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FxR != null) {
        paramVarArgs.d(1, this.FxR);
      }
      if (this.hzB != null) {
        paramVarArgs.d(2, this.hzB);
      }
      paramVarArgs.aS(3, this.weight);
      AppMethodBeat.o(124569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FxR == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.FxR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hzB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hzB);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.weight);
      AppMethodBeat.o(124569);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124569);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dmz localdmz = (dmz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124569);
          return -1;
        case 1: 
          localdmz.FxR = locala.NPN.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 2: 
          localdmz.hzB = locala.NPN.readString();
          AppMethodBeat.o(124569);
          return 0;
        }
        localdmz.weight = locala.NPN.zc();
        AppMethodBeat.o(124569);
        return 0;
      }
      AppMethodBeat.o(124569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmz
 * JD-Core Version:    0.7.0.1
 */