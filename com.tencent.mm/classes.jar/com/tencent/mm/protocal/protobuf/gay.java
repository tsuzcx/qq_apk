package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gay
  extends com.tencent.mm.bx.a
{
  public int UNy;
  public String abMk;
  public int abYC;
  public int abYD;
  public int port;
  public int timeout;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115896);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abMk != null) {
        paramVarArgs.g(1, this.abMk);
      }
      paramVarArgs.bS(2, this.port);
      paramVarArgs.bS(3, this.UNy);
      paramVarArgs.bS(4, this.abYC);
      paramVarArgs.bS(5, this.timeout);
      paramVarArgs.bS(6, this.abYD);
      AppMethodBeat.o(115896);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abMk == null) {
        break label442;
      }
    }
    label442:
    for (paramInt = i.a.a.b.b.a.h(1, this.abMk) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.port);
      int j = i.a.a.b.b.a.cJ(3, this.UNy);
      int k = i.a.a.b.b.a.cJ(4, this.abYC);
      int m = i.a.a.b.b.a.cJ(5, this.timeout);
      int n = i.a.a.b.b.a.cJ(6, this.abYD);
      AppMethodBeat.o(115896);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(115896);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gay localgay = (gay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115896);
          return -1;
        case 1: 
          localgay.abMk = locala.ajGk.readString();
          AppMethodBeat.o(115896);
          return 0;
        case 2: 
          localgay.port = locala.ajGk.aar();
          AppMethodBeat.o(115896);
          return 0;
        case 3: 
          localgay.UNy = locala.ajGk.aar();
          AppMethodBeat.o(115896);
          return 0;
        case 4: 
          localgay.abYC = locala.ajGk.aar();
          AppMethodBeat.o(115896);
          return 0;
        case 5: 
          localgay.timeout = locala.ajGk.aar();
          AppMethodBeat.o(115896);
          return 0;
        }
        localgay.abYD = locala.ajGk.aar();
        AppMethodBeat.o(115896);
        return 0;
      }
      AppMethodBeat.o(115896);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gay
 * JD-Core Version:    0.7.0.1
 */