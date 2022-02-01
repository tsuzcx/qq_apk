package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agh
  extends com.tencent.mm.bw.a
{
  public String Lqv;
  public int Lqw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32188);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqv != null) {
        paramVarArgs.e(1, this.Lqv);
      }
      paramVarArgs.aM(2, this.Lqw);
      AppMethodBeat.o(32188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lqv == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = g.a.a.b.b.a.f(1, this.Lqv) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Lqw);
      AppMethodBeat.o(32188);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32188);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        agh localagh = (agh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32188);
          return -1;
        case 1: 
          localagh.Lqv = locala.UbS.readString();
          AppMethodBeat.o(32188);
          return 0;
        }
        localagh.Lqw = locala.UbS.zi();
        AppMethodBeat.o(32188);
        return 0;
      }
      AppMethodBeat.o(32188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agh
 * JD-Core Version:    0.7.0.1
 */