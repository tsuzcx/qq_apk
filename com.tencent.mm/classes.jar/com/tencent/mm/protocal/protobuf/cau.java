package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cau
  extends com.tencent.mm.bw.a
{
  public bob FVS;
  public boc FVT;
  public int Hou;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32350);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVS == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.FVT == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.FVS != null)
      {
        paramVarArgs.lJ(1, this.FVS.computeSize());
        this.FVS.writeFields(paramVarArgs);
      }
      if (this.FVT != null)
      {
        paramVarArgs.lJ(2, this.FVT.computeSize());
        this.FVT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Hou);
      AppMethodBeat.o(32350);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVS == null) {
        break label619;
      }
    }
    label619:
    for (paramInt = f.a.a.a.lI(1, this.FVS.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FVT != null) {
        i = paramInt + f.a.a.a.lI(2, this.FVT.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Hou);
      AppMethodBeat.o(32350);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FVS == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32350);
          throw paramVarArgs;
        }
        if (this.FVT == null)
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
        cau localcau = (cau)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32350);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bob();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcau.FVS = ((bob)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((boc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcau.FVT = ((boc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        }
        localcau.Hou = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32350);
        return 0;
      }
      AppMethodBeat.o(32350);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cau
 * JD-Core Version:    0.7.0.1
 */