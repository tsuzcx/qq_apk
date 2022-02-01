package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnl
  extends com.tencent.mm.bx.a
{
  public boolean HBx;
  public String HBy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(182773);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.HBx);
      if (this.HBy != null) {
        paramVarArgs.d(2, this.HBy);
      }
      AppMethodBeat.o(182773);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0;
      paramInt = i;
      if (this.HBy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HBy);
      }
      AppMethodBeat.o(182773);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(182773);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dnl localdnl = (dnl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(182773);
        return -1;
      case 1: 
        localdnl.HBx = locala.NPN.grw();
        AppMethodBeat.o(182773);
        return 0;
      }
      localdnl.HBy = locala.NPN.readString();
      AppMethodBeat.o(182773);
      return 0;
    }
    AppMethodBeat.o(182773);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnl
 * JD-Core Version:    0.7.0.1
 */