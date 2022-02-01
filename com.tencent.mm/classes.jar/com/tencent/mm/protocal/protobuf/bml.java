package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bml
  extends com.tencent.mm.cd.a
{
  public String ONZ;
  public String OOa;
  public String OOb;
  public long SXm;
  public int SXn;
  public double SXo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91470);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SXm);
      paramVarArgs.aY(2, this.SXn);
      paramVarArgs.e(3, this.SXo);
      if (this.ONZ != null) {
        paramVarArgs.f(4, this.ONZ);
      }
      if (this.OOa != null) {
        paramVarArgs.f(5, this.OOa);
      }
      if (this.OOb != null) {
        paramVarArgs.f(6, this.OOb);
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.SXm) + 0 + g.a.a.b.b.a.bM(2, this.SXn) + (g.a.a.b.b.a.gL(3) + 8);
      paramInt = i;
      if (this.ONZ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ONZ);
      }
      i = paramInt;
      if (this.OOa != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.OOa);
      }
      paramInt = i;
      if (this.OOb != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.OOb);
      }
      AppMethodBeat.o(91470);
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
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bml localbml = (bml)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91470);
        return -1;
      case 1: 
        localbml.SXm = locala.abFh.AN();
        AppMethodBeat.o(91470);
        return 0;
      case 2: 
        localbml.SXn = locala.abFh.AK();
        AppMethodBeat.o(91470);
        return 0;
      case 3: 
        localbml.SXo = Double.longBitsToDouble(locala.abFh.AP());
        AppMethodBeat.o(91470);
        return 0;
      case 4: 
        localbml.ONZ = locala.abFh.readString();
        AppMethodBeat.o(91470);
        return 0;
      case 5: 
        localbml.OOa = locala.abFh.readString();
        AppMethodBeat.o(91470);
        return 0;
      }
      localbml.OOb = locala.abFh.readString();
      AppMethodBeat.o(91470);
      return 0;
    }
    AppMethodBeat.o(91470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bml
 * JD-Core Version:    0.7.0.1
 */