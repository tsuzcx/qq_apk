package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class glm
  extends com.tencent.mm.bx.a
{
  public int ZSe;
  public String acgY;
  public String report_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257530);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZSe);
      if (this.acgY != null) {
        paramVarArgs.g(2, this.acgY);
      }
      if (this.report_info != null) {
        paramVarArgs.g(3, this.report_info);
      }
      AppMethodBeat.o(257530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZSe) + 0;
      paramInt = i;
      if (this.acgY != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.acgY);
      }
      i = paramInt;
      if (this.report_info != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.report_info);
      }
      AppMethodBeat.o(257530);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257530);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      glm localglm = (glm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257530);
        return -1;
      case 1: 
        localglm.ZSe = locala.ajGk.aar();
        AppMethodBeat.o(257530);
        return 0;
      case 2: 
        localglm.acgY = locala.ajGk.readString();
        AppMethodBeat.o(257530);
        return 0;
      }
      localglm.report_info = locala.ajGk.readString();
      AppMethodBeat.o(257530);
      return 0;
    }
    AppMethodBeat.o(257530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glm
 * JD-Core Version:    0.7.0.1
 */