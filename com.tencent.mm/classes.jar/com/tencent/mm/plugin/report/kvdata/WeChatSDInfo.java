package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class WeChatSDInfo
  extends com.tencent.mm.bx.a
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.totalSize_);
      paramVarArgs.bv(2, this.dirCount_);
      paramVarArgs.bv(3, this.fileCount_);
      paramVarArgs.bv(4, this.fileLenInvalidCount_);
      paramVarArgs.bS(5, this.subDirResultsSize_);
      paramVarArgs.bv(6, this.totalTime_);
      paramVarArgs.bS(7, this.depth_);
      paramVarArgs.bv(8, this.tempAccTotalSize_);
      paramVarArgs.bS(9, this.tempAccDirResultsSize_);
      paramVarArgs.bv(10, this.tempAccDirCount_);
      paramVarArgs.bv(11, this.tempAccFileCount_);
      paramVarArgs.bv(12, this.tempAccFileLenInvalidCount_);
      paramVarArgs.e(13, 8, this.subDirList_);
      AppMethodBeat.o(151543);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.totalSize_);
      i = i.a.a.b.b.a.q(2, this.dirCount_);
      int j = i.a.a.b.b.a.q(3, this.fileCount_);
      int k = i.a.a.b.b.a.q(4, this.fileLenInvalidCount_);
      int m = i.a.a.b.b.a.cJ(5, this.subDirResultsSize_);
      int n = i.a.a.b.b.a.q(6, this.totalTime_);
      int i1 = i.a.a.b.b.a.cJ(7, this.depth_);
      int i2 = i.a.a.b.b.a.q(8, this.tempAccTotalSize_);
      int i3 = i.a.a.b.b.a.cJ(9, this.tempAccDirResultsSize_);
      int i4 = i.a.a.b.b.a.q(10, this.tempAccDirCount_);
      int i5 = i.a.a.b.b.a.q(11, this.tempAccFileCount_);
      int i6 = i.a.a.b.b.a.q(12, this.tempAccFileLenInvalidCount_);
      int i7 = i.a.a.a.c(13, 8, this.subDirList_);
      AppMethodBeat.o(151543);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.subDirList_.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(151543);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      WeChatSDInfo localWeChatSDInfo = (WeChatSDInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151543);
        return -1;
      case 1: 
        localWeChatSDInfo.totalSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151543);
        return 0;
      case 2: 
        localWeChatSDInfo.dirCount_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151543);
        return 0;
      case 3: 
        localWeChatSDInfo.fileCount_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151543);
        return 0;
      case 4: 
        localWeChatSDInfo.fileLenInvalidCount_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151543);
        return 0;
      case 5: 
        localWeChatSDInfo.subDirResultsSize_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151543);
        return 0;
      case 6: 
        localWeChatSDInfo.totalTime_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151543);
        return 0;
      case 7: 
        localWeChatSDInfo.depth_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151543);
        return 0;
      case 8: 
        localWeChatSDInfo.tempAccTotalSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151543);
        return 0;
      case 9: 
        localWeChatSDInfo.tempAccDirResultsSize_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151543);
        return 0;
      case 10: 
        localWeChatSDInfo.tempAccDirCount_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151543);
        return 0;
      case 11: 
        localWeChatSDInfo.tempAccFileCount_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151543);
        return 0;
      case 12: 
        localWeChatSDInfo.tempAccFileLenInvalidCount_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151543);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.WeChatSDInfo
 * JD-Core Version:    0.7.0.1
 */