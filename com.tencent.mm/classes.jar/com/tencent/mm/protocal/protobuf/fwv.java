package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fwv
  extends esc
{
  public String UserName;
  public String aaVR;
  public String abUG;
  public fww abUH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152728);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152728);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.aaVR != null) {
        paramVarArgs.g(3, this.aaVR);
      }
      if (this.abUH != null)
      {
        paramVarArgs.qD(4, this.abUH.computeSize());
        this.abUH.writeFields(paramVarArgs);
      }
      if (this.abUG != null) {
        paramVarArgs.g(5, this.abUG);
      }
      AppMethodBeat.o(152728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label646;
      }
    }
    label646:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.aaVR != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaVR);
      }
      paramInt = i;
      if (this.abUH != null) {
        paramInt = i + i.a.a.a.qC(4, this.abUH.computeSize());
      }
      i = paramInt;
      if (this.abUG != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abUG);
      }
      AppMethodBeat.o(152728);
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
          AppMethodBeat.o(152728);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fwv localfwv = (fwv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152728);
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
            localfwv.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152728);
          return 0;
        case 2: 
          localfwv.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152728);
          return 0;
        case 3: 
          localfwv.aaVR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152728);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fww();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fww)localObject2).parseFrom((byte[])localObject1);
            }
            localfwv.abUH = ((fww)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152728);
          return 0;
        }
        localfwv.abUG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(152728);
        return 0;
      }
      AppMethodBeat.o(152728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fwv
 * JD-Core Version:    0.7.0.1
 */