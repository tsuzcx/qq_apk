package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dms
  extends com.tencent.mm.bx.a
{
  public int ECG;
  public String EsN;
  public int gap;
  public int port;
  public int timeout;
  public int zvK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115896);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EsN != null) {
        paramVarArgs.d(1, this.EsN);
      }
      paramVarArgs.aR(2, this.port);
      paramVarArgs.aR(3, this.zvK);
      paramVarArgs.aR(4, this.gap);
      paramVarArgs.aR(5, this.timeout);
      paramVarArgs.aR(6, this.ECG);
      AppMethodBeat.o(115896);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EsN == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = f.a.a.b.b.a.e(1, this.EsN) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.port);
      int j = f.a.a.b.b.a.bA(3, this.zvK);
      int k = f.a.a.b.b.a.bA(4, this.gap);
      int m = f.a.a.b.b.a.bA(5, this.timeout);
      int n = f.a.a.b.b.a.bA(6, this.ECG);
      AppMethodBeat.o(115896);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(115896);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dms localdms = (dms)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115896);
          return -1;
        case 1: 
          localdms.EsN = locala.KhF.readString();
          AppMethodBeat.o(115896);
          return 0;
        case 2: 
          localdms.port = locala.KhF.xS();
          AppMethodBeat.o(115896);
          return 0;
        case 3: 
          localdms.zvK = locala.KhF.xS();
          AppMethodBeat.o(115896);
          return 0;
        case 4: 
          localdms.gap = locala.KhF.xS();
          AppMethodBeat.o(115896);
          return 0;
        case 5: 
          localdms.timeout = locala.KhF.xS();
          AppMethodBeat.o(115896);
          return 0;
        }
        localdms.ECG = locala.KhF.xS();
        AppMethodBeat.o(115896);
        return 0;
      }
      AppMethodBeat.o(115896);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dms
 * JD-Core Version:    0.7.0.1
 */