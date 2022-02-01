package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvb
  extends com.tencent.mm.bx.a
{
  public String desc;
  public int id;
  public String nickname;
  public String rHi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152630);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.rHi != null) {
        paramVarArgs.g(3, this.rHi);
      }
      if (this.desc != null) {
        paramVarArgs.g(4, this.desc);
      }
      AppMethodBeat.o(152630);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.id) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.rHi != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.rHi);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.desc);
      }
      AppMethodBeat.o(152630);
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
      AppMethodBeat.o(152630);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dvb localdvb = (dvb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152630);
        return -1;
      case 1: 
        localdvb.id = locala.ajGk.aar();
        AppMethodBeat.o(152630);
        return 0;
      case 2: 
        localdvb.nickname = locala.ajGk.readString();
        AppMethodBeat.o(152630);
        return 0;
      case 3: 
        localdvb.rHi = locala.ajGk.readString();
        AppMethodBeat.o(152630);
        return 0;
      }
      localdvb.desc = locala.ajGk.readString();
      AppMethodBeat.o(152630);
      return 0;
    }
    AppMethodBeat.o(152630);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvb
 * JD-Core Version:    0.7.0.1
 */