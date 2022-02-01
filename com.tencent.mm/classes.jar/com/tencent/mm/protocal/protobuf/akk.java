package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akk
  extends com.tencent.mm.cd.a
{
  public long Svo;
  public String Svp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260145);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Svo);
      if (this.Svp != null) {
        paramVarArgs.f(2, this.Svp);
      }
      AppMethodBeat.o(260145);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.Svo) + 0;
      paramInt = i;
      if (this.Svp != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Svp);
      }
      AppMethodBeat.o(260145);
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
      AppMethodBeat.o(260145);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      akk localakk = (akk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260145);
        return -1;
      case 1: 
        localakk.Svo = locala.abFh.AN();
        AppMethodBeat.o(260145);
        return 0;
      }
      localakk.Svp = locala.abFh.readString();
      AppMethodBeat.o(260145);
      return 0;
    }
    AppMethodBeat.o(260145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akk
 * JD-Core Version:    0.7.0.1
 */