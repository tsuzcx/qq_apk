package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eru
  extends com.tencent.mm.bx.a
{
  public String Zid;
  public int abvA;
  public int abvB;
  public float abvC;
  public float abvD;
  public float abvE;
  public String abvu;
  public long abvv;
  public int abvw;
  public int abvx;
  public int abvy;
  public int abvz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87875);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zid != null) {
        paramVarArgs.g(1, this.Zid);
      }
      if (this.abvu != null) {
        paramVarArgs.g(2, this.abvu);
      }
      paramVarArgs.bv(3, this.abvv);
      paramVarArgs.bS(4, this.abvw);
      paramVarArgs.bS(5, this.abvx);
      paramVarArgs.bS(6, this.abvy);
      paramVarArgs.bS(7, this.abvz);
      paramVarArgs.bS(8, this.abvA);
      paramVarArgs.bS(9, this.abvB);
      paramVarArgs.l(10, this.abvC);
      paramVarArgs.l(11, this.abvD);
      paramVarArgs.l(12, this.abvE);
      AppMethodBeat.o(87875);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zid == null) {
        break label747;
      }
    }
    label747:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abvu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abvu);
      }
      paramInt = i.a.a.b.b.a.q(3, this.abvv);
      int j = i.a.a.b.b.a.cJ(4, this.abvw);
      int k = i.a.a.b.b.a.cJ(5, this.abvx);
      int m = i.a.a.b.b.a.cJ(6, this.abvy);
      int n = i.a.a.b.b.a.cJ(7, this.abvz);
      int i1 = i.a.a.b.b.a.cJ(8, this.abvA);
      int i2 = i.a.a.b.b.a.cJ(9, this.abvB);
      int i3 = i.a.a.b.b.a.ko(10);
      int i4 = i.a.a.b.b.a.ko(11);
      int i5 = i.a.a.b.b.a.ko(12);
      AppMethodBeat.o(87875);
      return i + paramInt + j + k + m + n + i1 + i2 + (i3 + 4) + (i4 + 4) + (i5 + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(87875);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eru localeru = (eru)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87875);
          return -1;
        case 1: 
          localeru.Zid = locala.ajGk.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 2: 
          localeru.abvu = locala.ajGk.readString();
          AppMethodBeat.o(87875);
          return 0;
        case 3: 
          localeru.abvv = locala.ajGk.aaw();
          AppMethodBeat.o(87875);
          return 0;
        case 4: 
          localeru.abvw = locala.ajGk.aar();
          AppMethodBeat.o(87875);
          return 0;
        case 5: 
          localeru.abvx = locala.ajGk.aar();
          AppMethodBeat.o(87875);
          return 0;
        case 6: 
          localeru.abvy = locala.ajGk.aar();
          AppMethodBeat.o(87875);
          return 0;
        case 7: 
          localeru.abvz = locala.ajGk.aar();
          AppMethodBeat.o(87875);
          return 0;
        case 8: 
          localeru.abvA = locala.ajGk.aar();
          AppMethodBeat.o(87875);
          return 0;
        case 9: 
          localeru.abvB = locala.ajGk.aar();
          AppMethodBeat.o(87875);
          return 0;
        case 10: 
          localeru.abvC = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(87875);
          return 0;
        case 11: 
          localeru.abvD = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(87875);
          return 0;
        }
        localeru.abvE = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(87875);
        return 0;
      }
      AppMethodBeat.o(87875);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eru
 * JD-Core Version:    0.7.0.1
 */