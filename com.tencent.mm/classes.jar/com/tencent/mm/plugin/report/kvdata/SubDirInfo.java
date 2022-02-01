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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.tag_);
      paramVarArgs.aG(2, this.totalSize_);
      paramVarArgs.aG(3, this.dirCount_);
      paramVarArgs.aG(4, this.fileCount_);
      paramVarArgs.aG(5, this.fileLenInvalidCount);
      AppMethodBeat.o(151539);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.tag_);
      int i = f.a.a.b.b.a.q(2, this.totalSize_);
      int j = f.a.a.b.b.a.q(3, this.dirCount_);
      int k = f.a.a.b.b.a.q(4, this.fileCount_);
      int m = f.a.a.b.b.a.q(5, this.fileLenInvalidCount);
      AppMethodBeat.o(151539);
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
      AppMethodBeat.o(151539);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      SubDirInfo localSubDirInfo = (SubDirInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151539);
        return -1;
      case 1: 
        localSubDirInfo.tag_ = locala.KhF.xS();
        AppMethodBeat.o(151539);
        return 0;
      case 2: 
        localSubDirInfo.totalSize_ = locala.KhF.xT();
        AppMethodBeat.o(151539);
        return 0;
      case 3: 
        localSubDirInfo.dirCount_ = locala.KhF.xT();
        AppMethodBeat.o(151539);
        return 0;
      case 4: 
        localSubDirInfo.fileCount_ = locala.KhF.xT();
        AppMethodBeat.o(151539);
        return 0;
      }
      localSubDirInfo.fileLenInvalidCount = locala.KhF.xT();
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