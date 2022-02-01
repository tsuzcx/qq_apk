package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccw
  extends com.tencent.mm.bw.a
{
  public String Hpr;
  public String Hps;
  public int Hpt;
  public int Hpu;
  public int Hpv;
  public int Hpw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133179);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hpr != null) {
        paramVarArgs.d(1, this.Hpr);
      }
      if (this.Hps != null) {
        paramVarArgs.d(2, this.Hps);
      }
      paramVarArgs.aS(3, this.Hpt);
      paramVarArgs.aS(4, this.Hpu);
      paramVarArgs.aS(5, this.Hpv);
      paramVarArgs.aS(7, this.Hpw);
      AppMethodBeat.o(133179);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hpr == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hpr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hps != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hps);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Hpt);
      int j = f.a.a.b.b.a.bz(4, this.Hpu);
      int k = f.a.a.b.b.a.bz(5, this.Hpv);
      int m = f.a.a.b.b.a.bz(7, this.Hpw);
      AppMethodBeat.o(133179);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133179);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccw localccw = (ccw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 6: 
        default: 
          AppMethodBeat.o(133179);
          return -1;
        case 1: 
          localccw.Hpr = locala.OmT.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 2: 
          localccw.Hps = locala.OmT.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 3: 
          localccw.Hpt = locala.OmT.zc();
          AppMethodBeat.o(133179);
          return 0;
        case 4: 
          localccw.Hpu = locala.OmT.zc();
          AppMethodBeat.o(133179);
          return 0;
        case 5: 
          localccw.Hpv = locala.OmT.zc();
          AppMethodBeat.o(133179);
          return 0;
        }
        localccw.Hpw = locala.OmT.zc();
        AppMethodBeat.o(133179);
        return 0;
      }
      AppMethodBeat.o(133179);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccw
 * JD-Core Version:    0.7.0.1
 */