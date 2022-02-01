package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cma
  extends com.tencent.mm.bx.a
{
  public String Username;
  public String sdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.sdZ != null) {
        paramVarArgs.d(2, this.sdZ);
      }
      AppMethodBeat.o(181513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sdZ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sdZ);
      }
      AppMethodBeat.o(181513);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(181513);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cma localcma = (cma)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181513);
          return -1;
        case 1: 
          localcma.Username = locala.KhF.readString();
          AppMethodBeat.o(181513);
          return 0;
        }
        localcma.sdZ = locala.KhF.readString();
        AppMethodBeat.o(181513);
        return 0;
      }
      AppMethodBeat.o(181513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cma
 * JD-Core Version:    0.7.0.1
 */