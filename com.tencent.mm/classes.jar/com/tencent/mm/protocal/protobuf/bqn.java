package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bqn
  extends cvp
{
  public bql GKP;
  public int GKZ;
  public int dqI;
  public int uda;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123603);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123603);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GKP != null)
      {
        paramVarArgs.lC(2, this.GKP.computeSize());
        this.GKP.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.dqI);
      paramVarArgs.aS(4, this.uda);
      paramVarArgs.aS(5, this.GKZ);
      AppMethodBeat.o(123603);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GKP != null) {
        i = paramInt + f.a.a.a.lB(2, this.GKP.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.dqI);
      int j = f.a.a.b.b.a.bz(4, this.uda);
      int k = f.a.a.b.b.a.bz(5, this.GKZ);
      AppMethodBeat.o(123603);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123603);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123603);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqn localbqn = (bqn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123603);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123603);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bql();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqn.GKP = ((bql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123603);
          return 0;
        case 3: 
          localbqn.dqI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123603);
          return 0;
        case 4: 
          localbqn.uda = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123603);
          return 0;
        }
        localbqn.GKZ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123603);
        return 0;
      }
      AppMethodBeat.o(123603);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqn
 * JD-Core Version:    0.7.0.1
 */