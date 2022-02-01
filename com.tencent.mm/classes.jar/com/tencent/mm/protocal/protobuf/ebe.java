package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ebe
  extends com.tencent.mm.bx.a
{
  public String abgI;
  public int abgJ;
  public int abgK;
  public int abgL;
  public long createTime;
  public String hQQ;
  public String nVS;
  public long vaU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258195);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hQQ != null) {
        paramVarArgs.g(1, this.hQQ);
      }
      if (this.abgI != null) {
        paramVarArgs.g(2, this.abgI);
      }
      if (this.nVS != null) {
        paramVarArgs.g(3, this.nVS);
      }
      paramVarArgs.bv(4, this.createTime);
      paramVarArgs.bS(5, this.abgJ);
      paramVarArgs.bv(6, this.vaU);
      paramVarArgs.bS(7, this.abgK);
      paramVarArgs.bS(8, this.abgL);
      AppMethodBeat.o(258195);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hQQ == null) {
        break label566;
      }
    }
    label566:
    for (int i = i.a.a.b.b.a.h(1, this.hQQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abgI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abgI);
      }
      i = paramInt;
      if (this.nVS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nVS);
      }
      paramInt = i.a.a.b.b.a.q(4, this.createTime);
      int j = i.a.a.b.b.a.cJ(5, this.abgJ);
      int k = i.a.a.b.b.a.q(6, this.vaU);
      int m = i.a.a.b.b.a.cJ(7, this.abgK);
      int n = i.a.a.b.b.a.cJ(8, this.abgL);
      AppMethodBeat.o(258195);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258195);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ebe localebe = (ebe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258195);
          return -1;
        case 1: 
          localebe.hQQ = locala.ajGk.readString();
          AppMethodBeat.o(258195);
          return 0;
        case 2: 
          localebe.abgI = locala.ajGk.readString();
          AppMethodBeat.o(258195);
          return 0;
        case 3: 
          localebe.nVS = locala.ajGk.readString();
          AppMethodBeat.o(258195);
          return 0;
        case 4: 
          localebe.createTime = locala.ajGk.aaw();
          AppMethodBeat.o(258195);
          return 0;
        case 5: 
          localebe.abgJ = locala.ajGk.aar();
          AppMethodBeat.o(258195);
          return 0;
        case 6: 
          localebe.vaU = locala.ajGk.aaw();
          AppMethodBeat.o(258195);
          return 0;
        case 7: 
          localebe.abgK = locala.ajGk.aar();
          AppMethodBeat.o(258195);
          return 0;
        }
        localebe.abgL = locala.ajGk.aar();
        AppMethodBeat.o(258195);
        return 0;
      }
      AppMethodBeat.o(258195);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebe
 * JD-Core Version:    0.7.0.1
 */