package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ace
  extends com.tencent.mm.bx.a
{
  public cbw GbM;
  public LinkedList<aet> GbN;
  public LinkedList<dwa> GbO;
  public String GbP;
  
  public ace()
  {
    AppMethodBeat.i(91431);
    this.GbN = new LinkedList();
    this.GbO = new LinkedList();
    AppMethodBeat.o(91431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91432);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbM != null)
      {
        paramVarArgs.lC(1, this.GbM.computeSize());
        this.GbM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GbN);
      paramVarArgs.e(3, 8, this.GbO);
      if (this.GbP != null) {
        paramVarArgs.d(4, this.GbP);
      }
      AppMethodBeat.o(91432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbM == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lB(1, this.GbM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GbN) + f.a.a.a.c(3, 8, this.GbO);
      paramInt = i;
      if (this.GbP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GbP);
      }
      AppMethodBeat.o(91432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GbN.clear();
        this.GbO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ace localace = (ace)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91432);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localace.GbM = ((cbw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aet();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localace.GbN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localace.GbO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        }
        localace.GbP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91432);
        return 0;
      }
      AppMethodBeat.o(91432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ace
 * JD-Core Version:    0.7.0.1
 */