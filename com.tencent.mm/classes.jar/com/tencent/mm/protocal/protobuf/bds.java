package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bds
  extends com.tencent.mm.bx.a
{
  public int ZOf;
  public int ZOu;
  public int ZOw;
  public String ZlX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258941);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZOf);
      paramVarArgs.bS(102, this.ZOu);
      if (this.ZlX != null) {
        paramVarArgs.g(103, this.ZlX);
      }
      paramVarArgs.bS(104, this.ZOw);
      AppMethodBeat.o(258941);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZOf) + 0 + i.a.a.b.b.a.cJ(102, this.ZOu);
      paramInt = i;
      if (this.ZlX != null) {
        paramInt = i + i.a.a.b.b.a.h(103, this.ZlX);
      }
      i = i.a.a.b.b.a.cJ(104, this.ZOw);
      AppMethodBeat.o(258941);
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
      AppMethodBeat.o(258941);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bds localbds = (bds)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258941);
        return -1;
      case 1: 
        localbds.ZOf = locala.ajGk.aar();
        AppMethodBeat.o(258941);
        return 0;
      case 102: 
        localbds.ZOu = locala.ajGk.aar();
        AppMethodBeat.o(258941);
        return 0;
      case 103: 
        localbds.ZlX = locala.ajGk.readString();
        AppMethodBeat.o(258941);
        return 0;
      }
      localbds.ZOw = locala.ajGk.aar();
      AppMethodBeat.o(258941);
      return 0;
    }
    AppMethodBeat.o(258941);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bds
 * JD-Core Version:    0.7.0.1
 */