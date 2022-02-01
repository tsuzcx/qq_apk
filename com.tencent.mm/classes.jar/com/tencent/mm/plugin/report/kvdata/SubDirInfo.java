package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SubDirInfo
  extends com.tencent.mm.bw.a
{
  public long dirCount_;
  public long fileCount_;
  public long fileLenInvalidCount;
  public int tag_;
  public long totalSize_;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.tag_);
      paramVarArgs.bb(2, this.totalSize_);
      paramVarArgs.bb(3, this.dirCount_);
      paramVarArgs.bb(4, this.fileCount_);
      paramVarArgs.bb(5, this.fileLenInvalidCount);
      AppMethodBeat.o(151539);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.tag_);
      int i = g.a.a.b.b.a.r(2, this.totalSize_);
      int j = g.a.a.b.b.a.r(3, this.dirCount_);
      int k = g.a.a.b.b.a.r(4, this.fileCount_);
      int m = g.a.a.b.b.a.r(5, this.fileLenInvalidCount);
      AppMethodBeat.o(151539);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(151539);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      SubDirInfo localSubDirInfo = (SubDirInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151539);
        return -1;
      case 1: 
        localSubDirInfo.tag_ = locala.UbS.zi();
        AppMethodBeat.o(151539);
        return 0;
      case 2: 
        localSubDirInfo.totalSize_ = locala.UbS.zl();
        AppMethodBeat.o(151539);
        return 0;
      case 3: 
        localSubDirInfo.dirCount_ = locala.UbS.zl();
        AppMethodBeat.o(151539);
        return 0;
      case 4: 
        localSubDirInfo.fileCount_ = locala.UbS.zl();
        AppMethodBeat.o(151539);
        return 0;
      }
      localSubDirInfo.fileLenInvalidCount = locala.UbS.zl();
      AppMethodBeat.o(151539);
      return 0;
    }
    AppMethodBeat.o(151539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.SubDirInfo
 * JD-Core Version:    0.7.0.1
 */