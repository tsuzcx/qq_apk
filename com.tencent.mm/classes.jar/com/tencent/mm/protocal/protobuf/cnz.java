package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnz
  extends com.tencent.mm.bx.a
{
  public String Eig;
  public int Eih;
  public String dpO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152686);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eig != null) {
        paramVarArgs.d(1, this.Eig);
      }
      if (this.dpO != null) {
        paramVarArgs.d(2, this.dpO);
      }
      paramVarArgs.aR(3, this.Eih);
      AppMethodBeat.o(152686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eig == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.Eig) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dpO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dpO);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.Eih);
      AppMethodBeat.o(152686);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152686);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cnz localcnz = (cnz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152686);
          return -1;
        case 1: 
          localcnz.Eig = locala.KhF.readString();
          AppMethodBeat.o(152686);
          return 0;
        case 2: 
          localcnz.dpO = locala.KhF.readString();
          AppMethodBeat.o(152686);
          return 0;
        }
        localcnz.Eih = locala.KhF.xS();
        AppMethodBeat.o(152686);
        return 0;
      }
      AppMethodBeat.o(152686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnz
 * JD-Core Version:    0.7.0.1
 */