package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcj
  extends com.tencent.mm.bv.a
{
  public String bssid;
  public String coX;
  public int csT;
  public int mIE;
  public String ssid;
  public int xrs;
  public String xrt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28547);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ssid != null) {
        paramVarArgs.e(1, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.e(2, this.bssid);
      }
      paramVarArgs.aO(3, this.csT);
      paramVarArgs.aO(4, this.xrs);
      if (this.xrt != null) {
        paramVarArgs.e(5, this.xrt);
      }
      if (this.coX != null) {
        paramVarArgs.e(6, this.coX);
      }
      paramVarArgs.aO(7, this.mIE);
      AppMethodBeat.o(28547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ssid == null) {
        break label543;
      }
    }
    label543:
    for (paramInt = e.a.a.b.b.a.f(1, this.ssid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bssid != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.bssid);
      }
      i = i + e.a.a.b.b.a.bl(3, this.csT) + e.a.a.b.b.a.bl(4, this.xrs);
      paramInt = i;
      if (this.xrt != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xrt);
      }
      i = paramInt;
      if (this.coX != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.coX);
      }
      paramInt = e.a.a.b.b.a.bl(7, this.mIE);
      AppMethodBeat.o(28547);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28547);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bcj localbcj = (bcj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28547);
          return -1;
        case 1: 
          localbcj.ssid = locala.CLY.readString();
          AppMethodBeat.o(28547);
          return 0;
        case 2: 
          localbcj.bssid = locala.CLY.readString();
          AppMethodBeat.o(28547);
          return 0;
        case 3: 
          localbcj.csT = locala.CLY.sl();
          AppMethodBeat.o(28547);
          return 0;
        case 4: 
          localbcj.xrs = locala.CLY.sl();
          AppMethodBeat.o(28547);
          return 0;
        case 5: 
          localbcj.xrt = locala.CLY.readString();
          AppMethodBeat.o(28547);
          return 0;
        case 6: 
          localbcj.coX = locala.CLY.readString();
          AppMethodBeat.o(28547);
          return 0;
        }
        localbcj.mIE = locala.CLY.sl();
        AppMethodBeat.o(28547);
        return 0;
      }
      AppMethodBeat.o(28547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcj
 * JD-Core Version:    0.7.0.1
 */