package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ks
  extends com.tencent.mm.bw.a
{
  public int DWJ;
  public int DXP;
  public int DXQ;
  public int DXR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32145);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DWJ);
      paramVarArgs.aR(2, this.DXP);
      paramVarArgs.aR(3, this.DXQ);
      paramVarArgs.aR(4, this.DXR);
      AppMethodBeat.o(32145);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.DWJ);
      int i = f.a.a.b.b.a.bx(2, this.DXP);
      int j = f.a.a.b.b.a.bx(3, this.DXQ);
      int k = f.a.a.b.b.a.bx(4, this.DXR);
      AppMethodBeat.o(32145);
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
      AppMethodBeat.o(32145);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ks localks = (ks)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32145);
        return -1;
      case 1: 
        localks.DWJ = locala.LVo.xF();
        AppMethodBeat.o(32145);
        return 0;
      case 2: 
        localks.DXP = locala.LVo.xF();
        AppMethodBeat.o(32145);
        return 0;
      case 3: 
        localks.DXQ = locala.LVo.xF();
        AppMethodBeat.o(32145);
        return 0;
      }
      localks.DXR = locala.LVo.xF();
      AppMethodBeat.o(32145);
      return 0;
    }
    AppMethodBeat.o(32145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ks
 * JD-Core Version:    0.7.0.1
 */