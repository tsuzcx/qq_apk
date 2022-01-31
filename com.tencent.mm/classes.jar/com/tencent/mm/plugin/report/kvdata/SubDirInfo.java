package com.tencent.mm.plugin.report.kvdata;

public class SubDirInfo
  extends com.tencent.mm.bv.a
{
  public long dirCount_;
  public long fileCount_;
  public long fileLenInvalidCount;
  public int tag_;
  public long totalSize_;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tag_);
      paramVarArgs.Y(2, this.totalSize_);
      paramVarArgs.Y(3, this.dirCount_);
      paramVarArgs.Y(4, this.fileCount_);
      paramVarArgs.Y(5, this.fileLenInvalidCount);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tag_) + 0 + d.a.a.a.X(2, this.totalSize_) + d.a.a.a.X(3, this.dirCount_) + d.a.a.a.X(4, this.fileCount_) + d.a.a.a.X(5, this.fileLenInvalidCount);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      SubDirInfo localSubDirInfo = (SubDirInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localSubDirInfo.tag_ = locala.xpH.oD();
        return 0;
      case 2: 
        localSubDirInfo.totalSize_ = locala.xpH.oE();
        return 0;
      case 3: 
        localSubDirInfo.dirCount_ = locala.xpH.oE();
        return 0;
      case 4: 
        localSubDirInfo.fileCount_ = locala.xpH.oE();
        return 0;
      }
      localSubDirInfo.fileLenInvalidCount = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.SubDirInfo
 * JD-Core Version:    0.7.0.1
 */