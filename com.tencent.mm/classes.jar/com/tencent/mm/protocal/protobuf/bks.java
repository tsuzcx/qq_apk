package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bks
  extends com.tencent.mm.bw.a
{
  public double hRA;
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
      paramVarArgs.e(4, this.hRA);
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
      int i = f.a.a.b.b.a.bx(2, this.major);
      int j = f.a.a.b.b.a.bx(3, this.minor);
      int k = f.a.a.b.b.a.fK(4);
      AppMethodBeat.o(82426);
      return paramInt + i + j + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82426);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bks localbks = (bks)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82426);
          return -1;
        case 1: 
          localbks.uuid = locala.LVo.readString();
          AppMethodBeat.o(82426);
          return 0;
        case 2: 
          localbks.major = locala.LVo.xF();
          AppMethodBeat.o(82426);
          return 0;
        case 3: 
          localbks.minor = locala.LVo.xF();
          AppMethodBeat.o(82426);
          return 0;
        }
        localbks.hRA = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(82426);
        return 0;
      }
      AppMethodBeat.o(82426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bks
 * JD-Core Version:    0.7.0.1
 */