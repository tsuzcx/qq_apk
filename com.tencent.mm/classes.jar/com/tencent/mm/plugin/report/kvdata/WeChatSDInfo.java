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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.totalSize_);
      paramVarArgs.aO(2, this.dirCount_);
      paramVarArgs.aO(3, this.fileCount_);
      paramVarArgs.aO(4, this.fileLenInvalidCount_);
      paramVarArgs.aR(5, this.subDirResultsSize_);
      paramVarArgs.aO(6, this.totalTime_);
      paramVarArgs.aR(7, this.depth_);
      paramVarArgs.aO(8, this.tempAccTotalSize_);
      paramVarArgs.aR(9, this.tempAccDirResultsSize_);
      paramVarArgs.aO(10, this.tempAccDirCount_);
      paramVarArgs.aO(11, this.tempAccFileCount_);
      paramVarArgs.aO(12, this.tempAccFileLenInvalidCount_);
      paramVarArgs.e(13, 8, this.subDirList_);
      AppMethodBeat.o(151543);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.totalSize_);
      i = f.a.a.b.b.a.p(2, this.dirCount_);
      int j = f.a.a.b.b.a.p(3, this.fileCount_);
      int k = f.a.a.b.b.a.p(4, this.fileLenInvalidCount_);
      int m = f.a.a.b.b.a.bx(5, this.subDirResultsSize_);
      int n = f.a.a.b.b.a.p(6, this.totalTime_);
      int i1 = f.a.a.b.b.a.bx(7, this.depth_);
      int i2 = f.a.a.b.b.a.p(8, this.tempAccTotalSize_);
      int i3 = f.a.a.b.b.a.bx(9, this.tempAccDirResultsSize_);
      int i4 = f.a.a.b.b.a.p(10, this.tempAccDirCount_);
      int i5 = f.a.a.b.b.a.p(11, this.tempAccFileCount_);
      int i6 = f.a.a.b.b.a.p(12, this.tempAccFileLenInvalidCount_);
      int i7 = f.a.a.a.c(13, 8, this.subDirList_);
      AppMethodBeat.o(151543);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.subDirList_.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(151543);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      WeChatSDInfo localWeChatSDInfo = (WeChatSDInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151543);
        return -1;
      case 1: 
        localWeChatSDInfo.totalSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151543);
        return 0;
      case 2: 
        localWeChatSDInfo.dirCount_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151543);
        return 0;
      case 3: 
        localWeChatSDInfo.fileCount_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151543);
        return 0;
      case 4: 
        localWeChatSDInfo.fileLenInvalidCount_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151543);
        return 0;
      case 5: 
        localWeChatSDInfo.subDirResultsSize_ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(151543);
        return 0;
      case 6: 
        localWeChatSDInfo.totalTime_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151543);
        return 0;
      case 7: 
        localWeChatSDInfo.depth_ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(151543);
        return 0;
      case 8: 
        localWeChatSDInfo.tempAccTotalSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151543);
        return 0;
      case 9: 
        localWeChatSDInfo.tempAccDirResultsSize_ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(151543);
        return 0;
      case 10: 
        localWeChatSDInfo.tempAccDirCount_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151543);
        return 0;
      case 11: 
        localWeChatSDInfo.tempAccFileCount_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151543);
        return 0;
      case 12: 
        localWeChatSDInfo.tempAccFileLenInvalidCount_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151543);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SubDirInfo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SubDirInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.WeChatSDInfo
 * JD-Core Version:    0.7.0.1
 */