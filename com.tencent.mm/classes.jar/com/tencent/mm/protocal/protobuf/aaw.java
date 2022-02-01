package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aaw
  extends com.tencent.mm.bx.a
{
  public String DbJ;
  public int DbK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32188);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DbJ != null) {
        paramVarArgs.d(1, this.DbJ);
      }
      paramVarArgs.aR(2, this.DbK);
      AppMethodBeat.o(32188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DbJ == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = f.a.a.b.b.a.e(1, this.DbJ) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DbK);
      AppMethodBeat.o(32188);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32188);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aaw localaaw = (aaw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32188);
          return -1;
        case 1: 
          localaaw.DbJ = locala.KhF.readString();
          AppMethodBeat.o(32188);
          return 0;
        }
        localaaw.DbK = locala.KhF.xS();
        AppMethodBeat.o(32188);
        return 0;
      }
      AppMethodBeat.o(32188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaw
 * JD-Core Version:    0.7.0.1
 */