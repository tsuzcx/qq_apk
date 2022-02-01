package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drt
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b CAF;
  public long CCn;
  public int EGJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CAF == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(32552);
        throw paramVarArgs;
      }
      paramVarArgs.aG(1, this.CCn);
      if (this.CAF != null) {
        paramVarArgs.c(2, this.CAF);
      }
      paramVarArgs.aR(3, this.EGJ);
      AppMethodBeat.o(32552);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.CCn) + 0;
      paramInt = i;
      if (this.CAF != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.CAF);
      }
      i = f.a.a.b.b.a.bA(3, this.EGJ);
      AppMethodBeat.o(32552);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.CAF == null)
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
      drt localdrt = (drt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32552);
        return -1;
      case 1: 
        localdrt.CCn = locala.KhF.xT();
        AppMethodBeat.o(32552);
        return 0;
      case 2: 
        localdrt.CAF = locala.KhF.fMu();
        AppMethodBeat.o(32552);
        return 0;
      }
      localdrt.EGJ = locala.KhF.xS();
      AppMethodBeat.o(32552);
      return 0;
    }
    AppMethodBeat.o(32552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drt
 * JD-Core Version:    0.7.0.1
 */