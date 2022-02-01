package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cqm
  extends esc
{
  public String aawX;
  public String aawY;
  public String aawZ;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259085);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259085);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.aawX != null) {
        paramVarArgs.g(3, this.aawX);
      }
      if (this.aawY != null) {
        paramVarArgs.g(4, this.aawY);
      }
      if (this.aawZ != null) {
        paramVarArgs.g(5, this.aawZ);
      }
      AppMethodBeat.o(259085);
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
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.aawX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aawX);
      }
      paramInt = i;
      if (this.aawY != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aawY);
      }
      i = paramInt;
      if (this.aawZ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aawZ);
      }
      AppMethodBeat.o(259085);
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
          AppMethodBeat.o(259085);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259085);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cqm localcqm = (cqm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259085);
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
            localcqm.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259085);
          return 0;
        case 2: 
          localcqm.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259085);
          return 0;
        case 3: 
          localcqm.aawX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259085);
          return 0;
        case 4: 
          localcqm.aawY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259085);
          return 0;
        }
        localcqm.aawZ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259085);
        return 0;
      }
      AppMethodBeat.o(259085);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqm
 * JD-Core Version:    0.7.0.1
 */