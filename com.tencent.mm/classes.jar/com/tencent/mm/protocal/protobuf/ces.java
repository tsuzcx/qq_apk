package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ces
  extends com.tencent.mm.bx.a
{
  public String DfD;
  public int Ebj;
  public String oXi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oXi != null) {
        paramVarArgs.d(1, this.oXi);
      }
      paramVarArgs.aR(2, this.Ebj);
      if (this.DfD != null) {
        paramVarArgs.d(3, this.DfD);
      }
      AppMethodBeat.o(32394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oXi == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.oXi) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Ebj);
      paramInt = i;
      if (this.DfD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DfD);
      }
      AppMethodBeat.o(32394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32394);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ces localces = (ces)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32394);
          return -1;
        case 1: 
          localces.oXi = locala.KhF.readString();
          AppMethodBeat.o(32394);
          return 0;
        case 2: 
          localces.Ebj = locala.KhF.xS();
          AppMethodBeat.o(32394);
          return 0;
        }
        localces.DfD = locala.KhF.readString();
        AppMethodBeat.o(32394);
        return 0;
      }
      AppMethodBeat.o(32394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ces
 * JD-Core Version:    0.7.0.1
 */