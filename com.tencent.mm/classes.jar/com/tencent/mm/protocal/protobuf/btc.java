package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class btc
  extends com.tencent.mm.bx.a
{
  public long EVt;
  public btb aaaW;
  public LinkedList<btd> aaaX;
  public LinkedList<dnp> aaaY;
  
  public btc()
  {
    AppMethodBeat.i(184206);
    this.aaaX = new LinkedList();
    this.aaaY = new LinkedList();
    AppMethodBeat.o(184206);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184207);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.EVt);
      if (this.aaaW != null)
      {
        paramVarArgs.qD(2, this.aaaW.computeSize());
        this.aaaW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.aaaX);
      paramVarArgs.e(4, 8, this.aaaY);
      AppMethodBeat.o(184207);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.EVt) + 0;
      paramInt = i;
      if (this.aaaW != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaaW.computeSize());
      }
      i = i.a.a.a.c(3, 8, this.aaaX);
      int j = i.a.a.a.c(4, 8, this.aaaY);
      AppMethodBeat.o(184207);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaaX.clear();
      this.aaaY.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(184207);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      btc localbtc = (btc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184207);
        return -1;
      case 1: 
        localbtc.EVt = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(184207);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new btb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((btb)localObject2).parseFrom((byte[])localObject1);
          }
          localbtc.aaaW = ((btb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184207);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new btd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((btd)localObject2).parseFrom((byte[])localObject1);
          }
          localbtc.aaaX.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184207);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dnp();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dnp)localObject2).parseFrom((byte[])localObject1);
        }
        localbtc.aaaY.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(184207);
      return 0;
    }
    AppMethodBeat.o(184207);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btc
 * JD-Core Version:    0.7.0.1
 */