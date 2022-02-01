package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ccj
  extends esc
{
  public String aalO;
  public String aalP;
  public int ytv;
  public String ytw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91472);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91472);
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
      AppMethodBeat.o(91472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label556;
      }
    }
    label556:
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
      AppMethodBeat.o(91472);
      return paramInt;
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
          AppMethodBeat.o(91472);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ccj localccj = (ccj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91472);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localccj.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91472);
          return 0;
        case 2: 
          localccj.aalO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91472);
          return 0;
        case 3: 
          localccj.aalP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91472);
          return 0;
        case 4: 
          localccj.ytv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91472);
          return 0;
        }
        localccj.ytw = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91472);
        return 0;
      }
      AppMethodBeat.o(91472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccj
 * JD-Core Version:    0.7.0.1
 */