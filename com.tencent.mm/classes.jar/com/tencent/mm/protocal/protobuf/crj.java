package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crj
  extends com.tencent.mm.bw.a
{
  public String CEI;
  public int LZv;
  public String LZw;
  public int Lia;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CEI != null) {
        paramVarArgs.e(1, this.CEI);
      }
      paramVarArgs.aM(2, this.LZv);
      if (this.LZw != null) {
        paramVarArgs.e(3, this.LZw);
      }
      paramVarArgs.aM(4, this.Lia);
      AppMethodBeat.o(116456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CEI == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.f(1, this.CEI) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LZv);
      paramInt = i;
      if (this.LZw != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LZw);
      }
      i = g.a.a.b.b.a.bu(4, this.Lia);
      AppMethodBeat.o(116456);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116456);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crj localcrj = (crj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116456);
          return -1;
        case 1: 
          localcrj.CEI = locala.UbS.readString();
          AppMethodBeat.o(116456);
          return 0;
        case 2: 
          localcrj.LZv = locala.UbS.zi();
          AppMethodBeat.o(116456);
          return 0;
        case 3: 
          localcrj.LZw = locala.UbS.readString();
          AppMethodBeat.o(116456);
          return 0;
        }
        localcrj.Lia = locala.UbS.zi();
        AppMethodBeat.o(116456);
        return 0;
      }
      AppMethodBeat.o(116456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crj
 * JD-Core Version:    0.7.0.1
 */