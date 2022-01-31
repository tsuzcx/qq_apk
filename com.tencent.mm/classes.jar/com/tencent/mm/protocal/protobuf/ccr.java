package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccr
  extends com.tencent.mm.bv.a
{
  public int Version;
  public com.tencent.mm.bv.b xNh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80189);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xNh == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(80189);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Version);
      if (this.xNh != null) {
        paramVarArgs.c(2, this.xNh);
      }
      AppMethodBeat.o(80189);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.Version) + 0;
      paramInt = i;
      if (this.xNh != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.xNh);
      }
      AppMethodBeat.o(80189);
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
      if (this.xNh == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(80189);
        throw paramVarArgs;
      }
      AppMethodBeat.o(80189);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ccr localccr = (ccr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(80189);
        return -1;
      case 1: 
        localccr.Version = locala.CLY.sl();
        AppMethodBeat.o(80189);
        return 0;
      }
      localccr.xNh = locala.CLY.eqS();
      AppMethodBeat.o(80189);
      return 0;
    }
    AppMethodBeat.o(80189);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccr
 * JD-Core Version:    0.7.0.1
 */