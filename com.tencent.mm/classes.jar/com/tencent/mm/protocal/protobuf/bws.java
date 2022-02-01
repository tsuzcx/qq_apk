package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bws
  extends com.tencent.mm.bx.a
{
  public String config;
  public int expt_id;
  public int hit;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258571);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.hit);
      if (this.config != null) {
        paramVarArgs.g(2, this.config);
      }
      paramVarArgs.bS(3, this.expt_id);
      AppMethodBeat.o(258571);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.hit) + 0;
      paramInt = i;
      if (this.config != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.config);
      }
      i = i.a.a.b.b.a.cJ(3, this.expt_id);
      AppMethodBeat.o(258571);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258571);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bws localbws = (bws)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258571);
        return -1;
      case 1: 
        localbws.hit = locala.ajGk.aar();
        AppMethodBeat.o(258571);
        return 0;
      case 2: 
        localbws.config = locala.ajGk.readString();
        AppMethodBeat.o(258571);
        return 0;
      }
      localbws.expt_id = locala.ajGk.aar();
      AppMethodBeat.o(258571);
      return 0;
    }
    AppMethodBeat.o(258571);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bws
 * JD-Core Version:    0.7.0.1
 */