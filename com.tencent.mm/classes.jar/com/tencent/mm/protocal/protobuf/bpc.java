package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpc
  extends com.tencent.mm.bx.a
{
  public double ikO;
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
      paramVarArgs.aS(2, this.major);
      paramVarArgs.aS(3, this.minor);
      paramVarArgs.e(4, this.ikO);
      AppMethodBeat.o(82426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label349;
      }
    }
    label349:
    for (paramInt = f.a.a.b.b.a.e(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.major);
      int j = f.a.a.b.b.a.bz(3, this.minor);
      int k = f.a.a.b.b.a.alT(4);
      AppMethodBeat.o(82426);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82426);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpc localbpc = (bpc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82426);
          return -1;
        case 1: 
          localbpc.uuid = locala.NPN.readString();
          AppMethodBeat.o(82426);
          return 0;
        case 2: 
          localbpc.major = locala.NPN.zc();
          AppMethodBeat.o(82426);
          return 0;
        case 3: 
          localbpc.minor = locala.NPN.zc();
          AppMethodBeat.o(82426);
          return 0;
        }
        localbpc.ikO = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(82426);
        return 0;
      }
      AppMethodBeat.o(82426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpc
 * JD-Core Version:    0.7.0.1
 */