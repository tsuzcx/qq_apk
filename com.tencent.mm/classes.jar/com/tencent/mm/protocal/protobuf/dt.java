package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dt
  extends com.tencent.mm.bx.a
{
  public int fIi;
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
      paramVarArgs.aR(2, this.fIi);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.fIi);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ssid);
      }
      AppMethodBeat.o(32114);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32114);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dt localdt = (dt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32114);
          return -1;
        case 1: 
          localdt.mac = locala.KhF.readString();
          AppMethodBeat.o(32114);
          return 0;
        case 2: 
          localdt.fIi = locala.KhF.xS();
          AppMethodBeat.o(32114);
          return 0;
        }
        localdt.ssid = locala.KhF.readString();
        AppMethodBeat.o(32114);
        return 0;
      }
      AppMethodBeat.o(32114);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dt
 * JD-Core Version:    0.7.0.1
 */