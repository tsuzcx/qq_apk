package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cmm
  extends bvk
{
  public int xWl;
  public ft xWm;
  public ar xWn;
  public bfu xWo;
  public gl xWp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58938);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(58938);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xWl);
      if (this.xWm != null)
      {
        paramVarArgs.iQ(3, this.xWm.computeSize());
        this.xWm.writeFields(paramVarArgs);
      }
      if (this.xWn != null)
      {
        paramVarArgs.iQ(4, this.xWn.computeSize());
        this.xWn.writeFields(paramVarArgs);
      }
      if (this.xWo != null)
      {
        paramVarArgs.iQ(5, this.xWo.computeSize());
        this.xWo.writeFields(paramVarArgs);
      }
      if (this.xWp != null)
      {
        paramVarArgs.iQ(6, this.xWp.computeSize());
        this.xWp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xWl);
      paramInt = i;
      if (this.xWm != null) {
        paramInt = i + e.a.a.a.iP(3, this.xWm.computeSize());
      }
      i = paramInt;
      if (this.xWn != null) {
        i = paramInt + e.a.a.a.iP(4, this.xWn.computeSize());
      }
      paramInt = i;
      if (this.xWo != null) {
        paramInt = i + e.a.a.a.iP(5, this.xWo.computeSize());
      }
      i = paramInt;
      if (this.xWp != null) {
        i = paramInt + e.a.a.a.iP(6, this.xWp.computeSize());
      }
      AppMethodBeat.o(58938);
      return i;
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
          AppMethodBeat.o(58938);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58938);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cmm localcmm = (cmm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58938);
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
            localcmm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58938);
          return 0;
        case 2: 
          localcmm.xWl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58938);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ft();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ft)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcmm.xWm = ((ft)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58938);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ar();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ar)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcmm.xWn = ((ar)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58938);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcmm.xWo = ((bfu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58938);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gl();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcmm.xWp = ((gl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58938);
        return 0;
      }
      AppMethodBeat.o(58938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmm
 * JD-Core Version:    0.7.0.1
 */