package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aqa
  extends bvk
{
  public int cnK;
  public String kNv;
  public String omZ;
  public LinkedList<String> xfA;
  public int xfB;
  public LinkedList<aus> xfx;
  public String xfy;
  public int xfz;
  
  public aqa()
  {
    AppMethodBeat.i(56837);
    this.cnK = 0;
    this.kNv = "ok";
    this.xfx = new LinkedList();
    this.xfA = new LinkedList();
    AppMethodBeat.o(56837);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56838);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56838);
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
      paramVarArgs.e(4, 8, this.xfx);
      if (this.xfy != null) {
        paramVarArgs.e(5, this.xfy);
      }
      paramVarArgs.aO(6, this.xfz);
      if (this.omZ != null) {
        paramVarArgs.e(7, this.omZ);
      }
      paramVarArgs.e(8, 1, this.xfA);
      paramVarArgs.aO(9, this.xfB);
      AppMethodBeat.o(56838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt + e.a.a.a.c(4, 8, this.xfx);
      paramInt = i;
      if (this.xfy != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xfy);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xfz);
      paramInt = i;
      if (this.omZ != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.omZ);
      }
      i = e.a.a.a.c(8, 1, this.xfA);
      int j = e.a.a.b.b.a.bl(9, this.xfB);
      AppMethodBeat.o(56838);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xfx.clear();
        this.xfA.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56838);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56838);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aqa localaqa = (aqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56838);
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
            localaqa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56838);
          return 0;
        case 2: 
          localaqa.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56838);
          return 0;
        case 3: 
          localaqa.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56838);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aus();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aus)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaqa.xfx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56838);
          return 0;
        case 5: 
          localaqa.xfy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56838);
          return 0;
        case 6: 
          localaqa.xfz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56838);
          return 0;
        case 7: 
          localaqa.omZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56838);
          return 0;
        case 8: 
          localaqa.xfA.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(56838);
          return 0;
        }
        localaqa.xfB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56838);
        return 0;
      }
      AppMethodBeat.o(56838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqa
 * JD-Core Version:    0.7.0.1
 */