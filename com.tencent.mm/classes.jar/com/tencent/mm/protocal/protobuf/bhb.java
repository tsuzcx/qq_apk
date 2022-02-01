package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhb
  extends com.tencent.mm.bx.a
{
  public LinkedList<bhd> DEX;
  public int major;
  public String uuid;
  
  public bhb()
  {
    AppMethodBeat.i(82427);
    this.DEX = new LinkedList();
    AppMethodBeat.o(82427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.d(1, this.uuid);
      }
      paramVarArgs.aR(2, this.major);
      paramVarArgs.e(3, 8, this.DEX);
      AppMethodBeat.o(82428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.major);
      int j = f.a.a.a.c(3, 8, this.DEX);
      AppMethodBeat.o(82428);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DEX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhb localbhb = (bhb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82428);
          return -1;
        case 1: 
          localbhb.uuid = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82428);
          return 0;
        case 2: 
          localbhb.major = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82428);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bhd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bhd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbhb.DEX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82428);
        return 0;
      }
      AppMethodBeat.o(82428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhb
 * JD-Core Version:    0.7.0.1
 */