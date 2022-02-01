package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dci
  extends com.tencent.mm.bx.a
{
  public String DoR;
  public boolean EtO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DoR != null) {
        paramVarArgs.d(1, this.DoR);
      }
      paramVarArgs.bg(2, this.EtO);
      AppMethodBeat.o(6440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DoR == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = f.a.a.b.b.a.e(1, this.DoR) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fY(2);
      AppMethodBeat.o(6440);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(6440);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dci localdci = (dci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6440);
          return -1;
        case 1: 
          localdci.DoR = locala.KhF.readString();
          AppMethodBeat.o(6440);
          return 0;
        }
        localdci.EtO = locala.KhF.fHu();
        AppMethodBeat.o(6440);
        return 0;
      }
      AppMethodBeat.o(6440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dci
 * JD-Core Version:    0.7.0.1
 */