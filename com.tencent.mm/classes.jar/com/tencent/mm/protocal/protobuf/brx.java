package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class brx
  extends com.tencent.mm.bx.a
{
  public String Rfi;
  public String ZZV;
  public int businessType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260243);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.businessType);
      if (this.Rfi != null) {
        paramVarArgs.g(2, this.Rfi);
      }
      if (this.ZZV != null) {
        paramVarArgs.g(3, this.ZZV);
      }
      AppMethodBeat.o(260243);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.businessType) + 0;
      paramInt = i;
      if (this.Rfi != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Rfi);
      }
      i = paramInt;
      if (this.ZZV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZZV);
      }
      AppMethodBeat.o(260243);
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
      AppMethodBeat.o(260243);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      brx localbrx = (brx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260243);
        return -1;
      case 1: 
        localbrx.businessType = locala.ajGk.aar();
        AppMethodBeat.o(260243);
        return 0;
      case 2: 
        localbrx.Rfi = locala.ajGk.readString();
        AppMethodBeat.o(260243);
        return 0;
      }
      localbrx.ZZV = locala.ajGk.readString();
      AppMethodBeat.o(260243);
      return 0;
    }
    AppMethodBeat.o(260243);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brx
 * JD-Core Version:    0.7.0.1
 */