package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qy
  extends com.tencent.mm.bx.a
{
  public qq FMQ;
  public qp FMR;
  public long FMS;
  public qw FMT;
  public ra FMU;
  public qv FMV;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117850);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      if (this.FMQ != null)
      {
        paramVarArgs.lC(2, this.FMQ.computeSize());
        this.FMQ.writeFields(paramVarArgs);
      }
      if (this.FMR != null)
      {
        paramVarArgs.lC(3, this.FMR.computeSize());
        this.FMR.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.FMS);
      if (this.FMT != null)
      {
        paramVarArgs.lC(5, this.FMT.computeSize());
        this.FMT.writeFields(paramVarArgs);
      }
      if (this.FMU != null)
      {
        paramVarArgs.lC(6, this.FMU.computeSize());
        this.FMU.writeFields(paramVarArgs);
      }
      if (this.FMV != null)
      {
        paramVarArgs.lC(7, this.FMV.computeSize());
        this.FMV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nEf) + 0;
      paramInt = i;
      if (this.FMQ != null) {
        paramInt = i + f.a.a.a.lB(2, this.FMQ.computeSize());
      }
      i = paramInt;
      if (this.FMR != null) {
        i = paramInt + f.a.a.a.lB(3, this.FMR.computeSize());
      }
      i += f.a.a.b.b.a.p(4, this.FMS);
      paramInt = i;
      if (this.FMT != null) {
        paramInt = i + f.a.a.a.lB(5, this.FMT.computeSize());
      }
      i = paramInt;
      if (this.FMU != null) {
        i = paramInt + f.a.a.a.lB(6, this.FMU.computeSize());
      }
      paramInt = i;
      if (this.FMV != null) {
        paramInt = i + f.a.a.a.lB(7, this.FMV.computeSize());
      }
      AppMethodBeat.o(117850);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      qy localqy = (qy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117850);
        return -1;
      case 1: 
        localqy.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117850);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.FMQ = ((qq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.FMR = ((qp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 4: 
        localqy.FMS = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117850);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.FMT = ((qw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ra();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.FMU = ((ra)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new qv();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((qv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localqy.FMV = ((qv)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    AppMethodBeat.o(117850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qy
 * JD-Core Version:    0.7.0.1
 */