package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FinderJsApiMediaThumbInfo
  extends com.tencent.mm.cd.a
{
  public int thumbHeight;
  public String thumbPath;
  public int thumbWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169001);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.thumbWidth);
      paramVarArgs.aY(2, this.thumbHeight);
      if (this.thumbPath != null) {
        paramVarArgs.f(3, this.thumbPath);
      }
      AppMethodBeat.o(169001);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.thumbWidth) + 0 + g.a.a.b.b.a.bM(2, this.thumbHeight);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.thumbPath);
      }
      AppMethodBeat.o(169001);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169001);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      FinderJsApiMediaThumbInfo localFinderJsApiMediaThumbInfo = (FinderJsApiMediaThumbInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169001);
        return -1;
      case 1: 
        localFinderJsApiMediaThumbInfo.thumbWidth = locala.abFh.AK();
        AppMethodBeat.o(169001);
        return 0;
      case 2: 
        localFinderJsApiMediaThumbInfo.thumbHeight = locala.abFh.AK();
        AppMethodBeat.o(169001);
        return 0;
      }
      localFinderJsApiMediaThumbInfo.thumbPath = locala.abFh.readString();
      AppMethodBeat.o(169001);
      return 0;
    }
    AppMethodBeat.o(169001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderJsApiMediaThumbInfo
 * JD-Core Version:    0.7.0.1
 */