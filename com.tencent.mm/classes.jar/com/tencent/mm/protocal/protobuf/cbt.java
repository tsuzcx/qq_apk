package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbt
  extends com.tencent.mm.bx.a
{
  public String GVE;
  public String GVF;
  public String GVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63277);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GVE != null) {
        paramVarArgs.d(1, this.GVE);
      }
      if (this.GVF != null) {
        paramVarArgs.d(2, this.GVF);
      }
      if (this.GVG != null) {
        paramVarArgs.d(3, this.GVG);
      }
      AppMethodBeat.o(63277);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GVE == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.GVE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GVF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GVF);
      }
      i = paramInt;
      if (this.GVG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GVG);
      }
      AppMethodBeat.o(63277);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(63277);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cbt localcbt = (cbt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63277);
          return -1;
        case 1: 
          localcbt.GVE = locala.NPN.readString();
          AppMethodBeat.o(63277);
          return 0;
        case 2: 
          localcbt.GVF = locala.NPN.readString();
          AppMethodBeat.o(63277);
          return 0;
        }
        localcbt.GVG = locala.NPN.readString();
        AppMethodBeat.o(63277);
        return 0;
      }
      AppMethodBeat.o(63277);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbt
 * JD-Core Version:    0.7.0.1
 */