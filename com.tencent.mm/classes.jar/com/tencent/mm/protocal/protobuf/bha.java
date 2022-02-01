package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bha
  extends com.tencent.mm.bx.a
{
  public double hqY;
  public int major;
  public int minor;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.d(1, this.uuid);
      }
      paramVarArgs.aR(2, this.major);
      paramVarArgs.aR(3, this.minor);
      paramVarArgs.e(4, this.hqY);
      AppMethodBeat.o(82426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label353;
      }
    }
    label353:
    for (paramInt = f.a.a.b.b.a.e(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.major);
      int j = f.a.a.b.b.a.bA(3, this.minor);
      int k = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(82426);
      return paramInt + i + j + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82426);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bha localbha = (bha)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82426);
          return -1;
        case 1: 
          localbha.uuid = locala.KhF.readString();
          AppMethodBeat.o(82426);
          return 0;
        case 2: 
          localbha.major = locala.KhF.xS();
          AppMethodBeat.o(82426);
          return 0;
        case 3: 
          localbha.minor = locala.KhF.xS();
          AppMethodBeat.o(82426);
          return 0;
        }
        localbha.hqY = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(82426);
        return 0;
      }
      AppMethodBeat.o(82426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bha
 * JD-Core Version:    0.7.0.1
 */