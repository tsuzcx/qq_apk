package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class biy
  extends com.tencent.mm.bw.a
{
  public int EXM;
  public com.tencent.mm.bw.b EXN;
  public com.tencent.mm.bw.b EXO;
  public com.tencent.mm.bw.b EXP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EXN == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.EXO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.EXM);
      if (this.EXN != null) {
        paramVarArgs.c(2, this.EXN);
      }
      if (this.EXO != null) {
        paramVarArgs.c(3, this.EXO);
      }
      if (this.EXP != null) {
        paramVarArgs.c(4, this.EXP);
      }
      AppMethodBeat.o(115844);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.EXM) + 0;
      paramInt = i;
      if (this.EXN != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.EXN);
      }
      i = paramInt;
      if (this.EXO != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.EXO);
      }
      paramInt = i;
      if (this.EXP != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.EXP);
      }
      AppMethodBeat.o(115844);
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
      if (this.EXN == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(115844);
        throw paramVarArgs;
      }
      if (this.EXO == null)
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
      biy localbiy = (biy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115844);
        return -1;
      case 1: 
        localbiy.EXM = locala.LVo.xF();
        AppMethodBeat.o(115844);
        return 0;
      case 2: 
        localbiy.EXN = locala.LVo.gfk();
        AppMethodBeat.o(115844);
        return 0;
      case 3: 
        localbiy.EXO = locala.LVo.gfk();
        AppMethodBeat.o(115844);
        return 0;
      }
      localbiy.EXP = locala.LVo.gfk();
      AppMethodBeat.o(115844);
      return 0;
    }
    AppMethodBeat.o(115844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biy
 * JD-Core Version:    0.7.0.1
 */