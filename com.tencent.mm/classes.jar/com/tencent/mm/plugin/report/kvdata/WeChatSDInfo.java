package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class WeChatSDInfo
  extends com.tencent.mm.cd.a
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
      paramVarArgs.bm(1, this.totalSize_);
      paramVarArgs.bm(2, this.dirCount_);
      paramVarArgs.bm(3, this.fileCount_);
      paramVarArgs.bm(4, this.fileLenInvalidCount_);
      paramVarArgs.aY(5, this.subDirResultsSize_);
      paramVarArgs.bm(6, this.totalTime_);
      paramVarArgs.aY(7, this.depth_);
      paramVarArgs.bm(8, this.tempAccTotalSize_);
      paramVarArgs.aY(9, this.tempAccDirResultsSize_);
      paramVarArgs.bm(10, this.tempAccDirCount_);
      paramVarArgs.bm(11, this.tempAccFileCount_);
      paramVarArgs.bm(12, this.tempAccFileLenInvalidCount_);
      paramVarArgs.e(13, 8, this.subDirList_);
      AppMethodBeat.o(151543);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.totalSize_);
      i = g.a.a.b.b.a.p(2, this.dirCount_);
      int j = g.a.a.b.b.a.p(3, this.fileCount_);
      int k = g.a.a.b.b.a.p(4, this.fileLenInvalidCount_);
      int m = g.a.a.b.b.a.bM(5, this.subDirResultsSize_);
      int n = g.a.a.b.b.a.p(6, this.totalTime_);
      int i1 = g.a.a.b.b.a.bM(7, this.depth_);
      int i2 = g.a.a.b.b.a.p(8, this.tempAccTotalSize_);
      int i3 = g.a.a.b.b.a.bM(9, this.tempAccDirResultsSize_);
      int i4 = g.a.a.b.b.a.p(10, this.tempAccDirCount_);
      int i5 = g.a.a.b.b.a.p(11, this.tempAccFileCount_);
      int i6 = g.a.a.b.b.a.p(12, this.tempAccFileLenInvalidCount_);
      int i7 = g.a.a.a.c(13, 8, this.subDirList_);
      AppMethodBeat.o(151543);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.subDirList_.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(151543);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      WeChatSDInfo localWeChatSDInfo = (WeChatSDInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151543);
        return -1;
      case 1: 
        localWeChatSDInfo.totalSize_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151543);
        return 0;
      case 2: 
        localWeChatSDInfo.dirCount_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151543);
        return 0;
      case 3: 
        localWeChatSDInfo.fileCount_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151543);
        return 0;
      case 4: 
        localWeChatSDInfo.fileLenInvalidCount_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151543);
        return 0;
      case 5: 
        localWeChatSDInfo.subDirResultsSize_ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(151543);
        return 0;
      case 6: 
        localWeChatSDInfo.totalTime_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151543);
        return 0;
      case 7: 
        localWeChatSDInfo.depth_ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(151543);
        return 0;
      case 8: 
        localWeChatSDInfo.tempAccTotalSize_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151543);
        return 0;
      case 9: 
        localWeChatSDInfo.tempAccDirResultsSize_ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(151543);
        return 0;
      case 10: 
        localWeChatSDInfo.tempAccDirCount_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151543);
        return 0;
      case 11: 
        localWeChatSDInfo.tempAccFileCount_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151543);
        return 0;
      case 12: 
        localWeChatSDInfo.tempAccFileLenInvalidCount_ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(151543);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        SubDirInfo localSubDirInfo = new SubDirInfo();
        if ((localObject != null) && (localObject.length > 0)) {
          localSubDirInfo.parseFrom((byte[])localObject);
        }
        localWeChatSDInfo.subDirList_.add(localSubDirInfo);
        paramInt += 1;
      }
      AppMethodBeat.o(151543);
      return 0;
    }
    AppMethodBeat.o(151543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.WeChatSDInfo
 * JD-Core Version:    0.7.0.1
 */