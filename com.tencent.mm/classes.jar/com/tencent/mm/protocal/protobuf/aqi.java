package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aqi
  extends bvk
{
  public int jJu;
  public LinkedList<bwc> jJv;
  public String xfI;
  public SKBuiltinBuffer_t xfL;
  public int xfM;
  
  public aqi()
  {
    AppMethodBeat.i(73717);
    this.jJv = new LinkedList();
    AppMethodBeat.o(73717);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73718);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(73718);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jJu);
      paramVarArgs.e(3, 8, this.jJv);
      if (this.xfI != null) {
        paramVarArgs.e(4, this.xfI);
      }
      if (this.xfL != null)
      {
        paramVarArgs.iQ(5, this.xfL.computeSize());
        this.xfL.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.xfM);
      AppMethodBeat.o(73718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jJu) + e.a.a.a.c(3, 8, this.jJv);
      paramInt = i;
      if (this.xfI != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xfI);
      }
      i = paramInt;
      if (this.xfL != null) {
        i = paramInt + e.a.a.a.iP(5, this.xfL.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(6, this.xfM);
      AppMethodBeat.o(73718);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.jJv.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(73718);
          throw paramVarArgs;
        }
        AppMethodBeat.o(73718);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aqi localaqi = (aqi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73718);
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
            localaqi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73718);
          return 0;
        case 2: 
          localaqi.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73718);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaqi.jJv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73718);
          return 0;
        case 4: 
          localaqi.xfI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73718);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaqi.xfL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73718);
          return 0;
        }
        localaqi.xfM = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(73718);
        return 0;
      }
      AppMethodBeat.o(73718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqi
 * JD-Core Version:    0.7.0.1
 */