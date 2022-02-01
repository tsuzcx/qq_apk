package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyq
  extends com.tencent.mm.cd.a
{
  public String SjX;
  public String Ueg;
  public long Ueh;
  public int Uei;
  public int Uej;
  public int Uek;
  public int Uel;
  public int Uem;
  public int Uen;
  public float Ueo;
  public float Uep;
  public float Ueq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87875);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SjX != null) {
        paramVarArgs.f(1, this.SjX);
      }
      if (this.Ueg != null) {
        paramVarArgs.f(2, this.Ueg);
      }
      paramVarArgs.bm(3, this.Ueh);
      paramVarArgs.aY(4, this.Uei);
      paramVarArgs.aY(5, this.Uej);
      paramVarArgs.aY(6, this.Uek);
      paramVarArgs.aY(7, this.Uel);
      paramVarArgs.aY(8, this.Uem);
      paramVarArgs.aY(9, this.Uen);
      paramVarArgs.i(10, this.Ueo);
      paramVarArgs.i(11, this.Uep);
      paramVarArgs.i(12, this.Ueq);
      AppMethodBeat.o(87875);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SjX == null) {
        break label751;
      }
    }
    label751:
    for (paramInt = g.a.a.b.b.a.g(1, this.SjX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ueg != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Ueg);
      }
      paramInt = g.a.a.b.b.a.p(3, this.Ueh);
      int j = g.a.a.b.b.a.bM(4, this.Uei);
      int k = g.a.a.b.b.a.bM(5, this.Uej);
      int m = g.a.a.b.b.a.bM(6, this.Uek);
      int n = g.a.a.b.b.a.bM(7, this.Uel);
      int i1 = g.a.a.b.b.a.bM(8, this.Uem);
      int i2 = g.a.a.b.b.a.bM(9, this.Uen);
      int i3 = g.a.a.b.b.a.gL(10);
      int i4 = g.a.a.b.b.a.gL(11);
      int i5 = g.a.a.b.b.a.gL(12);
      AppMethodBeat.o(87875);
      return i + paramInt + j + k + m + n + i1 + i2 + (i3 + 4) + (i4 + 4) + (i5 + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(87875);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyq localdyq = (dyq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87875);
          return -1;
        case 1: 
          localdyq.SjX = locala.abFh.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 2: 
          localdyq.Ueg = locala.abFh.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 3: 
          localdyq.Ueh = locala.abFh.AN();
          AppMethodBeat.o(87875);
          return 0;
        case 4: 
          localdyq.Uei = locala.abFh.AK();
          AppMethodBeat.o(87875);
          return 0;
        case 5: 
          localdyq.Uej = locala.abFh.AK();
          AppMethodBeat.o(87875);
          return 0;
        case 6: 
          localdyq.Uek = locala.abFh.AK();
          AppMethodBeat.o(87875);
          return 0;
        case 7: 
          localdyq.Uel = locala.abFh.AK();
          AppMethodBeat.o(87875);
          return 0;
        case 8: 
          localdyq.Uem = locala.abFh.AK();
          AppMethodBeat.o(87875);
          return 0;
        case 9: 
          localdyq.Uen = locala.abFh.AK();
          AppMethodBeat.o(87875);
          return 0;
        case 10: 
          localdyq.Ueo = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(87875);
          return 0;
        case 11: 
          localdyq.Uep = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(87875);
          return 0;
        }
        localdyq.Ueq = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(87875);
        return 0;
      }
      AppMethodBeat.o(87875);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyq
 * JD-Core Version:    0.7.0.1
 */