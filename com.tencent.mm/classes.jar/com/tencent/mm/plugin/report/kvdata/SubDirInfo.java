package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SubDirInfo
  extends com.tencent.mm.bv.a
{
  public long dirCount_;
  public long fileCount_;
  public long fileLenInvalidCount;
  public int tag_;
  public long totalSize_;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79153);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.tag_);
      paramVarArgs.am(2, this.totalSize_);
      paramVarArgs.am(3, this.dirCount_);
      paramVarArgs.am(4, this.fileCount_);
      paramVarArgs.am(5, this.fileLenInvalidCount);
      AppMethodBeat.o(79153);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.tag_);
      int i = e.a.a.b.b.a.p(2, this.totalSize_);
      int j = e.a.a.b.b.a.p(3, this.dirCount_);
      int k = e.a.a.b.b.a.p(4, this.fileCount_);
      int m = e.a.a.b.b.a.p(5, this.fileLenInvalidCount);
      AppMethodBeat.o(79153);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(79153);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      SubDirInfo localSubDirInfo = (SubDirInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(79153);
        return -1;
      case 1: 
        localSubDirInfo.tag_ = locala.CLY.sl();
        AppMethodBeat.o(79153);
        return 0;
      case 2: 
        localSubDirInfo.totalSize_ = locala.CLY.sm();
        AppMethodBeat.o(79153);
        return 0;
      case 3: 
        localSubDirInfo.dirCount_ = locala.CLY.sm();
        AppMethodBeat.o(79153);
        return 0;
      case 4: 
        localSubDirInfo.fileCount_ = locala.CLY.sm();
        AppMethodBeat.o(79153);
        return 0;
      }
      localSubDirInfo.fileLenInvalidCount = locala.CLY.sm();
      AppMethodBeat.o(79153);
      return 0;
    }
    AppMethodBeat.o(79153);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.SubDirInfo
 * JD-Core Version:    0.7.0.1
 */