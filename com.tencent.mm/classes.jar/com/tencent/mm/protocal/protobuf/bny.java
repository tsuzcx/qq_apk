package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bny
  extends com.tencent.mm.bw.a
{
  public int HaK;
  public com.tencent.mm.bw.b HaL;
  public com.tencent.mm.bw.b HaM;
  public com.tencent.mm.bw.b HaN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HaL == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.HaM == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.HaK);
      if (this.HaL != null) {
        paramVarArgs.c(2, this.HaL);
      }
      if (this.HaM != null) {
        paramVarArgs.c(3, this.HaM);
      }
      if (this.HaN != null) {
        paramVarArgs.c(4, this.HaN);
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HaK) + 0;
      paramInt = i;
      if (this.HaL != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HaL);
      }
      i = paramInt;
      if (this.HaM != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HaM);
      }
      paramInt = i;
      if (this.HaN != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HaN);
      }
      AppMethodBeat.o(115844);
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
      if (this.HaL == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.HaM == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bny localbny = (bny)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115844);
        return -1;
      case 1: 
        localbny.HaK = locala.OmT.zc();
        AppMethodBeat.o(115844);
        return 0;
      case 2: 
        localbny.HaL = locala.OmT.gCk();
        AppMethodBeat.o(115844);
        return 0;
      case 3: 
        localbny.HaM = locala.OmT.gCk();
        AppMethodBeat.o(115844);
        return 0;
      }
      localbny.HaN = locala.OmT.gCk();
      AppMethodBeat.o(115844);
      return 0;
    }
    AppMethodBeat.o(115844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bny
 * JD-Core Version:    0.7.0.1
 */