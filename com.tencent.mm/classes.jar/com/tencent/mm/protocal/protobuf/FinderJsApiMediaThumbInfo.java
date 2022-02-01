package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FinderJsApiMediaThumbInfo
  extends com.tencent.mm.bw.a
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
      paramVarArgs.aM(1, this.thumbWidth);
      paramVarArgs.aM(2, this.thumbHeight);
      if (this.thumbPath != null) {
        paramVarArgs.e(3, this.thumbPath);
      }
      AppMethodBeat.o(169001);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.thumbWidth) + 0 + g.a.a.b.b.a.bu(2, this.thumbHeight);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.thumbPath);
      }
      AppMethodBeat.o(169001);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
        localFinderJsApiMediaThumbInfo.thumbWidth = locala.UbS.zi();
        AppMethodBeat.o(169001);
        return 0;
      case 2: 
        localFinderJsApiMediaThumbInfo.thumbHeight = locala.UbS.zi();
        AppMethodBeat.o(169001);
        return 0;
      }
      localFinderJsApiMediaThumbInfo.thumbPath = locala.UbS.readString();
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