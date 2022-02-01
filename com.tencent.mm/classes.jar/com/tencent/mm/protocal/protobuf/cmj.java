package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmj
  extends com.tencent.mm.bw.a
{
  public String bssid;
  public int dIX;
  public String ssid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32343);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ssid != null) {
        paramVarArgs.e(1, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.e(2, this.bssid);
      }
      paramVarArgs.aM(3, this.dIX);
      AppMethodBeat.o(32343);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ssid == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = g.a.a.b.b.a.f(1, this.ssid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bssid != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.bssid);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.dIX);
      AppMethodBeat.o(32343);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32343);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cmj localcmj = (cmj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32343);
          return -1;
        case 1: 
          localcmj.ssid = locala.UbS.readString();
          AppMethodBeat.o(32343);
          return 0;
        case 2: 
          localcmj.bssid = locala.UbS.readString();
          AppMethodBeat.o(32343);
          return 0;
        }
        localcmj.dIX = locala.UbS.zi();
        AppMethodBeat.o(32343);
        return 0;
      }
      AppMethodBeat.o(32343);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmj
 * JD-Core Version:    0.7.0.1
 */