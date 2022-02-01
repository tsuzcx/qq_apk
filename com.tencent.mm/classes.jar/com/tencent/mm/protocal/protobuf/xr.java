package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xr
  extends com.tencent.mm.bx.a
{
  public int CZl;
  public int CZm;
  public int CzO;
  public String CzP;
  public int count;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CzP != null) {
        paramVarArgs.d(1, this.CzP);
      }
      paramVarArgs.aR(2, this.CzO);
      paramVarArgs.aR(3, this.CZl);
      paramVarArgs.aR(4, this.CZm);
      paramVarArgs.aR(5, this.scene);
      paramVarArgs.aR(6, this.count);
      AppMethodBeat.o(103205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CzP == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = f.a.a.b.b.a.e(1, this.CzP) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.CzO);
      int j = f.a.a.b.b.a.bA(3, this.CZl);
      int k = f.a.a.b.b.a.bA(4, this.CZm);
      int m = f.a.a.b.b.a.bA(5, this.scene);
      int n = f.a.a.b.b.a.bA(6, this.count);
      AppMethodBeat.o(103205);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103205);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        xr localxr = (xr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103205);
          return -1;
        case 1: 
          localxr.CzP = locala.KhF.readString();
          AppMethodBeat.o(103205);
          return 0;
        case 2: 
          localxr.CzO = locala.KhF.xS();
          AppMethodBeat.o(103205);
          return 0;
        case 3: 
          localxr.CZl = locala.KhF.xS();
          AppMethodBeat.o(103205);
          return 0;
        case 4: 
          localxr.CZm = locala.KhF.xS();
          AppMethodBeat.o(103205);
          return 0;
        case 5: 
          localxr.scene = locala.KhF.xS();
          AppMethodBeat.o(103205);
          return 0;
        }
        localxr.count = locala.KhF.xS();
        AppMethodBeat.o(103205);
        return 0;
      }
      AppMethodBeat.o(103205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xr
 * JD-Core Version:    0.7.0.1
 */