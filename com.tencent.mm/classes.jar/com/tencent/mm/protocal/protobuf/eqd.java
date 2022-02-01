package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqd
  extends com.tencent.mm.cd.a
{
  public int RIs;
  public String RRW;
  public String UsA;
  public String UserName;
  public String mVB;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124559);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      paramVarArgs.aY(3, this.RIs);
      if (this.UsA != null) {
        paramVarArgs.f(4, this.UsA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(5, this.mVB);
      }
      if (this.RRW != null) {
        paramVarArgs.f(6, this.RRW);
      }
      AppMethodBeat.o(124559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.rWI);
      }
      i += g.a.a.b.b.a.bM(3, this.RIs);
      paramInt = i;
      if (this.UsA != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UsA);
      }
      i = paramInt;
      if (this.mVB != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mVB);
      }
      paramInt = i;
      if (this.RRW != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RRW);
      }
      AppMethodBeat.o(124559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124559);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eqd localeqd = (eqd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124559);
          return -1;
        case 1: 
          localeqd.UserName = locala.abFh.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 2: 
          localeqd.rWI = locala.abFh.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 3: 
          localeqd.RIs = locala.abFh.AK();
          AppMethodBeat.o(124559);
          return 0;
        case 4: 
          localeqd.UsA = locala.abFh.readString();
          AppMethodBeat.o(124559);
          return 0;
        case 5: 
          localeqd.mVB = locala.abFh.readString();
          AppMethodBeat.o(124559);
          return 0;
        }
        localeqd.RRW = locala.abFh.readString();
        AppMethodBeat.o(124559);
        return 0;
      }
      AppMethodBeat.o(124559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqd
 * JD-Core Version:    0.7.0.1
 */