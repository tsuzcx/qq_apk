package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class adb
  extends com.tencent.mm.bx.a
{
  public String IHV;
  public int IJG;
  public String Version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110847);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IHV == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110847);
        throw paramVarArgs;
      }
      if (this.IHV != null) {
        paramVarArgs.g(1, this.IHV);
      }
      if (this.Version != null) {
        paramVarArgs.g(2, this.Version);
      }
      paramVarArgs.bS(3, this.IJG);
      AppMethodBeat.o(110847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IHV == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.IHV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Version != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Version);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.IJG);
      AppMethodBeat.o(110847);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IHV == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(110847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110847);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        adb localadb = (adb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110847);
          return -1;
        case 1: 
          localadb.IHV = locala.ajGk.readString();
          AppMethodBeat.o(110847);
          return 0;
        case 2: 
          localadb.Version = locala.ajGk.readString();
          AppMethodBeat.o(110847);
          return 0;
        }
        localadb.IJG = locala.ajGk.aar();
        AppMethodBeat.o(110847);
        return 0;
      }
      AppMethodBeat.o(110847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adb
 * JD-Core Version:    0.7.0.1
 */