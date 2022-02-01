package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckj
  extends com.tencent.mm.cd.a
{
  public String CRn;
  public float TrV;
  public float TrW;
  public float TrX;
  public String TrY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32326);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(1, this.TrV);
      paramVarArgs.i(2, this.TrW);
      paramVarArgs.i(3, this.TrX);
      if (this.CRn != null) {
        paramVarArgs.f(4, this.CRn);
      }
      if (this.TrY != null) {
        paramVarArgs.f(5, this.TrY);
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 4 + 0 + (g.a.a.b.b.a.gL(2) + 4) + (g.a.a.b.b.a.gL(3) + 4);
      paramInt = i;
      if (this.CRn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CRn);
      }
      i = paramInt;
      if (this.TrY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TrY);
      }
      AppMethodBeat.o(32326);
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
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ckj localckj = (ckj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32326);
        return -1;
      case 1: 
        localckj.TrV = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(32326);
        return 0;
      case 2: 
        localckj.TrW = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(32326);
        return 0;
      case 3: 
        localckj.TrX = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(32326);
        return 0;
      case 4: 
        localckj.CRn = locala.abFh.readString();
        AppMethodBeat.o(32326);
        return 0;
      }
      localckj.TrY = locala.abFh.readString();
      AppMethodBeat.o(32326);
      return 0;
    }
    AppMethodBeat.o(32326);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckj
 * JD-Core Version:    0.7.0.1
 */