package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvp
  extends com.tencent.mm.bx.a
{
  public dwe GPL;
  public asu GPM;
  public dwe GPN;
  public int ddx;
  public int height;
  public int htQ;
  public int retryCount;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169087);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GPL != null)
      {
        paramVarArgs.lC(1, this.GPL.computeSize());
        this.GPL.writeFields(paramVarArgs);
      }
      if (this.GPM != null)
      {
        paramVarArgs.lC(2, this.GPM.computeSize());
        this.GPM.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.ddx);
      paramVarArgs.aS(4, this.htQ);
      paramVarArgs.aS(5, this.width);
      paramVarArgs.aS(6, this.height);
      if (this.GPN != null)
      {
        paramVarArgs.lC(7, this.GPN.computeSize());
        this.GPN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.retryCount);
      AppMethodBeat.o(169087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GPL == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = f.a.a.a.lB(1, this.GPL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GPM != null) {
        i = paramInt + f.a.a.a.lB(2, this.GPM.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.ddx) + f.a.a.b.b.a.bz(4, this.htQ) + f.a.a.b.b.a.bz(5, this.width) + f.a.a.b.b.a.bz(6, this.height);
      paramInt = i;
      if (this.GPN != null) {
        paramInt = i + f.a.a.a.lB(7, this.GPN.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.retryCount);
      AppMethodBeat.o(169087);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169087);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvp localbvp = (bvp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169087);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvp.GPL = ((dwe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new asu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((asu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvp.GPM = ((asu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 3: 
          localbvp.ddx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169087);
          return 0;
        case 4: 
          localbvp.htQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169087);
          return 0;
        case 5: 
          localbvp.width = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169087);
          return 0;
        case 6: 
          localbvp.height = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169087);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvp.GPN = ((dwe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        }
        localbvp.retryCount = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169087);
        return 0;
      }
      AppMethodBeat.o(169087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvp
 * JD-Core Version:    0.7.0.1
 */