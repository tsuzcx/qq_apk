package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class brr
  extends bvk
{
  public String lOy;
  public bro xFf;
  public int xFt;
  public int xFu;
  public String xFv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28607);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xFf == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(28607);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28607);
        throw paramVarArgs;
      }
      if (this.xFf != null)
      {
        paramVarArgs.iQ(1, this.xFf.computeSize());
        this.xFf.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xFt);
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(3, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.lOy != null) {
        paramVarArgs.e(4, this.lOy);
      }
      paramVarArgs.aO(5, this.xFu);
      if (this.xFv != null) {
        paramVarArgs.e(6, this.xFv);
      }
      AppMethodBeat.o(28607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xFf == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = e.a.a.a.iP(1, this.xFf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xFt);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + e.a.a.a.iP(3, this.BaseResponse.computeSize());
      }
      i = paramInt;
      if (this.lOy != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.lOy);
      }
      i += e.a.a.b.b.a.bl(5, this.xFu);
      paramInt = i;
      if (this.xFv != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xFv);
      }
      AppMethodBeat.o(28607);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xFf == null)
        {
          paramVarArgs = new b("Not all required fields were included: rcptinfolist");
          AppMethodBeat.o(28607);
          throw paramVarArgs;
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28607);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        brr localbrr = (brr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28607);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bro();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bro)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbrr.xFf = ((bro)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28607);
          return 0;
        case 2: 
          localbrr.xFt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28607);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbrr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28607);
          return 0;
        case 4: 
          localbrr.lOy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28607);
          return 0;
        case 5: 
          localbrr.xFu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28607);
          return 0;
        }
        localbrr.xFv = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28607);
        return 0;
      }
      AppMethodBeat.o(28607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brr
 * JD-Core Version:    0.7.0.1
 */