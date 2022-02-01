package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SubDirInfo
  extends com.tencent.mm.bx.a
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.tag_);
      paramVarArgs.bv(2, this.totalSize_);
      paramVarArgs.bv(3, this.dirCount_);
      paramVarArgs.bv(4, this.fileCount_);
      paramVarArgs.bv(5, this.fileLenInvalidCount);
      AppMethodBeat.o(151539);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.tag_);
      int i = i.a.a.b.b.a.q(2, this.totalSize_);
      int j = i.a.a.b.b.a.q(3, this.dirCount_);
      int k = i.a.a.b.b.a.q(4, this.fileCount_);
      int m = i.a.a.b.b.a.q(5, this.fileLenInvalidCount);
      AppMethodBeat.o(151539);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(151539);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      SubDirInfo localSubDirInfo = (SubDirInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151539);
        return -1;
      case 1: 
        localSubDirInfo.tag_ = locala.ajGk.aar();
        AppMethodBeat.o(151539);
        return 0;
      case 2: 
        localSubDirInfo.totalSize_ = locala.ajGk.aaw();
        AppMethodBeat.o(151539);
        return 0;
      case 3: 
        localSubDirInfo.dirCount_ = locala.ajGk.aaw();
        AppMethodBeat.o(151539);
        return 0;
      case 4: 
        localSubDirInfo.fileCount_ = locala.ajGk.aaw();
        AppMethodBeat.o(151539);
        return 0;
      }
      localSubDirInfo.fileLenInvalidCount = locala.ajGk.aaw();
      AppMethodBeat.o(151539);
      return 0;
    }
    AppMethodBeat.o(151539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.SubDirInfo
 * JD-Core Version:    0.7.0.1
 */