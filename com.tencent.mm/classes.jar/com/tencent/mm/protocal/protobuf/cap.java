package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cap
  extends com.tencent.mm.bw.a
{
  public int MfK;
  public com.tencent.mm.bw.b MfL;
  public com.tencent.mm.bw.b MfM;
  public com.tencent.mm.bw.b MfN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115844);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MfL == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.MfM == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.MfK);
      if (this.MfL != null) {
        paramVarArgs.c(2, this.MfL);
      }
      if (this.MfM != null) {
        paramVarArgs.c(3, this.MfM);
      }
      if (this.MfN != null) {
        paramVarArgs.c(4, this.MfN);
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MfK) + 0;
      paramInt = i;
      if (this.MfL != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.MfL);
      }
      i = paramInt;
      if (this.MfM != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.MfM);
      }
      paramInt = i;
      if (this.MfN != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.MfN);
      }
      AppMethodBeat.o(115844);
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
      if (this.MfL == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.MfM == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cap localcap = (cap)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115844);
        return -1;
      case 1: 
        localcap.MfK = locala.UbS.zi();
        AppMethodBeat.o(115844);
        return 0;
      case 2: 
        localcap.MfL = locala.UbS.hPo();
        AppMethodBeat.o(115844);
        return 0;
      case 3: 
        localcap.MfM = locala.UbS.hPo();
        AppMethodBeat.o(115844);
        return 0;
      }
      localcap.MfN = locala.UbS.hPo();
      AppMethodBeat.o(115844);
      return 0;
    }
    AppMethodBeat.o(115844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cap
 * JD-Core Version:    0.7.0.1
 */