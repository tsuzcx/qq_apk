package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edd
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> HOS;
  public boolean HOT;
  
  public edd()
  {
    AppMethodBeat.i(32543);
    this.HOS = new LinkedList();
    AppMethodBeat.o(32543);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32544);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 2, this.HOS);
      paramVarArgs.bt(2, this.HOT);
      AppMethodBeat.o(32544);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 2, this.HOS);
      int i = f.a.a.b.b.a.alV(2);
      AppMethodBeat.o(32544);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HOS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32544);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      edd localedd = (edd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32544);
        return -1;
      case 1: 
        localedd.HOS.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(32544);
        return 0;
      }
      localedd.HOT = locala.NPN.grw();
      AppMethodBeat.o(32544);
      return 0;
    }
    AppMethodBeat.o(32544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edd
 * JD-Core Version:    0.7.0.1
 */