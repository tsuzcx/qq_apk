package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FinderMediaReportInfo
  extends com.tencent.mm.bx.a
{
  public int fileSize;
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
      paramVarArgs.aR(1, this.videoDuration);
      paramVarArgs.aR(2, this.videoBitrate);
      paramVarArgs.aR(3, this.width);
      paramVarArgs.aR(4, this.height);
      paramVarArgs.aR(5, this.fileSize);
      AppMethodBeat.o(169007);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.videoDuration);
      int i = f.a.a.b.b.a.bA(2, this.videoBitrate);
      int j = f.a.a.b.b.a.bA(3, this.width);
      int k = f.a.a.b.b.a.bA(4, this.height);
      int m = f.a.a.b.b.a.bA(5, this.fileSize);
      AppMethodBeat.o(169007);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localFinderMediaReportInfo.videoDuration = locala.KhF.xS();
        AppMethodBeat.o(169007);
        return 0;
      case 2: 
        localFinderMediaReportInfo.videoBitrate = locala.KhF.xS();
        AppMethodBeat.o(169007);
        return 0;
      case 3: 
        localFinderMediaReportInfo.width = locala.KhF.xS();
        AppMethodBeat.o(169007);
        return 0;
      case 4: 
        localFinderMediaReportInfo.height = locala.KhF.xS();
        AppMethodBeat.o(169007);
        return 0;
      }
      localFinderMediaReportInfo.fileSize = locala.KhF.xS();
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