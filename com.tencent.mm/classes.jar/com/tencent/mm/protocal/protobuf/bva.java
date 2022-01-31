package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bva
  extends bvk
{
  public int cnK;
  public String kNv;
  public String nLq;
  public String opy;
  public String qgv;
  public String qgw;
  public String wBQ;
  public dc xII;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48956);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48956);
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
      if (this.opy != null) {
        paramVarArgs.e(4, this.opy);
      }
      if (this.wBQ != null) {
        paramVarArgs.e(5, this.wBQ);
      }
      if (this.qgv != null) {
        paramVarArgs.e(6, this.qgv);
      }
      if (this.qgw != null) {
        paramVarArgs.e(7, this.qgw);
      }
      if (this.nLq != null) {
        paramVarArgs.e(8, this.nLq);
      }
      if (this.xII != null)
      {
        paramVarArgs.iQ(9, this.xII.computeSize());
        this.xII.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.opy != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.opy);
      }
      paramInt = i;
      if (this.wBQ != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wBQ);
      }
      i = paramInt;
      if (this.qgv != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.qgv);
      }
      paramInt = i;
      if (this.qgw != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.qgw);
      }
      i = paramInt;
      if (this.nLq != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.nLq);
      }
      paramInt = i;
      if (this.xII != null) {
        paramInt = i + e.a.a.a.iP(9, this.xII.computeSize());
      }
      AppMethodBeat.o(48956);
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
          AppMethodBeat.o(48956);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bva localbva = (bva)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48956);
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
            localbva.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48956);
          return 0;
        case 2: 
          localbva.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48956);
          return 0;
        case 3: 
          localbva.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48956);
          return 0;
        case 4: 
          localbva.opy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48956);
          return 0;
        case 5: 
          localbva.wBQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48956);
          return 0;
        case 6: 
          localbva.qgv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48956);
          return 0;
        case 7: 
          localbva.qgw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48956);
          return 0;
        case 8: 
          localbva.nLq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48956);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbva.xII = ((dc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48956);
        return 0;
      }
      AppMethodBeat.o(48956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bva
 * JD-Core Version:    0.7.0.1
 */