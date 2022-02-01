package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmc
  extends com.tencent.mm.bw.a
{
  public String KOS;
  public int MMx;
  public String rBy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32411);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rBy != null) {
        paramVarArgs.e(1, this.rBy);
      }
      if (this.KOS != null) {
        paramVarArgs.e(2, this.KOS);
      }
      paramVarArgs.aM(3, this.MMx);
      AppMethodBeat.o(32411);
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
      int i = paramInt;
      if (this.KOS != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KOS);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MMx);
      AppMethodBeat.o(32411);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32411);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dmc localdmc = (dmc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32411);
          return -1;
        case 1: 
          localdmc.rBy = locala.UbS.readString();
          AppMethodBeat.o(32411);
          return 0;
        case 2: 
          localdmc.KOS = locala.UbS.readString();
          AppMethodBeat.o(32411);
          return 0;
        }
        localdmc.MMx = locala.UbS.zi();
        AppMethodBeat.o(32411);
        return 0;
      }
      AppMethodBeat.o(32411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmc
 * JD-Core Version:    0.7.0.1
 */