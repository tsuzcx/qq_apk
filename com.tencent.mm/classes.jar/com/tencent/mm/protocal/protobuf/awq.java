package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awq
  extends cvp
{
  public int FqJ;
  public int FqN;
  public String FqO;
  public dej FqP;
  public int FqX;
  public hu tpT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32220);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32220);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FqN);
      paramVarArgs.aS(3, this.FqX);
      if (this.FqO != null) {
        paramVarArgs.d(4, this.FqO);
      }
      if (this.FqP != null)
      {
        paramVarArgs.lC(5, this.FqP.computeSize());
        this.FqP.writeFields(paramVarArgs);
      }
      if (this.tpT != null)
      {
        paramVarArgs.lC(6, this.tpT.computeSize());
        this.tpT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.FqJ);
      AppMethodBeat.o(32220);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label875;
      }
    }
    label875:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FqN) + f.a.a.b.b.a.bz(3, this.FqX);
      paramInt = i;
      if (this.FqO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FqO);
      }
      i = paramInt;
      if (this.FqP != null) {
        i = paramInt + f.a.a.a.lB(5, this.FqP.computeSize());
      }
      paramInt = i;
      if (this.tpT != null) {
        paramInt = i + f.a.a.a.lB(6, this.tpT.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.FqJ);
      AppMethodBeat.o(32220);
      return paramInt + i;
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
          AppMethodBeat.o(32220);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32220);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awq localawq = (awq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32220);
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
            localawq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        case 2: 
          localawq.FqN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32220);
          return 0;
        case 3: 
          localawq.FqX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32220);
          return 0;
        case 4: 
          localawq.FqO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32220);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dej();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dej)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawq.FqP = ((dej)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawq.tpT = ((hu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        }
        localawq.FqJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32220);
        return 0;
      }
      AppMethodBeat.o(32220);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awq
 * JD-Core Version:    0.7.0.1
 */