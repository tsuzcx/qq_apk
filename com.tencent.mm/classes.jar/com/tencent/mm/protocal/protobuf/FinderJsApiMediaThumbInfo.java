package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FinderJsApiMediaThumbInfo
  extends com.tencent.mm.bx.a
{
  public int thumbHeight;
  public String thumbPath;
  public int thumbWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169001);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.thumbWidth);
      paramVarArgs.bS(2, this.thumbHeight);
      if (this.thumbPath != null) {
        paramVarArgs.g(3, this.thumbPath);
      }
      AppMethodBeat.o(169001);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.thumbWidth) + 0 + i.a.a.b.b.a.cJ(2, this.thumbHeight);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.thumbPath);
      }
      AppMethodBeat.o(169001);
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
      AppMethodBeat.o(169001);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      FinderJsApiMediaThumbInfo localFinderJsApiMediaThumbInfo = (FinderJsApiMediaThumbInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169001);
        return -1;
      case 1: 
        localFinderJsApiMediaThumbInfo.thumbWidth = locala.ajGk.aar();
        AppMethodBeat.o(169001);
        return 0;
      case 2: 
        localFinderJsApiMediaThumbInfo.thumbHeight = locala.ajGk.aar();
        AppMethodBeat.o(169001);
        return 0;
      }
      localFinderJsApiMediaThumbInfo.thumbPath = locala.ajGk.readString();
      AppMethodBeat.o(169001);
      return 0;
    }
    AppMethodBeat.o(169001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderJsApiMediaThumbInfo
 * JD-Core Version:    0.7.0.1
 */