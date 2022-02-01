package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class co
  extends com.tencent.mm.bw.a
{
  public int DPH;
  public int DPI;
  public int DPJ;
  public int DPK;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127429);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DPH);
      paramVarArgs.aR(2, this.ndI);
      paramVarArgs.aR(3, this.DPI);
      paramVarArgs.aR(4, this.DPJ);
      paramVarArgs.aR(5, this.DPK);
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.DPH);
      int i = f.a.a.b.b.a.bx(2, this.ndI);
      int j = f.a.a.b.b.a.bx(3, this.DPI);
      int k = f.a.a.b.b.a.bx(4, this.DPJ);
      int m = f.a.a.b.b.a.bx(5, this.DPK);
      AppMethodBeat.o(127429);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      co localco = (co)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127429);
        return -1;
      case 1: 
        localco.DPH = locala.LVo.xF();
        AppMethodBeat.o(127429);
        return 0;
      case 2: 
        localco.ndI = locala.LVo.xF();
        AppMethodBeat.o(127429);
        return 0;
      case 3: 
        localco.DPI = locala.LVo.xF();
        AppMethodBeat.o(127429);
        return 0;
      case 4: 
        localco.DPJ = locala.LVo.xF();
        AppMethodBeat.o(127429);
        return 0;
      }
      localco.DPK = locala.LVo.xF();
      AppMethodBeat.o(127429);
      return 0;
    }
    AppMethodBeat.o(127429);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.co
 * JD-Core Version:    0.7.0.1
 */