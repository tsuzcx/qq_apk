package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dov
  extends com.tencent.mm.bx.a
{
  public long GSt;
  public long HDb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110913);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.GSt);
      paramVarArgs.aY(2, this.HDb);
      AppMethodBeat.o(110913);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.GSt);
      int i = f.a.a.b.b.a.p(2, this.HDb);
      AppMethodBeat.o(110913);
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
      AppMethodBeat.o(110913);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dov localdov = (dov)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110913);
        return -1;
      case 1: 
        localdov.GSt = locala.NPN.zd();
        AppMethodBeat.o(110913);
        return 0;
      }
      localdov.HDb = locala.NPN.zd();
      AppMethodBeat.o(110913);
      return 0;
    }
    AppMethodBeat.o(110913);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dov
 * JD-Core Version:    0.7.0.1
 */