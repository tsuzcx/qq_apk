package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmk
  extends com.tencent.mm.bw.a
{
  public int MrG;
  public String MrH;
  public String bssid;
  public String dFd;
  public int dIX;
  public String ssid;
  public int wNc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32344);
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
      paramVarArgs.aM(4, this.MrG);
      if (this.MrH != null) {
        paramVarArgs.e(5, this.MrH);
      }
      if (this.dFd != null) {
        paramVarArgs.e(6, this.dFd);
      }
      paramVarArgs.aM(7, this.wNc);
      AppMethodBeat.o(32344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ssid == null) {
        break label543;
      }
    }
    label543:
    for (paramInt = g.a.a.b.b.a.f(1, this.ssid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bssid != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.bssid);
      }
      i = i + g.a.a.b.b.a.bu(3, this.dIX) + g.a.a.b.b.a.bu(4, this.MrG);
      paramInt = i;
      if (this.MrH != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MrH);
      }
      i = paramInt;
      if (this.dFd != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.dFd);
      }
      paramInt = g.a.a.b.b.a.bu(7, this.wNc);
      AppMethodBeat.o(32344);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32344);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cmk localcmk = (cmk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32344);
          return -1;
        case 1: 
          localcmk.ssid = locala.UbS.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 2: 
          localcmk.bssid = locala.UbS.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 3: 
          localcmk.dIX = locala.UbS.zi();
          AppMethodBeat.o(32344);
          return 0;
        case 4: 
          localcmk.MrG = locala.UbS.zi();
          AppMethodBeat.o(32344);
          return 0;
        case 5: 
          localcmk.MrH = locala.UbS.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 6: 
          localcmk.dFd = locala.UbS.readString();
          AppMethodBeat.o(32344);
          return 0;
        }
        localcmk.wNc = locala.UbS.zi();
        AppMethodBeat.o(32344);
        return 0;
      }
      AppMethodBeat.o(32344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmk
 * JD-Core Version:    0.7.0.1
 */