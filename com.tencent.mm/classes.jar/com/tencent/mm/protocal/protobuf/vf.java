package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vf
  extends com.tencent.mm.cd.a
{
  public String SgE;
  public String SgF;
  public int SgG;
  public int SgH;
  public int SgI;
  public int SgJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123560);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SgE != null) {
        paramVarArgs.f(1, this.SgE);
      }
      if (this.SgF != null) {
        paramVarArgs.f(2, this.SgF);
      }
      paramVarArgs.aY(3, this.SgG);
      paramVarArgs.aY(4, this.SgH);
      paramVarArgs.aY(5, this.SgI);
      paramVarArgs.aY(6, this.SgJ);
      AppMethodBeat.o(123560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SgE == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = g.a.a.b.b.a.g(1, this.SgE) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SgF != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SgF);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.SgG);
      int j = g.a.a.b.b.a.bM(4, this.SgH);
      int k = g.a.a.b.b.a.bM(5, this.SgI);
      int m = g.a.a.b.b.a.bM(6, this.SgJ);
      AppMethodBeat.o(123560);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123560);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        vf localvf = (vf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123560);
          return -1;
        case 1: 
          localvf.SgE = locala.abFh.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 2: 
          localvf.SgF = locala.abFh.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 3: 
          localvf.SgG = locala.abFh.AK();
          AppMethodBeat.o(123560);
          return 0;
        case 4: 
          localvf.SgH = locala.abFh.AK();
          AppMethodBeat.o(123560);
          return 0;
        case 5: 
          localvf.SgI = locala.abFh.AK();
          AppMethodBeat.o(123560);
          return 0;
        }
        localvf.SgJ = locala.abFh.AK();
        AppMethodBeat.o(123560);
        return 0;
      }
      AppMethodBeat.o(123560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vf
 * JD-Core Version:    0.7.0.1
 */