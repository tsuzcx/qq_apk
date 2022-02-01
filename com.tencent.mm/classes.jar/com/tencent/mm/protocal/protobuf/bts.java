package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bts
  extends com.tencent.mm.bw.a
{
  public String HgO;
  public int HgP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32335);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HgO != null) {
        paramVarArgs.d(1, this.HgO);
      }
      paramVarArgs.aS(2, this.HgP);
      AppMethodBeat.o(32335);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HgO == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = f.a.a.b.b.a.e(1, this.HgO) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HgP);
      AppMethodBeat.o(32335);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32335);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bts localbts = (bts)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32335);
          return -1;
        case 1: 
          localbts.HgO = locala.OmT.readString();
          AppMethodBeat.o(32335);
          return 0;
        }
        localbts.HgP = locala.OmT.zc();
        AppMethodBeat.o(32335);
        return 0;
      }
      AppMethodBeat.o(32335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bts
 * JD-Core Version:    0.7.0.1
 */