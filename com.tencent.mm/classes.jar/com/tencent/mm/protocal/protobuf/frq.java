package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class frq
  extends erp
{
  public String MyW;
  public int abQY;
  public String devicetype;
  public String kDc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32477);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.devicetype == null)
      {
        paramVarArgs = new b("Not all required fields were included: devicetype");
        AppMethodBeat.o(32477);
        throw paramVarArgs;
      }
      if (this.MyW == null)
      {
        paramVarArgs = new b("Not all required fields were included: deviceid");
        AppMethodBeat.o(32477);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.devicetype != null) {
        paramVarArgs.g(2, this.devicetype);
      }
      if (this.MyW != null) {
        paramVarArgs.g(3, this.MyW);
      }
      if (this.kDc != null) {
        paramVarArgs.g(4, this.kDc);
      }
      paramVarArgs.bS(5, this.abQY);
      AppMethodBeat.o(32477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label619;
      }
    }
    label619:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicetype != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.devicetype);
      }
      i = paramInt;
      if (this.MyW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.MyW);
      }
      paramInt = i;
      if (this.kDc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.kDc);
      }
      i = i.a.a.b.b.a.cJ(5, this.abQY);
      AppMethodBeat.o(32477);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.devicetype == null)
        {
          paramVarArgs = new b("Not all required fields were included: devicetype");
          AppMethodBeat.o(32477);
          throw paramVarArgs;
        }
        if (this.MyW == null)
        {
          paramVarArgs = new b("Not all required fields were included: deviceid");
          AppMethodBeat.o(32477);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        frq localfrq = (frq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32477);
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
            localfrq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32477);
          return 0;
        case 2: 
          localfrq.devicetype = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32477);
          return 0;
        case 3: 
          localfrq.MyW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32477);
          return 0;
        case 4: 
          localfrq.kDc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32477);
          return 0;
        }
        localfrq.abQY = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32477);
        return 0;
      }
      AppMethodBeat.o(32477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.frq
 * JD-Core Version:    0.7.0.1
 */