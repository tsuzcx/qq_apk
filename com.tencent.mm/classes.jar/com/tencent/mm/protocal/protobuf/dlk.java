package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlk
  extends com.tencent.mm.bw.a
{
  public String KUp;
  public long KVE;
  public String MPh;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212304);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KUp != null) {
        paramVarArgs.e(1, this.KUp);
      }
      paramVarArgs.bb(2, this.KVE);
      paramVarArgs.aM(3, this.status);
      if (this.MPh != null) {
        paramVarArgs.e(4, this.MPh);
      }
      AppMethodBeat.o(212304);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KUp == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.f(1, this.KUp) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.KVE) + g.a.a.b.b.a.bu(3, this.status);
      paramInt = i;
      if (this.MPh != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MPh);
      }
      AppMethodBeat.o(212304);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212304);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dlk localdlk = (dlk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212304);
          return -1;
        case 1: 
          localdlk.KUp = locala.UbS.readString();
          AppMethodBeat.o(212304);
          return 0;
        case 2: 
          localdlk.KVE = locala.UbS.zl();
          AppMethodBeat.o(212304);
          return 0;
        case 3: 
          localdlk.status = locala.UbS.zi();
          AppMethodBeat.o(212304);
          return 0;
        }
        localdlk.MPh = locala.UbS.readString();
        AppMethodBeat.o(212304);
        return 0;
      }
      AppMethodBeat.o(212304);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlk
 * JD-Core Version:    0.7.0.1
 */