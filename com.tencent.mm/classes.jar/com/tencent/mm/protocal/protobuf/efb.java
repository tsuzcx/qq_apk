package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efb
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b FQS;
  public long FSD;
  public int Iji;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQS == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      paramVarArgs.aZ(1, this.FSD);
      if (this.FQS != null) {
        paramVarArgs.c(2, this.FQS);
      }
      paramVarArgs.aS(3, this.Iji);
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FSD) + 0;
      paramInt = i;
      if (this.FQS != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FQS);
      }
      i = f.a.a.b.b.a.bz(3, this.Iji);
      AppMethodBeat.o(32552);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.FQS == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      efb localefb = (efb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32552);
        return -1;
      case 1: 
        localefb.FSD = locala.OmT.zd();
        AppMethodBeat.o(32552);
        return 0;
      case 2: 
        localefb.FQS = locala.OmT.gCk();
        AppMethodBeat.o(32552);
        return 0;
      }
      localefb.Iji = locala.OmT.zc();
      AppMethodBeat.o(32552);
      return 0;
    }
    AppMethodBeat.o(32552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efb
 * JD-Core Version:    0.7.0.1
 */