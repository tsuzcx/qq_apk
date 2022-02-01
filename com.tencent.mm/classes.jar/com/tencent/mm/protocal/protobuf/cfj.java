package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfj
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b GZa;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43115);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GZa == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(43115);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.type);
      if (this.GZa != null) {
        paramVarArgs.c(2, this.GZa);
      }
      AppMethodBeat.o(43115);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.GZa != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GZa);
      }
      AppMethodBeat.o(43115);
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
      if (this.GZa == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(43115);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43115);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cfj localcfj = (cfj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43115);
        return -1;
      case 1: 
        localcfj.type = locala.NPN.zc();
        AppMethodBeat.o(43115);
        return 0;
      }
      localcfj.GZa = locala.NPN.gxI();
      AppMethodBeat.o(43115);
      return 0;
    }
    AppMethodBeat.o(43115);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfj
 * JD-Core Version:    0.7.0.1
 */