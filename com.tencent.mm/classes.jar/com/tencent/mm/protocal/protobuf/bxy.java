package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxy
  extends com.tencent.mm.bx.a
{
  public int GRT;
  public String GRU;
  public String bssid;
  public String dmM;
  public int dqG;
  public String ssid;
  public int tlg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32344);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ssid != null) {
        paramVarArgs.d(1, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(2, this.bssid);
      }
      paramVarArgs.aS(3, this.dqG);
      paramVarArgs.aS(4, this.GRT);
      if (this.GRU != null) {
        paramVarArgs.d(5, this.GRU);
      }
      if (this.dmM != null) {
        paramVarArgs.d(6, this.dmM);
      }
      paramVarArgs.aS(7, this.tlg);
      AppMethodBeat.o(32344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ssid == null) {
        break label543;
      }
    }
    label543:
    for (paramInt = f.a.a.b.b.a.e(1, this.ssid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bssid != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.bssid);
      }
      i = i + f.a.a.b.b.a.bz(3, this.dqG) + f.a.a.b.b.a.bz(4, this.GRT);
      paramInt = i;
      if (this.GRU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GRU);
      }
      i = paramInt;
      if (this.dmM != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dmM);
      }
      paramInt = f.a.a.b.b.a.bz(7, this.tlg);
      AppMethodBeat.o(32344);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32344);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxy localbxy = (bxy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32344);
          return -1;
        case 1: 
          localbxy.ssid = locala.NPN.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 2: 
          localbxy.bssid = locala.NPN.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 3: 
          localbxy.dqG = locala.NPN.zc();
          AppMethodBeat.o(32344);
          return 0;
        case 4: 
          localbxy.GRT = locala.NPN.zc();
          AppMethodBeat.o(32344);
          return 0;
        case 5: 
          localbxy.GRU = locala.NPN.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 6: 
          localbxy.dmM = locala.NPN.readString();
          AppMethodBeat.o(32344);
          return 0;
        }
        localbxy.tlg = locala.NPN.zc();
        AppMethodBeat.o(32344);
        return 0;
      }
      AppMethodBeat.o(32344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxy
 * JD-Core Version:    0.7.0.1
 */