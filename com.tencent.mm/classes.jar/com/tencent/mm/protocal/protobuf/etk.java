package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class etk
  extends com.tencent.mm.cd.a
{
  public String AesKey;
  public long Cqz;
  public String RNi;
  public int Uvw;
  public int Uvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Uvw);
      if (this.RNi != null) {
        paramVarArgs.f(2, this.RNi);
      }
      if (this.AesKey != null) {
        paramVarArgs.f(3, this.AesKey);
      }
      paramVarArgs.aY(4, this.Uvx);
      paramVarArgs.bm(5, this.Cqz);
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Uvw) + 0;
      paramInt = i;
      if (this.RNi != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RNi);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.AesKey);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.Uvx);
      int j = g.a.a.b.b.a.p(5, this.Cqz);
      AppMethodBeat.o(127506);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      etk localetk = (etk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127506);
        return -1;
      case 1: 
        localetk.Uvw = locala.abFh.AK();
        AppMethodBeat.o(127506);
        return 0;
      case 2: 
        localetk.RNi = locala.abFh.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 3: 
        localetk.AesKey = locala.abFh.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 4: 
        localetk.Uvx = locala.abFh.AK();
        AppMethodBeat.o(127506);
        return 0;
      }
      localetk.Cqz = locala.abFh.AN();
      AppMethodBeat.o(127506);
      return 0;
    }
    AppMethodBeat.o(127506);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etk
 * JD-Core Version:    0.7.0.1
 */