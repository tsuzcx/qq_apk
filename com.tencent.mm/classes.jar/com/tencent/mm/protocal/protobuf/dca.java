package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dca
  extends com.tencent.mm.bx.a
{
  public long aaHG;
  public long aaHH;
  public long aaHI;
  public long aaHJ;
  public long aaHK;
  public long aaHL;
  public long aaHM;
  public boolean aaHN;
  public long aaHO;
  public long hqS;
  public int sessionType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259264);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaHG);
      paramVarArgs.bv(2, this.aaHH);
      paramVarArgs.bv(3, this.aaHI);
      paramVarArgs.bv(4, this.aaHJ);
      paramVarArgs.bv(5, this.aaHK);
      paramVarArgs.bS(6, this.sessionType);
      paramVarArgs.bv(7, this.aaHL);
      paramVarArgs.bv(8, this.hqS);
      paramVarArgs.bv(9, this.aaHM);
      paramVarArgs.di(10, this.aaHN);
      paramVarArgs.bv(11, this.aaHO);
      AppMethodBeat.o(259264);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.aaHG);
      int i = i.a.a.b.b.a.q(2, this.aaHH);
      int j = i.a.a.b.b.a.q(3, this.aaHI);
      int k = i.a.a.b.b.a.q(4, this.aaHJ);
      int m = i.a.a.b.b.a.q(5, this.aaHK);
      int n = i.a.a.b.b.a.cJ(6, this.sessionType);
      int i1 = i.a.a.b.b.a.q(7, this.aaHL);
      int i2 = i.a.a.b.b.a.q(8, this.hqS);
      int i3 = i.a.a.b.b.a.q(9, this.aaHM);
      int i4 = i.a.a.b.b.a.ko(10);
      int i5 = i.a.a.b.b.a.q(11, this.aaHO);
      AppMethodBeat.o(259264);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259264);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dca localdca = (dca)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259264);
        return -1;
      case 1: 
        localdca.aaHG = locala.ajGk.aaw();
        AppMethodBeat.o(259264);
        return 0;
      case 2: 
        localdca.aaHH = locala.ajGk.aaw();
        AppMethodBeat.o(259264);
        return 0;
      case 3: 
        localdca.aaHI = locala.ajGk.aaw();
        AppMethodBeat.o(259264);
        return 0;
      case 4: 
        localdca.aaHJ = locala.ajGk.aaw();
        AppMethodBeat.o(259264);
        return 0;
      case 5: 
        localdca.aaHK = locala.ajGk.aaw();
        AppMethodBeat.o(259264);
        return 0;
      case 6: 
        localdca.sessionType = locala.ajGk.aar();
        AppMethodBeat.o(259264);
        return 0;
      case 7: 
        localdca.aaHL = locala.ajGk.aaw();
        AppMethodBeat.o(259264);
        return 0;
      case 8: 
        localdca.hqS = locala.ajGk.aaw();
        AppMethodBeat.o(259264);
        return 0;
      case 9: 
        localdca.aaHM = locala.ajGk.aaw();
        AppMethodBeat.o(259264);
        return 0;
      case 10: 
        localdca.aaHN = locala.ajGk.aai();
        AppMethodBeat.o(259264);
        return 0;
      }
      localdca.aaHO = locala.ajGk.aaw();
      AppMethodBeat.o(259264);
      return 0;
    }
    AppMethodBeat.o(259264);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dca
 * JD-Core Version:    0.7.0.1
 */