package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcj
  extends cvp
{
  public bnc FWq;
  public bxo Gxh;
  public rs GyZ;
  public bna Gza;
  public bon Gzb;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72489);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.FWq != null)
      {
        paramVarArgs.lC(4, this.FWq.computeSize());
        this.FWq.writeFields(paramVarArgs);
      }
      if (this.GyZ != null)
      {
        paramVarArgs.lC(8, this.GyZ.computeSize());
        this.GyZ.writeFields(paramVarArgs);
      }
      if (this.Gxh != null)
      {
        paramVarArgs.lC(9, this.Gxh.computeSize());
        this.Gxh.writeFields(paramVarArgs);
      }
      if (this.Gza != null)
      {
        paramVarArgs.lC(10, this.Gza.computeSize());
        this.Gza.writeFields(paramVarArgs);
      }
      if (this.Gzb != null)
      {
        paramVarArgs.lC(11, this.Gzb.computeSize());
        this.Gzb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1254;
      }
    }
    label1254:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.FWq != null) {
        i = paramInt + f.a.a.a.lB(4, this.FWq.computeSize());
      }
      paramInt = i;
      if (this.GyZ != null) {
        paramInt = i + f.a.a.a.lB(8, this.GyZ.computeSize());
      }
      i = paramInt;
      if (this.Gxh != null) {
        i = paramInt + f.a.a.a.lB(9, this.Gxh.computeSize());
      }
      paramInt = i;
      if (this.Gza != null) {
        paramInt = i + f.a.a.a.lB(10, this.Gza.computeSize());
      }
      i = paramInt;
      if (this.Gzb != null) {
        i = paramInt + f.a.a.a.lB(11, this.Gzb.computeSize());
      }
      AppMethodBeat.o(72489);
      return i;
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
          AppMethodBeat.o(72489);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcj localbcj = (bcj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(72489);
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
            localbcj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 2: 
          localbcj.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72489);
          return 0;
        case 3: 
          localbcj.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72489);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcj.FWq = ((bnc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcj.GyZ = ((rs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcj.Gxh = ((bxo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bna();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bna)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcj.Gza = ((bna)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bon();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bon)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbcj.Gzb = ((bon)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72489);
        return 0;
      }
      AppMethodBeat.o(72489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcj
 * JD-Core Version:    0.7.0.1
 */