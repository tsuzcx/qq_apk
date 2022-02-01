package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eze
  extends com.tencent.mm.bw.a
{
  public String MRZ;
  public int MWA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32546);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MRZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32546);
        throw paramVarArgs;
      }
      if (this.MRZ != null) {
        paramVarArgs.e(1, this.MRZ);
      }
      paramVarArgs.aM(2, this.MWA);
      AppMethodBeat.o(32546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRZ == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.MRZ) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.MWA);
      AppMethodBeat.o(32546);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MRZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32546);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32546);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eze localeze = (eze)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32546);
          return -1;
        case 1: 
          localeze.MRZ = locala.UbS.readString();
          AppMethodBeat.o(32546);
          return 0;
        }
        localeze.MWA = locala.UbS.zi();
        AppMethodBeat.o(32546);
        return 0;
      }
      AppMethodBeat.o(32546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eze
 * JD-Core Version:    0.7.0.1
 */