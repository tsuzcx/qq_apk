package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qa
  extends com.tencent.mm.bx.a
{
  public String CEc;
  public String COV;
  public int COW;
  public String COX;
  public String abi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.COV != null) {
        paramVarArgs.d(1, this.COV);
      }
      paramVarArgs.aR(2, this.COW);
      if (this.abi != null) {
        paramVarArgs.d(3, this.abi);
      }
      if (this.CEc != null) {
        paramVarArgs.d(4, this.CEc);
      }
      if (this.COX != null) {
        paramVarArgs.d(5, this.COX);
      }
      AppMethodBeat.o(116466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.COV == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.COV) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.COW);
      paramInt = i;
      if (this.abi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.abi);
      }
      i = paramInt;
      if (this.CEc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CEc);
      }
      paramInt = i;
      if (this.COX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.COX);
      }
      AppMethodBeat.o(116466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116466);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        qa localqa = (qa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116466);
          return -1;
        case 1: 
          localqa.COV = locala.KhF.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 2: 
          localqa.COW = locala.KhF.xS();
          AppMethodBeat.o(116466);
          return 0;
        case 3: 
          localqa.abi = locala.KhF.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 4: 
          localqa.CEc = locala.KhF.readString();
          AppMethodBeat.o(116466);
          return 0;
        }
        localqa.COX = locala.KhF.readString();
        AppMethodBeat.o(116466);
        return 0;
      }
      AppMethodBeat.o(116466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qa
 * JD-Core Version:    0.7.0.1
 */