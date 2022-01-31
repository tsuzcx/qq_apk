package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ble
  extends bvk
{
  public int lGK;
  public String lGL;
  public String npR;
  public String wXQ;
  public String wXR;
  public String xzJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56889);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56889);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wXQ != null) {
        paramVarArgs.e(2, this.wXQ);
      }
      if (this.npR != null) {
        paramVarArgs.e(3, this.npR);
      }
      if (this.wXR != null) {
        paramVarArgs.e(4, this.wXR);
      }
      paramVarArgs.aO(5, this.lGK);
      if (this.lGL != null) {
        paramVarArgs.e(6, this.lGL);
      }
      if (this.xzJ != null) {
        paramVarArgs.e(7, this.xzJ);
      }
      AppMethodBeat.o(56889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wXQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wXQ);
      }
      i = paramInt;
      if (this.npR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npR);
      }
      paramInt = i;
      if (this.wXR != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wXR);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.lGK);
      paramInt = i;
      if (this.lGL != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.lGL);
      }
      i = paramInt;
      if (this.xzJ != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xzJ);
      }
      AppMethodBeat.o(56889);
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
          AppMethodBeat.o(56889);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ble localble = (ble)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56889);
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
            localble.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56889);
          return 0;
        case 2: 
          localble.wXQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56889);
          return 0;
        case 3: 
          localble.npR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56889);
          return 0;
        case 4: 
          localble.wXR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56889);
          return 0;
        case 5: 
          localble.lGK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56889);
          return 0;
        case 6: 
          localble.lGL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56889);
          return 0;
        }
        localble.xzJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56889);
        return 0;
      }
      AppMethodBeat.o(56889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ble
 * JD-Core Version:    0.7.0.1
 */