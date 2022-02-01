package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class btc
  extends cld
{
  public int CNq;
  public int CtL;
  public SKBuiltinBuffer_t DQb;
  public SKBuiltinBuffer_t DQc;
  public int DQd;
  public int DQe;
  public LinkedList<xd> DQf;
  
  public btc()
  {
    AppMethodBeat.i(133182);
    this.DQf = new LinkedList();
    AppMethodBeat.o(133182);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133183);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.DQb == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.DQc == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DQb != null)
      {
        paramVarArgs.kX(2, this.DQb.computeSize());
        this.DQb.writeFields(paramVarArgs);
      }
      if (this.DQc != null)
      {
        paramVarArgs.kX(3, this.DQc.computeSize());
        this.DQc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.CNq);
      paramVarArgs.aR(5, this.DQd);
      paramVarArgs.aR(6, this.DQe);
      paramVarArgs.e(7, 8, this.DQf);
      paramVarArgs.aR(8, this.CtL);
      AppMethodBeat.o(133183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DQb != null) {
        paramInt = i + f.a.a.a.kW(2, this.DQb.computeSize());
      }
      i = paramInt;
      if (this.DQc != null) {
        i = paramInt + f.a.a.a.kW(3, this.DQc.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(4, this.CNq);
      int j = f.a.a.b.b.a.bA(5, this.DQd);
      int k = f.a.a.b.b.a.bA(6, this.DQe);
      int m = f.a.a.a.c(7, 8, this.DQf);
      int n = f.a.a.b.b.a.bA(8, this.CtL);
      AppMethodBeat.o(133183);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DQf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.DQb == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.DQc == null)
        {
          paramVarArgs = new b("Not all required fields were included: MaxSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133183);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btc localbtc = (btc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133183);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtc.DQb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtc.DQc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 4: 
          localbtc.CNq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133183);
          return 0;
        case 5: 
          localbtc.DQd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133183);
          return 0;
        case 6: 
          localbtc.DQe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133183);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtc.DQf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        }
        localbtc.CtL = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133183);
        return 0;
      }
      AppMethodBeat.o(133183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btc
 * JD-Core Version:    0.7.0.1
 */