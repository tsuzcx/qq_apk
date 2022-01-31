package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bhw
  extends bvk
{
  public int koj;
  public String kok;
  public String wvp;
  public bmu wvq;
  public bje wvr;
  public String xwM;
  public String xwT;
  public awn xwU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48906);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48906);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      if (this.xwM != null) {
        paramVarArgs.e(4, this.xwM);
      }
      if (this.wvp != null) {
        paramVarArgs.e(5, this.wvp);
      }
      if (this.xwT != null) {
        paramVarArgs.e(6, this.xwT);
      }
      if (this.wvq != null)
      {
        paramVarArgs.iQ(7, this.wvq.computeSize());
        this.wvq.writeFields(paramVarArgs);
      }
      if (this.wvr != null)
      {
        paramVarArgs.iQ(8, this.wvr.computeSize());
        this.wvr.writeFields(paramVarArgs);
      }
      if (this.xwU != null)
      {
        paramVarArgs.iQ(9, this.xwU.computeSize());
        this.xwU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.xwM != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xwM);
      }
      paramInt = i;
      if (this.wvp != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wvp);
      }
      i = paramInt;
      if (this.xwT != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xwT);
      }
      paramInt = i;
      if (this.wvq != null) {
        paramInt = i + e.a.a.a.iP(7, this.wvq.computeSize());
      }
      i = paramInt;
      if (this.wvr != null) {
        i = paramInt + e.a.a.a.iP(8, this.wvr.computeSize());
      }
      paramInt = i;
      if (this.xwU != null) {
        paramInt = i + e.a.a.a.iP(9, this.xwU.computeSize());
      }
      AppMethodBeat.o(48906);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(48906);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48906);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bhw localbhw = (bhw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48906);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48906);
          return 0;
        case 2: 
          localbhw.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48906);
          return 0;
        case 3: 
          localbhw.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48906);
          return 0;
        case 4: 
          localbhw.xwM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48906);
          return 0;
        case 5: 
          localbhw.wvp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48906);
          return 0;
        case 6: 
          localbhw.xwT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48906);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhw.wvq = ((bmu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48906);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bje();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bje)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhw.wvr = ((bje)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48906);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbhw.xwU = ((awn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48906);
        return 0;
      }
      AppMethodBeat.o(48906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhw
 * JD-Core Version:    0.7.0.1
 */