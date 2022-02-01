package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dho
  extends com.tencent.mm.bw.a
{
  public String LuS;
  public int MMx;
  public String rBy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32394);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rBy != null) {
        paramVarArgs.e(1, this.rBy);
      }
      paramVarArgs.aM(2, this.MMx);
      if (this.LuS != null) {
        paramVarArgs.e(3, this.LuS);
      }
      AppMethodBeat.o(32394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rBy == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = g.a.a.b.b.a.f(1, this.rBy) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MMx);
      paramInt = i;
      if (this.LuS != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LuS);
      }
      AppMethodBeat.o(32394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32394);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dho localdho = (dho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32394);
          return -1;
        case 1: 
          localdho.rBy = locala.UbS.readString();
          AppMethodBeat.o(32394);
          return 0;
        case 2: 
          localdho.MMx = locala.UbS.zi();
          AppMethodBeat.o(32394);
          return 0;
        }
        localdho.LuS = locala.UbS.readString();
        AppMethodBeat.o(32394);
        return 0;
      }
      AppMethodBeat.o(32394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dho
 * JD-Core Version:    0.7.0.1
 */