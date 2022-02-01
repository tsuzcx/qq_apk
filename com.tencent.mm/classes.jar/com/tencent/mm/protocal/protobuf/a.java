package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.cd.a
{
  public int cUP;
  public String oDJ;
  public String oDK;
  public String tVu;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91310);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.cUP);
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.oDJ != null) {
        paramVarArgs.f(3, this.oDJ);
      }
      if (this.oDK != null) {
        paramVarArgs.f(4, this.oDK);
      }
      if (this.tVu != null) {
        paramVarArgs.f(5, this.tVu);
      }
      AppMethodBeat.o(91310);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.cUP) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt;
      if (this.oDJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.oDJ);
      }
      paramInt = i;
      if (this.oDK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.oDK);
      }
      i = paramInt;
      if (this.tVu != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.tVu);
      }
      AppMethodBeat.o(91310);
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
      AppMethodBeat.o(91310);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91310);
        return -1;
      case 1: 
        locala1.cUP = locala.abFh.AK();
        AppMethodBeat.o(91310);
        return 0;
      case 2: 
        locala1.wording = locala.abFh.readString();
        AppMethodBeat.o(91310);
        return 0;
      case 3: 
        locala1.oDJ = locala.abFh.readString();
        AppMethodBeat.o(91310);
        return 0;
      case 4: 
        locala1.oDK = locala.abFh.readString();
        AppMethodBeat.o(91310);
        return 0;
      }
      locala1.tVu = locala.abFh.readString();
      AppMethodBeat.o(91310);
      return 0;
    }
    AppMethodBeat.o(91310);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a
 * JD-Core Version:    0.7.0.1
 */