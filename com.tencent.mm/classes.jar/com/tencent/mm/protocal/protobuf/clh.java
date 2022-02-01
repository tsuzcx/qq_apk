package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clh
  extends com.tencent.mm.bx.a
{
  public String EgE;
  public int EgF;
  public int EgG;
  public int fWw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91673);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EgE != null) {
        paramVarArgs.d(1, this.EgE);
      }
      paramVarArgs.aR(2, this.fWw);
      paramVarArgs.aR(3, this.EgF);
      paramVarArgs.aR(4, this.EgG);
      AppMethodBeat.o(91673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EgE == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.EgE) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.fWw);
      int j = f.a.a.b.b.a.bA(3, this.EgF);
      int k = f.a.a.b.b.a.bA(4, this.EgG);
      AppMethodBeat.o(91673);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91673);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        clh localclh = (clh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91673);
          return -1;
        case 1: 
          localclh.EgE = locala.KhF.readString();
          AppMethodBeat.o(91673);
          return 0;
        case 2: 
          localclh.fWw = locala.KhF.xS();
          AppMethodBeat.o(91673);
          return 0;
        case 3: 
          localclh.EgF = locala.KhF.xS();
          AppMethodBeat.o(91673);
          return 0;
        }
        localclh.EgG = locala.KhF.xS();
        AppMethodBeat.o(91673);
        return 0;
      }
      AppMethodBeat.o(91673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clh
 * JD-Core Version:    0.7.0.1
 */