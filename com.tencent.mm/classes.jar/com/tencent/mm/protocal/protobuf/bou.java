package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bou
  extends com.tencent.mm.bx.a
{
  public int DMd;
  public String DMe;
  public String bssid;
  public String ddU;
  public int dhP;
  public int rfL;
  public String ssid;
  
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
      paramVarArgs.aR(3, this.dhP);
      paramVarArgs.aR(4, this.DMd);
      if (this.DMe != null) {
        paramVarArgs.d(5, this.DMe);
      }
      if (this.ddU != null) {
        paramVarArgs.d(6, this.ddU);
      }
      paramVarArgs.aR(7, this.rfL);
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
      i = i + f.a.a.b.b.a.bA(3, this.dhP) + f.a.a.b.b.a.bA(4, this.DMd);
      paramInt = i;
      if (this.DMe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DMe);
      }
      i = paramInt;
      if (this.ddU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ddU);
      }
      paramInt = f.a.a.b.b.a.bA(7, this.rfL);
      AppMethodBeat.o(32344);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32344);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bou localbou = (bou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32344);
          return -1;
        case 1: 
          localbou.ssid = locala.KhF.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 2: 
          localbou.bssid = locala.KhF.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 3: 
          localbou.dhP = locala.KhF.xS();
          AppMethodBeat.o(32344);
          return 0;
        case 4: 
          localbou.DMd = locala.KhF.xS();
          AppMethodBeat.o(32344);
          return 0;
        case 5: 
          localbou.DMe = locala.KhF.readString();
          AppMethodBeat.o(32344);
          return 0;
        case 6: 
          localbou.ddU = locala.KhF.readString();
          AppMethodBeat.o(32344);
          return 0;
        }
        localbou.rfL = locala.KhF.xS();
        AppMethodBeat.o(32344);
        return 0;
      }
      AppMethodBeat.o(32344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bou
 * JD-Core Version:    0.7.0.1
 */