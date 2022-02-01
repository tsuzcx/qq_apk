package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dya
  extends com.tencent.mm.bx.a
{
  public ebe Lxb;
  public ebn Lxc;
  public ebn Lxd;
  public ebn Lxe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Lxb != null)
      {
        paramVarArgs.kX(1, this.Lxb.computeSize());
        this.Lxb.writeFields(paramVarArgs);
      }
      if (this.Lxc != null)
      {
        paramVarArgs.kX(2, this.Lxc.computeSize());
        this.Lxc.writeFields(paramVarArgs);
      }
      if (this.Lxd != null)
      {
        paramVarArgs.kX(3, this.Lxd.computeSize());
        this.Lxd.writeFields(paramVarArgs);
      }
      if (this.Lxe != null)
      {
        paramVarArgs.kX(4, this.Lxe.computeSize());
        this.Lxe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(203589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lxb == null) {
        break label774;
      }
    }
    label774:
    for (int i = f.a.a.a.kW(1, this.Lxb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lxc != null) {
        paramInt = i + f.a.a.a.kW(2, this.Lxc.computeSize());
      }
      i = paramInt;
      if (this.Lxd != null) {
        i = paramInt + f.a.a.a.kW(3, this.Lxd.computeSize());
      }
      paramInt = i;
      if (this.Lxe != null) {
        paramInt = i + f.a.a.a.kW(4, this.Lxe.computeSize());
      }
      AppMethodBeat.o(203589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dya localdya = (dya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203589);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdya.Lxb = ((ebe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203589);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdya.Lxc = ((ebn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203589);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdya.Lxd = ((ebn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203589);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdya.Lxe = ((ebn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(203589);
        return 0;
      }
      AppMethodBeat.o(203589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dya
 * JD-Core Version:    0.7.0.1
 */