package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buj
  extends com.tencent.mm.bx.a
{
  public String CJL;
  public int DRA;
  public int DRB;
  public int nqd;
  public int rXS;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CJL != null) {
        paramVarArgs.d(1, this.CJL);
      }
      paramVarArgs.aR(2, this.DRA);
      paramVarArgs.aR(3, this.rXS);
      paramVarArgs.aR(4, this.DRB);
      paramVarArgs.aR(5, this.nqd);
      paramVarArgs.aR(6, this.type);
      AppMethodBeat.o(6416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CJL == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.CJL) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DRA);
      int j = f.a.a.b.b.a.bA(3, this.rXS);
      int k = f.a.a.b.b.a.bA(4, this.DRB);
      int m = f.a.a.b.b.a.bA(5, this.nqd);
      int n = f.a.a.b.b.a.bA(6, this.type);
      AppMethodBeat.o(6416);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(6416);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        buj localbuj = (buj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6416);
          return -1;
        case 1: 
          localbuj.CJL = locala.KhF.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 2: 
          localbuj.DRA = locala.KhF.xS();
          AppMethodBeat.o(6416);
          return 0;
        case 3: 
          localbuj.rXS = locala.KhF.xS();
          AppMethodBeat.o(6416);
          return 0;
        case 4: 
          localbuj.DRB = locala.KhF.xS();
          AppMethodBeat.o(6416);
          return 0;
        case 5: 
          localbuj.nqd = locala.KhF.xS();
          AppMethodBeat.o(6416);
          return 0;
        }
        localbuj.type = locala.KhF.xS();
        AppMethodBeat.o(6416);
        return 0;
      }
      AppMethodBeat.o(6416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buj
 * JD-Core Version:    0.7.0.1
 */