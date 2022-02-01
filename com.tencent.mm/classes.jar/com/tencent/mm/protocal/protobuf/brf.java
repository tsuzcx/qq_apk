package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class brf
  extends com.tencent.mm.bx.a
{
  public String ZZk;
  public int name;
  public String text;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257468);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.name);
      paramVarArgs.bS(2, this.type);
      if (this.text != null) {
        paramVarArgs.g(3, this.text);
      }
      if (this.ZZk != null) {
        paramVarArgs.g(4, this.ZZk);
      }
      AppMethodBeat.o(257468);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.name) + 0 + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.text);
      }
      i = paramInt;
      if (this.ZZk != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZZk);
      }
      AppMethodBeat.o(257468);
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
      AppMethodBeat.o(257468);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      brf localbrf = (brf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257468);
        return -1;
      case 1: 
        localbrf.name = locala.ajGk.aar();
        AppMethodBeat.o(257468);
        return 0;
      case 2: 
        localbrf.type = locala.ajGk.aar();
        AppMethodBeat.o(257468);
        return 0;
      case 3: 
        localbrf.text = locala.ajGk.readString();
        AppMethodBeat.o(257468);
        return 0;
      }
      localbrf.ZZk = locala.ajGk.readString();
      AppMethodBeat.o(257468);
      return 0;
    }
    AppMethodBeat.o(257468);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brf
 * JD-Core Version:    0.7.0.1
 */