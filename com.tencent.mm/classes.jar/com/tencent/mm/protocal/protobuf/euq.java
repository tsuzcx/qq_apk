package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class euq
  extends com.tencent.mm.cd.a
{
  public int Uwk;
  public b Uwl;
  public b Uwm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196330);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Uwk);
      if (this.Uwl != null) {
        paramVarArgs.c(2, this.Uwl);
      }
      if (this.Uwm != null) {
        paramVarArgs.c(3, this.Uwm);
      }
      AppMethodBeat.o(196330);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Uwk) + 0;
      paramInt = i;
      if (this.Uwl != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Uwl);
      }
      i = paramInt;
      if (this.Uwm != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Uwm);
      }
      AppMethodBeat.o(196330);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(196330);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      euq localeuq = (euq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(196330);
        return -1;
      case 1: 
        localeuq.Uwk = locala.abFh.AK();
        AppMethodBeat.o(196330);
        return 0;
      case 2: 
        localeuq.Uwl = locala.abFh.iUw();
        AppMethodBeat.o(196330);
        return 0;
      }
      localeuq.Uwm = locala.abFh.iUw();
      AppMethodBeat.o(196330);
      return 0;
    }
    AppMethodBeat.o(196330);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euq
 * JD-Core Version:    0.7.0.1
 */