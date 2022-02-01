package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dw
  extends com.tencent.mm.bw.a
{
  public int ghG;
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
      paramVarArgs.aS(2, this.ghG);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ghG);
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
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32114);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dw localdw = (dw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32114);
          return -1;
        case 1: 
          localdw.mac = locala.OmT.readString();
          AppMethodBeat.o(32114);
          return 0;
        case 2: 
          localdw.ghG = locala.OmT.zc();
          AppMethodBeat.o(32114);
          return 0;
        }
        localdw.ssid = locala.OmT.readString();
        AppMethodBeat.o(32114);
        return 0;
      }
      AppMethodBeat.o(32114);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dw
 * JD-Core Version:    0.7.0.1
 */