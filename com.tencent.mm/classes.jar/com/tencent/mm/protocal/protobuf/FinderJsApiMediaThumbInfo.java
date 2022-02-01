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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.thumbWidth);
      paramVarArgs.aR(2, this.thumbHeight);
      if (this.thumbPath != null) {
        paramVarArgs.d(3, this.thumbPath);
      }
      AppMethodBeat.o(169001);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.thumbWidth) + 0 + f.a.a.b.b.a.bx(2, this.thumbHeight);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.thumbPath);
      }
      AppMethodBeat.o(169001);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(169001);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      FinderJsApiMediaThumbInfo localFinderJsApiMediaThumbInfo = (FinderJsApiMediaThumbInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169001);
        return -1;
      case 1: 
        localFinderJsApiMediaThumbInfo.thumbWidth = locala.LVo.xF();
        AppMethodBeat.o(169001);
        return 0;
      case 2: 
        localFinderJsApiMediaThumbInfo.thumbHeight = locala.LVo.xF();
        AppMethodBeat.o(169001);
        return 0;
      }
      localFinderJsApiMediaThumbInfo.thumbPath = locala.LVo.readString();
      AppMethodBeat.o(169001);
      return 0;
    }
    AppMethodBeat.o(169001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderJsApiMediaThumbInfo
 * JD-Core Version:    0.7.0.1
 */