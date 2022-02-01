package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ewv
  extends com.tencent.mm.bw.a
{
  public String AOv;
  public String pTL;
  public String qGB;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212318);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.AOv != null) {
        paramVarArgs.e(2, this.AOv);
      }
      if (this.qGB != null) {
        paramVarArgs.e(3, this.qGB);
      }
      if (this.pTL != null) {
        paramVarArgs.e(4, this.pTL);
      }
      AppMethodBeat.o(212318);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.AOv != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.AOv);
      }
      i = paramInt;
      if (this.qGB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qGB);
      }
      paramInt = i;
      if (this.pTL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pTL);
      }
      AppMethodBeat.o(212318);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(212318);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ewv localewv = (ewv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(212318);
        return -1;
      case 1: 
        localewv.type = locala.UbS.zi();
        AppMethodBeat.o(212318);
        return 0;
      case 2: 
        localewv.AOv = locala.UbS.readString();
        AppMethodBeat.o(212318);
        return 0;
      case 3: 
        localewv.qGB = locala.UbS.readString();
        AppMethodBeat.o(212318);
        return 0;
      }
      localewv.pTL = locala.UbS.readString();
      AppMethodBeat.o(212318);
      return 0;
    }
    AppMethodBeat.o(212318);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewv
 * JD-Core Version:    0.7.0.1
 */