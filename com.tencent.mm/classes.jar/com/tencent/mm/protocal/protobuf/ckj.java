package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckj
  extends com.tencent.mm.bw.a
{
  public int HwS;
  public String HwT;
  public String hFN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HwS);
      if (this.HwT != null) {
        paramVarArgs.d(2, this.HwT);
      }
      if (this.hFN != null) {
        paramVarArgs.d(3, this.hFN);
      }
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HwS) + 0;
      paramInt = i;
      if (this.HwT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HwT);
      }
      i = paramInt;
      if (this.hFN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hFN);
      }
      AppMethodBeat.o(124538);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ckj localckj = (ckj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124538);
        return -1;
      case 1: 
        localckj.HwS = locala.OmT.zc();
        AppMethodBeat.o(124538);
        return 0;
      case 2: 
        localckj.HwT = locala.OmT.readString();
        AppMethodBeat.o(124538);
        return 0;
      }
      localckj.hFN = locala.OmT.readString();
      AppMethodBeat.o(124538);
      return 0;
    }
    AppMethodBeat.o(124538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckj
 * JD-Core Version:    0.7.0.1
 */