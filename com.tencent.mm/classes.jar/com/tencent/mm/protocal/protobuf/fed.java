package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class fed
  extends com.tencent.mm.bw.a
{
  public b Lqh;
  public String dNI;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50124);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.Lqh != null) {
        paramVarArgs.c(2, this.Lqh);
      }
      if (this.dNI != null) {
        paramVarArgs.e(3, this.dNI);
      }
      AppMethodBeat.o(50124);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.Lqh != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Lqh);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dNI);
      }
      AppMethodBeat.o(50124);
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
      AppMethodBeat.o(50124);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fed localfed = (fed)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50124);
        return -1;
      case 1: 
        localfed.type = locala.UbS.zi();
        AppMethodBeat.o(50124);
        return 0;
      case 2: 
        localfed.Lqh = locala.UbS.hPo();
        AppMethodBeat.o(50124);
        return 0;
      }
      localfed.dNI = locala.UbS.readString();
      AppMethodBeat.o(50124);
      return 0;
    }
    AppMethodBeat.o(50124);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fed
 * JD-Core Version:    0.7.0.1
 */