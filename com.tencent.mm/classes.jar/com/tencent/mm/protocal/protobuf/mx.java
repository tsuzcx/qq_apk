package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class mx
  extends esc
{
  public String YOa;
  public String YOb;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184127);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(184127);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.session_id != null) {
        paramVarArgs.g(2, this.session_id);
      }
      if (this.YOa != null) {
        paramVarArgs.g(3, this.YOa);
      }
      if (this.YOb != null) {
        paramVarArgs.g(4, this.YOb);
      }
      AppMethodBeat.o(184127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label512;
      }
    }
    label512:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.session_id);
      }
      i = paramInt;
      if (this.YOa != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YOa);
      }
      paramInt = i;
      if (this.YOb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YOb);
      }
      AppMethodBeat.o(184127);
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
          AppMethodBeat.o(184127);
          throw paramVarArgs;
        }
        AppMethodBeat.o(184127);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        mx localmx = (mx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(184127);
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
            localmx.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(184127);
          return 0;
        case 2: 
          localmx.session_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(184127);
          return 0;
        case 3: 
          localmx.YOa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(184127);
          return 0;
        }
        localmx.YOb = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(184127);
        return 0;
      }
      AppMethodBeat.o(184127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mx
 * JD-Core Version:    0.7.0.1
 */