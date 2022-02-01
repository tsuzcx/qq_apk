package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmi
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public float GtJ;
  public String TST;
  public int TTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209082);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      if (this.TST != null) {
        paramVarArgs.f(2, this.TST);
      }
      paramVarArgs.aY(3, this.TTM);
      paramVarArgs.i(4, this.GtJ);
      AppMethodBeat.o(209082);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label365;
      }
    }
    label365:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TST != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TST);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.TTM);
      int j = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(209082);
      return i + paramInt + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(209082);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dmi localdmi = (dmi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209082);
          return -1;
        case 1: 
          localdmi.CMP = locala.abFh.readString();
          AppMethodBeat.o(209082);
          return 0;
        case 2: 
          localdmi.TST = locala.abFh.readString();
          AppMethodBeat.o(209082);
          return 0;
        case 3: 
          localdmi.TTM = locala.abFh.AK();
          AppMethodBeat.o(209082);
          return 0;
        }
        localdmi.GtJ = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(209082);
        return 0;
      }
      AppMethodBeat.o(209082);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmi
 * JD-Core Version:    0.7.0.1
 */