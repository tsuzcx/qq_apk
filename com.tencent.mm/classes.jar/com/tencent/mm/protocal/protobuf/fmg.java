package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmg
  extends com.tencent.mm.cd.a
{
  public int RYL;
  public int ULb;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123680);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.ULb);
      paramVarArgs.aY(2, this.RYL);
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.f(4, this.md5);
      }
      AppMethodBeat.o(123680);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.ULb) + 0 + g.a.a.b.b.a.bM(2, this.RYL);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.md5);
      }
      AppMethodBeat.o(123680);
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
      AppMethodBeat.o(123680);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fmg localfmg = (fmg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123680);
        return -1;
      case 1: 
        localfmg.ULb = locala.abFh.AK();
        AppMethodBeat.o(123680);
        return 0;
      case 2: 
        localfmg.RYL = locala.abFh.AK();
        AppMethodBeat.o(123680);
        return 0;
      case 3: 
        localfmg.url = locala.abFh.readString();
        AppMethodBeat.o(123680);
        return 0;
      }
      localfmg.md5 = locala.abFh.readString();
      AppMethodBeat.o(123680);
      return 0;
    }
    AppMethodBeat.o(123680);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmg
 * JD-Core Version:    0.7.0.1
 */