package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bty
  extends com.tencent.mm.bw.a
{
  public int Fjf;
  public int Fjg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32347);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fjf);
      paramVarArgs.aR(2, this.Fjg);
      AppMethodBeat.o(32347);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Fjf);
      int i = f.a.a.b.b.a.bx(2, this.Fjg);
      AppMethodBeat.o(32347);
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
      AppMethodBeat.o(32347);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bty localbty = (bty)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32347);
        return -1;
      case 1: 
        localbty.Fjf = locala.LVo.xF();
        AppMethodBeat.o(32347);
        return 0;
      }
      localbty.Fjg = locala.LVo.xF();
      AppMethodBeat.o(32347);
      return 0;
    }
    AppMethodBeat.o(32347);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bty
 * JD-Core Version:    0.7.0.1
 */