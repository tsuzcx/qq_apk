package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aea
  extends com.tencent.mm.bw.a
{
  public String HTZ;
  public String HUd;
  public String IaZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91429);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.HTZ != null) {
        paramVarArgs.e(1, this.HTZ);
      }
      if (this.IaZ != null) {
        paramVarArgs.e(2, this.IaZ);
      }
      if (this.HUd != null) {
        paramVarArgs.e(3, this.HUd);
      }
      AppMethodBeat.o(91429);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HTZ == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.HTZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IaZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.IaZ);
      }
      i = paramInt;
      if (this.HUd != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.HUd);
      }
      AppMethodBeat.o(91429);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91429);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aea localaea = (aea)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91429);
          return -1;
        case 1: 
          localaea.HTZ = locala.UbS.readString();
          AppMethodBeat.o(91429);
          return 0;
        case 2: 
          localaea.IaZ = locala.UbS.readString();
          AppMethodBeat.o(91429);
          return 0;
        }
        localaea.HUd = locala.UbS.readString();
        AppMethodBeat.o(91429);
        return 0;
      }
      AppMethodBeat.o(91429);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aea
 * JD-Core Version:    0.7.0.1
 */