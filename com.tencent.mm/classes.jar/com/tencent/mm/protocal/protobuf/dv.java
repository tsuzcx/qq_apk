package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dv
  extends com.tencent.mm.bw.a
{
  public int fLO;
  public String mac;
  public String ssid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mac != null) {
        paramVarArgs.d(1, this.mac);
      }
      paramVarArgs.aR(2, this.fLO);
      if (this.ssid != null) {
        paramVarArgs.d(3, this.ssid);
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
    for (paramInt = f.a.a.b.b.a.e(1, this.mac) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.fLO);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ssid);
      }
      AppMethodBeat.o(32114);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32114);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dv localdv = (dv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32114);
          return -1;
        case 1: 
          localdv.mac = locala.LVo.readString();
          AppMethodBeat.o(32114);
          return 0;
        case 2: 
          localdv.fLO = locala.LVo.xF();
          AppMethodBeat.o(32114);
          return 0;
        }
        localdv.ssid = locala.LVo.readString();
        AppMethodBeat.o(32114);
        return 0;
      }
      AppMethodBeat.o(32114);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dv
 * JD-Core Version:    0.7.0.1
 */