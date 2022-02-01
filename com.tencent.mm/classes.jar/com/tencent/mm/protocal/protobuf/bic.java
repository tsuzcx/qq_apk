package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bic
  extends com.tencent.mm.bw.a
{
  public int EXq;
  public int EXr;
  public boolean EXs;
  public boolean EXt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50094);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EXq);
      paramVarArgs.aR(2, this.EXr);
      paramVarArgs.bl(3, this.EXs);
      paramVarArgs.bl(4, this.EXt);
      AppMethodBeat.o(50094);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.EXq);
      int i = f.a.a.b.b.a.bx(2, this.EXr);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      AppMethodBeat.o(50094);
      return paramInt + 0 + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(50094);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bic localbic = (bic)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50094);
        return -1;
      case 1: 
        localbic.EXq = locala.LVo.xF();
        AppMethodBeat.o(50094);
        return 0;
      case 2: 
        localbic.EXr = locala.LVo.xF();
        AppMethodBeat.o(50094);
        return 0;
      case 3: 
        localbic.EXs = locala.LVo.fZX();
        AppMethodBeat.o(50094);
        return 0;
      }
      localbic.EXt = locala.LVo.fZX();
      AppMethodBeat.o(50094);
      return 0;
    }
    AppMethodBeat.o(50094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bic
 * JD-Core Version:    0.7.0.1
 */