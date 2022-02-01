package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aik
  extends cwj
{
  public ain GxW;
  public aih GxX;
  public aii GxY;
  public String GxZ;
  public int Gya;
  public int Gyb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32202);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32202);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GxW != null)
      {
        paramVarArgs.lJ(2, this.GxW.computeSize());
        this.GxW.writeFields(paramVarArgs);
      }
      if (this.GxX != null)
      {
        paramVarArgs.lJ(3, this.GxX.computeSize());
        this.GxX.writeFields(paramVarArgs);
      }
      if (this.GxY != null)
      {
        paramVarArgs.lJ(4, this.GxY.computeSize());
        this.GxY.writeFields(paramVarArgs);
      }
      if (this.GxZ != null) {
        paramVarArgs.d(5, this.GxZ);
      }
      paramVarArgs.aS(6, this.Gya);
      paramVarArgs.aS(7, this.Gyb);
      AppMethodBeat.o(32202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label991;
      }
    }
    label991:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GxW != null) {
        paramInt = i + f.a.a.a.lI(2, this.GxW.computeSize());
      }
      i = paramInt;
      if (this.GxX != null) {
        i = paramInt + f.a.a.a.lI(3, this.GxX.computeSize());
      }
      paramInt = i;
      if (this.GxY != null) {
        paramInt = i + f.a.a.a.lI(4, this.GxY.computeSize());
      }
      i = paramInt;
      if (this.GxZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GxZ);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Gya);
      int j = f.a.a.b.b.a.bz(7, this.Gyb);
      AppMethodBeat.o(32202);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32202);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aik localaik = (aik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32202);
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
            localaik.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ain();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ain)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaik.GxW = ((ain)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aih();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aih)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaik.GxX = ((aih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aii();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aii)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaik.GxY = ((aii)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 5: 
          localaik.GxZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32202);
          return 0;
        case 6: 
          localaik.Gya = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32202);
          return 0;
        }
        localaik.Gyb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32202);
        return 0;
      }
      AppMethodBeat.o(32202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aik
 * JD-Core Version:    0.7.0.1
 */