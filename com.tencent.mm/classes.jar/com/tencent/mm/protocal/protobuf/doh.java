package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doh
  extends com.tencent.mm.bw.a
{
  public String GMr;
  public boolean HVj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GMr != null) {
        paramVarArgs.d(1, this.GMr);
      }
      paramVarArgs.bC(2, this.HVj);
      AppMethodBeat.o(6440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GMr == null) {
        break label262;
      }
    }
    label262:
    for (paramInt = f.a.a.b.b.a.e(1, this.GMr) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amF(2);
      AppMethodBeat.o(6440);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(6440);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        doh localdoh = (doh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6440);
          return -1;
        case 1: 
          localdoh.GMr = locala.OmT.readString();
          AppMethodBeat.o(6440);
          return 0;
        }
        localdoh.HVj = locala.OmT.gvY();
        AppMethodBeat.o(6440);
        return 0;
      }
      AppMethodBeat.o(6440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doh
 * JD-Core Version:    0.7.0.1
 */