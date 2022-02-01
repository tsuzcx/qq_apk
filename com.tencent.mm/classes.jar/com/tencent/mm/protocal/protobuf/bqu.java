package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bqu
  extends com.tencent.mm.bx.a
{
  public bfj CFB;
  public bfk CFC;
  public int DOU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32350);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CFB == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.CFC == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.CFB != null)
      {
        paramVarArgs.kX(1, this.CFB.computeSize());
        this.CFB.writeFields(paramVarArgs);
      }
      if (this.CFC != null)
      {
        paramVarArgs.kX(2, this.CFC.computeSize());
        this.CFC.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.DOU);
      AppMethodBeat.o(32350);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CFB == null) {
        break label619;
      }
    }
    label619:
    for (paramInt = f.a.a.a.kW(1, this.CFB.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CFC != null) {
        i = paramInt + f.a.a.a.kW(2, this.CFC.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DOU);
      AppMethodBeat.o(32350);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CFB == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32350);
          throw paramVarArgs;
        }
        if (this.CFC == null)
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
        bqu localbqu = (bqu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32350);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqu.CFB = ((bfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqu.CFC = ((bfk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        }
        localbqu.DOU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32350);
        return 0;
      }
      AppMethodBeat.o(32350);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqu
 * JD-Core Version:    0.7.0.1
 */