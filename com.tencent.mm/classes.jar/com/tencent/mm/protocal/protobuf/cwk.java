package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwk
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b MBx;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43115);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MBx == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(43115);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.type);
      if (this.MBx != null) {
        paramVarArgs.c(2, this.MBx);
      }
      AppMethodBeat.o(43115);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.MBx != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.MBx);
      }
      AppMethodBeat.o(43115);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.MBx == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(43115);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43115);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cwk localcwk = (cwk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43115);
        return -1;
      case 1: 
        localcwk.type = locala.UbS.zi();
        AppMethodBeat.o(43115);
        return 0;
      }
      localcwk.MBx = locala.UbS.hPo();
      AppMethodBeat.o(43115);
      return 0;
    }
    AppMethodBeat.o(43115);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwk
 * JD-Core Version:    0.7.0.1
 */