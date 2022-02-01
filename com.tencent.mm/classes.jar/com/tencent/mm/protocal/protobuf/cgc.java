package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgc
  extends com.tencent.mm.bw.a
{
  public String Cyk;
  public String MlO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32334);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Cyk != null) {
        paramVarArgs.e(1, this.Cyk);
      }
      if (this.MlO != null) {
        paramVarArgs.e(2, this.MlO);
      }
      AppMethodBeat.o(32334);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cyk == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = g.a.a.b.b.a.f(1, this.Cyk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MlO != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MlO);
      }
      AppMethodBeat.o(32334);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32334);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cgc localcgc = (cgc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32334);
          return -1;
        case 1: 
          localcgc.Cyk = locala.UbS.readString();
          AppMethodBeat.o(32334);
          return 0;
        }
        localcgc.MlO = locala.UbS.readString();
        AppMethodBeat.o(32334);
        return 0;
      }
      AppMethodBeat.o(32334);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgc
 * JD-Core Version:    0.7.0.1
 */