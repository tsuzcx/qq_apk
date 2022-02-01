package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class erz
  extends com.tencent.mm.cd.a
{
  public int fwp;
  public String path;
  public String title;
  public String ufC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127285);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.fwp);
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      if (this.ufC != null) {
        paramVarArgs.f(3, this.ufC);
      }
      if (this.path != null) {
        paramVarArgs.f(4, this.path);
      }
      AppMethodBeat.o(127285);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.fwp) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      i = paramInt;
      if (this.ufC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ufC);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.path);
      }
      AppMethodBeat.o(127285);
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
      AppMethodBeat.o(127285);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      erz localerz = (erz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127285);
        return -1;
      case 1: 
        localerz.fwp = locala.abFh.AK();
        AppMethodBeat.o(127285);
        return 0;
      case 2: 
        localerz.title = locala.abFh.readString();
        AppMethodBeat.o(127285);
        return 0;
      case 3: 
        localerz.ufC = locala.abFh.readString();
        AppMethodBeat.o(127285);
        return 0;
      }
      localerz.path = locala.abFh.readString();
      AppMethodBeat.o(127285);
      return 0;
    }
    AppMethodBeat.o(127285);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erz
 * JD-Core Version:    0.7.0.1
 */