package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fu
  extends com.tencent.mm.bx.a
{
  public int CAB;
  public fv CAC;
  public int CAt;
  public int CAu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CAt);
      paramVarArgs.aR(2, this.CAu);
      paramVarArgs.aR(3, this.CAB);
      if (this.CAC != null)
      {
        paramVarArgs.kX(4, this.CAC.computeSize());
        this.CAC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CAt) + 0 + f.a.a.b.b.a.bA(2, this.CAu) + f.a.a.b.b.a.bA(3, this.CAB);
      paramInt = i;
      if (this.CAC != null) {
        paramInt = i + f.a.a.a.kW(4, this.CAC.computeSize());
      }
      AppMethodBeat.o(32120);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      fu localfu = (fu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32120);
        return -1;
      case 1: 
        localfu.CAt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32120);
        return 0;
      case 2: 
        localfu.CAu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32120);
        return 0;
      case 3: 
        localfu.CAB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32120);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new fv();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((fv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localfu.CAC = ((fv)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    AppMethodBeat.o(32120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fu
 * JD-Core Version:    0.7.0.1
 */