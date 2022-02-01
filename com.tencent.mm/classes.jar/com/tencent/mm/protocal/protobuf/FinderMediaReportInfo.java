package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FinderMediaReportInfo
  extends com.tencent.mm.bw.a
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
      paramVarArgs.aM(1, this.videoDuration);
      paramVarArgs.aM(2, this.videoBitrate);
      paramVarArgs.aM(3, this.width);
      paramVarArgs.aM(4, this.height);
      paramVarArgs.aM(5, this.fileSize);
      paramVarArgs.aM(6, this.audioBitrate);
      paramVarArgs.aM(7, this.fps);
      AppMethodBeat.o(169007);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.videoDuration);
      int i = g.a.a.b.b.a.bu(2, this.videoBitrate);
      int j = g.a.a.b.b.a.bu(3, this.width);
      int k = g.a.a.b.b.a.bu(4, this.height);
      int m = g.a.a.b.b.a.bu(5, this.fileSize);
      int n = g.a.a.b.b.a.bu(6, this.audioBitrate);
      int i1 = g.a.a.b.b.a.bu(7, this.fps);
      AppMethodBeat.o(169007);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
        localFinderMediaReportInfo.videoDuration = locala.UbS.zi();
        AppMethodBeat.o(169007);
        return 0;
      case 2: 
        localFinderMediaReportInfo.videoBitrate = locala.UbS.zi();
        AppMethodBeat.o(169007);
        return 0;
      case 3: 
        localFinderMediaReportInfo.width = locala.UbS.zi();
        AppMethodBeat.o(169007);
        return 0;
      case 4: 
        localFinderMediaReportInfo.height = locala.UbS.zi();
        AppMethodBeat.o(169007);
        return 0;
      case 5: 
        localFinderMediaReportInfo.fileSize = locala.UbS.zi();
        AppMethodBeat.o(169007);
        return 0;
      case 6: 
        localFinderMediaReportInfo.audioBitrate = locala.UbS.zi();
        AppMethodBeat.o(169007);
        return 0;
      }
      localFinderMediaReportInfo.fps = locala.UbS.zi();
      AppMethodBeat.o(169007);
      return 0;
    }
    AppMethodBeat.o(169007);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMediaReportInfo
 * JD-Core Version:    0.7.0.1
 */