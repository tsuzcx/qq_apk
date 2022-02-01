package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bof
  extends com.tencent.mm.bx.a
{
  public long DLA;
  public long DLB;
  public int DLC;
  public String DLy;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117877);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Scene);
      if (this.DLy != null) {
        paramVarArgs.d(2, this.DLy);
      }
      paramVarArgs.aG(3, this.DLB);
      paramVarArgs.aG(4, this.DLA);
      paramVarArgs.aR(5, this.DLC);
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Scene) + 0;
      paramInt = i;
      if (this.DLy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DLy);
      }
      i = f.a.a.b.b.a.q(3, this.DLB);
      int j = f.a.a.b.b.a.q(4, this.DLA);
      int k = f.a.a.b.b.a.bA(5, this.DLC);
      AppMethodBeat.o(117877);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bof localbof = (bof)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117877);
        return -1;
      case 1: 
        localbof.Scene = locala.KhF.xS();
        AppMethodBeat.o(117877);
        return 0;
      case 2: 
        localbof.DLy = locala.KhF.readString();
        AppMethodBeat.o(117877);
        return 0;
      case 3: 
        localbof.DLB = locala.KhF.xT();
        AppMethodBeat.o(117877);
        return 0;
      case 4: 
        localbof.DLA = locala.KhF.xT();
        AppMethodBeat.o(117877);
        return 0;
      }
      localbof.DLC = locala.KhF.xS();
      AppMethodBeat.o(117877);
      return 0;
    }
    AppMethodBeat.o(117877);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bof
 * JD-Core Version:    0.7.0.1
 */