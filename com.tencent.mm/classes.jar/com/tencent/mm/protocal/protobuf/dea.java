package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dea
  extends com.tencent.mm.bw.a
{
  public String MJb;
  public String MJc;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153294);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.MJb != null) {
        paramVarArgs.e(2, this.MJb);
      }
      if (this.MJc != null) {
        paramVarArgs.e(3, this.MJc);
      }
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.MJb != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MJb);
      }
      i = paramInt;
      if (this.MJc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MJc);
      }
      AppMethodBeat.o(153294);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dea localdea = (dea)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153294);
        return -1;
      case 1: 
        localdea.type = locala.UbS.zi();
        AppMethodBeat.o(153294);
        return 0;
      case 2: 
        localdea.MJb = locala.UbS.readString();
        AppMethodBeat.o(153294);
        return 0;
      }
      localdea.MJc = locala.UbS.readString();
      AppMethodBeat.o(153294);
      return 0;
    }
    AppMethodBeat.o(153294);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dea
 * JD-Core Version:    0.7.0.1
 */