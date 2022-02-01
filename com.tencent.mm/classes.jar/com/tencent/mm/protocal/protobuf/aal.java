package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aal
  extends com.tencent.mm.bx.a
{
  public boolean htP;
  public boolean xwT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.htP);
      paramVarArgs.bt(2, this.xwT);
      AppMethodBeat.o(101527);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alV(1);
      int i = f.a.a.b.b.a.alV(2);
      AppMethodBeat.o(101527);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(101527);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aal localaal = (aal)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(101527);
        return -1;
      case 1: 
        localaal.htP = locala.NPN.grw();
        AppMethodBeat.o(101527);
        return 0;
      }
      localaal.xwT = locala.NPN.grw();
      AppMethodBeat.o(101527);
      return 0;
    }
    AppMethodBeat.o(101527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aal
 * JD-Core Version:    0.7.0.1
 */