package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bi
  extends com.tencent.mm.cd.a
{
  public boolean RGk = false;
  public boolean RGl = false;
  public boolean RGm = false;
  public boolean RGn = false;
  public String RGo = "";
  public String RGp = "";
  public String RGq = "";
  public String RGr = "";
  public int RGs = -1;
  public String woF = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122480);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.RGk);
      paramVarArgs.co(2, this.RGl);
      paramVarArgs.co(3, this.RGm);
      paramVarArgs.co(4, this.RGn);
      if (this.RGo != null) {
        paramVarArgs.f(5, this.RGo);
      }
      if (this.RGp != null) {
        paramVarArgs.f(6, this.RGp);
      }
      if (this.RGq != null) {
        paramVarArgs.f(7, this.RGq);
      }
      if (this.RGr != null) {
        paramVarArgs.f(8, this.RGr);
      }
      paramVarArgs.aY(9, this.RGs);
      if (this.woF != null) {
        paramVarArgs.f(10, this.woF);
      }
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0 + (g.a.a.b.b.a.gL(2) + 1) + (g.a.a.b.b.a.gL(3) + 1) + (g.a.a.b.b.a.gL(4) + 1);
      paramInt = i;
      if (this.RGo != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RGo);
      }
      i = paramInt;
      if (this.RGp != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RGp);
      }
      paramInt = i;
      if (this.RGq != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RGq);
      }
      i = paramInt;
      if (this.RGr != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RGr);
      }
      i += g.a.a.b.b.a.bM(9, this.RGs);
      paramInt = i;
      if (this.woF != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.woF);
      }
      AppMethodBeat.o(122480);
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
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bi localbi = (bi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122480);
        return -1;
      case 1: 
        localbi.RGk = locala.abFh.AB();
        AppMethodBeat.o(122480);
        return 0;
      case 2: 
        localbi.RGl = locala.abFh.AB();
        AppMethodBeat.o(122480);
        return 0;
      case 3: 
        localbi.RGm = locala.abFh.AB();
        AppMethodBeat.o(122480);
        return 0;
      case 4: 
        localbi.RGn = locala.abFh.AB();
        AppMethodBeat.o(122480);
        return 0;
      case 5: 
        localbi.RGo = locala.abFh.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 6: 
        localbi.RGp = locala.abFh.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 7: 
        localbi.RGq = locala.abFh.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 8: 
        localbi.RGr = locala.abFh.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 9: 
        localbi.RGs = locala.abFh.AK();
        AppMethodBeat.o(122480);
        return 0;
      }
      localbi.woF = locala.abFh.readString();
      AppMethodBeat.o(122480);
      return 0;
    }
    AppMethodBeat.o(122480);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bi
 * JD-Core Version:    0.7.0.1
 */