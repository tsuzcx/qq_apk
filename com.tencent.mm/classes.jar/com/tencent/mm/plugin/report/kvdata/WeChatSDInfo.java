package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class WeChatSDInfo
  extends com.tencent.mm.bv.a
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
    AppMethodBeat.i(79156);
    this.subDirList_ = new LinkedList();
    AppMethodBeat.o(79156);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79157);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.totalSize_);
      paramVarArgs.am(2, this.dirCount_);
      paramVarArgs.am(3, this.fileCount_);
      paramVarArgs.am(4, this.fileLenInvalidCount_);
      paramVarArgs.aO(5, this.subDirResultsSize_);
      paramVarArgs.am(6, this.totalTime_);
      paramVarArgs.aO(7, this.depth_);
      paramVarArgs.am(8, this.tempAccTotalSize_);
      paramVarArgs.aO(9, this.tempAccDirResultsSize_);
      paramVarArgs.am(10, this.tempAccDirCount_);
      paramVarArgs.am(11, this.tempAccFileCount_);
      paramVarArgs.am(12, this.tempAccFileLenInvalidCount_);
      paramVarArgs.e(13, 8, this.subDirList_);
      AppMethodBeat.o(79157);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.totalSize_);
      i = e.a.a.b.b.a.p(2, this.dirCount_);
      int j = e.a.a.b.b.a.p(3, this.fileCount_);
      int k = e.a.a.b.b.a.p(4, this.fileLenInvalidCount_);
      int m = e.a.a.b.b.a.bl(5, this.subDirResultsSize_);
      int n = e.a.a.b.b.a.p(6, this.totalTime_);
      int i1 = e.a.a.b.b.a.bl(7, this.depth_);
      int i2 = e.a.a.b.b.a.p(8, this.tempAccTotalSize_);
      int i3 = e.a.a.b.b.a.bl(9, this.tempAccDirResultsSize_);
      int i4 = e.a.a.b.b.a.p(10, this.tempAccDirCount_);
      int i5 = e.a.a.b.b.a.p(11, this.tempAccFileCount_);
      int i6 = e.a.a.b.b.a.p(12, this.tempAccFileLenInvalidCount_);
      int i7 = e.a.a.a.c(13, 8, this.subDirList_);
      AppMethodBeat.o(79157);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.subDirList_.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(79157);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      WeChatSDInfo localWeChatSDInfo = (WeChatSDInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(79157);
        return -1;
      case 1: 
        localWeChatSDInfo.totalSize_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79157);
        return 0;
      case 2: 
        localWeChatSDInfo.dirCount_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79157);
        return 0;
      case 3: 
        localWeChatSDInfo.fileCount_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79157);
        return 0;
      case 4: 
        localWeChatSDInfo.fileLenInvalidCount_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79157);
        return 0;
      case 5: 
        localWeChatSDInfo.subDirResultsSize_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79157);
        return 0;
      case 6: 
        localWeChatSDInfo.totalTime_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79157);
        return 0;
      case 7: 
        localWeChatSDInfo.depth_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79157);
        return 0;
      case 8: 
        localWeChatSDInfo.tempAccTotalSize_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79157);
        return 0;
      case 9: 
        localWeChatSDInfo.tempAccDirResultsSize_ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(79157);
        return 0;
      case 10: 
        localWeChatSDInfo.tempAccDirCount_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79157);
        return 0;
      case 11: 
        localWeChatSDInfo.tempAccFileCount_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79157);
        return 0;
      case 12: 
        localWeChatSDInfo.tempAccFileLenInvalidCount_ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(79157);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SubDirInfo();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SubDirInfo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localWeChatSDInfo.subDirList_.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(79157);
      return 0;
    }
    AppMethodBeat.o(79157);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.WeChatSDInfo
 * JD-Core Version:    0.7.0.1
 */