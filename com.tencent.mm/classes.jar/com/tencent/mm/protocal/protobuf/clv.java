package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class clv
  extends esc
{
  public String aatL;
  public String aatM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125733);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125733);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aatL != null) {
        paramVarArgs.g(2, this.aatL);
      }
      if (this.aatM != null) {
        paramVarArgs.g(3, this.aatM);
      }
      AppMethodBeat.o(125733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label452;
      }
    }
    label452:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aatL != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aatL);
      }
      i = paramInt;
      if (this.aatM != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aatM);
      }
      AppMethodBeat.o(125733);
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
          AppMethodBeat.o(125733);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125733);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        clv localclv = (clv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125733);
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
            localclv.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(125733);
          return 0;
        case 2: 
          localclv.aatL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125733);
          return 0;
        }
        localclv.aatM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(125733);
        return 0;
      }
      AppMethodBeat.o(125733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clv
 * JD-Core Version:    0.7.0.1
 */