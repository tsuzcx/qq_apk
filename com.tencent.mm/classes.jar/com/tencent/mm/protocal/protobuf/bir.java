package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bir
  extends com.tencent.mm.bv.a
{
  public int type;
  public com.tencent.mm.bv.b xxv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60054);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xxv == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(60054);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.type);
      if (this.xxv != null) {
        paramVarArgs.c(2, this.xxv);
      }
      AppMethodBeat.o(60054);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.xxv != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.xxv);
      }
      AppMethodBeat.o(60054);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xxv == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(60054);
        throw paramVarArgs;
      }
      AppMethodBeat.o(60054);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bir localbir = (bir)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(60054);
        return -1;
      case 1: 
        localbir.type = locala.CLY.sl();
        AppMethodBeat.o(60054);
        return 0;
      }
      localbir.xxv = locala.CLY.eqS();
      AppMethodBeat.o(60054);
      return 0;
    }
    AppMethodBeat.o(60054);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bir
 * JD-Core Version:    0.7.0.1
 */