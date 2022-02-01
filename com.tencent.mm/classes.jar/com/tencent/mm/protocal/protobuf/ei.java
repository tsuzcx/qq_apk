package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ei
  extends com.tencent.mm.bw.a
{
  public int gNm;
  public String mac;
  public String ssid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32114);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mac != null) {
        paramVarArgs.e(1, this.mac);
      }
      paramVarArgs.aM(2, this.gNm);
      if (this.ssid != null) {
        paramVarArgs.e(3, this.ssid);
      }
      AppMethodBeat.o(32114);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mac == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = g.a.a.b.b.a.f(1, this.mac) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.gNm);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.ssid);
      }
      AppMethodBeat.o(32114);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32114);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ei localei = (ei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32114);
          return -1;
        case 1: 
          localei.mac = locala.UbS.readString();
          AppMethodBeat.o(32114);
          return 0;
        case 2: 
          localei.gNm = locala.UbS.zi();
          AppMethodBeat.o(32114);
          return 0;
        }
        localei.ssid = locala.UbS.readString();
        AppMethodBeat.o(32114);
        return 0;
      }
      AppMethodBeat.o(32114);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ei
 * JD-Core Version:    0.7.0.1
 */