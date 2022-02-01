package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbu
  extends com.tencent.mm.cd.a
{
  public String EyH;
  public boolean SNB;
  public int tpK;
  public String ufC;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231170);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.SNB);
      if (this.ufC != null) {
        paramVarArgs.f(2, this.ufC);
      }
      if (this.wording != null) {
        paramVarArgs.f(3, this.wording);
      }
      paramVarArgs.aY(4, this.tpK);
      if (this.EyH != null) {
        paramVarArgs.f(5, this.EyH);
      }
      AppMethodBeat.o(231170);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0;
      paramInt = i;
      if (this.ufC != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ufC);
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.wording);
      }
      i += g.a.a.b.b.a.bM(4, this.tpK);
      paramInt = i;
      if (this.EyH != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.EyH);
      }
      AppMethodBeat.o(231170);
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
      AppMethodBeat.o(231170);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bbu localbbu = (bbu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(231170);
        return -1;
      case 1: 
        localbbu.SNB = locala.abFh.AB();
        AppMethodBeat.o(231170);
        return 0;
      case 2: 
        localbbu.ufC = locala.abFh.readString();
        AppMethodBeat.o(231170);
        return 0;
      case 3: 
        localbbu.wording = locala.abFh.readString();
        AppMethodBeat.o(231170);
        return 0;
      case 4: 
        localbbu.tpK = locala.abFh.AK();
        AppMethodBeat.o(231170);
        return 0;
      }
      localbbu.EyH = locala.abFh.readString();
      AppMethodBeat.o(231170);
      return 0;
    }
    AppMethodBeat.o(231170);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbu
 * JD-Core Version:    0.7.0.1
 */