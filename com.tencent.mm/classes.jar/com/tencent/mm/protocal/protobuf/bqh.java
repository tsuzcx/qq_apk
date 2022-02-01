package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqh
  extends com.tencent.mm.bx.a
{
  public int ZLh;
  public String hHa;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257686);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZLh);
      if (this.hHa != null) {
        paramVarArgs.g(2, this.hHa);
      }
      if (this.sessionId != null) {
        paramVarArgs.g(3, this.sessionId);
      }
      AppMethodBeat.o(257686);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZLh) + 0;
      paramInt = i;
      if (this.hHa != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hHa);
      }
      i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.sessionId);
      }
      AppMethodBeat.o(257686);
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
      AppMethodBeat.o(257686);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bqh localbqh = (bqh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257686);
        return -1;
      case 1: 
        localbqh.ZLh = locala.ajGk.aar();
        AppMethodBeat.o(257686);
        return 0;
      case 2: 
        localbqh.hHa = locala.ajGk.readString();
        AppMethodBeat.o(257686);
        return 0;
      }
      localbqh.sessionId = locala.ajGk.readString();
      AppMethodBeat.o(257686);
      return 0;
    }
    AppMethodBeat.o(257686);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqh
 * JD-Core Version:    0.7.0.1
 */