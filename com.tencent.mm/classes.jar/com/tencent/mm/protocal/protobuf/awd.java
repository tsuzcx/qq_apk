package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awd
  extends com.tencent.mm.cd.a
{
  public int SIw;
  public int bitrate;
  public String fPD;
  public String zKY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199500);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fPD != null) {
        paramVarArgs.f(1, this.fPD);
      }
      paramVarArgs.aY(2, this.SIw);
      paramVarArgs.aY(3, this.bitrate);
      if (this.zKY != null) {
        paramVarArgs.f(4, this.zKY);
      }
      AppMethodBeat.o(199500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fPD == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.g(1, this.fPD) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SIw) + g.a.a.b.b.a.bM(3, this.bitrate);
      paramInt = i;
      if (this.zKY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.zKY);
      }
      AppMethodBeat.o(199500);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199500);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        awd localawd = (awd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199500);
          return -1;
        case 1: 
          localawd.fPD = locala.abFh.readString();
          AppMethodBeat.o(199500);
          return 0;
        case 2: 
          localawd.SIw = locala.abFh.AK();
          AppMethodBeat.o(199500);
          return 0;
        case 3: 
          localawd.bitrate = locala.abFh.AK();
          AppMethodBeat.o(199500);
          return 0;
        }
        localawd.zKY = locala.abFh.readString();
        AppMethodBeat.o(199500);
        return 0;
      }
      AppMethodBeat.o(199500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awd
 * JD-Core Version:    0.7.0.1
 */