package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ayl
  extends com.tencent.mm.cd.a
{
  public int SKA;
  public String SKB;
  public int SKC;
  public String background_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207457);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SKA);
      if (this.SKB != null) {
        paramVarArgs.f(2, this.SKB);
      }
      paramVarArgs.aY(3, this.SKC);
      if (this.background_color != null) {
        paramVarArgs.f(4, this.background_color);
      }
      AppMethodBeat.o(207457);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SKA) + 0;
      paramInt = i;
      if (this.SKB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SKB);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.SKC);
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.background_color);
      }
      AppMethodBeat.o(207457);
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
      AppMethodBeat.o(207457);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ayl localayl = (ayl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207457);
        return -1;
      case 1: 
        localayl.SKA = locala.abFh.AK();
        AppMethodBeat.o(207457);
        return 0;
      case 2: 
        localayl.SKB = locala.abFh.readString();
        AppMethodBeat.o(207457);
        return 0;
      case 3: 
        localayl.SKC = locala.abFh.AK();
        AppMethodBeat.o(207457);
        return 0;
      }
      localayl.background_color = locala.abFh.readString();
      AppMethodBeat.o(207457);
      return 0;
    }
    AppMethodBeat.o(207457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayl
 * JD-Core Version:    0.7.0.1
 */