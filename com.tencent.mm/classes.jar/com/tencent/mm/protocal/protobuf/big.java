package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class big
  extends com.tencent.mm.bx.a
{
  public int CBy;
  public String DFP;
  public String DFQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82432);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DFP != null) {
        paramVarArgs.d(1, this.DFP);
      }
      paramVarArgs.aR(2, this.CBy);
      if (this.DFQ != null) {
        paramVarArgs.d(3, this.DFQ);
      }
      AppMethodBeat.o(82432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DFP == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.DFP) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CBy);
      paramInt = i;
      if (this.DFQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DFQ);
      }
      AppMethodBeat.o(82432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82432);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        big localbig = (big)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82432);
          return -1;
        case 1: 
          localbig.DFP = locala.KhF.readString();
          AppMethodBeat.o(82432);
          return 0;
        case 2: 
          localbig.CBy = locala.KhF.xS();
          AppMethodBeat.o(82432);
          return 0;
        }
        localbig.DFQ = locala.KhF.readString();
        AppMethodBeat.o(82432);
        return 0;
      }
      AppMethodBeat.o(82432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.big
 * JD-Core Version:    0.7.0.1
 */