package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ecx
  extends esc
{
  public String aalO;
  public String aalP;
  public String abim;
  public String ytw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91607);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91607);
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
      if (this.abim != null) {
        paramVarArgs.g(4, this.abim);
      }
      if (this.ytw != null) {
        paramVarArgs.g(5, this.ytw);
      }
      AppMethodBeat.o(91607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label572;
      }
    }
    label572:
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
      paramInt = i;
      if (this.abim != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abim);
      }
      i = paramInt;
      if (this.ytw != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ytw);
      }
      AppMethodBeat.o(91607);
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
          AppMethodBeat.o(91607);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ecx localecx = (ecx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91607);
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
            localecx.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91607);
          return 0;
        case 2: 
          localecx.aalO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91607);
          return 0;
        case 3: 
          localecx.aalP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91607);
          return 0;
        case 4: 
          localecx.abim = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91607);
          return 0;
        }
        localecx.ytw = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91607);
        return 0;
      }
      AppMethodBeat.o(91607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecx
 * JD-Core Version:    0.7.0.1
 */