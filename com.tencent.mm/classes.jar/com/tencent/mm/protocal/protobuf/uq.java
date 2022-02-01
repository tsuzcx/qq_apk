package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uq
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public int Jnj;
  public String jEd;
  public String text;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113966);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.text != null) {
        paramVarArgs.f(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      paramVarArgs.aY(4, this.Jnj);
      paramVarArgs.aY(5, this.ChC);
      if (this.jEd != null) {
        paramVarArgs.f(6, this.jEd);
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.url);
      }
      i = i + g.a.a.b.b.a.bM(4, this.Jnj) + g.a.a.b.b.a.bM(5, this.ChC);
      paramInt = i;
      if (this.jEd != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.jEd);
      }
      AppMethodBeat.o(113966);
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
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      uq localuq = (uq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113966);
        return -1;
      case 1: 
        localuq.type = locala.abFh.AK();
        AppMethodBeat.o(113966);
        return 0;
      case 2: 
        localuq.text = locala.abFh.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 3: 
        localuq.url = locala.abFh.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 4: 
        localuq.Jnj = locala.abFh.AK();
        AppMethodBeat.o(113966);
        return 0;
      case 5: 
        localuq.ChC = locala.abFh.AK();
        AppMethodBeat.o(113966);
        return 0;
      }
      localuq.jEd = locala.abFh.readString();
      AppMethodBeat.o(113966);
      return 0;
    }
    AppMethodBeat.o(113966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uq
 * JD-Core Version:    0.7.0.1
 */