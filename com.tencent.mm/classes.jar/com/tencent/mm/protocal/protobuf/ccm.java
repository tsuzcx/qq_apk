package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccm
  extends com.tencent.mm.bv.a
{
  public String kNB;
  public String opC;
  public String opD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56973);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.opC != null) {
        paramVarArgs.e(1, this.opC);
      }
      if (this.opD != null) {
        paramVarArgs.e(2, this.opD);
      }
      if (this.kNB != null) {
        paramVarArgs.e(3, this.kNB);
      }
      AppMethodBeat.o(56973);
      return 0;
    }
    if (paramInt == 1) {
      if (this.opC == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.opC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.opD != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.opD);
      }
      i = paramInt;
      if (this.kNB != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kNB);
      }
      AppMethodBeat.o(56973);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56973);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ccm localccm = (ccm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56973);
          return -1;
        case 1: 
          localccm.opC = locala.CLY.readString();
          AppMethodBeat.o(56973);
          return 0;
        case 2: 
          localccm.opD = locala.CLY.readString();
          AppMethodBeat.o(56973);
          return 0;
        }
        localccm.kNB = locala.CLY.readString();
        AppMethodBeat.o(56973);
        return 0;
      }
      AppMethodBeat.o(56973);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccm
 * JD-Core Version:    0.7.0.1
 */