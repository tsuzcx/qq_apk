package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnk
  extends com.tencent.mm.bx.a
{
  public String GsT;
  public boolean HBw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GsT != null) {
        paramVarArgs.d(1, this.GsT);
      }
      paramVarArgs.bt(2, this.HBw);
      AppMethodBeat.o(6440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GsT == null) {
        break label262;
      }
    }
    label262:
    for (paramInt = f.a.a.b.b.a.e(1, this.GsT) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.alV(2);
      AppMethodBeat.o(6440);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(6440);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dnk localdnk = (dnk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6440);
          return -1;
        case 1: 
          localdnk.GsT = locala.NPN.readString();
          AppMethodBeat.o(6440);
          return 0;
        }
        localdnk.HBw = locala.NPN.grw();
        AppMethodBeat.o(6440);
        return 0;
      }
      AppMethodBeat.o(6440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnk
 * JD-Core Version:    0.7.0.1
 */