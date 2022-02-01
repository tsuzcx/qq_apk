package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btj
  extends com.tencent.mm.bw.a
{
  public String bssid;
  public int dfk;
  public String ssid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32343);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ssid != null) {
        paramVarArgs.d(1, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(2, this.bssid);
      }
      paramVarArgs.aR(3, this.dfk);
      AppMethodBeat.o(32343);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ssid == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.ssid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bssid != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.bssid);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.dfk);
      AppMethodBeat.o(32343);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32343);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        btj localbtj = (btj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32343);
          return -1;
        case 1: 
          localbtj.ssid = locala.LVo.readString();
          AppMethodBeat.o(32343);
          return 0;
        case 2: 
          localbtj.bssid = locala.LVo.readString();
          AppMethodBeat.o(32343);
          return 0;
        }
        localbtj.dfk = locala.LVo.xF();
        AppMethodBeat.o(32343);
        return 0;
      }
      AppMethodBeat.o(32343);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btj
 * JD-Core Version:    0.7.0.1
 */