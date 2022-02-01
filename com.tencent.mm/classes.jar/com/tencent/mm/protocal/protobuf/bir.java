package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bir
  extends com.tencent.mm.bw.a
{
  public int GWA;
  public String GWz;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188484);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Scene);
      if (this.GWz != null) {
        paramVarArgs.d(2, this.GWz);
      }
      paramVarArgs.aS(3, this.GWA);
      AppMethodBeat.o(188484);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Scene) + 0;
      paramInt = i;
      if (this.GWz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GWz);
      }
      i = f.a.a.b.b.a.bz(3, this.GWA);
      AppMethodBeat.o(188484);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(188484);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bir localbir = (bir)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(188484);
        return -1;
      case 1: 
        localbir.Scene = locala.OmT.zc();
        AppMethodBeat.o(188484);
        return 0;
      case 2: 
        localbir.GWz = locala.OmT.readString();
        AppMethodBeat.o(188484);
        return 0;
      }
      localbir.GWA = locala.OmT.zc();
      AppMethodBeat.o(188484);
      return 0;
    }
    AppMethodBeat.o(188484);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bir
 * JD-Core Version:    0.7.0.1
 */