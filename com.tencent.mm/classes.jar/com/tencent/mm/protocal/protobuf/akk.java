package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akk
  extends com.tencent.mm.bx.a
{
  public float DlV;
  public float DlW;
  public int DlX;
  public float dpb;
  public float dqQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169035);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(8, this.dqQ);
      paramVarArgs.x(9, this.dpb);
      paramVarArgs.x(10, this.DlV);
      paramVarArgs.x(11, this.DlW);
      paramVarArgs.aR(12, this.DlX);
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(8);
      int i = f.a.a.b.b.a.fY(9);
      int j = f.a.a.b.b.a.fY(10);
      int k = f.a.a.b.b.a.fY(11);
      int m = f.a.a.b.b.a.bA(12, this.DlX);
      AppMethodBeat.o(169035);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      akk localakk = (akk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169035);
        return -1;
      case 8: 
        localakk.dqQ = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(169035);
        return 0;
      case 9: 
        localakk.dpb = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(169035);
        return 0;
      case 10: 
        localakk.DlV = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(169035);
        return 0;
      case 11: 
        localakk.DlW = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(169035);
        return 0;
      }
      localakk.DlX = locala.KhF.xS();
      AppMethodBeat.o(169035);
      return 0;
    }
    AppMethodBeat.o(169035);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akk
 * JD-Core Version:    0.7.0.1
 */