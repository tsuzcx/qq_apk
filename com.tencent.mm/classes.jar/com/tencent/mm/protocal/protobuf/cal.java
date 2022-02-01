package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cal
  extends com.tencent.mm.bx.a
{
  public int aajs = 7;
  public long aajt = 0L;
  public int aaju = 0;
  public String aajv = "";
  public boolean aajw = false;
  public int cHb = 0;
  public int oUj = 0;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122494);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aajs);
      paramVarArgs.bv(2, this.aajt);
      paramVarArgs.bS(3, this.aaju);
      if (this.aajv != null) {
        paramVarArgs.g(4, this.aajv);
      }
      paramVarArgs.bS(5, this.cHb);
      paramVarArgs.bS(6, this.oUj);
      paramVarArgs.di(7, this.aajw);
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aajs) + 0 + i.a.a.b.b.a.q(2, this.aajt) + i.a.a.b.b.a.cJ(3, this.aaju);
      paramInt = i;
      if (this.aajv != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aajv);
      }
      i = i.a.a.b.b.a.cJ(5, this.cHb);
      int j = i.a.a.b.b.a.cJ(6, this.oUj);
      int k = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(122494);
      return paramInt + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cal localcal = (cal)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122494);
        return -1;
      case 1: 
        localcal.aajs = locala.ajGk.aar();
        AppMethodBeat.o(122494);
        return 0;
      case 2: 
        localcal.aajt = locala.ajGk.aaw();
        AppMethodBeat.o(122494);
        return 0;
      case 3: 
        localcal.aaju = locala.ajGk.aar();
        AppMethodBeat.o(122494);
        return 0;
      case 4: 
        localcal.aajv = locala.ajGk.readString();
        AppMethodBeat.o(122494);
        return 0;
      case 5: 
        localcal.cHb = locala.ajGk.aar();
        AppMethodBeat.o(122494);
        return 0;
      case 6: 
        localcal.oUj = locala.ajGk.aar();
        AppMethodBeat.o(122494);
        return 0;
      }
      localcal.aajw = locala.ajGk.aai();
      AppMethodBeat.o(122494);
      return 0;
    }
    AppMethodBeat.o(122494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cal
 * JD-Core Version:    0.7.0.1
 */