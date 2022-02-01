package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cde
  extends cwj
{
  public int FJF;
  public int GeQ;
  public SKBuiltinBuffer_t HpB;
  public SKBuiltinBuffer_t HpC;
  public int HpD;
  public int HpE;
  public LinkedList<zx> HpF;
  
  public cde()
  {
    AppMethodBeat.i(133182);
    this.HpF = new LinkedList();
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
      if (this.HpB == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.HpC == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HpB != null)
      {
        paramVarArgs.lJ(2, this.HpB.computeSize());
        this.HpB.writeFields(paramVarArgs);
      }
      if (this.HpC != null)
      {
        paramVarArgs.lJ(3, this.HpC.computeSize());
        this.HpC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GeQ);
      paramVarArgs.aS(5, this.HpD);
      paramVarArgs.aS(6, this.HpE);
      paramVarArgs.e(7, 8, this.HpF);
      paramVarArgs.aS(8, this.FJF);
      AppMethodBeat.o(133183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HpB != null) {
        paramInt = i + f.a.a.a.lI(2, this.HpB.computeSize());
      }
      i = paramInt;
      if (this.HpC != null) {
        i = paramInt + f.a.a.a.lI(3, this.HpC.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GeQ);
      int j = f.a.a.b.b.a.bz(5, this.HpD);
      int k = f.a.a.b.b.a.bz(6, this.HpE);
      int m = f.a.a.a.c(7, 8, this.HpF);
      int n = f.a.a.b.b.a.bz(8, this.FJF);
      AppMethodBeat.o(133183);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HpF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.HpB == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.HpC == null)
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
        cde localcde = (cde)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133183);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcde.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcde.HpB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcde.HpC = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 4: 
          localcde.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133183);
          return 0;
        case 5: 
          localcde.HpD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133183);
          return 0;
        case 6: 
          localcde.HpE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133183);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcde.HpF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        }
        localcde.FJF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133183);
        return 0;
      }
      AppMethodBeat.o(133183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cde
 * JD-Core Version:    0.7.0.1
 */