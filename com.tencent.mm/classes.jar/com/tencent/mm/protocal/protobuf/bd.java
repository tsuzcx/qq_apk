package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bd
  extends com.tencent.mm.bw.a
{
  public boolean DNF;
  public boolean DNG;
  public int DNH;
  public boolean DNI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123537);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.DNF);
      paramVarArgs.bl(2, this.DNG);
      paramVarArgs.aR(3, this.DNH);
      paramVarArgs.bl(4, this.DNI);
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.bx(3, this.DNH);
      int k = f.a.a.b.b.a.fK(4);
      AppMethodBeat.o(123537);
      return paramInt + 1 + 0 + (i + 1) + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bd localbd = (bd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123537);
        return -1;
      case 1: 
        localbd.DNF = locala.LVo.fZX();
        AppMethodBeat.o(123537);
        return 0;
      case 2: 
        localbd.DNG = locala.LVo.fZX();
        AppMethodBeat.o(123537);
        return 0;
      case 3: 
        localbd.DNH = locala.LVo.xF();
        AppMethodBeat.o(123537);
        return 0;
      }
      localbd.DNI = locala.LVo.fZX();
      AppMethodBeat.o(123537);
      return 0;
    }
    AppMethodBeat.o(123537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bd
 * JD-Core Version:    0.7.0.1
 */