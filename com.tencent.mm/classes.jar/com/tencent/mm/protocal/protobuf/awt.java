package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awt
  extends com.tencent.mm.bw.a
{
  public String LHv;
  public int LHw;
  public int LHx;
  public String coverImgUrl;
  public String dDJ;
  public int dvv;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209545);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dvv);
      paramVarArgs.aM(2, this.status);
      if (this.coverImgUrl != null) {
        paramVarArgs.e(3, this.coverImgUrl);
      }
      if (this.LHv != null) {
        paramVarArgs.e(4, this.LHv);
      }
      if (this.dDJ != null) {
        paramVarArgs.e(5, this.dDJ);
      }
      paramVarArgs.aM(6, this.LHw);
      paramVarArgs.aM(7, this.LHx);
      AppMethodBeat.o(209545);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.dvv) + 0 + g.a.a.b.b.a.bu(2, this.status);
      paramInt = i;
      if (this.coverImgUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.coverImgUrl);
      }
      i = paramInt;
      if (this.LHv != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.LHv);
      }
      paramInt = i;
      if (this.dDJ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dDJ);
      }
      i = g.a.a.b.b.a.bu(6, this.LHw);
      int j = g.a.a.b.b.a.bu(7, this.LHx);
      AppMethodBeat.o(209545);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209545);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      awt localawt = (awt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209545);
        return -1;
      case 1: 
        localawt.dvv = locala.UbS.zi();
        AppMethodBeat.o(209545);
        return 0;
      case 2: 
        localawt.status = locala.UbS.zi();
        AppMethodBeat.o(209545);
        return 0;
      case 3: 
        localawt.coverImgUrl = locala.UbS.readString();
        AppMethodBeat.o(209545);
        return 0;
      case 4: 
        localawt.LHv = locala.UbS.readString();
        AppMethodBeat.o(209545);
        return 0;
      case 5: 
        localawt.dDJ = locala.UbS.readString();
        AppMethodBeat.o(209545);
        return 0;
      case 6: 
        localawt.LHw = locala.UbS.zi();
        AppMethodBeat.o(209545);
        return 0;
      }
      localawt.LHx = locala.UbS.zi();
      AppMethodBeat.o(209545);
      return 0;
    }
    AppMethodBeat.o(209545);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awt
 * JD-Core Version:    0.7.0.1
 */