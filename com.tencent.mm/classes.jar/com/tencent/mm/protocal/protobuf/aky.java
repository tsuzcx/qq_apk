package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aky
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> FJN;
  public int FJO;
  
  public aky()
  {
    AppMethodBeat.i(124487);
    this.FJN = new LinkedList();
    this.FJO = 1;
    AppMethodBeat.o(124487);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124488);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.FJN);
      paramVarArgs.aS(2, this.FJO);
      AppMethodBeat.o(124488);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.FJN);
      int i = f.a.a.b.b.a.bz(2, this.FJO);
      AppMethodBeat.o(124488);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FJN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(124488);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aky localaky = (aky)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124488);
        return -1;
      case 1: 
        localaky.FJN.add(locala.NPN.readString());
        AppMethodBeat.o(124488);
        return 0;
      }
      localaky.FJO = locala.NPN.zc();
      AppMethodBeat.o(124488);
      return 0;
    }
    AppMethodBeat.o(124488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aky
 * JD-Core Version:    0.7.0.1
 */