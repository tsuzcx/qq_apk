package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cev
  extends com.tencent.mm.bw.a
{
  public int HrC;
  public b HrD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121105);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HrC);
      if (this.HrD != null) {
        paramVarArgs.c(2, this.HrD);
      }
      AppMethodBeat.o(121105);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HrC) + 0;
      paramInt = i;
      if (this.HrD != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HrD);
      }
      AppMethodBeat.o(121105);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(121105);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cev localcev = (cev)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(121105);
        return -1;
      case 1: 
        localcev.HrC = locala.OmT.zc();
        AppMethodBeat.o(121105);
        return 0;
      }
      localcev.HrD = locala.OmT.gCk();
      AppMethodBeat.o(121105);
      return 0;
    }
    AppMethodBeat.o(121105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cev
 * JD-Core Version:    0.7.0.1
 */