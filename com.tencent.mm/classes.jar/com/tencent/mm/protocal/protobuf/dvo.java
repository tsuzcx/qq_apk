package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dvo
  extends com.tencent.mm.cd.a
{
  public int TUV;
  public String UbD;
  public String UbE;
  public int UbF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91667);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TUV);
      if (this.UbD != null) {
        paramVarArgs.f(2, this.UbD);
      }
      if (this.UbE != null) {
        paramVarArgs.f(3, this.UbE);
      }
      paramVarArgs.aY(4, this.UbF);
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.TUV) + 0;
      paramInt = i;
      if (this.UbD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UbD);
      }
      i = paramInt;
      if (this.UbE != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UbE);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.UbF);
      AppMethodBeat.o(91667);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dvo localdvo = (dvo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91667);
        return -1;
      case 1: 
        localdvo.TUV = locala.abFh.AK();
        AppMethodBeat.o(91667);
        return 0;
      case 2: 
        localdvo.UbD = locala.abFh.readString();
        AppMethodBeat.o(91667);
        return 0;
      case 3: 
        localdvo.UbE = locala.abFh.readString();
        AppMethodBeat.o(91667);
        return 0;
      }
      localdvo.UbF = locala.abFh.AK();
      AppMethodBeat.o(91667);
      return 0;
    }
    AppMethodBeat.o(91667);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvo
 * JD-Core Version:    0.7.0.1
 */