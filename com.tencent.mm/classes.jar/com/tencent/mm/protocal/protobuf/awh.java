package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awh
  extends com.tencent.mm.bv.a
{
  public String xlG;
  public String xlH;
  public long xlI;
  public int xlJ;
  public int xlK;
  public int xlL;
  public int xlM;
  public int xlN;
  public int xlO;
  public float xlP;
  public float xlQ;
  public float xlR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(54937);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlG != null) {
        paramVarArgs.e(1, this.xlG);
      }
      if (this.xlH != null) {
        paramVarArgs.e(2, this.xlH);
      }
      paramVarArgs.am(3, this.xlI);
      paramVarArgs.aO(4, this.xlJ);
      paramVarArgs.aO(5, this.xlK);
      paramVarArgs.aO(6, this.xlL);
      paramVarArgs.aO(7, this.xlM);
      paramVarArgs.aO(8, this.xlN);
      paramVarArgs.aO(9, this.xlO);
      paramVarArgs.q(10, this.xlP);
      paramVarArgs.q(11, this.xlQ);
      paramVarArgs.q(12, this.xlR);
      AppMethodBeat.o(54937);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlG == null) {
        break label751;
      }
    }
    label751:
    for (paramInt = e.a.a.b.b.a.f(1, this.xlG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xlH != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xlH);
      }
      paramInt = e.a.a.b.b.a.p(3, this.xlI);
      int j = e.a.a.b.b.a.bl(4, this.xlJ);
      int k = e.a.a.b.b.a.bl(5, this.xlK);
      int m = e.a.a.b.b.a.bl(6, this.xlL);
      int n = e.a.a.b.b.a.bl(7, this.xlM);
      int i1 = e.a.a.b.b.a.bl(8, this.xlN);
      int i2 = e.a.a.b.b.a.bl(9, this.xlO);
      int i3 = e.a.a.b.b.a.eW(10);
      int i4 = e.a.a.b.b.a.eW(11);
      int i5 = e.a.a.b.b.a.eW(12);
      AppMethodBeat.o(54937);
      return i + paramInt + j + k + m + n + i1 + i2 + (i3 + 4) + (i4 + 4) + (i5 + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(54937);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        awh localawh = (awh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(54937);
          return -1;
        case 1: 
          localawh.xlG = locala.CLY.readString();
          AppMethodBeat.o(54937);
          return 0;
        case 2: 
          localawh.xlH = locala.CLY.readString();
          AppMethodBeat.o(54937);
          return 0;
        case 3: 
          localawh.xlI = locala.CLY.sm();
          AppMethodBeat.o(54937);
          return 0;
        case 4: 
          localawh.xlJ = locala.CLY.sl();
          AppMethodBeat.o(54937);
          return 0;
        case 5: 
          localawh.xlK = locala.CLY.sl();
          AppMethodBeat.o(54937);
          return 0;
        case 6: 
          localawh.xlL = locala.CLY.sl();
          AppMethodBeat.o(54937);
          return 0;
        case 7: 
          localawh.xlM = locala.CLY.sl();
          AppMethodBeat.o(54937);
          return 0;
        case 8: 
          localawh.xlN = locala.CLY.sl();
          AppMethodBeat.o(54937);
          return 0;
        case 9: 
          localawh.xlO = locala.CLY.sl();
          AppMethodBeat.o(54937);
          return 0;
        case 10: 
          localawh.xlP = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(54937);
          return 0;
        case 11: 
          localawh.xlQ = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(54937);
          return 0;
        }
        localawh.xlR = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(54937);
        return 0;
      }
      AppMethodBeat.o(54937);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awh
 * JD-Core Version:    0.7.0.1
 */