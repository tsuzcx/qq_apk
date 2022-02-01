package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avf
  extends com.tencent.mm.bx.a
{
  public String ZFy;
  public int jump_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257623);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.jump_type);
      if (this.ZFy != null) {
        paramVarArgs.g(2, this.ZFy);
      }
      AppMethodBeat.o(257623);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.jump_type) + 0;
      paramInt = i;
      if (this.ZFy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZFy);
      }
      AppMethodBeat.o(257623);
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
      AppMethodBeat.o(257623);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      avf localavf = (avf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257623);
        return -1;
      case 1: 
        localavf.jump_type = locala.ajGk.aar();
        AppMethodBeat.o(257623);
        return 0;
      }
      localavf.ZFy = locala.ajGk.readString();
      AppMethodBeat.o(257623);
      return 0;
    }
    AppMethodBeat.o(257623);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avf
 * JD-Core Version:    0.7.0.1
 */