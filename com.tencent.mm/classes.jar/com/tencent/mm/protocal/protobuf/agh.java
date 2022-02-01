package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agh
  extends com.tencent.mm.bx.a
{
  public int height;
  public int left;
  public int top;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127468);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.left);
      paramVarArgs.aR(2, this.top);
      paramVarArgs.aR(3, this.width);
      paramVarArgs.aR(4, this.height);
      AppMethodBeat.o(127468);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.left);
      int i = f.a.a.b.b.a.bA(2, this.top);
      int j = f.a.a.b.b.a.bA(3, this.width);
      int k = f.a.a.b.b.a.bA(4, this.height);
      AppMethodBeat.o(127468);
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
      AppMethodBeat.o(127468);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      agh localagh = (agh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127468);
        return -1;
      case 1: 
        localagh.left = locala.KhF.xS();
        AppMethodBeat.o(127468);
        return 0;
      case 2: 
        localagh.top = locala.KhF.xS();
        AppMethodBeat.o(127468);
        return 0;
      case 3: 
        localagh.width = locala.KhF.xS();
        AppMethodBeat.o(127468);
        return 0;
      }
      localagh.height = locala.KhF.xS();
      AppMethodBeat.o(127468);
      return 0;
    }
    AppMethodBeat.o(127468);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agh
 * JD-Core Version:    0.7.0.1
 */