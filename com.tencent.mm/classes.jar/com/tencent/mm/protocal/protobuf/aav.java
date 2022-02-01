package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class aav
  extends com.tencent.mm.bw.a
{
  public int Scene;
  public String Version;
  public String xJD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110847);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110847);
        throw paramVarArgs;
      }
      if (this.xJD != null) {
        paramVarArgs.e(1, this.xJD);
      }
      if (this.Version != null) {
        paramVarArgs.e(2, this.Version);
      }
      paramVarArgs.aM(3, this.Scene);
      AppMethodBeat.o(110847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJD == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.f(1, this.xJD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Version != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Version);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.Scene);
      AppMethodBeat.o(110847);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xJD == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aav localaav = (aav)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110847);
          return -1;
        case 1: 
          localaav.xJD = locala.UbS.readString();
          AppMethodBeat.o(110847);
          return 0;
        case 2: 
          localaav.Version = locala.UbS.readString();
          AppMethodBeat.o(110847);
          return 0;
        }
        localaav.Scene = locala.UbS.zi();
        AppMethodBeat.o(110847);
        return 0;
      }
      AppMethodBeat.o(110847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aav
 * JD-Core Version:    0.7.0.1
 */