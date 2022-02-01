package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vj
  extends com.tencent.mm.cd.a
{
  public int SgP;
  public int SgQ;
  public int mbK;
  public int tag;
  public String ugl;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(253341);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.tag);
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      paramVarArgs.aY(3, this.SgP);
      if (this.ugl != null) {
        paramVarArgs.f(4, this.ugl);
      }
      paramVarArgs.aY(5, this.mbK);
      paramVarArgs.aY(6, this.SgQ);
      AppMethodBeat.o(253341);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.tag) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.SgP);
      paramInt = i;
      if (this.ugl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ugl);
      }
      i = g.a.a.b.b.a.bM(5, this.mbK);
      int j = g.a.a.b.b.a.bM(6, this.SgQ);
      AppMethodBeat.o(253341);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(253341);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      vj localvj = (vj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(253341);
        return -1;
      case 1: 
        localvj.tag = locala.abFh.AK();
        AppMethodBeat.o(253341);
        return 0;
      case 2: 
        localvj.url = locala.abFh.readString();
        AppMethodBeat.o(253341);
        return 0;
      case 3: 
        localvj.SgP = locala.abFh.AK();
        AppMethodBeat.o(253341);
        return 0;
      case 4: 
        localvj.ugl = locala.abFh.readString();
        AppMethodBeat.o(253341);
        return 0;
      case 5: 
        localvj.mbK = locala.abFh.AK();
        AppMethodBeat.o(253341);
        return 0;
      }
      localvj.SgQ = locala.abFh.AK();
      AppMethodBeat.o(253341);
      return 0;
    }
    AppMethodBeat.o(253341);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vj
 * JD-Core Version:    0.7.0.1
 */