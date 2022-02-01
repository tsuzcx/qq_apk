package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dly
  extends com.tencent.mm.cd.a
{
  public float ScO;
  public float ScP;
  public String TSU;
  public String TSV;
  public long TSW;
  public String TrY;
  public String mVA;
  public String mVH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117892);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TSU != null) {
        paramVarArgs.f(1, this.TSU);
      }
      if (this.mVH != null) {
        paramVarArgs.f(2, this.mVH);
      }
      if (this.mVA != null) {
        paramVarArgs.f(3, this.mVA);
      }
      if (this.TrY != null) {
        paramVarArgs.f(4, this.TrY);
      }
      paramVarArgs.i(5, this.ScP);
      paramVarArgs.i(6, this.ScO);
      if (this.TSV != null) {
        paramVarArgs.f(7, this.TSV);
      }
      paramVarArgs.bm(8, this.TSW);
      AppMethodBeat.o(117892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TSU == null) {
        break label592;
      }
    }
    label592:
    for (int i = g.a.a.b.b.a.g(1, this.TSU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.mVH);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.mVA);
      }
      paramInt = i;
      if (this.TrY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TrY);
      }
      i = paramInt + (g.a.a.b.b.a.gL(5) + 4) + (g.a.a.b.b.a.gL(6) + 4);
      paramInt = i;
      if (this.TSV != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TSV);
      }
      i = g.a.a.b.b.a.p(8, this.TSW);
      AppMethodBeat.o(117892);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117892);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dly localdly = (dly)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117892);
          return -1;
        case 1: 
          localdly.TSU = locala.abFh.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 2: 
          localdly.mVH = locala.abFh.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 3: 
          localdly.mVA = locala.abFh.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 4: 
          localdly.TrY = locala.abFh.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 5: 
          localdly.ScP = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(117892);
          return 0;
        case 6: 
          localdly.ScO = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(117892);
          return 0;
        case 7: 
          localdly.TSV = locala.abFh.readString();
          AppMethodBeat.o(117892);
          return 0;
        }
        localdly.TSW = locala.abFh.AN();
        AppMethodBeat.o(117892);
        return 0;
      }
      AppMethodBeat.o(117892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dly
 * JD-Core Version:    0.7.0.1
 */