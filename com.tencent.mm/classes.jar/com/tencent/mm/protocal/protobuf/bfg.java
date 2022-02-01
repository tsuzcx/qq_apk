package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfg
  extends com.tencent.mm.bx.a
{
  public int DCq;
  public com.tencent.mm.bx.b DCr;
  public com.tencent.mm.bx.b DCs;
  public com.tencent.mm.bx.b DCt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DCr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.DCs == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.DCq);
      if (this.DCr != null) {
        paramVarArgs.c(2, this.DCr);
      }
      if (this.DCs != null) {
        paramVarArgs.c(3, this.DCs);
      }
      if (this.DCt != null) {
        paramVarArgs.c(4, this.DCt);
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DCq) + 0;
      paramInt = i;
      if (this.DCr != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DCr);
      }
      i = paramInt;
      if (this.DCs != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.DCs);
      }
      paramInt = i;
      if (this.DCt != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.DCt);
      }
      AppMethodBeat.o(115844);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.DCr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.DCs == null)
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
      bfg localbfg = (bfg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115844);
        return -1;
      case 1: 
        localbfg.DCq = locala.KhF.xS();
        AppMethodBeat.o(115844);
        return 0;
      case 2: 
        localbfg.DCr = locala.KhF.fMu();
        AppMethodBeat.o(115844);
        return 0;
      case 3: 
        localbfg.DCs = locala.KhF.fMu();
        AppMethodBeat.o(115844);
        return 0;
      }
      localbfg.DCt = locala.KhF.fMu();
      AppMethodBeat.o(115844);
      return 0;
    }
    AppMethodBeat.o(115844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfg
 * JD-Core Version:    0.7.0.1
 */