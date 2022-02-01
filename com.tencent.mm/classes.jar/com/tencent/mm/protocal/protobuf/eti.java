package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eti
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public double RVy;
  public double RVz;
  public String TOk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56262);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.RVz);
      paramVarArgs.e(2, this.RVy);
      if (this.CMP != null) {
        paramVarArgs.f(3, this.CMP);
      }
      if (this.TOk != null) {
        paramVarArgs.f(4, this.TOk);
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 8 + 0 + (g.a.a.b.b.a.gL(2) + 8);
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CMP);
      }
      i = paramInt;
      if (this.TOk != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TOk);
      }
      AppMethodBeat.o(56262);
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
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eti localeti = (eti)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56262);
        return -1;
      case 1: 
        localeti.RVz = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(56262);
        return 0;
      case 2: 
        localeti.RVy = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(56262);
        return 0;
      case 3: 
        localeti.CMP = locala.abFh.readString();
        AppMethodBeat.o(56262);
        return 0;
      }
      localeti.TOk = locala.abFh.readString();
      AppMethodBeat.o(56262);
      return 0;
    }
    AppMethodBeat.o(56262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eti
 * JD-Core Version:    0.7.0.1
 */