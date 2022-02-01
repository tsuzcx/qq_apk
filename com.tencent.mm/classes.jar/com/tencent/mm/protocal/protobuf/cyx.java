package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyx
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b FIf;
  public int Version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FIf == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(152695);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Version);
      if (this.FIf != null) {
        paramVarArgs.c(2, this.FIf);
      }
      AppMethodBeat.o(152695);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Version) + 0;
      paramInt = i;
      if (this.FIf != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FIf);
      }
      AppMethodBeat.o(152695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FIf == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(152695);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152695);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cyx localcyx = (cyx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152695);
        return -1;
      case 1: 
        localcyx.Version = locala.LVo.xF();
        AppMethodBeat.o(152695);
        return 0;
      }
      localcyx.FIf = locala.LVo.gfk();
      AppMethodBeat.o(152695);
      return 0;
    }
    AppMethodBeat.o(152695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyx
 * JD-Core Version:    0.7.0.1
 */