package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FinderMediaReportInfo
  extends com.tencent.mm.cd.a
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.videoDuration);
      paramVarArgs.aY(2, this.videoBitrate);
      paramVarArgs.aY(3, this.width);
      paramVarArgs.aY(4, this.height);
      paramVarArgs.aY(5, this.fileSize);
      paramVarArgs.aY(6, this.audioBitrate);
      paramVarArgs.aY(7, this.fps);
      AppMethodBeat.o(169007);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.videoDuration);
      int i = g.a.a.b.b.a.bM(2, this.videoBitrate);
      int j = g.a.a.b.b.a.bM(3, this.width);
      int k = g.a.a.b.b.a.bM(4, this.height);
      int m = g.a.a.b.b.a.bM(5, this.fileSize);
      int n = g.a.a.b.b.a.bM(6, this.audioBitrate);
      int i1 = g.a.a.b.b.a.bM(7, this.fps);
      AppMethodBeat.o(169007);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169007);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      FinderMediaReportInfo localFinderMediaReportInfo = (FinderMediaReportInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169007);
        return -1;
      case 1: 
        localFinderMediaReportInfo.videoDuration = locala.abFh.AK();
        AppMethodBeat.o(169007);
        return 0;
      case 2: 
        localFinderMediaReportInfo.videoBitrate = locala.abFh.AK();
        AppMethodBeat.o(169007);
        return 0;
      case 3: 
        localFinderMediaReportInfo.width = locala.abFh.AK();
        AppMethodBeat.o(169007);
        return 0;
      case 4: 
        localFinderMediaReportInfo.height = locala.abFh.AK();
        AppMethodBeat.o(169007);
        return 0;
      case 5: 
        localFinderMediaReportInfo.fileSize = locala.abFh.AK();
        AppMethodBeat.o(169007);
        return 0;
      case 6: 
        localFinderMediaReportInfo.audioBitrate = locala.abFh.AK();
        AppMethodBeat.o(169007);
        return 0;
      }
      localFinderMediaReportInfo.fps = locala.abFh.AK();
      AppMethodBeat.o(169007);
      return 0;
    }
    AppMethodBeat.o(169007);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMediaReportInfo
 * JD-Core Version:    0.7.0.1
 */