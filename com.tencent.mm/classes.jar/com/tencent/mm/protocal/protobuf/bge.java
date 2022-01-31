package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bge
  extends bvk
{
  public int fKi;
  public String qun;
  public String quo;
  public LinkedList<clu> xcb;
  public com.tencent.mm.bv.b xuZ;
  public float xvd;
  
  public bge()
  {
    AppMethodBeat.i(81503);
    this.xcb = new LinkedList();
    AppMethodBeat.o(81503);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(81504);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(81504);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.fKi);
      paramVarArgs.e(3, 8, this.xcb);
      if (this.xuZ != null) {
        paramVarArgs.c(4, this.xuZ);
      }
      paramVarArgs.q(5, this.xvd);
      if (this.qun != null) {
        paramVarArgs.e(6, this.qun);
      }
      if (this.quo != null) {
        paramVarArgs.e(7, this.quo);
      }
      AppMethodBeat.o(81504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label769;
      }
    }
    label769:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.fKi) + e.a.a.a.c(3, 8, this.xcb);
      paramInt = i;
      if (this.xuZ != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.xuZ);
      }
      i = paramInt + (e.a.a.b.b.a.eW(5) + 4);
      paramInt = i;
      if (this.qun != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.qun);
      }
      i = paramInt;
      if (this.quo != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.quo);
      }
      AppMethodBeat.o(81504);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xcb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(81504);
          throw paramVarArgs;
        }
        AppMethodBeat.o(81504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bge localbge = (bge)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(81504);
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
            localbge.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(81504);
          return 0;
        case 2: 
          localbge.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(81504);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbge.xcb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(81504);
          return 0;
        case 4: 
          localbge.xuZ = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(81504);
          return 0;
        case 5: 
          localbge.xvd = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(81504);
          return 0;
        case 6: 
          localbge.qun = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(81504);
          return 0;
        }
        localbge.quo = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(81504);
        return 0;
      }
      AppMethodBeat.o(81504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bge
 * JD-Core Version:    0.7.0.1
 */