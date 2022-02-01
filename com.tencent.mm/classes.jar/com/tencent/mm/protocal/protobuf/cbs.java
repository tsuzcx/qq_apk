package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbs
  extends com.tencent.mm.bx.a
{
  public String DXW;
  public String DXX;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153294);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.DXW != null) {
        paramVarArgs.d(2, this.DXW);
      }
      if (this.DXX != null) {
        paramVarArgs.d(3, this.DXX);
      }
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.DXW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DXW);
      }
      i = paramInt;
      if (this.DXX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DXX);
      }
      AppMethodBeat.o(153294);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cbs localcbs = (cbs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153294);
        return -1;
      case 1: 
        localcbs.type = locala.KhF.xS();
        AppMethodBeat.o(153294);
        return 0;
      case 2: 
        localcbs.DXW = locala.KhF.readString();
        AppMethodBeat.o(153294);
        return 0;
      }
      localcbs.DXX = locala.KhF.readString();
      AppMethodBeat.o(153294);
      return 0;
    }
    AppMethodBeat.o(153294);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbs
 * JD-Core Version:    0.7.0.1
 */