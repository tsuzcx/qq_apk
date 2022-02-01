package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class epb
  extends com.tencent.mm.bx.a
{
  public int abtl;
  public String abtm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259293);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abtl);
      if (this.abtm != null) {
        paramVarArgs.g(2, this.abtm);
      }
      AppMethodBeat.o(259293);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abtl) + 0;
      paramInt = i;
      if (this.abtm != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abtm);
      }
      AppMethodBeat.o(259293);
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
      AppMethodBeat.o(259293);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      epb localepb = (epb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259293);
        return -1;
      case 1: 
        localepb.abtl = locala.ajGk.aar();
        AppMethodBeat.o(259293);
        return 0;
      }
      localepb.abtm = locala.ajGk.readString();
      AppMethodBeat.o(259293);
      return 0;
    }
    AppMethodBeat.o(259293);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epb
 * JD-Core Version:    0.7.0.1
 */