package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edc
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b Sth;
  public int UhA;
  public int UhB;
  public int UhC;
  public int UhD;
  public int UhE;
  public int Uhy;
  public int Uhz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32425);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sth == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Uhy);
      paramVarArgs.aY(2, this.Uhz);
      paramVarArgs.aY(3, this.UhA);
      paramVarArgs.aY(4, this.UhB);
      paramVarArgs.aY(5, this.UhC);
      paramVarArgs.aY(6, this.UhD);
      paramVarArgs.aY(7, this.UhE);
      if (this.Sth != null) {
        paramVarArgs.c(8, this.Sth);
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Uhy) + 0 + g.a.a.b.b.a.bM(2, this.Uhz) + g.a.a.b.b.a.bM(3, this.UhA) + g.a.a.b.b.a.bM(4, this.UhB) + g.a.a.b.b.a.bM(5, this.UhC) + g.a.a.b.b.a.bM(6, this.UhD) + g.a.a.b.b.a.bM(7, this.UhE);
      paramInt = i;
      if (this.Sth != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.Sth);
      }
      AppMethodBeat.o(32425);
      return paramInt;
    }
    g.a.a.a.a locala;
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      locala = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(locala); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(locala)) {
        if (!super.populateBuilderWithField(locala, this, paramInt)) {
          locala.iUs();
        }
      }
      if (paramVarArgs == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 3)
    {
      locala = (g.a.a.a.a)paramVarArgs[0];
      edc localedc = (edc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32425);
        return -1;
      case 1: 
        localedc.Uhy = locala.abFh.AK();
        AppMethodBeat.o(32425);
        return 0;
      case 2: 
        localedc.Uhz = locala.abFh.AK();
        AppMethodBeat.o(32425);
        return 0;
      case 3: 
        localedc.UhA = locala.abFh.AK();
        AppMethodBeat.o(32425);
        return 0;
      case 4: 
        localedc.UhB = locala.abFh.AK();
        AppMethodBeat.o(32425);
        return 0;
      case 5: 
        localedc.UhC = locala.abFh.AK();
        AppMethodBeat.o(32425);
        return 0;
      case 6: 
        localedc.UhD = locala.abFh.AK();
        AppMethodBeat.o(32425);
        return 0;
      case 7: 
        localedc.UhE = locala.abFh.AK();
        AppMethodBeat.o(32425);
        return 0;
      }
      localedc.Sth = locala.abFh.iUw();
      AppMethodBeat.o(32425);
      return 0;
    }
    AppMethodBeat.o(32425);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edc
 * JD-Core Version:    0.7.0.1
 */