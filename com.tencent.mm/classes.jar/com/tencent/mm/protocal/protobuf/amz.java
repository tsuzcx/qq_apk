package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amz
  extends com.tencent.mm.bw.a
{
  public int EGb;
  public int EGc;
  public int EGd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EGb);
      paramVarArgs.aR(2, this.EGc);
      paramVarArgs.aR(3, this.EGd);
      AppMethodBeat.o(184204);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.EGb);
      int i = f.a.a.b.b.a.bx(2, this.EGc);
      int j = f.a.a.b.b.a.bx(3, this.EGd);
      AppMethodBeat.o(184204);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(184204);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amz localamz = (amz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184204);
        return -1;
      case 1: 
        localamz.EGb = locala.LVo.xF();
        AppMethodBeat.o(184204);
        return 0;
      case 2: 
        localamz.EGc = locala.LVo.xF();
        AppMethodBeat.o(184204);
        return 0;
      }
      localamz.EGd = locala.LVo.xF();
      AppMethodBeat.o(184204);
      return 0;
    }
    AppMethodBeat.o(184204);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amz
 * JD-Core Version:    0.7.0.1
 */