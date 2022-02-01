package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqt
  extends com.tencent.mm.cd.a
{
  public int TVY;
  public int Utf;
  public String Utg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32466);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Utf);
      paramVarArgs.aY(2, this.TVY);
      if (this.Utg != null) {
        paramVarArgs.f(3, this.Utg);
      }
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Utf) + 0 + g.a.a.b.b.a.bM(2, this.TVY);
      paramInt = i;
      if (this.Utg != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Utg);
      }
      AppMethodBeat.o(32466);
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
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eqt localeqt = (eqt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32466);
        return -1;
      case 1: 
        localeqt.Utf = locala.abFh.AK();
        AppMethodBeat.o(32466);
        return 0;
      case 2: 
        localeqt.TVY = locala.abFh.AK();
        AppMethodBeat.o(32466);
        return 0;
      }
      localeqt.Utg = locala.abFh.readString();
      AppMethodBeat.o(32466);
      return 0;
    }
    AppMethodBeat.o(32466);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqt
 * JD-Core Version:    0.7.0.1
 */