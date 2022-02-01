package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fvq
  extends com.tencent.mm.bx.a
{
  public String abTK;
  public String abTL;
  public int abTM;
  public int abTN;
  public long abTO;
  public long abTP;
  public long abTQ;
  public long startTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258651);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abTK != null) {
        paramVarArgs.g(1, this.abTK);
      }
      if (this.abTL != null) {
        paramVarArgs.g(2, this.abTL);
      }
      paramVarArgs.bS(3, this.abTM);
      paramVarArgs.bS(4, this.abTN);
      paramVarArgs.bv(5, this.abTO);
      paramVarArgs.bv(6, this.abTP);
      paramVarArgs.bv(7, this.abTQ);
      paramVarArgs.bv(8, this.startTime);
      AppMethodBeat.o(258651);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abTK == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = i.a.a.b.b.a.h(1, this.abTK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abTL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abTL);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abTM);
      int j = i.a.a.b.b.a.cJ(4, this.abTN);
      int k = i.a.a.b.b.a.q(5, this.abTO);
      int m = i.a.a.b.b.a.q(6, this.abTP);
      int n = i.a.a.b.b.a.q(7, this.abTQ);
      int i1 = i.a.a.b.b.a.q(8, this.startTime);
      AppMethodBeat.o(258651);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258651);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fvq localfvq = (fvq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258651);
          return -1;
        case 1: 
          localfvq.abTK = locala.ajGk.readString();
          AppMethodBeat.o(258651);
          return 0;
        case 2: 
          localfvq.abTL = locala.ajGk.readString();
          AppMethodBeat.o(258651);
          return 0;
        case 3: 
          localfvq.abTM = locala.ajGk.aar();
          AppMethodBeat.o(258651);
          return 0;
        case 4: 
          localfvq.abTN = locala.ajGk.aar();
          AppMethodBeat.o(258651);
          return 0;
        case 5: 
          localfvq.abTO = locala.ajGk.aaw();
          AppMethodBeat.o(258651);
          return 0;
        case 6: 
          localfvq.abTP = locala.ajGk.aaw();
          AppMethodBeat.o(258651);
          return 0;
        case 7: 
          localfvq.abTQ = locala.ajGk.aaw();
          AppMethodBeat.o(258651);
          return 0;
        }
        localfvq.startTime = locala.ajGk.aaw();
        AppMethodBeat.o(258651);
        return 0;
      }
      AppMethodBeat.o(258651);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvq
 * JD-Core Version:    0.7.0.1
 */