package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class clr
  extends esc
{
  public String aatH;
  public String aatI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32246);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32246);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aatH != null) {
        paramVarArgs.g(2, this.aatH);
      }
      if (this.aatI != null) {
        paramVarArgs.g(3, this.aatI);
      }
      AppMethodBeat.o(32246);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label465;
      }
    }
    label465:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aatH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aatH);
      }
      i = paramInt;
      if (this.aatI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aatI);
      }
      AppMethodBeat.o(32246);
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
          AppMethodBeat.o(32246);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32246);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        clr localclr = (clr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32246);
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
            localclr.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(32246);
          return 0;
        case 2: 
          localclr.aatH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32246);
          return 0;
        }
        localclr.aatI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32246);
        return 0;
      }
      AppMethodBeat.o(32246);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clr
 * JD-Core Version:    0.7.0.1
 */