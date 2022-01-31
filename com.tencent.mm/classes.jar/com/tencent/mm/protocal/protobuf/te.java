package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class te
  extends bvk
{
  public int lGK;
  public String lGL;
  public String token;
  public cla wLF;
  public blm wLd;
  public String wgF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56763);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56763);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.lGK);
      if (this.lGL != null) {
        paramVarArgs.e(3, this.lGL);
      }
      if (this.token != null) {
        paramVarArgs.e(4, this.token);
      }
      if (this.wLd != null)
      {
        paramVarArgs.iQ(5, this.wLd.computeSize());
        this.wLd.writeFields(paramVarArgs);
      }
      if (this.wgF != null) {
        paramVarArgs.e(6, this.wgF);
      }
      if (this.wLF != null)
      {
        paramVarArgs.iQ(7, this.wLF.computeSize());
        this.wLF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56763);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.lGK);
      paramInt = i;
      if (this.lGL != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.lGL);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.token);
      }
      paramInt = i;
      if (this.wLd != null) {
        paramInt = i + e.a.a.a.iP(5, this.wLd.computeSize());
      }
      i = paramInt;
      if (this.wgF != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wgF);
      }
      paramInt = i;
      if (this.wLF != null) {
        paramInt = i + e.a.a.a.iP(7, this.wLF.computeSize());
      }
      AppMethodBeat.o(56763);
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
          AppMethodBeat.o(56763);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56763);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        te localte = (te)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56763);
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
            localte.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56763);
          return 0;
        case 2: 
          localte.lGK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56763);
          return 0;
        case 3: 
          localte.lGL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56763);
          return 0;
        case 4: 
          localte.token = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56763);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localte.wLd = ((blm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56763);
          return 0;
        case 6: 
          localte.wgF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56763);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cla();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cla)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localte.wLF = ((cla)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56763);
        return 0;
      }
      AppMethodBeat.o(56763);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.te
 * JD-Core Version:    0.7.0.1
 */