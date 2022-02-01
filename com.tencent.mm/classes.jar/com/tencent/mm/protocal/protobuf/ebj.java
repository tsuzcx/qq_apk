package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebj
  extends com.tencent.mm.bx.a
{
  public String HNX;
  public sc HNY;
  public boolean HNZ;
  public String HOa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91731);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HNX != null) {
        paramVarArgs.d(1, this.HNX);
      }
      if (this.HNY != null)
      {
        paramVarArgs.lC(2, this.HNY.computeSize());
        this.HNY.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(3, this.HNZ);
      if (this.HOa != null) {
        paramVarArgs.d(4, this.HOa);
      }
      AppMethodBeat.o(91731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HNX == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.e(1, this.HNX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HNY != null) {
        i = paramInt + f.a.a.a.lB(2, this.HNY.computeSize());
      }
      i += f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.HOa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HOa);
      }
      AppMethodBeat.o(91731);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebj localebj = (ebj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91731);
          return -1;
        case 1: 
          localebj.HNX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91731);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((sc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebj.HNY = ((sc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91731);
          return 0;
        case 3: 
          localebj.HNZ = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91731);
          return 0;
        }
        localebj.HOa = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91731);
        return 0;
      }
      AppMethodBeat.o(91731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebj
 * JD-Core Version:    0.7.0.1
 */