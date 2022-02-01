package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dri
  extends com.tencent.mm.bx.a
{
  public long EGk;
  public b mAx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.EGk);
      if (this.mAx != null) {
        paramVarArgs.c(2, this.mAx);
      }
      AppMethodBeat.o(32538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.EGk) + 0;
      paramInt = i;
      if (this.mAx != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.mAx);
      }
      AppMethodBeat.o(32538);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dri localdri = (dri)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32538);
        return -1;
      case 1: 
        localdri.EGk = locala.KhF.xT();
        AppMethodBeat.o(32538);
        return 0;
      }
      localdri.mAx = locala.KhF.fMu();
      AppMethodBeat.o(32538);
      return 0;
    }
    AppMethodBeat.o(32538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dri
 * JD-Core Version:    0.7.0.1
 */