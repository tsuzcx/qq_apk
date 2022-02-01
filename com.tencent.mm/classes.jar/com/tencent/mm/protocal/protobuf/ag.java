package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag
  extends com.tencent.mm.bx.a
{
  public String CtI;
  public int CtJ;
  public int CtK;
  public int CtL;
  public int CtM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CtI != null) {
        paramVarArgs.d(1, this.CtI);
      }
      paramVarArgs.aR(2, this.CtJ);
      paramVarArgs.aR(3, this.CtK);
      paramVarArgs.aR(4, this.CtL);
      paramVarArgs.aR(5, this.CtM);
      AppMethodBeat.o(143961);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CtI == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.CtI) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.CtJ);
      int j = f.a.a.b.b.a.bA(3, this.CtK);
      int k = f.a.a.b.b.a.bA(4, this.CtL);
      int m = f.a.a.b.b.a.bA(5, this.CtM);
      AppMethodBeat.o(143961);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(143961);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(143961);
          return -1;
        case 1: 
          localag.CtI = locala.KhF.readString();
          AppMethodBeat.o(143961);
          return 0;
        case 2: 
          localag.CtJ = locala.KhF.xS();
          AppMethodBeat.o(143961);
          return 0;
        case 3: 
          localag.CtK = locala.KhF.xS();
          AppMethodBeat.o(143961);
          return 0;
        case 4: 
          localag.CtL = locala.KhF.xS();
          AppMethodBeat.o(143961);
          return 0;
        }
        localag.CtM = locala.KhF.xS();
        AppMethodBeat.o(143961);
        return 0;
      }
      AppMethodBeat.o(143961);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ag
 * JD-Core Version:    0.7.0.1
 */