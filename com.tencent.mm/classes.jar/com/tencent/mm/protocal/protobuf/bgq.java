package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgq
  extends com.tencent.mm.bx.a
{
  public String ZQe;
  public String jumpUrl;
  public String title;
  public int type;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257966);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.jumpUrl != null) {
        paramVarArgs.g(4, this.jumpUrl);
      }
      if (this.ZQe != null) {
        paramVarArgs.g(5, this.ZQe);
      }
      AppMethodBeat.o(257966);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.title);
      }
      paramInt = i;
      if (this.jumpUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.jumpUrl);
      }
      i = paramInt;
      if (this.ZQe != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZQe);
      }
      AppMethodBeat.o(257966);
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
      AppMethodBeat.o(257966);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bgq localbgq = (bgq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257966);
        return -1;
      case 1: 
        localbgq.type = locala.ajGk.aar();
        AppMethodBeat.o(257966);
        return 0;
      case 2: 
        localbgq.wording = locala.ajGk.readString();
        AppMethodBeat.o(257966);
        return 0;
      case 3: 
        localbgq.title = locala.ajGk.readString();
        AppMethodBeat.o(257966);
        return 0;
      case 4: 
        localbgq.jumpUrl = locala.ajGk.readString();
        AppMethodBeat.o(257966);
        return 0;
      }
      localbgq.ZQe = locala.ajGk.readString();
      AppMethodBeat.o(257966);
      return 0;
    }
    AppMethodBeat.o(257966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgq
 * JD-Core Version:    0.7.0.1
 */