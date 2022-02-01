package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctg
  extends com.tencent.mm.bx.a
{
  public bry HlA;
  public bry HlB;
  public String dxD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72578);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dxD != null) {
        paramVarArgs.d(1, this.dxD);
      }
      if (this.HlA != null)
      {
        paramVarArgs.lC(2, this.HlA.computeSize());
        this.HlA.writeFields(paramVarArgs);
      }
      if (this.HlB != null)
      {
        paramVarArgs.lC(3, this.HlB.computeSize());
        this.HlB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dxD == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.b.b.a.e(1, this.dxD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HlA != null) {
        paramInt = i + f.a.a.a.lB(2, this.HlA.computeSize());
      }
      i = paramInt;
      if (this.HlB != null) {
        i = paramInt + f.a.a.a.lB(3, this.HlB.computeSize());
      }
      AppMethodBeat.o(72578);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72578);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctg localctg = (ctg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72578);
          return -1;
        case 1: 
          localctg.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72578);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctg.HlA = ((bry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72578);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bry();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localctg.HlB = ((bry)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72578);
        return 0;
      }
      AppMethodBeat.o(72578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctg
 * JD-Core Version:    0.7.0.1
 */