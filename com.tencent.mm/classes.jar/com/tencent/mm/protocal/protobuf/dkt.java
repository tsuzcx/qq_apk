package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkt
  extends com.tencent.mm.bx.a
{
  public int bottom;
  public int left;
  public int right;
  public int top;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169093);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.left);
      paramVarArgs.aR(2, this.top);
      paramVarArgs.aR(3, this.right);
      paramVarArgs.aR(4, this.bottom);
      AppMethodBeat.o(169093);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.left);
      int i = f.a.a.b.b.a.bA(2, this.top);
      int j = f.a.a.b.b.a.bA(3, this.right);
      int k = f.a.a.b.b.a.bA(4, this.bottom);
      AppMethodBeat.o(169093);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(169093);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dkt localdkt = (dkt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169093);
        return -1;
      case 1: 
        localdkt.left = locala.KhF.xS();
        AppMethodBeat.o(169093);
        return 0;
      case 2: 
        localdkt.top = locala.KhF.xS();
        AppMethodBeat.o(169093);
        return 0;
      case 3: 
        localdkt.right = locala.KhF.xS();
        AppMethodBeat.o(169093);
        return 0;
      }
      localdkt.bottom = locala.KhF.xS();
      AppMethodBeat.o(169093);
      return 0;
    }
    AppMethodBeat.o(169093);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkt
 * JD-Core Version:    0.7.0.1
 */