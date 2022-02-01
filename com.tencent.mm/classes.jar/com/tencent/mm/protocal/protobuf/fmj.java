package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fmj
  extends com.tencent.mm.cd.a
{
  public int RTb;
  public String ULd;
  public String ULe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123682);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RTb);
      if (this.ULd != null) {
        paramVarArgs.f(2, this.ULd);
      }
      if (this.ULe != null) {
        paramVarArgs.f(3, this.ULe);
      }
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RTb) + 0;
      paramInt = i;
      if (this.ULd != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ULd);
      }
      i = paramInt;
      if (this.ULe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ULe);
      }
      AppMethodBeat.o(123682);
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
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fmj localfmj = (fmj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123682);
        return -1;
      case 1: 
        localfmj.RTb = locala.abFh.AK();
        AppMethodBeat.o(123682);
        return 0;
      case 2: 
        localfmj.ULd = locala.abFh.readString();
        AppMethodBeat.o(123682);
        return 0;
      }
      localfmj.ULe = locala.abFh.readString();
      AppMethodBeat.o(123682);
      return 0;
    }
    AppMethodBeat.o(123682);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmj
 * JD-Core Version:    0.7.0.1
 */