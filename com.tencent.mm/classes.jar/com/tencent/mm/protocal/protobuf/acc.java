package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acc
  extends erp
{
  public String VJo;
  public String appid;
  public String hRk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123565);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.hRk != null) {
        paramVarArgs.g(3, this.hRk);
      }
      if (this.VJo != null) {
        paramVarArgs.g(4, this.VJo);
      }
      AppMethodBeat.o(123565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.hRk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hRk);
      }
      paramInt = i;
      if (this.VJo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.VJo);
      }
      AppMethodBeat.o(123565);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        acc localacc = (acc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123565);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localacc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(123565);
          return 0;
        case 2: 
          localacc.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123565);
          return 0;
        case 3: 
          localacc.hRk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123565);
          return 0;
        }
        localacc.VJo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(123565);
        return 0;
      }
      AppMethodBeat.o(123565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acc
 * JD-Core Version:    0.7.0.1
 */