package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class clr
  extends bvk
{
  public int csV;
  public String csW;
  public int version;
  public String xVG;
  public String xVH;
  public cci xVI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80200);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80200);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.csV);
      if (this.csW != null) {
        paramVarArgs.e(3, this.csW);
      }
      if (this.xVG != null) {
        paramVarArgs.e(4, this.xVG);
      }
      if (this.xVH != null) {
        paramVarArgs.e(5, this.xVH);
      }
      if (this.xVI != null)
      {
        paramVarArgs.iQ(6, this.xVI.computeSize());
        this.xVI.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.version);
      AppMethodBeat.o(80200);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.csV);
      paramInt = i;
      if (this.csW != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.csW);
      }
      i = paramInt;
      if (this.xVG != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xVG);
      }
      paramInt = i;
      if (this.xVH != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xVH);
      }
      i = paramInt;
      if (this.xVI != null) {
        i = paramInt + e.a.a.a.iP(6, this.xVI.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(7, this.version);
      AppMethodBeat.o(80200);
      return i + paramInt;
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
          AppMethodBeat.o(80200);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80200);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        clr localclr = (clr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80200);
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
            localclr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80200);
          return 0;
        case 2: 
          localclr.csV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80200);
          return 0;
        case 3: 
          localclr.csW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80200);
          return 0;
        case 4: 
          localclr.xVG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80200);
          return 0;
        case 5: 
          localclr.xVH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80200);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cci();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cci)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localclr.xVI = ((cci)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80200);
          return 0;
        }
        localclr.version = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80200);
        return 0;
      }
      AppMethodBeat.o(80200);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clr
 * JD-Core Version:    0.7.0.1
 */