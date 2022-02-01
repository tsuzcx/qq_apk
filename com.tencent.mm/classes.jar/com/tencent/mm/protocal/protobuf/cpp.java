package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpp
  extends com.tencent.mm.cd.a
{
  public String Sba;
  public boolean TwU;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91530);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.Sba != null) {
        paramVarArgs.f(3, this.Sba);
      }
      paramVarArgs.co(4, this.TwU);
      AppMethodBeat.o(91530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.Sba != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sba);
      }
      paramInt = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(91530);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91530);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cpp localcpp = (cpp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91530);
        return -1;
      case 1: 
        localcpp.type = locala.abFh.AK();
        AppMethodBeat.o(91530);
        return 0;
      case 2: 
        localcpp.url = locala.abFh.readString();
        AppMethodBeat.o(91530);
        return 0;
      case 3: 
        localcpp.Sba = locala.abFh.readString();
        AppMethodBeat.o(91530);
        return 0;
      }
      localcpp.TwU = locala.abFh.AB();
      AppMethodBeat.o(91530);
      return 0;
    }
    AppMethodBeat.o(91530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpp
 * JD-Core Version:    0.7.0.1
 */