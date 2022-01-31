package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aea
  extends com.tencent.mm.bv.a
{
  public String ugi;
  public String ugj;
  public String ugk;
  public long wWV;
  public int wWW;
  public double wWX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(141132);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.wWV);
      paramVarArgs.aO(2, this.wWW);
      paramVarArgs.f(3, this.wWX);
      if (this.ugi != null) {
        paramVarArgs.e(4, this.ugi);
      }
      if (this.ugj != null) {
        paramVarArgs.e(5, this.ugj);
      }
      if (this.ugk != null) {
        paramVarArgs.e(6, this.ugk);
      }
      AppMethodBeat.o(141132);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.wWV) + 0 + e.a.a.b.b.a.bl(2, this.wWW) + (e.a.a.b.b.a.eW(3) + 8);
      paramInt = i;
      if (this.ugi != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ugi);
      }
      i = paramInt;
      if (this.ugj != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ugj);
      }
      paramInt = i;
      if (this.ugk != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.ugk);
      }
      AppMethodBeat.o(141132);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(141132);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aea localaea = (aea)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(141132);
        return -1;
      case 1: 
        localaea.wWV = locala.CLY.sm();
        AppMethodBeat.o(141132);
        return 0;
      case 2: 
        localaea.wWW = locala.CLY.sl();
        AppMethodBeat.o(141132);
        return 0;
      case 3: 
        localaea.wWX = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(141132);
        return 0;
      case 4: 
        localaea.ugi = locala.CLY.readString();
        AppMethodBeat.o(141132);
        return 0;
      case 5: 
        localaea.ugj = locala.CLY.readString();
        AppMethodBeat.o(141132);
        return 0;
      }
      localaea.ugk = locala.CLY.readString();
      AppMethodBeat.o(141132);
      return 0;
    }
    AppMethodBeat.o(141132);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aea
 * JD-Core Version:    0.7.0.1
 */