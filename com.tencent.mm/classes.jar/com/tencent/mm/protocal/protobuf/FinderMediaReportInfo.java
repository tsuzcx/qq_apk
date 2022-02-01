package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FinderMediaReportInfo
  extends com.tencent.mm.bx.a
{
  public int audioBitrate;
  public int fileSize;
  public int fps;
  public int height;
  public int videoBitrate;
  public int videoDuration;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169007);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.videoDuration);
      paramVarArgs.bS(2, this.videoBitrate);
      paramVarArgs.bS(3, this.width);
      paramVarArgs.bS(4, this.height);
      paramVarArgs.bS(5, this.fileSize);
      paramVarArgs.bS(6, this.audioBitrate);
      paramVarArgs.bS(7, this.fps);
      AppMethodBeat.o(169007);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.videoDuration);
      int i = i.a.a.b.b.a.cJ(2, this.videoBitrate);
      int j = i.a.a.b.b.a.cJ(3, this.width);
      int k = i.a.a.b.b.a.cJ(4, this.height);
      int m = i.a.a.b.b.a.cJ(5, this.fileSize);
      int n = i.a.a.b.b.a.cJ(6, this.audioBitrate);
      int i1 = i.a.a.b.b.a.cJ(7, this.fps);
      AppMethodBeat.o(169007);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169007);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      FinderMediaReportInfo localFinderMediaReportInfo = (FinderMediaReportInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169007);
        return -1;
      case 1: 
        localFinderMediaReportInfo.videoDuration = locala.ajGk.aar();
        AppMethodBeat.o(169007);
        return 0;
      case 2: 
        localFinderMediaReportInfo.videoBitrate = locala.ajGk.aar();
        AppMethodBeat.o(169007);
        return 0;
      case 3: 
        localFinderMediaReportInfo.width = locala.ajGk.aar();
        AppMethodBeat.o(169007);
        return 0;
      case 4: 
        localFinderMediaReportInfo.height = locala.ajGk.aar();
        AppMethodBeat.o(169007);
        return 0;
      case 5: 
        localFinderMediaReportInfo.fileSize = locala.ajGk.aar();
        AppMethodBeat.o(169007);
        return 0;
      case 6: 
        localFinderMediaReportInfo.audioBitrate = locala.ajGk.aar();
        AppMethodBeat.o(169007);
        return 0;
      }
      localFinderMediaReportInfo.fps = locala.ajGk.aar();
      AppMethodBeat.o(169007);
      return 0;
    }
    AppMethodBeat.o(169007);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMediaReportInfo
 * JD-Core Version:    0.7.0.1
 */