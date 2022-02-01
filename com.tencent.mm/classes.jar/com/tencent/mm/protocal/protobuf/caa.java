package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class caa
  extends com.tencent.mm.bx.a
{
  public bnj FDx;
  public bnk FDy;
  public int GUT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32350);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDx == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.FDy == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.FDx != null)
      {
        paramVarArgs.lC(1, this.FDx.computeSize());
        this.FDx.writeFields(paramVarArgs);
      }
      if (this.FDy != null)
      {
        paramVarArgs.lC(2, this.FDy.computeSize());
        this.FDy.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GUT);
      AppMethodBeat.o(32350);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDx == null) {
        break label619;
      }
    }
    label619:
    for (paramInt = f.a.a.a.lB(1, this.FDx.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FDy != null) {
        i = paramInt + f.a.a.a.lB(2, this.FDy.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GUT);
      AppMethodBeat.o(32350);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FDx == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32350);
          throw paramVarArgs;
        }
        if (this.FDy == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
          AppMethodBeat.o(32350);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32350);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        caa localcaa = (caa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32350);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaa.FDx = ((bnj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaa.FDy = ((bnk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        }
        localcaa.GUT = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32350);
        return 0;
      }
      AppMethodBeat.o(32350);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caa
 * JD-Core Version:    0.7.0.1
 */