package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class BDStatusInfo
  extends com.tencent.mm.bx.a
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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.mmDBSize_);
      paramVarArgs.bv(2, this.snsDBSize_);
      paramVarArgs.bS(3, this.mmDBTableCount_);
      paramVarArgs.e(4, 8, this.tableList_);
      paramVarArgs.bv(5, this.favDBSize_);
      AppMethodBeat.o(151533);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.mmDBSize_);
      i = i.a.a.b.b.a.q(2, this.snsDBSize_);
      int j = i.a.a.b.b.a.cJ(3, this.mmDBTableCount_);
      int k = i.a.a.a.c(4, 8, this.tableList_);
      int m = i.a.a.b.b.a.q(5, this.favDBSize_);
      AppMethodBeat.o(151533);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tableList_.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(151533);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      BDStatusInfo localBDStatusInfo = (BDStatusInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151533);
        return -1;
      case 1: 
        localBDStatusInfo.mmDBSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151533);
        return 0;
      case 2: 
        localBDStatusInfo.snsDBSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(151533);
        return 0;
      case 3: 
        localBDStatusInfo.mmDBTableCount_ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(151533);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          TableInfo localTableInfo = new TableInfo();
          if ((localObject != null) && (localObject.length > 0)) {
            localTableInfo.parseFrom((byte[])localObject);
          }
          localBDStatusInfo.tableList_.add(localTableInfo);
          paramInt += 1;
        }
        AppMethodBeat.o(151533);
        return 0;
      }
      localBDStatusInfo.favDBSize_ = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(151533);
      return 0;
    }
    AppMethodBeat.o(151533);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.BDStatusInfo
 * JD-Core Version:    0.7.0.1
 */