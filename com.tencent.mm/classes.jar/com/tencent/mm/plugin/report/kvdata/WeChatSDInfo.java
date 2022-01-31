package com.tencent.mm.plugin.report.kvdata;

import java.util.LinkedList;

public class WeChatSDInfo
  extends com.tencent.mm.bv.a
{
  public int depth_;
  public long dirCount_;
  public long fileCount_;
  public long fileLenInvalidCount_;
  public LinkedList<SubDirInfo> subDirList_ = new LinkedList();
  public int subDirResultsSize_;
  public long tempAccDirCount_;
  public int tempAccDirResultsSize_;
  public long tempAccFileCount_;
  public long tempAccFileLenInvalidCount_;
  public long tempAccTotalSize_;
  public long totalSize_;
  public long totalTime_;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.totalSize_);
      paramVarArgs.Y(2, this.dirCount_);
      paramVarArgs.Y(3, this.fileCount_);
      paramVarArgs.Y(4, this.fileLenInvalidCount_);
      paramVarArgs.gB(5, this.subDirResultsSize_);
      paramVarArgs.Y(6, this.totalTime_);
      paramVarArgs.gB(7, this.depth_);
      paramVarArgs.Y(8, this.tempAccTotalSize_);
      paramVarArgs.gB(9, this.tempAccDirResultsSize_);
      paramVarArgs.Y(10, this.tempAccDirCount_);
      paramVarArgs.Y(11, this.tempAccFileCount_);
      paramVarArgs.Y(12, this.tempAccFileLenInvalidCount_);
      paramVarArgs.d(13, 8, this.subDirList_);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.X(1, this.totalSize_) + 0 + d.a.a.a.X(2, this.dirCount_) + d.a.a.a.X(3, this.fileCount_) + d.a.a.a.X(4, this.fileLenInvalidCount_) + d.a.a.a.gy(5, this.subDirResultsSize_) + d.a.a.a.X(6, this.totalTime_) + d.a.a.a.gy(7, this.depth_) + d.a.a.a.X(8, this.tempAccTotalSize_) + d.a.a.a.gy(9, this.tempAccDirResultsSize_) + d.a.a.a.X(10, this.tempAccDirCount_) + d.a.a.a.X(11, this.tempAccFileCount_) + d.a.a.a.X(12, this.tempAccFileLenInvalidCount_) + d.a.a.a.c(13, 8, this.subDirList_);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.subDirList_.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      WeChatSDInfo localWeChatSDInfo = (WeChatSDInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localWeChatSDInfo.totalSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 2: 
        localWeChatSDInfo.dirCount_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 3: 
        localWeChatSDInfo.fileCount_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 4: 
        localWeChatSDInfo.fileLenInvalidCount_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 5: 
        localWeChatSDInfo.subDirResultsSize_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        localWeChatSDInfo.totalTime_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 7: 
        localWeChatSDInfo.depth_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localWeChatSDInfo.tempAccTotalSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 9: 
        localWeChatSDInfo.tempAccDirResultsSize_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 10: 
        localWeChatSDInfo.tempAccDirCount_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 11: 
        localWeChatSDInfo.tempAccFileCount_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 12: 
        localWeChatSDInfo.tempAccFileLenInvalidCount_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SubDirInfo();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((SubDirInfo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localWeChatSDInfo.subDirList_.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.WeChatSDInfo
 * JD-Core Version:    0.7.0.1
 */