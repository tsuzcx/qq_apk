package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ut
  extends com.tencent.mm.bx.a
{
  public int Zag;
  public int Zah;
  public int Zai;
  public int Zaj;
  public int Zak;
  public int Zal;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133161);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zag);
      paramVarArgs.bS(2, this.Zah);
      paramVarArgs.bS(3, this.Zai);
      paramVarArgs.bS(4, this.Zaj);
      paramVarArgs.bS(5, this.Zak);
      paramVarArgs.bS(6, this.Zal);
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Zag);
      int i = i.a.a.b.b.a.cJ(2, this.Zah);
      int j = i.a.a.b.b.a.cJ(3, this.Zai);
      int k = i.a.a.b.b.a.cJ(4, this.Zaj);
      int m = i.a.a.b.b.a.cJ(5, this.Zak);
      int n = i.a.a.b.b.a.cJ(6, this.Zal);
      AppMethodBeat.o(133161);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ut localut = (ut)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133161);
        return -1;
      case 1: 
        localut.Zag = locala.ajGk.aar();
        AppMethodBeat.o(133161);
        return 0;
      case 2: 
        localut.Zah = locala.ajGk.aar();
        AppMethodBeat.o(133161);
        return 0;
      case 3: 
        localut.Zai = locala.ajGk.aar();
        AppMethodBeat.o(133161);
        return 0;
      case 4: 
        localut.Zaj = locala.ajGk.aar();
        AppMethodBeat.o(133161);
        return 0;
      case 5: 
        localut.Zak = locala.ajGk.aar();
        AppMethodBeat.o(133161);
        return 0;
      }
      localut.Zal = locala.ajGk.aar();
      AppMethodBeat.o(133161);
      return 0;
    }
    AppMethodBeat.o(133161);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ut
 * JD-Core Version:    0.7.0.1
 */