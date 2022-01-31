package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class czn
  extends bvk
{
  public String cqq;
  public String cyc;
  public String url;
  public int version;
  public int xCO;
  public int ygl;
  public int ygm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96323);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96323);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.cqq != null) {
        paramVarArgs.e(3, this.cqq);
      }
      paramVarArgs.aO(4, this.version);
      paramVarArgs.aO(5, this.ygl);
      paramVarArgs.aO(6, this.xCO);
      paramVarArgs.aO(7, this.ygm);
      if (this.cyc != null) {
        paramVarArgs.e(8, this.cyc);
      }
      AppMethodBeat.o(96323);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.cqq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cqq);
      }
      i = i + e.a.a.b.b.a.bl(4, this.version) + e.a.a.b.b.a.bl(5, this.ygl) + e.a.a.b.b.a.bl(6, this.xCO) + e.a.a.b.b.a.bl(7, this.ygm);
      paramInt = i;
      if (this.cyc != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.cyc);
      }
      AppMethodBeat.o(96323);
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
          AppMethodBeat.o(96323);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96323);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        czn localczn = (czn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96323);
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
            localczn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96323);
          return 0;
        case 2: 
          localczn.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96323);
          return 0;
        case 3: 
          localczn.cqq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96323);
          return 0;
        case 4: 
          localczn.version = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96323);
          return 0;
        case 5: 
          localczn.ygl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96323);
          return 0;
        case 6: 
          localczn.xCO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96323);
          return 0;
        case 7: 
          localczn.ygm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96323);
          return 0;
        }
        localczn.cyc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96323);
        return 0;
      }
      AppMethodBeat.o(96323);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czn
 * JD-Core Version:    0.7.0.1
 */