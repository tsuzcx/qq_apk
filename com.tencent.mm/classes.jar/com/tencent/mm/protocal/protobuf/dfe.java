package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfe
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b HMq;
  public int Version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMq == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(152695);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Version);
      if (this.HMq != null) {
        paramVarArgs.c(2, this.HMq);
      }
      AppMethodBeat.o(152695);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Version) + 0;
      paramInt = i;
      if (this.HMq != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HMq);
      }
      AppMethodBeat.o(152695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HMq == null)
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
      dfe localdfe = (dfe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152695);
        return -1;
      case 1: 
        localdfe.Version = locala.OmT.zc();
        AppMethodBeat.o(152695);
        return 0;
      }
      localdfe.HMq = locala.OmT.gCk();
      AppMethodBeat.o(152695);
      return 0;
    }
    AppMethodBeat.o(152695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfe
 * JD-Core Version:    0.7.0.1
 */