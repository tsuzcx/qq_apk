package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmt
  extends com.tencent.mm.cd.a
{
  public int ULt;
  public String ULu;
  public String ULv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124575);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.ULt);
      if (this.ULu != null) {
        paramVarArgs.f(2, this.ULu);
      }
      if (this.ULv != null) {
        paramVarArgs.f(3, this.ULv);
      }
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.ULt) + 0;
      paramInt = i;
      if (this.ULu != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ULu);
      }
      i = paramInt;
      if (this.ULv != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ULv);
      }
      AppMethodBeat.o(124575);
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
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fmt localfmt = (fmt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124575);
        return -1;
      case 1: 
        localfmt.ULt = locala.abFh.AK();
        AppMethodBeat.o(124575);
        return 0;
      case 2: 
        localfmt.ULu = locala.abFh.readString();
        AppMethodBeat.o(124575);
        return 0;
      }
      localfmt.ULv = locala.abFh.readString();
      AppMethodBeat.o(124575);
      return 0;
    }
    AppMethodBeat.o(124575);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmt
 * JD-Core Version:    0.7.0.1
 */