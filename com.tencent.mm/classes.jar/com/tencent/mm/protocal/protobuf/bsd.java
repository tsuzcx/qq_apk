package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bsd
  extends com.tencent.mm.bx.a
{
  public double DPA;
  public long DPB;
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
      paramVarArgs.e(2, this.DPA);
      paramVarArgs.aG(3, this.DPB);
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
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.q(3, this.DPB);
      AppMethodBeat.o(117880);
      return paramInt + (i + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        bsd localbsd = (bsd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117880);
          return -1;
        case 1: 
          localbsd.Username = locala.KhF.readString();
          AppMethodBeat.o(117880);
          return 0;
        case 2: 
          localbsd.DPA = Double.longBitsToDouble(locala.KhF.fHy());
          AppMethodBeat.o(117880);
          return 0;
        }
        localbsd.DPB = locala.KhF.xT();
        AppMethodBeat.o(117880);
        return 0;
      }
      AppMethodBeat.o(117880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsd
 * JD-Core Version:    0.7.0.1
 */