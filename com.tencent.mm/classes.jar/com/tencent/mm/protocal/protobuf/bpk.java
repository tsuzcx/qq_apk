package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpk
  extends com.tencent.mm.bx.a
{
  public float DNH;
  public float DNI;
  public float DNJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125746);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.DNH);
      paramVarArgs.x(2, this.DNI);
      paramVarArgs.x(3, this.DNJ);
      AppMethodBeat.o(125746);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(125746);
      return paramInt + 4 + 0 + (i + 4) + (j + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125746);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpk localbpk = (bpk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125746);
        return -1;
      case 1: 
        localbpk.DNH = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125746);
        return 0;
      case 2: 
        localbpk.DNI = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125746);
        return 0;
      }
      localbpk.DNJ = Float.intBitsToFloat(locala.KhF.fHx());
      AppMethodBeat.o(125746);
      return 0;
    }
    AppMethodBeat.o(125746);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpk
 * JD-Core Version:    0.7.0.1
 */