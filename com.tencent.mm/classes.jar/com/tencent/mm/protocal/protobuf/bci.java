package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bci
  extends com.tencent.mm.bv.a
{
  public String bssid;
  public int csT;
  public String ssid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28546);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ssid != null) {
        paramVarArgs.e(1, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.e(2, this.bssid);
      }
      paramVarArgs.aO(3, this.csT);
      AppMethodBeat.o(28546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ssid == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = e.a.a.b.b.a.f(1, this.ssid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bssid != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.bssid);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.csT);
      AppMethodBeat.o(28546);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28546);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bci localbci = (bci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28546);
          return -1;
        case 1: 
          localbci.ssid = locala.CLY.readString();
          AppMethodBeat.o(28546);
          return 0;
        case 2: 
          localbci.bssid = locala.CLY.readString();
          AppMethodBeat.o(28546);
          return 0;
        }
        localbci.csT = locala.CLY.sl();
        AppMethodBeat.o(28546);
        return 0;
      }
      AppMethodBeat.o(28546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bci
 * JD-Core Version:    0.7.0.1
 */