package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xw
  extends com.tencent.mm.bx.a
{
  public long CZv;
  public abo CZy;
  public abr CZz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90958);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.CZv);
      if (this.CZy != null)
      {
        paramVarArgs.kX(2, this.CZy.computeSize());
        this.CZy.writeFields(paramVarArgs);
      }
      if (this.CZz != null)
      {
        paramVarArgs.kX(3, this.CZz.computeSize());
        this.CZz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.CZv) + 0;
      paramInt = i;
      if (this.CZy != null) {
        paramInt = i + f.a.a.a.kW(2, this.CZy.computeSize());
      }
      i = paramInt;
      if (this.CZz != null) {
        i = paramInt + f.a.a.a.kW(3, this.CZz.computeSize());
      }
      AppMethodBeat.o(90958);
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
      AppMethodBeat.o(90958);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      xw localxw = (xw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90958);
        return -1;
      case 1: 
        localxw.CZv = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(90958);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localxw.CZy = ((abo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90958);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new abr();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((abr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localxw.CZz = ((abr)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    AppMethodBeat.o(90958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xw
 * JD-Core Version:    0.7.0.1
 */