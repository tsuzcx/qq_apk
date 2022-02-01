package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqy
  extends com.tencent.mm.bx.a
{
  public int CNt;
  public LinkedList<dqr> DsN;
  public boolean Dwd;
  
  public dqy()
  {
    AppMethodBeat.i(32525);
    this.DsN = new LinkedList();
    AppMethodBeat.o(32525);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32526);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.DsN);
      paramVarArgs.aR(2, this.CNt);
      paramVarArgs.bg(3, this.Dwd);
      AppMethodBeat.o(32526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.DsN);
      i = f.a.a.b.b.a.bA(2, this.CNt);
      int j = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(32526);
      return paramInt + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DsN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dqy localdqy = (dqy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32526);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dqr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqy.DsN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32526);
        return 0;
      case 2: 
        localdqy.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32526);
        return 0;
      }
      localdqy.Dwd = ((f.a.a.a.a)localObject1).KhF.fHu();
      AppMethodBeat.o(32526);
      return 0;
    }
    AppMethodBeat.o(32526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqy
 * JD-Core Version:    0.7.0.1
 */