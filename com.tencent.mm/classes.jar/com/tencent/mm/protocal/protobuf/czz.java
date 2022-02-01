package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class czz
  extends com.tencent.mm.bw.a
{
  public int HJv;
  public int HJw;
  public b HJx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149128);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HJv);
      paramVarArgs.aS(2, this.HJw);
      if (this.HJx != null) {
        paramVarArgs.c(3, this.HJx);
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HJv) + 0 + f.a.a.b.b.a.bz(2, this.HJw);
      paramInt = i;
      if (this.HJx != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.HJx);
      }
      AppMethodBeat.o(149128);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(149128);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      czz localczz = (czz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149128);
        return -1;
      case 1: 
        localczz.HJv = locala.OmT.zc();
        AppMethodBeat.o(149128);
        return 0;
      case 2: 
        localczz.HJw = locala.OmT.zc();
        AppMethodBeat.o(149128);
        return 0;
      }
      localczz.HJx = locala.OmT.gCk();
      AppMethodBeat.o(149128);
      return 0;
    }
    AppMethodBeat.o(149128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czz
 * JD-Core Version:    0.7.0.1
 */