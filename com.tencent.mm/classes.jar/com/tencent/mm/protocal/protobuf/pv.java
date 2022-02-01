package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pv
  extends com.tencent.mm.bx.a
{
  public int COi;
  public int COj;
  public int COk;
  public int COl;
  public int COm;
  public int COn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133161);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.COi);
      paramVarArgs.aR(2, this.COj);
      paramVarArgs.aR(3, this.COk);
      paramVarArgs.aR(4, this.COl);
      paramVarArgs.aR(5, this.COm);
      paramVarArgs.aR(6, this.COn);
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.COi);
      int i = f.a.a.b.b.a.bA(2, this.COj);
      int j = f.a.a.b.b.a.bA(3, this.COk);
      int k = f.a.a.b.b.a.bA(4, this.COl);
      int m = f.a.a.b.b.a.bA(5, this.COm);
      int n = f.a.a.b.b.a.bA(6, this.COn);
      AppMethodBeat.o(133161);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      pv localpv = (pv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133161);
        return -1;
      case 1: 
        localpv.COi = locala.KhF.xS();
        AppMethodBeat.o(133161);
        return 0;
      case 2: 
        localpv.COj = locala.KhF.xS();
        AppMethodBeat.o(133161);
        return 0;
      case 3: 
        localpv.COk = locala.KhF.xS();
        AppMethodBeat.o(133161);
        return 0;
      case 4: 
        localpv.COl = locala.KhF.xS();
        AppMethodBeat.o(133161);
        return 0;
      case 5: 
        localpv.COm = locala.KhF.xS();
        AppMethodBeat.o(133161);
        return 0;
      }
      localpv.COn = locala.KhF.xS();
      AppMethodBeat.o(133161);
      return 0;
    }
    AppMethodBeat.o(133161);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pv
 * JD-Core Version:    0.7.0.1
 */