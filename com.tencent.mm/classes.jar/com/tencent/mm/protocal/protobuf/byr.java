package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byr
  extends com.tencent.mm.bw.a
{
  public String bssid;
  public int drL;
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
      paramVarArgs.aS(3, this.drL);
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
      paramInt = f.a.a.b.b.a.bz(3, this.drL);
      AppMethodBeat.o(32343);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32343);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byr localbyr = (byr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32343);
          return -1;
        case 1: 
          localbyr.ssid = locala.OmT.readString();
          AppMethodBeat.o(32343);
          return 0;
        case 2: 
          localbyr.bssid = locala.OmT.readString();
          AppMethodBeat.o(32343);
          return 0;
        }
        localbyr.drL = locala.OmT.zc();
        AppMethodBeat.o(32343);
        return 0;
      }
      AppMethodBeat.o(32343);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byr
 * JD-Core Version:    0.7.0.1
 */