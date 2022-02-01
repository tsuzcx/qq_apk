package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bug
  extends com.tencent.mm.bx.a
{
  public String CJL;
  public int DRA;
  public int DRB;
  public int rXS;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CJL != null) {
        paramVarArgs.d(1, this.CJL);
      }
      paramVarArgs.aR(2, this.DRA);
      paramVarArgs.aR(3, this.rXS);
      paramVarArgs.aR(4, this.DRB);
      paramVarArgs.aR(5, this.type);
      AppMethodBeat.o(6412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CJL == null) {
        break label409;
      }
    }
    label409:
    for (paramInt = f.a.a.b.b.a.e(1, this.CJL) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DRA);
      int j = f.a.a.b.b.a.bA(3, this.rXS);
      int k = f.a.a.b.b.a.bA(4, this.DRB);
      int m = f.a.a.b.b.a.bA(5, this.type);
      AppMethodBeat.o(6412);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(6412);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bug localbug = (bug)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6412);
          return -1;
        case 1: 
          localbug.CJL = locala.KhF.readString();
          AppMethodBeat.o(6412);
          return 0;
        case 2: 
          localbug.DRA = locala.KhF.xS();
          AppMethodBeat.o(6412);
          return 0;
        case 3: 
          localbug.rXS = locala.KhF.xS();
          AppMethodBeat.o(6412);
          return 0;
        case 4: 
          localbug.DRB = locala.KhF.xS();
          AppMethodBeat.o(6412);
          return 0;
        }
        localbug.type = locala.KhF.xS();
        AppMethodBeat.o(6412);
        return 0;
      }
      AppMethodBeat.o(6412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bug
 * JD-Core Version:    0.7.0.1
 */