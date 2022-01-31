package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dh
  extends com.tencent.mm.bv.a
{
  public String mac;
  public String ssid;
  public int wpy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28310);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.mac != null) {
        paramVarArgs.e(1, this.mac);
      }
      paramVarArgs.aO(2, this.wpy);
      if (this.ssid != null) {
        paramVarArgs.e(3, this.ssid);
      }
      AppMethodBeat.o(28310);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mac == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = e.a.a.b.b.a.f(1, this.mac) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wpy);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.ssid);
      }
      AppMethodBeat.o(28310);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28310);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dh localdh = (dh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28310);
          return -1;
        case 1: 
          localdh.mac = locala.CLY.readString();
          AppMethodBeat.o(28310);
          return 0;
        case 2: 
          localdh.wpy = locala.CLY.sl();
          AppMethodBeat.o(28310);
          return 0;
        }
        localdh.ssid = locala.CLY.readString();
        AppMethodBeat.o(28310);
        return 0;
      }
      AppMethodBeat.o(28310);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dh
 * JD-Core Version:    0.7.0.1
 */