package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bhu
  extends bvk
{
  public int koj;
  public String kok;
  public String wvo;
  public bmu wvq;
  public String xwM;
  public boolean xwN;
  public boolean xwO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48904);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48904);
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
      if (this.wvo != null) {
        paramVarArgs.e(7, this.wvo);
      }
      if (this.wvq != null)
      {
        paramVarArgs.iQ(8, this.wvq.computeSize());
        this.wvq.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.xwN);
      paramVarArgs.aS(10, this.xwO);
      AppMethodBeat.o(48904);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label838;
      }
    }
    label838:
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
      if (this.wvo != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wvo);
      }
      i = paramInt;
      if (this.wvq != null) {
        i = paramInt + e.a.a.a.iP(8, this.wvq.computeSize());
      }
      paramInt = e.a.a.b.b.a.eW(9);
      int j = e.a.a.b.b.a.eW(10);
      AppMethodBeat.o(48904);
      return i + (paramInt + 1) + (j + 1);
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
          AppMethodBeat.o(48904);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48904);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bhu localbhu = (bhu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(48904);
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
            localbhu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48904);
          return 0;
        case 2: 
          localbhu.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48904);
          return 0;
        case 3: 
          localbhu.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48904);
          return 0;
        case 4: 
          localbhu.xwM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48904);
          return 0;
        case 7: 
          localbhu.wvo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48904);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhu.wvq = ((bmu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48904);
          return 0;
        case 9: 
          localbhu.xwN = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(48904);
          return 0;
        }
        localbhu.xwO = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(48904);
        return 0;
      }
      AppMethodBeat.o(48904);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhu
 * JD-Core Version:    0.7.0.1
 */