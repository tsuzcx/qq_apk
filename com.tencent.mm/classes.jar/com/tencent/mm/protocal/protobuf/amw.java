package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amw
  extends com.tencent.mm.bw.a
{
  public float EFU;
  public float EFV;
  public int EFW;
  public float dmL;
  public float doB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169035);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(8, this.doB);
      paramVarArgs.x(9, this.dmL);
      paramVarArgs.x(10, this.EFU);
      paramVarArgs.x(11, this.EFV);
      paramVarArgs.aR(12, this.EFW);
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(8);
      int i = f.a.a.b.b.a.fK(9);
      int j = f.a.a.b.b.a.fK(10);
      int k = f.a.a.b.b.a.fK(11);
      int m = f.a.a.b.b.a.bx(12, this.EFW);
      AppMethodBeat.o(169035);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amw localamw = (amw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169035);
        return -1;
      case 8: 
        localamw.doB = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(169035);
        return 0;
      case 9: 
        localamw.dmL = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(169035);
        return 0;
      case 10: 
        localamw.EFU = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(169035);
        return 0;
      case 11: 
        localamw.EFV = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(169035);
        return 0;
      }
      localamw.EFW = locala.LVo.xF();
      AppMethodBeat.o(169035);
      return 0;
    }
    AppMethodBeat.o(169035);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amw
 * JD-Core Version:    0.7.0.1
 */