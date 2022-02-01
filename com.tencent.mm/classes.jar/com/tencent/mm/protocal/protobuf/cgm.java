package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgm
  extends com.tencent.mm.bw.a
{
  public int MlV;
  public String UserName;
  public String oTI;
  public String oUJ;
  public String xJE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256409);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.xJE != null) {
        paramVarArgs.e(3, this.xJE);
      }
      if (this.oTI != null) {
        paramVarArgs.e(4, this.oTI);
      }
      paramVarArgs.aM(5, this.MlV);
      AppMethodBeat.o(256409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.xJE != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xJE);
      }
      paramInt = i;
      if (this.oTI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oTI);
      }
      i = g.a.a.b.b.a.bu(5, this.MlV);
      AppMethodBeat.o(256409);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256409);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cgm localcgm = (cgm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(256409);
          return -1;
        case 1: 
          localcgm.UserName = locala.UbS.readString();
          AppMethodBeat.o(256409);
          return 0;
        case 2: 
          localcgm.oUJ = locala.UbS.readString();
          AppMethodBeat.o(256409);
          return 0;
        case 3: 
          localcgm.xJE = locala.UbS.readString();
          AppMethodBeat.o(256409);
          return 0;
        case 4: 
          localcgm.oTI = locala.UbS.readString();
          AppMethodBeat.o(256409);
          return 0;
        }
        localcgm.MlV = locala.UbS.zi();
        AppMethodBeat.o(256409);
        return 0;
      }
      AppMethodBeat.o(256409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgm
 * JD-Core Version:    0.7.0.1
 */