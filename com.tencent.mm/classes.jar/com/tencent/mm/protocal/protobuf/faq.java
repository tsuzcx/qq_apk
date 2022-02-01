package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class faq
  extends com.tencent.mm.cd.a
{
  public int UAF;
  public String UAG;
  public String UAH;
  public String UAI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213807);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UAF);
      if (this.UAG != null) {
        paramVarArgs.f(2, this.UAG);
      }
      if (this.UAH != null) {
        paramVarArgs.f(3, this.UAH);
      }
      if (this.UAI != null) {
        paramVarArgs.f(4, this.UAI);
      }
      AppMethodBeat.o(213807);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.UAF) + 0;
      paramInt = i;
      if (this.UAG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UAG);
      }
      i = paramInt;
      if (this.UAH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UAH);
      }
      paramInt = i;
      if (this.UAI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UAI);
      }
      AppMethodBeat.o(213807);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(213807);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      faq localfaq = (faq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(213807);
        return -1;
      case 1: 
        localfaq.UAF = locala.abFh.AK();
        AppMethodBeat.o(213807);
        return 0;
      case 2: 
        localfaq.UAG = locala.abFh.readString();
        AppMethodBeat.o(213807);
        return 0;
      case 3: 
        localfaq.UAH = locala.abFh.readString();
        AppMethodBeat.o(213807);
        return 0;
      }
      localfaq.UAI = locala.abFh.readString();
      AppMethodBeat.o(213807);
      return 0;
    }
    AppMethodBeat.o(213807);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.faq
 * JD-Core Version:    0.7.0.1
 */