package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgh
  extends com.tencent.mm.bx.a
{
  public adt HuA;
  public clz HuB;
  public int Hux;
  public dhl Huy;
  public cpv Huz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125802);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hux);
      if (this.Huy != null)
      {
        paramVarArgs.lC(2, this.Huy.computeSize());
        this.Huy.writeFields(paramVarArgs);
      }
      if (this.Huz != null)
      {
        paramVarArgs.lC(3, this.Huz.computeSize());
        this.Huz.writeFields(paramVarArgs);
      }
      if (this.HuA != null)
      {
        paramVarArgs.lC(4, this.HuA.computeSize());
        this.HuA.writeFields(paramVarArgs);
      }
      if (this.HuB != null)
      {
        paramVarArgs.lC(5, this.HuB.computeSize());
        this.HuB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Hux) + 0;
      paramInt = i;
      if (this.Huy != null) {
        paramInt = i + f.a.a.a.lB(2, this.Huy.computeSize());
      }
      i = paramInt;
      if (this.Huz != null) {
        i = paramInt + f.a.a.a.lB(3, this.Huz.computeSize());
      }
      paramInt = i;
      if (this.HuA != null) {
        paramInt = i + f.a.a.a.lB(4, this.HuA.computeSize());
      }
      i = paramInt;
      if (this.HuB != null) {
        i = paramInt + f.a.a.a.lB(5, this.HuB.computeSize());
      }
      AppMethodBeat.o(125802);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dgh localdgh = (dgh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125802);
        return -1;
      case 1: 
        localdgh.Hux = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125802);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgh.Huy = ((dhl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cpv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cpv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgh.Huz = ((cpv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgh.HuA = ((adt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new clz();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((clz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdgh.HuB = ((clz)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    AppMethodBeat.o(125802);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgh
 * JD-Core Version:    0.7.0.1
 */