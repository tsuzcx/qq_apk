package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class baf
  extends com.tencent.mm.cd.a
{
  public String RLx;
  public int SMc;
  public String SMd;
  public String SMe;
  public int SMf;
  public String SMg;
  public String SMh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210993);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SMc);
      if (this.SMd != null) {
        paramVarArgs.f(2, this.SMd);
      }
      if (this.SMe != null) {
        paramVarArgs.f(3, this.SMe);
      }
      paramVarArgs.aY(4, this.SMf);
      if (this.RLx != null) {
        paramVarArgs.f(5, this.RLx);
      }
      if (this.SMg != null) {
        paramVarArgs.f(6, this.SMg);
      }
      if (this.SMh != null) {
        paramVarArgs.f(7, this.SMh);
      }
      AppMethodBeat.o(210993);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SMc) + 0;
      paramInt = i;
      if (this.SMd != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SMd);
      }
      i = paramInt;
      if (this.SMe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SMe);
      }
      i += g.a.a.b.b.a.bM(4, this.SMf);
      paramInt = i;
      if (this.RLx != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RLx);
      }
      i = paramInt;
      if (this.SMg != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.SMg);
      }
      paramInt = i;
      if (this.SMh != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SMh);
      }
      AppMethodBeat.o(210993);
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
      AppMethodBeat.o(210993);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      baf localbaf = (baf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(210993);
        return -1;
      case 1: 
        localbaf.SMc = locala.abFh.AK();
        AppMethodBeat.o(210993);
        return 0;
      case 2: 
        localbaf.SMd = locala.abFh.readString();
        AppMethodBeat.o(210993);
        return 0;
      case 3: 
        localbaf.SMe = locala.abFh.readString();
        AppMethodBeat.o(210993);
        return 0;
      case 4: 
        localbaf.SMf = locala.abFh.AK();
        AppMethodBeat.o(210993);
        return 0;
      case 5: 
        localbaf.RLx = locala.abFh.readString();
        AppMethodBeat.o(210993);
        return 0;
      case 6: 
        localbaf.SMg = locala.abFh.readString();
        AppMethodBeat.o(210993);
        return 0;
      }
      localbaf.SMh = locala.abFh.readString();
      AppMethodBeat.o(210993);
      return 0;
    }
    AppMethodBeat.o(210993);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baf
 * JD-Core Version:    0.7.0.1
 */