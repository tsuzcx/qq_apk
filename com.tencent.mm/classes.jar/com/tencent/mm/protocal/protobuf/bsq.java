package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsq
  extends com.tencent.mm.bx.a
{
  public long FJv;
  public LinkedList<String> GNk;
  
  public bsq()
  {
    AppMethodBeat.i(210605);
    this.FJv = 0L;
    this.GNk = new LinkedList();
    AppMethodBeat.o(210605);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210606);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FJv);
      paramVarArgs.e(2, 1, this.GNk);
      AppMethodBeat.o(210606);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FJv);
      int i = f.a.a.a.c(2, 1, this.GNk);
      AppMethodBeat.o(210606);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GNk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(210606);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsq localbsq = (bsq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(210606);
        return -1;
      case 1: 
        localbsq.FJv = locala.NPN.zd();
        AppMethodBeat.o(210606);
        return 0;
      }
      localbsq.GNk.add(locala.NPN.readString());
      AppMethodBeat.o(210606);
      return 0;
    }
    AppMethodBeat.o(210606);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsq
 * JD-Core Version:    0.7.0.1
 */