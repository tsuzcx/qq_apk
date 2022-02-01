package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fkf
  extends com.tencent.mm.bx.a
{
  public String aaBg;
  public int aaMx;
  public String abLh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152708);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaMx);
      if (this.aaBg != null) {
        paramVarArgs.g(2, this.aaBg);
      }
      if (this.abLh != null) {
        paramVarArgs.g(3, this.abLh);
      }
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aaMx) + 0;
      paramInt = i;
      if (this.aaBg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaBg);
      }
      i = paramInt;
      if (this.abLh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abLh);
      }
      AppMethodBeat.o(152708);
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
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fkf localfkf = (fkf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152708);
        return -1;
      case 1: 
        localfkf.aaMx = locala.ajGk.aar();
        AppMethodBeat.o(152708);
        return 0;
      case 2: 
        localfkf.aaBg = locala.ajGk.readString();
        AppMethodBeat.o(152708);
        return 0;
      }
      localfkf.abLh = locala.ajGk.readString();
      AppMethodBeat.o(152708);
      return 0;
    }
    AppMethodBeat.o(152708);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkf
 * JD-Core Version:    0.7.0.1
 */