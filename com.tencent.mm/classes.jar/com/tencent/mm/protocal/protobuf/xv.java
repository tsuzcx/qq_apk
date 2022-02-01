package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xv
  extends com.tencent.mm.bx.a
{
  public long CZu;
  public long CZv;
  public LinkedList<Integer> CZw;
  public LinkedList<Integer> CZx;
  
  public xv()
  {
    AppMethodBeat.i(184493);
    this.CZw = new LinkedList();
    this.CZx = new LinkedList();
    AppMethodBeat.o(184493);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.CZu);
      paramVarArgs.aG(2, this.CZv);
      paramVarArgs.e(3, 2, this.CZw);
      paramVarArgs.e(4, 2, this.CZx);
      AppMethodBeat.o(184494);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.CZu);
      int i = f.a.a.b.b.a.q(2, this.CZv);
      int j = f.a.a.a.c(3, 2, this.CZw);
      int k = f.a.a.a.c(4, 2, this.CZx);
      AppMethodBeat.o(184494);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CZw.clear();
      this.CZx.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(184494);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      xv localxv = (xv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184494);
        return -1;
      case 1: 
        localxv.CZu = locala.KhF.xT();
        AppMethodBeat.o(184494);
        return 0;
      case 2: 
        localxv.CZv = locala.KhF.xT();
        AppMethodBeat.o(184494);
        return 0;
      case 3: 
        localxv.CZw.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(184494);
        return 0;
      }
      localxv.CZx.add(Integer.valueOf(locala.KhF.xS()));
      AppMethodBeat.o(184494);
      return 0;
    }
    AppMethodBeat.o(184494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xv
 * JD-Core Version:    0.7.0.1
 */