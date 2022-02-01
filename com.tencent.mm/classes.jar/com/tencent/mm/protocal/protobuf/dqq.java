package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dqq
  extends com.tencent.mm.bw.a
{
  public int HXx;
  public b HXy;
  public b HXz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(193587);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HXx);
      if (this.HXy != null) {
        paramVarArgs.c(2, this.HXy);
      }
      if (this.HXz != null) {
        paramVarArgs.c(3, this.HXz);
      }
      AppMethodBeat.o(193587);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HXx) + 0;
      paramInt = i;
      if (this.HXy != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HXy);
      }
      i = paramInt;
      if (this.HXz != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HXz);
      }
      AppMethodBeat.o(193587);
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
      AppMethodBeat.o(193587);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dqq localdqq = (dqq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(193587);
        return -1;
      case 1: 
        localdqq.HXx = locala.OmT.zc();
        AppMethodBeat.o(193587);
        return 0;
      case 2: 
        localdqq.HXy = locala.OmT.gCk();
        AppMethodBeat.o(193587);
        return 0;
      }
      localdqq.HXz = locala.OmT.gCk();
      AppMethodBeat.o(193587);
      return 0;
    }
    AppMethodBeat.o(193587);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqq
 * JD-Core Version:    0.7.0.1
 */