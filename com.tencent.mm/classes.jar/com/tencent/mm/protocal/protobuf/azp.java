package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azp
  extends cvp
{
  public String FAA;
  public String FAB;
  public int FAF;
  public String FAG;
  public String FAH;
  public int FAx;
  public LinkedList<aba> FAy;
  public String FAz;
  public SKBuiltinBuffer_t FzN;
  public String GwM;
  public String ID;
  public int Scene;
  public long nDC;
  public int nEf;
  
  public azp()
  {
    AppMethodBeat.i(32227);
    this.FAy = new LinkedList();
    AppMethodBeat.o(32227);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32228);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.FzN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ID != null) {
        paramVarArgs.d(2, this.ID);
      }
      if (this.FzN != null)
      {
        paramVarArgs.lC(3, this.FzN.computeSize());
        this.FzN.writeFields(paramVarArgs);
      }
      if (this.FAG != null) {
        paramVarArgs.d(4, this.FAG);
      }
      if (this.FAH != null) {
        paramVarArgs.d(5, this.FAH);
      }
      paramVarArgs.aS(6, this.nEf);
      paramVarArgs.aS(7, this.FAx);
      paramVarArgs.e(8, 8, this.FAy);
      if (this.GwM != null) {
        paramVarArgs.d(9, this.GwM);
      }
      if (this.FAz != null) {
        paramVarArgs.d(10, this.FAz);
      }
      if (this.FAA != null) {
        paramVarArgs.d(11, this.FAA);
      }
      paramVarArgs.aS(12, this.FAF);
      paramVarArgs.aS(13, this.Scene);
      paramVarArgs.aY(14, this.nDC);
      if (this.FAB != null) {
        paramVarArgs.d(15, this.FAB);
      }
      AppMethodBeat.o(32228);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1379;
      }
    }
    label1379:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ID);
      }
      i = paramInt;
      if (this.FzN != null) {
        i = paramInt + f.a.a.a.lB(3, this.FzN.computeSize());
      }
      paramInt = i;
      if (this.FAG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FAG);
      }
      i = paramInt;
      if (this.FAH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FAH);
      }
      i = i + f.a.a.b.b.a.bz(6, this.nEf) + f.a.a.b.b.a.bz(7, this.FAx) + f.a.a.a.c(8, 8, this.FAy);
      paramInt = i;
      if (this.GwM != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GwM);
      }
      i = paramInt;
      if (this.FAz != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FAz);
      }
      paramInt = i;
      if (this.FAA != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FAA);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.FAF) + f.a.a.b.b.a.bz(13, this.Scene) + f.a.a.b.b.a.p(14, this.nDC);
      paramInt = i;
      if (this.FAB != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FAB);
      }
      AppMethodBeat.o(32228);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FAy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        if (this.FzN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32228);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azp localazp = (azp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32228);
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
            localazp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 2: 
          localazp.ID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazp.FzN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 4: 
          localazp.FAG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 5: 
          localazp.FAH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 6: 
          localazp.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32228);
          return 0;
        case 7: 
          localazp.FAx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32228);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazp.FAy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 9: 
          localazp.GwM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 10: 
          localazp.FAz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 11: 
          localazp.FAA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 12: 
          localazp.FAF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32228);
          return 0;
        case 13: 
          localazp.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32228);
          return 0;
        case 14: 
          localazp.nDC = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32228);
          return 0;
        }
        localazp.FAB = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32228);
        return 0;
      }
      AppMethodBeat.o(32228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azp
 * JD-Core Version:    0.7.0.1
 */