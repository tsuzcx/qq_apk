package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpf
  extends com.tencent.mm.bw.a
{
  public String MGp;
  public int him;
  public String xIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117905);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MGp != null) {
        paramVarArgs.e(1, this.MGp);
      }
      paramVarArgs.aM(2, this.him);
      if (this.xIy != null) {
        paramVarArgs.e(3, this.xIy);
      }
      AppMethodBeat.o(117905);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MGp == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.MGp) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.him);
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xIy);
      }
      AppMethodBeat.o(117905);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117905);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dpf localdpf = (dpf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117905);
          return -1;
        case 1: 
          localdpf.MGp = locala.UbS.readString();
          AppMethodBeat.o(117905);
          return 0;
        case 2: 
          localdpf.him = locala.UbS.zi();
          AppMethodBeat.o(117905);
          return 0;
        }
        localdpf.xIy = locala.UbS.readString();
        AppMethodBeat.o(117905);
        return 0;
      }
      AppMethodBeat.o(117905);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpf
 * JD-Core Version:    0.7.0.1
 */