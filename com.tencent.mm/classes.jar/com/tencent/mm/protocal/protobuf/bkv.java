package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkv
  extends com.tencent.mm.bw.a
{
  public int Fas;
  public int Fat;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fas);
      paramVarArgs.aR(2, this.Fat);
      AppMethodBeat.o(82430);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Fas);
      int i = f.a.a.b.b.a.bx(2, this.Fat);
      AppMethodBeat.o(82430);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(82430);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bkv localbkv = (bkv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(82430);
        return -1;
      case 1: 
        localbkv.Fas = locala.LVo.xF();
        AppMethodBeat.o(82430);
        return 0;
      }
      localbkv.Fat = locala.LVo.xF();
      AppMethodBeat.o(82430);
      return 0;
    }
    AppMethodBeat.o(82430);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkv
 * JD-Core Version:    0.7.0.1
 */