package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bni
  extends com.tencent.mm.bx.a
{
  public dng GHs;
  public cnw GHt;
  public cnw GHu;
  public String dxD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GHs != null)
      {
        paramVarArgs.lC(1, this.GHs.computeSize());
        this.GHs.writeFields(paramVarArgs);
      }
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      if (this.GHt != null)
      {
        paramVarArgs.lC(3, this.GHt.computeSize());
        this.GHt.writeFields(paramVarArgs);
      }
      if (this.GHu != null)
      {
        paramVarArgs.lC(4, this.GHu.computeSize());
        this.GHu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GHs == null) {
        break label678;
      }
    }
    label678:
    for (int i = f.a.a.a.lB(1, this.GHs.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = paramInt;
      if (this.GHt != null) {
        i = paramInt + f.a.a.a.lB(3, this.GHt.computeSize());
      }
      paramInt = i;
      if (this.GHu != null) {
        paramInt = i + f.a.a.a.lB(4, this.GHu.computeSize());
      }
      AppMethodBeat.o(209408);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bni localbni = (bni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209408);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dng();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dng)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbni.GHs = ((dng)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209408);
          return 0;
        case 2: 
          localbni.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209408);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbni.GHt = ((cnw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209408);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cnw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbni.GHu = ((cnw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209408);
        return 0;
      }
      AppMethodBeat.o(209408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bni
 * JD-Core Version:    0.7.0.1
 */