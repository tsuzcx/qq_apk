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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.videoDuration);
      paramVarArgs.aS(2, this.videoBitrate);
      paramVarArgs.aS(3, this.width);
      paramVarArgs.aS(4, this.height);
      paramVarArgs.aS(5, this.fileSize);
      paramVarArgs.aS(6, this.audioBitrate);
      paramVarArgs.aS(7, this.fps);
      AppMethodBeat.o(169007);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.videoDuration);
      int i = f.a.a.b.b.a.bz(2, this.videoBitrate);
      int j = f.a.a.b.b.a.bz(3, this.width);
      int k = f.a.a.b.b.a.bz(4, this.height);
      int m = f.a.a.b.b.a.bz(5, this.fileSize);
      int n = f.a.a.b.b.a.bz(6, this.audioBitrate);
      int i1 = f.a.a.b.b.a.bz(7, this.fps);
      AppMethodBeat.o(169007);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(169007);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      FinderMediaReportInfo localFinderMediaReportInfo = (FinderMediaReportInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169007);
        return -1;
      case 1: 
        localFinderMediaReportInfo.videoDuration = locala.OmT.zc();
        AppMethodBeat.o(169007);
        return 0;
      case 2: 
        localFinderMediaReportInfo.videoBitrate = locala.OmT.zc();
        AppMethodBeat.o(169007);
        return 0;
      case 3: 
        localFinderMediaReportInfo.width = locala.OmT.zc();
        AppMethodBeat.o(169007);
        return 0;
      case 4: 
        localFinderMediaReportInfo.height = locala.OmT.zc();
        AppMethodBeat.o(169007);
        return 0;
      case 5: 
        localFinderMediaReportInfo.fileSize = locala.OmT.zc();
        AppMethodBeat.o(169007);
        return 0;
      case 6: 
        localFinderMediaReportInfo.audioBitrate = locala.OmT.zc();
        AppMethodBeat.o(169007);
        return 0;
      }
      localFinderMediaReportInfo.fps = locala.OmT.zc();
      AppMethodBeat.o(169007);
      return 0;
    }
    AppMethodBeat.o(169007);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMediaReportInfo
 * JD-Core Version:    0.7.0.1
 */