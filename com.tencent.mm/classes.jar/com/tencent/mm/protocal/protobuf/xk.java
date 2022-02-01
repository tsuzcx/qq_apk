package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xk
  extends com.tencent.mm.bx.a
{
  public String CZd;
  public xg CZe;
  public String CzS;
  public String dnB;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117861);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.timestamp);
      if (this.CZd != null) {
        paramVarArgs.d(2, this.CZd);
      }
      if (this.CzS != null) {
        paramVarArgs.d(3, this.CzS);
      }
      if (this.dnB != null) {
        paramVarArgs.d(4, this.dnB);
      }
      if (this.CZe != null)
      {
        paramVarArgs.kX(5, this.CZe.computeSize());
        this.CZe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.timestamp) + 0;
      paramInt = i;
      if (this.CZd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CZd);
      }
      i = paramInt;
      if (this.CzS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CzS);
      }
      paramInt = i;
      if (this.dnB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dnB);
      }
      i = paramInt;
      if (this.CZe != null) {
        i = paramInt + f.a.a.a.kW(5, this.CZe.computeSize());
      }
      AppMethodBeat.o(117861);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      xk localxk = (xk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117861);
        return -1;
      case 1: 
        localxk.timestamp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(117861);
        return 0;
      case 2: 
        localxk.CZd = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 3: 
        localxk.CzS = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 4: 
        localxk.dnB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117861);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new xg();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((xg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localxk.CZe = ((xg)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    AppMethodBeat.o(117861);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xk
 * JD-Core Version:    0.7.0.1
 */