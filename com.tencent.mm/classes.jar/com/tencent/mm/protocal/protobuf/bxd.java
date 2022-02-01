package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxd
  extends com.tencent.mm.bw.a
{
  public String FlV;
  public String FlW;
  public String FlX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63277);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FlV != null) {
        paramVarArgs.d(1, this.FlV);
      }
      if (this.FlW != null) {
        paramVarArgs.d(2, this.FlW);
      }
      if (this.FlX != null) {
        paramVarArgs.d(3, this.FlX);
      }
      AppMethodBeat.o(63277);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FlV == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.FlV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FlW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FlW);
      }
      i = paramInt;
      if (this.FlX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FlX);
      }
      AppMethodBeat.o(63277);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(63277);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxd localbxd = (bxd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63277);
          return -1;
        case 1: 
          localbxd.FlV = locala.LVo.readString();
          AppMethodBeat.o(63277);
          return 0;
        case 2: 
          localbxd.FlW = locala.LVo.readString();
          AppMethodBeat.o(63277);
          return 0;
        }
        localbxd.FlX = locala.LVo.readString();
        AppMethodBeat.o(63277);
        return 0;
      }
      AppMethodBeat.o(63277);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxd
 * JD-Core Version:    0.7.0.1
 */