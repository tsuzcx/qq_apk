package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kr
  extends com.tencent.mm.bv.a
{
  public String kqi;
  public int ver;
  public String wyi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11702);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyi != null) {
        paramVarArgs.e(1, this.wyi);
      }
      if (this.kqi != null) {
        paramVarArgs.e(2, this.kqi);
      }
      paramVarArgs.aO(3, this.ver);
      AppMethodBeat.o(11702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wyi == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = e.a.a.b.b.a.f(1, this.wyi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kqi != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.kqi);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.ver);
      AppMethodBeat.o(11702);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11702);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        kr localkr = (kr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11702);
          return -1;
        case 1: 
          localkr.wyi = locala.CLY.readString();
          AppMethodBeat.o(11702);
          return 0;
        case 2: 
          localkr.kqi = locala.CLY.readString();
          AppMethodBeat.o(11702);
          return 0;
        }
        localkr.ver = locala.CLY.sl();
        AppMethodBeat.o(11702);
        return 0;
      }
      AppMethodBeat.o(11702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kr
 * JD-Core Version:    0.7.0.1
 */