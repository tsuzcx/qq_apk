package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class exg
  extends com.tencent.mm.bw.a
{
  public String NuF;
  public String NuG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200238);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NuF != null) {
        paramVarArgs.e(1, this.NuF);
      }
      if (this.NuG != null) {
        paramVarArgs.e(2, this.NuG);
      }
      AppMethodBeat.o(200238);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NuF == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.NuF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NuG != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.NuG);
      }
      AppMethodBeat.o(200238);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200238);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        exg localexg = (exg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200238);
          return -1;
        case 1: 
          localexg.NuF = locala.UbS.readString();
          AppMethodBeat.o(200238);
          return 0;
        }
        localexg.NuG = locala.UbS.readString();
        AppMethodBeat.o(200238);
        return 0;
      }
      AppMethodBeat.o(200238);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exg
 * JD-Core Version:    0.7.0.1
 */