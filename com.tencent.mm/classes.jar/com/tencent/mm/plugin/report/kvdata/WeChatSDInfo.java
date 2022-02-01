package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class WeChatSDInfo
  extends com.tencent.mm.bw.a
{
  public int depth_;
  public long dirCount_;
  public long fileCount_;
  public long fileLenInvalidCount_;
  public LinkedList<SubDirInfo> subDirList_;
  public int subDirResultsSize_;
  public long tempAccDirCount_;
  public int tempAccDirResultsSize_;
  public long tempAccFileCount_;
  public long tempAccFileLenInvalidCount_;
  public long tempAccTotalSize_;
  public long totalSize_;
  public long totalTime_;
  
  public WeChatSDInfo()
  {
    AppMethodBeat.i(151542);
    this.subDirList_ = new LinkedList();
    AppMethodBeat.o(151542);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151543);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.totalSize_);
      paramVarArgs.bb(2, this.dirCount_);
      paramVarArgs.bb(3, this.fileCount_);
      paramVarArgs.bb(4, this.fileLenInvalidCount_);
      paramVarArgs.aM(5, this.subDirResultsSize_);
      paramVarArgs.bb(6, this.totalTime_);
      paramVarArgs.aM(7, this.depth_);
      paramVarArgs.bb(8, this.tempAccTotalSize_);
      paramVarArgs.aM(9, this.tempAccDirResultsSize_);
      paramVarArgs.bb(10, this.tempAccDirCount_);
      paramVarArgs.bb(11, this.tempAccFileCount_);
      paramVarArgs.bb(12, this.tempAccFileLenInvalidCount_);
      paramVarArgs.e(13, 8, this.subDirList_);
      AppMethodBeat.o(151543);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.totalSize_);
      i = g.a.a.b.b.a.r(2, this.dirCount_);
      int j = g.a.a.b.b.a.r(3, this.fileCount_);
      int k = g.a.a.b.b.a.r(4, this.fileLenInvalidCount_);
      int m = g.a.a.b.b.a.bu(5, this.subDirResultsSize_);
      int n = g.a.a.b.b.a.r(6, this.totalTime_);
      int i1 = g.a.a.b.b.a.bu(7, this.depth_);
      int i2 = g.a.a.b.b.a.r(8, this.tempAccTotalSize_);
      int i3 = g.a.a.b.b.a.bu(9, this.tempAccDirResultsSize_);
      int i4 = g.a.a.b.b.a.r(10, this.tempAccDirCount_);
      int i5 = g.a.a.b.b.a.r(11, this.tempAccFileCount_);
      int i6 = g.a.a.b.b.a.r(12, this.tempAccFileLenInvalidCount_);
      int i7 = g.a.a.a.c(13, 8, this.subDirList_);
      AppMethodBeat.o(151543);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.subDirList_.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(151543);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      WeChatSDInfo localWeChatSDInfo = (WeChatSDInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151543);
        return -1;
      case 1: 
        localWeChatSDInfo.totalSize_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151543);
        return 0;
      case 2: 
        localWeChatSDInfo.dirCount_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151543);
        return 0;
      case 3: 
        localWeChatSDInfo.fileCount_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151543);
        return 0;
      case 4: 
        localWeChatSDInfo.fileLenInvalidCount_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151543);
        return 0;
      case 5: 
        localWeChatSDInfo.subDirResultsSize_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151543);
        return 0;
      case 6: 
        localWeChatSDInfo.totalTime_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151543);
        return 0;
      case 7: 
        localWeChatSDInfo.depth_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151543);
        return 0;
      case 8: 
        localWeChatSDInfo.tempAccTotalSize_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151543);
        return 0;
      case 9: 
        localWeChatSDInfo.tempAccDirResultsSize_ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(151543);
        return 0;
      case 10: 
        localWeChatSDInfo.tempAccDirCount_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151543);
        return 0;
      case 11: 
        localWeChatSDInfo.tempAccFileCount_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151543);
        return 0;
      case 12: 
        localWeChatSDInfo.tempAccFileLenInvalidCount_ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(151543);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SubDirInfo();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SubDirInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localWeChatSDInfo.subDirList_.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(151543);
      return 0;
    }
    AppMethodBeat.o(151543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.WeChatSDInfo
 * JD-Core Version:    0.7.0.1
 */