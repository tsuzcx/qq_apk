package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class epw
  extends com.tencent.mm.bx.a
{
  public int ILB;
  public String YRs;
  public long abtS;
  public int abtT;
  public boolean abtU;
  public boolean abtV;
  public int abtW;
  public boolean abtX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124546);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRs != null) {
        paramVarArgs.g(1, this.YRs);
      }
      paramVarArgs.bv(2, this.abtS);
      paramVarArgs.bS(3, this.abtT);
      paramVarArgs.di(4, this.abtU);
      paramVarArgs.di(5, this.abtV);
      paramVarArgs.bS(6, this.abtW);
      paramVarArgs.bS(7, this.ILB);
      paramVarArgs.di(8, this.abtX);
      AppMethodBeat.o(124546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRs == null) {
        break label530;
      }
    }
    label530:
    for (paramInt = i.a.a.b.b.a.h(1, this.YRs) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.abtS);
      int j = i.a.a.b.b.a.cJ(3, this.abtT);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.cJ(6, this.abtW);
      int i1 = i.a.a.b.b.a.cJ(7, this.ILB);
      int i2 = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(124546);
      return paramInt + i + j + (k + 1) + (m + 1) + n + i1 + (i2 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124546);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        epw localepw = (epw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124546);
          return -1;
        case 1: 
          localepw.YRs = locala.ajGk.readString();
          AppMethodBeat.o(124546);
          return 0;
        case 2: 
          localepw.abtS = locala.ajGk.aaw();
          AppMethodBeat.o(124546);
          return 0;
        case 3: 
          localepw.abtT = locala.ajGk.aar();
          AppMethodBeat.o(124546);
          return 0;
        case 4: 
          localepw.abtU = locala.ajGk.aai();
          AppMethodBeat.o(124546);
          return 0;
        case 5: 
          localepw.abtV = locala.ajGk.aai();
          AppMethodBeat.o(124546);
          return 0;
        case 6: 
          localepw.abtW = locala.ajGk.aar();
          AppMethodBeat.o(124546);
          return 0;
        case 7: 
          localepw.ILB = locala.ajGk.aar();
          AppMethodBeat.o(124546);
          return 0;
        }
        localepw.abtX = locala.ajGk.aai();
        AppMethodBeat.o(124546);
        return 0;
      }
      AppMethodBeat.o(124546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epw
 * JD-Core Version:    0.7.0.1
 */