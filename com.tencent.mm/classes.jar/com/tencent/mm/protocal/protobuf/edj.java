package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class edj
  extends com.tencent.mm.bw.a
{
  public String DRR;
  public int DRS;
  public String DRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118441);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.DRR == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(118441);
        throw paramVarArgs;
      }
      if (this.DRR != null) {
        paramVarArgs.e(1, this.DRR);
      }
      paramVarArgs.aM(2, this.DRS);
      if (this.DRT != null) {
        paramVarArgs.e(3, this.DRT);
      }
      AppMethodBeat.o(118441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DRR == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.f(1, this.DRR) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.DRS);
      paramInt = i;
      if (this.DRT != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.DRT);
      }
      AppMethodBeat.o(118441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.DRR == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(118441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118441);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        edj localedj = (edj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118441);
          return -1;
        case 1: 
          localedj.DRR = locala.UbS.readString();
          AppMethodBeat.o(118441);
          return 0;
        case 2: 
          localedj.DRS = locala.UbS.zi();
          AppMethodBeat.o(118441);
          return 0;
        }
        localedj.DRT = locala.UbS.readString();
        AppMethodBeat.o(118441);
        return 0;
      }
      AppMethodBeat.o(118441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edj
 * JD-Core Version:    0.7.0.1
 */