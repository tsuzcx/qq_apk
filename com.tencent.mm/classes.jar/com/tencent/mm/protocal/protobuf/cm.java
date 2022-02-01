package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cm
  extends com.tencent.mm.bx.a
{
  public int Cxl;
  public int Cxm;
  public int Cxn;
  public int Cxo;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127429);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Cxl);
      paramVarArgs.aR(2, this.mBH);
      paramVarArgs.aR(3, this.Cxm);
      paramVarArgs.aR(4, this.Cxn);
      paramVarArgs.aR(5, this.Cxo);
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Cxl);
      int i = f.a.a.b.b.a.bA(2, this.mBH);
      int j = f.a.a.b.b.a.bA(3, this.Cxm);
      int k = f.a.a.b.b.a.bA(4, this.Cxn);
      int m = f.a.a.b.b.a.bA(5, this.Cxo);
      AppMethodBeat.o(127429);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cm localcm = (cm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127429);
        return -1;
      case 1: 
        localcm.Cxl = locala.KhF.xS();
        AppMethodBeat.o(127429);
        return 0;
      case 2: 
        localcm.mBH = locala.KhF.xS();
        AppMethodBeat.o(127429);
        return 0;
      case 3: 
        localcm.Cxm = locala.KhF.xS();
        AppMethodBeat.o(127429);
        return 0;
      case 4: 
        localcm.Cxn = locala.KhF.xS();
        AppMethodBeat.o(127429);
        return 0;
      }
      localcm.Cxo = locala.KhF.xS();
      AppMethodBeat.o(127429);
      return 0;
    }
    AppMethodBeat.o(127429);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cm
 * JD-Core Version:    0.7.0.1
 */