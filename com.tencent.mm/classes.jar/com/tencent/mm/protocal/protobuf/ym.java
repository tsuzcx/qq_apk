package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ym
  extends com.tencent.mm.bw.a
{
  public boolean hbH;
  public boolean wpd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.hbH);
      paramVarArgs.bl(2, this.wpd);
      AppMethodBeat.o(101527);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      AppMethodBeat.o(101527);
      return paramInt + 1 + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(101527);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ym localym = (ym)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(101527);
        return -1;
      case 1: 
        localym.hbH = locala.LVo.fZX();
        AppMethodBeat.o(101527);
        return 0;
      }
      localym.wpd = locala.LVo.fZX();
      AppMethodBeat.o(101527);
      return 0;
    }
    AppMethodBeat.o(101527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ym
 * JD-Core Version:    0.7.0.1
 */