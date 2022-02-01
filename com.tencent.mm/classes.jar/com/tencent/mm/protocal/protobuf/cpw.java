package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cpw
  extends com.tencent.mm.bw.a
{
  public cat KPD;
  public cau KPE;
  public int MvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32350);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KPD == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.KPE == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.KPD != null)
      {
        paramVarArgs.ni(1, this.KPD.computeSize());
        this.KPD.writeFields(paramVarArgs);
      }
      if (this.KPE != null)
      {
        paramVarArgs.ni(2, this.KPE.computeSize());
        this.KPE.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.MvP);
      AppMethodBeat.o(32350);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KPD == null) {
        break label619;
      }
    }
    label619:
    for (paramInt = g.a.a.a.nh(1, this.KPD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KPE != null) {
        i = paramInt + g.a.a.a.nh(2, this.KPE.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MvP);
      AppMethodBeat.o(32350);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KPD == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32350);
          throw paramVarArgs;
        }
        if (this.KPE == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cpw localcpw = (cpw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32350);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cat();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpw.KPD = ((cat)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cau();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cau)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpw.KPE = ((cau)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        }
        localcpw.MvP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32350);
        return 0;
      }
      AppMethodBeat.o(32350);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpw
 * JD-Core Version:    0.7.0.1
 */