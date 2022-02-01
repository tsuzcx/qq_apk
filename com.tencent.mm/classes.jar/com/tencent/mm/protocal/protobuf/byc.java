package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byc
  extends com.tencent.mm.bw.a
{
  public String GWB;
  public long HkR;
  public long HkS;
  public int HkT;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117877);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Scene);
      if (this.GWB != null) {
        paramVarArgs.d(2, this.GWB);
      }
      paramVarArgs.aZ(3, this.HkS);
      paramVarArgs.aZ(4, this.HkR);
      paramVarArgs.aS(5, this.HkT);
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Scene) + 0;
      paramInt = i;
      if (this.GWB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GWB);
      }
      i = f.a.a.b.b.a.p(3, this.HkS);
      int j = f.a.a.b.b.a.p(4, this.HkR);
      int k = f.a.a.b.b.a.bz(5, this.HkT);
      AppMethodBeat.o(117877);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byc localbyc = (byc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117877);
        return -1;
      case 1: 
        localbyc.Scene = locala.OmT.zc();
        AppMethodBeat.o(117877);
        return 0;
      case 2: 
        localbyc.GWB = locala.OmT.readString();
        AppMethodBeat.o(117877);
        return 0;
      case 3: 
        localbyc.HkS = locala.OmT.zd();
        AppMethodBeat.o(117877);
        return 0;
      case 4: 
        localbyc.HkR = locala.OmT.zd();
        AppMethodBeat.o(117877);
        return 0;
      }
      localbyc.HkT = locala.OmT.zc();
      AppMethodBeat.o(117877);
      return 0;
    }
    AppMethodBeat.o(117877);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byc
 * JD-Core Version:    0.7.0.1
 */