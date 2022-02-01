package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afv
  extends com.tencent.mm.bx.a
{
  public long DfM;
  public long DfN;
  public LinkedList<dbt> DfO;
  
  public afv()
  {
    AppMethodBeat.i(125722);
    this.DfO = new LinkedList();
    AppMethodBeat.o(125722);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125723);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.DfM);
      paramVarArgs.aG(2, this.DfN);
      paramVarArgs.e(3, 8, this.DfO);
      AppMethodBeat.o(125723);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.DfM);
      i = f.a.a.b.b.a.q(2, this.DfN);
      int j = f.a.a.a.c(3, 8, this.DfO);
      AppMethodBeat.o(125723);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DfO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125723);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      afv localafv = (afv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125723);
        return -1;
      case 1: 
        localafv.DfM = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125723);
        return 0;
      case 2: 
        localafv.DfN = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125723);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dbt();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localafv.DfO.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125723);
      return 0;
    }
    AppMethodBeat.o(125723);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afv
 * JD-Core Version:    0.7.0.1
 */