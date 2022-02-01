package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aod
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public int RIv;
  public String RIw;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138174);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      paramVarArgs.aY(3, this.RIv);
      if (this.RIw != null) {
        paramVarArgs.f(4, this.RIw);
      }
      AppMethodBeat.o(138174);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CMB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CMB);
      }
      i += g.a.a.b.b.a.bM(3, this.RIv);
      paramInt = i;
      if (this.RIw != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RIw);
      }
      AppMethodBeat.o(138174);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(138174);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aod localaod = (aod)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138174);
          return -1;
        case 1: 
          localaod.fwr = locala.abFh.readString();
          AppMethodBeat.o(138174);
          return 0;
        case 2: 
          localaod.CMB = locala.abFh.readString();
          AppMethodBeat.o(138174);
          return 0;
        case 3: 
          localaod.RIv = locala.abFh.AK();
          AppMethodBeat.o(138174);
          return 0;
        }
        localaod.RIw = locala.abFh.readString();
        AppMethodBeat.o(138174);
        return 0;
      }
      AppMethodBeat.o(138174);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aod
 * JD-Core Version:    0.7.0.1
 */