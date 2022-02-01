package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccm
  extends com.tencent.mm.bw.a
{
  public double jiP;
  public int major;
  public int minor;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.e(1, this.uuid);
      }
      paramVarArgs.aM(2, this.major);
      paramVarArgs.aM(3, this.minor);
      paramVarArgs.e(4, this.jiP);
      AppMethodBeat.o(82426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label353;
      }
    }
    label353:
    for (paramInt = g.a.a.b.b.a.f(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.major);
      int j = g.a.a.b.b.a.bu(3, this.minor);
      int k = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(82426);
      return paramInt + i + j + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82426);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ccm localccm = (ccm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82426);
          return -1;
        case 1: 
          localccm.uuid = locala.UbS.readString();
          AppMethodBeat.o(82426);
          return 0;
        case 2: 
          localccm.major = locala.UbS.zi();
          AppMethodBeat.o(82426);
          return 0;
        case 3: 
          localccm.minor = locala.UbS.zi();
          AppMethodBeat.o(82426);
          return 0;
        }
        localccm.jiP = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(82426);
        return 0;
      }
      AppMethodBeat.o(82426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccm
 * JD-Core Version:    0.7.0.1
 */