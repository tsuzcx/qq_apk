package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class x
  extends bvk
{
  public int cnK;
  public String kNv;
  public String wkK;
  public int wkL;
  public int wkM;
  public String wkN;
  public LinkedList<k> wkO;
  public String wkP;
  
  public x()
  {
    AppMethodBeat.i(56693);
    this.cnK = 268513600;
    this.kNv = "请求不成功，请稍候再试";
    this.wkO = new LinkedList();
    AppMethodBeat.o(56693);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56694);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56694);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      paramVarArgs.e(4, 8, this.wkO);
      if (this.wkP != null) {
        paramVarArgs.e(5, this.wkP);
      }
      if (this.wkK != null) {
        paramVarArgs.e(6, this.wkK);
      }
      paramVarArgs.aO(7, this.wkL);
      paramVarArgs.aO(8, this.wkM);
      if (this.wkN != null) {
        paramVarArgs.e(9, this.wkN);
      }
      AppMethodBeat.o(56694);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt + e.a.a.a.c(4, 8, this.wkO);
      paramInt = i;
      if (this.wkP != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wkP);
      }
      i = paramInt;
      if (this.wkK != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wkK);
      }
      i = i + e.a.a.b.b.a.bl(7, this.wkL) + e.a.a.b.b.a.bl(8, this.wkM);
      paramInt = i;
      if (this.wkN != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wkN);
      }
      AppMethodBeat.o(56694);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wkO.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56694);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56694);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56694);
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
            localx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56694);
          return 0;
        case 2: 
          localx.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56694);
          return 0;
        case 3: 
          localx.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56694);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localx.wkO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56694);
          return 0;
        case 5: 
          localx.wkP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56694);
          return 0;
        case 6: 
          localx.wkK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56694);
          return 0;
        case 7: 
          localx.wkL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56694);
          return 0;
        case 8: 
          localx.wkM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56694);
          return 0;
        }
        localx.wkN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56694);
        return 0;
      }
      AppMethodBeat.o(56694);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.x
 * JD-Core Version:    0.7.0.1
 */