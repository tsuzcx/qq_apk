package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dli
  extends com.tencent.mm.bw.a
{
  public String KUp;
  public long KVE;
  public String MPh;
  public String MPi;
  public int cSx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212301);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KUp != null) {
        paramVarArgs.e(1, this.KUp);
      }
      paramVarArgs.bb(2, this.KVE);
      paramVarArgs.aM(3, this.cSx);
      if (this.MPh != null) {
        paramVarArgs.e(4, this.MPh);
      }
      if (this.MPi != null) {
        paramVarArgs.e(5, this.MPi);
      }
      AppMethodBeat.o(212301);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KUp == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.f(1, this.KUp) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.KVE) + g.a.a.b.b.a.bu(3, this.cSx);
      paramInt = i;
      if (this.MPh != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MPh);
      }
      i = paramInt;
      if (this.MPi != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MPi);
      }
      AppMethodBeat.o(212301);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212301);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dli localdli = (dli)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212301);
          return -1;
        case 1: 
          localdli.KUp = locala.UbS.readString();
          AppMethodBeat.o(212301);
          return 0;
        case 2: 
          localdli.KVE = locala.UbS.zl();
          AppMethodBeat.o(212301);
          return 0;
        case 3: 
          localdli.cSx = locala.UbS.zi();
          AppMethodBeat.o(212301);
          return 0;
        case 4: 
          localdli.MPh = locala.UbS.readString();
          AppMethodBeat.o(212301);
          return 0;
        }
        localdli.MPi = locala.UbS.readString();
        AppMethodBeat.o(212301);
        return 0;
      }
      AppMethodBeat.o(212301);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dli
 * JD-Core Version:    0.7.0.1
 */