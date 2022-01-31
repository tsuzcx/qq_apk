package com.tencent.mm.plugin.report.kvdata;

import java.util.LinkedList;

public class BDStatusInfo
  extends com.tencent.mm.bv.a
{
  public long favDBSize_;
  public long mmDBSize_;
  public int mmDBTableCount_;
  public long snsDBSize_;
  public LinkedList<TableInfo> tableList_ = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.mmDBSize_);
      paramVarArgs.Y(2, this.snsDBSize_);
      paramVarArgs.gB(3, this.mmDBTableCount_);
      paramVarArgs.d(4, 8, this.tableList_);
      paramVarArgs.Y(5, this.favDBSize_);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.X(1, this.mmDBSize_) + 0 + d.a.a.a.X(2, this.snsDBSize_) + d.a.a.a.gy(3, this.mmDBTableCount_) + d.a.a.a.c(4, 8, this.tableList_) + d.a.a.a.X(5, this.favDBSize_);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tableList_.clear();
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
      BDStatusInfo localBDStatusInfo = (BDStatusInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localBDStatusInfo.mmDBSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 2: 
        localBDStatusInfo.snsDBSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 3: 
        localBDStatusInfo.mmDBTableCount_ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new TableInfo();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((TableInfo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localBDStatusInfo.tableList_.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localBDStatusInfo.favDBSize_ = ((d.a.a.a.a)localObject1).xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.BDStatusInfo
 * JD-Core Version:    0.7.0.1
 */