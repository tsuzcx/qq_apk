package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzu
  extends com.tencent.mm.bw.a
{
  public int CFz;
  public String HUh;
  public int IeX;
  public int gap;
  public int port;
  public int timeout;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115896);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HUh != null) {
        paramVarArgs.d(1, this.HUh);
      }
      paramVarArgs.aS(2, this.port);
      paramVarArgs.aS(3, this.CFz);
      paramVarArgs.aS(4, this.gap);
      paramVarArgs.aS(5, this.timeout);
      paramVarArgs.aS(6, this.IeX);
      AppMethodBeat.o(115896);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HUh == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = f.a.a.b.b.a.e(1, this.HUh) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.port);
      int j = f.a.a.b.b.a.bz(3, this.CFz);
      int k = f.a.a.b.b.a.bz(4, this.gap);
      int m = f.a.a.b.b.a.bz(5, this.timeout);
      int n = f.a.a.b.b.a.bz(6, this.IeX);
      AppMethodBeat.o(115896);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(115896);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzu localdzu = (dzu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115896);
          return -1;
        case 1: 
          localdzu.HUh = locala.OmT.readString();
          AppMethodBeat.o(115896);
          return 0;
        case 2: 
          localdzu.port = locala.OmT.zc();
          AppMethodBeat.o(115896);
          return 0;
        case 3: 
          localdzu.CFz = locala.OmT.zc();
          AppMethodBeat.o(115896);
          return 0;
        case 4: 
          localdzu.gap = locala.OmT.zc();
          AppMethodBeat.o(115896);
          return 0;
        case 5: 
          localdzu.timeout = locala.OmT.zc();
          AppMethodBeat.o(115896);
          return 0;
        }
        localdzu.IeX = locala.OmT.zc();
        AppMethodBeat.o(115896);
        return 0;
      }
      AppMethodBeat.o(115896);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzu
 * JD-Core Version:    0.7.0.1
 */