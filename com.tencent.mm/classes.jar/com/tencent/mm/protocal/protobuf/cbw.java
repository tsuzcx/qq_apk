package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cbw
  extends com.tencent.mm.bw.a
{
  public LinkedList<Integer> EKK;
  public LinkedList<cbt> FpS;
  public int ncL;
  
  public cbw()
  {
    AppMethodBeat.i(43120);
    this.EKK = new LinkedList();
    this.FpS = new LinkedList();
    AppMethodBeat.o(43120);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43121);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ncL);
      paramVarArgs.f(2, 2, this.EKK);
      paramVarArgs.e(3, 8, this.FpS);
      AppMethodBeat.o(43121);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.ncL);
      i = f.a.a.a.d(2, 2, this.EKK);
      int j = f.a.a.a.c(3, 8, this.FpS);
      AppMethodBeat.o(43121);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EKK.clear();
      this.FpS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(43121);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cbw localcbw = (cbw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43121);
        return -1;
      case 1: 
        localcbw.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43121);
        return 0;
      case 2: 
        localcbw.EKK = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
        AppMethodBeat.o(43121);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cbt();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcbw.FpS.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43121);
      return 0;
    }
    AppMethodBeat.o(43121);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbw
 * JD-Core Version:    0.7.0.1
 */