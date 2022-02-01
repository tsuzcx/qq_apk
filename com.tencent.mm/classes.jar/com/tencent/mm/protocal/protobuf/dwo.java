package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwo
  extends com.tencent.mm.bx.a
{
  public int YWY;
  public int ZkT;
  public int abcv;
  public String abcw;
  public String abcy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43114);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YWY);
      if (this.abcy != null) {
        paramVarArgs.g(3, this.abcy);
      }
      paramVarArgs.bS(4, this.abcv);
      paramVarArgs.bS(5, this.ZkT);
      if (this.abcw != null) {
        paramVarArgs.g(6, this.abcw);
      }
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YWY) + 0;
      paramInt = i;
      if (this.abcy != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abcy);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.abcv) + i.a.a.b.b.a.cJ(5, this.ZkT);
      paramInt = i;
      if (this.abcw != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abcw);
      }
      AppMethodBeat.o(43114);
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
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dwo localdwo = (dwo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(43114);
        return -1;
      case 1: 
        localdwo.YWY = locala.ajGk.aar();
        AppMethodBeat.o(43114);
        return 0;
      case 3: 
        localdwo.abcy = locala.ajGk.readString();
        AppMethodBeat.o(43114);
        return 0;
      case 4: 
        localdwo.abcv = locala.ajGk.aar();
        AppMethodBeat.o(43114);
        return 0;
      case 5: 
        localdwo.ZkT = locala.ajGk.aar();
        AppMethodBeat.o(43114);
        return 0;
      }
      localdwo.abcw = locala.ajGk.readString();
      AppMethodBeat.o(43114);
      return 0;
    }
    AppMethodBeat.o(43114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwo
 * JD-Core Version:    0.7.0.1
 */