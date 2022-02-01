package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class boo
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String SZD;
  public String SZE;
  public String SZF;
  public String SZG;
  public int SZu;
  public int Slv;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152546);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Slv);
      if (this.SZD != null) {
        paramVarArgs.f(2, this.SZD);
      }
      if (this.lVG != null) {
        paramVarArgs.f(3, this.lVG);
      }
      if (this.SZE != null) {
        paramVarArgs.f(4, this.SZE);
      }
      if (this.SZF != null) {
        paramVarArgs.f(5, this.SZF);
      }
      if (this.SZG != null) {
        paramVarArgs.f(7, this.SZG);
      }
      paramVarArgs.aY(8, this.SZu);
      paramVarArgs.aY(9, this.CPw);
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Slv) + 0;
      paramInt = i;
      if (this.SZD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SZD);
      }
      i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lVG);
      }
      paramInt = i;
      if (this.SZE != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SZE);
      }
      i = paramInt;
      if (this.SZF != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SZF);
      }
      paramInt = i;
      if (this.SZG != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SZG);
      }
      i = g.a.a.b.b.a.bM(8, this.SZu);
      int j = g.a.a.b.b.a.bM(9, this.CPw);
      AppMethodBeat.o(152546);
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
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      boo localboo = (boo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(152546);
        return -1;
      case 1: 
        localboo.Slv = locala.abFh.AK();
        AppMethodBeat.o(152546);
        return 0;
      case 2: 
        localboo.SZD = locala.abFh.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 3: 
        localboo.lVG = locala.abFh.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 4: 
        localboo.SZE = locala.abFh.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 5: 
        localboo.SZF = locala.abFh.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 7: 
        localboo.SZG = locala.abFh.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 8: 
        localboo.SZu = locala.abFh.AK();
        AppMethodBeat.o(152546);
        return 0;
      }
      localboo.CPw = locala.abFh.AK();
      AppMethodBeat.o(152546);
      return 0;
    }
    AppMethodBeat.o(152546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boo
 * JD-Core Version:    0.7.0.1
 */