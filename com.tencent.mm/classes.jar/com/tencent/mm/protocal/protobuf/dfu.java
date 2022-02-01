package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dfu
  extends ckq
{
  public int EwW;
  public String devicetype;
  public String eKn;
  public String ujZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.devicetype == null)
      {
        paramVarArgs = new b("Not all required fields were included: devicetype");
        AppMethodBeat.o(32477);
        throw paramVarArgs;
      }
      if (this.ujZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: deviceid");
        AppMethodBeat.o(32477);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.devicetype != null) {
        paramVarArgs.d(2, this.devicetype);
      }
      if (this.ujZ != null) {
        paramVarArgs.d(3, this.ujZ);
      }
      if (this.eKn != null) {
        paramVarArgs.d(4, this.eKn);
      }
      paramVarArgs.aR(5, this.EwW);
      AppMethodBeat.o(32477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label645;
      }
    }
    label645:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicetype != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.devicetype);
      }
      i = paramInt;
      if (this.ujZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ujZ);
      }
      paramInt = i;
      if (this.eKn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.eKn);
      }
      i = f.a.a.b.b.a.bA(5, this.EwW);
      AppMethodBeat.o(32477);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.devicetype == null)
        {
          paramVarArgs = new b("Not all required fields were included: devicetype");
          AppMethodBeat.o(32477);
          throw paramVarArgs;
        }
        if (this.ujZ == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfu localdfu = (dfu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32477);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfu.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32477);
          return 0;
        case 2: 
          localdfu.devicetype = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32477);
          return 0;
        case 3: 
          localdfu.ujZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32477);
          return 0;
        case 4: 
          localdfu.eKn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32477);
          return 0;
        }
        localdfu.EwW = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32477);
        return 0;
      }
      AppMethodBeat.o(32477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfu
 * JD-Core Version:    0.7.0.1
 */