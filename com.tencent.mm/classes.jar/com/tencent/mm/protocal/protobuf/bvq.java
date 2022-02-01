package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvq
  extends com.tencent.mm.bx.a
{
  public int aadA;
  public int aadu;
  public int aadv;
  public int aadw;
  public int aadx;
  public int aady;
  public int aadz;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258882);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bS(2, this.aadu);
      paramVarArgs.bS(3, this.aadv);
      paramVarArgs.bS(4, this.aadw);
      paramVarArgs.bS(5, this.aadx);
      paramVarArgs.bS(6, this.aady);
      paramVarArgs.bS(7, this.aadz);
      paramVarArgs.bS(8, this.aadA);
      AppMethodBeat.o(258882);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.type);
      int i = i.a.a.b.b.a.cJ(2, this.aadu);
      int j = i.a.a.b.b.a.cJ(3, this.aadv);
      int k = i.a.a.b.b.a.cJ(4, this.aadw);
      int m = i.a.a.b.b.a.cJ(5, this.aadx);
      int n = i.a.a.b.b.a.cJ(6, this.aady);
      int i1 = i.a.a.b.b.a.cJ(7, this.aadz);
      int i2 = i.a.a.b.b.a.cJ(8, this.aadA);
      AppMethodBeat.o(258882);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258882);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bvq localbvq = (bvq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258882);
        return -1;
      case 1: 
        localbvq.type = locala.ajGk.aar();
        AppMethodBeat.o(258882);
        return 0;
      case 2: 
        localbvq.aadu = locala.ajGk.aar();
        AppMethodBeat.o(258882);
        return 0;
      case 3: 
        localbvq.aadv = locala.ajGk.aar();
        AppMethodBeat.o(258882);
        return 0;
      case 4: 
        localbvq.aadw = locala.ajGk.aar();
        AppMethodBeat.o(258882);
        return 0;
      case 5: 
        localbvq.aadx = locala.ajGk.aar();
        AppMethodBeat.o(258882);
        return 0;
      case 6: 
        localbvq.aady = locala.ajGk.aar();
        AppMethodBeat.o(258882);
        return 0;
      case 7: 
        localbvq.aadz = locala.ajGk.aar();
        AppMethodBeat.o(258882);
        return 0;
      }
      localbvq.aadA = locala.ajGk.aar();
      AppMethodBeat.o(258882);
      return 0;
    }
    AppMethodBeat.o(258882);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvq
 * JD-Core Version:    0.7.0.1
 */