package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpu
  extends com.tencent.mm.bw.a
{
  public double inH;
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
      paramVarArgs.e(4, this.inH);
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
      int k = f.a.a.b.b.a.amD(4);
      AppMethodBeat.o(82426);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82426);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpu localbpu = (bpu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82426);
          return -1;
        case 1: 
          localbpu.uuid = locala.OmT.readString();
          AppMethodBeat.o(82426);
          return 0;
        case 2: 
          localbpu.major = locala.OmT.zc();
          AppMethodBeat.o(82426);
          return 0;
        case 3: 
          localbpu.minor = locala.OmT.zc();
          AppMethodBeat.o(82426);
          return 0;
        }
        localbpu.inH = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(82426);
        return 0;
      }
      AppMethodBeat.o(82426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpu
 * JD-Core Version:    0.7.0.1
 */