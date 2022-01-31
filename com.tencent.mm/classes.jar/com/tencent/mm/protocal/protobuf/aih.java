package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aih
  extends bvk
{
  public LinkedList<String> kkX;
  public int kkZ;
  public int kla;
  public int klb;
  
  public aih()
  {
    AppMethodBeat.i(89085);
    this.kkX = new LinkedList();
    AppMethodBeat.o(89085);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89086);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89086);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.kkX);
      paramVarArgs.aO(3, this.kkZ);
      paramVarArgs.aO(4, this.kla);
      paramVarArgs.aO(5, this.klb);
      AppMethodBeat.o(89086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 1, this.kkX);
      int j = e.a.a.b.b.a.bl(3, this.kkZ);
      int k = e.a.a.b.b.a.bl(4, this.kla);
      int m = e.a.a.b.b.a.bl(5, this.klb);
      AppMethodBeat.o(89086);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kkX.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(89086);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89086);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aih localaih = (aih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89086);
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
            localaih.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89086);
          return 0;
        case 2: 
          localaih.kkX.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(89086);
          return 0;
        case 3: 
          localaih.kkZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89086);
          return 0;
        case 4: 
          localaih.kla = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89086);
          return 0;
        }
        localaih.klb = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89086);
        return 0;
      }
      AppMethodBeat.o(89086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aih
 * JD-Core Version:    0.7.0.1
 */