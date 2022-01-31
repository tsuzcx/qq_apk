package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class akh
  extends bvk
{
  public int koj;
  public String kok;
  public String person_id;
  public String wKp;
  public String xbA;
  public String xby;
  public float xbz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(848);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(848);
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
      if (this.person_id != null) {
        paramVarArgs.e(4, this.person_id);
      }
      if (this.xby != null) {
        paramVarArgs.e(5, this.xby);
      }
      paramVarArgs.q(6, this.xbz);
      if (this.wKp != null) {
        paramVarArgs.e(7, this.wKp);
      }
      if (this.xbA != null) {
        paramVarArgs.e(8, this.xbA);
      }
      AppMethodBeat.o(848);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label771;
      }
    }
    label771:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.person_id != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.person_id);
      }
      paramInt = i;
      if (this.xby != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xby);
      }
      i = paramInt + (e.a.a.b.b.a.eW(6) + 4);
      paramInt = i;
      if (this.wKp != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wKp);
      }
      i = paramInt;
      if (this.xbA != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xbA);
      }
      AppMethodBeat.o(848);
      return i;
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
          AppMethodBeat.o(848);
          throw paramVarArgs;
        }
        AppMethodBeat.o(848);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        akh localakh = (akh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(848);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localakh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(848);
          return 0;
        case 2: 
          localakh.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(848);
          return 0;
        case 3: 
          localakh.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(848);
          return 0;
        case 4: 
          localakh.person_id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(848);
          return 0;
        case 5: 
          localakh.xby = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(848);
          return 0;
        case 6: 
          localakh.xbz = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(848);
          return 0;
        case 7: 
          localakh.wKp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(848);
          return 0;
        }
        localakh.xbA = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(848);
        return 0;
      }
      AppMethodBeat.o(848);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akh
 * JD-Core Version:    0.7.0.1
 */