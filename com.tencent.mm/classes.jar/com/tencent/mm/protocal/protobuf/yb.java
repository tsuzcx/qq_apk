package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yb
  extends cvc
{
  public LinkedList<Integer> FXH;
  public LinkedList<ya> FXI;
  public int Scene;
  public String orm;
  
  public yb()
  {
    AppMethodBeat.i(6403);
    this.FXH = new LinkedList();
    this.FXI = new LinkedList();
    AppMethodBeat.o(6403);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.FXH);
      paramVarArgs.aS(3, this.Scene);
      if (this.orm != null) {
        paramVarArgs.d(4, this.orm);
      }
      paramVarArgs.e(5, 8, this.FXI);
      AppMethodBeat.o(6404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 2, this.FXH) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.orm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.orm);
      }
      i = f.a.a.a.c(5, 8, this.FXI);
      AppMethodBeat.o(6404);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FXH.clear();
        this.FXI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(6404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yb localyb = (yb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6404);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6404);
          return 0;
        case 2: 
          localyb.FXH.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(6404);
          return 0;
        case 3: 
          localyb.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6404);
          return 0;
        case 4: 
          localyb.orm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6404);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ya();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ya)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyb.FXI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6404);
        return 0;
      }
      AppMethodBeat.o(6404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yb
 * JD-Core Version:    0.7.0.1
 */