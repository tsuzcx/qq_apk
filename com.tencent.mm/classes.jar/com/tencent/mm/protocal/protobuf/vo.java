package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class vo
  extends bvk
{
  public String ucg;
  public int version;
  public LinkedList<oi> wOn;
  public int wOo;
  public int wOp;
  
  public vo()
  {
    AppMethodBeat.i(28373);
    this.wOn = new LinkedList();
    AppMethodBeat.o(28373);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28374);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28374);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wOn);
      paramVarArgs.aO(3, this.version);
      paramVarArgs.aO(4, this.wOo);
      paramVarArgs.aO(5, this.wOp);
      if (this.ucg != null) {
        paramVarArgs.e(6, this.ucg);
      }
      AppMethodBeat.o(28374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wOn) + e.a.a.b.b.a.bl(3, this.version) + e.a.a.b.b.a.bl(4, this.wOo) + e.a.a.b.b.a.bl(5, this.wOp);
      paramInt = i;
      if (this.ucg != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.ucg);
      }
      AppMethodBeat.o(28374);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wOn.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28374);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vo localvo = (vo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28374);
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
            localvo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28374);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvo.wOn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28374);
          return 0;
        case 3: 
          localvo.version = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28374);
          return 0;
        case 4: 
          localvo.wOo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28374);
          return 0;
        case 5: 
          localvo.wOp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28374);
          return 0;
        }
        localvo.ucg = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28374);
        return 0;
      }
      AppMethodBeat.o(28374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vo
 * JD-Core Version:    0.7.0.1
 */