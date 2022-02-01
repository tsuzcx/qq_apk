package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eol
  extends com.tencent.mm.bx.a
{
  public String absO;
  public String appid;
  public String mdR;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91668);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.absO != null) {
        paramVarArgs.g(3, this.absO);
      }
      if (this.path != null) {
        paramVarArgs.g(4, this.path);
      }
      if (this.mdR != null) {
        paramVarArgs.g(5, this.mdR);
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.absO != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.absO);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.path);
      }
      i = paramInt;
      if (this.mdR != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.mdR);
      }
      AppMethodBeat.o(91668);
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
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eol localeol = (eol)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91668);
        return -1;
      case 1: 
        localeol.type = locala.ajGk.aar();
        AppMethodBeat.o(91668);
        return 0;
      case 2: 
        localeol.appid = locala.ajGk.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 3: 
        localeol.absO = locala.ajGk.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 4: 
        localeol.path = locala.ajGk.readString();
        AppMethodBeat.o(91668);
        return 0;
      }
      localeol.mdR = locala.ajGk.readString();
      AppMethodBeat.o(91668);
      return 0;
    }
    AppMethodBeat.o(91668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eol
 * JD-Core Version:    0.7.0.1
 */