package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class deo
  extends com.tencent.mm.cd.a
{
  public int RYY;
  public int SmH;
  public int TMm;
  public String TMn;
  public String TMo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32361);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RYY);
      if (this.TMo != null) {
        paramVarArgs.f(3, this.TMo);
      }
      paramVarArgs.aY(4, this.TMm);
      paramVarArgs.aY(5, this.SmH);
      if (this.TMn != null) {
        paramVarArgs.f(6, this.TMn);
      }
      AppMethodBeat.o(32361);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RYY) + 0;
      paramInt = i;
      if (this.TMo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TMo);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.TMm) + g.a.a.b.b.a.bM(5, this.SmH);
      paramInt = i;
      if (this.TMn != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TMn);
      }
      AppMethodBeat.o(32361);
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
      AppMethodBeat.o(32361);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      deo localdeo = (deo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(32361);
        return -1;
      case 1: 
        localdeo.RYY = locala.abFh.AK();
        AppMethodBeat.o(32361);
        return 0;
      case 3: 
        localdeo.TMo = locala.abFh.readString();
        AppMethodBeat.o(32361);
        return 0;
      case 4: 
        localdeo.TMm = locala.abFh.AK();
        AppMethodBeat.o(32361);
        return 0;
      case 5: 
        localdeo.SmH = locala.abFh.AK();
        AppMethodBeat.o(32361);
        return 0;
      }
      localdeo.TMn = locala.abFh.readString();
      AppMethodBeat.o(32361);
      return 0;
    }
    AppMethodBeat.o(32361);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deo
 * JD-Core Version:    0.7.0.1
 */