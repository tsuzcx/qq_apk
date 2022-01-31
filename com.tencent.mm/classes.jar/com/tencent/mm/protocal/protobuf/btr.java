package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class btr
  extends com.tencent.mm.bv.a
{
  public int ntX;
  public String wxM;
  public long xHe;
  public int xHf;
  public boolean xHg;
  public boolean xHh;
  public int xHi;
  public boolean xHj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11801);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wxM != null) {
        paramVarArgs.e(1, this.wxM);
      }
      paramVarArgs.am(2, this.xHe);
      paramVarArgs.aO(3, this.xHf);
      paramVarArgs.aS(4, this.xHg);
      paramVarArgs.aS(5, this.xHh);
      paramVarArgs.aO(6, this.xHi);
      paramVarArgs.aO(7, this.ntX);
      paramVarArgs.aS(8, this.xHj);
      AppMethodBeat.o(11801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wxM == null) {
        break label548;
      }
    }
    label548:
    for (paramInt = e.a.a.b.b.a.f(1, this.wxM) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.p(2, this.xHe);
      int j = e.a.a.b.b.a.bl(3, this.xHf);
      int k = e.a.a.b.b.a.eW(4);
      int m = e.a.a.b.b.a.eW(5);
      int n = e.a.a.b.b.a.bl(6, this.xHi);
      int i1 = e.a.a.b.b.a.bl(7, this.ntX);
      int i2 = e.a.a.b.b.a.eW(8);
      AppMethodBeat.o(11801);
      return paramInt + i + j + (k + 1) + (m + 1) + n + i1 + (i2 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11801);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        btr localbtr = (btr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11801);
          return -1;
        case 1: 
          localbtr.wxM = locala.CLY.readString();
          AppMethodBeat.o(11801);
          return 0;
        case 2: 
          localbtr.xHe = locala.CLY.sm();
          AppMethodBeat.o(11801);
          return 0;
        case 3: 
          localbtr.xHf = locala.CLY.sl();
          AppMethodBeat.o(11801);
          return 0;
        case 4: 
          localbtr.xHg = locala.CLY.emu();
          AppMethodBeat.o(11801);
          return 0;
        case 5: 
          localbtr.xHh = locala.CLY.emu();
          AppMethodBeat.o(11801);
          return 0;
        case 6: 
          localbtr.xHi = locala.CLY.sl();
          AppMethodBeat.o(11801);
          return 0;
        case 7: 
          localbtr.ntX = locala.CLY.sl();
          AppMethodBeat.o(11801);
          return 0;
        }
        localbtr.xHj = locala.CLY.emu();
        AppMethodBeat.o(11801);
        return 0;
      }
      AppMethodBeat.o(11801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btr
 * JD-Core Version:    0.7.0.1
 */