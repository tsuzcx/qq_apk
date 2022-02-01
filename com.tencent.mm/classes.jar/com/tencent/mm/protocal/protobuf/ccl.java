package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ccl
  extends esc
{
  public String aalO;
  public String aalP;
  public geh aalU;
  public int ytv;
  public String ytw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91474);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91474);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aalO != null) {
        paramVarArgs.g(2, this.aalO);
      }
      if (this.aalP != null) {
        paramVarArgs.g(3, this.aalP);
      }
      paramVarArgs.bS(4, this.ytv);
      if (this.ytw != null) {
        paramVarArgs.g(5, this.ytw);
      }
      if (this.aalU != null)
      {
        paramVarArgs.qD(6, this.aalU.computeSize());
        this.aalU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aalO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aalO);
      }
      i = paramInt;
      if (this.aalP != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aalP);
      }
      i += i.a.a.b.b.a.cJ(4, this.ytv);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ytw);
      }
      i = paramInt;
      if (this.aalU != null) {
        i = paramInt + i.a.a.a.qC(6, this.aalU.computeSize());
      }
      AppMethodBeat.o(91474);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91474);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ccl localccl = (ccl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91474);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localccl.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91474);
          return 0;
        case 2: 
          localccl.aalO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91474);
          return 0;
        case 3: 
          localccl.aalP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91474);
          return 0;
        case 4: 
          localccl.ytv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91474);
          return 0;
        case 5: 
          localccl.ytw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91474);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new geh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((geh)localObject2).parseFrom((byte[])localObject1);
          }
          localccl.aalU = ((geh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91474);
        return 0;
      }
      AppMethodBeat.o(91474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccl
 * JD-Core Version:    0.7.0.1
 */