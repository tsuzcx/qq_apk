package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpa
  extends com.tencent.mm.bx.a
{
  public int EFp;
  public String Eit;
  public String ijV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eit != null) {
        paramVarArgs.d(1, this.Eit);
      }
      if (this.ijV != null) {
        paramVarArgs.d(2, this.ijV);
      }
      paramVarArgs.aR(3, this.EFp);
      AppMethodBeat.o(32507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eit == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.Eit) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ijV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ijV);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.EFp);
      AppMethodBeat.o(32507);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32507);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dpa localdpa = (dpa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32507);
          return -1;
        case 1: 
          localdpa.Eit = locala.KhF.readString();
          AppMethodBeat.o(32507);
          return 0;
        case 2: 
          localdpa.ijV = locala.KhF.readString();
          AppMethodBeat.o(32507);
          return 0;
        }
        localdpa.EFp = locala.KhF.xS();
        AppMethodBeat.o(32507);
        return 0;
      }
      AppMethodBeat.o(32507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpa
 * JD-Core Version:    0.7.0.1
 */