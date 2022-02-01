package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pu
  extends com.tencent.mm.bx.a
{
  public String AHE;
  public String COh;
  public String duI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.COh != null) {
        paramVarArgs.d(1, this.COh);
      }
      if (this.AHE != null) {
        paramVarArgs.d(2, this.AHE);
      }
      if (this.duI != null) {
        paramVarArgs.d(3, this.duI);
      }
      AppMethodBeat.o(72426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.COh == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.COh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AHE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.AHE);
      }
      i = paramInt;
      if (this.duI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.duI);
      }
      AppMethodBeat.o(72426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72426);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pu localpu = (pu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72426);
          return -1;
        case 1: 
          localpu.COh = locala.KhF.readString();
          AppMethodBeat.o(72426);
          return 0;
        case 2: 
          localpu.AHE = locala.KhF.readString();
          AppMethodBeat.o(72426);
          return 0;
        }
        localpu.duI = locala.KhF.readString();
        AppMethodBeat.o(72426);
        return 0;
      }
      AppMethodBeat.o(72426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pu
 * JD-Core Version:    0.7.0.1
 */