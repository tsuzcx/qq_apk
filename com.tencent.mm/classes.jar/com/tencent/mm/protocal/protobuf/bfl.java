package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfl
  extends com.tencent.mm.bw.a
{
  public String LPd;
  public long LPe;
  public int dIZ;
  public String id;
  public int wPz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32213);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      paramVarArgs.aM(2, this.wPz);
      if (this.LPd != null) {
        paramVarArgs.e(3, this.LPd);
      }
      paramVarArgs.bb(4, this.LPe);
      paramVarArgs.aM(5, this.dIZ);
      AppMethodBeat.o(32213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label421;
      }
    }
    label421:
    for (paramInt = g.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.wPz);
      paramInt = i;
      if (this.LPd != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LPd);
      }
      i = g.a.a.b.b.a.r(4, this.LPe);
      int j = g.a.a.b.b.a.bu(5, this.dIZ);
      AppMethodBeat.o(32213);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32213);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bfl localbfl = (bfl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32213);
          return -1;
        case 1: 
          localbfl.id = locala.UbS.readString();
          AppMethodBeat.o(32213);
          return 0;
        case 2: 
          localbfl.wPz = locala.UbS.zi();
          AppMethodBeat.o(32213);
          return 0;
        case 3: 
          localbfl.LPd = locala.UbS.readString();
          AppMethodBeat.o(32213);
          return 0;
        case 4: 
          localbfl.LPe = locala.UbS.zl();
          AppMethodBeat.o(32213);
          return 0;
        }
        localbfl.dIZ = locala.UbS.zi();
        AppMethodBeat.o(32213);
        return 0;
      }
      AppMethodBeat.o(32213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfl
 * JD-Core Version:    0.7.0.1
 */