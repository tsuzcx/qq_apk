package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmd
  extends com.tencent.mm.bx.a
{
  public int abMu;
  public int abMv;
  public int abMw;
  public int abMx;
  public int abMy;
  public String desc;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258792);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      paramVarArgs.bS(3, this.abMu);
      paramVarArgs.bS(4, this.abMv);
      paramVarArgs.bS(5, this.abMw);
      paramVarArgs.bS(6, this.abMx);
      paramVarArgs.bS(7, this.abMy);
      AppMethodBeat.o(258792);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abMu);
      int j = i.a.a.b.b.a.cJ(4, this.abMv);
      int k = i.a.a.b.b.a.cJ(5, this.abMw);
      int m = i.a.a.b.b.a.cJ(6, this.abMx);
      int n = i.a.a.b.b.a.cJ(7, this.abMy);
      AppMethodBeat.o(258792);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258792);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fmd localfmd = (fmd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258792);
          return -1;
        case 1: 
          localfmd.title = locala.ajGk.readString();
          AppMethodBeat.o(258792);
          return 0;
        case 2: 
          localfmd.desc = locala.ajGk.readString();
          AppMethodBeat.o(258792);
          return 0;
        case 3: 
          localfmd.abMu = locala.ajGk.aar();
          AppMethodBeat.o(258792);
          return 0;
        case 4: 
          localfmd.abMv = locala.ajGk.aar();
          AppMethodBeat.o(258792);
          return 0;
        case 5: 
          localfmd.abMw = locala.ajGk.aar();
          AppMethodBeat.o(258792);
          return 0;
        case 6: 
          localfmd.abMx = locala.ajGk.aar();
          AppMethodBeat.o(258792);
          return 0;
        }
        localfmd.abMy = locala.ajGk.aar();
        AppMethodBeat.o(258792);
        return 0;
      }
      AppMethodBeat.o(258792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmd
 * JD-Core Version:    0.7.0.1
 */