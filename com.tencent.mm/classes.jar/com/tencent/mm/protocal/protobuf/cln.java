package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cln
  extends com.tencent.mm.bw.a
{
  public String uuW;
  public int uvE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133188);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuW != null) {
        paramVarArgs.d(1, this.uuW);
      }
      paramVarArgs.aS(2, this.uvE);
      AppMethodBeat.o(133188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuW == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.uuW) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.uvE);
      AppMethodBeat.o(133188);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133188);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cln localcln = (cln)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133188);
          return -1;
        case 1: 
          localcln.uuW = locala.OmT.readString();
          AppMethodBeat.o(133188);
          return 0;
        }
        localcln.uvE = locala.OmT.zc();
        AppMethodBeat.o(133188);
        return 0;
      }
      AppMethodBeat.o(133188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cln
 * JD-Core Version:    0.7.0.1
 */