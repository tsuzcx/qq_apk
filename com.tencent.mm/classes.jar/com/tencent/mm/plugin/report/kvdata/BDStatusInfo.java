package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class BDStatusInfo
  extends com.tencent.mm.bw.a
{
  public long favDBSize_;
  public long mmDBSize_;
  public int mmDBTableCount_;
  public long snsDBSize_;
  public LinkedList<TableInfo> tableList_;
  
  public BDStatusInfo()
  {
    AppMethodBeat.i(151532);
    this.tableList_ = new LinkedList();
    AppMethodBeat.o(151532);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.mmDBSize_);
      paramVarArgs.aO(2, this.snsDBSize_);
      paramVarArgs.aR(3, this.mmDBTableCount_);
      paramVarArgs.e(4, 8, this.tableList_);
      paramVarArgs.aO(5, this.favDBSize_);
      AppMethodBeat.o(151533);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.mmDBSize_);
      i = f.a.a.b.b.a.p(2, this.snsDBSize_);
      int j = f.a.a.b.b.a.bx(3, this.mmDBTableCount_);
      int k = f.a.a.a.c(4, 8, this.tableList_);
      int m = f.a.a.b.b.a.p(5, this.favDBSize_);
      AppMethodBeat.o(151533);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tableList_.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(151533);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      BDStatusInfo localBDStatusInfo = (BDStatusInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151533);
        return -1;
      case 1: 
        localBDStatusInfo.mmDBSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151533);
        return 0;
      case 2: 
        localBDStatusInfo.snsDBSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(151533);
        return 0;
      case 3: 
        localBDStatusInfo.mmDBTableCount_ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(151533);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new TableInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((TableInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localBDStatusInfo.tableList_.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151533);
        return 0;
      }
      localBDStatusInfo.favDBSize_ = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(151533);
      return 0;
    }
    AppMethodBeat.o(151533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.BDStatusInfo
 * JD-Core Version:    0.7.0.1
 */