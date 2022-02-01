package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahg
  extends com.tencent.mm.bw.a
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
      paramInt = f.a.a.b.b.a.bx(1, this.left);
      int i = f.a.a.b.b.a.bx(2, this.top);
      int j = f.a.a.b.b.a.bx(3, this.width);
      int k = f.a.a.b.b.a.bx(4, this.height);
      AppMethodBeat.o(127468);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127468);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahg localahg = (ahg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127468);
        return -1;
      case 1: 
        localahg.left = locala.LVo.xF();
        AppMethodBeat.o(127468);
        return 0;
      case 2: 
        localahg.top = locala.LVo.xF();
        AppMethodBeat.o(127468);
        return 0;
      case 3: 
        localahg.width = locala.LVo.xF();
        AppMethodBeat.o(127468);
        return 0;
      }
      localahg.height = locala.LVo.xF();
      AppMethodBeat.o(127468);
      return 0;
    }
    AppMethodBeat.o(127468);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahg
 * JD-Core Version:    0.7.0.1
 */