package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dik
  extends com.tencent.mm.bx.a
{
  public String md5;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260173);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.g(3, this.md5);
      }
      AppMethodBeat.o(260173);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.md5);
      }
      AppMethodBeat.o(260173);
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
      AppMethodBeat.o(260173);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dik localdik = (dik)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260173);
        return -1;
      case 1: 
        localdik.type = locala.ajGk.aar();
        AppMethodBeat.o(260173);
        return 0;
      case 2: 
        localdik.url = locala.ajGk.readString();
        AppMethodBeat.o(260173);
        return 0;
      }
      localdik.md5 = locala.ajGk.readString();
      AppMethodBeat.o(260173);
      return 0;
    }
    AppMethodBeat.o(260173);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dik
 * JD-Core Version:    0.7.0.1
 */