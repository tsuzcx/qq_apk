package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ecs
  extends com.tencent.mm.bx.a
{
  public String FKb;
  public int ukh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKb == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32530);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.ukh);
      if (this.FKb != null) {
        paramVarArgs.d(2, this.FKb);
      }
      AppMethodBeat.o(32530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ukh) + 0;
      paramInt = i;
      if (this.FKb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FKb);
      }
      AppMethodBeat.o(32530);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.FKb == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32530);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32530);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ecs localecs = (ecs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32530);
        return -1;
      case 1: 
        localecs.ukh = locala.NPN.zc();
        AppMethodBeat.o(32530);
        return 0;
      }
      localecs.FKb = locala.NPN.readString();
      AppMethodBeat.o(32530);
      return 0;
    }
    AppMethodBeat.o(32530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecs
 * JD-Core Version:    0.7.0.1
 */