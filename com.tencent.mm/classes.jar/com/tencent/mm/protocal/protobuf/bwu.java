package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bwu
  extends com.tencent.mm.bw.a
{
  public double FlR;
  public long FlS;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117880);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(117880);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      paramVarArgs.e(2, this.FlR);
      paramVarArgs.aO(3, this.FlS);
      AppMethodBeat.o(117880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label353;
      }
    }
    label353:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.p(3, this.FlS);
      AppMethodBeat.o(117880);
      return paramInt + (i + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(117880);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117880);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bwu localbwu = (bwu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117880);
          return -1;
        case 1: 
          localbwu.Username = locala.LVo.readString();
          AppMethodBeat.o(117880);
          return 0;
        case 2: 
          localbwu.FlR = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(117880);
          return 0;
        }
        localbwu.FlS = locala.LVo.xG();
        AppMethodBeat.o(117880);
        return 0;
      }
      AppMethodBeat.o(117880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwu
 * JD-Core Version:    0.7.0.1
 */