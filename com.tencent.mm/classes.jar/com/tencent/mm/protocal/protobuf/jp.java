package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class jp
  extends bvk
{
  public int woE;
  public auh wvw;
  public aui wvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28344);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28344);
        throw paramVarArgs;
      }
      if (this.wvw == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(28344);
        throw paramVarArgs;
      }
      if (this.wvx == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(28344);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wvw != null)
      {
        paramVarArgs.iQ(2, this.wvw.computeSize());
        this.wvw.writeFields(paramVarArgs);
      }
      if (this.wvx != null)
      {
        paramVarArgs.iQ(3, this.wvx.computeSize());
        this.wvx.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.woE);
      AppMethodBeat.o(28344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label824;
      }
    }
    label824:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wvw != null) {
        paramInt = i + e.a.a.a.iP(2, this.wvw.computeSize());
      }
      i = paramInt;
      if (this.wvx != null) {
        i = paramInt + e.a.a.a.iP(3, this.wvx.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(4, this.woE);
      AppMethodBeat.o(28344);
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
          AppMethodBeat.o(28344);
          throw paramVarArgs;
        }
        if (this.wvw == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(28344);
          throw paramVarArgs;
        }
        if (this.wvx == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
          AppMethodBeat.o(28344);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28344);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        jp localjp = (jp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28344);
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
            localjp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28344);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((auh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjp.wvw = ((auh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28344);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aui();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aui)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjp.wvx = ((aui)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28344);
          return 0;
        }
        localjp.woE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28344);
        return 0;
      }
      AppMethodBeat.o(28344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jp
 * JD-Core Version:    0.7.0.1
 */