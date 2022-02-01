package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyt
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b aaDA;
  public com.tencent.mm.bx.b aaDB;
  public int aaDy;
  public com.tencent.mm.bx.b aaDz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115844);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaDz == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.aaDA == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.aaDy);
      if (this.aaDz != null) {
        paramVarArgs.d(2, this.aaDz);
      }
      if (this.aaDA != null) {
        paramVarArgs.d(3, this.aaDA);
      }
      if (this.aaDB != null) {
        paramVarArgs.d(4, this.aaDB);
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aaDy) + 0;
      paramInt = i;
      if (this.aaDz != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.aaDz);
      }
      i = paramInt;
      if (this.aaDA != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.aaDA);
      }
      paramInt = i;
      if (this.aaDB != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.aaDB);
      }
      AppMethodBeat.o(115844);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.aaDz == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.aaDA == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cyt localcyt = (cyt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115844);
        return -1;
      case 1: 
        localcyt.aaDy = locala.ajGk.aar();
        AppMethodBeat.o(115844);
        return 0;
      case 2: 
        localcyt.aaDz = locala.ajGk.kFX();
        AppMethodBeat.o(115844);
        return 0;
      case 3: 
        localcyt.aaDA = locala.ajGk.kFX();
        AppMethodBeat.o(115844);
        return 0;
      }
      localcyt.aaDB = locala.ajGk.kFX();
      AppMethodBeat.o(115844);
      return 0;
    }
    AppMethodBeat.o(115844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyt
 * JD-Core Version:    0.7.0.1
 */